package com.joaquindev.jotacommerce.data.dataSource.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "products")
data class ProductsEntity(
   @PrimaryKey val id: String = "",
    @ColumnInfo("name")val name: String="",
    @ColumnInfo("description")val description: String="",
    @ColumnInfo("id_category")val idCategory: String ="",
    @ColumnInfo("price")val price: Double =0.0,
    @ColumnInfo("image1")val image1: String = "",
    @ColumnInfo("image2")val image2: String ="",

)
