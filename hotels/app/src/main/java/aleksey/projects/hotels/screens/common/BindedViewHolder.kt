package aleksey.projects.hotels.screens.common

import android.support.v7.widget.RecyclerView
import android.view.View

abstract class BindedViewHolder<in T>(view: View) : RecyclerView.ViewHolder(view) {
    abstract fun bind(data: T)
}