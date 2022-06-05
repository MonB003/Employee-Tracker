# Employee Tracker
> This is a personal project that allows users to add, view, save, and delete employees from the program.

<br>

## Table of Contents
- [Technologies](#technologies)
- [How to run the project](#how-to-run-project)
- [How to use the app](#how-to-use-app)
- [References](#references)

<br>

## Technologies
* Frontend: JavaFX
* Backend: Java


<br>


## <a id="how-to-run-project">How to run the project</a>
### Prerequisites:
- Have a Git and GitHub account
- Have [Java JDK](https://adoptopenjdk.net/archive.html) installed 
  - This project uses jdk-11

### Configuration instructions:

You will need to install:
- [IntelliJ](https://www.jetbrains.com/idea/download/#section=windows) (executable)
  - This project uses the community version, which is free
- [SceneBuilder](https://gluonhq.com/products/scene-builder/)
  - Under the section *Download Scene Builder for Java 8*, download the appropriate 64-bit installer
  - This project uses the *Windows Installer 64-bit* Platform

Cloning the repository:
- Open Command Prompt
- `cd` into the folder you want the repository stored in
- Type:  `git clone https://github.com/MonB2020/Employee-Tracker.git`

Using JavaFX in the project:
- In IntelliJ, go to: File > Settings > Languages & Frameworks > JavaFX
  - Under *Path to SceneBuilder*, copy the file location of the SceneBuilder executable on your device
  - Click *Apply*, then *Close*

### Running the project:
1. In IntelliJ, open the Main.java file
   - Main.java file location: *Your Folder Name* /src/sample/Main.java
2. Click the green triangle in the top right corner (when hovered on, it says: Run 'Main')
3. A small popup window will appear, which is the app


<br>


## <a id="how-to-use-app">How to use the app</a>
### Add an employee:
- Under the *Add Employees* tab, fill out the first name, last name, age, and job position of the employee
- Click the "Next" button after filling in each field
- Once all fields are filled with valid data, click the "Add Employee" button

### View all employees:
- Click on the *Employees* tab next to the *Add Employees* tab
- You can select an employee listed to view they information
  - When a user is selected, you have options to either delete them from the list, or save them to a text file

### Delete an employee:
- In the *Employees* tab, select an employee from the list
- Their data will appear on the right side on the window
- Under their data, click the "Remove" button
- This removes the employee from the list

### Save an employee:
- In the *Employees* tab, select an employee from the list
- Their data will appear on the right side on the window
- Under their data, click the "Save to File" button
- This writes that employee's data to the employees text file 


<br>


## <a id="references">References</a>
### JavaFX
- [Basic JavaFX window layout](https://www.youtube.com/watch?v=VuQFkxyWjr8)
- [File reading and writing](https://www.youtube.com/watch?v=ivRleZ6NWLQ&t=229s)
- [GUI with SceneBuilder](https://www.youtube.com/watch?v=C353UFc3te0&t=156s)
