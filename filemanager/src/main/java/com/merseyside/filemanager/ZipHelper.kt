package com.merseyside.filemanager

import net.lingala.zip4j.ZipFile
import java.io.File
import net.lingala.zip4j.model.ZipParameters
import net.lingala.zip4j.model.enums.AesKeyStrength
import net.lingala.zip4j.model.enums.CompressionLevel
import net.lingala.zip4j.model.enums.CompressionMethod
import net.lingala.zip4j.model.enums.EncryptionMethod


class ZipHelper(var file : File) {

    constructor(path: String, filename: String) : this(File(path, filename))

    var parameters = ZipParameters()
    private val zipFile : ZipFile
    private val fileList = ArrayList<File>()

    init {
        if (!file.name.endsWith(".zip")) {
            file = File(file.path, "${file.name}.zip")
        }

        zipFile = ZipFile(file)

        parameters.compressionMethod = CompressionMethod.STORE // set compression method to deflate compression
        parameters.compressionLevel = CompressionLevel.NORMAL

    }

    fun addFile(file : File) {
        fileList.add(file)
    }

    fun addFiles(vararg files: File) {
        fileList.addAll(files)
    }

    fun zip(): File {
        zipFile.addFiles(fileList, parameters)

        return file
    }

}