package aleksey.projects.hotels.screens.hotel_information.contact_hotel

import aleksey.projects.hotels.screens.common.BasePresenter
import android.arch.lifecycle.Lifecycle
import android.arch.lifecycle.LifecycleObserver
import android.arch.lifecycle.OnLifecycleEvent
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.plusAssign
import io.reactivex.schedulers.Schedulers
import timber.log.Timber

interface ContactHotelFragmentPresenter : BasePresenter<ContactHotelFragmentView> {
    fun getContacts(hotelId: String)
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

    override fun getContacts(hotelId: String) {
        disposables += interactor.getHotelInfo(hotelId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        {
                            view?.setView(it.address, it.phone ?: "")
                        },
                        {
                            Timber.e(it)
                        })
    }

}