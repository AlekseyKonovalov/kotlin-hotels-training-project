package aleksey.projects.hotels.screens.hotel_information.contact_hotel

import aleksey.projects.hotels.data.api.Api
import aleksey.projects.hotels.data.db.AppDatabase
import aleksey.projects.hotels.di.PerFragment
import android.content.Context
import dagger.Module
import dagger.Provides


@Module
class ContactHotelFragmentModule {
    @PerFragment
    @Provides
    fun providePresenter(activity: ContactHotelFragment,
                         interactor: ContactHotelFragmentInteractor,
                         resourceManager: ContactHotelFragmentResourceManager): ContactHotelFragmentPresenter {
        val presenter = ContactHotelFragmentPresenterImpl(interactor, resourceManager)
        activity.lifecycle.addObserver(presenter)
        presenter.attachView(activity)
        return presenter
    }

    @PerFragment
    @Provides
    fun provideInteractor(api: Api, db: AppDatabase): ContactHotelFragmentInteractor {
        return ContactHotelFragmentInteractorImpl(api, db)
    }

    @PerFragment
    @Provides
    fun provideResourceManager(context: Context): ContactHotelFragmentResourceManager {
        return ContactHotelFragmentResourceManagerImpl(context.resources)
    }

}