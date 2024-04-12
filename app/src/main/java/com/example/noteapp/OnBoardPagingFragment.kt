package com.example.noteapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.noteapp.databinding.FragmentOnBoardBinding
import com.example.noteapp.databinding.FragmentOnBoardPagingBinding

class OnBoardPagingFragment : Fragment() {

    private lateinit var binding: FragmentOnBoardPagingBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentOnBoardPagingBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initialize()
    }
    private fun initialize()= binding.apply{
       when(requireArguments().getInt(ARG_ONBOARD_POSITION)){
           0 -> {
               tvTitle.text = "Очень удобный функционал;"
           }
           1->{
               tvTitle.text = "Быстрый, качественный продукт"
           }
           2->{
               tvTitle.text = "Куча функций и интересных фишек"
           }
       }
    }
    companion object{
        const val ARG_ONBOARD_POSITION = "onBoard"
    }
}

