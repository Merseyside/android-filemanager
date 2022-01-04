package com.merseyside.filemanager.file

import android.content.Context
import com.merseyside.filemanager.FileManager
import com.merseyside.filemanager.utils.isEmpty
import com.merseyside.merseyLib.kotlin.extensions.log
import java.lang.Exception

abstract class DefaultFile(
    private val context: Context,
    private val file: java.io.File
): File {

    override fun getFile() = file

    override val path: String
        get() {
            return file.path
        }

    init {
        try {
            file.isEmpty()
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    override fun createFile(rewrire: Boolean): Boolean {
        return if (!file.exists() || rewrire) {
            FileManager.createFile(file)
        } else {
            log(TAG, "File already exists.")
            false
        }
    }

    override fun deleteFile(): Boolean {
        return if (!file.exists()) {
            file.delete()
        } else {
            log("File doesn't exist")
            false
        }
    }

    override fun write(data: Any) {
        FileManager.writeToFile(file, data)
    }

    override fun read() = FileManager.readFromFile(file)

    companion object {
        private const val TAG = "PublicFile"
    }
}