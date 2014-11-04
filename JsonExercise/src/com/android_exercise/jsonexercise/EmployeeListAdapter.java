package com.android_exercise.jsonexercise;


import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.content.ClipData.Item;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

class SingleRow{
	String name;
	String profession;
	String age;
	int image;

	public SingleRow(String name, String profession, String age, int image) {
		this.name = name;
		this.profession = profession;
		this.age = age;
		this.image = image;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getProfession() {
		return profession;
	}

	public void setProfession(String profession) {
		this.profession = profession;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public int getImage() {
		return image;
	}

	public void setImage(int image) {
		this.image = image;
	}
}

public class EmployeeListAdapter extends BaseAdapter {

	Context context;
	LayoutInflater inflater;
	ArrayList<SingleRow> list;
	EmployeeListAdapter(Context c){

		this.context = c;
		list = new ArrayList<SingleRow>();
		int[] images = {R.drawable.ic_launcher, R.drawable.ic_launcher, R.drawable.ic_launcher, R.drawable.ic_launcher, R.drawable.ic_launcher, R.drawable.ic_launcher, R.drawable.ic_launcher, R.drawable.ic_launcher, R.drawable.ic_launcher};

		try{
			InputStream is = c.getAssets().open("myjson.txt");
			int size = is.available();
			byte[] buffer = new byte[size];
			is.read(buffer);
			is.close();
			String bufferString = new String(buffer);
			
			JSONObject MainObj = new JSONObject(bufferString);
			JSONArray jArr = MainObj.getJSONArray("employees");
			
	
			for(int i = 0; i < jArr.length(); i ++){
				JSONObject value = jArr.getJSONObject(i);
				list.add(new SingleRow(value.getString("name"), value.getString("profession"), value.getString("age"), images[i]));
			}
		}
		catch(JSONException |  IOException e){
			((Throwable) e).printStackTrace();
		}



	}




	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return list.size();
	}

	@Override
	public Object getItem(int i) {
		// TODO Auto-generated method stub
		return list.get(i);
	}

	@Override
	public long getItemId(int i) {
		// TODO Auto-generated method stub
		return i;
	}

	@Override
	public View getView(int i, View convertView, ViewGroup parent) {
		LayoutInflater inflater = (LayoutInflater) (context.getSystemService(Context.LAYOUT_INFLATER_SERVICE));
		View row =  inflater.inflate(R.layout.single_row, parent,  false);
		TextView name = (TextView) row.findViewById(R.id.textView1);
		TextView age = (TextView) row.findViewById(R.id.textView2);
		TextView profession = (TextView) row.findViewById(R.id.textView3);
		ImageView image = 	(ImageView) row.findViewById(R.id.imageView1);

		for(int j =0; j < list.size(); j++){
			SingleRow sr = list.get(j);
			name.setText(sr.getName());
			age.setText(sr.getAge());
			profession.setText(sr.getProfession());
			image.setImageResource(sr.getImage());
		}


		return row;
	}

}
