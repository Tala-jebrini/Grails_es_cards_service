package orders

import catalog.Product
import auth.User
import groovy.json.JsonOutput
import grails.gorm.transactions.Transactional

@Transactional
class OrderService {

    CustomerOrder createOrder(
            User user,
            Long productId,
            Integer quantity,
            Map orderInfo
    ) {

        Product product = Product.get(productId)
        if (!product) {
            throw new IllegalArgumentException("Product not found")
        }

        if (quantity <= 0) {
            throw new IllegalArgumentException("Invalid quantity")
        }

        BigDecimal total = product.price * quantity

        def order = new CustomerOrder(
                user: user,
                status: "NEW",
                totalAmount: total,
                orderInfoJson: JsonOutput.toJson(orderInfo) // JSON
        )

        order.save(failOnError: true)

        def item = new CustomerOrderItem(
                order: order,
                product: product,
                quantity: quantity,
                unitPrice: product.price
        )

        item.save(failOnError: true)

        return order
    }
}

//class OrderService {
//
//    BigDecimal calculateTotal(Product product, int quantity) {
//        if (!product || quantity <= 0) {
//            return 0
//        }
//        return product.price * quantity
//    }
//
//    boolean canPlaceOrder(def user) {
//        return user != null
//    }
//
//    Map buildOrderPreview(Product product, int quantity) {
//        return [
//                productName: product?.name,
//                unitPrice : product?.price ?: 0,
//                quantity  : quantity,
//                total     : calculateTotal(product, quantity)
//        ]
//    }
//}