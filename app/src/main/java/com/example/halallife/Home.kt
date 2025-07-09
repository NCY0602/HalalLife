package com.example.halallife

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun HomeScreen(navController: NavController) {
    Scaffold(
        bottomBar = {
            BottomNavigationBar(navController)
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding) // Ensures content doesn't get hidden behind nav bar
                .background(Color(0xFFE3FFF3))
                .padding(24.dp)
        ) {
            // App Logo and Greeting
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Start,
                modifier = Modifier.fillMaxWidth()
            ) {
                Image(
                    painter = painterResource(id = R.drawable.halal),
                    contentDescription = "App Logo",
                    modifier = Modifier.size(58.dp)
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = "Hello, Name!",
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF00897B)
                )
            }

            Spacer(modifier = Modifier.height(20.dp))

            OutlinedTextField(
                value = "",
                onValueChange = {},
                label = { Text("Search for halal products") },
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.Search,
                        contentDescription = "Search Icon"
                    )
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable { navController.navigate("search") },
                shape = RoundedCornerShape(10.dp)
            )



            Spacer(modifier = Modifier.height(30.dp))

            Text(
                text = "Top Rated Products",
                fontSize = 20.sp,
                fontWeight = FontWeight.SemiBold,
                color = Color.Black
            )

            Spacer(modifier = Modifier.height(10.dp))

            ProductList()

            Spacer(modifier = Modifier.height(30.dp))

            Text(
                text = "Discover Top Restaurants",
                fontSize = 20.sp,
                fontWeight = FontWeight.SemiBold,
                color = Color.Black
            )

            Spacer(modifier = Modifier.height(10.dp))

            RestaurantList()
        }
    }
}


@Composable
fun ProductList() {
    val products = listOf("Product A", "Product B", "Product C")
    Column {
        products.forEach { product ->
            Text(
                text = product,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp)
                    .clickable { /* Handle click for product */ },
                fontSize = 18.sp
            )
        }
    }
}

@Composable
fun RestaurantList() { // Removed navController as it's not used
    val restaurants = listOf("Restaurant A", "Restaurant B")
    Column {
        restaurants.forEach { restaurant ->
            Text(
                text = restaurant,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp)
                    .clickable { /* Handle click for restaurant */ },
                fontSize = 18.sp
            )
        }
    }
}

@Composable
fun BottomNavigationBar(navController: NavController) {
    NavigationBar(
        modifier = Modifier
            .height(68.dp),
        containerColor = Color.White,
        contentColor = Color(0xFF00897B)
    ) {
        val iconSize = 28.dp

        NavigationBarItem(
            icon = {
                Icon(
                    Icons.Default.Home,
                    contentDescription = "Home",
                    modifier = Modifier.size(iconSize)
                )
            },
            selected = false,
            onClick = { navController.navigate("home") }
        )
        NavigationBarItem(
            icon = {
                Icon(
                    Icons.Default.LocationOn,
                    contentDescription = "Location",
                    modifier = Modifier.size(iconSize)
                )
            },
            selected = false,
            onClick = { navController.navigate("location") }
        )
        NavigationBarItem(
            icon = {
                Image(
                    painter = painterResource(id = R.drawable.scan),
                    contentDescription = "Scan",
                    modifier = Modifier.size(iconSize)
                )
            },
            selected = false,
            onClick = { navController.navigate("scan") }
        )
        NavigationBarItem(
            icon = {
                Icon(
                    Icons.Default.Star,
                    contentDescription = "Review",
                    modifier = Modifier.size(iconSize)
                )
            },
            selected = false,
            onClick = { navController.navigate("review") }
        )
        NavigationBarItem(
            icon = {
                Icon(
                    Icons.Default.AccountCircle,
                    contentDescription = "Profile",
                    modifier = Modifier.size(iconSize)
                )
            },
            selected = false,
            onClick = { navController.navigate("profile") }
        )
    }
}

