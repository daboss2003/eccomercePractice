package com.example.eccomerceapp.screens.product

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.eccomerceapp.layout.BottomNavigationBar

@Composable
fun ProfileScreen(navController: NavController, categoryId: Int) {

    Scaffold(bottomBar = { BottomNavigationBar(navController) })  {
        Column(modifier = Modifier.padding(it).fillMaxSize()) {
            Text("Product Category ID: $categoryId")
        }
    }
}