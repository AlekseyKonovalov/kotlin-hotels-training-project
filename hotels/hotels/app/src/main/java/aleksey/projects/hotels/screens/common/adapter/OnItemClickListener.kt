package aleksey.projects.hotels.screens.common.adapter

interface OnItemClickListener<in D, in V> {
    fun onItemClick(position: Int, view: V, data: D)
}