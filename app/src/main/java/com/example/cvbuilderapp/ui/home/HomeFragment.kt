package com.example.cvbuilderapp.ui.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.TextView
import com.example.cvbuilderapp.R
import com.example.cvbuilderapp.constants.Constant
import com.example.cvbuilderapp.constants.Constant.USER_EMAIL
import com.example.cvbuilderapp.constants.Constant.USER_NAME
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar

class HomeFragment : Fragment(R.layout.fragment_home) {

    private lateinit var userNameTextView: TextView

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initViews(view)
    }

    private fun initViews(view: View) {
        val floatingAddButton = view.findViewById<FloatingActionButton>(R.id.floating_add_button)
        userNameTextView = view.findViewById(R.id.user_name_text_view)

        floatingAddButton.setOnClickListener {
            Snackbar.make(view, "Add Additional fields on home page", Snackbar.LENGTH_LONG).show()
        }

    }

    private fun initUserData() {
        val sharedPref = requireActivity().getSharedPreferences(Constant.SP_NAME, 0)
        val userName = sharedPref.getString(USER_NAME, "")
        val userEmail = sharedPref.getString(USER_EMAIL, "")

        userNameTextView.text = userName

    }

    companion object {
        @JvmStatic
        fun newInstance() = HomeFragment()
    }
}