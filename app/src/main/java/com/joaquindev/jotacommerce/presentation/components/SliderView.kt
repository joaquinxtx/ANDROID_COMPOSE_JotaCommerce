package com.joaquindev.jotacommerce.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import coil.size.Scale
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.PagerState
import com.joaquindev.jotacommerce.R


@OptIn(ExperimentalPagerApi::class)
@Composable
fun SliderView(state: PagerState, images: List<String>) {

    val imageUrl = remember { mutableStateOf("") }
    HorizontalPager(
        state = state,
        count = images.size, modifier = Modifier
            .height(200.dp)
            .fillMaxWidth().padding(horizontal = 20.dp)

    ) { page ->
        imageUrl.value = images[page]

        Card(
            shape = RoundedCornerShape(
                30.dp

            )
        ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(contentAlignment = Alignment.BottomCenter) {

                val painter = rememberAsyncImagePainter(
                    ImageRequest.Builder(LocalContext.current).data(data = imageUrl.value)
                        .apply(block = fun ImageRequest.Builder.() {
                            placeholder( R.drawable.camara)
                            scale(Scale.FILL)
                        }).build()
                )
                    Image(
                        modifier = Modifier.fillMaxSize(),
                        painter = painter,
                        contentDescription = stringResource(id = R.string.image),
                    )

                }
            }
        }
    }
}
