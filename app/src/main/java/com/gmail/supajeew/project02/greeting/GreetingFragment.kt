package com.gmail.supajeew.project02.greeting


import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.gmail.supajeew.project02.R
import com.gmail.supajeew.project02.databinding.FragmentGreetingBinding
import com.gmail.supajeew.project02.question.GameViewModel

/**
 * A simple [Fragment] subclass.
 */
class GreetingFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        Log.i("greeting", "onCreate Greeting")
        val binding = DataBindingUtil.inflate<FragmentGreetingBinding>(inflater,
            R.layout.fragment_greeting_,container,false)
        val viewModel = ViewModelProviders.of(this).get(GreetingViewModel::class.java)
        val adapter = GreetingAdapter()
        adapter.replaceItems(viewModel.data)
        binding.greetingRecycleView.adapter = adapter
        return binding.root
    }



}
