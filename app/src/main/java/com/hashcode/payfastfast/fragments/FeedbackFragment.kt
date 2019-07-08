package com.hashcode.payfastfast.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.hashcode.payfastfast.R
import com.hashcode.payfastfast.data.PreferenceManager
import com.hashcode.payfastfast.model.SMSRequest
import com.hashcode.payfastfast.network.AppEndpointInterface
import com.hashcode.payfastfast.network.RetrofitBuilder
import retrofit2.Retrofit

class FeedbackFragment : Fragment() {
    lateinit var feedbackTextView: TextView
    lateinit var feedbackImageView: ImageView
    lateinit var preferenceManager : PreferenceManager
    lateinit var tryAgainButton : Button

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_feedback, container, false)
        feedbackTextView = view.findViewById(R.id.feedbackTextView)
        feedbackImageView = view.findViewById(R.id.feedbackImageView)
        tryAgainButton = view.findViewById(R.id.tryAgainButton)

        preferenceManager = PreferenceManager(context!!)

        if(preferenceManager.sendStatus){
            feedbackTextView.text = "Payment Successful"
            feedbackImageView.setImageResource(R.drawable.ic_success)
            tryAgainButton.visibility = View.GONE

        }
        else {
            feedbackTextView.text = "Payment Failed"
            feedbackImageView.setImageResource(R.drawable.ic_warning)
            tryAgainButton.visibility = View.VISIBLE
            tryAgainButton.setOnClickListener {
                view.findNavController().navigate(R.id.payFragment)
            }
        }
        return view
    }


}
