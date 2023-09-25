package com.rafaelneves.anacosmeticos.internal

import androidx.room.Room
import com.rafaelneves.anacosmeticos.data.local.database.AppDatabase
import org.koin.dsl.module

object DIModules {

    fun all() = listOf(
        dataModule,
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

private val viewModelModule = module { }
