package aleksey.projects.hotels.screens.hotel_information.contact_hotel

import aleksey.projects.hotels.R
import aleksey.projects.hotels.screens.common.BaseView
import aleksey.projects.hotels.screens.hotel_information.HotelInformationActivity
import android.os.Bundle
import android.support.design.widget.CoordinatorLayout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import dagger.android.support.DaggerFragment
import javax.inject.Inject

interface ContactHotelFragmentView : BaseView {
    fun setView(address: String, phone: String)
}

class ContactHotelFragment : DaggerFragment(), ContactHotelFragmentView {
    @Inject
    lateinit var presenter: ContactHotelFragmentPresenter

    private lateinit var root: CoordinatorLayout
    private lateinit var addressView: TextView
    private lateinit var phoneView: TextView

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        root = inflater.inflate(R.layout.fragment_contact_hotel, container, false) as CoordinatorLayout
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initToolbar()
        initViews()
        initListeners()
        presenter.getContacts((activity as HotelInformationActivity).hotelId.toString())
    }

    override fun initToolbar() {

    }

    override fun initViews() {
        view?.let {
            addressView = it.findViewById(R.id.hotel_address)
            phoneView = it.findViewById(R.id.hotel_phone)
        }
    }

    override fun initListeners() {

    }

    override fun setView(address: String, phone: String) {
        addressView.text = address
        phoneView.text = phone
    }


}