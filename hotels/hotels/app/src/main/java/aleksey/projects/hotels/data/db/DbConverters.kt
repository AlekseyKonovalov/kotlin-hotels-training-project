package aleksey.projects.hotels.data.db

import android.arch.persistence.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.util.*

class DbConverters {

    private val gson = Gson()

    @TypeConverter
    fun fromTimestamp(value: Long?): Date? {
        return if (value == null) null else Date(value)
    }

    @TypeConverter
    fun dateToTimestamp(date: Date?): Long? {
        return date?.time
    }

    @TypeConverter
    fun fromMutableListString(values: MutableList<String>?): String? {
        if (values == null) {
            return null
        }
        val type = object : TypeToken<MutableList<String>>() {}.type
        return gson.toJson(values, type)
    }

    @TypeConverter
    fun stringToMutableListString(values: String?): MutableList<String>? {
        if (values == null) {
            return null
        }
        val type = object : TypeToken<MutableList<String>>() {

        }.type
        return gson.fromJson(values, type)
    }

    @TypeConverter
    fun fromPairIntStr(value: Pair<Int, String>?): String? {
        if (value == null) {
            return null
        }
        val type = object : TypeToken<Pair<Int, String>>() {}.type
        return gson.toJson(value, type)
    }

    @TypeConverter
    fun stringToPairIntStr(value: String?): Pair<Int, String>? {
        if (value == null) {
            return null
        }
        val type = object : TypeToken<Pair<Int, String>>() {

        }.type
        return gson.fromJson(value, type)
    }

    @TypeConverter
    fun fromPairStrStr(value: Pair<String, String>?): String? {
        if (value == null) {
            return null
        }
        val type = object : TypeToken<Pair<String, String>>() {}.type
        return gson.toJson(value, type)
    }

    @TypeConverter
    fun stringToPairStrStr(value: String?): Pair<String, String>? {
        if (value == null) {
            return null
        }
        val type = object : TypeToken<Pair<String, String>>() {

        }.type
        return gson.fromJson(value, type)
    }

    @TypeConverter
    fun fromPairDblDbl(value: Pair<Double, Double>?): String? {
        if (value == null) {
            return null
        }
        val type = object : TypeToken<Pair<Double, Double>>() {}.type
        return gson.toJson(value, type)
    }

    @TypeConverter
    fun stringToPairDblDbl(value: String?): Pair<Double, Double>? {
        if (value == null) {
            return null
        }
        val type = object : TypeToken<Pair<Double, Double>>() {

        }.type
        return gson.fromJson(value, type)
    }

    @TypeConverter
    fun fromListPair(values: List<Pair<Int, String>>?): String? {
        if (values == null) {
            return null
        }
        val type = object : TypeToken<List<Pair<Int, String>>>() {}.type
        return gson.toJson(values, type)
    }

    @TypeConverter
    fun stringToListPair(values: String?): List<Pair<Int, String>>? {
        if (values == null) {
            return null
        }
        val type = object : TypeToken<List<Pair<Int, String>>>() {

        }.type
        return gson.fromJson(values, type)
    }

    @TypeConverter
    fun fromListTriple(values: List<Triple<Int, String, String>>?): String? {
        if (values == null) {
            return null
        }
        val type = object : TypeToken<List<Triple<Int, String, String>>>() {}.type
        return gson.toJson(values, type)
    }

    @TypeConverter
    fun stringToListTriple(values: String?): List<Triple<Int, String, String>>? {
        if (values == null) {
            return null
        }
        val type = object : TypeToken<List<Triple<Int, String, String>>>() {

        }.type
        return gson.fromJson(values, type)
    }

    @TypeConverter
    fun fromListInt(values: List<Int>?): String? {
        if (values == null) {
            return null
        }
        val type = object : TypeToken<List<Int>>() {}.type
        return gson.toJson(values, type)
    }

    @TypeConverter
    fun stringToListInt(values: String?): List<Int>? {
        if (values == null) {
            return null
        }
        val type = object : TypeToken<List<Int>>() {

        }.type
        return gson.fromJson(values, type)
    }

}