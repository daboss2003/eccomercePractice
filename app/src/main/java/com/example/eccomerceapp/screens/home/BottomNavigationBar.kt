package com.example.eccomerceapp.screens.home

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun BottomNavigationBar(navController: NavController){
    val currentRoute = navController.currentDestination
    val items = listOf(
        BottomNavigationItem(
            title = "Home",
            icon = Icons.Default.Home,
            route = "Home"
        ),
        BottomNavigationItem(
            title = "Categories",
            icon = Icons.Default.Search,
            route = "Categories"
        ),
        BottomNavigationItem(
            title = "Wishlist",
            icon = Icons.Default.Favorite,
            route = "Cart",
            badgeCount = 5
        ),
        BottomNavigationItem(
            title = "Cart",
            icon = Icons.Default.ShoppingCart,
            route = "Cart",
            badgeCount = 3
        ),
        BottomNavigationItem(
            title = "Profile",
            icon = Icons.Default.Person,
            route = "Profile",
        ),
    )

    NavigationBar(
        modifier = Modifier.height(82.dp),
        containerColor = Color.White,
        tonalElevation = 8.dp
    ) {
        items.forEach { item ->
            NavigationBarItem(
                icon = {
                    if (item.badgeCount > 0) {
                        BadgedBox(badge = { Badge { Text(item.badgeCount.toString()) } }) {
                            Icon(
                                imageVector = item.icon,
                                contentDescription = item.title,
                                modifier = Modifier.size(24.dp)
                            )
                        }
                    } else {
                        Icon(
                            imageVector = item.icon,
                            contentDescription = item.title,
                            modifier = Modifier.size(24.dp)
                        )
                    }
                },
                selected = currentRoute.toString() == item.route,
                onClick = { navController.navigate(item.route) },
                enabled = true,
                label = {Text(item.title, style = MaterialTheme.typography.labelSmall, maxLines = 1, overflow = TextOverflow.Ellipsis)},
                alwaysShowLabel = true,
                colors = NavigationBarItemDefaults.colors(),
                interactionSource = remember { MutableInteractionSource() }
            )

        }
    }
}

data class BottomNavigationItem(
    val title: String,
    val icon: ImageVector,
    val route: String,
    val badgeCount: Int= 0
)