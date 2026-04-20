package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AlertWindows extends BasePage {

    @FindBy(xpath = "//span[text()='Alerts']")
    private WebElement alertSubMenu;

    @FindBy(id = "alertButton")
    private WebElement firstAlertElement;

    @FindBy(id = "timerAlertButton")
    private WebElement secondAlertElement;

    @FindBy(id = "confirmButton")
    private WebElement thirdAlertElement;

    @FindBy(id = "confirmResult")
    private WebElement confirmResultText;

    @FindBy(id = "promtButton")
    private WebElement fourthAlertElement;

    public AlertWindows(WebDriver driver) {
        super(driver);
    }

    public void clickAlertSubMenu() {
        elementsMethods.javaScriptElement(alertSubMenu);
        loggerUtility.infoLog("The user clicks on Alert submenu.");
    }

    public void dealAlertProcess() {
        elementsMethods.javaScriptElement(firstAlertElement);
        loggerUtility.infoLog("The user clicks on First Alert Element.");
        alertsMethods.acceptAlert();
        loggerUtility.infoLog("The user accepts the first alert.");

        elementsMethods.clickElement(secondAlertElement);
        loggerUtility.infoLog("The user clicks on Second Alert Element.");
        alertsMethods.acceptAlert();
        loggerUtility.infoLog("The user accepts the second alert.");

        elementsMethods.clickElement(thirdAlertElement);
        loggerUtility.infoLog("The user clicks on Third Alert Element.");

        boolean chooseAccept = true;
        alertsMethods.acceptAlert(chooseAccept);
        loggerUtility.infoLog("The user accepts the confirmation alert.");

        String actualText = confirmResultText.getText();
        alertsMethods.verifyConfirmAlert(actualText, true);
        loggerUtility.infoLog("The user verifies the confirmation result.");

        elementsMethods.clickElement(fourthAlertElement);
        loggerUtility.infoLog("The user clicks on Fourth Alert Element.");

        alertsMethods.fillAlert("Buna");
        loggerUtility.infoLog("The user fills the prompt alert.");
    }
}