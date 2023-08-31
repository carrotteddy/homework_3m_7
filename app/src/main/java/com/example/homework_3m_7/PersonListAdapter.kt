package com.example.homework_3m_7

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.NavController
import androidx.navigation.NavOptions
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.bumptech.glide.Glide

class PersonListAdapter(
    private val personArrayList: ArrayList<Person>,
    private val navController: NavController
) : Adapter<PersonListAdapter.ViewHolder>() {
    private lateinit var context: Context


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val personName: TextView = itemView.findViewById(R.id.person_name)
        val personStatus: TextView = itemView.findViewById(R.id.person_status)
        val personImg: ImageView = itemView.findViewById(R.id.img_person)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        context = parent.context
        val view = LayoutInflater.from(context).inflate(R.layout.list_item, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return personArrayList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val person = personArrayList[position]
        holder.personName.text = person.name
        holder.personStatus.text = person.status
        Glide.with(context).load(person.image).into(holder.personImg)
        holder.itemView.setOnClickListener {
            val bundle = Bundle()
            bundle.putSerializable("person", person)
            navController.navigate(R.id.main_fragment_to_detail_fragment, bundle,
                NavOptions.Builder().setPopUpTo(R.id.mainFragment, false).build())
        }
    }
}