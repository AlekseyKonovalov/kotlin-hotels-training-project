package aleksey.projects.hotels.screens.hotel_list.adapter

import aleksey.projects.hotels.R
import aleksey.projects.hotels.extensions.inflate
import aleksey.projects.hotels.screens.common.BindedViewHolder
import aleksey.projects.hotels.screens.common.OnItemClickListener
import aleksey.projects.hotels.screens.hotel_list.HotelListActivity
import aleksey.projects.hotels.screens.hotel_list.models.SortModeModel
import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton

class SortModeAdapter(val context: Context) : RecyclerView.Adapter<SortModeAdapter.SortModeViewHolder>() {

    private var items: MutableList<SortModeModel> = mutableListOf()
    var dialogItemClickListener: OnItemClickListener<SortModeModel>? = null
    private var currentSortMode: Int? = null

    fun setItems(inputItems: MutableList<SortModeModel>) {
        items = inputItems
    }

    override fun onCreateViewHolder(parent: ViewGroup, position: Int): SortModeViewHolder {
        val view = parent.inflate(R.layout.item_sort_mode)
        view.layoutParams =
                ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)
        return SortModeViewHolder(view)
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: SortModeViewHolder, position: Int) {
        holder.bind(items[position])
        holder.setClickListener {
            dialogItemClickListener?.onClick(items[position])
        }
    }

    inner class SortModeViewHolder(val view: View) : BindedViewHolder<SortModeModel>(view) {
        private val radioButton: RadioButton = view.findViewById<View>(R.id.choice_sort_mode) as RadioButton
        override fun bind(data: SortModeModel) {
            radioButton.text = data.name
            radioButton.isChecked = false

            (view.context as? HotelListActivity)?.appPrefs?.getSortMode()?.let {
                if (it >= 0) {
                    currentSortMode = it
                }
            }

            currentSortMode?.let {
                if (currentSortMode == data.id) {
                    radioButton.isChecked = true
                }
            } ?: run {
                radioButton.isChecked = data.isCurrentSortMode
            }
        }

        fun setClickListener(callback: () -> Unit) {
            radioButton.setOnClickListener {
                callback()
            }
        }
    }

}