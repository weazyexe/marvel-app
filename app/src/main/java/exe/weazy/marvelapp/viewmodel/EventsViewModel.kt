package exe.weazy.marvelapp.viewmodel

import android.annotation.SuppressLint
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import exe.weazy.marvelapp.model.Event
import exe.weazy.marvelapp.repository.MarvelRepository
import exe.weazy.marvelapp.state.State
import exe.weazy.marvelapp.util.DEFAULT_PAGE_SIZE
import exe.weazy.marvelapp.util.DEFAULT_PREFETCH_DISTANCE
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class EventsViewModel : ViewModel() {

    var page = 0
    private val repository = MarvelRepository()

    val state : MutableLiveData<State> = MutableLiveData()

    val events by lazy {
        val dataSourceFactory = repository.getEventsCacheDataSource()

        val config = PagedList.Config.Builder()
            .setPageSize(DEFAULT_PAGE_SIZE)
            .setPrefetchDistance(DEFAULT_PREFETCH_DISTANCE)
            .setInitialLoadSizeHint(DEFAULT_PAGE_SIZE)
            .setEnablePlaceholders(true)
            .build()

        val boundaryCallback = object : PagedList.BoundaryCallback<Event>() {
            override fun onItemAtEndLoaded(itemAtEnd: Event) {
                loadEvents()
            }

            override fun onZeroItemsLoaded() {
                loadEvents()
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
        repository.nukeEvents()
        page = 0
        loadEvents()
    }

    @SuppressLint("CheckResult")
    fun loadEvents() {
        repository.fetchEventsFromNetwork(page * DEFAULT_PAGE_SIZE, DEFAULT_PAGE_SIZE)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe( { response ->
                repository.saveEvents(response)

                events.value?.dataSource?.invalidate()

                state.postValue(State.Loaded())
            },
                { t ->
                    val size = events.value?.size ?: 0

                    if (size > 0) {
                        state.postValue(State.Loaded(t.message))
                    } else {
                        state.postValue(State.Error(t.message))
                    }
                })
    }
}