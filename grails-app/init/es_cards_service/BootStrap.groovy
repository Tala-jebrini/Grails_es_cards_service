package es_cards_service

import marketing.Banner
import catalog.Category

class BootStrap {

    def init = { servletContext ->

        /* =========================
          BANNERS
       ========================= */

        if (Banner.count() == 0) {
            new Banner(
                    title: "PUBG",
                    imagePath: "banners/banner1.png",
                    active: true
            ).save(failOnError: true)

            new Banner(
                    title: "Roblox",
                    imagePath: "banners/banner2.png",
                    active: true
            ).save(failOnError: true)

            new Banner(
                    title: "iTunes",
                    imagePath: "banners/banner3.png",
                    active: true
            ).save(failOnError: true)

            new Banner(
                    title: "Xbox",
                    imagePath: "banners/banner4.png",
                    active: true
            ).save(failOnError: true)
        }

        /* =========================
           CATEGORIES
        ========================= */

        if (Category.count() == 0) {
            def ludo = new Category(
                    name: "LUDO",
                    iconPath: "categories/ludo.webp"
            ).save(failOnError: true)

            new Category(
                    name: "Diamond",
                    parent: ludo
            ).save(failOnError: true)

            new Category(
                    name: "Gold",
                    parent: ludo
            ).save(failOnError: true)

            new Category(
                    name: "PUBG",
                    iconPath: "categories/pubg.jpg"
            ).save(failOnError: true)

            new Category(
                    name: "XBOX",
                    iconPath: "categories/xbox.png"
            ).save(failOnError: true)
        }
    }

    def destroy = {
    }
}



