package com.example.noteapp.ui.fragment.onBoard

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.navigation.fragment.findNavController
import androidx.viewpager2.widget.ViewPager2
import com.example.noteapp.R
import com.example.noteapp.data.Pref
import com.example.noteapp.ui.adapter.OnBoardViewPagerAdapter
import com.example.noteapp.databinding.FragmentOnBoardBinding

class OnBoardFragment : Fragment() {
    private lateinit var binding: FragmentOnBoardBinding
    val dots = binding.dots
    val viewPager2 = binding.viewPager2

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
        setupListener()

    }

    private fun initialize() {
        binding.viewPager2.adapter = OnBoardViewPagerAdapter(this@OnBoardFragment)
    }

    private fun setupListener() {
        binding.tvSend.setOnClickListener {
            val currentItem = binding.viewPager2.currentItem
            if (currentItem < 2) {
                binding.viewPager2.setCurrentItem(currentItem + 1, true)
            } else {
                findNavController().navigate(R.id.noteFragment)
            }
            if (currentItem == 2) {
                binding.tvSend.isVisible = false
                binding.tvGetStarted.isVisible = true
            }
        }
        binding.tvGetStarted.isVisible = false
        findNavController().navigate(R.id.noteFragment)

    }
    private fun btnGetStarted() = with(binding) {
        viewPager2.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                when (position) {
                    0 -> {
                        tvSend.isVisible = true
                        tvGetStarted.isVisible = false
                    }

                    1 -> {
                        tvSend.isVisible = true
                        tvGetStarted.isVisible = false
                    }

                    2 -> {
                        tvSend.isVisible = false
                        tvGetStarted.isVisible = true
                    }
                }
                super.onPageSelected(position)
            }
        })
    }

    private fun openHome() {
        Pref.isOnBoardShown = true
    }

}



