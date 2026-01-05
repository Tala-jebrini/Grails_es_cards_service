package orders

import catalog.Product

class OrderService {

    BigDecimal calculateTotal(Product product, int quantity) {
        if (!product || quantity <= 0) {
            return 0
        }
        return product.price * quantity
    }

    boolean canPlaceOrder(def user) {
        return user != null
    }

    Map buildOrderPreview(Product product, int quantity) {
        return [
                productName: product?.name,
                unitPrice : product?.price ?: 0,
                quantity  : quantity,
                total     : calculateTotal(product, quantity)
        ]
    }
}
