package aleksey.projects.hotels.screens.hotel_information.about_hotel

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

interface AboutHotelFragmentView : BaseView {
    fun setDescription(description: String)
}

class AboutHotelFragment : DaggerFragment(), AboutHotelFragmentView {
    @Inject
    lateinit var presenter: AboutHotelFragmentPresenter

    private lateinit var root: CoordinatorLayout
    private lateinit var descriptionView: TextView

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        root = inflater.inflate(R.layout.fragment_about_hotel, container, false) as CoordinatorLayout
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initToolbar()
        initViews()
        initListeners()
        presenter.getDescriptions((activity as HotelInformationActivity).hotelId.toString())
    }

    override fun initToolbar() {

    }

    override fun initViews() {
        view?.let {
            descriptionView = it.findViewById(R.id.hotel_description)
        }
    }

    override fun initListeners() {

    }

    override fun setDescription(description: String) {
        descriptionView.text = description
    }


}