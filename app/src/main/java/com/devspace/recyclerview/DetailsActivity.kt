package com.devspace.recyclerview

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class DetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_details)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val name = intent.getStringExtra("name")
        val phone = intent.getStringExtra("phone")
        val image = intent.getIntExtra("image", R.drawable.sample1)

        val tv_namedetails = findViewById<TextView>(R.id.tv_namedetails)
        val tv_phonedetails = findViewById<TextView>(R.id.tv_phonedetails)
        val iv_imagedetails = findViewById<ImageView>(R.id.iv_imagedetails)

        tv_namedetails.text = name
        tv_phonedetails.text = phone
        iv_imagedetails.setImageResource(image)

        val sharecontact = findViewById<TextView>(R.id.tv_share)

        sharecontact.setOnClickListener {
            val sendIntent: Intent = Intent().apply {
                action = Intent.ACTION_SEND
                putExtra(Intent.EXTRA_TEXT, "$name - $phone")
                type = "text/plain"

            }

            val shareIntent = Intent.createChooser(sendIntent, null)
            startActivity(shareIntent)

        }

    }
}