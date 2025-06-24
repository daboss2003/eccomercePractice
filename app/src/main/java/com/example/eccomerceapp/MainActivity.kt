package com.example.eccomerceapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.eccomerceapp.screens.auth.LoginScreen
import com.example.eccomerceapp.screens.auth.SignUpScreen
import com.example.eccomerceapp.screens.cart.CartScreen
import com.example.eccomerceapp.screens.categories.CategoriesScreen
import com.example.eccomerceapp.screens.home.HomeScreen
import com.example.eccomerceapp.screens.navigation.Screens
import com.example.eccomerceapp.screens.product.ProductDetailsScreen
import com.example.eccomerceapp.screens.product.ProductListScreen
import com.example.eccomerceapp.screens.profile.ProfileScreen
import com.example.eccomerceapp.screens.wishlist.WishlistScreen


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navController = rememberNavController()
            NavHost(navController = navController, startDestination = Screens.Home.route){
                composable(Screens.Home.route){
                    HomeScreen(
                        navController = navController,
                        onProfilePressed = {navController.navigate(Screens.Profile.route)},
                        onCartPressed = { navController.navigate(Screens.Cart.route)}
                    )
                }

                composable(Screens.Cart.route){
                    CartScreen(navController = navController)
                }

                composable(Screens.Categories.route){
                    CategoriesScreen(navController = navController)
                }
                composable(Screens.Wishlist.route){
                    WishlistScreen(navController = navController)
                }



                composable(Screens.Profile.route){
                    ProfileScreen(navController = navController, onSignOut = {navController.navigate(Screens.Login.route)})
                }

                composable(Screens.ProductList.route){
                    val categoryId = it.arguments?.getString("categoryId")
                    if(categoryId != null){
                        ProductListScreen(navController = navController, categoryId = categoryId)
                    }
                }

                composable(Screens.ProductDetails.route){
                    val productId = it.arguments?.getString("productId")
                    if(productId != null){
                        ProductDetailsScreen(productId = productId, navController = navController)
                    }
                }

                composable(Screens.Login.route){
                    LoginScreen(onNavigateToSignUp = {navController.navigate(Screens.Signup.route)}, onLoginSuccess = {navController.navigate(Screens.Home.route)})
                }

                composable(Screens.Signup.route){
                    SignUpScreen(onNavigateToLogin = {navController.navigate(Screens.Login.route)}, onSignUpSuccess = {navController.navigate(Screens.Home.route)})
                }

            }
        }
    }
}
