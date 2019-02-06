package aleksey.projects.hotels.screens.hotel_list

import aleksey.projects.hotels.data.prefs.AppPrefs
import aleksey.projects.hotels.screens.common.BasePresenter
import aleksey.projects.hotels.screens.hotel_list.models.HotelModel
import android.arch.lifecycle.Lifecycle
import android.arch.lifecycle.LifecycleObserver
import android.arch.lifecycle.OnLifecycleEvent
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.plusAssign
import timber.log.Timber

interface HotelListActivityPresenter : BasePresenter<HotelListActivityView> {
    fun loadHotels()
    fun onSortModeSelected(sortModeId: Int, items: MutableList<HotelModel>)
    fun getSortModes()
    fun setup()
}

class HotelListActivityPresenterImpl(
    private val interactor: HotelListActivityInteractor,
    private val resourceManager: HotelListActivityResourceManager,
    private val prefs: AppPrefs
) : HotelListActivityPresenter, LifecycleObserver {

    private var view: HotelListActivityView? = null
    private val disposables = CompositeDisposable()

    override fun attachView(view: HotelListActivityView) {
        this.view = view
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    override fun detachView() {
        disposables.dispose()
        this.view = null
    }

    override fun loadHotels() {
        view?.showProgressBar()
        disposables += interactor.getHotels()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                { response ->
                    view?.hideProgressBar()
                    view?.submitHotelsItems(response)
                },
                { error ->
                    Timber.e(error)
                    view?.hideProgressBar()
                    view?.showSnackbar(resourceManager.getInternetError())
                }
            )
    }

    override fun getSortModes() {
        view?.showProgressBar()
        disposables += interactor.getSortModes()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                { response ->
                    view?.hideProgressBar()
                    view?.showSortModeSelector(response)
                },
                { error ->
                    Timber.e(error)
                    view?.hideProgressBar()
                    view?.showSnackbar(resourceManager.getInternetError())
                }
            )
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    override fun setup() {
        prefs.clear()
    }

    override fun onSortModeSelected(sortModeId: Int, items: MutableList<HotelModel>) {
        prefs.saveSortMode(sortModeId)
        view?.submitHotelsItems(sortItems(sortModeId, items))
    }

    private fun sortItems(sortModeId: Int, items: MutableList<HotelModel>): List<HotelModel> {
        //todo added sort
        return mutableListOf()
    }
}