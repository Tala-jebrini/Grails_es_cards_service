package catalog

class ProductOption {
    Product product
    String key            // Json key
    String label          // For user display
    String type           // String, Integer,...

    static belongsTo = [product: Product]

    static constraints = {
        key nullable: false
        label nullable: false
        type nullable: false
    }
}
