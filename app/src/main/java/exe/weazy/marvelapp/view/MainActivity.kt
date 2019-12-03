package exe.weazy.marvelapp.view

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import exe.weazy.marvelapp.R
import exe.weazy.marvelapp.databinding.ActivityMainBinding
import exe.weazy.marvelapp.model.MenuItem
import exe.weazy.marvelapp.recycler.adapter.MenuAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding

    private lateinit var menuItems : List<MenuItem>

    private lateinit var adapter : MenuAdapter
    private lateinit var layoutManager: LinearLayoutManager


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        initMenuItems()
        initListeners()
    }

    private fun initMenuItems() {
        menuItems = mutableListOf(
            MenuItem(
                getString(R.string.characters),
                getString(R.string.characters_desc),
                ContextCompat.getDrawable(this, R.drawable.characters)!!,
                Intent(this, CharactersActivity::class.java)),

            MenuItem(
                getString(R.string.comics),
                getString(R.string.comics_desc),
                ContextCompat.getDrawable(this, R.drawable.comics)!!,
                Intent(this, ComicsActivity::class.java)),

            MenuItem(
                getString(R.string.creators),
                getString(R.string.creators_desc),
                ContextCompat.getDrawable(this, R.drawable.creators)!!,
                Intent(this, CreatorsActivity::class.java)),

            MenuItem(
                getString(R.string.events),
                getString(R.string.events_desc),
                ContextCompat.getDrawable(this, R.drawable.events)!!,
                Intent(this, EventsActivity::class.java)),

            MenuItem(
                getString(R.string.series),
                getString(R.string.series_desc),
                ContextCompat.getDrawable(this, R.drawable.series)!!,
                Intent(this, SeriesActivity::class.java)),

            MenuItem(
                getString(R.string.stories),
                getString(R.string.stories_desc),
                ContextCompat.getDrawable(this, R.drawable.stories)!!,
                Intent(this, StoriesActivity::class.java))
        )
    }

    private fun initListeners() {
        val onClickListener = View.OnClickListener {
            val position = menuItemsRecyclerView.getChildAdapterPosition(it as View)
            val menuItem = menuItems[position]

            openActivity(menuItem.intent)
        }

        adapter = MenuAdapter(menuItems, onClickListener)
        layoutManager = LinearLayoutManager(this)

        menuItemsRecyclerView.adapter = adapter
        menuItemsRecyclerView.layoutManager = layoutManager
    }

    private fun openActivity(intent: Intent) {
        /*val options = ActivityOptions.makeSceneTransitionAnimation(this,
            Pair.create(cardImageView, getString(R.string.creators)))

        startActivity(intent, options.toBundle())*/
        startActivity(intent)
    }
}
