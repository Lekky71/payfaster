package com.hashcode.payfastfast.fragments

import android.app.DatePickerDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.hashcode.payfastfast.R
import com.hashcode.payfastfast.adapters.PaymentAdapter
import com.hashcode.payfastfast.model.BankAccount
import com.hashcode.payfastfast.model.Payment
import com.hashcode.payfastfast.utils.DataUtil
import java.util.*
import kotlin.collections.ArrayList


class PaymentsFragment : Fragment() {

    lateinit var startDateTextView: TextView
    lateinit var endDateTextView: TextView
    lateinit var searchImageView: ImageView
    lateinit var paymentsRecyclerView: RecyclerView


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_payments, container, false)

        startDateTextView = view.findViewById(R.id.startDateTextView)
        endDateTextView = view.findViewById(R.id.endDateTextView)
        searchImageView = view.findViewById(R.id.searchImageView)
        paymentsRecyclerView = view.findViewById(R.id.paymentsRecyclerView)

        val cldr = Calendar.getInstance()
        val currentDay = cldr.get(Calendar.DAY_OF_MONTH)
        val currentMonth = cldr.get(Calendar.MONTH)
        val currentYear = cldr.get(Calendar.YEAR)

        startDateTextView.text =
            (currentDay.toString() + "/" + (currentMonth + 1).toString() + "/" + currentYear.toString())
        endDateTextView.text =
            (currentDay.toString() + "/" + (currentMonth + 1).toString() + "/" + currentYear.toString())


        var startTime = getStartOfDay().time
        var endTime = getEndOfDay().time


        startDateTextView.setOnClickListener {
            val picker = DatePickerDialog(
                context!!, R.style.MyDialogTheme,
                DatePickerDialog.OnDateSetListener { _, year, monthOfYear, dayOfMonth ->
                    val calendar = Calendar.getInstance()
                    calendar.set(year, monthOfYear, dayOfMonth)
                    startDateTextView.text = (dayOfMonth.toString() + "/" + (monthOfYear + 1) + "/" + year)
                    startTime = calendar.time.time
                },
                currentYear,
                currentMonth,
                currentDay
            )
            picker.show()
        }

        endDateTextView.setOnClickListener {
            val picker = DatePickerDialog(
                context!!, R.style.MyDialogTheme,
                DatePickerDialog.OnDateSetListener { _, year, monthOfYear, dayOfMonth ->
                    val calendar = Calendar.getInstance()
                    calendar.set(year, monthOfYear, dayOfMonth)
                    endDateTextView.text = (dayOfMonth.toString() + "/" + (monthOfYear + 1) + "/" + year)
                    endTime = calendar.time.time
                },
                currentYear,
                currentMonth,
                currentDay
            )
            picker.show()
        }

        searchImageView.setOnClickListener {
//            todo get by timestamps

            val XmlFileInputStream = resources.openRawResource(R.raw.payments) // getting XML
            val dataUtil = DataUtil()

            val allPayments = Gson().fromJson<ArrayList<Payment>>(dataUtil.readTextFile(XmlFileInputStream), object : TypeToken<List<Payment>>() {}.type)


            val paymentAdapter = PaymentAdapter(context!!, allPayments)
            paymentsRecyclerView.adapter = paymentAdapter
            paymentsRecyclerView.layoutManager = LinearLayoutManager(context)
        }


        return view
    }


    private fun getStartOfDay(): Date {
        val calendar = Calendar.getInstance()
        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH)
        val day = calendar.get(Calendar.DATE)
        calendar.set(year, month, day, 0, 0, 0)
        return calendar.time
    }

    private fun getEndOfDay(): Date {
        val calendar = Calendar.getInstance()
        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH)
        val day = calendar.get(Calendar.DATE)
        calendar.set(year, month, day, 23, 59, 59)
        return calendar.time
    }
}
