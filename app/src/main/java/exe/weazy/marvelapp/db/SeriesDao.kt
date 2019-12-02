package exe.weazy.marvelapp.db

import androidx.paging.DataSource
import androidx.room.*
import exe.weazy.marvelapp.model.Series

@Dao
interface SeriesDao {

    @Query("SELECT * FROM series ORDER BY title ASC")
    fun getAll(): DataSource.Factory<Int, Series>

    @Query("SELECT * FROM series WHERE id = :id")
    fun getById(id: Int): Series?

    @Query("SELECT * FROM series ORDER BY title ASC LIMIT :limit OFFSET :offset")
    fun getByLimitAndOffset(offset : Int, limit: Int) : DataSource.Factory<Int, Series>

    @Insert
    fun insert(series: Series)

    @Update
    fun update(series: Series)

    @Delete
    fun delete(series: Series)

    @Query("DELETE FROM series")
    fun nukeTable()
}