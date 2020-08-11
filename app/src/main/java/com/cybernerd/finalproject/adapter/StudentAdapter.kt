package com.cybernerd.finalproject.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.cybernerd.finalproject.R
import com.cybernerd.finalproject.model.Result
import com.cybernerd.finalproject.utils.debug
import kotlinx.android.synthetic.main.rv_user_child.view.*

class StudentAdapter(private val context: Context) :
    RecyclerView.Adapter<StudentAdapter.ViewHolder>(){

    private var list: List<Result> = ArrayList()

    fun setStudent(list: List<Result>){
        this.list = list
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentAdapter.ViewHolder {
        return ViewHolder(
            LayoutInflater.from(context).inflate(R.layout.rv_user_child
                , parent, false)
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

    override fun onBindViewHolder(holder: StudentAdapter.ViewHolder, position: Int) {

        holder.name.text = list[position].first_name
        holder.department.text = list[position].department?.name
        holder.role.text = list[position].role?.role
        holder.rootView.setOnClickListener {
//            val intent = Intent(context, ClassroomDetailActivity::class.java)
//            intent.putExtra("name",list[position].name)
//            intent.putExtra("description",list[position].description)
//            context.startActivity(intent)
            debug("click","bhai click ho raha hai ispe : ${holder.rootView}")
        }
    }

}