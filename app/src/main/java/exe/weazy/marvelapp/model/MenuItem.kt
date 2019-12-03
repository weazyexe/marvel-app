package exe.weazy.marvelapp.model

import android.content.Intent
import android.graphics.drawable.Drawable

data class MenuItem(
    val title : String,
    val description : String,
    val drawable : Drawable,
    val intent : Intent
)