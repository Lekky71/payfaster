package com.hashcode.payfastfast.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.hashcode.payfastfast.R
import com.hashcode.payfastfast.model.BankAccount
import com.hashcode.payfastfast.model.Payment

class PaymentAdapter(var context: Context, var payments: ArrayList<Payment>) :
    RecyclerView.Adapter<PaymentAdapter.PaymentViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PaymentViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.each_payment_layout, parent, false)
        return PaymentViewHolder(view)
    }

    override fun onBindViewHolder(holder: PaymentViewHolder, position: Int) {
        val payment = payments[position]
        holder.nameTextView.text = payment.name
        holder.amountTextView.text = "₦ " + payment.amount
//        todo format date
        holder.dateTextView.text = "" +payment.timestamp
    }

    override fun getItemCount(): Int {
        return payments.size
    }

    inner class PaymentViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var nameTextView: TextView = itemView.findViewById(R.id.nameTextView)
        var amountTextView: TextView = itemView.findViewById(R.id.amountTextView)
        var dateTextView: TextView = itemView.findViewById(R.id.dateTextView)

    }
}