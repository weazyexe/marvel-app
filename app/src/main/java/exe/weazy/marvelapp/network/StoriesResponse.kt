package exe.weazy.marvelapp.network

import com.google.gson.annotations.SerializedName
import exe.weazy.marvelapp.model.Story

data class StoriesResponse(
    @SerializedName("data")
    val data: StoriesDataResponse
)

data class StoriesDataResponse(
    @SerializedName("results")
    val stories: List<Story>
)