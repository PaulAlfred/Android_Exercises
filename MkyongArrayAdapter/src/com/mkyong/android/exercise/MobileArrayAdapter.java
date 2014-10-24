package com.mkyong.android.exercise;

import android.widget.ArrayAdapter;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class MobileArrayAdapter extends ArrayAdapter<String> {
	private final Context context;
	private final String[] values;
	
	public MobileArrayAdapter(Context context, String[] values){
		super(context, R.layout.activity_list_mobile, values);
		this.context = context;
		this.values = values;
	}
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		LayoutInflater inflater = (LayoutInflater) context
			.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
 
		View rowView = inflater.inflate(R.layout.activity_list_mobile, parent, false);
		TextView textView = (TextView) rowView.findViewById(R.id.label);
		ImageView imageView = (ImageView) rowView.findViewById(R.id.logo);
		textView.setText(values[position]);
 
		// Change icon based on name
		String s = values[position];
 
		System.out.println(s);
 
		if (s.equals("dog1")) {
			imageView.setImageResource(R.drawable.sample_0);
		} else if (s.equals("dog2")) {
			imageView.setImageResource(R.drawable.sample_1);
		} else if (s.equals("dog3")) {
			imageView.setImageResource(R.drawable.sample_2);
		} else {
			imageView.setImageResource(R.drawable.sample_3);
		}
 
		return rowView;
	}
	
}
