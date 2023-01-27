package com.example.datalogger.adapter

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.datalogger.Model.DataModel
import com.example.datalogger.Model.Dispositivo
import com.example.datalogger.R
import com.github.mikephil.charting.charts.LineChart
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet
import com.github.mikephil.charting.utils.ColorTemplate

// recordar cambiar  el arraylist  a  DATAMODEL
class AdaptRecyFragment(private var newList : List<Dispositivo>):RecyclerView.Adapter<AdaptRecyFragment.MyViewHolder> (){




    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView=LayoutInflater.from(parent.context)
        return MyViewHolder(itemView.inflate(R.layout.itemgraphics_data,parent,false))
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        holder.ligarvista()
        val currentItem= newList[position]
        holder.lineList.add(Entry(6f,currentItem.temp.toFloat()))
        holder.linedataset = LineDataSet(holder.lineList,"Poblacion")
        holder.linedataset.setLineWidth(7f)
        holder.linedata = LineData(holder.linedataset)



        holder.grafica.data = holder.linedata
        holder.campotitulo.text = currentItem.Hospital
        holder.textVarea.text = currentItem.Area
        holder.textVid.text = currentItem.Id
        holder.textVtemp.text = currentItem.temp.toString()
        holder.textVhum.text = currentItem.hum.toString()
    }

    override fun getItemCount(): Int {
        return newList.size

    }


    fun updateadapterfragment(lista: List<Dispositivo>) {
        newList = lista
        notifyDataSetChanged() }

    inner class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){

        lateinit var lineList: ArrayList<Entry>
        lateinit var linedataset:LineDataSet
        lateinit var linedata:LineData
        lateinit var campotitulo : TextView
        lateinit var grafica : LineChart
        lateinit var textVtemp: TextView
        lateinit var textVhum: TextView
        lateinit var textVarea: TextView
        lateinit var textVubicacion: TextView
        lateinit var textVid: TextView

         fun ligarvista (){

              grafica= itemView.findViewById(R.id.lineChart)

              campotitulo = itemView.findViewById(R.id.textVtitulo)
              textVtemp = itemView.findViewById(R.id.textVtemp)
              textVhum = itemView.findViewById(R.id.textVhum)
              textVarea = itemView.findViewById(R.id.textVarea)
              textVubicacion = itemView.findViewById(R.id.textVubicacion)
              textVid  = itemView.findViewById(R.id.textVid)

             lineList= ArrayList()
             lineList.add(Entry(1f,500f))
             lineList.add(Entry(2f,100f))
             lineList.add(Entry(4f,400f))
             lineList.add(Entry(5f,200f))


             linedataset = LineDataSet(lineList,"Poblacion")
             linedataset.setLineWidth(7f)


             linedataset.setColors(ColorTemplate.JOYFUL_COLORS,250)
             linedataset.valueTextColor= Color.BLACK
             linedataset.valueTextSize=15f
             linedataset.setColor(Color.GREEN)

         }





    }

}

/*  lineDataset = LineDataSet(lineList,"Poblacion")
        lineDataset.setLineWidth(3f)
        lineData = LineData(lineDataset)
        linechart.data = lineData
        lineDataset.setColors(ColorTemplate.JOYFUL_COLORS,250)
        lineDataset.valueTextColor= Color.BLACK
        lineDataset.valueTextSize=15f
        lineDataset.setColor(Color.GREEN)
        lateinit var lineDataset: LineDataSet
        lateinit var lineData: LineData
 */