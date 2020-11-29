package com.onurseref.trendyol.di

import android.app.Application
import com.onurseref.trendyol.App
import com.onurseref.trendyol.di.module.ActivityBuilderModule
import com.onurseref.trendyol.di.module.ApplicationModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton


@Singleton
@Component(
    modules = [
        AndroidSupportInjectionModule::class,
        ActivityBuilderModule::class,
        ApplicationModule::class
    ]
)
interface AppComponent : AndroidInjector<App> {
    @Component.Builder
    abstract class Builder : AndroidInjector.Builder<App>() {
        @BindsInstance
        abstract fun app(application: Application): Builder
    }
}