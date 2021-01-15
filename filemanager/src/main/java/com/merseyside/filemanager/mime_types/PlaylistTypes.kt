package com.merseyside.filemanager.mime_types

import android.mtp.MtpConstants

enum class PlaylistTypes(var value: MimeType) {
    M3U(
        MimeType(format, "x-mpegurl", MtpConstants.FORMAT_M3U_PLAYLIST)
    ),
    PLS(
        MimeType(
            format,
            "x-scpls",
            MtpConstants.FORMAT_PLS_PLAYLIST
        )
    ),
    M3U8(
        MimeType(format, "x-mpegurl", -1)
    );

    companion object {
        val format: String
            get() = "audio"
    }
}