package com.rafaelneves.anacosmeticos.ui.screen.splash

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class SplashScreenViewModel : ViewModel() {

    private val _isLoading = MutableStateFlow(false)
    var isLoading = _isLoading.asStateFlow()

    fun openHomeScreen(
        onNavigateToHomeScreen: () -> Unit
    ) {
        viewModelScope.launch {
            _isLoading.value = true

            delay(2000)

            _isLoading.value = false

            onNavigateToHomeScreen()
        }
    }
}
