package com.jackie.mvp.view;

import com.jackie.mvp.entity.HistoryEntity;

/**
 * View示例
 *
 * 主要定义一些从Presenter接收数据的接口，不同的页面，可以定义不同的接口
 *
 */
public interface IHistoryView {
	void onDataChanged(HistoryEntity data);
}
