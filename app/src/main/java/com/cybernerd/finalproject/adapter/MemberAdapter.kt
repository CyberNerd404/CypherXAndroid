package com.cybernerd.finalproject.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.cybernerd.finalproject.R
import com.cybernerd.finalproject.model.User
import com.cybernerd.finalproject.utils.debug
import kotlinx.android.synthetic.main.rv_classroom_child.view.childRoot
import kotlinx.android.synthetic.main.rv_user_child.view.*


class MemberAdapter(private val context: Context) :
    RecyclerView.Adapter<MemberAdapter.ViewHolder>(){

    private var list: List<User> = ArrayList()

    fun setMember(list: User){
        this.list = listOf(list)
        notifyDataSetChanged()
    }



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MemberAdapter.ViewHolder {
        return ViewHolder(
            LayoutInflater.from(context).inflate(R.layout.rv_user_child, parent, false)
        )
    }

    class ViewHolder(view: View): RecyclerView.ViewHolder(view) {

        val name = view.tv_seach_name!!
        val department = view.tv_seach_department!!
        val role = view.tv_seach_role!!
        val rootView = view.childRoot!!

    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: MemberAdapter.ViewHolder, position: Int) {

        holder.name.text = list[position].first_name
        holder.department.text = list[position].department.name
        holder.role.text = list[position].role.role
        holder.rootView.setOnClickListener {
//            val intent = Intent(context, DetailActivity::class.java)
//            intent.putExtra("location",list[position].woeid)
//            intent.putExtra("name",list[position].title)
//            context.startActivity(intent)
            debug("click","bhai click ho raha hai ispe : ${holder.rootView}")
        }
    }

}