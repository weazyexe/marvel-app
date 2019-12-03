package exe.weazy.marvelapp.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity
data class Series(
    @PrimaryKey
    val id: Int,

    val title: String,

    val description : String?,

    @SerializedName("thumbnail")
    val image: Thumbnail
)