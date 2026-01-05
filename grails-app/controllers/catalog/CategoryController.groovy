package catalog

class CategoryController {

    CategoryService categoryService

    def show(Long id) {
        def category = Category.get(id)
        if (!category) {
            render status: 404
            return
        }

        def subCategories = categoryService.getSubcategories(category)
        def products = categoryService.getProductsForCategory(category)
        def orderOptions = categoryService.getOrderOptions(
                category.parent ?: category
        )

        [
                category     : category,
                subCategories: subCategories,
                products     : products,
                orderOptions : orderOptions
        ]
    }
}
