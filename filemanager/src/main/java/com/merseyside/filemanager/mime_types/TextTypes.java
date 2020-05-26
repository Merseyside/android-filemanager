package com.merseyside.filemanager.mime_types;


import android.mtp.MtpConstants;

public enum TextTypes {

    TXT (new MimeType(getFormat(), "plain", MtpConstants.FORMAT_TEXT)),
    HTML(new MimeType(getFormat(), "html",  MtpConstants.FORMAT_HTML));

    MimeType type;

    TextTypes(MimeType type) {
        this.type = type;
    }

    public MimeType getValue() {
        return type;
    }

    public static String getFormat() {
        return "text";
    }
}
