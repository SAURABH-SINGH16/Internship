                                                                             TasK-1:
Calculator in Java

Project Description
This is a simple **Calculator application** built in **Java**.  
It performs basic arithmetic operations like addition, subtraction, multiplication, and division.  
The project demonstrates the use of **Java Swing (GUI)** and **Object-Oriented Programming** concepts.

Features
- Addition, Subtraction, Multiplication, Division
- User-friendly GUI (Graphical User Interface) using Swing
- Input validation (prevents invalid operations like division by zero)
- Lightweight and easy to run

Technologies Used
- **Java**
- **Swing / AWT** for GUI

How to Run
1. Open terminal in the project folder.
2. Compile the Java file:
   CMD(TERMINAL)
   javac Calculator.java
------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
                                                                                    Task-2: 
Library Management System
- **Description**: A Java-based Library Management System with a GUI to manage books, authors, and availability.
- **File**: `LibraryManagementSystemGUI.java`
- **Technologies Used**: Java (Swing/AWT), OOP
- **Status**: Completed

How to Run
1. Open terminal inside the project folder.
2. Compile the code:
   CMD(Terminal) 
   javac LibraryManagementSystemGUI.java

------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
                                                                                       Task-3:
Weather App (CLI-Based in Java)

This is a **Command-Line Interface (CLI)** based Weather Application built in **Java**.  
It fetches real-time weather data using the **OpenWeatherMap API** and displays:  
-----------------------------------------------------------------------
Temperature & Feels Like  
  Humidity  
  Weather Condition  
  Wind Speed  
  Pressure  
  Country Code  
  Coordinates (Latitude & Longitude)  
------------------------------------------------------------------------
JAR Dependencies
------------------------------------------------------------------------    
This project uses the **org.json** library to parse API responses.  

### Adding the JAR
1. Download `json-20210307.jar` (or latest) from:  
   [https://repo1.maven.org/maven2/org/json/json/](https://repo1.maven.org/maven2/org/json/json/)  

2. Place the JAR file inside a `lib/` folder in your project directory.  

3. When compiling & running, include the JAR in your classpath:  
------------------------------------------------------------------------
   **Compile Like this 
   1. javac -cp .;lib/json-20210307.jar WeatherAppCLI.java
   2. java -cp .;lib/json-20210307.jar WeatherAppCLI

#######################################################################
--------------------------OUTPUT LOOKS LIKE THIS-----------------------
=== Weather Report ===
City: Mumbai
Temperature: 30.5 °C
Feels Like: 33.2 °C
Humidity: 70%
Condition: clear sky
Wind Speed: 2.5 m/s
Pressure: 1012 hPa
Country: IN
Coordinates: [lat: 19.07, lon: 72.87]
------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
