package exe.weazy.marvelapp.repository

import androidx.paging.DataSource
import exe.weazy.marvelapp.db.*
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
import exe.weazy.marvelapp.model.Creator
import exe.weazy.marvelapp.model.Event

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
    private val creatorsDao : CreatorsDao
    private val eventsDao : EventsDao

    private var service: NetworkService



    init {
        App.getComponent().inject(this)

        charactersDao = database.charactersDao()
        comicsDao = database.comicsDao()
        creatorsDao = database.creatorsDao()
        eventsDao = database.eventsDao()

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

    fun fetchCreatorsFromNetwork(offset : Int, limit: Int) : Observable<List<Creator>> {
        val pair = getTimestampAndHash()
        val ts = pair.first
        val hash = pair.second

        return service.fetchCreators(apiKey = publicApiKey, timestamp = ts, hash = hash, offset = offset, limit = limit)
            .map { it.data.creators }
    }

    fun fetchEventsFromNetwork(offset : Int, limit: Int) : Observable<List<Event>> {
        val pair = getTimestampAndHash()
        val ts = pair.first
        val hash = pair.second

        return service.fetchEvents(apiKey = publicApiKey, timestamp = ts, hash = hash, offset = offset, limit = limit)
            .map { it.data.events }
    }



    fun getCharactersCacheDataSource() : DataSource.Factory<Int, Character> {
        return charactersDao.getAll()
    }

    fun getComicsCacheDataSource() : DataSource.Factory<Int, Comics> {
        return comicsDao.getAll()
    }

    fun getCreatorsCacheDataSource() : DataSource.Factory<Int, Creator> {
        return creatorsDao.getAll()
    }

    fun getEventsCacheDataSource() : DataSource.Factory<Int, Event> {
        return eventsDao.getAll()
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

    fun saveCreators(creators: List<Creator>) {
        creators.forEach {
            if (creatorsDao.getById(it.id) != null) {
                creatorsDao.update(it)
            } else {
                creatorsDao.insert(it)
            }
        }
    }

    fun saveEvents(events: List<Event>) {
        events.forEach {
            if (eventsDao.getById(it.id) != null) {
                eventsDao.update(it)
            } else {
                eventsDao.insert(it)
            }
        }
    }




    fun nukeCharacters() {
        charactersDao.nukeTable()
    }

    fun nukeComics() {
        comicsDao.nukeTable()
    }

    fun nukeCreators() {
        creatorsDao.nukeTable()
    }

    fun nukeEvents() {
        eventsDao.nukeTable()
    }



    private fun getTimestampAndHash() : Pair<Long, String> {
        val ts = Date().time
        val hash = "${ts}${privateApiKey}${publicApiKey}".toMD5()

        return Pair(ts, hash)
    }
}