package com.ziad_emad_div.pdf_reader

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity

@SuppressLint("CustomSplashScreen")
class SplashScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        runApp()
    }

    private fun runApp() {
        Handler(Looper.myLooper()!!).postDelayed({
            selectPdf()
        }, 2000)
    }

    private fun selectPdf() {
        val intent = Intent(Intent.ACTION_OPEN_DOCUMENT).apply {
            addCategory(Intent.CATEGORY_OPENABLE)
            type = "application/pdf"
        }
        selectPdfLauncher.launch(intent)
    }

    private val selectPdfLauncher =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == RESULT_OK) {
                val uri: Uri? = result.data?.data
                if (uri != null) {
                    openPdf(uri)
                }
            }
        }

    private fun openPdf(uri: Uri) {
        val intent = Intent(this, MainActivity::class.java).apply {
            putExtra("pdf_uri", uri.toString())
        }
        startActivity(intent)
        finish()
    }
}