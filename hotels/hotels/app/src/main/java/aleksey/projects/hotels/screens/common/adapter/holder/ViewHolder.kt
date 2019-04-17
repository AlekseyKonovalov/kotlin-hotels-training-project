package aleksey.projects.hotels.screens.common.adapter.holder

import android.support.v7.widget.RecyclerView
import android.view.View

class ViewHolder<in D, V>(var view: V) : RecyclerView.ViewHolder(view) where V : View, V: ViewHolder.Binder<D> {

    interface Binder<in D> {
        fun bind(data: D)
    }

}