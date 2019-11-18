package exe.weazy.marvelapp.network

import com.google.gson.annotations.SerializedName
import exe.weazy.marvelapp.model.Comics

data class ComicsResponse(
    @SerializedName("data")
    val data: ComicsDataResponse
)

data class ComicsDataResponse(
    @SerializedName("results")
    val comics: List<Comics>
)