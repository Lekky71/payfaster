package com.hashcode.payfastfast.utils

import java.io.IOException
import java.io.InputStream
import java.util.*

class DataUtil {

    @Throws(IOException::class)
    fun readTextFile(inputStream: InputStream): String {

        Scanner(inputStream).use { scanner -> return scanner.useDelimiter("\\A").next() }
    }

}