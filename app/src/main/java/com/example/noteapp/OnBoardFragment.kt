package com.example.noteapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.noteapp.databinding.FragmentOnBoardBinding

class OnBoardFragment : Fragment() {
    private lateinit var binding : FragmentOnBoardBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentOnBoardBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
    private fun initialize(){
        binding.vpOne.adapter= OnBoardViewPagerAdapter(this@OnBoardFragment)
        initialize()
        setupListener()

    }
    private  fun setupListener()= with(binding.vpOne){
        binding.btnViewPager.setOnClickListener{
         if (currentItem<3){
             setCurrentItem(currentItem + 2, true)
         }
            if (currentItem<2){
                setCurrentItem(currentItem + 1, true)
            }
        }
    }

}