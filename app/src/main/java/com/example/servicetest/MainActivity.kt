package com.example.servicetest

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // service goona behave as singlton there create onece any user it over and over
        findViewById<Button>(R.id.btn_play).setOnClickListener {
            //Explicit Intent
            val playIntent = Intent()
            playIntent.setClass(
                this@MainActivity,
                MusicPlayService::class.java // setClass method is a Java methos
                                                // that's why need to pass java class reference
            )
            playIntent.putExtra(MusicPlayService.EXTRA_ACTION_PLAY,1)

                //init the Service
            startService(playIntent)
        }

        findViewById<Button>(R.id.btn_stop).setOnClickListener {
            //Explicit Intent
            val stopIntent = Intent()
            stopIntent.setClass(
                this@MainActivity,
                MusicPlayService::class.java // setClass method is a Java methos
                // that's why need to pass java class reference
            )
            stopIntent.putExtra(MusicPlayService.EXTRA_ACTION_STOP,1)

            //init the Service
            startService(stopIntent)
            stopService(stopIntent)
        }
    }
}