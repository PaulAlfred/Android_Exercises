package com.android_exercises.exerfive_activityinputresult;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class NameActivity extends Activity implements OnClickListener{
	
	final String TAG = "States";
	
	EditText eText;
	Button button;
	Intent intent;
	
	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.two);
		
		eText = (EditText) findViewById(R.id.editText1);
		button = (Button) findViewById(R.id.button1);
		button.setOnClickListener(this);
		
		Log.d(TAG, "NameActivity: onCreate()");
	}


	  @Override
	  public void onClick(View v) {
	    Intent intent = new Intent();
	    intent.putExtra("name", eText.getText().toString());
	    setResult(RESULT_OK, intent);
	    finish();
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
