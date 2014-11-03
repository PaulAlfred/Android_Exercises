package com.android_Exer.mvcpractice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.View;

public final class StarRatingView extends View implements StarRatingModel.Listener {
	
	
	public StarRatingView(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
	}
	private StarRatingModel model;
	private StarRatingController controller;
	public void setModel(StarRatingModel model) {
		if (model == null) {
			throw new NullPointerException("model");
		}

		StarRatingModel oldModel = this.model;
		if (oldModel != null) {
			oldModel.removeListener(this);
		}
		this.model = model;
		this.model.addListener(this);
		this.controller = new StarRatingController(this.model);

		if (oldModel != null) {
			invalidate();
		}
	}
	@Override
	protected void onDraw(Canvas canvas) {
		for (int i = 0; i < StarRatingModel.MAX_STARS; ++i) {
			float starX = starTopLeft.x + i * starSize;
			float starY = starTopLeft.y;

			Paint paint = null;
			if ((i + 1) <= model.getStars()) {
				// draw a gold star
				paint = goldPaint;
			} else {
				// draw a gray star
				paint = grayPaint;
			}

			starRect.set(starX, starY, starX + starSize, starY + starSize);
			canvas.drawBitmap(starBitmap, null, starRect, paint);
		}

		@Override
		public void handleStarRatingChanged(StarRatingModel sender) {
			invalidate();
		}
		public boolean onTouchEvent(MotionEvent event) {
			if (event.getAction() == MotionEvent.ACTION_DOWN) {
				controller.handleTap(event);
				return true;
			} else {
				return super.onTouchEvent(event);
			}
		}
	}
