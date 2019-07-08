package com.hashcode.payfastfast.data

import android.content.Context
import android.content.SharedPreferences
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.spender.spender.models.Bank
import com.spender.spender.models.Card
import com.spender.spender.models.Metadata
import com.spender.spender.models.OTPResponse


class PreferenceManager(context: Context) {


    private var mSharedPreferences: SharedPreferences

    var userPin: String
        get() {
            val metadata = userMetadata
            return metadata?.password!!
        }
        set(pin) {
            val metadata = userMetadata
            metadata?.password = pin
            this.userMetadata = metadata
        }

    var userBalance: Double
        get() {
            val metadata = userMetadata
            return metadata?.balance!!
        }
        set(amount) {
            val metadata = userMetadata
            if (metadata != null) {
                metadata.balance = amount
                this.userMetadata = metadata
            }
        }

    var authKey: String
        get() = this.mSharedPreferences.getString(PREF_AUTH_KEY, "")!!
        set(authkey) {
            val mEditor = this.mSharedPreferences.edit()
            mEditor.putString(PREF_AUTH_KEY, authkey)
            mEditor.apply()
        }

    var hotspotSsid: String
        get() = this.mSharedPreferences.getString(PREF_HOTSPOT_SSID, "")!!
        set(ssid) {
            val mEditor = this.mSharedPreferences.edit()
            mEditor.putString(PREF_HOTSPOT_SSID, ssid)
            mEditor.apply()
        }

    var hotspotActive: Boolean
        get() = this.mSharedPreferences.getBoolean(PREF_HOTSPOT_ACTIVE, false)
        set(active) {
            val mEditor = this.mSharedPreferences.edit()
            mEditor.putBoolean(PREF_HOTSPOT_ACTIVE, active)
            mEditor.apply()
        }

    var writeSettings: Boolean
        get() = this.mSharedPreferences.getBoolean(PREF_WRITE_SETTINGS, false)
        set(allowed) {
            val mEditor = this.mSharedPreferences.edit()
            mEditor.putBoolean(PREF_WRITE_SETTINGS, allowed)
            mEditor.apply()
        }


    var hotspotPassword: String
        get() = this.mSharedPreferences.getString(PREF_HOTSPOT_PASSWORD, "")!!
        set(password) {
            val mEditor = this.mSharedPreferences.edit()
            mEditor.putString(PREF_HOTSPOT_PASSWORD, password)
            mEditor.apply()
        }

    val userFullName: String
        get() = this.mSharedPreferences.getString(PREF_USER_FULL_NAME, "")!!


    var isUserLoggedIn: Boolean
        get() = this.mSharedPreferences.getBoolean(PREF_USER_LOGGED_IN, false)
        set(loggedIn) {
            val mEditor = this.mSharedPreferences.edit()
            mEditor.putBoolean(PREF_USER_LOGGED_IN, loggedIn)
            mEditor.apply()
        }

    val username: String
        get() {
            val metadata = userMetadata
            return metadata?.username!!
        }

    var iconUrl: String?
        get() = this.mSharedPreferences.getString(PREF_ICON_URL, null)
        set(iconUrl) {
            val mEditor = this.mSharedPreferences.edit()
            mEditor.putString(PREF_ICON_URL, iconUrl)
            mEditor.apply()
        }


    var userMetadata: Metadata?
        get() {
            val userString = this.mSharedPreferences.getString(PREF_USER_METADATA, "")
            return if (userString!!.length > 5) {
                Gson().fromJson(userString, Metadata::class.java)
            } else {
                null
            }
        }
        set(userMetadata) {
            val userString = Gson().toJson(userMetadata)
            val mEditor = this.mSharedPreferences.edit()
            mEditor.putString(PREF_USER_METADATA, userString)
            mEditor.apply()
        }


    var otpResponse: OTPResponse
        get() {
            val userString = this.mSharedPreferences.getString(PREF_OTP_RESPONSE, "")
            return Gson().fromJson(userString, OTPResponse::class.java)
        }
        set(otpResponse: OTPResponse) {
            val string = Gson().toJson(otpResponse)
            val mEditor = this.mSharedPreferences.edit()
            mEditor.putString(PREF_OTP_RESPONSE, string)
            mEditor.apply()
        }

    var isSyncingOn: Boolean
        get() = this.mSharedPreferences.getBoolean(PREF_SYNC_ON, false)
        set(isOn: Boolean) {
            val mEditor = this.mSharedPreferences.edit()
            mEditor.putBoolean(PREF_SYNC_ON, isOn)
            mEditor.apply()
        }

    var syncWorkerUUID: String
        get() = this.mSharedPreferences.getString(PREF_SYNC_WORKER_UUID, "")!!
        set(uuid) {
            val mEditor = this.mSharedPreferences.edit()
            mEditor.putString(PREF_SYNC_WORKER_UUID, uuid)
            mEditor.apply()
        }


    var prefHasShownIntro: Boolean
        get() = this.mSharedPreferences.getBoolean(PREF_HAS_SHOWN_INTRO, false)
        set(hasShownIntro) {
            val mEditor = this.mSharedPreferences.edit()
            mEditor.putBoolean(PREF_HAS_SHOWN_INTRO, hasShownIntro)
            mEditor.apply()
        }

    var hasDeletedOldFiles: Boolean
        get() = this.mSharedPreferences.getBoolean(PREF_HAS_DELETED_OLD_FILES, false)
        set(hasDeletedOldFiles) {
            val mEditor = this.mSharedPreferences.edit()
            mEditor.putBoolean(PREF_HAS_DELETED_OLD_FILES, hasDeletedOldFiles)
            mEditor.apply()
        }

    // TODO: Use this method to determine if fingerptint dialog will show or not
    var fingerPrintAllowed: Boolean
        get() = this.mSharedPreferences.getBoolean(PREF_IS_FINGERPRINT_ALLOWED, false)
        set(isAllowed) {
            val mEditor = this.mSharedPreferences.edit()
            mEditor.putBoolean(PREF_IS_FINGERPRINT_ALLOWED, isAllowed)
            mEditor.apply()
        }

    var accountVerified: Boolean
        get() = this.mSharedPreferences.getBoolean(PREF_IS_ACCOUNT_VERIFIED, false)
        set(isAllowed) {
            val mEditor = this.mSharedPreferences.edit()
            mEditor.putBoolean(PREF_IS_ACCOUNT_VERIFIED, isAllowed)
            mEditor.apply()
        }

    var allBanks: ArrayList<Bank>
        get() {
            val str = this.mSharedPreferences.getString(PREF_ALL_BANKS_LIST, "[]")!!
            return Gson().fromJson(str, object : TypeToken<List<Bank>>() {}.type)
        }
        set(banks) {
            val str = Gson().toJson(banks)
            val mEditor = this.mSharedPreferences.edit()
            mEditor.putString(PREF_ALL_BANKS_LIST, str)
            mEditor.apply()
        }

    fun saveNewBank(bank: Bank) {
        allBanks.add(bank)
        allBanks = allBanks
    }

    var allCards: ArrayList<Card>
        get() {
            val str = this.mSharedPreferences.getString(PREF_ALL_CARDS_LIST, "[]")!!
            return Gson().fromJson(str, object : TypeToken<List<Card>>() {}.type)
        }
        set(cards) {
            val str = Gson().toJson(cards)
            val mEditor = this.mSharedPreferences.edit()
            mEditor.putString(PREF_ALL_CARDS_LIST, str)
            mEditor.apply()
        }

    fun saveNewCard(card: Card) {
        allCards.add(card)
        allCards = allCards
    }


    init {
        this.mSharedPreferences = context.getSharedPreferences(PREFERENCE_FILE_NAME, 0)
    }

    fun clearAllData(): Boolean {
        val mEditor = this.mSharedPreferences.edit()
        mEditor.putBoolean(USER_LOGGED_IN, false)
        mEditor.putString(PREF_USER_METADATA, "")
        mEditor.putString(PREF_ICON_URL, "")
        mEditor.apply()
        return true
    }


    companion object {

        private const val PREFERENCE_FILE_NAME = "com.spender.spender"
        private const val PREF_ICON_URL = "icon_url"
        private const val PREF_USER_ID = "id"
        private const val PREF_USER_NAME = "username"
        private const val USER_LOGGED_IN = "user-logged-in"
        private const val PREF_USER_FULL_NAME = "fullname"
        private const val PREF_USER_LOGGED_IN = "user-logged-in"

        private const val PREF_USER_PIN = "spender-pin"

        private const val PREF_HOTSPOT_SSID = "old_ssid"
        private const val PREF_HOTSPOT_PASSWORD = "old_password"
        private const val PREF_HOTSPOT_ACTIVE = "hotspot_active"

        private const val PREF_OLD_NET_CONFIG = "old_net_config"
        private const val PREF_WRITE_SETTINGS = "write_phone_settings"

        private const val PREF_USER_BALANCE = "spender_user_account_balance"

        private const val PREF_AUTH_KEY = "android_auth_key"

        private const val PREF_USER_METADATA = "com.spender.spender.USER_METADATA"
        private const val PREF_OTP_RESPONSE = "com.spender.OTP_RESP"

        private const val PREF_TEMP_TRANSACTIONS = "com.spender.TEMP_TRANSACTIONS"

        private const val PREF_SYNC_ON = "com.spender.spender.SYNC_ON"

        private const val PREF_SYNC_WORKER_UUID = "com.spender.SYNC_WORKER_UUID"

        private const val PREF_HAS_SHOWN_INTRO = "com.spender.has_shown_intro"

        private const val PREF_HAS_DELETED_OLD_FILES = "com.spender.HAS_DELETED_OLD_FILES"
        private const val PREF_IS_FINGERPRINT_ALLOWED = "com.spender.IS_FINGERPRINT_ALLOWED"
        private const val PREF_IS_ACCOUNT_VERIFIED = "com.spender.IS_ACCOUNT_VERIFIED"
        private const val PREF_ALL_BANKS_LIST = "com.spender.ALL_BANKS_LIST"
        private const val PREF_ALL_CARDS_LIST = "com.spender.ALL_CARDS_LIST"
    }

    //    public boolean setTmpTransaction(Transaction transaction){
    //        String string = new Gson().toJson(otpResponse);
    //        Editor mEditor = this.mSharedPreferences.edit();
    //        mEditor.putString(PREF_OTP_RESPONSE, string);
    //        mEditor.apply();
    //        return true;
    //    }
    //    public OTPResponse getTmpTransactions(){
    //        String userString = this.mSharedPreferences.getString(PREF_TEMP_TRANSACTIONS, "");
    //        return new Gson().fromJson(userString, OTPResponse.class);
    //    }


}
