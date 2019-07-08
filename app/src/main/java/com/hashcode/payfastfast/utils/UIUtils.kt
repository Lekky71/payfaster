package com.hashcode.payfastfast.utils

import android.content.Context
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import com.hashcode.biometric.BiometricCallback
import com.hashcode.biometric.BiometricManager

class UIUtils(var context: Context) {

//    private var popupWindow: PopupWindow? = null
//
//    fun showLoading(parentView: View, message: String) {
//        val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
//        val view = inflater.inflate(R.layout.loading_overlay, null, false)
//        view.findViewById<TextView>(R.id.messageTextView).text = message
//        popupWindow = PopupWindow(view, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT, true)
//
//        if (popupWindow != null) popupWindow!!.showAtLocation(parentView, Gravity.CENTER, 0, 0)
//
//    }
//
//    fun stopLoading() {
//        if (popupWindow != null) {
//            popupWindow!!.dismiss()
//        }
//    }
//
//    fun showToast(message: String) {
//        Toast.makeText(context, message, Toast.LENGTH_LONG).show()
//    }
//
//    fun showPinPopUp(parentView: View) {
//        val preferenceManager = PreferenceManager(context)
//        val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
//        val dialog = inflater.inflate(R.layout.enter_spender_pin_popup, null, false)
//        val popupWindow = PopupWindow(dialog, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT, true)
//        if (preferenceManager.fingerPrintAllowed) {
//            Toast.makeText(context, "Click on the fingerprint icon to use your fingerprint", Toast.LENGTH_SHORT).show()
//        }
//
//        fun showToast(message: String) {
//            Toast.makeText(context, message, Toast.LENGTH_LONG).show()
//        }
//
//        val messageTextView = dialog.findViewById<TextView>(R.id.tv_pin_message)
//        val pinEditText = dialog.findViewById<EditText>(R.id.edt_spender_pin)
//        val cancelButton = dialog.findViewById<Button>(R.id.cancel_pin_button)
//        val submitButton = dialog.findViewById<Button>(R.id.submit_pin_button)
//
//
//        val biometricCallback = object : BiometricCallback {
//            override fun onSdkVersionNotSupported() {
//                showToast(context.getString(R.string.biometric_error_sdk_not_supported))
//            }
//
//            override fun onBiometricAuthenticationNotSupported() {
//                showToast(context.getString(R.string.biometric_error_hardware_not_supported))
//            }
//
//            override fun onBiometricAuthenticationNotAvailable() {
//                showToast(context.getString(R.string.biometric_error_fingerprint_not_available))
//            }
//
//            override fun onBiometricAuthenticationPermissionNotGranted() {
//                showToast(context.getString(R.string.biometric_error_permission_not_granted))
//            }
//
//            override fun onBiometricAuthenticationInternalError(error: String) {
//                authCallback.onAuthFailure()
//                showToast(error)
//            }
//
//            override fun onAuthenticationFailed() {
//                authCallback.onAuthFailure()
//                showToast(context.getString(R.string.biometric_failure))
//            }
//
//            override fun onAuthenticationCancelled() {
//            }
//
//            override fun onAuthenticationSuccessful() {
//                authCallback.onAuthSuccess()
//                popupWindow.dismiss()
//            }
//
//            override fun onAuthenticationHelp(helpCode: Int, helpString: CharSequence) {
//                showToast(helpString.toString())
//            }
//
//            override fun onAuthenticationError(errorCode: Int, errString: CharSequence) {
//                authCallback.onAuthFailure()
//                showToast(errString.toString())
//            }
//        }
//
//        val scanButtonClickListener = View.OnClickListener {
//            if (preferenceManager.fingerPrintAllowed) {
//                BiometricManager.BiometricBuilder(context)
//                        .setTitle("Spender Authentication")
//                        .setSubtitle("Approve with your fingerprint")
//                        .setDescription("Place your finger on your fingerprint scanner")
//                        .setNegativeButtonText("Cancel")
//                        .build()
//                        .authenticate(biometricCallback)
//            } else {
//                showToast("Kindly go to the settings page to allow the use of fingerprint authentication")
//            }
//        }
//
//        val fingerPrintButton = dialog.findViewById<ImageView>(R.id.fingerPrintButton)
//
//        fingerPrintButton.setOnClickListener(scanButtonClickListener)
//
//        cancelButton.setOnClickListener { popupWindow.dismiss() }
//
//        submitButton.setOnClickListener {
//            if (TextUtil.getString(pinEditText) == preferenceManager.userPin) {
//                authCallback.onAuthSuccess()
//                popupWindow.dismiss()
//
//            } else {
//                authCallback.onAuthFailure()
//                showToast("Wrong pin")
//            }
//
//        }
//
//        popupWindow.showAtLocation(parentView, Gravity.CENTER, 0, 0)
//
//    }

}