package com.jackie.mvp.entity;

import com.google.gson.Gson;

import java.io.Serializable;

public class BaseEntity implements Serializable {
	public String toJsonString() {
		Gson gson = new Gson();
		return gson.toJson(this);
	}
}
