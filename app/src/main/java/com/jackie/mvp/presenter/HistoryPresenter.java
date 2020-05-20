package com.jackie.mvp.presenter;

import com.jackie.mvp.entity.HistoryEntity;
import com.jackie.mvp.model.HistoryModel;
import com.jackie.mvp.view.IHistoryView;
import com.jackie.mvp.view.MainActivity;

/**
 * Presenter示例
 *
 * 数据处理与加工可以放在这里
 *
 */
public class HistoryPresenter {
	private static final String TAG = "HistoryPresenter";

	private MainActivity activity;
	private IHistoryView iHistoryView;
	private HistoryModel historyModel;

	public HistoryPresenter(IHistoryView iHistoryView) {
		this.iHistoryView = iHistoryView;
		this.activity = (MainActivity)iHistoryView;
		historyModel = new HistoryModel();
	}

	public void loadData(int times) {
		// 向Model请求数据
		HistoryEntity entity = historyModel.requestData(times);
		// 回传数据给View
		iHistoryView.onDataChanged(entity);
	}
}
