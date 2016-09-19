# daniels_p2
Program 2

Got some help with maps here
http://www.joellipman.com/articles/google/android/application-development/basic-android-app-using-google-maps-and-current-location.html
http://stackoverflow.com/questions/27621016/google-maps-zoom-in-and-zoom-out-android


Got some help with capturing pictures here
https://github.com/JimSeker/AudioVideo/tree/master/PicCapture3/app/src/main/java/edu/cs4730/piccapture3

Got help with marker on click listeners here
http://stackoverflow.com/questions/16635530/android-google-map-clicked-marker-opens-new-activity-or-bigger-window

Got help getting the current time here
http://stackoverflow.com/questions/833768/java-code-for-getting-current-time


//Got help with image intents here
http://stackoverflow.com/questions/23577827/how-to-pass-images-through-intent

# Grading ~~25~~40/50
 - I can't get the app to start up
<pre>03-09 16:56:50.108 8135-8135/edu.uwy.pdaniel3.program2 E/AndroidRuntime: FATAL EXCEPTION: main
   Process: edu.uwy.pdaniel3.program2, PID: 8135
   java.lang.NullPointerException: Attempt to invoke virtual method 'boolean java.util.ArrayList.add(java.lang.Object)' on a null object reference
       at edu.uwy.pdaniel3.program2.MapsActivity.onMapReady(MapsActivity.java:97)
       at com.google.android.gms.maps.SupportMapFragment$zza$1.zza(Unknown Source)
       at com.google.android.gms.maps.internal.zzo$zza.onTransact(Unknown Source)
       at android.os.Binder.transact(Binder.java:380)
       at com.google.android.gms.maps.internal.be.a(SourceFile:82)
       at com.google.maps.api.android.lib6.e.fb.run(Unknown Source)
       at android.os.Handler.handleCallback(Handler.java:739)
       at android.os.Handler.dispatchMessage(Handler.java:95)
       at android.os.Looper.loop(Looper.java:135)
       at android.app.ActivityThread.main(ActivityThread.java:5254)
       at java.lang.reflect.Method.invoke(Native Method)
       at java.lang.reflect.Method.invoke(Method.java:372)
       at com.android.internal.os.ZygoteInit$MethodAndArgsCaller.run(ZygoteInit.java:903)
       at com.android.internal.os.ZygoteInit.main(ZygoteInit.java:698)</pre>
Should a mostly working version
