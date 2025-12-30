package catalog

class Product {

    String name
    BigDecimal price

    static belongsTo = [category: Category]

    static constraints = {
        name nullable: false
        price nullable: false, scale: 2
        category nullable: false
    }

    static mapping = {
        price scale: 2
    }
}
