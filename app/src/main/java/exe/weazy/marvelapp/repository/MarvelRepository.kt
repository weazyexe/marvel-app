package exe.weazy.marvelapp.repository

import androidx.paging.DataSource
import exe.weazy.marvelapp.db.AppDatabase
import exe.weazy.marvelapp.db.CharactersDao
import exe.weazy.marvelapp.network.NetworkService
import exe.weazy.marvelapp.util.App
import exe.weazy.marvelapp.util.toMD5
import io.reactivex.Observable
import retrofit2.Retrofit
import java.util.*
import javax.inject.Inject
import javax.inject.Named
import exe.weazy.marvelapp.model.Character

class MarvelRepository {

    @Inject
    lateinit var retrofit: Retrofit

    @Inject
    @field:Named("publicApiKey")
    lateinit var publicApiKey : String

    @Inject
    @field:Named("privateApiKey")
    lateinit var privateApiKey : String

    @Inject
    lateinit var database : AppDatabase

    private val dao : CharactersDao

    private var service: NetworkService


    init {
        App.getComponent().inject(this)
        dao = database.charactersDao()
        service = retrofit.create(NetworkService::class.java)
    }

    fun fetchCharactersFromNetwork(offset : Int, limit: Int) : Observable<List<Character>> {
        val ts = Date().time
        val hash = "${ts}${privateApiKey}${publicApiKey}".toMD5()

        return service.fetchHeroes(apiKey = publicApiKey, timestamp = ts, hash = hash, offset = offset, limit = limit)
            .map { it.data.characters }
    }

    fun getCacheDataSource() : DataSource.Factory<Int, Character> {
        return dao.getAll()
    }

    fun writeCharactersToCache(characters: List<Character>) {
        characters.forEach {
            if (dao.getById(it.id) != null) {
                dao.update(it)
            } else {
                dao.insert(it)
            }
        }
    }
}