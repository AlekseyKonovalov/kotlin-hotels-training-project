package aleksey.projects.hotels.screens.hotel_information

import aleksey.projects.hotels.screens.common.BasePresenter
import android.arch.lifecycle.Lifecycle
import android.arch.lifecycle.LifecycleObserver
import android.arch.lifecycle.OnLifecycleEvent
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.plusAssign
import timber.log.Timber

interface HotelInformationActivityPresenter : BasePresenter<HotelInformationActivityView> {
    fun loadHotelInfo(hotelId: String)
}

class HotelInformationActivityPresenterImpl(
    private val interactor: HotelInformationActivityInteractor,
    private val resourceManager: HotelInformationActivityResourceManager
) : HotelInformationActivityPresenter, LifecycleObserver {

    private var view: HotelInformationActivityView? = null
    private val disposables = CompositeDisposable()

    override fun attachView(view: HotelInformationActivityView) {
        this.view = view
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    override fun detachView() {
        disposables.dispose()
        this.view = null
    }

    override fun loadHotelInfo(hotelId: String) {
        disposables += interactor.loadHotelInfo(hotelId)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                view?.setViews(it)
            },
                {
                    Timber.e(it.message.toString())
                })
    }

}