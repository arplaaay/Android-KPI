package com.example.myapplication
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle


class MainActivity : AppCompatActivity(), InputLangFragment.OnLangSent, InputLangFragment.ShowStorage {
    private val storageService = StorageService()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val inputFragment = InputLangFragment()
        supportFragmentManager.beginTransaction().replace(R.id.fragment_container, inputFragment)
            .commit()
    }


    override fun sendData(text: String) {
        val outputFragment = OutputResultFragment()
        val bundle = Bundle()

        bundle.putString("text", text)
        outputFragment.arguments = bundle

        storageService.writeFileOnInternalStorage(applicationContext, "MyData", text)

        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, outputFragment).addToBackStack(null).commit()


    }

    override fun show() {
        val intent = Intent(this, StorageActivity::class.java)
        startActivity(intent)
    }
}
