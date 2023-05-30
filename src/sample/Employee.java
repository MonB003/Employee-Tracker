/* Scholarship App Employee class
By: Monica 
 */

package sample;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Employee {

    // Fields for each employee object
    String firstName;
    String lastName;
    int age;
    String jobPosition;
    int employeeNumber;
    static int number = 202101; // Unique number for each employee


    // Constructor for employee object with parameters
    Employee(String firstName, String lastName, int age, String jobPosition, int employeeNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.jobPosition = jobPosition;
        this.employeeNumber = number;
        number++;
    }


    // Method to format employee object
    public String toString() {
        return firstName + " " + lastName;
    }


    // Method to write an employee object to the employees text file
    public void writeToFile() throws IOException {
        // Create a FileWriter and BufferedWriter to write into the text file
        FileWriter fileWriter = new FileWriter("employees.txt", true);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

        bufferedWriter.write("EMPLOYEE:" + "\r");
        bufferedWriter.write("Name:  " + firstName + " " + lastName + "\r");
        bufferedWriter.write("Age:  " + age + "\r");
        bufferedWriter.write("Job Position:  " + jobPosition + "\r");
        bufferedWriter.close();
    }

}
