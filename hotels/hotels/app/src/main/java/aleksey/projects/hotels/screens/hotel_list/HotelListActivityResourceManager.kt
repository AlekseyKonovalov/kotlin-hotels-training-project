package aleksey.projects.hotels.screens.hotel_list

import aleksey.projects.hotels.R
import android.content.res.Resources

interface HotelListActivityResourceManager {
    fun getInternetError(): String
}

class HotelListActivityResourceManagerImpl(val resources: Resources) : HotelListActivityResourceManager {
    override fun getInternetError(): String {
        return resources.getString(R.string.internet_error)
    }
}