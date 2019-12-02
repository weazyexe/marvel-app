package exe.weazy.marvelapp.viewmodel

import android.annotation.SuppressLint
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import exe.weazy.marvelapp.model.Story
import exe.weazy.marvelapp.repository.MarvelRepository
import exe.weazy.marvelapp.state.State
import exe.weazy.marvelapp.util.DEFAULT_PAGE_SIZE
import exe.weazy.marvelapp.util.DEFAULT_PREFETCH_DISTANCE
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class StoriesViewModel : ViewModel() {

    var page = 0
    private val repository = MarvelRepository()

    val state : MutableLiveData<State> = MutableLiveData()

    val stories by lazy {
        val dataSourceFactory = repository.getStoriesCacheDataSource()

        val config = PagedList.Config.Builder()
            .setPageSize(DEFAULT_PAGE_SIZE)
            .setPrefetchDistance(DEFAULT_PREFETCH_DISTANCE)
            .setInitialLoadSizeHint(DEFAULT_PAGE_SIZE)
            .setEnablePlaceholders(true)
            .build()

        val boundaryCallback = object : PagedList.BoundaryCallback<Story>() {
            override fun onItemAtEndLoaded(itemAtEnd: Story) {
                loadStories()
            }

            override fun onZeroItemsLoaded() {
                loadStories()
            }
        }

        LivePagedListBuilder(dataSourceFactory, config)
            .setBoundaryCallback(boundaryCallback)
            .build()
    }

    init {
        state.postValue(State.Loading())
    }

    fun refresh() {
        state.postValue(State.Loading())
        repository.nukeStories()
        page = 0
        loadStories()
    }

    @SuppressLint("CheckResult")
    fun loadStories() {
        repository.fetchStoriesFromNetwork(page * DEFAULT_PAGE_SIZE, DEFAULT_PAGE_SIZE)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe( { response ->
                repository.saveStories(response)

                stories.value?.dataSource?.invalidate()

                state.postValue(State.Loaded())
            },
                { t ->
                    val size = stories.value?.size ?: 0

                    if (size > 0) {
                        state.postValue(State.Loaded(t.message))
                    } else {
                        state.postValue(State.Error(t.message))
                    }
                })
    }
}