package com.merseyside.filemanager.mime_types;


import android.mtp.MtpConstants;

public enum ImageTypes {

    JPEG(new MimeType(getFormat(), "jpeg", MtpConstants.FORMAT_EXIF_JPEG)),
    JPG(new MimeType(getFormat(), "jpeg", MtpConstants.FORMAT_EXIF_JPEG)),
    GIF(new MimeType(getFormat(), "gif", MtpConstants.FORMAT_GIF)),
    PNG(new MimeType(getFormat(), "png", MtpConstants.FORMAT_PNG)),
    BMP(new MimeType(getFormat(), "x-ms-bmp", MtpConstants.FORMAT_BMP));

    MimeType type;

    ImageTypes(MimeType type) {
        this.type = type;
    }

    public MimeType getValue() {
        return type;
    }

    public static String getFormat() {
        return "image";
    }
}
