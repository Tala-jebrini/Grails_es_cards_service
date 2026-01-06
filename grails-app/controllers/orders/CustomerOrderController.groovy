package orders

import auth.AuthService
import catalog.Product


class CustomerOrderController {

    OrderService orderService
    AuthService authService

    def preview() {
        Product product = Product.get(params.productId)
        int quantity = params.int('quantity') ?: 1

        def preview = orderService.buildOrderPreview(product, quantity)
        boolean canOrder = authService.isLoggedIn(session)

        render preview + [canOrder: canOrder]
    }

    def placeOrder() {

        if (!params.productId) {
            flash.error = "Please select a product"
            redirect(uri: request.getHeader("referer"))
            return
        }

        def orderInfo = [:]

        // dynamically collect order info
        params.each { k, v ->
            if (k.startsWith("order_")) {
                orderInfo[k.replace("order_", "")] = v
            }
        }

        orderService.createOrder(
                session.user,
                params.long("productId"),
                params.int("quantity"),
                orderInfo
        )

        redirect(action: "success")
    }

    def success() {}
}


