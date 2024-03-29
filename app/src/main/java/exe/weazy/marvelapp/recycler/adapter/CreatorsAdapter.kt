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
import exe.weazy.marvelapp.model.Creator

class CreatorsAdapter(diffUtil : DiffUtil.ItemCallback<Creator>) : PagedListAdapter<Creator, CreatorsAdapter.Holder>(diffUtil) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)
        = Holder(LayoutInflater.from(parent.context).inflate(R.layout.item_creator, parent, false))

    override fun onBindViewHolder(holder: Holder, position: Int) {
        val creator = getItem(position)

        if (creator != null) {
            holder.bind(creator)
        }
    }

    inner class Holder(view : View) : RecyclerView.ViewHolder(view) {

        private var nameTextView = view.findViewById<TextView>(R.id.nameTextView)
        private var photoImageView = view.findViewById<ImageView>(R.id.photoImageView)


        fun bind(creator: Creator) {
            nameTextView.text = creator.fullName

            Glide.with(nameTextView.context)
                .load(creator.image.fullStandardPath())
                .placeholder(R.drawable.avatar_placeholder)
                .dontAnimate()
                .apply(RequestOptions.circleCropTransform())
                .into(photoImageView)
        }
    }
}