package com.joaquindev.jotacommerce.presentation.screens.client.payments.form

data class ClientPaymentsFormState(
    val cardNumber:String = "",
    val expirationYear:String = "",
    val expirationMonth:String = "",
    val securityCode:String = "",
    val name:String = "",
    val type:String = "",
    val number:String = "",

)