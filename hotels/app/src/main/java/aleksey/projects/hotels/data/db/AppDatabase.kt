package aleksey.projects.hotels.data.db

import aleksey.projects.hotels.data.db.dao.HotelDao
import aleksey.projects.hotels.data.db.entity.Hotel
import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import android.arch.persistence.room.TypeConverters

@Database(
    entities = [
        Hotel::class/*, Filter::class*/
    ], version = 1
)

@TypeConverters(DbConverters::class)
abstract class AppDatabase : RoomDatabase() {

    abstract fun hotelDao(): HotelDao

/*    abstract fun userDao(): UserDao   */

}