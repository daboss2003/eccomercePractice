package com.example.eccomerceapp.screens.wishlist

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.eccomerceapp.layout.BottomNavigationBar

@Composable
fun WishlistScreen(navController: NavController){
    Scaffold(bottomBar = { BottomNavigationBar(navController) }) {
        Column(modifier = Modifier.padding(it), verticalArrangement = Arrangement.Center){
            Text("Wishlist", modifier = Modifier.fillMaxSize().padding(horizontal = 16.dp))
        }
    }
}