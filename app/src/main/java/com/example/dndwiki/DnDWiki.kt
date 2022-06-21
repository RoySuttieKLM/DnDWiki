package com.example.dndwiki

import android.app.Application
import com.example.dndwiki.diModule.DnDModule
import com.example.dndwiki.diModule.databaseModule
import com.example.dndwiki.diModule.repositoryModule
import com.example.dndwiki.diModule.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.GlobalContext.startKoin

class DnDWiki : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@DnDWiki)
            modules(
                DnDModule,
                repositoryModule,
                viewModelModule,
                databaseModule
            )
        }
    }
}