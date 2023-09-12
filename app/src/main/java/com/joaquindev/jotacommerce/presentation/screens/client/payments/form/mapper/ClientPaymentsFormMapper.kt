package com.joaquindev.jotacommerce.presentation.screens.client.payments.form.mapper

import com.joaquindev.jotacommerce.domain.model.CardTokenBody
import com.joaquindev.jotacommerce.domain.model.Cardholder
import com.joaquindev.jotacommerce.domain.model.Identification
import com.joaquindev.jotacommerce.presentation.screens.client.payments.form.ClientPaymentsFormState

fun ClientPaymentsFormState.toCardTokenBody(): CardTokenBody {
    return CardTokenBody(
        cardNumber = cardNumber,
        expirationMonth = expirationMonth.toInt(),
        expirationYear = expirationYear,
        securityCode = securityCode,
        cardholder = Cardholder(
            name = name,
            identification = Identification(
                type = type,
                number = number
            )
        )
    )
}