package com.example.datalogger.adapter

import android.view.LayoutInflater

import android.view.ViewGroup

import androidx.recyclerview.widget.RecyclerView
import com.example.datalogger.Model.Dispositivo
import com.example.datalogger.R


class Adapter(private var lista: ArrayList<String>, private val click : (String) -> Unit) :
    RecyclerView.Adapter<UserViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        // return UserViewHolder(ItemuserBinding.inflate(LayoutInflater.from(parent.context)))
        return UserViewHolder(layoutInflater.inflate(R.layout.item1, parent, false))
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val item = lista[position]
        holder.bindtItems(item,click)
       // val itempos = lista.get(holder.adapterPosition)


    }


    override fun getItemCount(): Int = lista.size

    fun updateadapter(nuevalista: ArrayList<String>) {
        lista = nuevalista
        notifyDataSetChanged()// es necesaria esta instruccion para mostar los datos en el recycler
    }

}

