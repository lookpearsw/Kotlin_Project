package com.gmail.supajeew.project02


import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.gmail.supajeew.project02.databinding.FragmentHomeBinding
import com.gmail.supajeew.project02.question.GameViewModel

class HomeFragment : Fragment() {
    private lateinit var viewModel: GameViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val binding = DataBindingUtil.inflate<FragmentHomeBinding>(inflater,
            R.layout.fragment_home,container,false)
        (activity as AppCompatActivity).supportActionBar?.title = "Greeting Singapore"
        Log.i("QuestionFragment", "Called ViewModelProviders.of")
        viewModel = ViewModelProviders.of(this).get(GameViewModel::class.java)

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
