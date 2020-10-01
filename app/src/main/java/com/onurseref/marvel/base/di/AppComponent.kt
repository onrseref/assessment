package com.onurseref.marvel.base.di

import android.app.Application
import com.onurseref.marvel.App
import com.onurseref.marvel.base.di.module.ActivityBuilderModule
import com.onurseref.marvel.base.di.module.ApplicationModule
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