package es_cards_service

class HomeController {

    HomeService homeService // injection تلقائي

    def index() {
        def categories = homeService.getRootCategories()
        def banners = homeService.getActiveBanners()
        [categories: categories, banners: banners]
    }
}
