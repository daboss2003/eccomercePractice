package com.example.eccomerceapp.screens.product

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil3.compose.rememberAsyncImagePainter
import com.example.eccomerceapp.layout.SetStatusBarColorWithAccompanist
import com.example.eccomerceapp.model.Product

@Composable
fun ProductDetailsScreen(productId: String, navController: NavController) {
    val product = getProductById(productId)
    Scaffold()  {
        Column(modifier = Modifier.padding(it).fillMaxSize()) {
            SetStatusBarColorWithAccompanist()
            if(product != null){
                Column(modifier = Modifier.padding(16.dp).fillMaxSize()){
                    Image(
                        painter = rememberAsyncImagePainter(model = product.imageUrl),
                        contentDescription = "Product Image",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier.fillMaxWidth()
                            .height(300.dp)
                            .clip(RoundedCornerShape(12.dp))
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    Text(
                        product.name,
                        style = MaterialTheme.typography.titleLarge,
                        fontWeight = FontWeight.Bold
                    )

                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        "$${product.price}",
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Bold
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    Text(
                        "Product Description",
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Bold
                    )
                }

                IconButton(
                    onClick = { navController.popBackStack() },
                    modifier = Modifier.padding(16.dp)
                        .background(MaterialTheme.colorScheme.primary, shape = CircleShape)) {
                    Icon(imageVector = Icons.Default.ShoppingCart, contentDescription = "Shopping Cart", tint = Color.White)
                }
            }
            else{
                Text("Product not found!", modifier = Modifier.padding(16.dp))
            }
        }
    }
}

fun getProductById(productId: String): Product {
    return Product("1", "Smartphone",  999.99,  "https://image.pngaaa.com/404/1144404-middle.png" )
}
