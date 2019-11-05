package com.gmail.supajeew.project02

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.gmail.supajeew.project02.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.fragment_question.*

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private var _showSnackbarEvent = MutableLiveData<Boolean>()

    val showSnackBarEvent: LiveData<Boolean>
        get() = _showSnackbarEvent

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.i("MainActivity", "onCreate Called")
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        val navController = this.findNavController(R.id.myNavHostFragment)
        NavigationUI.setupActionBarWithNavController(this,navController)
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = this.findNavController(R.id.myNavHostFragment)
        return navController.navigateUp()
    }

//    override fun onDestroy() {
//        super.onDestroy()
//        Log.i("MainActivity", "onDestroy Called")
//    }
//
//    override fun onStart() {
//        super.onStart()
//        Log.i("MainActivity", "onStart Called")
//    }
//
//    override fun onStop() {
//        super.onStop()
//        Log.i("MainActivity", "onStop Called")
//    }

    fun doneShowingSnackbar() {
        _showSnackbarEvent.value = false
    }
}
