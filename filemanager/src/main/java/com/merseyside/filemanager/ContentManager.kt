package com.merseyside.filemanager

import android.app.Activity
import android.content.ContentValues
import android.content.Context
import android.content.Intent
import android.database.Cursor
import android.net.Uri
import android.provider.MediaStore
import com.merseyside.filemanager.mime_types.MimeType
import java.io.File

class ContentManager(private val context: Context) {

    private val activity: Activity

    init {
        require(context is Activity) { "Pass activity context!" }
        activity = context
    }

    fun performFileSearch(mimeType: MimeType, intent: Intent) {
        performFileSearch(mimeType.mimeType, intent)
    }

    fun performFileSearch(type: String?, intent: Intent) {
        intent.addCategory(Intent.CATEGORY_OPENABLE)
        intent.type = type
        activity.startActivityForResult(intent, READ_REQUEST_CODE)
    }

    private fun getImageContentUri(imageFile: File): Uri? {
        var cursor: Cursor? = null
        return try {
            val filePath = imageFile.absolutePath
            cursor = context.contentResolver.query(
                MediaStore.Images.Media.EXTERNAL_CONTENT_URI,
                arrayOf(MediaStore.Images.Media._ID),
                MediaStore.Images.Media.DATA + "=? ",
                arrayOf(filePath),
                null
            )
            if (cursor != null && cursor.moveToFirst()) {
                val id = cursor.getInt(
                    cursor
                        .getColumnIndex(MediaStore.MediaColumns._ID)
                )
                val baseUri = Uri.parse("content://media/external/images/media")
                Uri.withAppendedPath(baseUri, "" + id)
            } else {
                if (imageFile.exists()) {
                    val values = ContentValues()
                    values.put(MediaStore.Images.Media.DATA, filePath)
                    context.contentResolver.insert(
                        MediaStore.Images.Media.EXTERNAL_CONTENT_URI, values
                    )
                } else {
                    null
                }
            }
        } finally {
            cursor?.close()
        }
    }

    private fun getAudioContentUri(audioFile: File): Uri? {
        var cursor: Cursor? = null
        return try {
            val filePath = audioFile.absolutePath
            cursor = context.contentResolver.query(
                MediaStore.Audio.Media.EXTERNAL_CONTENT_URI,
                arrayOf(MediaStore.Audio.Media._ID),
                MediaStore.Audio.Media.DATA + "=? ",
                arrayOf(filePath),
                null
            )
            if (cursor != null && cursor.moveToFirst()) {
                val id = cursor.getInt(
                    cursor
                        .getColumnIndex(MediaStore.MediaColumns._ID)
                )
                val baseUri = Uri.parse("content://media/external/audio/media")
                Uri.withAppendedPath(baseUri, "" + id)
            } else {
                if (audioFile.exists()) {
                    val values = ContentValues()
                    values.put(MediaStore.Audio.Media.DATA, filePath)
                    context.contentResolver.insert(
                        MediaStore.Audio.Media.EXTERNAL_CONTENT_URI, values
                    )
                } else {
                    null
                }
            }
        } finally {
            cursor?.close()
        }
    }

    private fun getVideoContentUri(videoFile: File): Uri? {
        var cursor: Cursor? = null
        return try {
            val filePath = videoFile.absolutePath
            cursor = context.contentResolver.query(
                MediaStore.Video.Media.EXTERNAL_CONTENT_URI,
                arrayOf(MediaStore.Video.Media._ID),
                MediaStore.Video.Media.DATA + "=? ",
                arrayOf(filePath),
                null
            )
            if (cursor != null && cursor.moveToFirst()) {
                val id = cursor.getInt(
                    cursor
                        .getColumnIndex(MediaStore.MediaColumns._ID)
                )
                val baseUri = Uri.parse("content://media/external/video/media")
                Uri.withAppendedPath(baseUri, "" + id)
            } else {
                if (videoFile.exists()) {
                    val values = ContentValues()
                    values.put(MediaStore.Video.Media.DATA, filePath)
                    context.contentResolver.insert(
                        MediaStore.Video.Media.EXTERNAL_CONTENT_URI, values
                    )
                } else {
                    null
                }
            }
        } finally {
            cursor?.close()
        }
    }

    fun getFileContentUri(file: File): Uri? {
        var cursor: Cursor? = null
        return try {
            val filePath = file.absolutePath
            cursor = context.contentResolver.query(
                MediaStore.Video.Media.EXTERNAL_CONTENT_URI,
                arrayOf(MediaStore.Video.Media._ID),
                MediaStore.Video.Media.DATA + "=? ",
                arrayOf(filePath),
                null
            )
            if (cursor != null && cursor.moveToFirst()) {
                val id = cursor.getInt(
                    cursor
                        .getColumnIndex(MediaStore.MediaColumns._ID)
                )
                val baseUri = Uri.parse("content://media/external/video/media")
                Uri.withAppendedPath(baseUri, "" + id)
            } else {
                if (file.exists()) {
                    val values = ContentValues()
                    values.put(MediaStore.Video.Media.DATA, filePath)
                    context.contentResolver.insert(
                        MediaStore.Video.Media.EXTERNAL_CONTENT_URI, values
                    )
                } else {
                    null
                }
            }
        } finally {
            cursor?.close()
        }
    }

    private val READ_REQUEST_CODE = 1
}