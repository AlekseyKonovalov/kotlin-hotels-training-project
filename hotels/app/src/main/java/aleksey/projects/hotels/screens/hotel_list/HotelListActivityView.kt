package aleksey.projects.hotels.screens.hotel_list

import aleksey.projects.hotels.R
import aleksey.projects.hotels.screens.common.BaseView
import android.content.Context
import android.content.Intent
import android.os.Bundle
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

fun startHotelListActivity(context: Context) {
    val intent = Intent(context, HotelListActivity::class.java)
    context.startActivity(intent)
}

interface HotelListActivityView: BaseView {

}

class HotelListActivity : DaggerAppCompatActivity(), HotelListActivityView {

    @Inject
    lateinit var presenter: HotelListActivityPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.hotel_list)
    }

    override fun initToolbar() {

    }

    override fun initViews() {

    }

    override fun initListeners() {

    }


}
