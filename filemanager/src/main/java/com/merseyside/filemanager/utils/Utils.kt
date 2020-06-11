package com.merseyside.filemanager.utils

import android.content.Context
import android.content.res.AssetManager
import java.io.IOException
import java.io.InputStream

fun getAssetContent(context: Context, filename: String): String? {
    val manager: AssetManager = context.assets

    return try {
        val file: InputStream = manager.open(filename)
        val formArray = ByteArray(file.available())
        file.read(formArray)
        file.close()
        String(formArray)
    } catch (e: IOException) {
        null
    }
}