package com.example.noteapp.ui.fragment.onBoard

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.noteapp.R
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

    private fun initialize() {

        when (requireArguments().getInt(ARG_ONBOARD_POSITION)){
            0 -> {
                binding.tvOn.text = "Очень удобный функционал;"
                binding.lottie.setAnimation(R.raw.Animation2)
            }
            1 -> {
                binding.tvOn.text = "Быстрый, качественный продукт"
                binding.lottie.setAnimation(R.raw.Animation3)
            }
            2 -> {
                binding.tvOn.text = "Куча функций и интересных фишек"
                binding.lottie.setAnimation(R.raw.Animation4)
            }
        }
    }


    companion object{
        const val ARG_ONBOARD_POSITION = "onBoard"
    }

}

