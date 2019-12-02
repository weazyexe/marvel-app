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
import exe.weazy.marvelapp.model.Series

class SeriesAdapter(diffUtil : DiffUtil.ItemCallback<Series>) : PagedListAdapter<Series, SeriesAdapter.Holder>(diffUtil) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)
            = Holder(LayoutInflater.from(parent.context).inflate(R.layout.item_character, parent, false))

    override fun onBindViewHolder(holder: Holder, position: Int) {
        val series = getItem(position)

        if (series != null) {
            holder.bind(series)
        }
    }

    inner class Holder(view : View) : RecyclerView.ViewHolder(view) {

        private var nameTextView : TextView
        private var descriptionTextView : TextView
        private var photoImageView : ImageView

        init {
            super.itemView

            nameTextView = view.findViewById(R.id.nameTextView)
            descriptionTextView = view.findViewById(R.id.descriptionTextView)
            photoImageView = view.findViewById(R.id.characterImageView)
        }

        fun bind(series: Series) {
            nameTextView.text = series.title

            if (series.description != null) {
                descriptionTextView.text = series.description
                descriptionTextView.visibility = View.VISIBLE
            } else {
                descriptionTextView.visibility = View.GONE
            }


            Glide.with(nameTextView.context)
                .load(series.image.fullStandardPath())
                .placeholder(R.drawable.avatar_placeholder)
                .dontAnimate()
                .into(photoImageView)
        }
    }
}