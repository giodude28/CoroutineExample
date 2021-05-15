package io.giodude.bbin.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import io.giodude.bbin.Model.TeamModel
import io.giodude.bbin.R

class TeamAdapter(var context: Context, val itemList: ArrayList<TeamModel>): RecyclerView.Adapter<TeamAdapter.ItemViewHolder>() {


    class ItemViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val itemTitle: TextView = itemView.findViewById(R.id.teamname)
        val itemBadge: ImageView = itemView.findViewById(R.id.teamimg)
        val itemjersey: ImageView = itemView.findViewById(R.id.teamjersey)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TeamAdapter.ItemViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.teamitem, parent, false)
        return ItemViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: TeamAdapter.ItemViewHolder, position: Int) {
        holder.itemTitle.text = itemList[position].teamname
        Glide.with(holder.itemBadge.context)
            .load(itemList[position].teamimg)
            .into(holder.itemBadge)
        Glide.with(holder.itemjersey.context)
            .load(itemList[position].teamjersey)
            .into(holder.itemjersey)

    }

    override fun getItemCount(): Int {
        return itemList.size
    }
}