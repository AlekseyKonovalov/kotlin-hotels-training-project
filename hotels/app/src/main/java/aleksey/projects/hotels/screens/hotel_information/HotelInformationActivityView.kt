package aleksey.projects.hotels.screens.hotel_information

import aleksey.projects.hotels.R
import aleksey.projects.hotels.extensions.defaultConfig
import aleksey.projects.hotels.helper.GlideHelper
import aleksey.projects.hotels.screens.common.BaseView
import aleksey.projects.hotels.screens.hotel_list.models.HotelModel
import aleksey.projects.hotels.view.ProgressOverlay
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.design.widget.CoordinatorLayout
import android.support.design.widget.Snackbar
import android.support.design.widget.TabLayout
import android.support.v4.view.ViewPager
import android.support.v7.widget.Toolbar
import android.widget.ImageView
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
    fun setViews(hotelModel: HotelModel)
}

class HotelInformationActivity : DaggerAppCompatActivity(), HotelInformationActivityView {

    @Inject
    lateinit var presenter: HotelInformationActivityPresenter

    private lateinit var root: CoordinatorLayout
    private  lateinit var toolbar: Toolbar

    private lateinit var tabsPager: ViewPager
    private lateinit var tabLayout: TabLayout
    private  lateinit var mainImage: ImageView

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

        hotelId?.let {  presenter.loadHotelInfo(it) }
    }


    override fun initToolbar() {
        toolbar.title = ""
        setSupportActionBar(toolbar)
        toolbar.setNavigationOnClickListener {
            finish()
        }
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

    }

    override fun initViews() {
        root = findViewById(R.id.root)
        toolbar = findViewById(R.id.toolbar)
        tabsPager = findViewById(R.id.tabs_pager)
        tabLayout = findViewById(R.id.tab_layout)
        mainImage = findViewById(R.id.main_image)

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

    override fun setViews(hotelModel: HotelModel) {
        toolbar.title = hotelModel.name

        GlideHelper.with(this@HotelInformationActivity)
            .load(hotelModel.mainImage)
            .error(R.drawable.ic_image_placeholder)
            .into(mainImage)
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