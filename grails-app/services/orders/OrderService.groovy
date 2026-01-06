package orders

import auth.User
import catalog.Product
import groovy.json.JsonOutput
import grails.gorm.transactions.Transactional

@Transactional
class OrderService {

    // Build a preview of the order

    Map buildOrderPreview(Product product, int quantity) {
        return [
                productName: product.name,
                quantity   : quantity,
                total      : product.price * quantity
        ]
    }

    //Create an order

    CustomerOrder createOrder(User user, Long productId, int quantity, Map orderInfo) {
        Product product = Product.get(productId)
        if (!product) throw new RuntimeException("Product not found")

        // Create the order
        def order = new CustomerOrder(
                user: user,
                orderInfoJson: JsonOutput.toJson(orderInfo)
        ).save(failOnError: true)

        // Add items to the order
        new CustomerOrderItem(
                order: order,
                product: product,
                quantity: quantity,
                priceAtPurchase: product.price
        ).save(failOnError: true)

        return order
    }
}
