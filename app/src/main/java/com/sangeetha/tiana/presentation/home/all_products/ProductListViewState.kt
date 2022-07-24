package com.sangeetha.tiana.presentation.home.all_products

import com.sangeetha.tiana.domain.model.MakeupProduct

data class ProductListViewState(
    val isLoading: Boolean = false,
    val makeupProducts: List<MakeupProduct> = emptyList(),
    val failure: String = ""
)