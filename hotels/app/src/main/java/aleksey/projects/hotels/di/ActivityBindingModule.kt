package aleksey.projects.hotels.di

import aleksey.projects.hotels.screens.about_app.AboutAppActivity
import aleksey.projects.hotels.screens.about_app.AboutAppActivityModule
import aleksey.projects.hotels.screens.hotel_information.HotelInformationActivity
import aleksey.projects.hotels.screens.hotel_information.HotelInformationActivityModule
import aleksey.projects.hotels.screens.hotel_list.HotelListActivity
import aleksey.projects.hotels.screens.hotel_list.HotelListActivityModule
import aleksey.projects.hotels.screens.settings.SettingsActivity
import aleksey.projects.hotels.screens.settings.SettingsActivityModule
import aleksey.projects.hotels.screens.write_to_developer.WriteToDeveloperActivity
import aleksey.projects.hotels.screens.write_to_developer.WriteToDeveloperActivityModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBindingModule {

    @PerActivity
    @ContributesAndroidInjector(modules = [(HotelListActivityModule::class)])
    abstract fun hotelListActivity(): HotelListActivity

    @PerActivity
    @ContributesAndroidInjector(modules = [(HotelInformationActivityModule::class)])
    abstract fun hotelInformationActivity(): HotelInformationActivity

    @PerActivity
    @ContributesAndroidInjector(modules = [(AboutAppActivityModule::class)])
    abstract fun aboutAppActivity(): AboutAppActivity

    @PerActivity
    @ContributesAndroidInjector(modules = [(SettingsActivityModule::class)])
    abstract fun settingsActivity(): SettingsActivity

    @PerActivity
    @ContributesAndroidInjector(modules = [(WriteToDeveloperActivityModule::class)])
    abstract fun writeToDeveloperActivity(): WriteToDeveloperActivity

}