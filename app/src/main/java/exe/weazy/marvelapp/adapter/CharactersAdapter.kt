package exe.weazy.marvelapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.TextView
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import exe.weazy.marvelapp.R
import exe.weazy.marvelapp.model.Character

class CharactersAdapter(diffUtilItemCallback: DiffUtil.ItemCallback<Character>)
    : PagedListAdapter<Character, CharactersAdapter.Holder>(diffUtilItemCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        return Holder(LayoutInflater.from(parent.context).inflate(R.layout.card_hero, parent, false))
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        val item = getItem(position)
        if (item != null) {
            holder.bind(item)
        }
    }


    inner class Holder(view : View) : RecyclerView.ViewHolder(view) {

        private var nameTextView : TextView
        private var descriptionTextView : TextView
        private var characterImageView : ImageView
        private var characterLayout : FrameLayout

        init {
            super.itemView

            nameTextView = view.findViewById(R.id.nameTextView)
            descriptionTextView = view.findViewById(R.id.descriptionTextView)
            characterImageView = view.findViewById(R.id.characterImageView)
            characterLayout = view.findViewById(R.id.characterLayout)
        }

        fun bind(character: Character) {
            nameTextView.text = character.name

            Glide.with(characterLayout.context)
                .load(character.image.fullPath())
                .placeholder(R.drawable.avatar_placeholder)
                .error(R.drawable.ic_error_outline_gray_24dp)
                .dontAnimate()
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