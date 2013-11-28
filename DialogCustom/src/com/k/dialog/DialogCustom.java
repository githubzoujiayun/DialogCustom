package com.k.dialog;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.wl.R;

public class DialogCustom extends Dialog{
	TextView tvLoading;
	/**
	 * 通过主题样式来控制标题栏
	 * @param context
	 * @param theme
	 */
	public DialogCustom(Context context, int theme) {
		super(context, theme);
		//加载布局文件
		View v=LayoutInflater.from(context).inflate(R.layout.dialog_progress, null);
		tvLoading=(TextView)v.findViewById(R.id.tvLoading);
		this.setContentView(v);
	}
	public void setMessage(String content){
		tvLoading.setText(content);
	}
}
