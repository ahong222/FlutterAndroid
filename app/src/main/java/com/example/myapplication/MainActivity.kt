package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import io.flutter.embedding.android.FlutterActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.startFlutter).setOnClickListener {
            startActivity(Intent(this@MainActivity, MyFlutterActivity::class.java))
        }

        findViewById<Button>(R.id.startFlutter2).setOnClickListener {
            startActivity(Intent(this@MainActivity, SecondFlutterActivity::class.java))
        }

        findViewById<Button>(R.id.startFlutter3).setOnClickListener {
            val intent = FlutterActivity.withNewEngine()
                .initialRoute("main")
                .build(this)
            startActivity(intent)
        }


    }
}