package com.jackie.mvp.view;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.jackie.mvp.R;

/**
 * Activity的基类, 做一些公共的处理
 */

public abstract class BaseActivity extends Activity implements View.OnClickListener {
	protected ImageView leftIv;
	protected TextView centerTv;
	protected ImageView rightIv;
	private View titleView;
	private ViewGroup container;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		// 加载View
		LayoutInflater inflater = LayoutInflater.from(this);
		container = (ViewGroup) inflater.inflate(R.layout.common_base_container, null);
		int contentId = getContentViewId();
		if (contentId > 0) {
			View content = inflater.inflate(contentId, null);
			container.addView(content, new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
		}
		setContentView(container);
		initView(container);
		// 通知子类View加载完毕
		onViewCreated(savedInstanceState);

		if (getTitleId() > 0) {
			centerTv.setText(getTitleId());
		}
	}

	protected abstract int getContentViewId();
	protected abstract void onViewCreated(Bundle savedInstanceState);
	protected boolean onShowTitleBar() {
		return true;
	}
	protected int getTitleId(){return 0;}
	protected boolean onLeftEvent() {
		return false;
	}
	protected void onRightEvent(){}
	protected void onViewClicked(View v) {}

	@Override
	public <T extends View> T findViewById(int id) {
		if (container != null) {
			return container.findViewById(id);
		} else {
			return super.findViewById(id);
		}
	}

	private void initView(View container) {
		titleView = container.findViewById(R.id.common_title_bar_container);
		if (!onShowTitleBar()) {
			titleView.setVisibility(View.GONE);
		}
		leftIv = container.findViewById(R.id.title_bar_left_iv);
		leftIv.setOnClickListener(this);
		centerTv = container.findViewById(R.id.title_bar_label);
		rightIv = container.findViewById(R.id.title_bar_right_iv);
		rightIv.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
			case R.id.title_bar_left_iv: {
				// 通知子类左上角View点击事件
				boolean handled = onLeftEvent();
				if (!handled) {
					finish();
				}
				break;
			}
			case R.id.title_bar_right_iv: {
				// 通知子类右上角View点击事件
				onRightEvent();
				break;
			}
			default: {
				// 其余点击传递给子类
				onViewClicked(v);
				break;
			}
		}
	}
}
