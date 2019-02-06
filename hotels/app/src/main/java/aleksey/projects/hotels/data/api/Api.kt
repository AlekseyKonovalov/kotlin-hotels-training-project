package aleksey.projects.hotels.data.api

import aleksey.projects.hotels.screens.hotel_list.models.HotelModel
import aleksey.projects.hotels.screens.hotel_list.models.SortModeModel
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path

interface Api {
    @GET("HotelList")
    fun getHotelList(): Observable<List<HotelModel>>

    @GET("{hotel_id}")
    fun getHotelInformation(@Path(value = "hotel_id", encoded = true) hotelId: Int): Observable<HotelModel>

    @GET("SortModes")
    fun getSortModes(): Observable<List<SortModeModel>>
}