package cart

import auth.User

class Cart {

    User user

    static hasMany = [items: CartItem]
    static belongsTo = [user: User]

    static constraints = {
        user nullable: false
    }
}
