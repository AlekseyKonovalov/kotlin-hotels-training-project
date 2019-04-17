package aleksey.projects.hotels.screens.write_to_developer

import aleksey.projects.hotels.data.api.Api
import aleksey.projects.hotels.data.db.AppDatabase
import aleksey.projects.hotels.di.PerActivity
import android.content.Context
import dagger.Module
import dagger.Provides

@Module
class WriteToDeveloperActivityModule {
    @PerActivity
    @Provides
    fun providePresenter(
        activity: WriteToDeveloperActivity,
        interactor: WriteToDeveloperActivityInteractor,
        resourceManager: WriteToDeveloperActivityResourceManager
    ): WriteToDeveloperActivityPresenter {
        val presenter = WriteToDeveloperActivityPresenterImpl(interactor, resourceManager)
        activity.lifecycle.addObserver(presenter)
        presenter.attachView(activity)
        return presenter
    }

    @PerActivity
    @Provides
    fun provideInteractor(api: Api, db: AppDatabase): WriteToDeveloperActivityInteractor {
        return WriteToDeveloperActivityInteractorImpl(api, db)
    }

    @PerActivity
    @Provides
    fun provideResourceManager(context: Context): WriteToDeveloperActivityResourceManager {
        return WriteToDeveloperActivityResourceManagerImpl(context.resources)
    }
}