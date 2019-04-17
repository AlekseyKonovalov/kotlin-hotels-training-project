package aleksey.projects.hotels.screens.about_app

import aleksey.projects.hotels.screens.common.BasePresenter
import android.arch.lifecycle.Lifecycle
import android.arch.lifecycle.LifecycleObserver
import android.arch.lifecycle.OnLifecycleEvent
import io.reactivex.disposables.CompositeDisposable


interface AboutAppActivityPresenter : BasePresenter<AboutAppActivityView> {

}

class AboutAppActivityPresenterImpl(
    private val interactor: AboutAppActivityInteractor,
    private val resourceManager: AboutAppActivityResourceManager
) : AboutAppActivityPresenter, LifecycleObserver {

    private var view: AboutAppActivityView? = null
    private val disposables = CompositeDisposable()

    override fun attachView(view: AboutAppActivityView) {
        this.view = view
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    override fun detachView() {
        disposables.dispose()
        this.view = null
    }

}