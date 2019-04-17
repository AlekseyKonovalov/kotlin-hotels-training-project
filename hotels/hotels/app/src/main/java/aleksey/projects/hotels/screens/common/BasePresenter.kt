package aleksey.projects.hotels.screens.common


interface BasePresenter<in V : BaseView> {

    fun attachView(view: V)

    fun detachView()

}