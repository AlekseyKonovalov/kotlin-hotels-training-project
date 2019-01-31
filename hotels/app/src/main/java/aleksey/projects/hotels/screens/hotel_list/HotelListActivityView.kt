package aleksey.projects.hotels.screens.hotel_list

import aleksey.projects.hotels.R
import aleksey.projects.hotels.extensions.defaultConfig
import aleksey.projects.hotels.screens.common.BaseView
import aleksey.projects.hotels.screens.hotel_list.adapter.HotelsAdapter
import aleksey.projects.hotels.screens.hotel_list.models.HotelModel
import aleksey.projects.hotels.view.ProgressOverlay
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.design.widget.CoordinatorLayout
import android.support.design.widget.Snackbar
import android.support.v7.widget.RecyclerView
import dagger.android.support.DaggerAppCompatActivity
import kotlinx.android.synthetic.main.activity_hotel_list.*
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

class HotelListActivity : DaggerAppCompatActivity(), HotelListActivityView {

    @Inject
    lateinit var presenter: HotelListActivityPresenter
    private lateinit var hotelsAdapter: HotelsAdapter

    private lateinit var root: CoordinatorLayout
    private lateinit var hotelsRecyclerView: RecyclerView

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
        toolbar.title = "Hotels"
        setSupportActionBar(toolbar)
    }

    override fun initViews() {
        root = findViewById(R.id.root)
        hotelsRecyclerView = findViewById(R.id.hotels_recycler_view)

        hotelsAdapter = HotelsAdapter(this@HotelListActivity)
        hotelsRecyclerView.adapter = hotelsAdapter
    }

    override fun initListeners() {

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
