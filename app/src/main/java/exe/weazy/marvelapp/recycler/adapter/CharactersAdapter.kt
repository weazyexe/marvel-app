package exe.weazy.marvelapp.recycler.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import exe.weazy.marvelapp.R
import exe.weazy.marvelapp.model.Character

class CharactersAdapter(diffUtilItemCallback: DiffUtil.ItemCallback<Character>)
    : PagedListAdapter<Character, CharactersAdapter.Holder>(diffUtilItemCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        return Holder(LayoutInflater.from(parent.context).inflate(R.layout.item_character, parent, false))
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        val item = getItem(position)
        if (item != null) {
            holder.bind(item)
        }
    }


    inner class Holder(view : View) : RecyclerView.ViewHolder(view) {

        private var nameTextView = view.findViewById<TextView>(R.id.nameTextView)
        private var descriptionTextView = view.findViewById<TextView>(R.id.descriptionTextView)
        private var characterImageView = view.findViewById<ImageView>(R.id.characterImageView)
        private var characterLayout = view.findViewById<View>(R.id.characterLayout)

        fun bind(character: Character) {
            nameTextView.text = character.name

            Glide.with(characterLayout.context)
                .load(character.image.fullStandardPath())
                .placeholder(R.drawable.avatar_placeholder)
                .dontAnimate()
                .apply(RequestOptions.circleCropTransform())
                .into(characterImageView)

            if (character.description.isBlank()) {
                descriptionTextView.visibility = View.GONE
            } else {
                descriptionTextView.text = character.description
                descriptionTextView.visibility = View.VISIBLE
            }
        }
    }
}