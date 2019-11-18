package exe.weazy.marvelapp.db

import androidx.paging.DataSource
import androidx.room.*
import exe.weazy.marvelapp.model.Comics

@Dao
interface ComicsDao {

    @Query("SELECT * FROM comics ORDER BY title ASC")
    fun getAll(): DataSource.Factory<Int, Comics>

    @Query("SELECT * FROM comics WHERE id = :id")
    fun getById(id: Int): Comics?

    @Query("SELECT * FROM comics ORDER BY title ASC LIMIT :limit OFFSET :offset")
    fun getByLimitAndOffset(offset : Int, limit: Int) : DataSource.Factory<Int, Comics>

    @Insert
    fun insert(comics: Comics)

    @Update
    fun update(comics: Comics)

    @Delete
    fun delete(comics: Comics)

    @Query("DELETE FROM Comics")
    fun nukeTable()
}