package aleksey.projects.hotels.screens.hotel_information

import aleksey.projects.hotels.data.api.Api
import aleksey.projects.hotels.data.db.AppDatabase
import aleksey.projects.hotels.screens.hotel_list.models.HotelModel
import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers

interface HotelInformationActivityInteractor{
    fun loadHotelInfo(hotelId: Int): Observable<HotelModel>
}

class HotelInformationActivityInteractorImpl(val api: Api, val db: AppDatabase) : HotelInformationActivityInteractor{
    override fun loadHotelInfo(hotelId: Int): Observable<HotelModel> {
        return api.getHotelInformation(hotelId)
            .subscribeOn(Schedulers.io())
    }
}