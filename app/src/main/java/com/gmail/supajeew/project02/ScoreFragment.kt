package com.gmail.supajeew.project02

import android.content.Intent
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.gmail.supajeew.project02.databinding.FragmentGreetingBinding
import com.gmail.supajeew.project02.databinding.FragmentQuestionBinding
import com.gmail.supajeew.project02.databinding.FragmentScoreBinding
import com.google.android.material.snackbar.Snackbar
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
    // Creating our Share Intent
    private fun getShareIntent() : Intent {

        val shareIntent = Intent(Intent.ACTION_SEND)
        shareIntent.setType("text/plain")
            .putExtra(Intent.EXTRA_TEXT, getString(R.string.share))
        return shareIntent
    }
    // Starting an Activity with our new Intent
    private fun shareSuccess() {
        startActivity(getShareIntent())
    }

    // Showing the Share Menu Item Dynamically
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater?.inflate(R.menu.share_menu, menu)
        // check if the activity resolves
        if (null == getShareIntent().resolveActivity(activity!!.packageManager)) {
            // hide the menu item if it doesn't resolve
            menu?.findItem(R.id.share)?.setVisible(false)
        }
    }

    // Sharing from the Menu
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item!!.itemId) {
            R.id.share -> shareSuccess()
        }
        return super.onOptionsItemSelected(item)
    }

}
