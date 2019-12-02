package exe.weazy.marvelapp.db

import androidx.paging.DataSource
import androidx.room.*
import exe.weazy.marvelapp.model.Event

@Dao
interface EventsDao {
    @Query("SELECT * FROM event ORDER BY title ASC")
    fun getAll(): DataSource.Factory<Int, Event>

    @Query("SELECT * FROM event WHERE id = :id")
    fun getById(id: Int): Event?

    @Query("SELECT * FROM event ORDER BY title ASC LIMIT :limit OFFSET :offset")
    fun getByLimitAndOffset(offset : Int, limit: Int) : DataSource.Factory<Int, Event>

    @Insert
    fun insert(event: Event)

    @Update
    fun update(event: Event)

    @Delete
    fun delete(event: Event)

    @Query("DELETE FROM event")
    fun nukeTable()
}