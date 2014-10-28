package com.android_exercises.exerfive_activityinputresult;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity implements OnClickListener {
  
	final String TAG = "States";
	
	TextView tvName;
	Button btnName;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        tvName = (TextView) findViewById(R.id.tvName);
        btnName = (Button) findViewById(R.id.btnName);
        btnName.setOnClickListener(this);
        
        Log.d(TAG, "NameActivity: onCreate()");
    }

  @Override
  public void onClick(View v) {
    Intent intent = new Intent(this, NameActivity.class);
    startActivityForResult(intent, 1);
  }
  
  
  @Override
  protected void onActivityResult(int requestCode, int resultCode, Intent data) {
    if (data == null) {return;}
    String name = data.getStringExtra("name");
    tvName.setText("Your name is " + name);
  }
  @Override
  protected void onRestart() {
    super.onRestart();
    Log.d(TAG, "NameActivity: onRestart()");
  }

  @Override
  protected void onStart() {
    super.onStart();
    Log.d(TAG, "NameActivity: onStart()");
  }

  @Override
  protected void onResume() {
    super.onResume();
    Log.d(TAG, "NameActivity: onResume()");
  }

  @Override
  protected void onPause() {
    super.onPause();
    Log.d(TAG, "NameActivity: onPause()");
  }

  @Override
  protected void onStop() {
    super.onStop();
    Log.d(TAG, "NameActivity: onStop()");
  }

  @Override
  protected void onDestroy() {
    super.onDestroy();
    Log.d(TAG, "NameActivity: onDestroy()");
  }

}