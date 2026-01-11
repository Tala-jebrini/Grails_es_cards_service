package cart

import auth.User
import grails.gorm.transactions.Transactional

class CartController {

    CartService cartService

    @Transactional
    def show() {
        User user = session.user
        if (!user) {
            redirect(controller: "auth", action: "login")
            return
        }

        def cart = cartService.getCart(user)
        def total = cartService.getTotal(user)

        [cart: cart, total: total]
    }

    def add() {
        User user = session.user
        if (!user) {
            redirect(controller: "auth", action: "login")
            return
        }

        cartService.addToCart(user, params.long("productId"), params.int("quantity") ?: 1)
        redirect(controller: "cart", action: "show")
    }

    def remove(Long id) {
        cartService.removeItem(session.user, id)
        redirect(action: "show")
    }
}


