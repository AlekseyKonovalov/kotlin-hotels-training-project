package aleksey.projects.hotels.screens.about_app

import aleksey.projects.hotels.data.api.Api
import aleksey.projects.hotels.data.db.AppDatabase
import aleksey.projects.hotels.di.PerActivity
import android.content.Context
import dagger.Module
import dagger.Provides


@Module
class AboutAppActivityModule {
    @PerActivity
    @Provides
    fun providePresenter(
        activity: AboutAppActivity,
        interactor: AboutAppActivityInteractor,
        resourceManager: AboutAppActivityResourceManager
    ): AboutAppActivityPresenter {
        val presenter = AboutAppActivityPresenterImpl(interactor, resourceManager)
        activity.lifecycle.addObserver(presenter)
        presenter.attachView(activity)
        return presenter
    }

    @PerActivity
    @Provides
    fun provideInteractor(api: Api, db: AppDatabase): AboutAppActivityInteractor {
        return AboutAppActivityInteractorImpl(api, db)
    }

    @PerActivity
    @Provides
    fun provideResourceManager(context: Context): AboutAppActivityResourceManager {
        return AboutAppActivityResourceManagerImpl(context.resources)
    }
}
