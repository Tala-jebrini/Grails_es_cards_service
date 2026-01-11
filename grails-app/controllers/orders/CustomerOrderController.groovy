package orders

import auth.AuthService
import catalog.Product
import grails.converters.JSON
import org.hibernate.FetchMode

class CustomerOrderController {

    OrderService orderService
    AuthService authService

    // Preview single product order
    def preview() {
        Product product = Product.get(params.long('productId'))
        int quantity = params.int('quantity') ?: 1

        if (!product) {
            render(status: 404, text: "Product not found")
            return
        }

        def preview = orderService.buildOrderPreview(product, quantity)
        boolean canOrder = authService.isLoggedIn(session)

        render preview + [canOrder: canOrder] as JSON
    }

    // Place single product order
    def placeOrder() {
        if (!params.productId) {
            flash.error = "Please select a product"
            redirect(uri: request.getHeader("referer"))
            return
        }

        // Build order info map
        def orderInfo = [:]
        params.each { k, v ->
            if (k.startsWith("order_")) {
                orderInfo[k.replace("order_", "")] = v
            }
        }

        def order = orderService.createSingleOrder(
                session.user,
                params.long("productId"),
                params.int("quantity"),
                orderInfo
        )

        flash.message = "Order placed successfully! Order ID: ${order.id}"
        redirect(action: "success", id: order.id)
    }

    // Checkout all items in cart
    def checkoutFromCart() {
        def user = session.user
        if (!user) {
            redirect(controller: "auth", action: "login")
            return
        }

        def order = orderService.createOrderFromCart(user)
        if (!order) {
            flash.error = "Cart is empty"
            redirect(controller: "cart", action: "show")
            return
        }

        flash.message = "Cart checkout successful! Order ID: ${order.id}"
        redirect(action: "success", id: order.id)
    }

    // Success page
    def success() {
        def order = CustomerOrder.get(params.id)
        if (!order) redirect(uri: "/")
        [order: order]
    }

    def history() {
        def user = session.user

        def orders = CustomerOrder.createCriteria().list {
            eq("user", user)
            order("createdAt", "desc")
            fetchMode("items", FetchMode.JOIN)
            fetchMode("items.product", FetchMode.JOIN)
        }

        [orders: orders]
    }

}
