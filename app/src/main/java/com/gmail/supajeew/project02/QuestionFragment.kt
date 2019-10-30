package com.gmail.supajeew.project02


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.gmail.supajeew.project02.databinding.FragmentHomeBinding
import com.gmail.supajeew.project02.databinding.FragmentQuestionBinding
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.fragment_question.*
import kotlinx.android.synthetic.main.fragment_score.*

class QuestionFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val binding = DataBindingUtil.inflate<FragmentQuestionBinding>(inflater,
            R.layout.fragment_question,container,false)

        //The complete onClickListener with Navigation
        binding.ans1Button.setOnClickListener {
            Toast.makeText(context, "False", Toast.LENGTH_SHORT).show()
            findNavController().navigate(R.id.action_questionFragment_to_scoreFragment)
        }
        binding.ans2Button.setOnClickListener {
            var snack = view?.let {
                Snackbar.make(it, "True", Snackbar.LENGTH_LONG)
            }
            snack?.show()
            findNavController().navigate(R.id.action_questionFragment_to_question2Fragment)
        }
        binding.ans3Button.setOnClickListener {
            findNavController().navigate(R.id.action_questionFragment_to_scoreFragment)
        }

        return binding.root
    }
}
