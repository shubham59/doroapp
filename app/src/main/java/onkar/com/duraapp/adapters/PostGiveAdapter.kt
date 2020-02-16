package onkar.com.duraapp.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import onkar.com.duraapp.R

class PostGiveAdapter: RecyclerView.Adapter<PostGiveAdapter.PostGiveHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostGiveHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.cell_rv_adopt, parent, false)
        return PostGiveHolder(view)

    }

    override fun getItemCount(): Int {
        return 5
    }

    override fun onBindViewHolder(holder: PostGiveHolder, position: Int) {
    }

    inner class PostGiveHolder(itemView: View): RecyclerView.ViewHolder(itemView){

    }
}