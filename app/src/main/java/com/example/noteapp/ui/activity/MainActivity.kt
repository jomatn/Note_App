package com.example.noteapp.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.example.noteapp.data.Pref
import com.example.noteapp.R
import com.example.noteapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.fragment_container)as NavHostFragment

        navController= navHostFragment.navController

        if (Pref.isOnBoardShown){
            navController.navigate(R.id.noteFragment)
        }else{
            navController.navigate(R.id.onBoardFragment)
        }
    }
}