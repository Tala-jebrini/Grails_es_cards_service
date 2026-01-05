package marketing

class Offer {

    BigDecimal percentage
    Date startDate
    Date endDate
    Boolean isActive

    static constraints = {
        percentage nullable: true
        startDate nullable: false
        endDate nullable: false
        isActive nullable: false
    }
}
