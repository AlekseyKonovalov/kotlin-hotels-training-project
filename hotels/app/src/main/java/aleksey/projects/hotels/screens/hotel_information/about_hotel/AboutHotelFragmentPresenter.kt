package aleksey.projects.hotels.screens.hotel_information.about_hotel

import aleksey.projects.hotels.screens.common.BasePresenter
import android.arch.lifecycle.Lifecycle
import android.arch.lifecycle.LifecycleObserver
import android.arch.lifecycle.OnLifecycleEvent
import io.reactivex.disposables.CompositeDisposable

interface AboutHotelFragmentPresenter : BasePresenter<AboutHotelFragmentView> {

}

class AboutHotelFragmentPresenterImpl(
    val interactor: AboutHotelFragmentInteractor,
    val resourceManager: AboutHotelFragmentResourceManager
) : AboutHotelFragmentPresenter, LifecycleObserver {

    private val disposables = CompositeDisposable()

    private var view: AboutHotelFragmentView? = null

    override fun attachView(view: AboutHotelFragmentView) {
        this.view = view
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    override fun detachView() {
        disposables.dispose()
        this.view = null
    }

}