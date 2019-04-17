package aleksey.projects.hotels.screens.hotel_information.about_hotel

import aleksey.projects.hotels.data.api.Api
import aleksey.projects.hotels.data.db.AppDatabase
import aleksey.projects.hotels.di.PerFragment
import android.content.Context
import dagger.Module
import dagger.Provides

@Module
class AboutHotelFragmentModule {
    @PerFragment
    @Provides
    fun providePresenter(activity: AboutHotelFragment,
                         interactor: AboutHotelFragmentInteractor,
                         resourceManager: AboutHotelFragmentResourceManager
    ): AboutHotelFragmentPresenter {
        val presenter = AboutHotelFragmentPresenterImpl(interactor, resourceManager)
        activity.lifecycle.addObserver(presenter)
        presenter.attachView(activity)
        return presenter
    }

    @PerFragment
    @Provides
    fun provideInteractor(api: Api, db: AppDatabase): AboutHotelFragmentInteractor {
        return AboutHotelFragmentInteractorImpl(api, db)
    }

    @PerFragment
    @Provides
    fun provideResourceManager(context: Context): AboutHotelFragmentResourceManager {
        return AboutHotelFragmentResourceManagerImpl(context.resources)
    }

}