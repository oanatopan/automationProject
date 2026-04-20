package modelObject;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class WebTableModel {

    private String firstName;
    private String lastName;
    private String userEmail;
    private String age;
    private String salary;
    private String department;

    private String editedFirstName;
    private String editedLastName;
    private String editedUserEmail;
    private String editedAge;

    public WebTableModel(String filePath) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            WebTableModel data = objectMapper.readValue(new File(filePath), WebTableModel.class);
            this.firstName = data.firstName;
            this.lastName = data.lastName;
            this.userEmail = data.userEmail;
            this.age = data.age;
            this.salary = data.salary;
            this.department = data.department;
            this.editedFirstName = data.editedFirstName;
            this.editedLastName = data.editedLastName;
            this.editedUserEmail = data.editedUserEmail;
            this.editedAge = data.editedAge;
        } catch (IOException e) {
            throw new RuntimeException("Failed to read web tables data from JSON file.", e);
        }
    }

    public WebTableModel() {
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public String getAge() {
        return age;
    }

    public String getSalary() {
        return salary;
    }

    public String getDepartment() {
        return department;
    }

    public String getEditedFirstName() {
        return editedFirstName;
    }

    public String getEditedLastName() {
        return editedLastName;
    }

    public String getEditedUserEmail() {
        return editedUserEmail;
    }

    public String getEditedAge() {
        return editedAge;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public void setEditedFirstName(String editedFirstName) {
        this.editedFirstName = editedFirstName;
    }

    public void setEditedLastName(String editedLastName) {
        this.editedLastName = editedLastName;
    }

    public void setEditedUserEmail(String editedUserEmail) {
        this.editedUserEmail = editedUserEmail;
    }

    public void setEditedAge(String editedAge) {
        this.editedAge = editedAge;
    }
}