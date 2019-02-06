package aleksey.projects.hotels.screens.hotel_list

import aleksey.projects.hotels.R
import aleksey.projects.hotels.extensions.defaultConfig
import aleksey.projects.hotels.screens.common.BaseView
import aleksey.projects.hotels.screens.common.OnItemClickListener
import aleksey.projects.hotels.screens.hotel_information.startHotelInformationActivity
import aleksey.projects.hotels.screens.hotel_list.adapter.HotelsAdapter
import aleksey.projects.hotels.screens.hotel_list.models.HotelModel
import aleksey.projects.hotels.screens.hotel_list.navigation.NavigationFragment
import aleksey.projects.hotels.view.ProgressOverlay
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.design.bottomappbar.BottomAppBar
import android.support.design.widget.CoordinatorLayout
import android.support.design.widget.Snackbar
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

fun startHotelListActivity(context: Context) {
    val intent = Intent(context, HotelListActivity::class.java)
    context.startActivity(intent)
}

interface HotelListActivityView : BaseView {
    fun submitHotelsItems(items: List<HotelModel>)
    fun showSnackbar(message: String)
    fun showProgressBar()
    fun hideProgressBar()
}

private const val TAG_BOTTOM_NAVIGATION_FRAGMENT = "bottom_navigation_menu"

class HotelListActivity : DaggerAppCompatActivity(), HotelListActivityView {

    @Inject
    lateinit var presenter: HotelListActivityPresenter
    private lateinit var hotelsAdapter: HotelsAdapter

    private lateinit var root: CoordinatorLayout
    private lateinit var bottomAppBar: BottomAppBar
    private lateinit var hotelsRecyclerView: RecyclerView
    private lateinit var hotelsLayoutManager: RecyclerView.LayoutManager

    private val progressOverlay: ProgressOverlay by lazy {
        ProgressOverlay(this.root)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hotel_list)

        initViews()
        initListeners()
        initToolbar()
        presenter.loadHotels()
    }

    override fun initToolbar() {

    }

    override fun initViews() {
        root = findViewById(R.id.root)
        hotelsRecyclerView = findViewById(R.id.hotels_recycler_view)
        bottomAppBar = findViewById(R.id.bottom_app_bar)
        bottomAppBar.inflateMenu(R.menu.hotel_list_bottom_app_bar)

        hotelsLayoutManager = LinearLayoutManager(this@HotelListActivity)
        hotelsRecyclerView.layoutManager = hotelsLayoutManager
        hotelsAdapter = HotelsAdapter(this@HotelListActivity)
        hotelsRecyclerView.adapter = hotelsAdapter
    }

    override fun initListeners() {
        hotelsAdapter.listener = object : OnItemClickListener<HotelModel> {
            override fun onClick(data: HotelModel) {
                startHotelInformationActivity(this@HotelListActivity, data.hotelId)
            }
        }

        bottomAppBar.setNavigationOnClickListener {
            NavigationFragment().show(supportFragmentManager, TAG_BOTTOM_NAVIGATION_FRAGMENT)
        }

        bottomAppBar.setOnMenuItemClickListener { menuItem ->
            /*            when (menuItem.itemId) {
                            R.id.item_search ->
                            R.id.item_sort ->
                            R.id.item_more_vert ->
                        }*/
            return@setOnMenuItemClickListener true
        }
    }

    override fun showSnackbar(message: String) {
        val snack = Snackbar.make(root, message, Snackbar.LENGTH_LONG)
        snack.defaultConfig(this@HotelListActivity)
        snack.show()
    }

    override fun submitHotelsItems(items: List<HotelModel>) {
        hotelsAdapter.setItems(items)
    }

    override fun showProgressBar() {
        progressOverlay.show()
    }

    override fun hideProgressBar() {
        progressOverlay.hide()
    }

}
