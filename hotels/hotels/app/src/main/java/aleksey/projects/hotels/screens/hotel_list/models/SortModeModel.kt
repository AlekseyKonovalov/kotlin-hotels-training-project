package aleksey.projects.hotels.screens.hotel_list.models

import com.google.gson.annotations.SerializedName

data class SortModeModel(
    @SerializedName("id") var id: Int,
    @SerializedName("name") var name: String,
    @SerializedName("isCurrentSortMode") var isCurrentSortMode: Boolean
)