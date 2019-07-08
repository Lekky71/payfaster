package com.hashcode.payfastfast.model
import com.google.gson.annotations.SerializedName


data class SMSRequest(
    @SerializedName("amount")
    var amount: String,
    @SerializedName("phoneNumber")
    var phoneNumber: String,
    @SerializedName("shopName")
    var shopName: String
)

data class BankAccount(
    @SerializedName("accountNumber")
    var accountNumber: String,
    @SerializedName("balance")
    var balance: Int,
    @SerializedName("bankName")
    var bankName: String,
    @SerializedName("bvn")
    var bvn: String,
    @SerializedName("fingerPrint")
    var fingerPrint: String,
    @SerializedName("id")
    var id: Int,
    @SerializedName("imageUrl")
    var imageUrl: String,
    @SerializedName("name")
    var name: String,
    @SerializedName("phoneNumber")
    var phoneNumber: String
)

data class Payment(
    @SerializedName("account_id")
    var accountId: String,
    @SerializedName("amount")
    var amount: String,
    @SerializedName("id")
    var id: Int,
    @SerializedName("name")
    var name: String,
    @SerializedName("phoneNumber")
    var phoneNumber: String,
    @SerializedName("shopName")
    var shopName: String,
    @SerializedName("timestamp")
    var timestamp: String
)

data class SmsResponse(
    @SerializedName("data")
    var `data`: Data,
    @SerializedName("status")
    var status: String
)

data class Data(
    @SerializedName("SMSMessageData")
    var sMSMessageData: SMSMessageData
)

data class SMSMessageData(
    @SerializedName("Message")
    var message: String,
    @SerializedName("Recipients")
    var recipients: List<Recipient>
)

data class Recipient(
    @SerializedName("cost")
    var cost: String,
    @SerializedName("messageId")
    var messageId: String,
    @SerializedName("messageParts")
    var messageParts: Int,
    @SerializedName("number")
    var number: String,
    @SerializedName("status")
    var status: String,
    @SerializedName("statusCode")
    var statusCode: Int
)