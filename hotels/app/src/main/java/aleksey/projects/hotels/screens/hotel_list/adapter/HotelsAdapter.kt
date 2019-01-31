package aleksey.projects.hotels.screens.hotel_list.adapter

import aleksey.projects.hotels.R
import aleksey.projects.hotels.extensions.inflate
import aleksey.projects.hotels.helper.GlideHelper
import aleksey.projects.hotels.screens.common.BindedViewHolder
import aleksey.projects.hotels.screens.hotel_list.models.HotelModel
import android.support.design.card.MaterialCardView
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView

class HotelsAdapter : RecyclerView.Adapter<HotelsAdapter.HotelsViewHolder>() {

    private var items: MutableList<HotelModel> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, position: Int): HotelsViewHolder {
        val view = parent.inflate(R.layout.item_hotel)
        view.layoutParams =
                ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)
        return HotelsViewHolder(view)
    }

    override fun onBindViewHolder(holder: HotelsViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int = items.size

    fun setItems(items: List<HotelModel>) {
        this.items.addAll(items)
        notifyDataSetChanged()
    }

    inner class HotelsViewHolder(val view: View) : BindedViewHolder<HotelModel>(view) {

        val card: MaterialCardView = view.findViewById<View>(R.id.card_container) as MaterialCardView

        val name: TextView = view.findViewById<View>(R.id.name) as TextView
        val address: TextView = view.findViewById<View>(R.id.address) as TextView

        val imageHotel: ImageView = view.findViewById<View>(R.id.image_hotel) as ImageView



        override fun bind(data: HotelModel) {
            name.text = data.name
            address.text = data.address

            GlideHelper.with(view)
                .load(data.mainImage)
                .error(R.drawable.ic_image_placeholder)
                .into(imageHotel)

        }

    }
}