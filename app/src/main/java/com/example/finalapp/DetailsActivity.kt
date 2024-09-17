package com.example.finalapp

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class DetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        // Get the item title and detail passed from DashboardAdapter
        val itemTitle = intent.getStringExtra("itemTitle")
        val itemDetail = intent.getStringExtra("itemDetail")

        // Display the item title and detail on the details screen
        val itemTitleView = findViewById<TextView>(R.id.detailsTitle)
        val itemDetailView = findViewById<TextView>(R.id.itemDetail)

        itemTitleView.text = itemTitle
        itemDetailView.text = itemDetail
    }
}
