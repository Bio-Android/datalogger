package com.example.datalogger.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.datalogger.databinding.Item1Binding

//class UserViewHolder(private val itembinding:ItemuserBinding):RecyclerView.ViewHolder(itembinding.root){
 class UserViewHolder(view: View):RecyclerView.ViewHolder(view)  {

    val binding = Item1Binding.bind(view)
    var position: Int? = null

   fun bindtItems(valor: String,click:(String)->Unit) { // click recibe un elemento de tipo funcion String
        binding.root.setOnClickListener(){
            //click.invoke(valor)
            if(position==null) {
                position = adapterPosition
            }
            click.invoke(position.toString())
            println("posicion " + position.toString())
        }

        binding.tViewHospital.text = valor

    }


}



