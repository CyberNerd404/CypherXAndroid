package com.cybernerd.finalproject.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.cybernerd.finalproject.R
import com.cybernerd.finalproject.model.DetailX
import com.cybernerd.finalproject.utils.debug
import kotlinx.android.synthetic.main.rv_classroom_child.view.childRoot
import kotlinx.android.synthetic.main.rv_directmessage_child.view.*

class ConversationAdapter(private val context: Context) :
    RecyclerView.Adapter<ConversationAdapter.ViewHolder>(){

    private var list: List<DetailX> = ArrayList()

    fun setConversationList(list: List<DetailX>){
        this.list = list
        notifyDataSetChanged()
    }



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ConversationAdapter.ViewHolder {
        return ViewHolder(
            LayoutInflater.from(context).inflate(R.layout.rv_directmessage_child, parent, false)
        )
    }

    class ViewHolder(view: View): RecyclerView.ViewHolder(view) {

        val name = view.tv_reciever_name
        val rootView = view.childRoot!!

    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ConversationAdapter.ViewHolder, position: Int) {

        holder.name.text = list[position].receiver.name
        holder.rootView.setOnClickListener {
//            val intent = Intent(context, DetailActivity::class.java)
//            intent.putExtra("location",list[position].woeid)
//            intent.putExtra("name",list[position].title)
//            context.startActivity(intent)
            debug("click","bhai click ho raha hai ispe : ${holder.rootView}")
        }
    }

}