package aleksey.projects.hotels.screens.hotel_information

import aleksey.projects.hotels.R
import aleksey.projects.hotels.extensions.defaultConfig
import aleksey.projects.hotels.screens.common.BaseView
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.design.widget.CoordinatorLayout
import android.support.design.widget.Snackbar
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

    private var hotelId: Int? = null

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

    }

    override fun initViews() {

    }

    override fun initListeners() {

    }


    override fun showProgressBar() {

    }

    override fun hideProgressBar() {

    }

    override fun showSnackbar(message: String) {
        val snack = Snackbar.make(root, message, Snackbar.LENGTH_LONG)
        snack.defaultConfig(this@HotelInformationActivity)
        snack.show()
    }

}