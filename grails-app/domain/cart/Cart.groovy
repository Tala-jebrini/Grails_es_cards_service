package cart

import auth.User

class Cart {
    User user
    static hasMany = [items: CartItem]
}
