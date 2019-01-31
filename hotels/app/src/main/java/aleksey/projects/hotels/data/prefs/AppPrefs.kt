package aleksey.projects.hotels.data.prefs

import android.content.Context

private const val PREF_APP_CONFIG = "app_config"

class AppPrefs(context: Context) {

    private val sharedPreferences = context.getSharedPreferences(PREF_APP_CONFIG, Context.MODE_PRIVATE)

    fun clear() {
        sharedPreferences.edit().clear().apply()
    }

}