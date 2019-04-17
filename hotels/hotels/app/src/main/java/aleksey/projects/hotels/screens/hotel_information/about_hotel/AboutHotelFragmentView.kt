package aleksey.projects.hotels.screens.hotel_information.about_hotel

import aleksey.projects.hotels.R
import aleksey.projects.hotels.screens.common.BaseView
import android.os.Bundle
import android.support.design.widget.CoordinatorLayout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import dagger.android.support.DaggerFragment
import javax.inject.Inject

interface AboutHotelFragmentView : BaseView {

}

class AboutHotelFragment : DaggerFragment(), AboutHotelFragmentView {
    @Inject
    lateinit var presenter:  AboutHotelFragmentPresenter

    private lateinit var root: CoordinatorLayout

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        root = inflater.inflate(R.layout.fragment_about_hotel, container, false) as CoordinatorLayout
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initToolbar()
        initViews()
        initListeners()
    }

    override fun initToolbar() {

    }

    override fun initViews() {

    }

    override fun initListeners() {

    }


}