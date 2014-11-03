package com.android_exercise.jsonexercise;

import java.util.ArrayList;

import android.content.Context;
import android.content.res.Resources;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

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
}

public class EmployeeListAdapter extends BaseAdapter {
	
	Context context;
	LayoutInflater inflater;
	ArrayList<SingleRow> list;
	EmployeeListAdapter(Context c){

		this.context = c;
		list = new ArrayList<SingleRow>();
		Resources res = c.getResources();
		String[] name = res.getStringArray(R.array.emp_arr);
		String[] profession = res.getStringArray(R.array.emp_arr);
		String[] age = res.getStringArray(R.array.emp_arr);
		int[] images = {R.drawable.ic_launcher, R.drawable.ic_launcher, R.drawable.ic_launcher, R.drawable.ic_launcher, R.drawable.ic_launcher, R.drawable.ic_launcher, R.drawable.ic_launcher, R.drawable.ic_launcher, R.drawable.ic_launcher};
		for(int i=0; i<9; i++){
			list.add( new SingleRow( name[i], profession[i], age[i],images[i]));
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
		
		SingleRow temp = list.get(i);
		
		name.setText("1");
		age.setText("2");
		profession.setText(temp.profession);
		
		return row;
	}

}
