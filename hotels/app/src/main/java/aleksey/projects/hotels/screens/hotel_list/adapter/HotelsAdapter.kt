package aleksey.projects.hotels.screens.hotel_list.adapter

import aleksey.projects.hotels.R
import aleksey.projects.hotels.extensions.inflate
import aleksey.projects.hotels.helper.GlideHelper
import aleksey.projects.hotels.screens.common.BindedViewHolder
import aleksey.projects.hotels.screens.hotel_information.startHotelInformationActivity
import aleksey.projects.hotels.screens.hotel_list.models.HotelModel
import android.content.Context
import android.support.design.card.MaterialCardView
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView

class HotelsAdapter(val context: Context) : RecyclerView.Adapter<HotelsAdapter.HotelsViewHolder>() {

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

        private val card: MaterialCardView = view.findViewById<View>(R.id.card_container) as MaterialCardView

        private val name: TextView = view.findViewById<View>(R.id.name) as TextView
        private val address: TextView = view.findViewById<View>(R.id.address) as TextView

        private val imageHotel: ImageView = view.findViewById<View>(R.id.image_hotel) as ImageView

        private val zeroStars: LinearLayout = view.findViewById<View>(R.id.zero_stars) as LinearLayout
        private val oneStars: LinearLayout = view.findViewById<View>(R.id.one_stars) as LinearLayout
        private val twoStars: LinearLayout = view.findViewById<View>(R.id.two_stars) as LinearLayout
        private val threeStars: LinearLayout = view.findViewById<View>(R.id.three_stars) as LinearLayout
        private val fourStars: LinearLayout = view.findViewById<View>(R.id.four_stars) as LinearLayout
        private val fiveStars: LinearLayout = view.findViewById<View>(R.id.five_stars) as LinearLayout

        override fun bind(data: HotelModel) {
            name.text = data.name
            address.text = data.address

            GlideHelper.with(view)
                .load(data.mainImage)
                .error(R.drawable.ic_image_placeholder)
                .into(imageHotel)

            setStarsView(data)

            card.setOnClickListener {
                startHotelInformationActivity(context, items[position].hotelId)
            }
        }

        private fun setStarsView(data: HotelModel) {
            zeroStars.visibility = View.GONE
            oneStars.visibility = View.GONE
            twoStars.visibility = View.GONE
            threeStars.visibility = View.GONE
            fourStars.visibility = View.GONE
            fiveStars.visibility = View.GONE

            when (data.stars) {
                0 -> {
                    zeroStars.visibility = View.VISIBLE
                }
                1 -> {
                    oneStars.visibility = View.VISIBLE
                }
                2 -> {
                    twoStars.visibility = View.VISIBLE
                }
                3 -> {
                    threeStars.visibility = View.VISIBLE
                }
                4 -> {
                    fourStars.visibility = View.VISIBLE
                }
                5 -> {
                    fiveStars.visibility = View.VISIBLE
                }
            }
        }

    }
}