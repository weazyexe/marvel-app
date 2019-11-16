package exe.weazy.marvelapp.network

import com.google.gson.annotations.SerializedName
import exe.weazy.marvelapp.model.Character

data class HeroesResponse(
    @SerializedName("data")
    val data: HeroesDataResponse
)

data class HeroesDataResponse(
    @SerializedName("results")
    val characters: List<Character>
)