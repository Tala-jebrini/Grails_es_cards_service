package catalog

class CategoryController {

    def show(Long id) {
        def category = Category.get(id)
        if (!category) {
            render status: 404
            return
        }

        def subCategories = Category.findAllByParent(category)
        def products = []

        if (!subCategories) {
            // No subcategories → show products of this category
            products = Product.findAllByCategory(category)
        }

        [
                category: category,
                subCategories: subCategories,
                products: products,
                parent: category.parent
        ]
    }

}

