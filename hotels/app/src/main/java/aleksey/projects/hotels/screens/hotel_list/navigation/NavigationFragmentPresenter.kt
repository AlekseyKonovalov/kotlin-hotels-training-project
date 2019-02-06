package aleksey.projects.hotels.screens.hotel_list.navigation

import aleksey.projects.hotels.data.prefs.AppPrefs
import aleksey.projects.hotels.screens.common.BasePresenter
import android.arch.lifecycle.Lifecycle
import android.arch.lifecycle.LifecycleObserver
import android.arch.lifecycle.OnLifecycleEvent
import io.reactivex.disposables.CompositeDisposable

interface NavigationFragmentPresenter : BasePresenter<NavigationFragmentView> {
}

class NavigationFragmentPresenterImpl(val prefs: AppPrefs) :
    NavigationFragmentPresenter,
    LifecycleObserver {

    private var view: NavigationFragmentView? = null
    private val disposables = CompositeDisposable()

    override fun attachView(view: NavigationFragmentView) {
        this.view = view
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    override fun detachView() {
        disposables.dispose()
        this.view = null
    }
}