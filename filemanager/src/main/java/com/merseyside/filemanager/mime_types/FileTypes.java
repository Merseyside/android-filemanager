package com.merseyside.filemanager.mime_types;


import android.mtp.MtpConstants;

public enum FileTypes {

    PDF(new MimeType(getFormat(), "pdf", -1)),
    DOC(new MimeType(getFormat(), "msword", MtpConstants.FORMAT_MS_WORD_DOCUMENT)),
    XLS(new MimeType(getFormat(), "vnd.ms-excel", MtpConstants.FORMAT_MS_EXCEL_SPREADSHEET)),
    ZIP(new MimeType(getFormat(), "zip", -1));

    MimeType type;

    FileTypes(MimeType type) {
        this.type = type;
    }

    public MimeType getValue() {
        return type;
    }

    public static String getFormat() {
        return "application";
    }
}
