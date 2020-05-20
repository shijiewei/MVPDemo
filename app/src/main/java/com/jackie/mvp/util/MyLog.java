package com.jackie.mvp.util;

import android.util.Log;

public class MyLog {
	public static void v(String tag, String msg) {
		if (ENV.DEBUG) {
			Log.v(tag, msg);
		}
	}

	public static void v(String tag, String msg, Throwable tr) {
		if (ENV.DEBUG) {
			Log.v(tag, msg, tr);
		}
	}

	public static void d(String tag, String msg) {
		if (ENV.DEBUG) {
			Log.d(tag, msg);
		}
	}

	public static void d(String tag, String msg, Throwable tr) {
		if (ENV.DEBUG) {
			Log.d(tag, msg, tr);
		}
	}

	public static void i(String tag, String msg) {
		if (ENV.DEBUG) {
			Log.i(tag, msg);
		}
	}

	public static void i(String tag, String msg, Throwable tr) {
		if (ENV.DEBUG) {
			Log.i(tag, msg, tr);
		}
	}

	public static void w(String tag, String msg) {
		if (ENV.DEBUG) {
			Log.w(tag, msg);
		}
	}

	public static void w(String tag, String msg, Throwable tr) {
		if (ENV.DEBUG) {
			Log.w(tag, msg, tr);
		}
	}

	public static void e(String tag, String msg) {
		if (ENV.DEBUG) {
			Log.e(tag, msg);
		}
	}

	public static void e(String tag, String msg, Throwable tr) {
		if (ENV.DEBUG) {
			Log.e(tag, msg, tr);
		}
	}
}
