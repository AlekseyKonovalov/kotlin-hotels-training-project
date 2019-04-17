package aleksey.projects.hotels.screens.hotel_list

import aleksey.projects.hotels.R
import aleksey.projects.hotels.data.prefs.AppPrefs
import aleksey.projects.hotels.extensions.defaultConfig
import aleksey.projects.hotels.screens.common.BaseView
import aleksey.projects.hotels.screens.common.OnItemClickListener
import aleksey.projects.hotels.screens.hotel_information.startHotelInformationActivity
import aleksey.projects.hotels.screens.hotel_list.adapter.HotelsAdapter
import aleksey.projects.hotels.screens.hotel_list.adapter.SortModeAdapter
import aleksey.projects.hotels.screens.hotel_list.models.HotelModel
import aleksey.projects.hotels.screens.hotel_list.models.SortModeModel
import aleksey.projects.hotels.screens.hotel_list.navigation.NavigationFragment
import aleksey.projects.hotels.view.ProgressOverlay
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.design.bottomappbar.BottomAppBar
import android.support.design.widget.BottomSheetDialog
import android.support.design.widget.CoordinatorLayout
import android.support.design.widget.Snackbar
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.widget.ImageView
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
    fun showSortModeSelector(params: List<SortModeModel>)
}

private const val TAG_BOTTOM_NAVIGATION_FRAGMENT = "bottom_navigation_menu"

class HotelListActivity : DaggerAppCompatActivity(), HotelListActivityView {

    @Inject
    lateinit var presenter: HotelListActivityPresenter
    @Inject
    lateinit var appPrefs: AppPrefs

    private lateinit var hotelsAdapter: HotelsAdapter

    private lateinit var root: CoordinatorLayout
    private lateinit var bottomAppBar: BottomAppBar
    private lateinit var hotelsRecyclerView: RecyclerView
    private lateinit var hotelsLayoutManager: RecyclerView.LayoutManager

    private var currentHotelList: MutableList<HotelModel> = mutableListOf()

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
            when (menuItem.itemId) {
                R.id.item_sort -> presenter.getSortModes()
                /*     R.id.item_more_vert -> showSortModeSelector() // todo*/
            }
            return@setOnMenuItemClickListener true
        }
    }


    override fun showSortModeSelector(params: List<SortModeModel>) {
        val view = LayoutInflater.from(this@HotelListActivity).inflate(R.layout.bottom_sheet_sort_modes, null)
        val dialog = BottomSheetDialog(this@HotelListActivity)

        val dialogItems = view.findViewById(R.id.items) as RecyclerView
        val dialogCloseButton = view.findViewById(R.id.close) as ImageView
        dialogCloseButton.setOnClickListener {
            dialog.dismiss()
        }
        val dialogItemsAdapter = SortModeAdapter(this@HotelListActivity)
        dialogItems.adapter = dialogItemsAdapter

        dialogItemsAdapter.setItems(params.toMutableList())
        dialogItemsAdapter.dialogItemClickListener = object : OnItemClickListener<SortModeModel> {
            override fun onClick(item: SortModeModel) {
                presenter.onSortModeSelected(item.id, currentHotelList)
                dialog.dismiss()
            }
        }
        dialog.setContentView(view)
        dialog.show()

    }

    override fun showSnackbar(message: String) {
        val snack = Snackbar.make(root, message, Snackbar.LENGTH_LONG)
        snack.defaultConfig(this@HotelListActivity)
        snack.show()
    }

    override fun submitHotelsItems(items: List<HotelModel>) {
        currentHotelList = items.toMutableList()
        hotelsAdapter.setItems(items.toMutableList())
    }

    override fun showProgressBar() {
        progressOverlay.show()
    }

    override fun hideProgressBar() {
        progressOverlay.hide()
    }

}
