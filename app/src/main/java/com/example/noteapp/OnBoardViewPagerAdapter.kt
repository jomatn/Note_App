package com.example.noteapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.noteapp.OnBoardPagingFragment.Companion.ARG_ONBOARD_POSITION

class OnBoardViewPagerAdapter (fragment: Fragment)
    : FragmentStateAdapter(fragment){
    override fun getItemCount(): Int {
        return 3
    }

    override fun createFragment(position: Int) = OnBoardPagingFragment().apply {
        arguments = Bundle().apply {
            putInt(ARG_ONBOARD_POSITION, position)
        }
    }

//    private fun getAnimationFileName(position: Int): String {
//        return when (position) {
//            0 -> "Animation - 1712835860849.json"
//            1 -> "Animation - 2.json"
//            2 -> "Animation - 1.json"
//            else -> throw IllegalArgumentException("Invalid position: $position")
//        }
//    }

}