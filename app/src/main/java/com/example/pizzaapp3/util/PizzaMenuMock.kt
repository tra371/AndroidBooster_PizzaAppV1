package com.example.pizzaapp3.util

import android.text.Html
import com.example.pizzaapp3.model.PizzaMenu

object PizzaMenuMock {
    val crusts:Array<String> = arrayOf("Pan", "Cheesy", "Crispy Thin", "Sausage Stuffed")
    private val availableCrusts = "Available crusts:<br />\n"+ crusts.joinToString(separator=""){it -> "        &#8226; ${it}<br />\n"}
    val PizzaMenuList: ArrayList<PizzaMenu> = arrayListOf(
        PizzaMenu(
            1,
            "4 Cheeses",
            "Ingredients: Oregano, Mozzarella, Parmesan, Gorgonzola Cheese",
            Html.fromHtml(availableCrusts).toString(),
            PizzaURL.pizzaUrls.random(),
            "$8.50"
        ),
        PizzaMenu(
            2,
            "Hawaiian",
            "Ingredients: Chicken, Bacon, Pineapple",
            Html.fromHtml(availableCrusts).toString(),
            PizzaURL.pizzaUrls.random(),
            "$11.50"
        ),
        PizzaMenu(
            3,
            "Chicken Mushroom",
            "Ingredients: Chicken, Mushroom, Olive, Tomato",
            Html.fromHtml(availableCrusts).toString(),
            PizzaURL.pizzaUrls.random(),
            "$9.00"
        ),
        PizzaMenu(
            4,
            "Cheese Overload",
            "Ingredients: Mozzarella, Olive, Tomato",
            Html.fromHtml(availableCrusts).toString(),
            PizzaURL.pizzaUrls.random(),
            "$10.35"
        ),
        PizzaMenu(
            5,
            "Calzone",
            "Ingredients: Tomato Sauce, Pepperoni, Olive, Ham",
            Html.fromHtml(availableCrusts).toString(),
            PizzaURL.pizzaUrls.random(),
            "$13.25"
        ),
        PizzaMenu(
            6,
            "Margherita",
            "Ingredients: Tomato sauce, mozzarella, and oregano",
            Html.fromHtml(availableCrusts).toString(),
            PizzaURL.pizzaUrls.random(),
            "$8.85"
        ),
        PizzaMenu(
            7,
            "Frutti di Mare",
            "Ingredients: Tomato sauce and seafood",
            Html.fromHtml(availableCrusts).toString(),
            PizzaURL.pizzaUrls.random(),
            "$8.85"
        ),
        PizzaMenu(
            8,
            "Marinara",
            "Ingredients: Tomato sauce, garlic and basil",
            Html.fromHtml(availableCrusts).toString(),
            PizzaURL.pizzaUrls.random(),
            "$10.00"
        ),
        PizzaMenu(
            9,
            "Quattro Stagioni",
            "Ingredients: Tomato sauce, mozzarella, mushrooms, ham, artichokes, olives, and oregano",
            Html.fromHtml(availableCrusts).toString(),
            PizzaURL.pizzaUrls.random(),
            "$13.50"
        ),
        PizzaMenu(
            10,
            "Carbonara",
            "Ingredients: Tomato sauce, mozzarella, parmesan, eggs, and bacon",
            Html.fromHtml(availableCrusts).toString(),
            PizzaURL.pizzaUrls.random(),
            "$15.75"
        ),
        PizzaMenu(
            11,
            "Quattro Formaggi",
            "Ingredients: Tomato sauce, mozzarella, parmesan, gorgonzola cheese, artichokes, and oregano",
            Html.fromHtml(availableCrusts).toString(),
            PizzaURL.pizzaUrls.random(),
            "$11.50"
        ),
        PizzaMenu(
            12,
            "Crudo",
            "Ingredients: Tomato sauce, mozzarella and Parma ham",
            Html.fromHtml(availableCrusts).toString(),
            PizzaURL.pizzaUrls.random(),
            "$10.00"
        ),
        PizzaMenu(
            13,
            "Napoletana",
            "Ingredients: Tomato sauce, mozzarella, oregano, anchovies",
            Html.fromHtml(availableCrusts).toString(),
            PizzaURL.pizzaUrls.random(),
            "$8.75"
        ),
        PizzaMenu(
            14,
            "Pugliese",
            "Ingredients: Tomato sauce, mozzarella, oregano, and onions",
            Html.fromHtml(availableCrusts).toString(),
            PizzaURL.pizzaUrls.random(),
            "$8.25"
        ),
        PizzaMenu(
            15,
            "Montanara",
            "Ingredients: Tomato sauce, mozzarella, mushrooms, pepperoni, and Stracchino (soft cheese)",
            Html.fromHtml(availableCrusts).toString(),
            PizzaURL.pizzaUrls.random(),
            "$14.75"
        ),
        PizzaMenu(
            16,
            "Emiliana",
            "Ingredients: Tomato sauce, mozzarella, eggplant, boiled potatoes, and sausage",
            Html.fromHtml(availableCrusts).toString(),
            PizzaURL.pizzaUrls.random(),
            "$12.50"
        ),
        PizzaMenu(
            17,
            "Romana",
            "Ingredients: Tomato sauce, mozzarella, anchovies, capers, and oregano",
            Html.fromHtml(availableCrusts).toString(),
            PizzaURL.pizzaUrls.random(),
            "$10.00"
        ),
        PizzaMenu(
            18,
            "Fattoria",
            "Ingredients: Tomato sauce, mozzarella, peppers, peas, porchetta (Italian spit-roasted pork)",
            Html.fromHtml(availableCrusts).toString(),
            PizzaURL.pizzaUrls.random(),
            "$17.00"
        ),
    )
}