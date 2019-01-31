package aleksey.projects.hotels.extensions

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

fun ViewGroup.inflate(resId: Int, attach: Boolean = false): View {
    return LayoutInflater.from(context).inflate(resId, this, attach)
}