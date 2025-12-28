package es_cards_service

import marketing.Banner
import catalog.Category

class HomeController {

    def index() {
        def categories = Category.list()
        def banners = Banner.findAllByActive(true)
        //def offers = SpecialOffer.list()
        [categories: categories, banners: banners]//, offers: offers]
    }
}
