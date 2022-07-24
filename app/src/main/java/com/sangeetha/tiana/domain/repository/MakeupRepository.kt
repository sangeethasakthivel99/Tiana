package com.sangeetha.tiana.domain.repository

import com.sangeetha.tiana.data.remote.dto.MakeupProductsDto

interface MakeupRepository {

    suspend fun getAllMakeupProducts(): List<MakeupProductsDto>

    suspend fun getMakeupProductsByBrand(brandName: String): List<MakeupProductsDto>

    suspend fun getMakeupProductByCategory(categoryName: String): List<MakeupProductsDto>
}