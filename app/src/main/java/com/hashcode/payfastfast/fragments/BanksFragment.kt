package com.hashcode.payfastfast.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.hashcode.payfastfast.R
import com.hashcode.payfastfast.adapters.BankAdapter
import com.hashcode.payfastfast.data.PreferenceManager
import com.hashcode.payfastfast.model.BankAccount
import com.hashcode.payfastfast.model.SMSRequest
import com.hashcode.payfastfast.model.SmsResponse
import com.hashcode.payfastfast.network.AppEndpointInterface
import com.hashcode.payfastfast.network.RetrofitBuilder
import com.hashcode.payfastfast.utils.DataUtil
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class BanksFragment : Fragment(), BankAdapter.BankClickListener {
    lateinit var mView: View
    lateinit var preferenceManager : PreferenceManager

    override fun onBankClicked(bankAccount: BankAccount) {
        if(preferenceManager.amount < bankAccount.balance){
            preferenceManager.sendStatus = true
            mView.findNavController().navigate(R.id.feedbackFragment)

            val retrofit = RetrofitBuilder.getRetrofit()
            val apiService = retrofit.create(AppEndpointInterface::class.java)

            val smsRequest = SMSRequest(preferenceManager.amount.toString(), bankAccount.phoneNumber, preferenceManager.userFullName)
            val call = apiService.loginUser(smsRequest)
            call.enqueue(object : Callback<SmsResponse> {
                override fun onResponse(call: Call<SmsResponse>, response: Response<SmsResponse>) {
                    Toast.makeText(context!!, "Receipt sent", Toast.LENGTH_LONG).show()
                }

                override fun onFailure(call: Call<SmsResponse>, t: Throwable) {

                }
            })
        }
        else {
            preferenceManager.sendStatus = false
            mView.findNavController().navigate(R.id.feedbackFragment)
        }
    }

    lateinit var banksRecyclerView: RecyclerView

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        mView = inflater.inflate(R.layout.fragment_banks, container, false)
        preferenceManager = PreferenceManager(context!!)

        banksRecyclerView = mView.findViewById(R.id.banksRecyclerView)

        val XmlFileInputStream = resources.openRawResource(R.raw.accounts) // getting XML
        val dataUtil = DataUtil()

        Log.i("hello", "got here 1")

        val allBanks = Gson().fromJson<ArrayList<BankAccount>>(dataUtil.readTextFile(XmlFileInputStream), object : TypeToken<List<BankAccount>>() {}.type)

        Log.i("hello", "got here 2")

        val bankAdapter = BankAdapter(context!!, allBanks, this)
        banksRecyclerView.adapter = bankAdapter
        banksRecyclerView.layoutManager = LinearLayoutManager(context)

        return mView
    }

}
