package com.example.weichen.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class RelativeActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activiyt_relative);
		Button button=(Button) findViewById(R.id.fanhui);
		Intent intent=getIntent();
		String name=intent.getStringExtra("name");
		int id=intent.getIntExtra("id",-1);
		Log.e("tag", "name=="+name);
		Log.e("tag", "id=="+id);
		
		String msg="name="+name+";"+"id="+id;
		Toast.makeText(RelativeActivity.this, msg, Toast.LENGTH_SHORT).show();
		TextView text=(TextView) findViewById(R.id.content);
		text.setText(msg);
		button.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				
				
				
				finish();
			}
		});
	}
		
}
