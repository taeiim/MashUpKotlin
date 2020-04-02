package com.taeiim.gittoy

import android.app.Application
import com.taeiim.gittoy.di.dataSourceModule
import com.taeiim.gittoy.di.networkModule
import com.taeiim.gittoy.di.viewModelModule
import com.taeiim.gittoy.ext.setupKoin

class GitToyApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        setupKoin(this, viewModelModule, dataSourceModule, networkModule)
    }

}