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
import exe.weazy.marvelapp.model.Event

class EventsAdapter(diffUtil : DiffUtil.ItemCallback<Event>) : PagedListAdapter<Event, EventsAdapter.Holder>(diffUtil) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)
            = Holder(LayoutInflater.from(parent.context).inflate(R.layout.item_character, parent, false))

    override fun onBindViewHolder(holder: Holder, position: Int) {
        val event = getItem(position)

        if (event != null) {
            holder.bind(event)
        }
    }

    inner class Holder(view : View) : RecyclerView.ViewHolder(view) {

        private var nameTextView = view.findViewById<TextView>(R.id.nameTextView)
        private var descriptionTextView = view.findViewById<TextView>(R.id.descriptionTextView)
        private var photoImageView = view.findViewById<ImageView>(R.id.characterImageView)


        fun bind(event: Event) {
            nameTextView.text = event.title
            descriptionTextView.text = event.description

            Glide.with(nameTextView.context)
                .load(event.image.fullStandardPath())
                .placeholder(R.drawable.avatar_placeholder)
                .dontAnimate()
                .apply(RequestOptions.circleCropTransform())
                .into(photoImageView)
        }
    }
}