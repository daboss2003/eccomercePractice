package com.example.eccomerceapp.screens.navigation

sealed class Screens(val route: String) {
    object Cart: Screens("Cart")
    object ProductDetails: Screens("product_details/{productId}"){
        fun createRoute(productId: String) = "product_details/$productId"
    }
    object Home: Screens("Home")
    object Categories: Screens("Categories")
    object ProductList: Screens("product_list/{categoryId}"){
        fun createRoute(categoryId: Int) = "product_list/$categoryId"
    }
    object Wishlist: Screens("Wishlist")
    object Profile: Screens("Profile")
    object Login: Screens("Login")
    object Signup: Screens("Signup")

}