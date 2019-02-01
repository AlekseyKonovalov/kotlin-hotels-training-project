package aleksey.projects.hotels.screens.hotel_information

import aleksey.projects.hotels.data.api.Api
import aleksey.projects.hotels.data.db.AppDatabase
import aleksey.projects.hotels.di.PerActivity
import android.content.Context
import dagger.Module
import dagger.Provides

@Module
class HotelInformationActivityModule {

    @PerActivity
    @Provides
    fun providePresenter(activity: HotelInformationActivity,
                         interactor: HotelInformationActivityInteractor,
                         resourceManager: HotelInformationActivityResourceManager): HotelInformationActivityPresenter {
        val presenter = HotelInformationActivityPresenterImpl(interactor, resourceManager)
        activity.lifecycle.addObserver(presenter)
        presenter.attachView(activity)
        return presenter
    }

    @PerActivity
    @Provides
    fun provideInteractor(api: Api, db: AppDatabase): HotelInformationActivityInteractor {
        return HotelInformationActivityInteractorImpl(api, db)
    }

    @PerActivity
    @Provides
    fun provideResourceManager(context: Context):HotelInformationActivityResourceManager {
        return HotelInformationActivityResourceManagerImpl(context.resources)
    }

}
