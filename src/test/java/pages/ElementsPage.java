package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ElementsPage extends BasePage {

    public ElementsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//span[text()='Web Tables']")
    public WebElement webTableSubMenu;

    public void clickWebTable() {
        elementsMethods.javaScriptElement(webTableSubMenu);
    }
}