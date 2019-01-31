package aleksey.projects.hotels.screens.hotel_information

import aleksey.projects.hotels.R
import aleksey.projects.hotels.extensions.defaultConfig
import aleksey.projects.hotels.screens.common.BaseView
import aleksey.projects.hotels.view.ProgressOverlay
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.design.widget.CoordinatorLayout
import android.support.design.widget.Snackbar
import android.support.design.widget.TabLayout
import android.support.v4.view.ViewPager
import android.support.v7.widget.Toolbar
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

private const val INTENT_HOTEL_ID = "hotel_id"

fun startHotelInformationActivity(context: Context, hotelId: Int) {
    val intent = Intent(context, HotelInformationActivity::class.java)
    intent.putExtra(INTENT_HOTEL_ID, hotelId)
    context.startActivity(intent)
}

interface HotelInformationActivityView : BaseView {
    fun showProgressBar()
    fun hideProgressBar()
    fun showSnackbar(message: String)
}

class HotelInformationActivity : DaggerAppCompatActivity(), HotelInformationActivityView {

    @Inject
    lateinit var presenter: HotelInformationActivityPresenter

    private lateinit var root: CoordinatorLayout

    private lateinit var toolbar: Toolbar
    private lateinit var tabsPager: ViewPager
    private lateinit var tabLayout: TabLayout

    var hotelId: Int? = null

    private val progressOverlay: ProgressOverlay by lazy {
        ProgressOverlay(this.root)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hotel_information)

        if (intent.hasExtra(INTENT_HOTEL_ID)) {
            hotelId = intent.getIntExtra(INTENT_HOTEL_ID, -1)
        }

        initViews()
        initListeners()
        initToolbar()
    }


    override fun initToolbar() {
        toolbar.title = getString(R.string.hotel_info_toolbar)
        setSupportActionBar(toolbar)
        toolbar.setNavigationOnClickListener {
            finish()
        }
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    override fun initViews() {
        tabsPager.adapter = TabsPagerAdapter(supportFragmentManager, this@HotelInformationActivity)
        tabLayout.setupWithViewPager(tabsPager)
        tabLayout.setOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabReselected(p0: TabLayout.Tab?) {}
            override fun onTabUnselected(p0: TabLayout.Tab?) {}

            override fun onTabSelected(currentTab: TabLayout.Tab) {
                tabsPager.currentItem = currentTab.position
            }
        })
    }

    override fun initListeners() {

    }


    override fun showProgressBar() {
        progressOverlay.show()
    }

    override fun hideProgressBar() {
        progressOverlay.hide()
    }

    override fun showSnackbar(message: String) {
        val snack = Snackbar.make(root, message, Snackbar.LENGTH_LONG)
        snack.defaultConfig(this@HotelInformationActivity)
        snack.show()
    }

}