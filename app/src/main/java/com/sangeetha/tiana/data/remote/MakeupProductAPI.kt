package com.sangeetha.tiana.data.remote

import com.sangeetha.tiana.data.remote.dto.MakeupProductsDto
import retrofit2.http.GET
import retrofit2.http.Query

interface MakeupProductAPI {

    @GET("v1/products.json")
    suspend fun getAllMakeupProducts(): List<MakeupProductsDto>

    @GET("v1/products.json")
    suspend fun getMakeupProductByBrand(@Query("brand") brandName: String): List<MakeupProductsDto>

    @GET("v1/products.json")
    suspend fun getMakeupProductByCategory(@Query("product_type") categoryName: String): List<MakeupProductsDto>
}