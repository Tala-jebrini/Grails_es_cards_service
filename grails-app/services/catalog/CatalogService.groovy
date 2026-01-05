package catalog

class CatalogService {

    Map getCategoryViewData(Category category) {

        def subCategories = Category.findAllByParent(category)
        def products = []

        if (!subCategories) {
            products = Product.findAllByCategory(category)
        }

        return [
                category     : category,
                subCategories: subCategories,
                products     : products,
                parent       : category.parent
        ]
    }
}
