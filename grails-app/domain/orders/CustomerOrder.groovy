package orders

import auth.User

class CustomerOrder {

    Date createdAt = new Date()
    String orderInfoJson
    BigDecimal totalAmount


    static mappedBy = [items: "order"]
    static hasMany = [items: CustomerOrderItem]
    static belongsTo = [user: User]

    static constraints = {
        user nullable: true // guest
        orderInfoJson nullable: true
    }
    static mapping = {
        orderInfoJson type: 'text'
    }
}


