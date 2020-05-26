package com.merseyside.filemanager.mime_types;


import android.mtp.MtpConstants;

public enum AudioTypes {

    MP3  (new MimeType(getFormat(), "mpeg", MtpConstants.FORMAT_MP3)),
    MPGA (new MimeType(getFormat(), "mpeg", MtpConstants.FORMAT_MP3)),
    M4A  (new MimeType(getFormat(), "m4a",  MtpConstants.FORMAT_MPEG)),
    WAV  (new MimeType(getFormat(), "x-wav",MtpConstants.FORMAT_WAV)),
    WMA  (new MimeType(getFormat(), "mpeg", MtpConstants.FORMAT_MP3)),
    OGG  (new MimeType(getFormat(), "ogg",  MtpConstants.FORMAT_OGG)),
    AAC  (new MimeType(getFormat(), "aac",  MtpConstants.FORMAT_AAC)),
    FLAC (new MimeType(getFormat(), "flac", MtpConstants.FORMAT_FLAC));

    MimeType type;

    AudioTypes(MimeType type) {
        this.type = type;
    }

    public MimeType getValue() {
        return type;
    }

    public static String getFormat() {
        return "audio";
    }
}
