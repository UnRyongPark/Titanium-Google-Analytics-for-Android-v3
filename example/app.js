// This is a test harness for your module
// You should do something interesting in this harness 
// to test out the module and to provide instructions 
// to users on how to use it by example.

if (Ti.Platform.name == "android") {
	// TODO: write your module tests here
	var ga_android = require('com.mylogur.ga.android');
	Ti.API.info("module is => " + ga_android);
	
	//init( String trackingId, boolean dryRun, boolean manualSession, boolean async, int dispatchTime)
	ga_android.init('UA-XXXXXX-X', true, false, true, 0);
	
	/*
	 * dryRun = true - information not send to server.
	 * manualSession = true - you can controll Session start, And end
	 * 					if you use this option, you need endSession()
	 *                  https://developers.google.com/analytics/devguides/collection/android/v3/sessions
	 * async = true - if this option is enabled, it sends the data to the server for each request.
	 * dispatch = int - It is used when the async option is turned off.
	 * 					it is sends the data to the server, every x seconds.
	 */
	
	ga_android.trackScreen(name);
	
	ga_android.trackEvent({
	    category: "my event",
	    action: "clicked",
	    label: "how many clicks?",
	    value: 1
	});
	
	//if you used ManualSession
	//ga_android.endSession();
}

