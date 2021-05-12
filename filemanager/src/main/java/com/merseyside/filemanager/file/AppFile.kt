package com.merseyside.filemanager.file

import android.content.Context
import java.io.File as NativeFile

class AppFile(
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
            context.getExternalFilesDir(environmentType)?.path + "/${folderName ?: ""}",
            fileName
        )
    )
}