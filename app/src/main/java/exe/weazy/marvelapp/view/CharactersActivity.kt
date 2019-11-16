package exe.weazy.marvelapp.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import exe.weazy.marvelapp.R
import exe.weazy.marvelapp.adapter.CharactersAdapter
import exe.weazy.marvelapp.adapter.CharactersDiffUtilItemCallback
import exe.weazy.marvelapp.state.CharactersState
import exe.weazy.marvelapp.util.DEFAULT_PAGE_SIZE
import exe.weazy.marvelapp.viewmodel.CharactersViewModel
import kotlinx.android.synthetic.main.activity_characters.*

class CharactersActivity : AppCompatActivity() {

    private lateinit var viewModel: CharactersViewModel

    private lateinit var adapter : CharactersAdapter
    private lateinit var layoutManager : LinearLayoutManager


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_characters)

        initAdapter()
        initViewModel()
        initListeners()
    }

    override fun onStart() {
        super.onStart()
        setState(CharactersState.Loading())
    }

    private fun setState(state : CharactersState) {
        when (state) {
            is CharactersState.Loaded -> {
                heroesRecyclerView.visibility = View.VISIBLE
                loadingLayout.visibility = View.GONE
                errorLayout.visibility = View.GONE

                if (state.msg != null) {
                    showSnackbar(state.msg)
                }

                mainSwipeLayout.isRefreshing = false
            }

            is CharactersState.Loading -> {
                heroesRecyclerView.visibility = View.GONE
                loadingLayout.visibility = View.VISIBLE
                errorLayout.visibility = View.GONE

                mainSwipeLayout.isRefreshing = false
            }

            is CharactersState.Error -> {
                heroesRecyclerView.visibility = View.GONE
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
        viewModel = ViewModelProviders.of(this).get(CharactersViewModel::class.java)

        // characters observer
        viewModel.characters.observe(this, Observer {
            adapter.submitList(it)
            viewModel.page = it.size / DEFAULT_PAGE_SIZE
        })

        viewModel.state.observe(this, Observer {
            setState(it)
        })
    }

    private fun initAdapter() {
        adapter = CharactersAdapter(CharactersDiffUtilItemCallback())
        layoutManager = LinearLayoutManager(this)

        val recyclerView = findViewById<RecyclerView>(R.id.heroesRecyclerView)

        recyclerView.adapter = adapter
        recyclerView.layoutManager = layoutManager
    }

    private fun initListeners() {
        mainSwipeLayout.setOnRefreshListener {
            viewModel.refresh()
        }
    }
}
