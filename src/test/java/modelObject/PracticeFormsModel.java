package modelObject;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class PracticeFormsModel {

    private String firstName;
    private String lastName;
    private String userEmail;
    private String mobileNumber;
    private String monthValue;
    private String yearValue;
    private String dayValue;

    public PracticeFormsModel(String filePath) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            PracticeFormsModel data = objectMapper.readValue(new File(filePath), PracticeFormsModel.class);
            this.firstName = data.firstName;
            this.lastName = data.lastName;
            this.userEmail = data.userEmail;
            this.mobileNumber = data.mobileNumber;
            this.monthValue = data.monthValue;
            this.yearValue = data.yearValue;
            this.dayValue = data.dayValue;
        } catch (IOException e) {
            throw new RuntimeException("Failed to read practice forms data from JSON file.", e);
        }
    }

    public PracticeFormsModel() {
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

    public String getMobileNumber() {
        return mobileNumber;
    }

    public String getMonthValue() {
        return monthValue;
    }

    public String getYearValue() {
        return yearValue;
    }

    public String getDayValue() {
        return dayValue;
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

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public void setMonthValue(String monthValue) {
        this.monthValue = monthValue;
    }

    public void setYearValue(String yearValue) {
        this.yearValue = yearValue;
    }

    public void setDayValue(String dayValue) {
        this.dayValue = dayValue;
    }
}