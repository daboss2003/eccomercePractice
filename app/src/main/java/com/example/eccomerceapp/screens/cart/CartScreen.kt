package com.example.eccomerceapp.screens.cart

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.eccomerceapp.model.Product
import com.example.eccomerceapp.screens.home.BottomNavigationBar

@Composable
fun CartScreen(navController: NavController){
    val cartItems:List<Product> = listOf(
        Product("1", "Smartphone",  999.99,  "https://image.pngaaa.com/404/1144404-middle.png" ),
        Product("2", "Laptop", 1499.99,  "https://ng.jumia.is/unsafe/fit-in/680x680/filters:fill(white)/product/05/5140613/1.jpg?0503"),
        Product("3", "Headphone", 123.88, "https://images.pexels.com/photos/1649771/pexels-photo-1649771.jpeg?cs=srgb&dl=pexels-garrettmorrow-1649771.jpg&fm=jpg&_gl=1*1qqkgr3*_ga*ODUzMTcxNDEzLjE3MzY1MTI3MjA.*_ga_8JE65Q40S6*czE3NTA2OTcwODEkbzIkZzAkdDE3NTA2OTcwODEkajYwJGwwJGgw"),
    )

    Scaffold(bottomBar = { BottomNavigationBar(navController) }) {
        innerPadding ->
        Column(modifier = Modifier.fillMaxSize().padding(innerPadding)) {
            Text(
                "Your Cart",
                style = MaterialTheme.typography.headlineMedium,
                modifier = Modifier.padding(bottom = 16.dp)
            )
            if(cartItems.isEmpty()){
                Column(modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
                    Text("Your cart is empty", style = MaterialTheme.typography.bodyLarge)
                    Spacer(modifier = Modifier.height(16.dp))
                    Button(onClick = {}, ) {
                        Text("Continue Shopping")
                    }
                }
            }
            else{
                LazyColumn(modifier = Modifier.weight(1f)){
                    items(cartItems.size){
                        CartItemCard(cartItems[it], onRemove = {})
                    }
                }

                Column(modifier = Modifier.fillMaxWidth().padding(16.dp)) {
                    Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                        Text("Total", style = MaterialTheme.typography.titleMedium)
                        Text("$${cartItems.sumOf { it.price }}", style = MaterialTheme.typography.bodyLarge)
                    }
                }

                Spacer(modifier = Modifier.height(16.dp))

                Button(onClick = {}, modifier = Modifier.fillMaxWidth().height(50.dp)) {
                    Text("Checkout")
                }
            }
        }
    }


}