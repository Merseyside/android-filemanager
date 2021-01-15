package com.merseyside.filemanager.mime_types

import android.mtp.MtpConstants

enum class FileTypes(var value: MimeType) {
    PDF(
        MimeType(format, "pdf", -1)
    ),
    DOC(
        MimeType(
            format,
            "msword",
            MtpConstants.FORMAT_MS_WORD_DOCUMENT
        )
    ),
    XLS(
        MimeType(format, "vnd.ms-excel", MtpConstants.FORMAT_MS_EXCEL_SPREADSHEET)
    ),
    ZIP(
        MimeType(format, "zip", -1)
    );

    companion object {
        val format: String
            get() = "application"
    }
}