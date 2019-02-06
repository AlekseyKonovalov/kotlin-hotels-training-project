package aleksey.projects.hotels.screens.hotel_information

import aleksey.projects.hotels.R
import aleksey.projects.hotels.screens.hotel_information.about_hotel.AboutHotelFragment
import aleksey.projects.hotels.screens.hotel_information.contact_hotel.ContactHotelFragment
import android.content.Context
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter

class TabsPagerAdapter(fragmentManager: FragmentManager, val context: Context) : FragmentPagerAdapter(fragmentManager) {

    override fun getPageTitle(position: Int): CharSequence? {
        return when (position) {
            0 -> context.getString(R.string.hotel_info_about_hotel)
            else -> context.getString(R.string.hotel_info_contact_hotel)
        }
    }

    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> AboutHotelFragment()
            1 -> ContactHotelFragment()
            else -> AboutHotelFragment()
        }
    }

    override fun getCount(): Int = 2

}