package com.example.datalogger

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.SearchView
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.example.datalogger.Model.Dispositivo
import com.example.datalogger.Repositorio.Repositorio
import com.example.datalogger.ViewModel.ViewModel
import com.example.datalogger.adapter.Adapter
import com.example.datalogger.databinding.FragmentMainBinding
import com.example.datalogger.adapter.UserViewHolder as UserViewHolder1

class fragment_main : Fragment() {


    lateinit var adapter: Adapter
    lateinit var repositorio: Repositorio
    lateinit var VModel: ViewModel
    lateinit var copiadispositivos:List<Dispositivo>
    lateinit var dispositivotoswhow: Dispositivo
    var listhospitales = arrayListOf<String>()


    private lateinit var binding: FragmentMainBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        binding = FragmentMainBinding.inflate(layoutInflater)


        VModel = ViewModel()
        val listadapter: ArrayAdapter<String> =
            ArrayAdapter(requireContext(), android.R.layout.simple_list_item_1, listhospitales)


        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                binding.searchView.clearFocus()
                var hospsearch: ArrayList<String> = arrayListOf()
                if (query != null) {

                    for (listhosp in listhospitales) {

                        if (listhosp.lowercase().contains(query.lowercase())) {
                            hospsearch.add(listhosp)
                            adapter.updateadapter(hospsearch)

                            Toast.makeText(
                                requireContext(),
                                "si lo encuentra",
                                Toast.LENGTH_SHORT
                            )
                                .show()

                        }
                        /* if (listhospitales.map{it.lowercase() }.contains(query.lowercase())){ //tambien funciona
                        //listadapter.filter.filter((query))
                        Toast.makeText(applicationContext,"si lo encuentra",Toast.LENGTH_SHORT).show()
                        //
                    }*/
                    }
                }
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                if (newText == "") {
                    adapter.updateadapter(listhospitales)
                }

                return false
            }

        })

        VModel.loadData().observe(viewLifecycleOwner, Observer {
            println("datos traidos desde el viewmodel")
            println(it.toString())
            it.forEach { listhospitales.add(it.Hospital) }
            println(listhospitales)
            println(it[2].Hospital)
            adapter.updateadapter(listhospitales)
            copiadispositivos=it.toList()
            println(copiadispositivos.toString())
        })
        adapter   = Adapter(listhospitales,::clickenelemento)// por que  cuando manda a llamar a la funcion el compilador no respinga, por no pasarle los argumentos?

        binding.mainrecycler.adapter = adapter
        return binding.root

    }

    private fun clickenelemento(x:String) {
        Toast.makeText(requireContext(), "posicion: " + x, Toast.LENGTH_SHORT).show()
        dispositivotoswhow=copiadispositivos[x.toInt()]
        println(dispositivotoswhow)


        // me tiene que lanzar al fragment con los datos de firebase
        findNavController().navigate(R.id.action_fragment_main_to_graphics_Data2,Bundle().apply { putSerializable("dispositivo", dispositivotoswhow)})
        //val itemselectedposition=copiadispositivos.get(valor.toInt())
        // enviar  datos con navigation controller  navparams
    }
    private fun showError() {
        Toast.makeText(requireContext(), "Ha ocurrido un error", Toast.LENGTH_SHORT).show()
    }

    //  Nota en  onresume  si  el searchview contiene  algo  que  realize la busqueda, para que al rotar  no se pierda lavista

}


// subir una version basica a github  sin mostrar credenciales  preguntar a uvaldo como hago eso

