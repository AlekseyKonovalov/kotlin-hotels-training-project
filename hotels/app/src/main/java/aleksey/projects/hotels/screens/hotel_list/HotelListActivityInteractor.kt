package aleksey.projects.hotels.screens.hotel_list

import aleksey.projects.hotels.data.api.Api
import aleksey.projects.hotels.data.db.AppDatabase
import aleksey.projects.hotels.data.db.entity.Hotel
import aleksey.projects.hotels.screens.hotel_list.models.HotelModel
import aleksey.projects.hotels.screens.hotel_list.models.SortModeModel
import io.reactivex.Completable
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

interface HotelListActivityInteractor {
    fun getHotels(): Observable<List<HotelModel>>
    fun getSortModes(): Observable<List<SortModeModel>>
    fun setHotelsInDB(hotel: Hotel)
    fun getHotelsFromDB(): Observable<List<Hotel>>
}

class HotelListActivityInteractorImpl(val api: Api, val db: AppDatabase) : HotelListActivityInteractor {
    override fun getHotels(): Observable<List<HotelModel>> {
        return api.getHotelList()
                .subscribeOn(Schedulers.io())
    }

    override fun getSortModes(): Observable<List<SortModeModel>> {
        return api.getSortModes()
                .subscribeOn(Schedulers.io())
    }

    override fun setHotelsInDB(hotel: Hotel) {
        Completable.fromCallable { db.hotelDao().insert(hotel) }
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe()
    }

    override fun getHotelsFromDB(): Observable<List<Hotel>> {
        return Observable.fromCallable { db.hotelDao().getHotels() }
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
    }
}