package aleksey.projects.hotels.data.db.entity

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity
data class Hotel(
    @PrimaryKey
    @ColumnInfo
    var hotelId: Int,
    @ColumnInfo
    var name: String,
    @ColumnInfo
    var address: String,
    @ColumnInfo
    var stars: Int,
    @ColumnInfo
    var distance: Double?,
    @ColumnInfo
    var suitesAvailability: Int?,
    @ColumnInfo
    var mainImage: String?
)