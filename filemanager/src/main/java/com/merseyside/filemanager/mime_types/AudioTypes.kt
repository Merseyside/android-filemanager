package com.merseyside.filemanager.mime_types

import android.mtp.MtpConstants

enum class AudioTypes(var value: MimeType) {
    MP3(
        MimeType(format, "mpeg", MtpConstants.FORMAT_MP3)
    ),
    MPGA(
        MimeType(
            format,
            "mpeg",
            MtpConstants.FORMAT_MP3
        )
    ),
    M4A(
        MimeType(format, "m4a", MtpConstants.FORMAT_MPEG)
    ),
    WAV(
        MimeType(format, "x-wav", MtpConstants.FORMAT_WAV)
    ),
    WMA(
        MimeType(
            format,
            "mpeg",
            MtpConstants.FORMAT_MP3
        )
    ),
    OGG(
        MimeType(format, "ogg", MtpConstants.FORMAT_OGG)
    ),
    AAC(
        MimeType(format, "aac", MtpConstants.FORMAT_AAC)
    ),
    FLAC(
        MimeType(
            format,
            "flac",
            MtpConstants.FORMAT_FLAC
        )
    );

    companion object {
        val format: String
            get() = "audio"
    }
}