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
        initialize()
    }
    private fun initialize() {
        binding.viewPager2.adapter = OnBoardViewPagerAdapter(this@OnBoardFragment)
        setupListener()
    }

    private fun setupListener() {
        binding.tvSend.setOnClickListener() {
            val currentItem = binding.viewPager2.currentItem
            if (currentItem < 2) {
                binding.viewPager2.setCurrentItem(currentItem + 1, true)
            } else {
                binding.viewPager2.setCurrentItem(0, true)
            }
        }
    }


}