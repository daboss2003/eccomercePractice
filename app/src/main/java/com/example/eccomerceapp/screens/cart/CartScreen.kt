package com.example.eccomerceapp.screens.cart

import androidx.compose.runtime.Composable
import com.example.eccomerceapp.model.Product

@Composable
fun CartScreen(){
    val cartItems:List<Product> = listOf(
        Product("1", "Smartphone",  999.99,  "https://image.pngaaa.com/404/1144404-middle.png" ),
        Product("2", "Laptop", 1499.99,  "https://ng.jumia.is/unsafe/fit-in/680x680/filters:fill(white)/product/05/5140613/1.jpg?0503"),
        Product("3", "Headphone", 123.88, "https://images.pexels.com/photos/1649771/pexels-photo-1649771.jpeg?cs=srgb&dl=pexels-garrettmorrow-1649771.jpg&fm=jpg&_gl=1*1qqkgr3*_ga*ODUzMTcxNDEzLjE3MzY1MTI3MjA.*_ga_8JE65Q40S6*czE3NTA2OTcwODEkbzIkZzAkdDE3NTA2OTcwODEkajYwJGwwJGgw")
    )
}