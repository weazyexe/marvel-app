package exe.weazy.marvelapp.repository

import androidx.paging.DataSource
import exe.weazy.marvelapp.db.*
import exe.weazy.marvelapp.model.*
import exe.weazy.marvelapp.network.NetworkService
import exe.weazy.marvelapp.util.App
import exe.weazy.marvelapp.util.toMD5
import io.reactivex.Observable
import retrofit2.Retrofit
import java.util.*
import javax.inject.Inject
import javax.inject.Named

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
    private val seriesDao : SeriesDao
    private val storiesDao : StoriesDao

    private var service: NetworkService



    init {
        App.getComponent().inject(this)

        charactersDao = database.charactersDao()
        comicsDao = database.comicsDao()
        creatorsDao = database.creatorsDao()
        eventsDao = database.eventsDao()
        seriesDao = database.seriesDao()
        storiesDao = database.storiesDao()

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

    fun fetchSeriesFromNetwork(offset : Int, limit: Int) : Observable<List<Series>> {
        val pair = getTimestampAndHash()
        val ts = pair.first
        val hash = pair.second

        return service.fetchSeries(apiKey = publicApiKey, timestamp = ts, hash = hash, offset = offset, limit = limit)
            .map { it.data.series }
    }

    fun fetchStoriesFromNetwork(offset : Int, limit: Int) : Observable<List<Story>> {
        val pair = getTimestampAndHash()
        val ts = pair.first
        val hash = pair.second

        return service.fetchStories(apiKey = publicApiKey, timestamp = ts, hash = hash, offset = offset, limit = limit)
            .map { it.data.stories }
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

    fun getSeriesCacheDataSource() : DataSource.Factory<Int, Series> {
        return seriesDao.getAll()
    }

    fun getStoriesCacheDataSource() : DataSource.Factory<Int, Story> {
        return storiesDao.getAll()
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

    fun saveSeries(series: List<Series>) {
        series.forEach {
            if (seriesDao.getById(it.id) != null) {
                seriesDao.update(it)
            } else {
                seriesDao.insert(it)
            }
        }
    }

    fun saveStories(stories: List<Story>) {
        stories.forEach {
            if (storiesDao.getById(it.id) != null) {
                storiesDao.update(it)
            } else {
                storiesDao.insert(it)
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

    fun nukeSeries() {
        seriesDao.nukeTable()
    }

    fun nukeStories() {
        storiesDao.nukeTable()
    }



    private fun getTimestampAndHash() : Pair<Long, String> {
        val ts = Date().time
        val hash = "${ts}${privateApiKey}${publicApiKey}".toMD5()

        return Pair(ts, hash)
    }
}