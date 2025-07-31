package com.example.testaddtoapp

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout.LayoutParams.MATCH_PARENT
import android.view.ViewGroup
import io.flutter.embedding.android.FlutterView

class MainActivity : AppCompatActivity() {
    private lateinit var engines: FlutterViewEngines

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        engines = FlutterViewEngines(applicationContext)
        engines.attachToActivity(this)

        setContentView(R.layout.activity_main)

        val flutterContainer = requireViewById<ViewGroup>(R.id.flutter_view_container)

        val flutterView = FlutterView(applicationContext)
        flutterContainer.addView(flutterView, MATCH_PARENT, MATCH_PARENT)
        
        var flutterViewEngine = engines.createAndRunEngine("1", listOf())
        flutterViewEngine.attachFlutterView(flutterView)
    }
}
