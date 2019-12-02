package exe.weazy.marvelapp.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import exe.weazy.marvelapp.model.Character
import exe.weazy.marvelapp.model.Comics
import exe.weazy.marvelapp.model.Creator

@Database(entities = [Character::class, Comics::class, Creator::class], version = 5)
@TypeConverters(ThumbnailConverter::class)
abstract class AppDatabase : RoomDatabase() {

    abstract fun charactersDao() : CharactersDao

    abstract fun comicsDao() : ComicsDao

    abstract fun creatorsDao() : CreatorsDao
}