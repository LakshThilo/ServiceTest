package com.example.servicetest

import android.app.Service
import android.content.Intent
import android.media.MediaPlayer
import android.os.IBinder
import android.util.Log

private const val TAG ="MusicPlayService"



class MusicPlayService : Service(){

    private lateinit var musicPlay: MediaPlayer

    /**
     *  Used to init variable or opening connection (DB/Network)
     * */

    companion object{

        const val EXTRA_ACTION_PLAY = "EXTRA_ACTION_PLAY"
        const val EXTRA_ACTION_STOP = "EXTRA_ACTION_STOP"
    }

    override fun onCreate() {
        super.onCreate()
        Log.d(TAG, "onCreate: ")
        musicPlay = MediaPlayer.create(
    this,
            R.raw.music
        )
    }


    /**
     * Used for Bound Service , you have to create
     * your IBinder in this class
     * if not ued, return null
     * */
    override fun onBind(p0: Intent?): IBinder? {
        Log.d(TAG, "onBind: ")
        return  null

    }

    /**
     * Execute the "running " body of the Service
     * */

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        super.onStartCommand(intent, flags, startId)
        Log.d(TAG, "onStartCommand: ")

        intent?.let {

            // these EXTRA values is for click buttons
            //for the first time im gonna click the button and send the intent with EXREA_PLAY and the no 1
            if(it.getIntExtra(EXTRA_ACTION_PLAY, 0) != 0)
                musicPlay.start() // if it not 0 play nad if it is not 0 stop playing

            if(it.getIntExtra(EXTRA_ACTION_STOP,0)!= 0)
                musicPlay.stop()
                stopSelf()
        }

        return START_STICKY
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy: ")
    }
}