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
                    name: "Yalla Ludo",
                    iconPath: "categories/ludo.webp",
                    description:"Direct Top-up for Yalla Ludo"
            ).save(failOnError: true)

            new Category(
                    name: "Diamond",
                    parent: ludo,
                    description:"Direct Diamond Top-up for Yalla Ludo"
            ).save(failOnError: true)

            new Category(
                    name: "Gold",
                    parent: ludo,
                    description:"Direct Gold Top-up for Yalla Ludo"
            ).save(failOnError: true)

            new Category(
                    name: "PUBG",
                    iconPath: "categories/pubg.jpg",
                    description: "PUBG UC is in-game currency used to buy premium items like skins, outfits, and weapon upgrades in PUBG Mobile.\n"

            ).save(failOnError: true)

            new Category(
                    name: "XBOX",
                    iconPath: "categories/xbox.png",
                    description:"Game Pass Ultimate is a Microsoft subscription offering 400-500 games across Xbox, PC, and cloud, plus online multiplayer and exclusive perks. It includes Xbox Game Pass, PC Game Pass, Xbox Game pass Core and EA Play."
            ).save(failOnError: true)
        }
    }

    def destroy = {
    }
}



