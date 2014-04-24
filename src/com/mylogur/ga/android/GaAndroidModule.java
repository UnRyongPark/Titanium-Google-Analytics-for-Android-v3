/**
 * This file was auto-generated by the Titanium Module SDK helper for Android
 * Appcelerator Titanium Mobile
 * Copyright (c) 2009-2013 by Appcelerator, Inc. All Rights Reserved.
 * Licensed under the terms of the Apache Public License
 * Please see the LICENSE included with this distribution for details.
 *
 */
package com.mylogur.ga.android;

import java.util.HashMap;

import org.appcelerator.kroll.KrollDict;
import org.appcelerator.kroll.KrollModule;
import org.appcelerator.kroll.annotations.Kroll;
import org.appcelerator.titanium.TiApplication;
import org.appcelerator.titanium.util.TiConvert;
import org.appcelerator.kroll.common.Log;
import org.appcelerator.kroll.common.TiConfig;

import android.app.Activity;

import com.google.analytics.tracking.android.Fields;
import com.google.analytics.tracking.android.GAServiceManager;
import com.google.analytics.tracking.android.GoogleAnalytics;
import com.google.analytics.tracking.android.MapBuilder;
import com.google.analytics.tracking.android.Tracker;

@Kroll.module(name="GaAndroid", id="com.mylogur.ga.android")
public class GaAndroidModule extends KrollModule
{

	// Standard Debugging variables
	private static final String TAG = "GaAndroidModule";
	private static final boolean DBG = TiConfig.LOGD;
	
	private GoogleAnalytics mInstance;
	private boolean async_state;
	private Activity activity;
	private Tracker tracker;
	// You can define constants with @Kroll.constant, for example:
	// @Kroll.constant public static final String EXTERNAL_NAME = value;
	
	public GaAndroidModule()
	{
		super();
		TiApplication appContext = TiApplication.getInstance();
		activity = appContext.getCurrentActivity();
		
		mInstance = GoogleAnalytics.getInstance(activity);
		
	}

	@Kroll.onAppCreate
	public static void onAppCreate(TiApplication app)
	{
		Log.d(TAG, "inside onAppCreate");
		// put module init code that needs to run when the application is created
	}
	
	@Kroll.method
	public void init( String trackingId, boolean dryRun, boolean manualSession, boolean async, int dispatch){
		async_state = async;
		
		if( async_state == false ){
			GAServiceManager.getInstance().setLocalDispatchPeriod(dispatch);
		}
		
		mInstance.setDryRun(dryRun);
		tracker = mInstance.getTracker(trackingId);
		
		if( manualSession == true ){
			tracker.set(Fields.SESSION_CONTROL, "start");
		}
	}
	
	@Kroll.method
	public void endSession(){
		tracker.set(Fields.SESSION_CONTROL, "end");
	}
	
	@Kroll.method
	public void trackEvent(HashMap props){
		KrollDict propsDict = new KrollDict(props);
		String category = TiConvert.toString(propsDict, "category");
		String action = TiConvert.toString(propsDict, "action");
		String label = TiConvert.toString(propsDict, "label");
		long value = TiConvert.toInt(propsDict, "value");
		
		tracker.send(MapBuilder.createEvent(category, action, label, value).build());
		if( async_state == true ){
			GAServiceManager.getInstance().dispatchLocalHits();
		}
	}
	
	@Kroll.method
	public void trackScreen(String screen){
		tracker.set(Fields.SCREEN_NAME, screen);
		tracker.send(MapBuilder.createAppView().build());
		
		if( async_state == true ){
			GAServiceManager.getInstance().dispatchLocalHits();
		}
	}
}
