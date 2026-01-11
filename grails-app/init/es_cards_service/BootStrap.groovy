package es_cards_service

import auth.User
import cart.Cart
import catalog.CategoryOption
import catalog.Product
import marketing.Banner
import catalog.Category

class BootStrap {

//    def init = { servletContext ->
//
//
//        // =========================
//        // USERS
//        // =========================
//        if (User.count() == 0) {
//            // Tala
//            def talaCart = new Cart(items: [])  // create cart first
//            def tala = new User(
//                    username: "Tala",
//                    email: "tala@tala.com",
//                    password: "123456",
//                    cart: talaCart           // assign cart immediately
//            ).save(failOnError: true)
//
//            // Jane
//            def janeCart = new Cart(items: [])
//            def jane = new User(
//                    username: "Jane",
//                    email: "jane@example.com",
//                    password: "abcdef",
//                    cart: janeCart
//            ).save(failOnError: true)
//        }
//
//
//
//
//        /* =========================
//          BANNERS
//       ========================= */
//
//        if (Banner.count() == 0) {
//            new Banner(
//                    title: "PUBG",
//                    imagePath: "banners/banner1.png",
//                    active: true
//            ).save(failOnError: true)
//
//            new Banner(
//                    title: "Roblox",
//                    imagePath: "banners/banner2.png",
//                    active: true
//            ).save(failOnError: true)
//
//            new Banner(
//                    title: "iTunes",
//                    imagePath: "banners/banner3.png",
//                    active: true
//            ).save(failOnError: true)
//
//            new Banner(
//                    title: "Xbox",
//                    imagePath: "banners/banner4.png",
//                    active: true
//            ).save(failOnError: true)
//        }
//
//        /* =========================
//           CATEGORIES
//        ========================= */
//
//        if (Category.count() == 0) {
//            def ludo = new Category(
//                    name: "Yalla Ludo",
//                    iconPath: "categories/ludo.webp",
//                    subDescription:"Direct Top-up for Yalla Ludo"
//            ).save(failOnError: true)
//
//            new Category(
//                    name: "Diamond",
//                    parent: ludo,
//                    subDescription:"Direct Diamond Top-up for Yalla Ludo",
//                    description:"Yalla Ludo Diamond Top-Up\n" +
//                            "This is a direct top-up service for Diamonds in your Yalla Ludo account.\n" +
//                            "The top-up process takes approximately 5 to 20 minutes to be completed and activated on your account.\n" +
//                            "Please enter your Player ID carefully, ensuring there are no mistakes, as Diamonds may be credited to the wrong account if the ID is entered incorrectly."
//            ).save(failOnError: true)
//
//            new Category(
//                    name: "Gold",
//                    parent: ludo,
//                    subDescription:"Direct Gold Top-up for Yalla Ludo",
//                    description: "Yalla Ludo Gold Top-Up\n" +
//                            "This is a direct top-up service for Gold in your Yalla Ludo account.\n" +
//                            "The top-up process takes approximately 5 to 20 minutes to be completed and activated on your account.\n" +
//                            "Please enter your Player ID carefully, ensuring there are no mistakes, as Gold may be credited to the wrong account if the ID is entered incorrectly."
//            ).save(failOnError: true)
//
//            new Category(
//                    name: "PUBG",
//                    iconPath: "categories/pubg.webp",
//                    subDescription: "PUBG UC is in-game currency used to buy premium items like skins, outfits, and weapon upgrades in PUBG Mobile.\n",
//                    description: "1- Select the Unknown Cash UC Amount you want to Purchase.\n" +
//                            "2- Enter your PUBG Mobile Player ID.\n" +
//                            "3- Click Validate to make sure that the ID matches your Player name.\n" +
//                            "4- Click order now and make your purchase.\n" +
//                            "\n" +
//                            "You will receive your Pubg UC within 5-15 minutes from purchasing."
//
//            ).save(failOnError: true)
//
//            new Category(
//                    name: "XBOX",
//                    iconPath: "categories/xbox.png",
//                    subDescription:"Game Pass Ultimate is a Microsoft subscription offering 400-500 games across Xbox, PC, and cloud, plus online multiplayer and exclusive perks. It includes Xbox Game Pass, PC Game Pass, Xbox Game pass Core and EA Play.",
//                    description:"You can only Request a new account for this Product.\n" +
//                            "\n" +
//                            "Game Pass Ultimate is a Microsoft subscription offering 400-500 games across Xbox, PC, and cloud, plus online multiplayer and exclusive perks. It includes Xbox Game Pass, PC Game Pass, Xbox Game pass Core and EA Play.\n" +
//                            "\n" +
//                            "View all the games by visiting this link: https://tinyurl.com/GPUltimate\n" +
//                            "\n" +
//                            "Charging delivery is within 60 minute."
//            ).save(failOnError: true)
//        }
//
//        /* =========================
//          PRODUCTS
//       ========================= */
//
//        if (Product.count() == 0) {
//
//            // Get the Yalla Ludo subcategories
//            def diamond = Category.findByName("Diamond")
//            def gold = Category.findByName("Gold")
//
//            new Product(
//                    name: "Yalla Ludo (2320) Diamond",
//                    price: 5.99,
//                    category: diamond
//            ).save(failOnError: true)
//
//            new Product(
//                    name: "Yalla Ludo (5,150) Diamond",
//                    price: 24.99,
//                    category: diamond
//            ).save(failOnError: true)
//
//            new Product(
//                    name: "Yalla Ludo (223,700) Gold",
//                    price: 4.99,
//                    category: gold
//            ).save(failOnError: true)
//
//            new Product(
//                    name: "Yalla Ludo (1,463,320) Gold",
//                    price: 14.99,
//                    category: gold
//            ).save(failOnError: true)
//
//            // For main category PUBG
//            def pubg = Category.findByName("PUBG")
//
//            new Product(
//                    name: "Pubg 60 UC",
//                    price: 0.99,
//                    category: pubg
//            ).save(failOnError: true)
//
//            new Product(
//                    name: "Pubg 325 UC",
//                    price: 9.99,
//                    category: pubg
//            ).save(failOnError: true)
//
//            // For main category PUBG
//            def xbox = Category.findByName("XBOX")
//
//            new Product(
//                    name: "Game pass ultimate 1 months (new user only)",
//                    price: 9.99,
//                    category: xbox
//            ).save(failOnError: true)
//            new Product(
//                    name: "Game pass ultimate 3 months (new user only)",
//                    price: 9.99,
//                    category: xbox
//            ).save(failOnError: true)
//            new Product(
//                    name: "Game pass ultimate 6 months (new user only)",
//                    price: 9.99,
//                    category: xbox
//            ).save(failOnError: true)
//        }
//
//        def pubg = Category.findByName("PUBG")
//
//        new CategoryOption(
//                category: pubg,
//                optionKey: "gameId",
//                label: "PUBG Mobile Global ID",
//                type: "text",
//                placeholder: "Enter Player ID",
//                required: true
//        ).save(failOnError: true)
//
//        new CategoryOption(
//                category: pubg,
//                optionKey: "username",
//                label: "Username",
//                type: "text",
//                placeholder: "Enter Username",
//                required: true
//        ).save(failOnError: true)
//
//        def ludo = Category.findByName("Yalla Ludo")
//
//        new CategoryOption(
//                category: ludo,
//                optionKey: "playerId",
//                label: "Player ID",
//                type: "text",
//                placeholder: "Please Enter Player ID",
//                required: true
//        ).save(failOnError: true)
//
//        def xbox = Category.findByName("XBOX")
//
//        new CategoryOption(
//                category: xbox,
//                optionKey: "notes",
//                label: "Notes",
//                type: "text",
//                placeholder: "If you have any notes, please write them here",
//                required: false
//        ).save(failOnError: true)
//
//
//
//    }
//
//    def destroy = {
//    }
}



