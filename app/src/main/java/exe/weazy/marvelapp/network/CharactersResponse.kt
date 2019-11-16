package exe.weazy.marvelapp.network

import com.google.gson.annotations.SerializedName
import exe.weazy.marvelapp.model.Character

data class CharactersResponse(
    @SerializedName("data")
    val data: CharactersDataResponse
)

data class CharactersDataResponse(
    @SerializedName("results")
    val characters: List<Character>
)