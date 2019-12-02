package exe.weazy.marvelapp.network

import com.google.gson.annotations.SerializedName
import exe.weazy.marvelapp.model.Creator

data class CreatorsResponse(
    @SerializedName("data")
    val data : CreatorsDataResponse
)

data class CreatorsDataResponse(
    @SerializedName("results")
    val creators : List<Creator>
)