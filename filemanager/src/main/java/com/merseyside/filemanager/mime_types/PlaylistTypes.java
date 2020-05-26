package com.merseyside.filemanager.mime_types;


import android.mtp.MtpConstants;

public enum PlaylistTypes {

    M3U (new MimeType(getFormat(), "x-mpegurl", MtpConstants.FORMAT_M3U_PLAYLIST)),
    PLS (new MimeType(getFormat(), "x-scpls", MtpConstants.FORMAT_PLS_PLAYLIST)),
    M3U8(new MimeType(getFormat(), "x-mpegurl", -1));

    MimeType type;

    PlaylistTypes(MimeType type) {
        this.type = type;
    }

    public MimeType getValue() {
        return type;
    }

    public static String getFormat() {
        return "audio";
    }
}
