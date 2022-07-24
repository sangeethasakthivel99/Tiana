package com.sangeetha.tiana.presentation.home.all_products

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sangeetha.tiana.domain.use_case.GetAllMakeupProductUseCase
import com.sangeetha.tiana.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProductListViewModel @Inject constructor(
    private val getAllMakeupProductUseCase: GetAllMakeupProductUseCase
) : ViewModel() {

    private val _state = mutableStateOf(ProductListViewState())
    val state: State<ProductListViewState> = _state

    init {
        getMakeupProducts()
    }

    private fun getMakeupProducts() {
        viewModelScope.launch {
            getAllMakeupProductUseCase.invoke().collect {
                when (it) {
                    is Resource.Success -> {
                        _state.value = ProductListViewState(makeupProducts = it.data?.reversed() ?: emptyList())
                    }

                    is Resource.Failure -> {
                        _state.value =
                            ProductListViewState(failure = it.message ?: "Something went wrong")
                    }

                    is Resource.Loading -> {
                        _state.value = ProductListViewState(isLoading = true)
                    }
                }
            }
        }
    }
}