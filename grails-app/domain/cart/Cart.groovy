package cart

import auth.User

class Cart {

    static hasMany = [items: CartItem]
    static belongsTo = [user: User]

    static constraints = {
        user nullable: false
        items nullable: true
    }
}
