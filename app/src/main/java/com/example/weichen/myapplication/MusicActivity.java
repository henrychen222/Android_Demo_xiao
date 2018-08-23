package com.example.weichen.myapplication;

import java.io.IOException;

import android.app.Activity;
import android.app.Service;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MusicActivity extends Activity {
	private Button playbt;
	private Button pausebt;
	private Button stopbt;
	private Button addbt;
	private Button lowbt;
	private MediaPlayer mediaPlayer;
	private AudioManager audio;
	private int position;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_music);
		playbt = (Button) findViewById(R.id.playbt);
		mediaPlayer = MediaPlayer.create(MusicActivity.this, R.raw.zha);
		
		audio = (AudioManager) getSystemService(Service.AUDIO_SERVICE);
		playbt.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if(position==0)
				{mediaPlayer.start();}
				else
				{
					
					mediaPlayer.seekTo(position);
					mediaPlayer.start();
					
				}
			}
		});
		pausebt = (Button) findViewById(R.id.puasebt);
		pausebt.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				mediaPlayer.pause();
				position=mediaPlayer.getCurrentPosition();
			}
		});
		stopbt = (Button) findViewById(R.id.stopbt);
		stopbt.setOnClickListener(new View.OnClickListener() {

		

			@Override
			public void onClick(View v) {
				mediaPlayer.stop();
				
				
			}
		});
		addbt = (Button) findViewById(R.id.addbt);
		addbt.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				audio.adjustStreamVolume(AudioManager.STREAM_MUSIC,
						AudioManager.ADJUST_RAISE, AudioManager.FLAG_SHOW_UI);
			}
		});
		lowbt = (Button) findViewById(R.id.lowbt);
		lowbt.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				audio.adjustStreamVolume(AudioManager.STREAM_MUSIC,
						AudioManager.ADJUST_LOWER, AudioManager.FLAG_SHOW_UI);
			}
		});
	}

}
