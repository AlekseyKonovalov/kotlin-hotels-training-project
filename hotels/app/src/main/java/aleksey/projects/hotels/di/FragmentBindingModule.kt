package aleksey.projects.hotels.di

import aleksey.projects.hotels.screens.hotel_information.about_hotel.AboutHotelFragment
import aleksey.projects.hotels.screens.hotel_information.about_hotel.AboutHotelFragmentModule
import aleksey.projects.hotels.screens.hotel_information.contact_hotel.ContactHotelFragment
import aleksey.projects.hotels.screens.hotel_information.contact_hotel.ContactHotelFragmentModule
import aleksey.projects.hotels.screens.hotel_list.navigation.NavigationFragment
import aleksey.projects.hotels.screens.hotel_list.navigation.NavigationFragmentModule
import dagger.Module
import dagger.android.ContributesAndroidInjector


@Module
abstract class FragmentBindingModule {

    @PerFragment
    @ContributesAndroidInjector(modules = [(NavigationFragmentModule::class)])
    abstract fun navigationFragment(): NavigationFragment

    @PerFragment
    @ContributesAndroidInjector(modules = [(ContactHotelFragmentModule::class)])
    abstract fun contactHotelFragment(): ContactHotelFragment

    @PerFragment
    @ContributesAndroidInjector(modules = [(AboutHotelFragmentModule::class)])
    abstract fun aboutHotelFragment(): AboutHotelFragment
}