package aleksey.projects.hotels.data.api

import aleksey.projects.hotels.di.PerApplication
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import timber.log.Timber

const val API_ENDPOINT = "https://raw.githubusercontent.com/AlekseyKonovalov/kotlin-hotels-training-project/master/api/"

@Module
class ApiModule {

    @PerApplication
    @Provides
    fun provideClient(logging: HttpLoggingInterceptor): OkHttpClient {
        return OkHttpClient.Builder()
            .addNetworkInterceptor(logging)
            .build()
    }

    @PerApplication
    @Provides
    fun provideHttpLoggingInterceptor(): HttpLoggingInterceptor {
        val logging = HttpLoggingInterceptor(HttpLoggingInterceptor.Logger { message ->
            Timber.d(message)
        })
        logging.level = HttpLoggingInterceptor.Level.BODY
        return logging
    }

    @PerApplication
    @Provides
    fun provideGson(): Gson {
        return GsonBuilder().create()
    }

    @PerApplication
    @Provides
    fun provideRetrofit(client: OkHttpClient, gson: Gson): Retrofit {
        return Retrofit.Builder()
            .baseUrl(API_ENDPOINT)
            .client(client)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
    }

    @PerApplication
    @Provides
    fun provideApi(retrofit: Retrofit): Api {
        return retrofit.create(Api::class.java)
    }


}