# Open Weather API Demo application.

..* Features:

1. Today's weather data
2. Forcast for next 5 days
	
It will display the all the different temperatures for the day with the graphical images provided bu https://openweathermap.org/

## How to run / build / test project

### To run the source code, please follow these steps:

..* Import the project:

1. Start Android Studio.

2. From the Welcome screen, click Import project (Eclipse ADT, Gradle, etc.). (if there is already an open project then from the Android Studio menu click File > New > Import Project.) 

3. Select the Eclipse ADT project folder with the AndroidManifest.xml file and click Ok.

4. Select the destination folder and click Next.

5. Select the import options and click Finish.


..*. Set up your device as follows:

1. Connect your device to your development machine with a USB cable. On Windows, please install (if not installed) the appropriate USB driver for your device.

2. Enable USB debugging on your device by going to Settings > Developer options.

Note: On Android 4.2 and newer, Developer options is hidden by default. To make it available, go to Settings > About phone and tap Build number seven times. Return to the previous screen to find Developer options.
		
..* Run the app from Android Studio as follows:

1. In Android Studio, click the app module in the Project window and then select Run > Run.

2. In the Select Deployment Target window, select your device, and click OK.
	
---
	
## What could be done with more time
	
1. Better User interface with material design and interactive animations could have been applied.

2. Daily weather API and dynamic data for the day could have been added as a feature of the application.

3. Currently location is Hard coded in the application as Delhi. It could have been made dynamic.

4. User interaction for detailed forecast could also have been done.
	
---
	
## Libraries used in the demo:

1. [Retrofit](http://square.github.io/retrofit/) for network API access. 

2. [Glide](https://github.com/bumptech/glide) for Image loading. 