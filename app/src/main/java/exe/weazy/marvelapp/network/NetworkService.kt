package exe.weazy.marvelapp.network

import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface NetworkService {

    @GET("characters")
    fun fetchCharacters(@Query("apikey") apiKey : String,
                        @Query("ts") timestamp : Long,
                        @Query("hash") hash : String,
                        @Query("offset") offset : Int,
                        @Query("limit") limit: Int) : Observable<CharactersResponse>

    @GET("comics")
    fun fetchComics(@Query("apikey") apiKey : String,
                    @Query("ts") timestamp : Long,
                    @Query("hash") hash : String,
                    @Query("offset") offset : Int,
                    @Query("limit") limit: Int,
                    @Query("orderBy") orderBy : String = "title") : Observable<ComicsResponse>

    @GET("creators")
    fun fetchCreators(@Query("apikey") apiKey : String,
                    @Query("ts") timestamp : Long,
                    @Query("hash") hash : String,
                    @Query("offset") offset : Int,
                    @Query("limit") limit: Int,
                    @Query("orderBy") orderBy : String = "firstName") : Observable<CreatorsResponse>

    @GET("events")
    fun fetchEvents(@Query("apikey") apiKey : String,
                      @Query("ts") timestamp : Long,
                      @Query("hash") hash : String,
                      @Query("offset") offset : Int,
                      @Query("limit") limit: Int) : Observable<EventsResponse>

    @GET("series")
    fun fetchSeries(@Query("apikey") apiKey : String,
                    @Query("ts") timestamp : Long,
                    @Query("hash") hash : String,
                    @Query("offset") offset : Int,
                    @Query("limit") limit: Int) : Observable<SeriesResponse>

    @GET("stories")
    fun fetchStories(@Query("apikey") apiKey : String,
                    @Query("ts") timestamp : Long,
                    @Query("hash") hash : String,
                    @Query("offset") offset : Int,
                    @Query("limit") limit: Int) : Observable<StoriesResponse>
}