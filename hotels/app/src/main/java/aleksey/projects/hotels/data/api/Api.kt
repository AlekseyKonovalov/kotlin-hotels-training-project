package aleksey.projects.hotels.data.api

import aleksey.projects.hotels.screens.hotel_list.models.Hotel
import io.reactivex.Observable
import retrofit2.http.GET

interface Api {
    @GET("HotelList")
    fun getHotelList(): Observable<List<Hotel>>
}