package orders

import auth.User
import catalog.Product
import groovy.json.JsonOutput
import grails.gorm.transactions.Transactional

@Transactional
class OrderService {

    // Build a preview of a single product order
    Map buildOrderPreview(Product product, int quantity) {
        return [
                productName: product.name,
                quantity   : quantity,
                total      : product.price * quantity
        ]
    }

    // Create a single-product order
    CustomerOrder createSingleOrder(User user, Long productId, int quantity, Map orderInfo) {
        Product product = Product.get(productId)
        if (!product) throw new RuntimeException("Product not found")

        BigDecimal total = product.price * quantity

        def order = new CustomerOrder(
                user: user,
                totalAmount: total,
                orderInfoJson: JsonOutput.toJson(orderInfo)
        )

        // Add item to order
        order.addToItems(
                new CustomerOrderItem(
                        product: product,
                        quantity: quantity,
                        priceAtPurchase: product.price
                )
        )

        order.save(flush: true, failOnError: true)
        return order
    }

    // Create an order from the user's cart
    CustomerOrder createOrderFromCart(User user) {
        def cart = user.cart
        if (!cart?.items) return null

        BigDecimal total = 0
        def orderItemsList = []

        // Prepare order items and calculate total
        cart.items.each { cartItem ->
            total += cartItem.product.price * cartItem.quantity
            orderItemsList << [
                    productId: cartItem.product.id,
                    productName: cartItem.product.name,
                    quantity: cartItem.quantity,
                    priceAtPurchase: cartItem.product.price
            ]
        }

        // Convert order items to JSON
        def orderInfoJson = JsonOutput.toJson(orderItemsList)

        // Create the order
        def order = new CustomerOrder(
                user: user,
                totalAmount: total,
                orderInfoJson: orderInfoJson
        )

        // Add each cart item as a CustomerOrderItem
        cart.items.each { cartItem ->
            order.addToItems(
                    new CustomerOrderItem(
                            product: cartItem.product,
                            quantity: cartItem.quantity,
                            priceAtPurchase: cartItem.product.price
                    )
            )
        }

        order.save(flush: true, failOnError: true)

        // Clear cart
        cart.items*.delete(flush: true)

        return order
    }
}
