package com.gmail.supajeew.project02


import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.gmail.supajeew.project02.databinding.FragmentHomeBinding
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.fragment_question.*

class HomeFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val binding = DataBindingUtil.inflate<FragmentHomeBinding>(inflater,
            R.layout.fragment_home,container,false)

        //The complete onClickListener with Navigation
        binding.questionButton.setOnClickListener { view : View ->
            view.findNavController().navigate(R.id.action_homeFragment_to_questionFragment)

        }
        //The complete onClickListener with Navigation
        binding.greetingButton.setOnClickListener { view : View ->
            view.findNavController().navigate(R.id.action_homeFragment_to_greeting_Fragment)
        }
        setHasOptionsMenu(true)
        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater?.inflate(R.menu.option_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.onNavDestinationSelected(item!!,
            view!!.findNavController())
                || super.onOptionsItemSelected(item)
    }
    override fun onStart() {
        super.onStart()
        Log.i("MainActivity", "onStartHome Called")
    }
}
