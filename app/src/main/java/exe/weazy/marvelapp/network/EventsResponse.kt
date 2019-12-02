package exe.weazy.marvelapp.network

import com.google.gson.annotations.SerializedName
import exe.weazy.marvelapp.model.Event

data class EventsResponse(
    @SerializedName("data")
    val data: EventsDataResponse
)

data class EventsDataResponse(
    @SerializedName("results")
    val events: List<Event>
)