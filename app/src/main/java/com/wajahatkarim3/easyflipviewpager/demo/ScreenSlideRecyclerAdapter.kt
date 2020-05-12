package com.wajahatkarim3.easyflipviewpager.demo

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ScreenSlideRecyclerAdapter(val itemsList: ArrayList<Int>) : RecyclerView.Adapter<ScreenSlideRecyclerAdapter.ScreenSlideViewHolder>()
{
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ScreenSlideViewHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.fragment_dummy_layout, parent, false)
        return ScreenSlideViewHolder(view)
    }

    override fun onBindViewHolder(holder: ScreenSlideViewHolder, position: Int) {
        holder.bind(itemsList[position], position)
    }

    override fun getItemCount(): Int {
        return itemsList.size
    }

    fun setItems(items: List<Int>)
    {
        itemsList.clear()
        itemsList.addAll(items)
        notifyDataSetChanged()
    }

    inner class ScreenSlideViewHolder : RecyclerView.ViewHolder
    {
        var textView: TextView? = null
        constructor(view: View) : super(view) {
            textView = view.findViewById(R.id.textView)
        }

        fun bind(color: Int, position: Int) {
            textView?.setBackgroundColor(color)
            textView?.setText(position.toString())
        }
    }
}