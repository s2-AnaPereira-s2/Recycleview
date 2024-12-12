package com.devspace.recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView

class ContactListAdapter:
    ListAdapter<contact, ContactListAdapter.ContactViewHolder>(ContactDiffUtil()) {

    private lateinit var onClickListener: (contact) -> Unit

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_list, parent, false)
        return ContactViewHolder(view)
    }

    override fun onBindViewHolder(holder: ContactViewHolder, position: Int) {
        val contact = getItem(position)
        holder.bind(contact, onClickListener)
    }

    fun setOnClickListener(listener: (contact) -> Unit){
        onClickListener = listener
    }


    class ContactViewHolder(private val view: View): RecyclerView.ViewHolder(view){
        private val tv_name = view.findViewById<TextView>(R.id.tv_name)
        private val tv_phone = view.findViewById<TextView>(R.id.tv_phone)
        private val image = view.findViewById<ImageView>(R.id.image)

        fun bind(contact: contact, listener: (contact) -> Unit){
            tv_name.text = contact.name
            tv_phone.text = contact.phone
            image.setImageResource(contact.image)

            view.setOnClickListener {
                listener.invoke(contact)
            }


        }

    }

    class ContactDiffUtil: DiffUtil.ItemCallback<contact>(){
        override fun areItemsTheSame(oldItem: contact, newItem: contact): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: contact, newItem: contact): Boolean {
            return oldItem.name == newItem.name
        }

    }

}