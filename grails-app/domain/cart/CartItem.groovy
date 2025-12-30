package cart

import catalog.Product

class CartItem {

    Product product
    Integer quantity

    static belongsTo = [cart: Cart, product: Product]

    static constraints = {
        product nullable: false
        quantity nullable: false, min: 1
    }
}
