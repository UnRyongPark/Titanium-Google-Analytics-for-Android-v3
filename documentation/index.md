# ga_android Module

## Description

Connects to Google Analytics for app event tracking.

## Set up Google Analytics

First step: you have to create a new app property in your Google Analytics-account.

For more information see: http://support.google.com/analytics/bin/answer.py?hl=en&answer=2587086&topic=2587085&ctx=topic

## Accessing the ga_android Module

To access this module from JavaScript, you would do the following:

	var ga_android = require("com.mylogur.ga.android");

The ga_android variable is a reference to the Module object.	

## Reference

### init( String trackingId, boolean dryRun, boolean manualSession, boolean async, int dispatchTime)
```javascript
ga_android.init('UA-XXXXXX-X', true, false, true, 0);
```
	dryRun			=	true 
		-	information not send to server.
	manualSession	=	true 
		-	you can controll Session start, And end
			if you use this option, you need endSession()
			https://developers.google.com/analytics/devguides/collection/android/v3/sessions
 	async			=	true
 		-	if this option is enabled, it sends the data to the server for each request.
	dispatch		=	int
		-	It is used when the async option is turned off.
			it is sends the data to the server, every x seconds.


### trackScreen(screenName);
```javascript
ga_android.trackScreen(screenName);
```

### trackEvent(params)
```javascript
ga_android.trackEvent({
    category: "my event",
    action: "clicked",
    label: "how many clicks?",
    value: 1
});
```

Tracks an event taking the following parameters:

* category : String
* action : String
* label : String
* value : Integer

## Usage

```javascript
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
```

## Author

UnRyong Park - theblack1025@gmail.com

## License
The MIT License (MIT)

Copyright (c) 2014. UnRyongPark(theblack1025)

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in
all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
THE SOFTWARE.