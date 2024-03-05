package com.example.practical7

import android.media.MediaPlayer
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // create an instance of mediplayer for audio playback
        val mediaPlayer: MediaPlayer = MediaPlayer.create(applicationContext, R.raw.music)


        // register all the buttons using their appropriate IDs
        val bPlay: Button = findViewById(R.id.playButton)
        val bPause: Button = findViewById(R.id.pauseButton)
        val bStop: Button = findViewById(R.id.stopButton)


        // handle the start button to start the audio playback
        bPlay.setOnClickListener {
            mediaPlayer.start()
        }

        // handle the pause button to put the MediaPlayer instance at the Pause state
        bPause.setOnClickListener {
            mediaPlayer.pause()
        }

        // handle the stop button to stop playing and prepare the media player instance for the next instance of play
        bStop.setOnClickListener {
            mediaPlayer.stop()
            mediaPlayer.prepare()
        }

    }
}