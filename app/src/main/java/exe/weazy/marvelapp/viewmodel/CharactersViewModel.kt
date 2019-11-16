package exe.weazy.marvelapp.viewmodel

import android.annotation.SuppressLint
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import exe.weazy.marvelapp.model.Character
import exe.weazy.marvelapp.repository.MarvelRepository
import exe.weazy.marvelapp.state.CharactersState
import exe.weazy.marvelapp.util.DEFAULT_PAGE_SIZE
import exe.weazy.marvelapp.util.DEFAULT_PREFETCH_DISTANCE
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class CharactersViewModel : ViewModel() {

    private var page = 0
    private val repository = MarvelRepository()

    val characters by lazy {
        val dataSourceFactory = repository.getCacheDataSource()

        val config = PagedList.Config.Builder()
            .setPageSize(DEFAULT_PAGE_SIZE)
            .setPrefetchDistance(DEFAULT_PREFETCH_DISTANCE)
            .setInitialLoadSizeHint(DEFAULT_PAGE_SIZE)
            .setEnablePlaceholders(true)
            .build()

        val boundaryCallback = object : PagedList.BoundaryCallback<Character>() {
            override fun onItemAtEndLoaded(itemAtEnd: Character) {
                loadCharacters(page++)
            }

            override fun onZeroItemsLoaded() {
                loadCharacters(page++)
            }
        }

        LivePagedListBuilder(dataSourceFactory, config)
            .setBoundaryCallback(boundaryCallback)
            .build()
    }



    @SuppressLint("CheckResult")
    fun loadCharacters(page: Int) : LiveData<CharactersState> {
        val state = MutableLiveData<CharactersState>()

        repository.fetchCharactersFromNetwork(page * DEFAULT_PAGE_SIZE, DEFAULT_PAGE_SIZE)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe { response ->
                repository.writeCharactersToCache(response)
                characters.value?.dataSource?.invalidate()

                state.postValue(CharactersState.Loaded(response))
            }

        return state
    }
}