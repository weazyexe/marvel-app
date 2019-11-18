package exe.weazy.marvelapp.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity
data class Comics (
    @SerializedName("id")
    @PrimaryKey
    val id: Int,

    @SerializedName("title")
    val title : String,

    @SerializedName("description")
    val description : String?,

    @SerializedName("thumbnail")
    val image : Thumbnail
)