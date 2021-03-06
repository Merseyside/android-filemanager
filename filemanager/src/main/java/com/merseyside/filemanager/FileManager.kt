package com.merseyside.filemanager

import android.content.Context
import android.content.ContextWrapper
import android.database.Cursor
import android.net.Uri
import android.os.Environment
import android.util.Log
import java.io.*
import java.util.regex.Matcher
import java.util.regex.Pattern

/**
 * Created by ivan_ on 10.12.2017.
 */
object FileManager {

    enum class STORAGE {
        SD_CARD, EXTERNAL
    }

    @Throws(NullPointerException::class)
    fun getStorageLocations(storage: STORAGE): File? {
        val externalLocations =
            ExternalStorage.allStorageLocations
        return try {
            when (storage) {
                STORAGE.SD_CARD -> externalLocations[ExternalStorage.SD_CARD]
                STORAGE.EXTERNAL -> externalLocations[ExternalStorage.EXTERNAL_SD_CARD]
            }
        } catch (e: NullPointerException) {
            throw NullPointerException("Can not take access to storage. Are you allowed your app to interact with data?")
        }
    }

    fun checkExternalPathWriteable(path: String?): Boolean {
        return if (path != null) {
            val file = File(path)
            file.canWrite()
        } else false
    }

    fun isFilenameValid(name: String): Boolean {
        val pattern: Pattern
        val matcher: Matcher
        val patternCompile = "^[^*&%]+$"
        pattern = Pattern.compile(patternCompile)
        matcher = pattern.matcher(name)
        return matcher.find()
    }

    @Throws(Exception::class)
    fun convertStreamToString(inputStream: InputStream): String {
        val reader =
            BufferedReader(InputStreamReader(inputStream))
        val sb = StringBuilder()
        var line: String?
        while (reader.readLine().also { line = it } != null) {
            sb.append(line).append("\n")
        }
        reader.close()
        return sb.toString()
    }

    @Throws(Exception::class)
    fun getStringFromFile(context: Context, filePath: String): String {

        val uri = Uri.parse(filePath)
        val inputStream = if (isContentUri(uri)) {
            context.contentResolver.openInputStream(uri)
        } else {
            FileInputStream(File(filePath))
        }

        if (inputStream != null) {
            val ret = convertStreamToString(inputStream)
            inputStream.close()
            return ret
        } else throw IllegalArgumentException("Stream is null")
    }

    fun createTempFile(
        prefix: String,
        suffix: String? = null,
        data: String): File {

        val file = File.createTempFile(prefix, suffix)

        file.writeText(data)

        return file
    }

    fun writeToFile(file: File, data: Any) {
        try {
            val fos = FileOutputStream(file)

            val oos = ObjectOutputStream(fos)
            oos.writeObject(data)

            oos.close()
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    fun writeToFile(file: File, data: String) {
        try {
            file.writeText(data)
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    fun readStringFromFile(file: File): String {
        val inputStream: InputStream = file.inputStream()
        return inputStream.bufferedReader().use { it.readText() }
    }

    fun readFromFile(file: File): Any {
        val fos = FileInputStream(file)
        val oos = ObjectInputStream(fos)

        return oos.readObject()
    }

    fun createFile(file: File): Boolean {
        return try {
            if (!file.exists()) {
                if (file.createNewFile()) {
                    Log.d(TAG, "File ${file.path} created!")
                    true
                } else {
                    Log.e(TAG, "Cannot create file")
                    false
                }
            } else {
                if (file.delete()) {
                    createFile(file)
                }

                false
            }
        } catch (e: Exception) {
            Log.e(TAG, "path = $file")
            e.printStackTrace()

            false
        }
    }

    fun createFile(
        path: String,
        folderName: String? = null,
        filename: String
    ): File? {
        val filePath = File(path, folderName)
        if (!filePath.exists()) {
            filePath.mkdir()
        }

        val file = File(filePath, filename)

        createFile(file)

        return null
    }

    fun createFile(
        path: String,
        folderName: String,
        filename: String,
        data: String,
        contextWrapper: ContextWrapper? = null
    ): File? {
        val file = createFile(path, folderName, filename)

        if (file != null) {
            writeToFile(file, data)
        }

        return file
    }

    fun isContentUri(uri: Uri): Boolean {
        return uri.scheme == "content"
    }

    fun zipFiles(outputZipFile: File, vararg files: File): File {
        val zipHelper = ZipHelper(outputZipFile)

        zipHelper.addFiles(*files)
        return zipHelper.zip()
    }

    fun zipFile(outputZipFile: File, file: File): File {
        val zipHelper = ZipHelper(outputZipFile)

        zipHelper.addFile(file)
        return zipHelper.zip()
    }

    fun isExists(context: Context, path: String): Boolean {
        val uri = Uri.parse(path)

        return if (isContentUri(uri)) {
            checkURIResource(context, uri)
        } else {
            File(path).exists()
        }
    }

    fun checkURIResource(context: Context, uri: Uri?): Boolean {
        val cursor: Cursor? = context.contentResolver.query(uri!!, null, null, null, null)
        val doesExist = cursor != null && cursor.moveToFirst()
        cursor?.close()
        return doesExist
    }

    fun isExternalStorageDocument(uri: Uri): Boolean {
        return "com.android.externalstorage.documents" == uri.authority
    }

    fun isDownloadsDocument(uri: Uri): Boolean {
        return "com.android.providers.downloads.documents" == uri.authority
    }

    fun isMediaDocument(uri: Uri): Boolean {
        return "com.android.providers.media.documents" == uri.authority
    }

    fun isGooglePhotosUri(uri: Uri): Boolean {
        return "com.google.android.apps.photos.content" == uri.authority
    }

    private const val TAG = "FileManager"
}