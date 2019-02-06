package aleksey.projects.hotels.screens.about_app

import aleksey.projects.hotels.screens.common.BaseView
import dagger.android.support.DaggerAppCompatActivity

interface  AboutAppActivityView: BaseView{

}

class AboutAppActivity: DaggerAppCompatActivity(), AboutAppActivityView{
    override fun initToolbar() {

    }

    override fun initViews() {

    }

    override fun initListeners() {

    }

}