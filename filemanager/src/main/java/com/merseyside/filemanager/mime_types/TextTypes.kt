package com.merseyside.filemanager.mime_types

import android.mtp.MtpConstants

enum class TextTypes(var value: MimeType) {
    TXT(
        MimeType(format, "plain", MtpConstants.FORMAT_TEXT)
    ),
    HTML(
        MimeType(
            format,
            "html",
            MtpConstants.FORMAT_HTML
        )
    );

    companion object {
        val format: String
            get() = "text"
    }
}