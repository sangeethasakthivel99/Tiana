package com.sangeetha.tiana.presentation.home.all_products

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.sangeetha.tiana.domain.model.MakeupProduct

@Composable
fun ProductListItem(
    product: MakeupProduct,
    onItemClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp),
        elevation = 2.dp,
    ) {
        Column(
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(20.dp)
        ) {
            Image(
                painter = rememberAsyncImagePainter(product.imageLink),
                contentDescription = null,
                modifier = Modifier
                    .height(160.dp)
                    .width(60.dp),
                contentScale = ContentScale.Crop
            )
            Spacer(Modifier.height(10.dp))
            Text(
                text = product.name?: "",
                overflow = TextOverflow.Ellipsis
            )
        }
    }
}