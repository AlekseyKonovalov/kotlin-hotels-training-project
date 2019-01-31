package aleksey.projects.hotels.screens.hotel_information

import aleksey.projects.hotels.screens.common.BasePresenter
import android.arch.lifecycle.LifecycleObserver
import io.reactivex.disposables.CompositeDisposable

interface HotelInformationActivityPresenter : BasePresenter<HotelInformationActivityView> {

}

class HotelInformationActivityPresenterImpl(
    private val interactor: HotelInformationActivityInteractor,
    private val resourceManager: HotelInformationActivityResourceManager
)  : HotelInformationActivityPresenter, LifecycleObserver {

    private var view: HotelInformationActivityView? = null
    private val disposables = CompositeDisposable()

    override fun attachView(view: HotelInformationActivityView) {
        this.view = view
    }

    override fun detachView() {
        disposables.dispose()
        this.view = null
    }

}