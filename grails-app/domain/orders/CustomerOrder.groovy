package orders

import auth.User

class CustomerOrder {

    User user
    Date createdAt

    static hasMany = [items: CustomerOrderItem]
    static constraints = {
    }
}
