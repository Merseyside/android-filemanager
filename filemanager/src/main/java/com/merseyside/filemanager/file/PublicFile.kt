package com.merseyside.filemanager.file

import android.content.Context
import android.os.Environment
import java.io.File as NativeFile

class PublicFile(
    context: Context, file: NativeFile
): DefaultFile(context, file) {

    constructor(
        context: Context,
        environmentType: String,
        folderName: String? = null,
        fileName: String? = ""
    ) : this(
        context,
        NativeFile(
            Environment.getExternalStoragePublicDirectory(environmentType).path + "/${folderName ?: ""}",
            fileName
        )
    )
}