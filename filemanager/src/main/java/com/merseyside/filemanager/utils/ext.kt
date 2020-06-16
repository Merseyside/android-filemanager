package com.merseyside.filemanager.utils

import java.io.File

fun File.isEmpty(): Boolean {
    return length() == 0L
}