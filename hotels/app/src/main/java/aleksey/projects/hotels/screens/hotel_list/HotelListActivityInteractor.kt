package aleksey.projects.hotels.screens.hotel_list

import aleksey.projects.hotels.data.api.Api
import aleksey.projects.hotels.data.db.AppDatabase
import aleksey.projects.hotels.screens.hotel_list.models.HotelModel
import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers

interface HotelListActivityInteractor {
    fun getHotels(): Observable<List<HotelModel>>
}

class HotelListActivityInteractorImpl(val api: Api, val db: AppDatabase) : HotelListActivityInteractor {
    override fun getHotels(): Observable<List<HotelModel>> {
        return api.getHotelList()
            .subscribeOn(Schedulers.io())
    }
}