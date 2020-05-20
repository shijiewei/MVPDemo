package com.jackie.mvp.view;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.jackie.mvp.R;
import com.jackie.mvp.entity.HistoryEntity;
import com.jackie.mvp.history.HistoryAdapter;
import com.jackie.mvp.presenter.HistoryPresenter;
import com.jackie.mvp.util.MyLog;

import java.util.Date;

public class MainActivity extends BaseActivity implements IHistoryView, View.OnClickListener {
	private static final String TAG = "MainActivity";

	private Button testBtn;
	private TextView timesTv;
	private TextView timestampTv;
	private RecyclerView historyRv;
	private HistoryAdapter historyAdapter;
	private LinearLayoutManager layoutManager;
	private HistoryPresenter hPresenter;
	private int times = 0;

	@Override
	protected int getTitleId() {
		return R.string.main_title;
	}

	@Override
	protected int getContentViewId() {
		return R.layout.activity_main;
	}

	@Override
	protected void onViewCreated(Bundle savedInstanceState) {
		initView();
		hPresenter = new HistoryPresenter(this);
	}

	@Override
	public void onViewClicked(View v) {
		int id = v.getId();
		switch (id) {
			case R.id.btn_test_data_tv: {
				times++;
				hPresenter.loadData(times);
			}
		}
	}

	long preTime;
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if (keyCode == KeyEvent.KEYCODE_BACK) {
			long currentTime = new Date().getTime();
			// 如果时间间隔大于2秒，不处理
			if ((currentTime - preTime) > 1000) {
				// 显示消息
				Toast.makeText(this, "再按一次退出！", Toast.LENGTH_SHORT).show();
				//更新时间
				preTime = currentTime;
				//截获事件，不再处理
				return true;
			}
		}
		return super.onKeyDown(keyCode, event);
	}

	@Override
	public void onDataChanged(HistoryEntity data) {
		if (data != null) {
			MyLog.d(TAG, data.toJsonString());
			timesTv.setText(String.valueOf(data.getTimes()));
			timestampTv.setText(data.getTimestampDisp());
			historyAdapter.appendData(data);
			// Force scroll to the latest line
			layoutManager.scrollToPosition(historyAdapter.getSize() - 1);
		}
	}

	private void initView() {
		testBtn = findViewById(R.id.btn_test_data_tv);
		testBtn.setOnClickListener(this);
		timesTv = findViewById(R.id.times_tv);
		timestampTv = findViewById(R.id.timestamp_tv);

		historyAdapter = new HistoryAdapter(null);
		layoutManager = new LinearLayoutManager(this);
		historyRv = findViewById(R.id.history_rv);
		historyRv.setLayoutManager(layoutManager);
		historyRv.setAdapter(historyAdapter);
	}
}
