package com.hashcode.payfastfast.data

import android.content.Context
import android.content.SharedPreferences

class PreferenceManager(context: Context) {


    private var mSharedPreferences: SharedPreferences

    var userFullName: String
        get() = this.mSharedPreferences.getString(PREF_USER_FULL_NAME, "Shop")!!
        set(value) {
            val mEditor = this.mSharedPreferences.edit()
            mEditor.putString(PREF_USER_FULL_NAME, value)
            mEditor.apply()
        }

    var sendStatus: Boolean
        get() = this.mSharedPreferences.getBoolean(PREF_STATUS, false)
        set(value) {
            val mEditor = this.mSharedPreferences.edit()
            mEditor.putBoolean(PREF_STATUS, value)
            mEditor.apply()
        }

    var amount: Double
        get() = this.mSharedPreferences.getString(PREF_AMOUNT, "Shop")!!.toDouble()
        set(value) {
            val mEditor = this.mSharedPreferences.edit()
            mEditor.putString(PREF_AMOUNT, value.toString())
            mEditor.apply()
        }


    init {
        this.mSharedPreferences = context.getSharedPreferences(PREFERENCE_FILE_NAME, 0)
    }

    fun clearAllData(): Boolean {
        val mEditor = this.mSharedPreferences.edit()
        mEditor.putString(PREF_USER_FULL_NAME, "")
        mEditor.apply()
        return true
    }


    companion object {

        private const val PREFERENCE_FILE_NAME = "com.hashcode.payfastfast"
        private const val PREF_USER_FULL_NAME = "fullname"
        private const val PREF_AMOUNT = "amount"
        private const val PREF_STATUS = "send_status"


    }
}
