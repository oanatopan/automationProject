package pages;

import modelObject.PracticeFormsModel;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class PracticeFormsPage extends BasePage {

    @FindBy(xpath = "//h5[text()='Forms']")
    private WebElement formsMenu;

    @FindBy(xpath = "//span[text()='Practice Form']")
    private WebElement practiceFormSubMenu;

    @FindBy(id = "firstName")
    private WebElement firstNameElement;

    @FindBy(id = "lastName")
    private WebElement lastNameElement;

    @FindBy(id = "userEmail")
    private WebElement userEmailElement;

    @FindBy(id = "userNumber")
    private WebElement mobileElement;

    @FindBy(id = "dateOfBirthInput")
    private WebElement dateOfBirthElement;

    @FindBy(className = "react-datepicker__month-select")
    private WebElement monthElement;

    @FindBy(className = "react-datepicker__year-select")
    private WebElement yearElement;

    public PracticeFormsPage(WebDriver driver) {
        super(driver);
    }

    public void clickFormsMenu() {
        elementsMethods.javaScriptElement(formsMenu);
    }

    public void clickPracticeFormSubMenu() {
        elementsMethods.clickElement(practiceFormSubMenu);
    }

    public void fillPracticeForm(PracticeFormsModel testData) {
        elementsMethods.fillElement(firstNameElement, testData.getFirstName());
        elementsMethods.fillElement(lastNameElement, testData.getLastName());
        elementsMethods.fillElement(userEmailElement, testData.getUserEmail());
        elementsMethods.fillElement(mobileElement, testData.getMobileNumber());

        elementsMethods.clickElement(dateOfBirthElement);
        elementsMethods.dropDownElement(monthElement, testData.getMonthValue());
        elementsMethods.dropDownElement(yearElement, testData.getYearValue());

        List<WebElement> daysList = driver.findElements(By.xpath("//div[contains(@class,'react-datepicker__day--0') and not(contains(@class,'outside-month'))]"));
        for (int index = 0; index < daysList.size(); index++) {
            if (daysList.get(index).getText().equals(testData.getDayValue())) {
                elementsMethods.clickElement(daysList.get(index));
                break;
            }
        }
    }
}