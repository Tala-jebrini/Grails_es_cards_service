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
}
