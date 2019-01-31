package aleksey.projects.hotels.screens.hotel_list

import aleksey.projects.hotels.R
import aleksey.projects.hotels.extensions.defaultConfig
import aleksey.projects.hotels.screens.common.BaseView
import aleksey.projects.hotels.screens.hotel_list.models.Hotel
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.design.widget.CoordinatorLayout
import android.support.design.widget.Snackbar
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

fun startHotelListActivity(context: Context) {
    val intent = Intent(context, HotelListActivity::class.java)
    context.startActivity(intent)
}

interface HotelListActivityView : BaseView {
    fun submitHotelsItems(items: List<Hotel>)
    fun showSnackbar(message: String)
}

class HotelListActivity : DaggerAppCompatActivity(), HotelListActivityView {

    @Inject
    lateinit var presenter: HotelListActivityPresenter

    private lateinit var root: CoordinatorLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.hotel_list)
    }

    override fun initToolbar() {

    }

    override fun initViews() {
        root = findViewById(R.id.root)
    }

    override fun initListeners() {

    }

    override fun showSnackbar(message: String) {
        val snack = Snackbar.make(root, message, Snackbar.LENGTH_LONG)
        snack.defaultConfig(this@HotelListActivity)
        snack.show()
    }

    override fun submitHotelsItems(items: List<Hotel>) {

    }


}
