package com.gmail.supajeew.project02


import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.gmail.supajeew.project02.databinding.FragmentGreetingBinding
import com.gmail.supajeew.project02.databinding.FragmentQuestionBinding

/**
 * A simple [Fragment] subclass.
 */
class greeting_Fragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        Log.i("greeting", "onCreate Greeting")
        val binding = DataBindingUtil.inflate<FragmentGreetingBinding>(inflater,
            R.layout.fragment_greeting_,container,false)
        return binding.root
    }



}
