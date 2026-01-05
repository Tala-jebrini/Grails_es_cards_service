package catalog

//class CategoryController {
//
//    def orderService
//
//    def show(Long id) {
//        Category category = Category.get(id)
//        if (!category) {
//            flash.message = "Category not found"
//            redirect(uri: "/")
//            return
//        }
//
//        // Fetch subcategories using service
//        def subCategories = orderService.getSubcategories(category)
//        def products = orderService.getProductsForCategory(category)
//
//        [category: category, subCategories: subCategories, products: products]
//    }
//}


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

