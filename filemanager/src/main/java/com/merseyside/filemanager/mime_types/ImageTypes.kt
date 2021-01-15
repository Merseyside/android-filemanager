package com.merseyside.filemanager.mime_types

import android.mtp.MtpConstants

enum class ImageTypes(var value: MimeType) {
    JPEG(
        MimeType(format, "jpeg", MtpConstants.FORMAT_EXIF_JPEG)
    ),
    JPG(
        MimeType(
            format,
            "jpeg",
            MtpConstants.FORMAT_EXIF_JPEG
        )
    ),
    GIF(
        MimeType(format, "gif", MtpConstants.FORMAT_GIF)
    ),
    PNG(
        MimeType(format, "png", MtpConstants.FORMAT_PNG)
    ), BMP(
        MimeType(
            format,
            "x-ms-bmp",
            MtpConstants.FORMAT_BMP
        )
    );

    companion object {
        val format: String
            get() = "image"
    }
}