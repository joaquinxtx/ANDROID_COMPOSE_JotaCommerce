package com.joaquindev.jotacommerce.presentation.screens.client.home

import android.annotation.SuppressLint

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.joaquindev.jotacommerce.presentation.navigation.graph.ClientNavGraph
import com.joaquindev.jotacommerce.presentation.screens.client.home.components.ClientBottomBar

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeClientScreen(navController: NavHostController = rememberNavController( )){
    Scaffold(
        bottomBar = { ClientBottomBar(navController = navController)}
    ) {
           ClientNavGraph(navController = navController)
    }

}