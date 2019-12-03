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
import exe.weazy.marvelapp.R
import exe.weazy.marvelapp.model.Comics

class ComicsAdapter(diffUtil: DiffUtil.ItemCallback<Comics>) : PagedListAdapter<Comics, ComicsAdapter.Holder>(diffUtil) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)
        = Holder(LayoutInflater.from(parent.context).inflate(R.layout.item_comics, parent, false))

    override fun onBindViewHolder(holder: Holder, position: Int) {
        val comics = getItem(position)

        if (comics != null) {
            holder.bind(comics)
        }
    }

    inner class Holder(view : View) : RecyclerView.ViewHolder(view) {

        private var titleTextView = view.findViewById<TextView>(R.id.titleTextView)
        private var descriptionTextView = view.findViewById<TextView>(R.id.descriptionTextView)
        private var coverImageView = view.findViewById<ImageView>(R.id.coverImageView)
        private var comicsLayout = view.findViewById<View>(R.id.comicsLayout)



        fun bind(comics: Comics) {
            titleTextView.text = comics.title

            Glide.with(comicsLayout.context)
                .load(comics.image.fullPortraitPath())
                .placeholder(R.drawable.avatar_placeholder)
                .dontAnimate()
                .into(coverImageView)

            if (comics.description.isNullOrBlank()) {
                descriptionTextView.visibility = View.GONE
            } else {
                descriptionTextView.text = comics.description
                descriptionTextView.visibility = View.VISIBLE
            }
        }
    }
}