package aleksey.projects.hotels.screens.hotel_list

import aleksey.projects.hotels.data.api.Api
import aleksey.projects.hotels.data.db.AppDatabase
import aleksey.projects.hotels.data.prefs.AppPrefs
import aleksey.projects.hotels.di.PerActivity
import android.content.Context
import dagger.Module
import dagger.Provides

@Module
class HotelListActivityModule {

    @PerActivity
    @Provides
    fun providePresenter(
        activity: HotelListActivity,
        interactor: HotelListActivityInteractor,
        resourceManager: HotelListActivityResourceManager,
        prefs: AppPrefs
    ): HotelListActivityPresenter {
        val presenter = HotelListActivityPresenterImpl(interactor, resourceManager, prefs)
        activity.lifecycle.addObserver(presenter)
        presenter.attachView(activity)
        return presenter
    }

    @PerActivity
    @Provides
    fun provideInteractor(api: Api, db: AppDatabase): HotelListActivityInteractor {
        return HotelListActivityInteractorImpl(api, db)
    }

    @PerActivity
    @Provides
    fun provideResourceManager(context: Context): HotelListActivityResourceManager {
        return HotelListActivityResourceManagerImpl(context.resources)
    }

}