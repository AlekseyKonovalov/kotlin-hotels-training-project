package aleksey.projects.hotels.screens.about_app

import aleksey.projects.hotels.R
import aleksey.projects.hotels.screens.common.BaseView
import android.content.Context
import android.content.Intent
import android.os.Bundle
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

fun startAboutAppActivity(context: Context) {
    val intent = Intent(context, AboutAppActivity::class.java)
    context.startActivity(intent)
}

interface  AboutAppActivityView: BaseView{

}

class AboutAppActivity: DaggerAppCompatActivity(), AboutAppActivityView{

    @Inject
    lateinit var presenter: AboutAppActivityPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about_app)

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

}