package aleksey.projects.hotels.screens.hotel_list.models

import com.google.gson.annotations.SerializedName

data class HotelModel(
        @SerializedName("id") var hotelId: String,
        @SerializedName("name") var name: String,
        @SerializedName("address") var address: String,
        @SerializedName("stars") var stars: Int,
        @SerializedName("distance") var distance: Double?,
        @SerializedName("suites_availability") var suitesAvailability: String?,
        @SerializedName("main_image") var mainImage: String?,
        @SerializedName("description") var description: String?,
        @SerializedName("images") var images: List<String>? = emptyList(),
        @SerializedName("contacts") var contacts: String? = "",
        @SerializedName("phone") var phone: String? = ""
)