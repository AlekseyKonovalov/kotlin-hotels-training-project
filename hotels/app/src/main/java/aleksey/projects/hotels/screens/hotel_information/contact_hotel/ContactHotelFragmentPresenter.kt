package aleksey.projects.hotels.screens.hotel_information.contact_hotel

import aleksey.projects.hotels.screens.common.BasePresenter
import android.arch.lifecycle.Lifecycle
import android.arch.lifecycle.LifecycleObserver
import android.arch.lifecycle.OnLifecycleEvent
import io.reactivex.disposables.CompositeDisposable

interface ContactHotelFragmentPresenter : BasePresenter<ContactHotelFragmentView> {

}

class ContactHotelFragmentPresenterImpl(
    val interactor: ContactHotelFragmentInteractor,
    val resourceManager: ContactHotelFragmentResourceManager
) : ContactHotelFragmentPresenter, LifecycleObserver {

    private val disposables = CompositeDisposable()

    private var view: ContactHotelFragmentView? = null

    override fun attachView(view: ContactHotelFragmentView) {
        this.view = view
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    override fun detachView() {
        disposables.dispose()
        this.view = null
    }

}