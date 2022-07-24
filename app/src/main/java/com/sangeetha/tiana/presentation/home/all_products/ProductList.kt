package com.sangeetha.tiana.presentation.home.all_products

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ProductList(
    viewModel: ProductListViewModel = hiltViewModel()
) {
    val state = viewModel.state.value
    Box(modifier = Modifier.fillMaxSize()) {

        if(state.makeupProducts.isNotEmpty()) {
            LazyVerticalGrid(cells = GridCells.Fixed(2), content = {
                items(20) { index ->
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        ProductListItem(product = state.makeupProducts[index], onItemClick = {

                        })
                    }
                }
            })
        }

        if (state.failure.isNotBlank()) {
            Text(
                text = state.failure,
                color = MaterialTheme.colors.error,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp)
                    .align(Alignment.Center)
            )
        }
        if (state.isLoading) {
            CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
        }
    }
}