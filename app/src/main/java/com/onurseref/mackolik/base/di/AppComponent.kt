package com.onurseref.mackolik.base.di

import android.app.Application
import com.onurseref.mackolik.App
import com.onurseref.mackolik.base.di.module.ActivityBuilderModule
import com.onurseref.mackolik.base.di.module.ApplicationModule
import com.onurseref.mackolik.base.di.module.ViewModelModule
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
        ApplicationModule::class,
        ViewModelModule::class
    ]
)
interface AppComponent : AndroidInjector<App> {
    @Component.Builder
    abstract class Builder : AndroidInjector.Builder<App>() {
        @BindsInstance
        abstract fun app(application: Application): Builder
    }
}