package com.gmail.supajeew.project02


import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.gmail.supajeew.project02.databinding.FragmentGreetingBinding
import com.gmail.supajeew.project02.databinding.FragmentQuestionBinding
import com.gmail.supajeew.project02.databinding.FragmentScoreBinding
import kotlinx.android.synthetic.main.fragment_question.*

class ScoreFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        val binding = DataBindingUtil.inflate<FragmentScoreBinding>(inflater,
            R.layout.fragment_score,container,false)

        //The complete onClickListener with Navigation
        binding.tryButton.setOnClickListener {
            findNavController().navigate(R.id.action_scoreFragment_to_questionFragment)
        }

        binding.homeButton.setOnClickListener {
            findNavController().navigate(R.id.action_scoreFragment_to_homeFragment)
        }

        setHasOptionsMenu(true)
        return binding.root
    }


}
