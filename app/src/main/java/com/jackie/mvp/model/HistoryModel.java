package com.jackie.mvp.model;

import com.jackie.mvp.entity.HistoryEntity;

/**
 * Model示例
 *
 * 主要的数据获取可以放在这里
 *
 * 数据获取包括：请求网络、读取DB、调用第三方SDK接口等
 *
 */
public class HistoryModel {
	private static final String TAG = "HistoryModel";

	public HistoryModel() {}

	public HistoryEntity requestData(int times) {
		// 为了方便演示，这里直接返回一个fake数据
		HistoryEntity entity = new HistoryEntity(times, System.currentTimeMillis());
		return entity;
	}
}
