package aleksey.projects.hotels.screens.settings

import aleksey.projects.hotels.data.api.Api
import aleksey.projects.hotels.data.db.AppDatabase
import aleksey.projects.hotels.data.prefs.AppPrefs
import aleksey.projects.hotels.di.PerActivity
import android.content.Context
import dagger.Module
import dagger.Provides

@Module
class SettingsActivityModule {
    @PerActivity
    @Provides
    fun providePresenter(
        activity: SettingsActivity,
        interactor: SettingsActivityInteractor,
        resourceManager: SettingsActivityResourceManager
    ): SettingsActivityPresenter {
        val presenter = SettingsActivityPresenterImpl(interactor, resourceManager)
        activity.lifecycle.addObserver(presenter)
        presenter.attachView(activity)
        return presenter
    }

    @PerActivity
    @Provides
    fun provideInteractor(api: Api, db: AppDatabase, prefs: AppPrefs): SettingsActivityInteractor {
        return SettingsActivityInteractorImpl(api, db, prefs)
    }

    @PerActivity
    @Provides
    fun provideResourceManager(context: Context): SettingsActivityResourceManager {
        return SettingsActivityResourceManagerImpl(context.resources)
    }
}