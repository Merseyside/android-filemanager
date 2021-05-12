package com.merseyside.filemanager.file

import java.io.File

interface File {

    val path: String

    fun createFile(rewrire: Boolean = false): Boolean

    fun deleteFile(): Boolean

    fun write(data: Any)

    fun read(): Any?

    fun getFile(): File
}