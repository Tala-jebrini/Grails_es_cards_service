package orders

import auth.User

class CustomerOrder {

    User user
    Date createdAt = new Date()

    static hasMany = [items: CustomerOrderItem]
    static belongsTo = [user: User]

    static constraints = {
        user nullable: false
    }
}
