package com.rafaelneves.anacosmeticos.ui.screen.splash

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SplashScreenViewModel : ViewModel() {

    val isLoading = mutableStateOf(false)

    fun openHomeScreen(
        onNavigateToHomeScreen: () -> Unit
    ) {
        viewModelScope.launch {
            isLoading.value = true

            delay(2000)

            isLoading.value = false

            onNavigateToHomeScreen()
        }
    }
}
