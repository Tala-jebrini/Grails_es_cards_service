package catalog

class CategoryOption {

    String optionKey            // Json key
    String label          // For user display
    String placeholder
    String type           // String, Integer,...

    Boolean required = false


    static belongsTo = [category: Category]

    static constraints = {
        category nullable: false
        placeholder nullable: true
        optionKey nullable: false
        label nullable: false
        type nullable: false
        required nullable: false
    }
}
