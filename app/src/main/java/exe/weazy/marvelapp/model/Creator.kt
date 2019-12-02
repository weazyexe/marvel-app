package exe.weazy.marvelapp.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity
data class Creator(
    @SerializedName("id")
    @PrimaryKey
    val id : Int,

    @SerializedName("fullName")
    val fullName : String,

    @SerializedName("thumbnail")
    val image: Thumbnail
)