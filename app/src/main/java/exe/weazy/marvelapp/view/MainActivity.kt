package exe.weazy.marvelapp.view

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import exe.weazy.marvelapp.R
import exe.weazy.marvelapp.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
    }

    override fun onStart() {
        super.onStart()
        initListeners()
    }

    private fun initListeners() {
        charactersCardView.setOnClickListener {
            openActivity(Intent(this, CharactersActivity::class.java))
        }
    }

    private fun openActivity(intent: Intent) {
        /*val options = ActivityOptions.makeSceneTransitionAnimation(this,
            Pair.create(cardImageView, getString(R.string.characters)))

        startActivity(intent, options.toBundle())*/
        startActivity(intent)
    }
}
