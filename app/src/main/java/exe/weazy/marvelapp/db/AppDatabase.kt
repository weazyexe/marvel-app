package exe.weazy.marvelapp.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import exe.weazy.marvelapp.model.*

@Database(entities = [Character::class, Comics::class, Creator::class, Event::class, Series::class, Story::class], version = 5)
@TypeConverters(ThumbnailConverter::class)
abstract class AppDatabase : RoomDatabase() {

    abstract fun charactersDao() : CharactersDao

    abstract fun comicsDao() : ComicsDao

    abstract fun creatorsDao() : CreatorsDao

    abstract fun eventsDao() : EventsDao

    abstract fun seriesDao() : SeriesDao

    abstract fun storiesDao() : StoriesDao
}