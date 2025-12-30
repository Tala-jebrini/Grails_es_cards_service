package orders

import catalog.Product

class CustomerOrderItem {

    Product product
    Integer quantity
    BigDecimal priceAtPurchase

    static belongsTo = [order: CustomerOrder, product: Product]

    static constraints = {
        product nullable: false
        quantity nullable: false, min: 1
        priceAtPurchase nullable: false, scale: 2
    }

    static mapping = {
        priceAtPurchase scale: 2
    }
}
