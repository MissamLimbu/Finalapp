package com.example.finalapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class DashboardActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerViewDashboard)
        recyclerView.layoutManager = LinearLayoutManager(this)

        //Items for the dashboard
        val items = listOf(
            "TAFE",
            "Undergraduate",
            "Postgraduate",
            "Research"
        )

        // Create a map of corresponding details for each item
        val detailsMap = mapOf(
            "TAFE" to "Skill-based learning.",
            "Undergraduate" to "First-level university degree.",
            "Postgraduate" to "Enhance skills and expertise.",
            "Research" to "Master by Research and PhD."
        )

        // Set the adapter for the RecyclerView, passing both the items and the details
        recyclerView.adapter = DashboardAdapter(items, detailsMap)
    }
}
