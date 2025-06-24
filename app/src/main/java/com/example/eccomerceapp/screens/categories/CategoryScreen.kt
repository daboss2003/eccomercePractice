package com.example.eccomerceapp.screens.categories

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.eccomerceapp.model.Category
import com.example.eccomerceapp.layout.BottomNavigationBar
import com.example.eccomerceapp.layout.SetStatusBarColorWithAccompanist

@Composable
fun CategoriesScreen(navController: NavController){
    val categories: List<Category> = listOf(
        Category(1, "Electronics", "https://i.pinimgproxy.com/?url=aHR0cHM6Ly9jZG4taWNvbnMtcG5nLmZsYXRpY29uLmNvbS8yNTYvOTAwLzkwMDYxOC5wbmc=&ts=1750759672&sig=fb558197091fa1462e00c7adbb1fdd3407f23ecee6a6e275a79367cae7d2b695"),
        Category(2, "Clothing", "https://cdn-icons-png.flaticon.com/512/2935/2935183.png"),
    )
    Scaffold(bottomBar = { BottomNavigationBar(navController) }) {
        innerPadding ->
        Column(modifier = Modifier.padding(innerPadding)){
            SetStatusBarColorWithAccompanist(false)
            if(categories.isEmpty()){
                Box(modifier = Modifier.fillMaxSize().padding(16.dp), contentAlignment = Alignment.Center){
                    Text("No Categories found!", style = MaterialTheme.typography.bodyLarge)
                }
            }
            else{
                Text(
                    "Categories",
                    style = MaterialTheme.typography.titleLarge,
                    modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)
                )

                LazyVerticalGrid(
                    columns = GridCells.Fixed(3),
                    contentPadding = PaddingValues(8.dp),
                    verticalArrangement = Arrangement.spacedBy(12.dp),
                    horizontalArrangement = Arrangement.spacedBy(12.dp),
                    modifier = Modifier.fillMaxWidth().padding(horizontal = 8.dp)
                ) {
                    itemsIndexed(categories){ _, category ->
                        CategoryItem(category, onCategorySelected = {})
                    }
                }
            }
        }
    }
}