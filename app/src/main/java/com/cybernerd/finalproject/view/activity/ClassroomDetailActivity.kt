package com.cybernerd.finalproject.view.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import com.cybernerd.finalproject.R

class ClassroomDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_classroom_detail)

        val name = intent.getStringExtra("name")
        val description = intent.getStringExtra("description")

        val actionbar = supportActionBar
        actionbar?.title = name

    }
}
