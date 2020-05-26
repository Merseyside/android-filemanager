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

//    fun setPassword(password : String) {
//        parameters.isEncryptFiles = true
//
//        //Set the encryption method to AES Zip Encryption
//        parameters.encryptionMethod = EncryptionMethod.ZIP_STANDARD
//
//        //AES_STRENGTH_128 - For both encryption and decryption
//        //AES_STRENGTH_192 - For decryption only
//        //AES_STRENGTH_256 - For both encryption and decryption
//        //Key strength 192 cannot be used for encryption. But if a zip file already has a
//        //file encrypted with key strength of 192, then Zip4j can decrypt this file
//        parameters.aesKeyStrength = AesKeyStrength.KEY_STRENGTH_256
//
//        //parameters.setPassword(password)
//    }

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