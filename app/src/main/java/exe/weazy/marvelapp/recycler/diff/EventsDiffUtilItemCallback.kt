package exe.weazy.marvelapp.recycler.diff

import androidx.recyclerview.widget.DiffUtil
import exe.weazy.marvelapp.model.Event

class EventsDiffUtilItemCallback : DiffUtil.ItemCallback<Event>() {
    override fun areItemsTheSame(oldItem: Event, newItem: Event) = oldItem.id == newItem.id

    override fun areContentsTheSame(oldItem: Event, newItem: Event) = oldItem == newItem
}