package auth

import cart.Cart
import orders.CustomerOrder

class User {

    String username
    String email
    String password
    Date dateCreated
    Date lastUpdated

    static hasOne = [cart: Cart]
    static hasMany = [orders: CustomerOrder]

    static constraints = {
        username nullable: false, blank: false, unique: true
        email nullable: false, blank: false, unique: true, email: true
        password nullable: false, blank: false
    }
}
