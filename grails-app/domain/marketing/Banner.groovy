package marketing

class Banner {
    String title
    String imagePath
    Boolean active = true

    static constraints = {
        title blank: false
        imagePath nullable: true
    }
}

