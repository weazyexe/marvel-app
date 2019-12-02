package exe.weazy.marvelapp.recycler.diff

import androidx.recyclerview.widget.DiffUtil
import exe.weazy.marvelapp.model.Story

class StoriesDiffUtilItemCallback : DiffUtil.ItemCallback<Story>() {
    override fun areItemsTheSame(oldItem: Story, newItem: Story) = oldItem.id == newItem.id

    override fun areContentsTheSame(oldItem: Story, newItem: Story) = oldItem == newItem
}