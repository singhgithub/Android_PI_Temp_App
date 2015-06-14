# Android_PI_Temp_App
App that fetches data from a temp sensor
This is an **Android app** that allows you to check the temp of your room on your phone. I used Raspberry Pi which is connected to
a temprature sensor and a **PHP** script is used to fetch the data from the sensor. On the front end Android simply uses HTTP 
GET request to the PHP script and display the data. Later I learn that I can use Servlets and Pi4j as backend instead of PHP 
inorder to make the project all **Java**. 
