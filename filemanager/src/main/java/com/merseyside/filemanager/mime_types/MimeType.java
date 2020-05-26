package com.merseyside.filemanager.mime_types;


public class MimeType {

    private final String subformat;
    private final String format;
    private final int mtp_const;

    public MimeType(String format, String subformat, int mtp_const) {
        this.subformat = subformat;
        this.format = format;
        this.mtp_const = mtp_const;
    }

    public String getSubformat() {
        return subformat;
    }

    public String getFormat() {
        return format;
    }

    public String getMimeType() {
        return format + "/" + subformat;
    }
}
