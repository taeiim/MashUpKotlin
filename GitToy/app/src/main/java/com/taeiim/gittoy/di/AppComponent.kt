package com.taeiim.gittoy.di

import com.taeiim.gittoy.GitToyApplication
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
        modules = [
            AndroidInjectionModule::class,
            DataSourceModule::class,
            ActivityModuleBuilder::class,
            ViewModelModule::class
        ]
)

interface AppComponent {
    @Component.Builder
    interface Builder {
        fun build(): AppComponent
    }
    fun inject(app: GitToyApplication)
}
