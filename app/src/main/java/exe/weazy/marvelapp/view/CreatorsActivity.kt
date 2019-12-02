package exe.weazy.marvelapp.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.appcompat.widget.Toolbar
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import exe.weazy.marvelapp.R
import exe.weazy.marvelapp.recycler.adapter.CharactersAdapter
import exe.weazy.marvelapp.recycler.adapter.CreatorsAdapter
import exe.weazy.marvelapp.recycler.diff.CharactersDiffUtilItemCallback
import exe.weazy.marvelapp.recycler.diff.CreatorsDiffUtilIemCallback
import exe.weazy.marvelapp.state.State
import exe.weazy.marvelapp.util.DEFAULT_PAGE_SIZE
import exe.weazy.marvelapp.viewmodel.CharactersViewModel
import exe.weazy.marvelapp.viewmodel.CreatorsViewModel
import kotlinx.android.synthetic.main.activity_characters.*
import kotlinx.android.synthetic.main.activity_characters.errorLayout
import kotlinx.android.synthetic.main.activity_characters.loadingLayout
import kotlinx.android.synthetic.main.activity_characters.mainLayout
import kotlinx.android.synthetic.main.activity_characters.mainSwipeLayout
import kotlinx.android.synthetic.main.activity_creators.*

class CreatorsActivity : AppCompatActivity() {

    private lateinit var viewModel: CreatorsViewModel

    private lateinit var adapter : CreatorsAdapter
    private lateinit var layoutManager : LinearLayoutManager


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(R.style.AppTheme_TransparentStatusBar)
        setContentView(R.layout.activity_creators)

        initToolbar()
        initAdapter()
        initViewModel()
        initListeners()
    }

    override fun onStart() {
        super.onStart()
        setState(State.Loading())
    }

    private fun setState(state : State) {
        when (state) {
            is State.Loaded -> {
                creatorsRecyclerView.visibility = View.VISIBLE
                loadingLayout.visibility = View.GONE
                errorLayout.visibility = View.GONE

                if (state.msg != null) {
                    showSnackbar(state.msg)
                }

                mainSwipeLayout.isRefreshing = false
            }

            is State.Loading -> {
                creatorsRecyclerView.visibility = View.GONE
                loadingLayout.visibility = View.VISIBLE
                errorLayout.visibility = View.GONE

                mainSwipeLayout.isRefreshing = false
            }

            is State.Error -> {
                creatorsRecyclerView.visibility = View.GONE
                loadingLayout.visibility = View.GONE
                errorLayout.visibility = View.VISIBLE

                if (state.msg != null) {
                    showSnackbar(state.msg)
                }

                mainSwipeLayout.isRefreshing = false
            }
        }
    }

    private fun showSnackbar(msg: String) {
        Snackbar.make(mainLayout, msg, Snackbar.LENGTH_LONG).show()
    }

    private fun initViewModel() {
        viewModel = ViewModelProviders.of(this).get(CreatorsViewModel::class.java)

        // creators observer
        viewModel.creators.observe(this, Observer {
            adapter.submitList(it)

            viewModel.page = if (it.size.rem(DEFAULT_PAGE_SIZE) == 0) {
                it.size / DEFAULT_PAGE_SIZE
            }
            else {
                (it.size / DEFAULT_PAGE_SIZE) + 1
            }

            if (it.isNotEmpty()) {
                viewModel.state.postValue(State.Loaded())
            }
        })

        viewModel.state.observe(this, Observer {
            setState(it)
        })
    }

    private fun initAdapter() {
        adapter =
            CreatorsAdapter(CreatorsDiffUtilIemCallback())
        layoutManager = LinearLayoutManager(this)

        val recyclerView = findViewById<RecyclerView>(R.id.creatorsRecyclerView)

        recyclerView.adapter = adapter
        recyclerView.layoutManager = layoutManager
    }

    private fun initListeners() {
        mainSwipeLayout.setOnRefreshListener {
            viewModel.refresh()
        }
    }

    private fun initToolbar() {
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }
}
