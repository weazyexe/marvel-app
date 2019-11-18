package exe.weazy.marvelapp.model

import com.google.gson.annotations.SerializedName
import exe.weazy.marvelapp.util.DEFAULT_STANDARD_IMAGE_SIZE
import exe.weazy.marvelapp.util.DEFAULT_PORTRAIT_IMAGE_SIZE

data class Thumbnail(
    @SerializedName("path")
    val path : String,

    @SerializedName("extension")
    val extension : String
) {
    fun fullStandardPath() : String {
        val p = if (path.last() == '/') path else "${path}/"
        return "${p}${DEFAULT_STANDARD_IMAGE_SIZE}${extension}"
    }

    fun fullPortraitPath() : String {
        val p = if (path.last() == '/') path else "${path}/"
        return "${p}${DEFAULT_PORTRAIT_IMAGE_SIZE}${extension}"
    }
}