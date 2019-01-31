package aleksey.projects.hotels.screens.hotel_list

import aleksey.projects.hotels.screens.common.BasePresenter
import android.arch.lifecycle.LifecycleObserver
import io.reactivex.disposables.CompositeDisposable

interface HotelListActivityPresenter : BasePresenter<HotelListActivityView> {

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

}