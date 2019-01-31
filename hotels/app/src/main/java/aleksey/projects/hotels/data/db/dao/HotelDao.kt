package aleksey.projects.hotels.data.db.dao

import aleksey.projects.hotels.data.db.entity.Hotel
import android.arch.persistence.room.*
import io.reactivex.Single

private const val TABLE_NAME = "hotel"

@Dao
interface HotelDao {

    @Query("SELECT * FROM $TABLE_NAME WHERE hotelId=:id")
    fun get(id: Int): Single<Hotel>

    @Query("SELECT * FROM $TABLE_NAME")
    fun getHotels(): List<Hotel>

    @Update(onConflict = OnConflictStrategy.REPLACE)
    fun update(hotel: Hotel)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(hotel: Hotel)

    @Delete
    fun delete(hotel: Hotel)

    @Query("DELETE FROM $TABLE_NAME")
    fun deleteAll()

}