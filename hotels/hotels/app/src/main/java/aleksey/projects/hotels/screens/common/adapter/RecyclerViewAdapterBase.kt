package aleksey.projects.hotels.screens.common.adapter

import aleksey.projects.hotels.screens.common.adapter.holder.ViewHolder
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup

abstract class RecyclerViewAdapterBase<D, V> : RecyclerView.Adapter<ViewHolder<D, V>>() where V : View, V : ViewHolder.Binder<D> {

    private val items = ArrayList<D>()
    private var listener: OnItemClickListener<D, V>? = null

    fun setOnItemClickListener(listener: OnItemClickListener<D, V>) {
        this.listener = listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder<D, V> {
        return ViewHolder(onCreateItemView(parent, viewType))
    }

    protected abstract fun onCreateItemView(parent: ViewGroup, viewType: Int): V

    override fun onBindViewHolder(viewHolder: ViewHolder<D, V>, position: Int) {
        val view = viewHolder.view
        val data = items[position]
        view.bind(data)
        view.setOnClickListener {
            listener?.onItemClick(position, view, data)
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

    fun add(item: D) {
        items.add(item)
        notifyItemInserted(items.count())
    }

    fun removeAt(position: Int) {
        items.removeAt(position)
        notifyItemRemoved(position)
    }

    fun addAll(collection: List<D>) {
        items.addAll(collection)
        notifyDataSetChanged()
    }

    fun replaceAll(collection: List<D>) {
        items.clear()
        items.addAll(collection)
        notifyDataSetChanged()
    }

    fun clear() {
        items.clear()
        notifyDataSetChanged()
    }

    fun getItems(): List<D> {
        return items
    }

    interface OnItemClickListener<in D, in V> {
        fun onItemClick(position: Int, view: V, data: D)
    }

}