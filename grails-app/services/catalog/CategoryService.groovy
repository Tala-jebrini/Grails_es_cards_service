package catalog

import grails.gorm.transactions.Transactional

@Transactional
class CategoryService {

        List<Category> getSubcategories(Category category) {
            return Category.findAllByParent(category)
        }


        List<Product> getProductsForCategory(Category category) {
            def subCategories = getSubcategories(category)
            if (subCategories) {
                return [] // list in subcategories not here
            } else {
                return Product.findAllByCategory(category)
            }
        }
    }

