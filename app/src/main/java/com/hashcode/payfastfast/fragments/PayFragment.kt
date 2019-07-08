package com.hashcode.payfastfast.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.hashcode.biometric.BiometricCallback
import com.hashcode.biometric.BiometricManager
import com.hashcode.payfastfast.R
import com.hashcode.payfastfast.data.PreferenceManager


class PayFragment : Fragment() {

    lateinit var payButton: Button
    lateinit var amountEditText: EditText

    fun showToast(message: String) {
        Toast.makeText(context, message, Toast.LENGTH_LONG).show()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_pay, container, false)

        payButton = view.findViewById(R.id.payButton)
        amountEditText = view.findViewById(R.id.amountEditText)
        var amount = 100.00

        val biometricCallback = object : BiometricCallback {
            override fun onSdkVersionNotSupported() {
                showToast(context!!.getString(R.string.biometric_error_sdk_not_supported))
            }

            override fun onBiometricAuthenticationNotSupported() {
                showToast(context!!.getString(R.string.biometric_error_hardware_not_supported))
            }

            override fun onBiometricAuthenticationNotAvailable() {
                showToast(context!!.getString(R.string.biometric_error_fingerprint_not_available))
            }

            override fun onBiometricAuthenticationPermissionNotGranted() {
                showToast(context!!.getString(R.string.biometric_error_permission_not_granted))
            }

            override fun onBiometricAuthenticationInternalError(error: String) {
                showToast(error)
            }

            override fun onAuthenticationFailed() {
                showToast(context!!.getString(R.string.biometric_failure))
            }

            override fun onAuthenticationCancelled() {
            }

            override fun onAuthenticationSuccessful() {
                showToast("successful")
                val preferenceManager = PreferenceManager(context!!)
                preferenceManager.amount = amount
                view.findNavController().navigate(R.id.banksFragment)
            }

            override fun onAuthenticationHelp(helpCode: Int, helpString: CharSequence) {
                showToast(helpString.toString())
            }

            override fun onAuthenticationError(errorCode: Int, errString: CharSequence) {
                showToast(errString.toString())
            }
        }

        payButton.setOnClickListener {
            if(amountEditText.text.toString().length < 3){
                showToast("Minimum of 100 naira")
            }
            else {
                amount = amountEditText.text.toString().toDouble()
                BiometricManager.BiometricBuilder(context!!)
                    .setTitle("Payment")
                    .setSubtitle("Get all your accounts")
                    .setDescription("Place your finger on your fingerprint scanner")
                    .setNegativeButtonText("Cancel")
                    .build()
                    .authenticate(biometricCallback)

            }
        }

        return view
    }

}
