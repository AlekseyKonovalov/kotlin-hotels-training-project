package aleksey.projects.hotels.screens.write_to_developer

import aleksey.projects.hotels.screens.common.BasePresenter
import android.arch.lifecycle.Lifecycle
import android.arch.lifecycle.LifecycleObserver
import android.arch.lifecycle.OnLifecycleEvent
import io.reactivex.disposables.CompositeDisposable


interface WriteToDeveloperActivityPresenter : BasePresenter<WriteToDeveloperActivityView> {

}

class WriteToDeveloperActivityPresenterImpl(
    private val interactor: WriteToDeveloperActivityInteractor,
    private val resourceManager: WriteToDeveloperActivityResourceManager
) : WriteToDeveloperActivityPresenter, LifecycleObserver {

    private var view: WriteToDeveloperActivityView? = null
    private val disposables = CompositeDisposable()

    override fun attachView(view: WriteToDeveloperActivityView) {
        this.view = view
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    override fun detachView() {
        disposables.dispose()
        this.view = null
    }

}