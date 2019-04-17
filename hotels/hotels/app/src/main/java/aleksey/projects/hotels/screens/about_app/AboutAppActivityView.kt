package aleksey.projects.hotels.screens.about_app

import aleksey.projects.hotels.R
import aleksey.projects.hotels.screens.common.BaseView
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.design.widget.CoordinatorLayout
import android.widget.Toolbar
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
    private lateinit var root: CoordinatorLayout
    private lateinit var toolbar: Toolbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about_app)

        initViews()
        initListeners()
        initToolbar()
    }

    override fun initToolbar() {
        toolbar.title = "About app"
    }

    override fun initViews() {
        root = findViewById(R.id.root)
        toolbar = findViewById(R.id.toolbar)
    }

    override fun initListeners() {

    }

}