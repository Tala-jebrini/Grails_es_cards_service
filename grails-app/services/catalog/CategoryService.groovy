package catalog

import grails.gorm.transactions.Transactional
@Transactional
class CategoryService {

    List<Category> getSubcategories(Category category) {
        Category.findAllByParent(category)
    }

    List<Product> getProductsForCategory(Category category) {
        def subCategories = getSubcategories(category)
        subCategories ? [] : Product.findAllByCategory(category)
    }

    def getOrderOptions(Category category) {
        CategoryOption.findAllByCategory(category)
    }
}
