package aleksey.projects.hotels.screens.hotel_information.contact_hotel

import aleksey.projects.hotels.data.api.Api
import aleksey.projects.hotels.data.db.AppDatabase
import aleksey.projects.hotels.screens.hotel_list.models.HotelModel
import io.reactivex.Observable

interface ContactHotelFragmentInteractor {
    fun getHotelInfo(hotelId: String): Observable<HotelModel>
}

class ContactHotelFragmentInteractorImpl(val api: Api, val db: AppDatabase) : ContactHotelFragmentInteractor {
    override fun getHotelInfo(hotelId: String): Observable<HotelModel> {
        return api.getHotelInformation(hotelId)
    }
}