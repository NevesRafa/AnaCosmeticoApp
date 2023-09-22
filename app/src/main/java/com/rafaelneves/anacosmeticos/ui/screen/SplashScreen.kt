package com.rafaelneves.anacosmeticos.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.rememberLottieComposition
import com.rafaelneves.anacosmeticos.R
import com.rafaelneves.anacosmeticos.ui.widget.ButtonWithLoading


@Composable
fun SplashScreen(
    onNavigateToHomeScreen: () -> Unit
) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        ComposeLottieAnimation()


        Spacer(modifier = Modifier.height(16.dp))

        ButtonWithLoading(
            title = stringResource(R.string.enter_btn),
            isLoading = false,
            onClick = { onNavigateToHomeScreen() }
        )
    }
}


@Composable
fun ComposeLottieAnimation(modifier: Modifier = Modifier) {

    val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.box_animation))

    LottieAnimation(
        modifier = modifier,
        composition = composition,
        iterations = LottieConstants.IterateForever,
    )
}

//@Composable
//@Preview
//fun SplashScreenPreview() {
//    SplashScreen()
//}