package com.merseyside.filemanager

import android.content.ContentUris
import android.content.Context
import android.database.Cursor
import android.net.Uri
import android.os.Build
import android.os.Environment
import android.provider.DocumentsContract
import android.provider.MediaStore
import android.util.Log
import java.io.*
import java.net.URISyntaxException
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
            ExternalStorage.getAllStorageLocations()
        try {
            when (storage) {
                STORAGE.SD_CARD -> return externalLocations[ExternalStorage.SD_CARD]
                STORAGE.EXTERNAL -> return externalLocations[ExternalStorage.EXTERNAL_SD_CARD]
            }
        } catch (e: NullPointerException) {
            throw NullPointerException("Can not take access to storage. Are you allowed your app to interact with data?")
        }
        return null
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
    fun getStringFromFile(filePath: String): String {
        val fl = File(filePath)
        val fin = FileInputStream(fl)
        val ret = convertStreamToString(fin)
        fin.close()
        return ret
    }

    fun createTempFile(
        prefix: String,
        suffix: String? = null,
        data: String): File {

        val file = File.createTempFile(prefix, suffix)

        file.writeText(data)

        return file
    }

    fun writeToFile(file: File, data: String) {
        try {
            file.writeText(data)
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    fun readFromFile(path: String): String {
        val inputStream: InputStream = File(path).inputStream()
        return inputStream.bufferedReader().use { it.readText() }
    }

    fun createFile(path: String, filename: String): File? {
        val filePath = File(path)
        if (!filePath.exists()) {
            filePath.mkdir()
        }

        val file = File(filePath, filename)

        try {

            if (!file.exists()) {
                if (file.createNewFile()) {
                    return file
                } else {
                    Log.e(TAG, "Cannot create file")
                }
            } else {
                if (file.delete()) {
                    return createFile(path, filename)
                }
            }
        } catch (e: Exception) {
            Log.e(TAG, "path = $file")
            e.printStackTrace()
        }

        return null
    }

    fun createFile(path: String, filename: String, data: String): File? {
        val file = createFile(path, filename)

        if (file != null) {
            writeToFile(file, data)
        }

        return file
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

    fun isExists(path: String): Boolean {
        val file = File(path)

        return file.exists()
    }

    fun contentUriToFileUri(context: Context, uri: Uri): String {
        var filePath = ""
        Log.d("FileManager", "URI = $uri")
        if ("content" == uri.scheme) {
            context.contentResolver.query(
                uri,
                arrayOf(MediaStore.Files.FileColumns.DATA),
                null,
                null,
                null
            )?.apply {
                moveToFirst()
                filePath = getString(0)
                close()
            }
        } else {
            filePath = uri.path ?: ""
        }

        return filePath
    }

    @Throws(URISyntaxException::class)
    fun getFilePath(context: Context, uri: Uri): String? {
        var uri = uri
        var selection: String? = null
        var selectionArgs: Array<String>? = null
        // Uri is different in versions after KITKAT (Android 4.4), we need to
        if (Build.VERSION.SDK_INT >= 19 && DocumentsContract.isDocumentUri(
                context.applicationContext,
                uri
            )
        ) {
            when {
                isExternalStorageDocument(uri) -> {
                    val docId: String = DocumentsContract.getDocumentId(uri)
                    val split = docId.split(":").toTypedArray()
                    return Environment.getExternalStorageDirectory().toString() + "/" + split[1]
                }
                isDownloadsDocument(uri) -> {
                    val id: String = DocumentsContract.getDocumentId(uri)
                    uri = ContentUris.withAppendedId(
                        Uri.parse("content://downloads/public_downloads"),
                        java.lang.Long.valueOf(id)
                    )
                }
                isMediaDocument(uri) -> {
                    val docId: String = DocumentsContract.getDocumentId(uri)
                    val split = docId.split(":").toTypedArray()
                    val type = split[0]
                    when (type) {
                        "image" -> {
                            uri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI
                        }
                        "video" -> {
                            uri = MediaStore.Video.Media.EXTERNAL_CONTENT_URI
                        }
                        "audio" -> {
                            uri = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI
                        }
                    }
                    selection = "_id=?"
                    selectionArgs = arrayOf(
                        split[1]
                    )
                }
            }
        }
        if ("content".equals(uri.scheme, ignoreCase = true)) {
            if (isGooglePhotosUri(uri)) {
                return uri.lastPathSegment
            }
            val projection = arrayOf(
                MediaStore.Images.Media.DATA
            )
            var cursor: Cursor? = null
            try {
                cursor = context.contentResolver
                    .query(uri, projection, selection, selectionArgs, null)
                val columnIndex =
                    cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA)
                if (cursor.moveToFirst()) {
                    return cursor.getString(columnIndex)
                }
            } catch (e: java.lang.Exception) {
                e.printStackTrace()
            }
        } else if ("file".equals(uri.scheme, ignoreCase = true)) {
            return uri.path
        }
        return null
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