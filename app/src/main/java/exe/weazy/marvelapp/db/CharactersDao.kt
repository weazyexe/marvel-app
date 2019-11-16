package exe.weazy.marvelapp.db

import androidx.paging.DataSource
import androidx.room.*
import exe.weazy.marvelapp.model.Character


@Dao
interface CharactersDao {

    @Query("SELECT * FROM character ORDER BY name ASC")
    fun getAll(): DataSource.Factory<Int, Character>

    @Query("SELECT * FROM character WHERE id = :id")
    fun getById(id: Int): Character?

    @Query("SELECT * FROM character ORDER BY name ASC LIMIT :limit OFFSET :offset")
    fun getByLimitAndOffset(offset : Int, limit: Int) : DataSource.Factory<Int, Character>

    @Insert
    fun insert(character: Character)

    @Update
    fun update(character: Character)

    @Delete
    fun delete(character: Character)

    @Query("DELETE FROM character")
    fun nukeTable()
}