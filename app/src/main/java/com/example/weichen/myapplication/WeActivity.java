package com.example.weichen.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class WeActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
	
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activiyt_we);
		
		ImageView  image=(ImageView) findViewById(R.id.jinru);
		image.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent=new Intent(WeActivity.this, RelativeActivity.class);
				
				intent.putExtra("name", "zhouxiaol");
				intent.putExtra("id", 23);
				startActivity(intent);
			}
		});
	}

}
