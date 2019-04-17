package aleksey.projects.hotels.app

import aleksey.projects.hotels.helper.GlideHelper
import android.content.Context
import com.bumptech.glide.integration.okhttp3.OkHttpUrlLoader
import com.bumptech.glide.load.model.GlideUrl
import okhttp3.OkHttpClient
import java.io.InputStream

class InitGlideTask(private val context: Context, private val okHttpClient: OkHttpClient) {
    fun init() {
        GlideHelper.get(context).registry.replace(GlideUrl::class.java, InputStream::class.java, OkHttpUrlLoader.Factory(okHttpClient))
    }
}