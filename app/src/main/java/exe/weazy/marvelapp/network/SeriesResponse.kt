package exe.weazy.marvelapp.network

import com.google.gson.annotations.SerializedName
import exe.weazy.marvelapp.model.Series

data class SeriesResponse(
    @SerializedName("data")
    val data: SeriesDataResponse
)

data class SeriesDataResponse(
    @SerializedName("results")
    val series: List<Series>
)