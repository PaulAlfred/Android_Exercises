package com.android_exer.mvcexer;

import java.util.ArrayList;
import java.util.List;

public class Model {

	public static final String default_name = "Jack";
	
	public interface Listener{
		void handleStarRatingChanged(Model model);
	}
	
	private List<Listener> listener = new ArrayList<Listener>();
	
	public Model(){
		
	}
	private String  name = "Joaquin";
	
	public String getName(){
		return name;
	}
	
	public void setName(String name){
		if(name != this.name){
			this.name = name;
		}
	}
	
	public void addListener(Listener listener){
		this.listener.add(listener);
	}
	public void removeListener(Listener listener){
		this.listener.remove(listener);
	}
}
