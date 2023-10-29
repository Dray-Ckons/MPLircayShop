package com.example.mplircayshop.oneapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.example.mplircayshop.R

class CuartoFragment : Fragment() {

    private lateinit var logoutButton: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_cuarto, container, false)

        logoutButton = view.findViewById(R.id.logoutButton)
        logoutButton.setOnClickListener {
            activity?.finish()
        }

        return view
    }
}
