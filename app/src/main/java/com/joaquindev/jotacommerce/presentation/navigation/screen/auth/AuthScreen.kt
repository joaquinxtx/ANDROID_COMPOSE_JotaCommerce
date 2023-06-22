package com.joaquindev.jotacommerce.presentation.navigation.screen.auth


open class AuthScreen(val route:String){
object Login : AuthScreen("login")
object Register : AuthScreen("register")
}
