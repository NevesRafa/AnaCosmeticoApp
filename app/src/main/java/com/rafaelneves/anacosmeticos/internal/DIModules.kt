package com.rafaelneves.anacosmeticos.internal

import androidx.room.Room
import com.rafaelneves.anacosmeticos.data.local.database.AppDatabase
import com.rafaelneves.anacosmeticos.repository.NewBoxRepository
import com.rafaelneves.anacosmeticos.repository.NewProductRepository
import com.rafaelneves.anacosmeticos.ui.screen.home.HomeScreenViewModel
import com.rafaelneves.anacosmeticos.ui.screen.new_box.NewBoxScreenViewModel
import com.rafaelneves.anacosmeticos.ui.screen.product.NewProductViewModel
import com.rafaelneves.anacosmeticos.ui.screen.splash.SplashScreenViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

object DIModules {

    fun all() = listOf(
        dataModule,
        repositoryModule,
        viewModelModule
    )

    private val dataModule = module {
        single {
            Room.databaseBuilder(
                get(),
                AppDatabase::class.java,
                name = "anacosmeticos-db"
            )
                .fallbackToDestructiveMigration()
                .build()
        }

        factory { get<AppDatabase>().boxDetailsDao() }
        factory { get<AppDatabase>().productBoxDetailsDao() }
        factory { get<AppDatabase>().productDetailsDao() }
        factory { get<AppDatabase>().shippingDetailsDao() }
    }
}

private val repositoryModule = module {
    factory { NewBoxRepository(get()) }
    factory { NewProductRepository(get()) }
}

private val viewModelModule = module {
    viewModel { HomeScreenViewModel() }
    viewModel { SplashScreenViewModel() }
    viewModel { NewBoxScreenViewModel(get()) }
    viewModel { NewProductViewModel(get()) }
}
