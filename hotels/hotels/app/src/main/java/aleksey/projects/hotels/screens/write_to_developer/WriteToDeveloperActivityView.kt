package aleksey.projects.hotels.screens.write_to_developer

import aleksey.projects.hotels.R
import aleksey.projects.hotels.screens.common.BaseView
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.design.widget.CoordinatorLayout
import android.widget.Toolbar
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
    private lateinit var root: CoordinatorLayout
    private lateinit var toolbar: Toolbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_write_to_develop)

        initViews()
        initListeners()
        initToolbar()
    }

    override fun initToolbar() {
        toolbar.title = "Write to developer"
    }

    override fun initViews() {
        root = findViewById(R.id.root)
        toolbar = findViewById(R.id.toolbar)

    }

    override fun initListeners() {

    }

}