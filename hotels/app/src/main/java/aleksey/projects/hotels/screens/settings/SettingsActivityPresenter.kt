package aleksey.projects.hotels.screens.settings

import aleksey.projects.hotels.screens.common.BasePresenter
import android.arch.lifecycle.Lifecycle
import android.arch.lifecycle.LifecycleObserver
import android.arch.lifecycle.OnLifecycleEvent
import io.reactivex.disposables.CompositeDisposable

interface SettingsActivityPresenter : BasePresenter<SettingsActivityView> {

}

class SettingsActivityPresenterImpl(
    private val interactor: SettingsActivityInteractor,
    private val resourceManager: SettingsActivityResourceManager
) : SettingsActivityPresenter, LifecycleObserver {

    private var view: SettingsActivityView? = null
    private val disposables = CompositeDisposable()

    override fun attachView(view: SettingsActivityView) {
        this.view = view
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    override fun detachView() {
        disposables.dispose()
        this.view = null
    }

}