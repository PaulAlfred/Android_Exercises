package com.android.developer.inputcontrols;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;



public class InputControlsActivity extends ActionBarActivity {

	CheckBox cbkEveryday;
	CheckBox cbkWeekday;
	CheckBox cbkWeekend;
	Spinner mSnooze;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_input_controls);
		
		cbkEveryday = (CheckBox) findViewById(R.id.checkBox1);
		cbkWeekday = (CheckBox) findViewById(R.id.checkBox2);
		cbkWeekend = (CheckBox) findViewById(R.id.checkBox3);
		mSnooze = (Spinner) findViewById(R.id.spinner1);
		
		final EditText edittext = (EditText) findViewById(R.id.editText1);
		Button button = (Button) findViewById(R.id.button1);
		button.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Toast.makeText(getApplication(), edittext.getText().toString() + "Alarm has been set", Toast.LENGTH_SHORT).show();
				}
		});
		
		
		
		cbkEveryday.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
			
			@Override
			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
				if(cbkEveryday.isChecked()==true){
					cbkWeekday.setEnabled(false);
					cbkWeekend.setEnabled(false);
				} else {
					cbkWeekday.setEnabled(true);
					cbkWeekend.setEnabled(true);
				}
				
			}
		});
		
		ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,  R.array.snooze_time_array, android.R.layout.simple_spinner_dropdown_item);
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		mSnooze.setAdapter(adapter);
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.input_controls, menu);
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
}
