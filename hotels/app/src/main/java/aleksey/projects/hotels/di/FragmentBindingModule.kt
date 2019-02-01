package aleksey.projects.hotels.di

import aleksey.projects.hotels.screens.hotel_information.contact_hotel.ContactHotelFragment
import aleksey.projects.hotels.screens.hotel_information.contact_hotel.ContactHotelFragmentModule
import dagger.Module
import dagger.android.ContributesAndroidInjector


@Module
abstract class FragmentBindingModule {
    @PerFragment
    @ContributesAndroidInjector(modules = [(ContactHotelFragmentModule::class)])
    abstract fun navigationFragment(): ContactHotelFragment
}