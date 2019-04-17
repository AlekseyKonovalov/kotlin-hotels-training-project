package aleksey.projects.hotels.data.prefs

import aleksey.projects.hotels.di.PerApplication
import android.content.Context
import dagger.Module
import dagger.Provides

@Module
class PrefsModule {

    @PerApplication
    @Provides
    fun providePrefs(context: Context): AppPrefs {
        return AppPrefs(context)
    }

}