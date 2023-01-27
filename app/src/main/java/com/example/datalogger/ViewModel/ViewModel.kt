package com.example.datalogger.ViewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.datalogger.DataSource.DataSource
import com.example.datalogger.Model.DataModel
import com.example.datalogger.Model.Dispositivo
import com.example.datalogger.Repositorio.Repositorio
import kotlin.collections.ArrayList

class ViewModel  : ViewModel() {


    var listdata: MutableLiveData<ArrayList<DataModel>> = MutableLiveData<ArrayList<DataModel>>()

    var misdispositivos: MutableLiveData<List<Dispositivo>> = MutableLiveData()


    public lateinit var repositorio: Repositorio
    lateinit var dataSource: DataSource
    init {
        repositorio = Repositorio()
        dataSource=repositorio.getDataSource()
    }

  fun loadData(): MutableLiveData<List<Dispositivo>> {
      misdispositivos=dataSource.misdispositivos //recordar que las variables se llaman igual y que son del mismo tipo
      dataSource.recoverydata()
      return(misdispositivos)
    }
}

