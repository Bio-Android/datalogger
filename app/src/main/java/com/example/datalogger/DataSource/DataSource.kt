package com.example.datalogger.DataSource

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.datalogger.Model.DataModel
import com.example.datalogger.Model.Dispositivo
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class DataSource {

    var misdispositivos: MutableLiveData<List<Dispositivo>> = MutableLiveData()
     fun recoverydata(){
         var firebase :FirebaseDatabase = FirebaseDatabase.getInstance()
         var myInfo = firebase.getReference("dispositivos")

         myInfo.addValueEventListener(object : ValueEventListener {
             override fun onDataChange(dataSnapshot: DataSnapshot) {
               Log.e( "pppppp","onDataChange $dataSnapshot")
                 var  lista: ArrayList<Dispositivo> = arrayListOf()
                 for (mydatasnapShot in dataSnapshot.children){

                    var mydevice=mydatasnapShot.getValue(Dispositivo::class.java)// el snapshot se trae un objeto tipo json
                     // y se crea la variable my device a la cual se le pega estos datos pero formateados a tipo Dispositivo
                     if (mydevice != null) {
                         lista.add(mydevice)
                     }
                     println(mydatasnapShot)
                     misdispositivos.postValue(lista)
                 }

               /* if (dataSnapshot.hasChildren()) { // con este if verificamos que exista y que tenga ramas
                     for (mydatasnapShot in dataSnapshot.children){
                         var getdata: MutableList<DataModel> = mydatasnapShot.children.map{ mydatasnapShot->mydatasnapShot.getValue(DataModel::class.java)
                          }
                     }*/
                 }

             override fun onCancelled(error: DatabaseError) {
                 println("fallo")
             }

         } )
     }
}