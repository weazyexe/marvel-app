package exe.weazy.marvelapp.recycler.diff

import androidx.recyclerview.widget.DiffUtil
import exe.weazy.marvelapp.model.Comics

class ComicsDiffUtilItemCallback : DiffUtil.ItemCallback<Comics>() {

    override fun areItemsTheSame(oldItem: Comics, newItem: Comics) = oldItem.id == newItem.id

    override fun areContentsTheSame(oldItem: Comics, newItem: Comics) = oldItem == newItem
}