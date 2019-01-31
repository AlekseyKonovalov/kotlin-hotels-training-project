package aleksey.projects.hotels.di

import aleksey.projects.hotels.screens.hotel_list.HotelListActivity
import aleksey.projects.hotels.screens.hotel_list.HotelListActivityModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBindingModule {

    @PerActivity
    @ContributesAndroidInjector(modules = [(HotelListActivityModule::class)])
    abstract fun hotelListActivity(): HotelListActivity


}