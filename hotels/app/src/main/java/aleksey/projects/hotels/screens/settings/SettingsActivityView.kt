package aleksey.projects.hotels.screens.settings

import aleksey.projects.hotels.R
import aleksey.projects.hotels.screens.common.BaseView
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.design.widget.CoordinatorLayout
import android.support.v7.widget.Toolbar
import android.widget.Switch
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

fun startSettingsActivity(context: Context) {
    val intent = Intent(context, SettingsActivity::class.java)
    context.startActivity(intent)
}

interface SettingsActivityView : BaseView {

}

class SettingsActivity : DaggerAppCompatActivity(), SettingsActivityView {

    @Inject
    lateinit var presenter: SettingsActivityPresenter
    private lateinit var root: CoordinatorLayout
    private lateinit var toolbar: Toolbar
    private lateinit var useInternetSwitch: Switch

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)

        initViews()
        initListeners()
        initToolbar()
    }

    override fun initToolbar() {
        toolbar.title = "Settings"
    }

    override fun initViews() {
        root = findViewById(R.id.root)
        toolbar = findViewById(R.id.toolbar)
        useInternetSwitch = findViewById(R.id.use_internet)
    }

    override fun initListeners() {
        useInternetSwitch.setOnCheckedChangeListener { _, isChecked ->
            presenter.setUseInternetMode(isChecked)
        }
    }

}