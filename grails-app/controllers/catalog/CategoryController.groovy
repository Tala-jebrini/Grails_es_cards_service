package catalog


class CategoryController {

    def show(Long id) {
        def category = Category.get(id)
        if (!category) {
            render status: 404
            return
        }

        def subCategories = Category.findAllByParent(category)

        [
                category: category,
                subCategories: subCategories
        ]
    }
}

