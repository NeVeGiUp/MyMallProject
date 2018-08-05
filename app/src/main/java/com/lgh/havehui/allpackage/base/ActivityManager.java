package com.lgh.havehui.allpackage.base;

import android.app.Activity;

import java.util.Stack;

/**
 * activity管理类，防止activity跳转混乱
 * 
 * @author Change
 */
public class ActivityManager {
	/**
	 * 接收activity的Stack
	 */
	private static Stack<Activity> activityStack = null;
	private static ActivityManager activityManager = null;

	private ActivityManager() {
	}

	/**
	 * 单实�?
	 * 
	 * @return
	 */
	public static ActivityManager getInstance() {
		if (activityManager == null) {
			activityManager = new ActivityManager();
		}
		return activityManager;
	}

	/**
	 * 将activity移出�?
	 * 
	 * @param activity
	 */
	public void popActivity(Activity activity) {
		if (activity != null) {
			activityStack.remove(activity);
		}
	}

	/**
	 * 结束指定activity
	 * 
	 * @param activity
	 */
	public void endActivity(Activity activity) {
		if (activity != null) {
			activity.finish();
			activityStack.remove(activity);
			activity = null;
		}
	}

	/**
	 * 获得当前的activity(即最上层)
	 * 
	 * @return
	 */
	public Activity currentActivity() {
		Activity activity = null;
		if (!activityStack.empty())
			activity = activityStack.lastElement();
		return activity;
	}

	/**
	 * 将activity推入栈内
	 * 
	 * @param activity
	 */
	public void pushActivity(Activity activity) {
		if (activityStack == null) {
			activityStack = new Stack<Activity>();
		}
		activityStack.add(activity);
	}

	/**
	 * 弹出除cls外的�?有activity
	 * 
	 * @param cls
	 */
	public void popAllActivityExceptOne(Class<? extends Activity> cls) {
		while (true) {
			Activity activity = currentActivity();
			if (activity == null) {
				break;
			}
			if (activity.getClass().equals(cls)) {
				break;
			}
			popActivity(activity);
		}
	}

	/**
	 * 结束除cls之外的所有activity,执行结果都会清空Stack
	 * 
	 * @param cls
	 */
	public void finishAllActivityExceptOne(Class<? extends Activity> cls) {
		while (!activityStack.empty()) {
			Activity activity = currentActivity();
			if (activity.getClass().equals(cls)) {
				popActivity(activity);
			} else {
				endActivity(activity);
			}
		}
	}

	/**
	 * 结束�?有activity
	 */
	public void finishAllActivity() {
		while (!activityStack.empty()) {
			Activity activity = currentActivity();
			endActivity(activity);
		}
	}
}