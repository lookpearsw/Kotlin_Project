package com.gmail.supajeew.project02

import android.content.Context
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.gmail.supajeew.project02.databinding.FragmentQuestion2Binding
import com.gmail.supajeew.project02.databinding.FragmentQuestionBinding

class Question2Fragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val binding = DataBindingUtil.inflate<FragmentQuestion2Binding>(inflater,
            R.layout.fragment_question2,container,false)

        //The complete onClickListener with Navigation
        binding.ans1Button.setOnClickListener { view : View ->
            view.findNavController().navigate(R.id.action_question2Fragment_to_scoreFragment)
        }
        binding.ans2Button.setOnClickListener { view : View ->
            view.findNavController().navigate(R.id.action_question2Fragment_to_scoreFragment)
        }
        binding.ans3Button.setOnClickListener { view : View ->
            view.findNavController().navigate(R.id.action_question2Fragment_to_scoreFragment)
        }
        return binding.root
    }
}
