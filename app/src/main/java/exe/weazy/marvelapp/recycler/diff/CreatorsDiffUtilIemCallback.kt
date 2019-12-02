package exe.weazy.marvelapp.recycler.diff

import androidx.recyclerview.widget.DiffUtil
import exe.weazy.marvelapp.model.Creator

class CreatorsDiffUtilIemCallback : DiffUtil.ItemCallback<Creator>() {

    override fun areItemsTheSame(oldItem: Creator, newItem: Creator) = oldItem.id == newItem.id

    override fun areContentsTheSame(oldItem: Creator, newItem: Creator) = oldItem == newItem
}