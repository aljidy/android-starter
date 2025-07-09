package com.example.myapplication

import android.app.Application
import com.example.myapplication.di.FeatureModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

class MyApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        initKoin()
    }

    private fun initKoin() {
        startKoin {
            androidContext(this@MyApplication)
            modules(
                module {
                    single {
                        FeatureModule.provideOkHttpClient()
                    }

                    single {
                        FeatureModule.providesFeatureService(get())
                    }


                }
            )

        }
    }
}

