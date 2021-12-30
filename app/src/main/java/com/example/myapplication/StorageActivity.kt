package com.example.myapplication

import StorageFragment
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class StorageActivity : AppCompatActivity() {
    private val storageService = StorageService()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_storage)

        val data: String = storageService.readStorage(applicationContext, "MyData")
        val storageFragment = StorageFragment()
        val bundle = Bundle()

        bundle.putString("storageText", data)
        storageFragment.arguments = bundle

        supportFragmentManager.beginTransaction().replace(R.id.fragment_container, storageFragment)
            .commit()
    }
}