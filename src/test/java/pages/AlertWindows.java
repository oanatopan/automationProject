package pages;

import helpMethods.AlertMethods;
import helpMethods.ElementsMethod;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AlertWindows {

    public WebDriver driver;
    public ElementsMethod elementsMethod;
    public AlertMethods alertMethods;

    public AlertWindows(WebDriver driver) {
        this.driver = driver;
        elementsMethod = new ElementsMethod(this.driver);
        alertMethods = new AlertMethods(this.driver);
        PageFactory.initElements(this.driver, this);
    }

    @FindBy(xpath = "//span[text()='Alerts']")
    public WebElement alert;

    @FindBy(id = "alertButton")
    public WebElement firstAlertElement;

    @FindBy(id = "timerAlertButton")
    public WebElement secondAlert;

    @FindBy(id = "confirmButton")
    public WebElement thirdAlertElement;

    @FindBy(id = "confirmResult")
    public WebElement textThirdAlert;

    @FindBy(id = "promtButton")
    public WebElement fourthAlertElement;

    public void clickAlert() {
        elementsMethod.javaScriptElement(alert);
    }

    public void dealAlertProcess() {
        elementsMethod.clickElement(firstAlertElement);
        alertMethods.acceptAlert();

        elementsMethod.clickElement(secondAlert);
        alertMethods.acceptAlert();

        elementsMethod.clickElement(thirdAlertElement);
        alertMethods.acceptAlert(true);

        String actualText = textThirdAlert.getText();
        alertMethods.verifyConfirmAlert(actualText, true);

        elementsMethod.clickElement(fourthAlertElement);
        alertMethods.fillAlert("Buna ziua");
    }
}