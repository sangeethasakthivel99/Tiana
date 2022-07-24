package com.sangeetha.tiana.domain.use_case

import com.sangeetha.tiana.data.remote.dto.MakeupProductsDto
import com.sangeetha.tiana.data.remote.dto.toMakeupProduct
import com.sangeetha.tiana.domain.model.MakeupProduct
import com.sangeetha.tiana.domain.repository.MakeupRepository
import com.sangeetha.tiana.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetAllMakeupProductUseCase @Inject constructor(
    private val repository: MakeupRepository
) {
    operator fun invoke(): Flow<Resource<List<MakeupProduct>>> = flow {
        try {
            emit(Resource.Loading<List<MakeupProduct>>())
            val makeupProducts = repository.getAllMakeupProducts().map {
                it.toMakeupProduct()
            }
            emit(Resource.Success<List<MakeupProduct>>(data = makeupProducts))
        } catch (e: HttpException) {
            emit(Resource.Failure<List<MakeupProduct>>(message = e.localizedMessage ?: "Something went wrong"))
        } catch (e: IOException) {
            emit(Resource.Failure<List<MakeupProduct>>(message = e.localizedMessage ?: "Couldn't reach server. Check your internet connection"))
        }
    }
}
