package exe.weazy.marvelapp.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Story(
    @PrimaryKey
    val id: Int,

    val title: String,

    val description: String?
)