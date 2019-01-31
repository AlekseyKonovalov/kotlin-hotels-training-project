package aleksey.projects.hotels.data.db

import aleksey.projects.hotels.di.PerApplication
import android.arch.persistence.room.Room
import android.content.Context
import dagger.Module
import dagger.Provides

const val DB_NAME = "app_db"

@Module
class DbModule {

    @PerApplication
    @Provides
    fun provideDbRepository(context: Context, dbMigration: DbMigration): AppDatabase {
        return Room.databaseBuilder(context, AppDatabase::class.java, DB_NAME)
                //.addMigrations(dbMigration.MIGRATION_1_2)
                .build()
    }

    @Provides
    fun provideDbMigration(): DbMigration {
        return DbMigration()
    }

}