package com.k.dialog;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Shader;
import android.graphics.SweepGradient;
import android.util.AttributeSet;
import android.view.View;

public class MyProgressBar4 extends View {

	private Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
	private Shader mShader;
	private float x = 50.0f, y = 50.0f;
	private float swap = 0.02f;
	private Matrix mMatrix = new Matrix();

	private Paint tPaint = new Paint();
	private String value = "";
	private Rect rect = new Rect();
	

	public MyProgressBar4(Context context, AttributeSet attr) {
		super(context, attr);
		initPaint();
	}

	public MyProgressBar4(Context context) {
		super(context);
		initPaint();
	}

	private void initPaint() {
		mShader = new SweepGradient(x, y, new int[] { 0xFFFF0000, 0xCCCCCCCC }, new float[] { 1.0f, swap });
		mMatrix.setRotate(-90, x, y);
		mShader.setLocalMatrix(mMatrix);
		mPaint.setShader(mShader);
		mPaint.setStyle(Paint.Style.STROKE);
		mPaint.setStrokeWidth(7);
		mPaint.setAntiAlias(true);

		tPaint.setColor(Color.GREEN);
		tPaint.setTextSize(16);
	}

	private void resetShader() {
		mShader = new SweepGradient(x, y, new int[] { 0xFFFF0000, 0xCCCCCCCC }, new float[] { 1.0f, swap });
		mShader.setLocalMatrix(mMatrix);
		mPaint.setShader(mShader);
	}

	@Override
	protected void onDraw(Canvas canvas) {
		Paint paint = mPaint;
		canvas.drawText(value, x - rect.centerX(), y - rect.centerY(), tPaint);
		canvas.drawCircle(x, y, 30, paint);
	}

	public void changeProgressValue() {
		swap += 0.08f;
		int swapValue = (int)(swap * 100f);
		value = (swapValue > 100 ? 100 : swapValue) + "%";
		tPaint.getTextBounds(value, 0, value.length(), rect);
		resetShader();
		invalidate();
	}

	public float getSwapValue() {
		return swap;
	}

}
