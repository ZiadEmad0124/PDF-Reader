package com.ziad_emad_div.pdf_reader

import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.ziad_emad_div.pdf_reader.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val pdfUri = intent.getStringExtra("pdf_uri")?.let { Uri.parse(it) }
        if (pdfUri != null) {
            binding.pdfViewer.fromUri(pdfUri).load()
        }
    }
}