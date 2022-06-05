/* Scholarship App Controller class
By: Monica Bacatan
 */

package sample;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Controller {

    // VARIABLES
    // Text fields get user's input for each field
    public TextField textFirstName;
    public TextField textLastName;
    public TextField textAge;
    public TextField textJobPosition;
    // Buttons check user's input for each field and enable the next button
    public Button btnAddFirstName;
    public Button btnAddLastName;
    public Button btnAddAge;
    public Button btnAddJob;
    // Buttons to add, remove, and save an employee
    public Button btnAddEmployee;
    public Button btnRemoveEmployee;
    public Button btnSaveEmployee;
    // List View stores and displays a list of each employee object
    public ListView <Employee> employeeList = new ListView<>();
    // Labels stores specific info about each employee
    public Label lblFirstName;
    public Label lblLastName;
    public Label lblAge;
    public Label lblJobPosition;
    public Label lblEmployeeNumber;
    public Label lblEmployeeName;
    // Labels to display each field
    public Label firstNameLabel;
    public Label lastNameLabel;
    public Label ageLabel;
    public Label jobPositionLabel;
    public Label employeeNumLabel;
    // Label to warn user of invalid input when necessary
    public Label lblWarning;
    // Labels to tell user how to select an employee from List View
    public Label lblInfoStatement;
    public Label lblInfoStatement2;
    // Second tab that saves and displays each employee that the user add
    public Tab tabEmployees;
    // Menu item to save an employee, has the same function as the save employee button
    public MenuItem menuSave;
    // Button to close window
    public Button btnCloseWindow;

    // Variables to store user's input
    String userFirstName;
    String userLastName;
    int userAge;
    String userJobPosition;



    // METHODS

    // Method to add an employee
    public void addEmployee(ActionEvent actionEvent) {
        // Store user input from each text field
        userFirstName = textFirstName.getText();
        userLastName = textLastName.getText();
        userAge = Integer.parseInt(textAge.getText());
        userJobPosition = textJobPosition.getText();

        // Add employee to the employee list
        Employee employee = new Employee(userFirstName, userLastName, userAge, userJobPosition, 1);
        employeeList.getItems().add(employee);

        // Reset text fields
        textFirstName.clear();
        textLastName.clear();
        textAge.clear();
        textJobPosition.clear();

        // Clear warning label
        lblWarning.setText("");

        // Enable first name text field so user can restart and input info again
        textFirstName.setDisable(false);

        // Disable text fields
        textLastName.setDisable(true);
        textAge.setDisable(true);
        textJobPosition.setDisable(true);

        // Disable add employee button until all text fields are filled again
        btnAddEmployee.setDisable(true);

        // Enable tab for employees
        tabEmployees.setDisable(false);

        // Enable employeeList list view
        employeeList.setDisable(false);
    }


    // Method to display an employee's information in the employees tab
    public void displayInfo(MouseEvent mouseEvent) {
        // Get the employee that the user selects from the List View
        Employee employee;
        employee = employeeList.getSelectionModel().getSelectedItem();

        // Set labels for each field
        firstNameLabel.setText("First Name:");
        lastNameLabel.setText("Last Name:");
        ageLabel.setText("Age:");
        jobPositionLabel.setText("Job Position:");
        employeeNumLabel.setText("Employee Number:");

        // Set the other labels as the user's input
        lblFirstName.setText(employee.firstName);
        lblLastName.setText(employee.lastName);
        lblAge.setText(String.valueOf(employee.age));
        lblJobPosition.setText(employee.jobPosition);
        lblEmployeeNumber.setText(String.valueOf(employee.employeeNumber));
        lblEmployeeName.setText(employee.firstName + " " + employee.lastName);

        // Enable the remove and save employee buttons
        btnRemoveEmployee.setDisable(false);
        btnSaveEmployee.setDisable(false);

        // Display buttons for removing and saving an employee
        btnRemoveEmployee.setVisible(true);
        btnSaveEmployee.setVisible(true);

        // Enable menu item for saving employee to text file
        menuSave.setDisable(false);

        // Clear label telling user to select an employee
        lblInfoStatement.setText("");
        lblInfoStatement2.setText("");
    }


    // Method to remove an employee
    public void removeEmployee(ActionEvent actionEvent) {
        // Select an employee
        Employee employee;
        employee = employeeList.getSelectionModel().getSelectedItem();
        employeeList.getSelectionModel().select(employee);

        // Remove employee
        employeeList.getItems().remove(employee);

        // Disable remove and save employee buttons
        btnRemoveEmployee.setDisable(true);
        btnSaveEmployee.setDisable(true);

        // Clear labels for each category
        firstNameLabel.setText("");
        lastNameLabel.setText("");
        ageLabel.setText("");
        jobPositionLabel.setText("");
        employeeNumLabel.setText("");

        // Clear all labels with employee info
        lblFirstName.setText("");
        lblLastName.setText("");
        lblAge.setText("");
        lblJobPosition.setText("");
        lblEmployeeNumber.setText("");
        lblEmployeeName.setText("");

        // Hide buttons for removing and saving an employee
        btnRemoveEmployee.setVisible(false);
        btnSaveEmployee.setVisible(false);

        //Disable menu item for saving
        menuSave.setDisable(true);

        // Labels tell user how to view an employee's information
        lblInfoStatement.setText("Select an employee from the Employee List");
        lblInfoStatement2.setText("to see their information.");

        // If statement disables the employeeList list view when it's empty
        if (employeeList.getItems().isEmpty()) {
            employeeList.setDisable(true);
        }
    }


    // Method to save an employee to employees text file
    public void saveEmployee(ActionEvent actionEvent) throws IOException {
        // Save labels in variables that will be written into the employees text file
        String saveFirstName = lblFirstName.getText();
        String saveLastName = lblLastName.getText();
        int saveAge = Integer.parseInt(lblAge.getText());
        String saveJobPosition = lblJobPosition.getText();

        // Create an employee object with users input as the parameters
        Employee employee = new Employee(saveFirstName, saveLastName, saveAge, saveJobPosition, 0);

        // Write employee object to text file using writeToFile method
        employee.writeToFile();

        // Call method to write the employee number to text file
        getEmployeeNumber();

        // Disable save button and menu item
        btnSaveEmployee.setDisable(true);
        menuSave.setDisable(true);

    }


    // Method to write each employee's number to the employees text file
    public void getEmployeeNumber() throws IOException {
        FileWriter fileWriter = new FileWriter("employees.txt", true);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        bufferedWriter.write("Employee Number:  " + lblEmployeeNumber.getText() + "\r");
        bufferedWriter.write("\r");
        bufferedWriter.close();
    }


    // Method to clear text fields and restart the process to fill in the information
    public void reset(ActionEvent actionEvent) {
        // Reset text fields
        textFirstName.clear();
        textLastName.clear();
        textAge.clear();
        textJobPosition.clear();

        // Clear warning label
        lblWarning.setText("");

        // Enable first name text field so user can restart and input info again
        textFirstName.setDisable(false);

        // Disable text fields
        textLastName.setDisable(true);
        textAge.setDisable(true);
        textJobPosition.setDisable(true);

        // Disable add employee button until all text fields are filled again
        btnAddEmployee.setDisable(true);
    }


    // Method to enable first name button
    public void addFirstName(KeyEvent keyEvent) {
        // If statement check if the text field is empty
        if (textFirstName.getText() != null) {
            btnAddFirstName.setDisable(false);
        }
    }


    // Method to enable last name text field and check if first name text field is blank/empty
    public void enableLastName(ActionEvent actionEvent) {
        // If statement to check if text field for first name is blank
        if (textFirstName.getText().equals("")) {
            // Use label to tell user to enter a name (a string)
            lblWarning.setText("Please enter a name.");

            // Clear text field for first name
            textFirstName.clear();

            // Keep the next text field (last name) disabled until user enters a proper name
            textLastName.setDisable(true);

            // Enable text field and button for first name until user inputs a proper name
            textFirstName.setDisable(false);
            btnAddFirstName.setDisable(false);
        }
        // Else statement to enable the next text field so user can continue filling out info
        else {
            // Enable the next text field (last name)
            textLastName.setDisable(false);

            // Disable text field and button for first name
            textFirstName.setDisable(true);
            btnAddFirstName.setDisable(true);

            // Clear warning label
            lblWarning.setText("");
        }

        // String variable stores users input
        String firstNameInput = textFirstName.getText();

        // For loop checks each character in the string variable
        for (char c : firstNameInput.toCharArray()) {
            // If statement checks if each character is a number
            if (Character.isDigit(c)) {
                // Label tells user that first name can only have letters
                lblWarning.setText("First name can only contain letters.");

                // Clear text field for first name
                textFirstName.clear();

                // Keep the next text field (last name) disabled until user enters a proper name
                textLastName.setDisable(true);

                // Enable text field and button for first name until user inputs a proper name
                textFirstName.setDisable(false);
                btnAddFirstName.setDisable(false);
            }
        }
    }


    // Method to enable last name button
    public void addLastName(KeyEvent keyEvent) {
        // If statement check if the text field is empty
        if (textLastName.getText() != null) {
            btnAddLastName.setDisable(false);
        }
    }


    // Method to enable age text field and check if last name text field is blank/empty
    public void enableAge(ActionEvent actionEvent) {
        // If statement to check if text field for last name is empty
        if (textLastName.getText().equals("")) {
            // Use label to tell user to enter a name (a string)
            lblWarning.setText("Please enter a name.");

            // Clear text field for last name
            textLastName.clear();

            // Keep the next text field (age) disabled until user enters a proper name
            textAge.setDisable(true);

            // Enable text field and button for last name until user inputs a proper name
            textLastName.setDisable(false);
            btnAddLastName.setDisable(false);
        }
        else {
            // Enable the next text field (age)
            textAge.setDisable(false);

            // Disable text field and button for last name
            textLastName.setDisable(true);
            btnAddLastName.setDisable(true);

            // Clear warning label
            lblWarning.setText("");
        }

        // String variable stores users input
        String lastNameInput = textLastName.getText();

        // For loop checks each character in the string variable
        for (char c : lastNameInput.toCharArray()) {
            // If statement checks if each character is a number
            if (Character.isDigit(c)) {
                // Label tells user that last name can only have letters
                lblWarning.setText("Last name can only contain letters.");

                // Clear text field for last name
                textLastName.clear();

                // Keep the next text field (age) disabled until user enters a proper name
                textAge.setDisable(true);

                // Enable text field and button for last name until user inputs a proper name
                textLastName.setDisable(false);
                btnAddLastName.setDisable(false);
            }
        }

    }


    // Method to enable age button
    public void addAge(KeyEvent keyEvent) {
        // If statement check if the text field is empty
        if (textAge.getText() != null) {
            btnAddAge.setDisable(false);
        }
    }


    // Method to enable job position text field and check if users age input is a number
    public void enableJobPosition(ActionEvent actionEvent) {
        textJobPosition.setDisable(false);
        textAge.setDisable(true);
        btnAddAge.setDisable(true);
        lblWarning.setText("");

        // Try statement to check if user inputted a number
        try {
            int userAgeInput = Integer.parseInt(textAge.getText());
            checkAgeInput();
        }
        // Catch statement for if user's input is not a number
        catch (Exception e) {
            // Use label to tell user to enter a number
            lblWarning.setText("Please enter a number.");

            // Clear text field for age
            textAge.clear();

            // Keep age text field enabled until user inputs a number
            textAge.setDisable(false);

            // Disable the next text field (job position)
            textJobPosition.setDisable(true);

            // Enable button to add age so user can enter another input
            btnAddAge.setDisable(false);
        }
    }

    public void checkAgeInput() {
        // If statement to check if user's age input is less than 16
        if (Integer.parseInt(textAge.getText()) < 16) {
            // Label tells user that the age of the employee must be at least 16
            lblWarning.setText("Employee must be at least 16 years old.");

            // Clear text field for age
            textAge.clear();

            // Keep age text field enabled until user inputs a valid number
            textAge.setDisable(false);

            // Keep the job position text field disabled
            textJobPosition.setDisable(true);

            // Enable button to add age so user can enter another input
            btnAddAge.setDisable(false);
        }
    }


    // Method to enable job position button
    public void addJob(KeyEvent keyEvent) {
        // If statement check if the text field is empty
        if (textJobPosition.getText() != null) {
            btnAddJob.setDisable(false);
        }
    }


    // Method to check the job position text field
    public void enableAddEmployee(ActionEvent actionEvent) {
        // If statement to check if job position text field is empty
        if (textJobPosition.getText().equals("")) {
            // Label tells user to enter a job
            lblWarning.setText("Please enter a job position.");

            // Clear job position text field
            textJobPosition.clear();

            // Enable text field and button for job position until user inputs a proper job
            textJobPosition.setDisable(false);
            btnAddJob.setDisable(false);

            // Keep add employee button disabled
            btnAddEmployee.setDisable(true);
        }
        else {
            // Disable job position text field and button
            textJobPosition.setDisable(true);
            btnAddJob.setDisable(true);

            // Enable add employee button
           btnAddEmployee.setDisable(false);

           // Clear warning label
            lblWarning.setText("");
        }

        // String variable stores users input
        String jobPositionInput = textJobPosition.getText();

        // For loop checks each character in the string variable
        for (char c : jobPositionInput.toCharArray()) {
            // If statement checks if each character is a number
            if (Character.isDigit(c)) {
                // Label tells user that last name can only have letters
                lblWarning.setText("Job position can only contain letters.");

                // Clear text field for last name
                textJobPosition.clear();

                // Enable text field and button for job position until user inputs a proper job
                textJobPosition.setDisable(false);
                btnAddJob.setDisable(false);

                // Keep add employee button disabled
                btnAddEmployee.setDisable(true);
            }
        }
    }


    // Method to open a second window that gives a description about the Employee Tracker app
    public void aboutEmployeeTracker() {
        // Create a stage for the new window
        Stage stage2 = new Stage();
        stage2.setTitle("About Employee Tracker");

        // Create vertical box for the second window that will pop up
        VBox box = new VBox();

        // Center box on the screen
        box.setAlignment(Pos.CENTER);

        // Label gives a description about Employee Tracker app
        Label lblAboutApp = new Label("The Employee Tracker is used for businesses to keep track of their employees." + "\r"
                + "Fill in each section with an employee's information and add each employee." + "\r"
                + "In the Employees tab, you can see a list of all the employees you added." + "\r"
                + "You can select an employee, which gives you options to either remove" + "\r"
                + "the employee or save their information to a text file."+ "\r" + "\r");
        // Format for description label
        lblAboutApp.setAlignment(Pos.CENTER);
        lblAboutApp.setFont(Font.font(java.awt.Font.SANS_SERIF));

        // Ok button closes the second window when clicked
        Button btnOk = new Button();
        // Format for Ok button
        btnOk.setText("OK");
        btnOk.setAlignment(Pos.BOTTOM_CENTER);
        btnOk.setFont(Font.font(java.awt.Font.SANS_SERIF));

        btnOk.setOnAction(new EventHandler<ActionEvent>() {
            // Method to close second window when Ok button is clicked
            @Override
            public void handle(ActionEvent event) {
                // Close second window
                stage2.close();
            }
        });

        // Add the app description label and ok button to the second window
        box.getChildren().add(lblAboutApp);
        box.getChildren().add(btnOk);

        // Set up layout and size for the second window
        Scene scene2 = new Scene(box, 730, 450);
        stage2.setScene(scene2);
        stage2.show();
    }


    // Method to close the window when quit menu button is clicked
    public void closeWindow(ActionEvent actionEvent) {
        Stage stage = (Stage) btnCloseWindow.getScene().getWindow();
        stage.close();
    }

}
