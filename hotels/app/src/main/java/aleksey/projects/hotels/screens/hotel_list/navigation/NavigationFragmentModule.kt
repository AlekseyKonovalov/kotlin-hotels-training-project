package aleksey.projects.hotels.screens.hotel_list.navigation

import aleksey.projects.hotels.data.prefs.AppPrefs
import aleksey.projects.hotels.di.PerFragment
import dagger.Module
import dagger.Provides

@Module
class NavigationFragmentModule {

    @PerFragment
    @Provides
    fun providePresenter(fragment: NavigationFragment, prefs: AppPrefs): NavigationFragmentPresenter {
        val presenter = NavigationFragmentPresenterImpl(prefs)
        fragment.lifecycle.addObserver(presenter)
        presenter.attachView(fragment)
        return presenter
    }

}