package catalog

class Category {

    String name
    String iconPath
    Category parent
    String title
    String description

    static belongsTo = [parent: Category]


    static constraints = {
        parent nullable: true
        iconPath nullable: true
        name nullable: false
        title nullable: false
        description nullable: true
    }
    static mapping = {
        description type: 'text'   // <-- allows long descriptions
    }
}
