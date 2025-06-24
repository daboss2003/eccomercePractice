package com.example.eccomerceapp.screens.product

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.eccomerceapp.layout.BottomNavigationBar
import com.example.eccomerceapp.layout.SetStatusBarColorWithAccompanist
import com.example.eccomerceapp.model.Product
import com.example.eccomerceapp.screens.navigation.Screens

@Composable
fun ProfileScreen(navController: NavController, categoryId: Int) {
    val products: List<Product> = listOf(
        Product("1", "Smartphone",  999.99,  "https://image.pngaaa.com/404/1144404-middle.png" ),
        Product("2", "TV", 99.99, "https://media.istockphoto.com/id/1395191574/photo/black-led-tv-television-screen-blank-isolated.webp?s=1024x1024&w=is&k=20&c=iY0K5s0SnVIeL02PRNHtFG-uB6dRAd_Qo3rUvvK6p_g=")
    )

    Scaffold(bottomBar = { BottomNavigationBar(navController) })  {
        Column(modifier = Modifier.padding(it).fillMaxSize()) {
            SetStatusBarColorWithAccompanist()
            Text(
                "Product Category ID: $categoryId",
                style = MaterialTheme.typography.titleLarge,
                modifier = Modifier.padding(16.dp)
            )

            if(products.isEmpty()){
                Text("No products found!", modifier = Modifier.padding(16.dp))
            }
            else{
                LazyColumn(modifier = Modifier.fillMaxSize(), contentPadding = PaddingValues(8.dp)) {
                    itemsIndexed(products){_, product ->
                        ProductItem(product, onPress = {navController.navigate(Screens.ProductDetails.createRoute(product.id))}, onAddToCart = {})
                    }
                }
            }
        }
    }
}