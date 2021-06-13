//package com.merseyside.filemanager
//
//import android.content.Intent
//import android.net.Uri
//import android.os.Bundle
//import android.provider.MediaStore
//import androidx.appcompat.app.AppCompatActivity
//import androidx.core.content.FileProvider
//import com.merseyside.filemanager.databinding.ActivityMainBinding
//
//class MainActivity : AppCompatActivity() {
//
//    private lateinit var binding: ActivityMainBinding
//    private var uri: Uri? = null
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//
//        binding = ActivityMainBinding.inflate(layoutInflater)
//        setContentView(binding.root)
//
//        startPhoto()
//    }
//
//    fun startPhoto() {
//        val intent = Intent(MediaStore.INTENT_ACTION_STILL_IMAGE_CAMERA)
//        val file = FileManager.createFile(cacheDir.path, "pic.png")
//        uri = FileProvider.getUriForFile(this, "com.merseyside.fileprovider", file!!)
//        intent.putExtra(MediaStore.EXTRA_OUTPUT, this.uri)
//        startActivityForResult(intent, REQUEST_CODE_PHOTO)
//    }
//
//    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
//        super.onActivityResult(requestCode, resultCode, data)
//
//        val imageManager = ImageManager(this)
//        val bitmap = imageManager.getBitmap(uri!!)
//        binding.image.setImageBitmap(bitmap)
//    }
//
//    companion object {
//        private const val REQUEST_CODE_PHOTO = 312
//
//        private const val TAG = "MainActivity"
//    }
//}