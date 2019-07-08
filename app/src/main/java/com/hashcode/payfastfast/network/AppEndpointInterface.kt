package com.hashcode.payfastfast.network

import com.hashcode.payfastfast.model.SMSRequest
import com.hashcode.payfastfast.model.SmsResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface AppEndpointInterface {
    @POST("send-sms")
    fun loginUser(@Body smSRequest: SMSRequest): Call<SmsResponse>

}