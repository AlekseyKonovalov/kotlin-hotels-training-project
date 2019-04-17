package aleksey.projects.hotels.di

import aleksey.projects.hotels.screens.hotel_information.HotelInformationActivity
import aleksey.projects.hotels.screens.hotel_information.HotelInformationActivityModule
import aleksey.projects.hotels.screens.hotel_list.HotelListActivity
import aleksey.projects.hotels.screens.hotel_list.HotelListActivityModule
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
}