package com.example.pizzaapp3.util

import com.example.pizzaapp3.R
import com.example.pizzaapp3.model.PromotionPizza

object PromotionPizzaMock {
    val PromotionPizzaList: ArrayList<PromotionPizza> = arrayListOf(
        PromotionPizza(
            1,
            "20% OFF for everyone with a student card",
            R.mipmap.img_promotion_pizza_background,
            "$20.80",
            "$25.99",
            "Until May 27th, 2022"),
        PromotionPizza(
            2,
            "20% OFF for everyone with a student card",
            R.mipmap.img_promotion_pizza_background,
            "$20.80",
            "$25.99",
            "Until May 27th, 2022"),
        PromotionPizza(
            3,
            "20% OFF for everyone with a student card",
            R.mipmap.img_promotion_pizza_background,
            "$20.80",
            "$25.99",
            "Until May 27th, 2022"),
    )
}