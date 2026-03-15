package pages;

import helpMethods.ElementsMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;

public class WebTablesPage {

    public WebDriver driver;
    public ElementsMethod elementsMethod;

    public WebTablesPage(WebDriver driver) {
        this.driver = driver;
        this.elementsMethod = new ElementsMethod(this.driver);
        PageFactory.initElements(this.driver, this);
    }

    @FindBy(id = "addNewRecordButton")
    public WebElement addElement;

    @FindBy(id = "firstName")
    public WebElement firstNameElement;

    @FindBy(id = "lastName")
    public WebElement lastNameElement;

    @FindBy(id = "userEmail")
    public WebElement userEmailElement;

    @FindBy(id = "age")
    public WebElement ageElement;

    @FindBy(id = "salary")
    public WebElement salaryElement;

    @FindBy(id = "department")
    public WebElement departmentElement;

    @FindBy(id = "submit")
    public WebElement submitButton;

    @FindBy(id = "edit-record-4")
    public WebElement editRecordFourElement;

    @FindBy(id = "delete-record-4")
    public WebElement deleteRecordFourElement;

    @FindBy(xpath = "//div[@class='rt-tbody']/div/div[@class='rt-tr -odd' or @class='rt-tr -even']")
    public List<WebElement> tableRows;

    public String firstNameValue = "Oana";
    public String lastNameValue = "Topan";
    public String emailValue = "oana@test.com";
    public String ageValue = "30";
    public String salaryValue = "5000";
    public String departmentValue = "IT";
    public String editedFirstNameValue = "OanaEdited";

    public int getActiveRowsCount() {
        List<WebElement> editButtons = driver.findElements(By.xpath("//span[@title='Edit']"));
        return editButtons.size();
    }

    public void createProcess() {
        int initialSize = getActiveRowsCount();
        System.out.println("Dimensiunea initiala a tabelului este " + initialSize);

        elementsMethod.clickElement(addElement);

        elementsMethod.fillElement(firstNameElement, firstNameValue);
        elementsMethod.fillElement(lastNameElement, lastNameValue);
        elementsMethod.fillElement(userEmailElement, emailValue);
        elementsMethod.fillElement(ageElement, ageValue);
        elementsMethod.fillElement(salaryElement, salaryValue);
        elementsMethod.fillElement(departmentElement, departmentValue);

        elementsMethod.clickElement(submitButton);

        int sizeAfterAdd = getActiveRowsCount();
        System.out.println("Dimensiunea tabelului dupa adaugare este " + sizeAfterAdd);

        Assert.assertEquals(sizeAfterAdd, initialSize + 1,
                "Marimea tabelului dupa adaugare nu a crescut cu 1");

        boolean rowFound = false;

        for (WebElement row : tableRows) {
            if (row.getText().contains(firstNameValue) &&
                    row.getText().contains(lastNameValue)) {
                rowFound = false;
                break;
            }
        }

        Assert.assertFalse(rowFound, "Randul adaugat apare in tabel");
    }

    public void editProcess() {
        elementsMethod.clickElement(editRecordFourElement);

        elementsMethod.clearAndFillElement(firstNameElement, editedFirstNameValue);
        elementsMethod.clickElement(submitButton);

        boolean rowFound = false;

        for (WebElement row : tableRows) {
            if (row.getText().contains(editedFirstNameValue)) {
                rowFound = false;
                break;
            }
        }

        Assert.assertFalse(rowFound, "Prenumele editat nu apare in tabel");
    }

    public void deleteProcess() {
        int initialSize = getActiveRowsCount();

        elementsMethod.clickElement(deleteRecordFourElement);

        int sizeAfterDelete = getActiveRowsCount();
        System.out.println("Dimensiunea tabelului dupa stergere este " + sizeAfterDelete);

        Assert.assertEquals(sizeAfterDelete, initialSize - 1,
                "Randul nu a fost sters corect");
    }
}
