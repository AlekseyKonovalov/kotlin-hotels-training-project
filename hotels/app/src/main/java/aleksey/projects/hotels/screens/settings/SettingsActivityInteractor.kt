package aleksey.projects.hotels.screens.settings

import aleksey.projects.hotels.data.api.Api
import aleksey.projects.hotels.data.db.AppDatabase
import aleksey.projects.hotels.data.prefs.AppPrefs


interface SettingsActivityInteractor {
    fun setUseInternetMode(isUseInternetMode: Boolean)
}

class SettingsActivityInteractorImpl(val api: Api, val db: AppDatabase, val prefs: AppPrefs) : SettingsActivityInteractor {
    override fun setUseInternetMode(isUseInternetMode: Boolean) {
        prefs.saveUseInternetMode(isUseInternetMode)
    }
}