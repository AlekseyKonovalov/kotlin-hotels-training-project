package aleksey.projects.hotels.extensions

import aleksey.projects.hotels.R
import android.content.Context
import android.graphics.Color
import android.support.design.widget.Snackbar
import android.support.v4.view.ViewCompat
import android.view.ViewGroup
import android.widget.TextView

fun Snackbar.defaultConfig(context: Context, addFabMargin: Boolean = false, addButtonMargin: Boolean = false) {
    val params = this.view.layoutParams as ViewGroup.MarginLayoutParams
    var bottomMargin = params.bottomMargin
    if (addFabMargin) {
        bottomMargin += 288
    }
    if (addButtonMargin) {
        bottomMargin += 224
    }
    params.setMargins(params.leftMargin + 8,
        params.topMargin,
        params.rightMargin + 8,
        bottomMargin)
    this.view.layoutParams = params
    this.view.background = context.getDrawable(R.drawable.snackbar_drawable)
    this.view.findViewById<TextView>(android.support.design.R.id.snackbar_text).setTextColor(Color.WHITE)
    ViewCompat.setElevation(this.view, 6f)
}
