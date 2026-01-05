package orders

class Payment {
    CustomerOrder order
    BigDecimal amount
    String method     // cash, credit card, paypal...
    String status     // pending, completed, failed
    Date paidAt

    static constraints = {
        order nullable: false
        amount nullable: false, scale: 2
        method nullable: false
        status nullable: false
        paidAt nullable: true
    }
}


