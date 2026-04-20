package pages;

import modelObject.WebTableModel;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class WebTablePage extends BasePage {

    @FindBy(id = "addNewRecordButton")
    private WebElement addElement;

    @FindBy(id = "firstName")
    private WebElement firstNameElement;

    @FindBy(id = "lastName")
    private WebElement lastNameElement;

    @FindBy(id = "userEmail")
    private WebElement userEmailElement;

    @FindBy(id = "age")
    private WebElement ageElement;

    @FindBy(id = "salary")
    private WebElement salaryElement;

    @FindBy(id = "department")
    private WebElement departmentElement;

    @FindBy(id = "submit")
    private WebElement submitButton;

    public WebTablePage(WebDriver driver) {
        super(driver);
    }

    public void createProcess(WebTableModel testData) {
        System.out.println("STEP: User clicks on Add button.");
        elementsMethods.clickElement(addElement);

        System.out.println("STEP: User fills in First Name field.");
        elementsMethods.fillElement(firstNameElement, testData.getFirstName());

        System.out.println("STEP: User fills in Last Name field.");
        elementsMethods.fillElement(lastNameElement, testData.getLastName());

        System.out.println("STEP: User fills in Email field.");
        elementsMethods.fillElement(userEmailElement, testData.getUserEmail());

        System.out.println("STEP: User fills in Age field.");
        elementsMethods.fillElement(ageElement, testData.getAge());

        System.out.println("STEP: User fills in Salary field.");
        elementsMethods.fillElement(salaryElement, testData.getSalary());

        System.out.println("STEP: User fills in Department field.");
        elementsMethods.fillElement(departmentElement, testData.getDepartment());

        System.out.println("STEP: User clicks Submit button.");
        elementsMethods.clickElement(submitButton);

        System.out.println("STEP: User validates that the new record is displayed in table.");
        Assert.assertTrue(driver.getPageSource().contains(testData.getFirstName()), "First name is not displayed in table.");
        Assert.assertTrue(driver.getPageSource().contains(testData.getLastName()), "Last name is not displayed in table.");
        Assert.assertTrue(driver.getPageSource().contains(testData.getUserEmail()), "Email is not displayed in table.");
        Assert.assertTrue(driver.getPageSource().contains(testData.getAge()), "Age is not displayed in table.");
        Assert.assertTrue(driver.getPageSource().contains(testData.getSalary()), "Salary is not displayed in table.");
        Assert.assertTrue(driver.getPageSource().contains(testData.getDepartment()), "Department is not displayed in table.");
    }

    public void editProcess(WebTableModel testData) {
        WebElement editElement = driver.findElement(By.id("edit-record-4"));

        System.out.println("STEP: User clicks Edit button.");
        elementsMethods.clickElement(editElement);

        System.out.println("STEP: User clears and updates First Name field.");
        firstNameElement.clear();
        elementsMethods.fillElement(firstNameElement, testData.getEditedFirstName());

        System.out.println("STEP: User clears and updates Last Name field.");
        lastNameElement.clear();
        elementsMethods.fillElement(lastNameElement, testData.getEditedLastName());

        System.out.println("STEP: User clears and updates Email field.");
        userEmailElement.clear();
        elementsMethods.fillElement(userEmailElement, testData.getEditedUserEmail());

        System.out.println("STEP: User clears and updates Age field.");
        ageElement.clear();
        elementsMethods.fillElement(ageElement, testData.getEditedAge());

        System.out.println("STEP: User clicks Submit button after edit.");
        elementsMethods.clickElement(submitButton);

        System.out.println("STEP: User validates that edited record is displayed in table.");
        Assert.assertTrue(driver.getPageSource().contains(testData.getEditedFirstName()), "Edited first name is not displayed in table.");
        Assert.assertTrue(driver.getPageSource().contains(testData.getEditedLastName()), "Edited last name is not displayed in table.");
        Assert.assertTrue(driver.getPageSource().contains(testData.getEditedUserEmail()), "Edited email is not displayed in table.");
        Assert.assertTrue(driver.getPageSource().contains(testData.getEditedAge()), "Edited age is not displayed in table.");
    }

    public void deleteProcess(WebTableModel testData) {
        WebElement deleteElement = driver.findElement(By.id("delete-record-4"));

        System.out.println("STEP: User clicks Delete button.");
        elementsMethods.clickElement(deleteElement);

        System.out.println("STEP: User validates that deleted record is no longer displayed in table.");
        Assert.assertFalse(driver.getPageSource().contains(testData.getEditedFirstName()), "Deleted first name is still displayed in table.");
        Assert.assertFalse(driver.getPageSource().contains(testData.getEditedLastName()), "Deleted last name is still displayed in table.");
        Assert.assertFalse(driver.getPageSource().contains(testData.getEditedUserEmail()), "Deleted email is still displayed in table.");
    }
}