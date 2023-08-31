package com.joaquindev.jotacommerce.domain.model

import com.google.gson.Gson
import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class OrderHasProducts(
    @SerializedName("id_order") val idOrder: String,
    @SerializedName("id_product") val idProduct: String,
    @SerializedName("quantity") val quantity: Int,
    @SerializedName("product") val product: Product,
): Serializable {

    fun toJson(): String = Gson().toJson(OrderHasProducts(
        idOrder,
        idProduct,
        quantity,
        Product.fromJson(product.toJson())
    ))

    companion object {
        fun fromJson(data: String): OrderHasProducts = Gson().fromJson(data, OrderHasProducts::class.java)
    }

}
