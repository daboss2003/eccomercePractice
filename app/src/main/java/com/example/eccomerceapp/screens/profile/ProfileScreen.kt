package com.example.eccomerceapp.screens.profile

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.eccomerceapp.screens.home.BottomNavigationBar

@Composable
fun ProfileScreen(onSignOut: () -> Unit, navController: NavController){
    val currentUser = UserProfile("77", "James Bond", "james.francis.byrnes@example-pet-store.com")

    Scaffold(bottomBar = { BottomNavigationBar(navController) }) {
        innerPadding ->
        Column(modifier = Modifier.fillMaxSize().padding(innerPadding), horizontalAlignment = Alignment.CenterHorizontally) {
            Spacer(modifier = Modifier.height(32.dp))
            Box(modifier = Modifier.size(120.dp).clip(CircleShape).background(MaterialTheme.colorScheme.primaryContainer), contentAlignment = Alignment.Center){
                Icon(Icons.Default.Person, tint = MaterialTheme.colorScheme.primary, contentDescription = "Profile Picture", modifier = Modifier.size(80.dp))
            }

            Spacer(modifier = Modifier.height(24.dp))

            Text(currentUser.name, style = MaterialTheme.typography.headlineMedium, fontWeight = FontWeight.Bold)

            Spacer(modifier = Modifier.height(8.dp))

            Text(currentUser.email, style = MaterialTheme.typography.bodyMedium)

            Spacer(modifier = Modifier.fillMaxWidth())

            Button(
                onClick = onSignOut,
                modifier = Modifier.align(Alignment.CenterHorizontally)
                    .fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(
                    containerColor = MaterialTheme.colorScheme.error,
                    contentColor = MaterialTheme.colorScheme.onErrorContainer)
            ) {
                Text("Sign Out", modifier = Modifier.padding(vertical = 4.dp))
            }
        }
    }

}