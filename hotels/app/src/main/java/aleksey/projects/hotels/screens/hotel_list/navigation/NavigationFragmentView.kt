package aleksey.projects.hotels.screens.hotel_list.navigation

import aleksey.projects.hotels.R
import aleksey.projects.hotels.screens.about_app.startAboutAppActivity
import aleksey.projects.hotels.screens.common.BaseView
import aleksey.projects.hotels.screens.settings.startSettingsActivity
import aleksey.projects.hotels.screens.write_to_developer.startWriteToDeveloperActivity
import android.content.Context
import android.os.Bundle
import android.support.design.widget.BottomSheetDialogFragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import dagger.android.support.AndroidSupportInjection
import javax.inject.Inject

interface NavigationFragmentView : BaseView {
}

class NavigationFragment : BottomSheetDialogFragment(), NavigationFragmentView {

    @Inject
    lateinit var presenter: NavigationFragmentPresenter

    private lateinit var itemSettings: TextView
    private lateinit var itemWriteToDeveloper: TextView
    private lateinit var itemAboutApp: TextView

    override fun onAttach(context: Context?) {
        AndroidSupportInjection.inject(this)
        super.onAttach(context)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.bottom_navigation_menu, container, false)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
        initListeners()
    }


    override fun initToolbar() {

    }

    override fun initViews() {
        view?.let {
            itemSettings = it.findViewById(R.id.item_settings)
            itemWriteToDeveloper = it.findViewById(R.id.item_write_to_developer)
            itemAboutApp = it.findViewById(R.id.item_about_application)
        }
    }

    override fun initListeners() {
        itemSettings.setOnClickListener {
            startSettingsActivity(requireContext())
        }
        itemWriteToDeveloper.setOnClickListener {
            startWriteToDeveloperActivity(requireContext())
        }
        itemAboutApp.setOnClickListener {
            startAboutAppActivity(requireContext())
        }
    }

}