package com.example.eccomerceapp.screens.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.eccomerceapp.layout.BottomNavigationBar
import com.example.eccomerceapp.model.Category
import com.example.eccomerceapp.model.Product
import com.example.eccomerceapp.layout.SetStatusBarColorWithAccompanist
import com.example.eccomerceapp.screens.navigation.Screens


@Composable
fun HomeScreen(navController: NavController, onProfilePressed: () -> Unit, onCartPressed: () -> Unit){
    Scaffold(
        topBar = {MyTopAppBar(onProfilePressed = onProfilePressed, onCartPressed = onCartPressed)},
        bottomBar = { BottomNavigationBar(navController) }
    ) { innerPadding ->
        SetStatusBarColorWithAccompanist(false)
        Column(modifier = Modifier.fillMaxSize().padding(innerPadding)) {
            val searchQuery = remember { mutableStateOf("") }
            val focusManger = LocalFocusManager.current

            MySearchBar(
                query = searchQuery.value,
                onQueryChange = {searchQuery.value = it},
                onSearch = {},
                modifier = Modifier.fillMaxWidth().padding(16.dp)
            )

            SectionTitle("Categories", "See All", onActionPressed = {navController.navigate(Screens.Categories.route)})
            val categories: List<Category> =  listOf(
                Category(1, "Electronics", "https://i.pinimgproxy.com/?url=aHR0cHM6Ly9jZG4taWNvbnMtcG5nLmZsYXRpY29uLmNvbS8yNTYvOTAwLzkwMDYxOC5wbmc=&ts=1750759672&sig=fb558197091fa1462e00c7adbb1fdd3407f23ecee6a6e275a79367cae7d2b695"),
                Category(2, "Clothing", "https://cdn-icons-png.flaticon.com/512/2935/2935183.png"),
            )
            val selectedCategory = remember { mutableIntStateOf(1) }

            LazyRow(
                contentPadding = PaddingValues(horizontal = 16.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                items(categories.size){
                    CategoryChip(
                        icon = categories[it].iconUrl,
                        text = categories[it].name,
                        isSelected = selectedCategory.intValue == categories[it].id,
                        onPress = {selectedCategory.intValue = categories[it].id}
                    )
                }
            }
            Spacer(modifier = Modifier.height(16.dp))
            SectionTitle("Featured", "See All", onActionPressed = {navController.navigate(Screens.Product.route)})
            val productList: List<Product> = listOf(
                Product("1", "Smartphone",  999.99,  "https://image.pngaaa.com/404/1144404-middle.png" ),
                Product("2", "Laptop", 1499.99, imageUrl = "https://ng.jumia.is/unsafe/fit-in/680x680/filters:fill(white)/product/05/5140613/1.jpg?0503"),
                Product("3", "Headphone", 123.88, "https://images.pexels.com/photos/1649771/pexels-photo-1649771.jpeg?cs=srgb&dl=pexels-garrettmorrow-1649771.jpg&fm=jpg&_gl=1*1qqkgr3*_ga*ODUzMTcxNDEzLjE3MzY1MTI3MjA.*_ga_8JE65Q40S6*czE3NTA2OTcwODEkbzIkZzAkdDE3NTA2OTcwODEkajYwJGwwJGgw"),
            )

            LazyRow(
                contentPadding = PaddingValues(horizontal = 16.dp),
                horizontalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                items(productList){
                    FeatureProductCard(it) { }
                }
            }
        }
    }
}