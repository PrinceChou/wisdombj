package com.peachou.wisdombj.base;

import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.TextView;

import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;
import com.peachou.wisdombj.MainActivity;
import com.peachou.wisdombj.R;

public class BasePager {
	public Activity mActivity;
	public View mRootView;
	public ImageButton btnMenu;//菜单按钮
	public TextView tvTitle;
	public FrameLayout flContent;
	public BasePager(Activity activity){
		mActivity = activity;
		initViews();
	}
	/**
	 * 初始化布局
	 */
	public void initViews(){
		mRootView = View.inflate(mActivity, R.layout.base_pager, null);
		tvTitle = (TextView) mRootView.findViewById(R.id.tv_title);
		flContent = (FrameLayout) mRootView.findViewById(R.id.fl_content);
		btnMenu = (ImageButton) mRootView.findViewById(R.id.btn_menu);
		btnMenu.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				toggleSlidingMenu();
			}
		});
	}
	//切换SlidingMenu的状态
	protected void toggleSlidingMenu(){
		MainActivity mainUi = (MainActivity) mActivity;
		SlidingMenu slidingMenu = mainUi.getSlidingMenu();
		slidingMenu.toggle();//切换状态
	}
	/**
	 * 初始化数据
	 */
	public void initData(){
		
	}
	//隐藏SlidingMenu
	public void setSlidingMenuEnable(boolean enable){
		MainActivity mainUi = (MainActivity) mActivity;
		SlidingMenu slidingMenu = mainUi.getSlidingMenu();
		if (enable) {
			slidingMenu.setTouchModeAbove(SlidingMenu.TOUCHMODE_MARGIN);
		}else {
			slidingMenu.setTouchModeAbove(SlidingMenu.TOUCHMODE_NONE);
		}
	}
	
}
