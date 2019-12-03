package exe.weazy.marvelapp.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity
data class Creator(
    @PrimaryKey
    val id : Int,

    val fullName : String,

    @SerializedName("thumbnail")
    val image: Thumbnail
)