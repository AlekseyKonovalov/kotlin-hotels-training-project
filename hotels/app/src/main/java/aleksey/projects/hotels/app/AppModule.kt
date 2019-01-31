package aleksey.projects.hotels.app

import aleksey.projects.hotels.data.api.ApiModule
import aleksey.projects.hotels.data.db.DbModule
import aleksey.projects.hotels.data.prefs.PrefsModule
import aleksey.projects.hotels.di.PerApplication
import android.content.Context
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient

@Module(
    includes = [
        (ApiModule::class),
        (PrefsModule::class),
        (DbModule::class)
    ])
class AppModule {

    @PerApplication
    @Provides
    fun provideApplicationContext(app: App): Context = app.applicationContext

    @Provides
    @PerApplication
    fun provideGlideInitTasks(context: Context, okHttpClient: OkHttpClient): InitGlideTask {
        return InitGlideTask(context, okHttpClient)
    }

}