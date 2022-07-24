package com.sangeetha.tiana.data.repository

import com.sangeetha.tiana.data.remote.MakeupProductAPI
import com.sangeetha.tiana.data.remote.dto.MakeupProductsDto
import com.sangeetha.tiana.domain.repository.MakeupRepository
import javax.inject.Inject

class MakeupRepositoryImpl @Inject constructor(private val api: MakeupProductAPI): MakeupRepository {
    override suspend fun getAllMakeupProducts(): List<MakeupProductsDto> {
        return api.getAllMakeupProducts()
    }

    override suspend fun getMakeupProductsByBrand(brandName: String): List<MakeupProductsDto> {
        return api.getMakeupProductByBrand(brandName)
    }

    override suspend fun getMakeupProductByCategory(categoryName: String): List<MakeupProductsDto> {
        return api.getMakeupProductByCategory(categoryName)
    }
}