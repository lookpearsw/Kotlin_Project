package com.gmail.supajeew.project02


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.gmail.supajeew.project02.databinding.FragmentHomeBinding
import com.gmail.supajeew.project02.databinding.FragmentQuestionBinding

/**
 * A simple [Fragment] subclass.
 */
class QuestionFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val binding = DataBindingUtil.inflate<FragmentQuestionBinding>(inflater,
            R.layout.fragment_question,container,false)

        //The complete onClickListener with Navigation
        binding.ans1Button.setOnClickListener { view : View ->
            view.findNavController().navigate(R.id.action_questionFragment_to_scoreFragment)
        }
        binding.ans2Button.setOnClickListener { view : View ->
            view.findNavController().navigate(R.id.action_questionFragment_to_question2Fragment)
        }
        binding.ans3Button.setOnClickListener { view : View ->
            view.findNavController().navigate(R.id.action_questionFragment_to_scoreFragment)
        }
        return binding.root
    }


}
