package aleksey.projects.hotels.screens.hotel_information.contact_hotel

import aleksey.projects.hotels.R
import aleksey.projects.hotels.screens.common.BaseView
import android.os.Bundle
import android.support.design.widget.CoordinatorLayout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import dagger.android.support.DaggerFragment
import javax.inject.Inject

interface ContactHotelFragmentView : BaseView {

}

class ContactHotelFragment : DaggerFragment(), ContactHotelFragmentView {
    @Inject
    lateinit var presenter: ContactHotelFragmentPresenter

    private lateinit var root: CoordinatorLayout

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_contact_hotel, root, false)
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