package com.joaquindev.jotacommerce.presentation.screens.admin.home

import android.annotation.SuppressLint
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.joaquindev.jotacommerce.presentation.navigation.graph.AdminNavGraph
import com.joaquindev.jotacommerce.presentation.screens.admin.home.components.AdminBottomBar

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeAdminScreen(navController: NavHostController = rememberNavController()) {
    Scaffold(
        bottomBar = { AdminBottomBar(navController = navController)}
    ) {
        AdminNavGraph(navController = navController)

    }

}