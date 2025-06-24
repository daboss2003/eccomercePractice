package com.example.eccomerceapp.screens.navigation

sealed class Screens(val route: String) {
    object Cart: Screens("Cart")
    object ProductDetails: Screens("product_details/{productId}"){
        fun createRoute(productId: String) = "product_details/$productId"
    }
    object Home: Screens("Home")
    object Categories: Screens("Categories")
    object Product: Screens("Product")
    object Wishlist: Screens("Wishlist")
    object Profile: Screens("Profile")

}