package aleksey.projects.hotels.screens.write_to_developer

import aleksey.projects.hotels.R
import aleksey.projects.hotels.screens.common.BaseView
import android.content.Context
import android.content.Intent
import android.os.Bundle
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

fun startWriteToDeveloperActivity(context: Context) {
    val intent = Intent(context, WriteToDeveloperActivity::class.java)
    context.startActivity(intent)
}

interface WriteToDeveloperActivityView : BaseView {

}

class WriteToDeveloperActivity : DaggerAppCompatActivity(), WriteToDeveloperActivityView {

    @Inject
    lateinit var presenter: WriteToDeveloperActivityPresenter

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