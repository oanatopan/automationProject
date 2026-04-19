package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class WebTablesPage extends BasePage {

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

    public WebTablesPage(WebDriver driver) {
        super(driver);
    }

    public void createProcess() {
        String firstName = "Johny";
        String lastName = "Cash";
        String userEmail = "johnycash12n@gmail.com";
        String age = "31";
        String salary = "5000";
        String department = "Discogs";

        System.out.println("STEP: User clicks on Add button.");
        elementsMethods.clickElement(addElement);

        System.out.println("STEP: User fills in First Name field.");
        elementsMethods.fillElement(firstNameElement, firstName);

        System.out.println("STEP: User fills in Last Name field.");
        elementsMethods.fillElement(lastNameElement, lastName);

        System.out.println("STEP: User fills in Email field.");
        elementsMethods.fillElement(userEmailElement, userEmail);

        System.out.println("STEP: User fills in Age field.");
        elementsMethods.fillElement(ageElement, age);

        System.out.println("STEP: User fills in Salary field.");
        elementsMethods.fillElement(salaryElement, salary);

        System.out.println("STEP: User fills in Department field.");
        elementsMethods.fillElement(departmentElement, department);

        System.out.println("STEP: User clicks Submit button.");
        elementsMethods.clickElement(submitButton);

        System.out.println("STEP: User validates that the new record is displayed in table.");
        Assert.assertTrue(driver.getPageSource().contains(firstName), "First name is not displayed in table.");
        Assert.assertTrue(driver.getPageSource().contains(lastName), "Last name is not displayed in table.");
        Assert.assertTrue(driver.getPageSource().contains(userEmail), "Email is not displayed in table.");
        Assert.assertTrue(driver.getPageSource().contains(age), "Age is not displayed in table.");
        Assert.assertTrue(driver.getPageSource().contains(salary), "Salary is not displayed in table.");
        Assert.assertTrue(driver.getPageSource().contains(department), "Department is not displayed in table.");
    }

    public void editProcess() {
        WebElement editElement = driver.findElement(By.id("edit-record-4"));

        System.out.println("STEP: User clicks Edit button.");
        elementsMethods.clickElement(editElement);

        System.out.println("STEP: User clears and updates First Name field.");
        firstNameElement.clear();
        elementsMethods.fillElement(firstNameElement, "John");

        System.out.println("STEP: User clears and updates Last Name field.");
        lastNameElement.clear();
        elementsMethods.fillElement(lastNameElement, "Smith");

        System.out.println("STEP: User clears and updates Email field.");
        userEmailElement.clear();
        elementsMethods.fillElement(userEmailElement, "johnysmithasd2@conver.com");

        System.out.println("STEP: User clears and updates Age field.");
        ageElement.clear();
        elementsMethods.fillElement(ageElement, "50");

        System.out.println("STEP: User clicks Submit button after edit.");
        elementsMethods.clickElement(submitButton);

        System.out.println("STEP: User validates that edited record is displayed in table.");
        Assert.assertTrue(driver.getPageSource().contains("John"), "Edited first name is not displayed in table.");
        Assert.assertTrue(driver.getPageSource().contains("Smith"), "Edited last name is not displayed in table.");
        Assert.assertTrue(driver.getPageSource().contains("johnysmithasd2@conver.com"), "Edited email is not displayed in table.");
        Assert.assertTrue(driver.getPageSource().contains("50"), "Edited age is not displayed in table.");
    }

    public void deleteProcess() {
        WebElement deleteElement = driver.findElement(By.id("delete-record-4"));

        System.out.println("STEP: User clicks Delete button.");
        elementsMethods.clickElement(deleteElement);

        System.out.println("STEP: User validates that deleted record is no longer displayed in table.");
        Assert.assertFalse(driver.getPageSource().contains("John"), "Deleted first name is still displayed in table.");
        Assert.assertFalse(driver.getPageSource().contains("Smith"), "Deleted last name is still displayed in table.");
        Assert.assertFalse(driver.getPageSource().contains("johnysmithasd2@conver.com"), "Deleted email is still displayed in table.");
    }
}