package exe.weazy.marvelapp.repository

import androidx.paging.DataSource
import exe.weazy.marvelapp.db.AppDatabase
import exe.weazy.marvelapp.db.CharactersDao
import exe.weazy.marvelapp.db.ComicsDao
import exe.weazy.marvelapp.network.NetworkService
import exe.weazy.marvelapp.util.App
import exe.weazy.marvelapp.util.toMD5
import io.reactivex.Observable
import retrofit2.Retrofit
import java.util.*
import javax.inject.Inject
import javax.inject.Named
import exe.weazy.marvelapp.model.Character
import exe.weazy.marvelapp.model.Comics

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

    private val charactersDao : CharactersDao
    private val comicsDao : ComicsDao

    private var service: NetworkService



    init {
        App.getComponent().inject(this)

        charactersDao = database.charactersDao()
        comicsDao = database.comicsDao()

        service = retrofit.create(NetworkService::class.java)
    }



    fun fetchCharactersFromNetwork(offset : Int, limit: Int) : Observable<List<Character>> {
        val pair = getTimestampAndHash()
        val ts = pair.first
        val hash = pair.second

        return service.fetchCharacters(apiKey = publicApiKey, timestamp = ts, hash = hash, offset = offset, limit = limit)
            .map { it.data.characters }
    }

    fun fetchComicsFromNetwork(offset : Int, limit: Int) : Observable<List<Comics>> {
        val pair = getTimestampAndHash()
        val ts = pair.first
        val hash = pair.second

        return service.fetchComics(apiKey = publicApiKey, timestamp = ts, hash = hash, offset = offset, limit = limit)
            .map { it.data.comics }
    }



    fun getCharactersCacheDataSource() : DataSource.Factory<Int, Character> {
        return charactersDao.getAll()
    }

    fun getComicsCacheDataSource() : DataSource.Factory<Int, Comics> {
        return comicsDao.getAll()
    }



    fun saveCharacters(characters: List<Character>) {
        characters.forEach {
            if (charactersDao.getById(it.id) != null) {
                charactersDao.update(it)
            } else {
                charactersDao.insert(it)
            }
        }
    }

    fun saveComics(comics: List<Comics>) {
        comics.forEach {
            if (comicsDao.getById(it.id) != null) {
                comicsDao.update(it)
            } else {
                comicsDao.insert(it)
            }
        }
    }



    fun nukeCharacters() {
        charactersDao.nukeTable()
    }

    fun nukeComics() {
        comicsDao.nukeTable()
    }



    private fun getTimestampAndHash() : Pair<Long, String> {
        val ts = Date().time
        val hash = "${ts}${privateApiKey}${publicApiKey}".toMD5()

        return Pair(ts, hash)
    }
}