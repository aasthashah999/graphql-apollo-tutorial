package com.cornellappdev.apollo_android_tutorial

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.lifecycle.lifecycleScope
import com.cornellappdev.LaunchRocketQuery
import com.cornellappdev.apollo_android_tutorial.networking.NetworkingUtils
import kotlinx.coroutines.*
import kotlinx.coroutines.Dispatchers.Main

class MainActivity : AppCompatActivity() {

    private lateinit var launchNameTv: TextView
    private var launchObj: LaunchRocketQuery.Launch? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        launchNameTv = findViewById(R.id.lauch_tv)

        //lifecycleScope allows us to run the networking call in the background
        lifecycleScope.launch(Main) {
            launchObj = NetworkingUtils.retrieveData("90")
            launchNameTv.text = launchObj!!.site

        }
    }


}


