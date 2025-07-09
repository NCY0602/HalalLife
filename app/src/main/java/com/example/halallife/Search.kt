package com.example.halallife

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.material.icons.automirrored.filled.ArrowBack


// SearchScreen composable
@Composable
fun SearchScreen(navController: NavController) {
    var searchQuery by remember { mutableStateOf("") }
    var selectedCategory by remember { mutableStateOf("") }
    var selectedBrand by remember { mutableStateOf("") }
    var selectedCertificationBody by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFE3FFF3))
            .padding(24.dp)
    ) {
        // Back Button (for navigation)
        IconButton(onClick = { navController.popBackStack() }) {
            Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back")
        }

        // App Logo
        Image(
            painter = painterResource(id = R.drawable.halal),
            contentDescription = "App Logo",
            modifier = Modifier.size(60.dp).align(Alignment.CenterHorizontally)
        )

        Spacer(modifier = Modifier.height(20.dp))

        // Search Bar with search icon
        OutlinedTextField(
            value = searchQuery,
            onValueChange = { searchQuery = it },
            label = { Text("Search for halal products") },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Search,  // Search icon from Material Icons
                    contentDescription = "Search Icon"
                )
            },
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(10.dp)
        )

        Spacer(modifier = Modifier.height(30.dp))

        // Filters
        Text(
            text = "Filter by",
            fontSize = 20.sp,
            fontWeight = FontWeight.SemiBold,
            color = Color.Black
        )

        Spacer(modifier = Modifier.height(10.dp))

        // Dropdown for Categories
        DropdownMenuExample(label = "Categories", selectedItem = selectedCategory, onItemSelected = { selectedCategory = it })

        Spacer(modifier = Modifier.height(10.dp))

        // Dropdown for Brands
        DropdownMenuExample(label = "Brands", selectedItem = selectedBrand, onItemSelected = { selectedBrand = it })

        Spacer(modifier = Modifier.height(10.dp))

        // Certification Bodies Checkbox
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            Checkbox(
                checked = selectedCertificationBody,
                onCheckedChange = { selectedCertificationBody = it }
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = "Department of Islamic Development Malaysia (JAKIM)",
                fontSize = 16.sp,
                modifier = Modifier.weight(1f)
            )
        }

        Spacer(modifier = Modifier.height(20.dp))

        // Clear and Apply Buttons
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Button(
                onClick = { /* Clear filters logic */ },
                modifier = Modifier.weight(1f)
            ) {
                Text("Clear All")
            }

            Spacer(modifier = Modifier.width(8.dp))

            Button(
                onClick = { /* Apply filters logic */ },
                modifier = Modifier.weight(1f)
            ) {
                Text("Apply")
            }
        }
    }
}

@Composable
fun DropdownMenuExample(label: String, selectedItem: String, onItemSelected: (String) -> Unit) {
    var expanded by remember { mutableStateOf(false) }
    Box(
        modifier = Modifier.fillMaxWidth().clickable(
            interactionSource = remember { MutableInteractionSource() },
            indication = null,
            onClick = { expanded = !expanded }
        )

    ) {
        OutlinedTextField(
            value = selectedItem,
            onValueChange = {},
            label = { Text(label) },
            trailingIcon = {
                Icon(
                    imageVector = Icons.Default.ArrowDropDown,
                    contentDescription = "Drop Down Icon"
                )
            },
            modifier = Modifier.fillMaxWidth(),
            readOnly = true,
            shape = RoundedCornerShape(10.dp)
        )
        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false }
        ) {
            listOf("Option 1", "Option 2", "Option 3").forEach { option ->
                DropdownMenuItem(
                    text = { Text(option) },
                    onClick = {
                        onItemSelected(option)
                        expanded = false
                    }
                )
            }
        }
    }
}
