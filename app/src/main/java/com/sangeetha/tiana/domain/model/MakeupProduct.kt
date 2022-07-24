package com.sangeetha.tiana.domain.model

data class MakeupProduct(
    val id: Int?,
    val brand: String?,
    val name: String?,
    val price: String?,
    val description: String?,
    val imageLink: String?,
    val rating: Double?,
    val category: String?,
    val product_colors: List<ProductColor?>?
)

data class ProductColor(
    val hexValue: String?,
    val colourName: String?
)