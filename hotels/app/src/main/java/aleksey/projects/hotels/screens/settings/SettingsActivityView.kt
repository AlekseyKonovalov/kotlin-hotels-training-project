package aleksey.projects.hotels.screens.settings

import aleksey.projects.hotels.R
import aleksey.projects.hotels.screens.common.BaseView
import android.content.Context
import android.content.Intent
import android.os.Bundle
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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)

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