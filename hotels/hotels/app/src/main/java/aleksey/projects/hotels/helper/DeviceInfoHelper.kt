package aleksey.projects.hotels.helper

import aleksey.projects.hotels.BuildConfig
import android.annotation.SuppressLint
import android.content.Context
import android.os.Build
import android.provider.Settings
import java.util.*

interface DeviceInfoHelper {

    fun getDeviceId(): String
    fun getDeviceModel(): String
    fun getOSTypeId(): Int
    fun getOSVersion(): String
    fun getRandomUID(): String
    fun getAppVersionCode(): Int
    fun getAppVersionName(): String

}

class DeviceInfoHelperImpl(val context: Context) : DeviceInfoHelper {


    @SuppressLint("HardwareIds")
    override fun getDeviceId(): String {
        return Settings.Secure.getString(context.contentResolver, Settings.Secure.ANDROID_ID)
    }

    override fun getDeviceModel(): String {
        return "Android"
    }

    override fun getOSTypeId(): Int {
        return 1
    }

    override fun getOSVersion(): String {
        return Build.VERSION.RELEASE
    }

    override fun getRandomUID(): String {
        return UUID.randomUUID().toString()
    }

    override fun getAppVersionCode(): Int {
        return BuildConfig.VERSION_CODE
    }

    override fun getAppVersionName(): String {
        return BuildConfig.VERSION_NAME
    }

}