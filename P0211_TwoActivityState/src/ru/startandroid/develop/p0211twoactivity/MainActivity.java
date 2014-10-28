package ru.startandroid.develop.p0211twoactivity;



import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends ActionBarActivity implements OnClickListener {

	final String TAG = "States";
	Button btnActTwo;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		btnActTwo = (Button) findViewById(R.id.btnActTwo);
	    btnActTwo.setOnClickListener(this);
	    Log.d(TAG, "MainActivity: onCreate()");

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	@Override
	public void onClick(View v) {
		 switch (v.getId()) {
		    case R.id.btnActTwo:
                Intent intent = new Intent(this, ActivityTwo.class);
                startActivity(intent);
		      break;
		    default:
		      break;
		    }
	}
	@Override
	  protected void onRestart() {
	    super.onRestart();
	    Log.d(TAG, "MainActivity: onRestart()");
	  }

	  @Override
	  protected void onStart() {
	    super.onStart();
	    Log.d(TAG, "MainActivity: onStart()");
	  }

	  @Override
	  protected void onResume() {
	    super.onResume();
	    Log.d(TAG, "MainActivity: onResume()");
	  }

	  @Override
	  protected void onPause() {
	    super.onPause();
	    Log.d(TAG, "MainActivity: onPause()");
	  }

	  @Override
	  protected void onStop() {
	    super.onStop();
	    Log.d(TAG, "MainActivity: onStop()");
	  }

	  @Override
	  protected void onDestroy() {
	    super.onDestroy();
	    Log.d(TAG, "MainActivity: onDestroy()");
	  }

}
