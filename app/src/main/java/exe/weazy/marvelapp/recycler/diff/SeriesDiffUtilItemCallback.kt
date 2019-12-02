package exe.weazy.marvelapp.recycler.diff

import androidx.recyclerview.widget.DiffUtil
import exe.weazy.marvelapp.model.Series

class SeriesDiffUtilItemCallback : DiffUtil.ItemCallback<Series>() {
    override fun areItemsTheSame(oldItem: Series, newItem: Series) = oldItem.id == newItem.id

    override fun areContentsTheSame(oldItem: Series, newItem: Series) = oldItem == newItem
}