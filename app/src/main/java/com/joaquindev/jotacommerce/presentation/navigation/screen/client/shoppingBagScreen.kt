package com.joaquindev.jotacommerce.presentation.navigation.screen.client




open class ShoppingBagScreen(val route: String) {
    object ShoppingBag : ShoppingBagScreen("client/shopping_bag")
    object AddressList: ShoppingBagScreen("client/address/list")
    object AddressCreate: ShoppingBagScreen("client/address/create")
    object PaymentsForm: ShoppingBagScreen("client/payments/form")
    object PaymentsInstallments: ShoppingBagScreen("client/payments/installments/{payment_form}") {
        fun passPaymentForm(paymentForm: String) = "client/payments/installments/$paymentForm"
    }



}