package exe.weazy.marvelapp.model

import com.google.gson.annotations.SerializedName
import exe.weazy.marvelapp.util.DEFAULT_CHARACTER_IMAGE_SIZE

data class Thumbnail(
    @SerializedName("path")
    val path : String,

    @SerializedName("extension")
    val extension : String
) {
    fun fullPath() : String {
        val p = if (path.last() == '/') path else "${path}/"
        return "${p}${DEFAULT_CHARACTER_IMAGE_SIZE}${extension}"
    }
}