package com.rafaelneves.anacosmeticos.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.rafaelneves.anacosmeticos.ui.new_box.NewBoxScreen
import com.rafaelneves.anacosmeticos.ui.screen.NewProductScreen
import com.rafaelneves.anacosmeticos.ui.screen.NewShippingScreen
import com.rafaelneves.anacosmeticos.ui.screen.SentScreen
import com.rafaelneves.anacosmeticos.ui.screen.StockScreen
import com.rafaelneves.anacosmeticos.ui.screen.home.HomeScreen
import com.rafaelneves.anacosmeticos.ui.screen.splash.SplashScreen

@Composable
fun Navigation(modifier: Modifier = Modifier) {
    val navController = rememberNavController()

    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = NavigationRoute.SPLASH_SCREEN.route
    ) {

        composable(route = NavigationRoute.SPLASH_SCREEN.route) {
            SplashScreen(
                onNavigateToHomeScreen = {
                    navController.navigate(NavigationRoute.HOME_SCREEN.route) {
                        popUpTo(NavigationRoute.SPLASH_SCREEN.route) {
                            inclusive = true
                        }
                    }
                }
            )
        }

        composable(route = NavigationRoute.HOME_SCREEN.route) {

            HomeScreen(
                onNavigateToNewShippingScreenScreen = {
                    navController.navigate(NavigationRoute.NEW_SHIPPING_SCREEN.route)
                },
                onNavigateToSentScreenScreen = {
                    navController.navigate(NavigationRoute.SENT_SCREEN.route)
                },
                onNavigateToStockScreenScreen = {
                    navController.navigate((NavigationRoute.STOCK_SCREEN.route))
                },
                onNavigateToNewProductScreenScreen = {
                    navController.navigate(NavigationRoute.ADD_NEW_PRODUCT.route)
                }
            )
        }

        composable(route = NavigationRoute.NEW_SHIPPING_SCREEN.route) {
            NewShippingScreen(
                productInput = "",
                quantityInput = "",
                onNavigateToNewBoxScreen = {
                    navController.navigate(NavigationRoute.NEW_BOX_SCREEN.route)
                },
                onBackPressed = { navController.navigateUp() }
            )
        }

        composable(route = NavigationRoute.NEW_BOX_SCREEN.route) {
            NewBoxScreen(
                onBackPressed = { navController.navigateUp() }
            )
        }

        composable(route = NavigationRoute.SENT_SCREEN.route) {
            SentScreen(
                onBackPressed = { navController.navigateUp() }
            )
        }

        composable(route = NavigationRoute.STOCK_SCREEN.route) {
            StockScreen(
                onNavigateToAddNewProduct = {
                    navController.navigate(NavigationRoute.ADD_NEW_PRODUCT.route)
                },
                onBackPressed = { navController.navigateUp() }
            )
        }

        composable(route = NavigationRoute.ADD_NEW_PRODUCT.route) {
            NewProductScreen(
                productName = "",
                productDescription = "",
                productAmount = "",
                productForm = "",
                onBackPressed = { navController.navigateUp() }
            )
        }
    }
}