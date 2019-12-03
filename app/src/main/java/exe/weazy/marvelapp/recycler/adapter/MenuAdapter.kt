package exe.weazy.marvelapp.recycler.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import exe.weazy.marvelapp.R
import exe.weazy.marvelapp.model.MenuItem

class MenuAdapter(private val items : List<MenuItem>, private val onClickListener: View.OnClickListener) : RecyclerView.Adapter<MenuAdapter.Holder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) : Holder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.card_menu_item, parent, false)
        view.setOnClickListener(onClickListener)

        return Holder(view)
    }

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.bind(items[position])
    }

    inner class Holder(view: View) : RecyclerView.ViewHolder(view) {
        private var titleTextView = view.findViewById<TextView>(R.id.titleTextView)
        private var descriptionTextView = view.findViewById<TextView>(R.id.descriptionTextView)
        private var posterImageView = view.findViewById<ImageView>(R.id.cardImageView)

        fun bind(menuItem: MenuItem) {
            titleTextView.text = menuItem.title
            descriptionTextView.text = menuItem.description
            posterImageView.setImageDrawable(menuItem.drawable)
        }
    }
}