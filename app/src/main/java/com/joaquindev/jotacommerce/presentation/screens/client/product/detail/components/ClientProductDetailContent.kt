package com.joaquindev.jotacommerce.presentation.screens.client.product.detail.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.rememberPagerState
import com.joaquindev.jotacommerce.presentation.components.DefaultButton
import com.joaquindev.jotacommerce.presentation.components.DotsIndicator
import com.joaquindev.jotacommerce.presentation.components.SliderView
import com.joaquindev.jotacommerce.presentation.screens.client.product.detail.ClientProductDetailViewModel
import com.joaquindev.jotacommerce.presentation.ui.theme.Cafe_blue
import kotlinx.coroutines.delay

@OptIn(ExperimentalPagerApi::class)
@Composable
fun ClientProductDetailContent(
    paddingValues: PaddingValues,
    vm: ClientProductDetailViewModel = hiltViewModel()
) {
    val state = rememberPagerState()

    Box() {
        Column(Modifier.padding(paddingValues)) {
            SliderView(state = state, images = vm.productImages)
            Spacer(modifier = Modifier.height(4.dp))
            DotsIndicator(totalDots = vm.productImages.size, selectedIndex = state.currentPage)

        }
        Card(
            modifier = Modifier.padding(top = 300.dp),
            shape = RoundedCornerShape(
                topEnd = 40.dp,
                topStart = 40.dp

            )
        ) {

            Column(modifier = Modifier.padding(20.dp)) {
                Text(text = vm.product.name, fontWeight = FontWeight.Bold, fontSize = 18.sp)
                Divider(color = Color.White, modifier = Modifier.padding(vertical = 10.dp))
                Text(
                    text = "Descripcion",
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp,
                    modifier = Modifier.padding(bottom = 7.dp)
                )
                Text(text = vm.product.description, fontSize = 15.sp)
                Divider(color = Color.White, modifier = Modifier.padding(vertical = 10.dp))
                Text(
                    text = "Precio",
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp,
                    modifier = Modifier.padding(bottom = 7.dp)
                )
                Text(text = vm.product.price.toString(), fontSize = 15.sp)
                Divider(color = Color.White, modifier = Modifier.padding(vertical = 10.dp))
                Text(
                    text = "Tu Orden",
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp,
                    modifier = Modifier.padding(bottom = 7.dp)
                )
                Text(text = "Cantidad: 0", fontSize = 15.sp)
                Text(text = "Precio C/U: 0", fontSize = 15.sp)

                Spacer(modifier = Modifier.weight(1f))


                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Card(
                        shape = RoundedCornerShape(20.dp),

                        colors = CardDefaults.cardColors(containerColor = Cafe_blue),
                        modifier = Modifier
                            .width(100.dp)
                            .height(35.dp)
                    ) {
                        Row(

                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceEvenly,
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Text(
                                text = "-", fontSize = 18.sp,

                                color = Color.White,
                                modifier = Modifier.clickable { vm.remove() }
                            )
                            Text(
                                text = vm.quantity.toString(), fontSize = 20.sp,
                                color = Color.White
                            )
                            Text(
                                text = "+", fontSize = 18.sp,
                                color = Color.White,
                                modifier = Modifier.clickable { vm.add() }
                            )
                        }
                    }

                    DefaultButton(
                        modifier = Modifier.width(200.dp),
                        text = "Agregar al carrito",
                        onClick = { vm.saveItem()})


                }

            }

        }

    }
    LaunchedEffect(key1 = state.currentPage) {
        delay(timeMillis = 3000)
        var newPosition = state.currentPage + 1
        if (newPosition > vm.productImages.size - 1) {
            newPosition = 0
        }

        state.animateScrollToPage(newPosition)
    }
}