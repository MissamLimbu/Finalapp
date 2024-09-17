package com.example.finalapp

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class DashboardAdapter(
    private val dataList: List<String>,           // List of item titles
    private val detailsMap: Map<String, String>   // Map of corresponding details
) : RecyclerView.Adapter<DashboardAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val itemTitle: TextView = view.findViewById(R.id.itemTitle)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_dashboard, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = dataList[position]
        holder.itemTitle.text = item

        // Handle click event to navigate to details screen
        holder.itemView.setOnClickListener {
            val context = holder.itemView.context
            val intent = Intent(context, DetailsActivity::class.java)

            // Pass both the item title and its corresponding detail
            intent.putExtra("itemTitle", item)
            intent.putExtra("itemDetail", detailsMap[item])
            context.startActivity(intent)
        }
    }

    override fun getItemCount() = dataList.size
}
