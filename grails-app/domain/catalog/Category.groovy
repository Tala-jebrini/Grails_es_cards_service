package catalog

class Category {

    String name
    String iconPath
    Category parent
    String description

    static hasMany = [children: Category]

    static constraints = {
        parent nullable: true
        iconPath nullable: true
        name nullable: false
        description nullable: false
    }
}
