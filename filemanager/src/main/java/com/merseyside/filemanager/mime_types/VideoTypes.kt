package com.merseyside.filemanager.mime_types

import android.mtp.MtpConstants

enum class VideoTypes(var value: MimeType) {
    MPEG(
        MimeType(format, "mpeg", MtpConstants.FORMAT_MPEG)
    ),
    MP4(
        MimeType(
            format,
            "mp4",
            MtpConstants.FORMAT_MPEG
        )
    ),
    MPG(
        MimeType(format, "mpeg", MtpConstants.FORMAT_MPEG)
    ),
    M4V(
        MimeType(format, "mp4", MtpConstants.FORMAT_MPEG)
    ),
    THREE_GP(
        MimeType(
            format,
            "3gpp",
            MtpConstants.FORMAT_3GP_CONTAINER
        )
    ),
    MKV(
        MimeType(format, "x-matroska", -1)
    ),
    AVI(
        MimeType(format, "avi", MtpConstants.FORMAT_AVI)
    );

    companion object {
        val format: String
            get() = "video"
    }
}