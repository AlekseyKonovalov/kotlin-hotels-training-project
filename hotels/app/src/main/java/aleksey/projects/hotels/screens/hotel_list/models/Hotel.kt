package aleksey.projects.hotels.screens.hotel_list.models

import com.google.gson.annotations.SerializedName

data class Hotel(
    @SerializedName("id") var hotelId: Int,
    @SerializedName("name") var name: String,
    @SerializedName("address") var address: String,
    @SerializedName("stars") var stars: Int,
    @SerializedName("distance") var distance: Double?,
    @SerializedName("suites_availability") var suitesAvailability: Int?
)