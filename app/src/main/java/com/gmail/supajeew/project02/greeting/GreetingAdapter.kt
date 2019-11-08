package com.gmail.supajeew.project02.greeting

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.gmail.supajeew.project02.R
import com.gmail.supajeew.project02.data.Greeting

class GreetingAdapter : RecyclerView.Adapter<GreetingAdapter.ViewHolder>(){
    var data = listOf<Greeting>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.singaporeText.text = data[position].singapore
        holder.thaiText.text = data[position].thai
//        holder.sourceTextView.text = _data[position].source
    }

    fun replaceItems(items: List<Greeting>) {
        this.data = items
    }

    override fun getItemCount(): Int = data.size

    class ViewHolder private constructor(itemView: View) : RecyclerView.ViewHolder(itemView){
        val singaporeText: TextView = itemView.findViewById(R.id.singaporeText)
        val thaiText: TextView = itemView.findViewById(R.id.thaiText)

        companion object {
            fun from(parent: ViewGroup): ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val view = layoutInflater
                    .inflate(R.layout.greeting_item, parent, false)

                return ViewHolder(view)
            }
        }
    }
}