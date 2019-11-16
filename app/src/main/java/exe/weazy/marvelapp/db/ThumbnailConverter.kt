package exe.weazy.marvelapp.db

import androidx.room.TypeConverter
import exe.weazy.marvelapp.model.Thumbnail
import exe.weazy.marvelapp.util.DEFAULT_CHARACTER_IMAGE_SIZE

class ThumbnailConverter {

    @TypeConverter
    fun thumbnailToString(thumbnail: Thumbnail) = thumbnail.fullPath()

    @TypeConverter
    fun stringToThumbnail(string: String) : Thumbnail {
        val splitted = string.split(DEFAULT_CHARACTER_IMAGE_SIZE)
        return Thumbnail(path = splitted[0], extension = splitted[1])
    }
}