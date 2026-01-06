package orders

import auth.AuthService
import catalog.Product
import grails.converters.JSON

class CustomerOrderController {

    OrderService orderService
    AuthService authService

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

    def placeOrder() {
        if (!params.productId) {
            flash.error = "Please select a product"
            redirect(uri: request.getHeader("referer"))
            return
        }

        def orderInfo = [:]
        params.each { k, v ->
            if (k.startsWith("order_")) {
                orderInfo[k.replace("order_", "")] = v
            }
        }

        def order = orderService.createOrder(
                session.user,
                params.long("productId"),
                params.int("quantity"),
                orderInfo
        )

        flash.message = "Order placed successfully! Order ID: ${order.id}"
        redirect(action: "success", id: order.id)
    }

    def success() {
        def order = CustomerOrder.get(params.id)
        if (!order) redirect(uri: "/")
        [order: order]
    }
}
