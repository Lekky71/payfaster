package com.hashcode.payfastfast.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.google.android.material.textfield.TextInputEditText
import com.hashcode.payfastfast.R
import com.hashcode.payfastfast.data.PreferenceManager


class SettingsFragment : Fragment() {
    lateinit var nameInputEditText: TextInputEditText
    lateinit var saveButton: Button
    lateinit var preferenceManager: PreferenceManager

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_settings, container, false)
        nameInputEditText = view.findViewById(R.id.nameTextInputEditText)
        saveButton = view.findViewById(R.id.saveButton)
        preferenceManager = PreferenceManager(context!!)

        nameInputEditText.setText(preferenceManager.userFullName)
        saveButton.setOnClickListener {
            if(nameInputEditText.text!!.length < 5){
                Toast.makeText(context, "Name must be a minimum of 5 characters", Toast.LENGTH_SHORT).show()
            }
            else {
                val name = nameInputEditText.text.toString()
                preferenceManager.userFullName = name
                Toast.makeText(context, "Name Updated!", Toast.LENGTH_SHORT).show()
                view.findNavController().navigate(R.id.payFragment)
            }
        }

        return view
    }

}
