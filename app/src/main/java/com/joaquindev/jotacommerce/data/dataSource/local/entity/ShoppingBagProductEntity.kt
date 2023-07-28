package com.joaquindev.jotacommerce.data.dataSource.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "shopping_bag")
data class ShoppingBagProductEntity(
   @PrimaryKey val id: String = "",
    @ColumnInfo("name")val name: String="",
    @ColumnInfo("id_category")val idCategory: String ="",
    @ColumnInfo("image1")val image1: String = "",
    @ColumnInfo("price")val price: Double =0.0,
    @ColumnInfo("quantity")val quantity: Int = 0,


)
