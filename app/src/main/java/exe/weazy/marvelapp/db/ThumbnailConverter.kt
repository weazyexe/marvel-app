package exe.weazy.marvelapp.db

import androidx.room.TypeConverter
import exe.weazy.marvelapp.model.Thumbnail
import exe.weazy.marvelapp.util.DEFAULT_STANDARD_IMAGE_SIZE

class ThumbnailConverter {

    @TypeConverter
    fun thumbnailToString(thumbnail: Thumbnail) = thumbnail.fullStandardPath()

    @TypeConverter
    fun stringToThumbnail(string: String) : Thumbnail {
        val splitted = string.split(DEFAULT_STANDARD_IMAGE_SIZE)
        return Thumbnail(path = splitted[0], extension = splitted[1])
    }
}