package com.merseyside.filemanager

import android.content.Context
import android.content.res.AssetManager
import android.util.Log
import com.merseyside.filemanager.utils.isEmpty
import java.io.File
import java.io.FileOutputStream
import java.io.InputStream
import java.io.OutputStream

object AssetHelper {

    fun copyFileToCache(
        context: Context,
        filename: String,
        overwrite: Boolean = false
    ): Boolean {
        return copyFileToSystem(context, filename, context.cacheDir, overwrite)
    }

    fun copyFileToSystem(
        context: Context,
        filename: String,
        dst: String,
        overwrite: Boolean = false
    ): Boolean {
        return copyFileToSystem(context, filename, File(dst), overwrite)
    }

    fun copyFileToSystem(
        context: Context,
        filename: String,
        dstFile: File,
        overwrite: Boolean = false
    ): Boolean {
        val assetManager: AssetManager = context.assets

        val dstPathFile = FileManager.createFile(dstFile.absolutePath, filename)

        if (dstPathFile != null) {
            if (dstPathFile.isEmpty() || overwrite) {
                val input: InputStream = assetManager.open(filename)
                val output: OutputStream = FileOutputStream(dstPathFile)

                return try {
                    val buffer = ByteArray(1024)
                    var read: Int
                    while (input.read(buffer).also { read = it } != -1) {
                        output.write(buffer, 0, read)
                    }
                    input.close()
                    output.flush()
                    output.close()

                    true
                } catch (e: Exception) {
                    e.printStackTrace()
                    false
                }
            }

            return true
        } else {
            Log.e(TAG, "File is null")
            return false
        }

    }

    const val TAG = "AssetHelper"
}