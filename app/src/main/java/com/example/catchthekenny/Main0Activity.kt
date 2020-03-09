package com.example.catchthekenny

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class Main0Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main0)
    }
    fun changeActivity(view: View){
        val intent= Intent(applicationContext,instruction::class.java)
        startActivity(intent)
    }
}
