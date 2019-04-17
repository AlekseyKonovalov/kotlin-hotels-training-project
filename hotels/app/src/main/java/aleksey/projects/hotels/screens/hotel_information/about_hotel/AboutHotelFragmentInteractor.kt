package aleksey.projects.hotels.screens.hotel_information.about_hotel

import aleksey.projects.hotels.data.api.Api
import aleksey.projects.hotels.data.db.AppDatabase
import aleksey.projects.hotels.screens.hotel_list.models.HotelModel
import io.reactivex.Observable

interface AboutHotelFragmentInteractor {
    fun getHotelInfo(hotelId: String): Observable<HotelModel>
}

class AboutHotelFragmentInteractorImpl(val api: Api, val db: AppDatabase) : AboutHotelFragmentInteractor {
    override fun getHotelInfo(hotelId: String): Observable<HotelModel> {
        return api.getHotelInformation(hotelId)
    }

}