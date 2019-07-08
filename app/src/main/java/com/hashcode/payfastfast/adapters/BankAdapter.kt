package com.hashcode.payfastfast.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.hashcode.payfastfast.R
import com.hashcode.payfastfast.model.BankAccount

class BankAdapter(
    var context: Context,
    var accounts: ArrayList<BankAccount>,
    var bankClickListener: BankClickListener
) :
    RecyclerView.Adapter<BankAdapter.AccountViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AccountViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.each_bank_layout, parent, false)
        return AccountViewHolder(view)
    }

    override fun onBindViewHolder(holder: AccountViewHolder, position: Int) {
        val bankAccount = accounts[position]
        holder.bankNameTextView.text = "  " + bankAccount.bankName
        holder.nameTextView.text = "  " + bankAccount.name
        holder.accountNumberTextView.text = "  " + bankAccount.accountNumber

        val drawable: Int
        val color: Int

        when (bankAccount.bankName) {
            "Stanbic Bank" -> {
                drawable = R.drawable.ic_stanbic
                color = R.color.colorStanbic
            }
            "Wema Bank" -> {
                drawable = R.drawable.ic_wema
                color = R.color.colorWema

            }
            "Access Bank" -> {
                drawable = R.drawable.ic_access
                color = R.color.colorAccess

            }
            "Guaranty Trust Bank" -> {
                drawable = R.drawable.ic_guaranty_trust_bank
                color = R.color.colorGtb

            }
            "First Bank" -> {
                drawable = R.drawable.ic_first_bank
                color = R.color.colorFirst
            }
            "Polaris Bank" -> {
                drawable = R.drawable.ic_polaris
                color = R.color.colorPolaris

            }
            "UBA Bank" -> {
                drawable = R.drawable.ic_uba
                color = R.color.colorUba

            }
            else -> {
                drawable = R.drawable.ic_stanbic
                color = R.color.colorPolaris
            }
        }
        holder.bankImageView.setImageResource(drawable)
        holder.bankLinearLayout.setBackgroundResource(color)

        holder.itemView.setOnClickListener {
            bankClickListener.onBankClicked(bankAccount)
        }
    }

    override fun getItemCount(): Int {
        return accounts.size
    }

    interface BankClickListener {
        fun onBankClicked(bankAccount: BankAccount)
    }

    inner class AccountViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var bankLinearLayout: LinearLayout = itemView.findViewById(R.id.bankLinearLayout)
        var bankNameTextView: TextView = itemView.findViewById(R.id.bankNameTextView)
        var bankImageView: ImageView = itemView.findViewById(R.id.bankImageView)
        var nameTextView: TextView = itemView.findViewById(R.id.nameTextView)
        var accountNumberTextView: TextView = itemView.findViewById(R.id.accountNumberTextView)
    }
}