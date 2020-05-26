package com.merseyside.filemanager.mime_types;


import android.mtp.MtpConstants;


public enum VideoTypes {

    MPEG    (new MimeType(getFormat(), "mpeg",      MtpConstants.FORMAT_MPEG)),
    MP4     (new MimeType(getFormat(), "mp4",       MtpConstants.FORMAT_MPEG)),
    MPG     (new MimeType(getFormat(), "mpeg",      MtpConstants.FORMAT_MPEG)),
    M4V     (new MimeType(getFormat(), "mp4",       MtpConstants.FORMAT_MPEG)),
    THREE_GP(new MimeType(getFormat(), "3gpp",      MtpConstants.FORMAT_3GP_CONTAINER)),
    MKV     (new MimeType(getFormat(), "x-matroska", -1)),
    AVI     (new MimeType(getFormat(), "avi",       MtpConstants.FORMAT_AVI));

    MimeType type;

    VideoTypes(MimeType type) {
        this.type = type;
    }

    public MimeType getValue() {
        return type;
    }

    public static String getFormat() {
        return "video";
    }
}
