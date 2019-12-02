package exe.weazy.marvelapp.db

import androidx.paging.DataSource
import androidx.room.*
import exe.weazy.marvelapp.model.Creator

@Dao
interface CreatorsDao {

    @Query("SELECT * FROM creator ORDER BY fullName ASC")
    fun getAll(): DataSource.Factory<Int, Creator>

    @Query("SELECT * FROM creator WHERE id = :id")
    fun getById(id: Int): Creator?

    @Query("SELECT * FROM creator ORDER BY fullName ASC LIMIT :limit OFFSET :offset")
    fun getByLimitAndOffset(offset : Int, limit: Int) : DataSource.Factory<Int, Creator>

    @Insert
    fun insert(creator: Creator)

    @Update
    fun update(creator: Creator)

    @Delete
    fun delete(creator: Creator)

    @Query("DELETE FROM creator")
    fun nukeTable()
}