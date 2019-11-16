package exe.weazy.marvelapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import exe.weazy.marvelapp.R
import exe.weazy.marvelapp.model.Character

class CharactersAdapter(diffUtilItemCallback: DiffUtil.ItemCallback<Character>)
    : PagedListAdapter<Character, CharactersAdapter.Holder>(diffUtilItemCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        return Holder(LayoutInflater.from(parent.context).inflate(R.layout.card_hero, parent, false))
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }


    inner class Holder(view : View) : RecyclerView.ViewHolder(view) {

        private var nameTextView : TextView
        private var descriptionTextView : TextView

        private var dataLayout : View
        private var placeholderLayout : View

        init {
            super.itemView

            nameTextView = view.findViewById(R.id.nameTextView)
            descriptionTextView = view.findViewById(R.id.descriptionTextView)

            dataLayout = view.findViewById(R.id.dataLayout)
            placeholderLayout = view.findViewById(R.id.placeholderLayout)
        }

        fun bind(character: Character?) {
            if (character != null) {
                dataLayout.visibility = View.VISIBLE
                placeholderLayout.visibility = View.GONE

                nameTextView.text = character.name

                if (character.description.isBlank()) {
                    descriptionTextView.visibility = View.GONE
                } else {
                    descriptionTextView.text = character.description
                    descriptionTextView.visibility = View.VISIBLE
                }
            } else {
                dataLayout.visibility = View.GONE
                placeholderLayout.visibility = View.VISIBLE
            }
        }
    }
}