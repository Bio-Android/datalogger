package com.example.datalogger

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.Navigation
import com.example.datalogger.databinding.MainActivityBinding


class MainActivity : AppCompatActivity()  {


    private lateinit var binding: MainActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=MainActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val navigationcontroller= Navigation.findNavController(this,R.id.fragmentContainerView)

    }

}