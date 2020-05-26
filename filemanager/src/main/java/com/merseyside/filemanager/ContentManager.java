package com.merseyside.filemanager;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore;

import com.merseyside.filemanager.mime_types.MimeType;

import java.io.File;

public class ContentManager {

    private final int READ_REQUEST_CODE = 1;

    private Activity activity;
    private Context context;

    public ContentManager(Context context) {
        if (!(context instanceof Activity)) throw new IllegalArgumentException("Pass activity context!");
        else {
            this.activity = (Activity) context;
            context = activity;
        }
    }


    public void performFileSearch(MimeType mimeType, Intent intent) {
        performFileSearch(mimeType.getMimeType(), intent);
    }

    public void performFileSearch(String type, Intent intent) {

        intent.addCategory(Intent.CATEGORY_OPENABLE);
        intent.setType(type);

        activity.startActivityForResult(intent, READ_REQUEST_CODE);
    }

    private Uri getImageContentUri(File imageFile) {
        Cursor cursor = null;
        try {
            String filePath = imageFile.getAbsolutePath();
            cursor = context.getContentResolver().query(
                    MediaStore.Images.Media.EXTERNAL_CONTENT_URI,
                    new String[]{MediaStore.Images.Media._ID},
                    MediaStore.Images.Media.DATA + "=? ",
                    new String[]{filePath}, null);

            if (cursor != null && cursor.moveToFirst()) {
                int id = cursor.getInt(cursor
                        .getColumnIndex(MediaStore.MediaColumns._ID));
                Uri baseUri = Uri.parse("content://media/external/images/media");
                return Uri.withAppendedPath(baseUri, "" + id);
            } else {
                if (imageFile.exists()) {
                    ContentValues values = new ContentValues();
                    values.put(MediaStore.Images.Media.DATA, filePath);
                    return context.getContentResolver().insert(
                            MediaStore.Images.Media.EXTERNAL_CONTENT_URI, values);
                } else {
                    return null;
                }
            }
        } finally {
            if (cursor != null) cursor.close();
        }
    }

    private Uri getAudioContentUri(File audioFile) {
        Cursor cursor = null;
        try {
            String filePath = audioFile.getAbsolutePath();
            cursor = context.getContentResolver().query(
                    MediaStore.Audio.Media.EXTERNAL_CONTENT_URI,
                    new String[]{MediaStore.Audio.Media._ID},
                    MediaStore.Audio.Media.DATA + "=? ",
                    new String[]{filePath}, null);

            if (cursor != null && cursor.moveToFirst()) {
                int id = cursor.getInt(cursor
                        .getColumnIndex(MediaStore.MediaColumns._ID));
                Uri baseUri = Uri.parse("content://media/external/audio/media");
                return Uri.withAppendedPath(baseUri, "" + id);
            } else {
                if (audioFile.exists()) {
                    ContentValues values = new ContentValues();
                    values.put(MediaStore.Audio.Media.DATA, filePath);
                    return context.getContentResolver().insert(
                            MediaStore.Audio.Media.EXTERNAL_CONTENT_URI, values);
                } else {
                    return null;
                }
            }
        } finally {
            if (cursor != null) cursor.close();
        }
    }

    private Uri getVideoContentUri(File videoFile) {
        Cursor cursor = null;
        try {
            String filePath = videoFile.getAbsolutePath();
            cursor = context.getContentResolver().query(
                    MediaStore.Video.Media.EXTERNAL_CONTENT_URI,
                    new String[]{MediaStore.Video.Media._ID},
                    MediaStore.Video.Media.DATA + "=? ",
                    new String[]{filePath}, null);

            if (cursor != null && cursor.moveToFirst()) {
                int id = cursor.getInt(cursor
                        .getColumnIndex(MediaStore.MediaColumns._ID));
                Uri baseUri = Uri.parse("content://media/external/video/media");
                return Uri.withAppendedPath(baseUri, "" + id);
            } else {
                if (videoFile.exists()) {
                    ContentValues values = new ContentValues();
                    values.put(MediaStore.Video.Media.DATA, filePath);
                    return context.getContentResolver().insert(
                            MediaStore.Video.Media.EXTERNAL_CONTENT_URI, values);
                } else {
                    return null;
                }
            }
        } finally {
            if (cursor != null) cursor.close();
        }
    }

    public Uri getFileContentUri(File file) {
        Cursor cursor = null;
        try {
            String filePath = file.getAbsolutePath();
            cursor = context.getContentResolver().query(
                    MediaStore.Video.Media.EXTERNAL_CONTENT_URI,
                    new String[]{MediaStore.Video.Media._ID},
                    MediaStore.Video.Media.DATA + "=? ",
                    new String[]{filePath}, null);

            if (cursor != null && cursor.moveToFirst()) {
                int id = cursor.getInt(cursor
                        .getColumnIndex(MediaStore.MediaColumns._ID));
                Uri baseUri = Uri.parse("content://media/external/video/media");
                return Uri.withAppendedPath(baseUri, "" + id);
            } else {
                if (file.exists()) {
                    ContentValues values = new ContentValues();
                    values.put(MediaStore.Video.Media.DATA, filePath);
                    return context.getContentResolver().insert(
                            MediaStore.Video.Media.EXTERNAL_CONTENT_URI, values);
                } else {
                    return null;
                }
            }
        } finally {
            if (cursor != null) cursor.close();
        }
    }

}
