# Open Weather API Demo application.

Features:
..* Today's weather data
..* Forcast for next 5 days
	
It will display the all the different temperatures for the day with the graphical images provided bu https://openweathermap.org/

## How to run / build / test project

To run the source code, please follow these steps:
A. Import the project:
..* Start Android Studio.
..* From the Welcome screen, click Import project (Eclipse ADT, Gradle, etc.). (if there is already an open project then from the Android Studio menu click File > New > Import Project.) 
..* Select the Eclipse ADT project folder with the AndroidManifest.xml file and click Ok.
..* Select the destination folder and click Next.
..* Select the import options and click Finish.

B. Set up your device as follows:
..* Connect your device to your development machine with a USB cable. On Windows, please install (if not installed) the appropriate USB driver for your device.
..* Enable USB debugging on your device by going to Settings > Developer options.
Note: On Android 4.2 and newer, Developer options is hidden by default. To make it available, go to Settings > About phone and tap Build number seven times. Return to the previous screen to find Developer options.
		
C. Run the app from Android Studio as follows:
..* In Android Studio, click the app module in the Project window and then select Run > Run.
..* In the Select Deployment Target window, select your device, and click OK.
	
---
	
## What could be done with more time
	
..* Better User interface with material design and interactive animations could have been applied.
..* Daily weather API and dynamic data for the day could have been added as a feature of the application.
..* Currently location is Hard coded in the application as Delhi. It could have been made dynamic.
..* User interaction for detailed forecast could also have been done.
	
---
	
## Libraries used in the demo:

..* [Retrofit](http://square.github.io/retrofit/) for network API access. 
..* [Glide](https://github.com/bumptech/glide) for Image loading. 