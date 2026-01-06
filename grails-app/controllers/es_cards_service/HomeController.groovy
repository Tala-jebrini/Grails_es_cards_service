package es_cards_service

class HomeController {

    HomeService homeService // injection

    def index() {
        def categories = homeService.getRootCategories()
        def banners = homeService.getActiveBanners()
        [categories: categories, banners: banners]
    }
}
