package exe.weazy.marvelapp.recycler.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import exe.weazy.marvelapp.R
import exe.weazy.marvelapp.model.Story

class StoriesAdapter(diffUtil : DiffUtil.ItemCallback<Story>) : PagedListAdapter<Story, StoriesAdapter.Holder>(diffUtil) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)
            = Holder(LayoutInflater.from(parent.context).inflate(R.layout.item_story, parent, false))

    override fun onBindViewHolder(holder: Holder, position: Int) {
        val series = getItem(position)

        if (series != null) {
            holder.bind(series)
        }
    }

    inner class Holder(view : View) : RecyclerView.ViewHolder(view) {

        private var titleTextView : TextView
        private var descriptionTextView : TextView

        init {
            super.itemView

            titleTextView = view.findViewById(R.id.titleTextView)
            descriptionTextView = view.findViewById(R.id.descriptionTextView)
        }

        fun bind(story: Story) {
            titleTextView.text = story.title

            if (!story.description.isNullOrBlank()) {
                descriptionTextView.text = story.description
                descriptionTextView.visibility = View.VISIBLE
            } else {
                descriptionTextView.visibility = View.GONE
            }
        }
    }
}