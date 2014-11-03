package com.android_exer.mvcexer;

import android.content.Context;
import android.view.MotionEvent;
import android.widget.Toast;

public class Control {
	private Model model;
	Context context;
	public Control(Model model, Context context){
		this.model = model;
		this.context = context;
	}
	
	public void handleTap() {
	    // the old trick with % to wrap around values
	    model.setName(model.getName() + " you are so cool");
	    
	    Toast.makeText(context, model.getName(), Toast.LENGTH_SHORT).show();
	  }
}
