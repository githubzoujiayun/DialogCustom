package com.wl;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.k.dialog.DialogCustom;
import com.k.dialog.MyProgressBar4;

public class MyprogressBarActivity4 extends Activity {
	Activity context;
	Button btn;
	MyProgressBar4 progressBar = null;

	Handler handler = new Handler() {
		public void handleMessage(android.os.Message msg) {
			if (progressBar.getSwapValue() <= 1.0f) {
				progressBar.changeProgressValue();
				handler.sendEmptyMessageDelayed(0, 500);
			}
		};
	};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		context=this;
//		setContentView(R.layout.myprogressdialog);
		setContentView(R.layout.main);
		btn=(Button)findViewById(R.id.button);
//		progressBar = (MyProgressBar4) findViewById(R.id.my_progress_bar_4);
//		handler.sendEmptyMessageDelayed(0, 500);
		btn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				DialogCustom d = new DialogCustom(context,R.style.ProgressDialog);  
		        d.show();  
			}
		});
	}

}
