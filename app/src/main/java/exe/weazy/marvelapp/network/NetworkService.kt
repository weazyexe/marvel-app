package exe.weazy.marvelapp.network

import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface NetworkService {

    @GET("comics")
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
                    @Query("limit") limit: Int) : Observable<ComicsResponse>
}