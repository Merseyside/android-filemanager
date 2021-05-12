package com.merseyside.filemanager

import android.content.Context
import android.content.res.AssetManager
import android.util.Log
import com.merseyside.filemanager.utils.isEmpty
import com.merseyside.utils.serialization.deserialize
import kotlinx.serialization.DeserializationStrategy
import java.io.*

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

        val dstPathFile = FileManager.createFile(dstFile.absolutePath, null, filename)

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

    inline fun <reified T: Any> jsonAssetToModel(
        context: Context,
        filename: String
    ): T? {
        return getAssetContent(context, filename)?.deserialize()
    }

    inline fun <reified T: Any> jsonAssetToModel(
        context: Context,
        filename: String,
        deserializationStrategy: DeserializationStrategy<T>
    ): T? {
        return getAssetContent(context, filename)?.deserialize(deserializationStrategy)
    }

    private const val TAG = "AssetHelper"
}