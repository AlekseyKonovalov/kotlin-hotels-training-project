package aleksey.projects.hotels.screens.hotel_list

import aleksey.projects.hotels.screens.common.BasePresenter
import android.arch.lifecycle.LifecycleObserver
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.plusAssign
import timber.log.Timber

interface HotelListActivityPresenter : BasePresenter<HotelListActivityView> {
    fun loadHotels()
}

class HotelListActivityPresenterImpl(
    val interactor: HotelListActivityInteractor,
    val resourceManager: HotelListActivityResourceManager
) : HotelListActivityPresenter, LifecycleObserver {

    private var view: HotelListActivityView? = null
    private val disposables = CompositeDisposable()

    override fun attachView(view: HotelListActivityView) {
        this.view = view
    }

    override fun detachView() {
        disposables.dispose()
        this.view = null
    }

    override fun loadHotels() {
        disposables += interactor.getHotels()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                { response ->
                    view?.submitHotelsItems(response)
                },
                { error ->
                    Timber.e(error)
                    view?.showSnackbar(resourceManager.getInternetError())
                }
            )
    }

}