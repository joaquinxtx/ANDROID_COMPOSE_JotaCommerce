package com.joaquindev.jotacommerce.presentation.screens.admin.category.list.components


import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color

import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController

import com.joaquindev.jotacommerce.domain.model.Category

import com.joaquindev.jotacommerce.presentation.screens.admin.category.list.AdminCategoryListViewModel


@Composable
fun AdminCategoryListContent(
    navController: NavHostController,
    categories: List<Category>,
    paddingValues: PaddingValues,
    vm:AdminCategoryListViewModel = hiltViewModel()
) {

    var searchText by remember { mutableStateOf("") }
    var isSearchTextEmpty by remember { mutableStateOf(true) }

    Column(
        Modifier
            .fillMaxWidth()
            .padding(paddingValues)
    ) {

        Column(Modifier.padding(20.dp)) {
            Text(
                text = "!Hola ${vm.user?.name}¡",
                fontSize = 27.sp,
                fontWeight = FontWeight.SemiBold
            )
            Text(
                text = "que categoria quieres modificar o agregar?",
                fontSize = 20.sp,
                fontWeight = FontWeight.Normal,
                color = Color.Gray
            )

        }
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(16.dp))
                .padding(horizontal = 30.dp),
            colors = CardDefaults.cardColors(containerColor = Color.LightGray)

        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {

                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = "Search",
                    modifier = Modifier.size(24.dp)
                )


                BasicTextField(
                    value = searchText,
                    onValueChange = {
                        searchText = it
                        isSearchTextEmpty = it.isEmpty()
                    },

                    keyboardActions = KeyboardActions(
                        onSearch = {

                        }
                    ),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 8.dp, end = 8.dp)
                )


                if (!isSearchTextEmpty) {
                    IconButton(
                        onClick = {
                            searchText = ""
                            isSearchTextEmpty = true
                        },
                        modifier = Modifier.size(24.dp)
                    ) {
                        Icon(
                            imageVector = Icons.Default.Clear,
                            contentDescription = "Clear",
                            modifier = Modifier.size(24.dp)
                        )
                    }
                }
            }
        }

            LazyColumn(
                modifier = Modifier
                    .padding(paddingValues)
                    .fillMaxSize()
            ) {
                items(
                    items = categories
                ) {
                    AdminCategoryListItem(category = it, navController = navController)
                }
            }
        }

    }

