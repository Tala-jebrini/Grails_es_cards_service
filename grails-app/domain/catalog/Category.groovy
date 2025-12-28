package catalog

class Category {

    String name
    String iconPath
    Category parent

    static hasMany = [children: Category]

    static constraints = {
        parent nullable: true
        iconPath nullable: true
        name nullable: false
    }
}
