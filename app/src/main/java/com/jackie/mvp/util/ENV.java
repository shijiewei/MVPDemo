package com.jackie.mvp.util;

public class ENV {
	//#if def{sdk.debugable}
	public static final boolean DEBUG = true;
	//#else
	//#=public static final boolean DEBUG = false;
	//#endif
}
