package com.example.datalogger.Model

import java.io.Serializable

data class Dispositivo(
    var Area: String,
    var Hospital: String,
    var Id: String,
    var Ubicacion: String,
    var hum: Int,
    var temp: Int
):Serializable{
constructor() : this("","","","",0,0)
}