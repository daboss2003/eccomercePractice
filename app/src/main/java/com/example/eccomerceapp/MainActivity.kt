package com.example.eccomerceapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.eccomerceapp.screens.cart.CartScreen
import com.example.eccomerceapp.screens.categories.CategoriesScreen
import com.example.eccomerceapp.screens.home.HomeScreen
import com.example.eccomerceapp.screens.navigation.Screens
import com.example.eccomerceapp.screens.profile.ProfileScreen
import com.example.eccomerceapp.screens.wishlist.WishlistScreen
import com.example.eccomerceapp.ui.theme.EccomerceAppTheme

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
                    ProfileScreen(navController = navController, onSignOut = {})
                }

                composable(Screens.Product.route){
                    ProfileScreen(navController = navController, onSignOut = {})
                }

            }
        }
    }
}
