package com.gmail.supajeew.project02


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
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
        return binding.root
    }


}
