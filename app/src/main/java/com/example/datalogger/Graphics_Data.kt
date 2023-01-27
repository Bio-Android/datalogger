package com.example.datalogger

import android.graphics.Color
import android.graphics.Insets.add
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.datalogger.Model.Dispositivo

import com.example.datalogger.adapter.AdaptRecyFragment




class Graphics_Data : Fragment() {

    lateinit var recyclerView: RecyclerView
    lateinit var adapterTareas: AdaptRecyFragment
    val listatemporal : MutableList<Dispositivo> = arrayListOf(Dispositivo("Hospitalizacion","Nicolas San Juan","123","Hospitalizacion",12,100))


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ):View?{


        println( "hola"+requireArguments().get("dispositivo"))
        listatemporal.add(requireArguments().get("dispositivo") as Dispositivo)
        return inflater.inflate(R.layout.fragment_graphics__data, container, false)
}

    override fun onViewCreated(view: View,savedInstanceState: Bundle?){
    super.onViewCreated(view, savedInstanceState)
        val layoutManager = LinearLayoutManager(context)
        recyclerView=view.findViewById(R.id.recycler_fragment)
        recyclerView.layoutManager =layoutManager
        recyclerView.setHasFixedSize(true)

        adapterTareas=AdaptRecyFragment(listatemporal)
        adapterTareas.updateadapterfragment(listatemporal)
        recyclerView.adapter = adapterTareas

    }

}


//barchart = findViewById(R.id.barChart)

/* barList = ArrayList()
 barList.add(BarEntry(1f,500f))
 barList.add(BarEntry(2f,100f))
 barList.add(BarEntry(8f,800f))
 barList.add(BarEntry(4f,400f))
 barList.add(BarEntry(5f,200f))*/

/*lineList=ArrayList()
lineList.add(Entry(1f,500f))
lineList.add(Entry(2f,100f))
lineList.add(Entry(4f,400f))
lineList.add(Entry(5f,200f))
lineList.add(Entry(8f,800f))*/

/* barDataset= BarDataSet(barList,"Poblacion")
barData= BarData(barDataset)
barchart.data= barData
barDataset.setColors(ColorTemplate.JOYFUL_COLORS,250)
barDataset.valueTextColor= Color.BLACK
barDataset.valueTextSize=15f*/

/* lateinit var barchart : BarChart
 lateinit var  barList: ArrayList<BarEntry>
 lateinit var barDataset:BarDataSet
 lateinit var barData: BarData*/