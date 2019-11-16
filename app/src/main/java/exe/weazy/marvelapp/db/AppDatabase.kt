package exe.weazy.marvelapp.db

import androidx.room.Database
import androidx.room.RoomDatabase
import exe.weazy.marvelapp.model.Character

@Database(entities = [Character::class], version = 5)
abstract class AppDatabase : RoomDatabase() {

    abstract fun charactersDao() : CharactersDao
}