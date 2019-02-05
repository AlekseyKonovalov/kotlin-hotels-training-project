package aleksey.projects.hotels.screens.hotel_list.models

import com.google.gson.annotations.SerializedName

data class HotelModel(
    @SerializedName("id") var hotelId: Int,
    @SerializedName("name") var name: String,
    @SerializedName("address") var address: String,
    @SerializedName("stars") var stars: Int,
    @SerializedName("distance") var distance: Double?,
    @SerializedName("suites_availability") var suitesAvailability: Int?,
    @SerializedName("main_image") var mainImage: String?,
    @SerializedName("images") var images: List<String>?,
    @SerializedName("contacts") var contacts: String?,
    @SerializedName("phone") var phone: String?
)