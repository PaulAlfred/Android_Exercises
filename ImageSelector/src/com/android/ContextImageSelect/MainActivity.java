package com.android.ContextImageSelect;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends ActionBarActivity {

	final int Image1 = 1;
	final int Image2 = 2;
	final int Image3 = 3;
	
	final int Image_Fill = 4;
	final int Image_Wrap = 5;
	
	ImageView iView;
	TextView textView;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		iView = (ImageView) findViewById(R.id.imageView1);
		textView = (TextView) findViewById(R.id.textView1);
		
		registerForContextMenu(iView);
		registerForContextMenu(textView);
		
	}
	
	public void onCreateContextMenu(ContextMenu menu, View v, ContextMenuInfo menuInfo){
		switch(v.getId()){
		case R.id.textView1:
			menu.add(0, Image1, 0, "Image1");
			menu.add(0, Image2, 0, "Image2");
			menu.add(0, Image3, 0, "Image3");
		break;
		case R.id.imageView1:
			menu.add(0, Image_Fill, 0, "Fill_Parent");
			menu.add(0, Image_Wrap, 0, "Wrap_Parent");
		break;
		}
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
	public boolean onContextItemSelected(MenuItem item){
		
		switch(item.getItemId()){
		case Image1:
			iView.setImageResource(R.drawable.sample_0);
			break;
		case Image2:
			iView.setImageResource(R.drawable.sample_1);
			break;
		case Image3:
			iView.setImageResource(R.drawable.sample_2);
			break;
		case Image_Fill:
			iView.setMaxHeight(500);
			iView.setMaxWidth(300);
			break;
		case Image_Wrap:
			iView.setMaxHeight(100);
			iView.setMaxWidth(100);
			break;
		}
		
		return super.onContextItemSelected(item);
	}
}
