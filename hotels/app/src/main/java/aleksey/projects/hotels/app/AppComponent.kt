package aleksey.projects.hotels.app

import aleksey.projects.hotels.di.ActivityBindingModule
import aleksey.projects.hotels.di.FragmentBindingModule
import aleksey.projects.hotels.di.PerApplication
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule

@PerApplication
@Component(modules = [
    (AndroidSupportInjectionModule::class),
    (ActivityBindingModule::class),
    (FragmentBindingModule::class),
    (AppModule::class)
])
interface AppComponent : AndroidInjector<App> {
    @Component.Builder
    abstract class Builder : AndroidInjector.Builder<App>()
}