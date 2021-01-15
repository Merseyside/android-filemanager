package com.merseyside.filemanager.mime_types

class MimeType(val format: String, val subformat: String, private val mtp_const: Int) {
    val mimeType: String
        get() = "$format/$subformat"
}