package aleksey.projects.hotels.screens.hotel_list.adapter

import aleksey.projects.hotels.R
import aleksey.projects.hotels.extensions.inflate
import aleksey.projects.hotels.helper.GlideHelper
import aleksey.projects.hotels.screens.common.BindedViewHolder
import aleksey.projects.hotels.screens.common.OnItemClickListener
import aleksey.projects.hotels.screens.hotel_list.models.HotelModel
import android.content.Context
import android.support.transition.TransitionManager
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView

class HotelsAdapter(val context: Context) : RecyclerView.Adapter<HotelsAdapter.HotelsViewHolder>() {

    private var items: MutableList<HotelModel> = mutableListOf()
    var listener: OnItemClickListener<HotelModel>? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HotelsViewHolder {
        val view = parent.inflate(R.layout.item_hotel)
        view.layoutParams =
                ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)
        return HotelsViewHolder(view)
    }

    override fun onBindViewHolder(holder: HotelsViewHolder, position: Int) {
        holder.bind(items[position])
        holder.setOnClickListener {
            listener?.onClick(items[position])
        }
    }

    override fun getItemCount(): Int = items.size

    fun setItems(items: MutableList<HotelModel>) {
        this.items = items
        notifyDataSetChanged()
    }

    inner class HotelsViewHolder(view: View) : BindedViewHolder<HotelModel>(view) {
        private val container: FrameLayout = view.findViewById<View>(R.id.container) as FrameLayout
        private val name: TextView = view.findViewById<View>(R.id.name) as TextView
        private val imageHotel: ImageView = view.findViewById<View>(R.id.image_hotel) as ImageView
        private val address: TextView = view.findViewById<View>(R.id.address) as TextView
        private val stars: TextView = view.findViewById<View>(R.id.stars) as TextView
        private val suitesAvailability: TextView = view.findViewById<View>(R.id.suites_availability) as TextView
        private val expandImage: ImageView = view.findViewById<View>(R.id.expand_image) as ImageView
        private val expandInfo: LinearLayout = view.findViewById<View>(R.id.expand_info) as LinearLayout

        private var isClickOnExpandImage = false

        override fun bind(data: HotelModel) {
            TransitionManager.beginDelayedTransition(container)
            name.text = data.name
            address.text = data.address
            stars.text = data.stars.toString()
            suitesAvailability.text = data.suitesAvailability

            GlideHelper.with(itemView)
                .load(data.mainImage)
                .error(R.drawable.ic_broken_image)
                .into(imageHotel)

            expandImage.setOnClickListener {
                if (isClickOnExpandImage) {
                    isClickOnExpandImage = false
                    expandInfo.visibility = View.GONE
                    expandImage.setImageResource(R.drawable.ic_expand_more)
                } else {
                    isClickOnExpandImage = true
                    expandInfo.visibility = View.VISIBLE
                    expandImage.setImageResource(R.drawable.ic_expand_less)
                }

            }
        }

        fun setOnClickListener(callback: () -> Unit) {
            imageHotel.setOnClickListener {
                callback()
            }
        }

    }
}