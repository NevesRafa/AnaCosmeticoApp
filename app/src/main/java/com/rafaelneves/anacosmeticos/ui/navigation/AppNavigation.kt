package com.rafaelneves.anacosmeticos.ui.navigation

import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.core.tween
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.rafaelneves.anacosmeticos.ui.screen.HomeScreen
import com.rafaelneves.anacosmeticos.ui.screen.NewProductScreen
import com.rafaelneves.anacosmeticos.ui.screen.NewShippingScreen
import com.rafaelneves.anacosmeticos.ui.screen.SentScreen
import com.rafaelneves.anacosmeticos.ui.screen.StockScreen

@Composable
fun Navigation(modifier: Modifier = Modifier) {
    val navController = rememberNavController()

    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = NavigationRoute.HOME_SCREEN.route
    ) {
        composable(
            route = NavigationRoute.HOME_SCREEN.route,
            enterTransition = {
                slideIntoContainer(
                    AnimatedContentTransitionScope.SlideDirection.Left,
                    animationSpec = tween(700)
                )
            },
            exitTransition = {
                slideOutOfContainer(
                    AnimatedContentTransitionScope.SlideDirection.Right,
                    animationSpec = tween(700)
                )
            }
        )
        {
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
                    navController.navigate(NavigationRoute.NEW_PRODUCT_SCREEN.route)
                }
            )
        }

        composable(
            route = NavigationRoute.NEW_SHIPPING_SCREEN.route,
            enterTransition = {
                slideIntoContainer(
                    AnimatedContentTransitionScope.SlideDirection.Left,
                    animationSpec = tween(700)
                )
            },
            exitTransition = {
                slideOutOfContainer(
                    AnimatedContentTransitionScope.SlideDirection.Right,
                    animationSpec = tween(700)
                )
            }
        ) {
            NewShippingScreen(topAppBarTitle = "NOVO ENVIO", productInput = "", quantityInput = "")
        }

        composable(
            route = NavigationRoute.SENT_SCREEN.route,
            enterTransition = {
                slideIntoContainer(
                    AnimatedContentTransitionScope.SlideDirection.Left,
                    animationSpec = tween(700)
                )
            },
            exitTransition = {
                slideOutOfContainer(
                    AnimatedContentTransitionScope.SlideDirection.Right,
                    animationSpec = tween(700)
                )
            }
        ) {
            SentScreen(topAppBarTitle = "ENVIADOS")
        }

        composable(
            route = NavigationRoute.STOCK_SCREEN.route,
            enterTransition = {
                slideIntoContainer(
                    AnimatedContentTransitionScope.SlideDirection.Left,
                    animationSpec = tween(700)
                )
            },
            exitTransition = {
                slideOutOfContainer(
                    AnimatedContentTransitionScope.SlideDirection.Right,
                    animationSpec = tween(700)
                )
            }
        ) {
            StockScreen(topAppBarTitle = "ESTOQUE")
        }

        composable(
            route = NavigationRoute.NEW_PRODUCT_SCREEN.route,
            enterTransition = {
                slideIntoContainer(
                    AnimatedContentTransitionScope.SlideDirection.Left,
                    animationSpec = tween(700)
                )
            },
            exitTransition = {
                slideOutOfContainer(
                    AnimatedContentTransitionScope.SlideDirection.Right,
                    animationSpec = tween(700)
                )
            }
        ) {
            NewProductScreen(
                topAppBarTitle = "NOVO PRODUTO",
                productName = "",
                productDescription = "",
                productAmount = "",
                productForm = ""
            )
        }
    }
}