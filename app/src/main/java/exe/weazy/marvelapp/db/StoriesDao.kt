package exe.weazy.marvelapp.db

import androidx.paging.DataSource
import androidx.room.*
import exe.weazy.marvelapp.model.Story

@Dao
interface StoriesDao {

    @Query("SELECT * FROM story")
    fun getAll(): DataSource.Factory<Int, Story>

    @Query("SELECT * FROM story WHERE id = :id")
    fun getById(id: Int): Story?

    @Query("SELECT * FROM story ORDER BY title ASC LIMIT :limit OFFSET :offset")
    fun getByLimitAndOffset(offset : Int, limit: Int) : DataSource.Factory<Int, Story>

    @Insert
    fun insert(story: Story)

    @Update
    fun update(story: Story)

    @Delete
    fun delete(story: Story)

    @Query("DELETE FROM story")
    fun nukeTable()
}