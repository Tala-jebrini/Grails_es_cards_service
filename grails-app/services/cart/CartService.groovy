package cart

import auth.User
import catalog.Product
import grails.gorm.transactions.Transactional

@Transactional
class CartService {

    Cart getCart(User user) {
        Cart cart = Cart.findByUser(user)

        if (!cart) {
            cart = new Cart(user: user)
            cart.save(flush: true)
        }

        // Force Hibernate to load items
        cart.items?.size()

        return cart
    }


    void addToCart(User user, Long productId, Integer qty) {
        def cart = getCart(user)
        def product = Product.get(productId)

        def item = CartItem.findByCartAndProduct(cart, product)

        if (item) {
            item.quantity += qty
        } else {
            cart.addToItems(new CartItem(product: product, quantity: qty))
        }

        cart.save(flush: true)
    }

    void removeItem(User user, Long itemId) {
        def cart = getCart(user)
        def item = CartItem.get(itemId)

        if (item?.cart?.id == cart.id) {
            item.delete(flush: true)
        }
    }

    BigDecimal getTotal(User user) {
        Cart cart = getCart(user)

        BigDecimal total = 0
        cart.items.each {
            total += it.product.price * it.quantity
        }

        return total
    }


    void clearCart(User user) {
        getCart(user).items*.delete(flush: true)
    }
}
