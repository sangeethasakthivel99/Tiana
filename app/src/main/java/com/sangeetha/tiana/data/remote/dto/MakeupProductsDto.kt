package com.sangeetha.tiana.data.remote.dto

import com.google.gson.annotations.SerializedName
import com.sangeetha.tiana.domain.model.MakeupProduct
import com.sangeetha.tiana.domain.model.ProductColor

data class MakeupProductsDto(
    val id: Int?,
    val brand: String?,
    val name: String?,
    val price: String?,
    @SerializedName("price_sign")
    val price_sign: String?,
    val currency: String?,
    @SerializedName("image_link")
    val image_link: String?,
    @SerializedName("product_link")
    val product_link: String?,
    @SerializedName("website_link")
    val website_link: String?,
    val description: String?,
    val rating: Double?,
    val category: String?,
    @SerializedName("product_type")
    val product_type: String?,
    @SerializedName("tag_list")
    val tag_list: List<String?>?,
    @SerializedName("created_at")
    val created_at: String?,
    @SerializedName("updated_at")
    val updated_at: String?,
    @SerializedName("product_api_url")
    val product_api_url: String?,
    @SerializedName("api_featured_image")
    val api_featured_image: String?,
    @SerializedName("product_colors")
    val product_colors: List<ProductColorDto?>?
)

data class ProductColorDto(
    @SerializedName("hex_value")
    val hex_value: String?,
    @SerializedName("colour_name")
    val colour_name: String?
)

fun MakeupProductsDto.toMakeupProduct(): MakeupProduct {
    return MakeupProduct(
        id = this.id,
        brand = this.brand,
        name = this.name,
        price = this.price,
        description = this.description,
        imageLink = this.image_link,
        rating = this.rating,
        category = this.category,
        product_colors = this.product_colors?.toProductColor()
    )
}

fun List<ProductColorDto?>.toProductColor(): List<ProductColor> {
    return this.map {
        ProductColor(
            hexValue = it?.hex_value,
            colourName = it?.colour_name
        )
    }
}