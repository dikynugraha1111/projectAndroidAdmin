package com.example.projectandroidadmin.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.projectandroidadmin.R
import com.example.projectandroidadmin.model.DataItem
import com.example.projectandroidadmin.model.DataItemsampah
import com.example.projectandroidadmin.model.arsipsekolah
import com.example.projectandroidadmin.model.getdatasampah
import kotlinx.android.synthetic.main.item_blog.view.*
import retrofit2.Response

class blogAdapter(private val list: ArrayList<DataItemsampah>): RecyclerView.Adapter<blogAdapter.BlogViewHolder>() {
    private lateinit var onItemClickCallback: OnItemClickCallback

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BlogViewHolder {
        return BlogViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_blog,parent,false))
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: BlogViewHolder, position: Int) {
        holder.bindModel(list[position])
        holder.itemView.setOnClickListener { onItemClickCallback.onItemClicked(list[holder.adapterPosition])}
    }

    inner class BlogViewHolder(itemView : View): RecyclerView.ViewHolder(itemView){

        fun bindModel(dataItem: DataItemsampah){
            with(itemView){
                tv_title.text = dataItem.jenis
                tv_desc.text = dataItem.nama
                tv_berat.text = dataItem.berat
            }
        }
    }

    interface OnItemClickCallback {
        fun onItemClicked(data: DataItemsampah)
    }

}