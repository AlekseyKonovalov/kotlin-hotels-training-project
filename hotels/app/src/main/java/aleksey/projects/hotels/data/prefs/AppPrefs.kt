package aleksey.projects.hotels.data.prefs

import android.content.Context

private const val PREF_APP_CONFIG = "app_config"
private const val PREF_SORT_MODE = "sort_mode"
private const val PREF_USE_INTERNET = "use_internet"

class AppPrefs(context: Context) {

    private val sharedPreferences = context.getSharedPreferences(PREF_APP_CONFIG, Context.MODE_PRIVATE)

    fun clear() {
        sharedPreferences.edit().clear().apply()
    }

    fun saveSortMode(sortMode: Int) {
        sharedPreferences.edit()
                .putInt(PREF_SORT_MODE, sortMode)
                .apply()
    }

    fun getSortMode(): Int {
        return sharedPreferences.getInt(PREF_SORT_MODE, -1)
    }

    fun removeSortMode() {
        sharedPreferences.edit().remove(PREF_SORT_MODE).apply()
    }


    fun saveUseInternetMode(mode: Boolean) {
        sharedPreferences.edit()
                .putBoolean(PREF_USE_INTERNET, mode)
                .apply()
    }

    fun getUseInternetMode(): Boolean {
        return sharedPreferences.getBoolean(PREF_USE_INTERNET, true)
    }

    fun removeUseInternetMode() {
        sharedPreferences.edit().remove(PREF_USE_INTERNET).apply()
    }

}