package es_cards_service

import catalog.Category
import marketing.Banner

class HomeService {


    List<Category> getRootCategories() {
        return Category.findAllByParentIsNull()
    }

    List<Banner> getActiveBanners() {
        return Banner.findAllByActive(true)
    }

}
