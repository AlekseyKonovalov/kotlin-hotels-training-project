package aleksey.projects.hotels.view

import aleksey.projects.hotels.R
import aleksey.projects.hotels.extensions.inflate
import android.support.v4.content.ContextCompat
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout

class ProgressOverlay(root: ViewGroup) {

    val content: View = root.inflate(R.layout.progress_overlay)

    init {
        content.alpha = 1f
        content.visibility = View.GONE
        val targetParent: ViewGroup = findSuitableParent(root)
                ?: throw IllegalArgumentException("No suitable parent found from the given view. " + "Please provide a valid view.")

        targetParent.addView(content, targetParent.childCount)
    }

    fun show(isShadowed: Boolean? = false) {
        isShadowed?.let { shadowed ->
            if (shadowed) {
                content.rootView.context?.let { context ->
                    content.background = ContextCompat.getDrawable(context, R.color.progress_background_gray)
                }
            }
        }
        content.visibility = View.VISIBLE
    }

    fun hide() {
        content.rootView.context?.let { context ->
            content.background = ContextCompat.getDrawable(context, R.color.progress_background)
        }
        content.visibility = View.GONE
    }

    private fun findSuitableParent(view: View?): ViewGroup? {
        @Suppress("NAME_SHADOWING")
        var view = view
        var fallback: ViewGroup? = null
        do {
            if (view is FrameLayout) {
                if (view.id == android.R.id.content) {
                    // If we've hit the decor content view, then we didn't find a CoL in the
                    // hierarchy, so use it.
                    return view
                } else {
                    // It's not the content view but we'll use it as our fallback
                    fallback = view
                }
            }

            if (view != null) {
                // Else, we will loop and crawl up the view hierarchy and try to find a parent
                val parent = view.parent
                view = if (parent is View) parent else null
            }
        } while (view != null)

        // If we reach here then we didn't find a CoL or a suitable content view so we'll fallback
        return fallback
    }
}