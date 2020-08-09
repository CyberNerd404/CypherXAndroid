package com.cybernerd.finalproject.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.cybernerd.finalproject.R
import com.cybernerd.finalproject.model.Detail
import com.cybernerd.finalproject.utils.debug
import kotlinx.android.synthetic.main.rv_classroom_child.view.*

class ClassroomAdapter(private val context: Context) :
    RecyclerView.Adapter<ClassroomAdapter.ViewHolder>(){

    private var list: List<Detail> = ArrayList()

    fun setClassroom(list: List<Detail>){
        this.list = list
        notifyDataSetChanged()
    }



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ClassroomAdapter.ViewHolder {
        return ViewHolder(
//            LayoutInflater.from(context).inflate(R.layout.rv_classroom_child, parent, false)
        LayoutInflater.from(context).inflate(R.layout.rv_classroom_child, parent, false)
        )
    }

    class ViewHolder(view: View): RecyclerView.ViewHolder(view) {

        val name = view.tv_classroom_name!!
        val latLong = view.tv_classroom_description!!
        val rootView = view.childRoot!!

    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ClassroomAdapter.ViewHolder, position: Int) {

        holder.name.text = list[position].name
        holder.latLong.text = list[position].description
        holder.rootView.setOnClickListener {
//            val intent = Intent(context, DetailActivity::class.java)
//            intent.putExtra("location",list[position].woeid)
//            intent.putExtra("name",list[position].title)
//            context.startActivity(intent)
            debug("click","bhai click ho raha hai ispe : ${holder.rootView}")
        }
    }

}