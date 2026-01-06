package tests;

import helpMethods.ElementsMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class WebTableTest {

    public WebDriver driver;
    ElementsMethod elementsMethod; // Adăugat pentru utilitare


    @Test
    public void metodaTest (){

        //Deschidem un browser
        driver = new ChromeDriver();

        //Accesam un URL
        driver.get("https://demoqa.com/");
        driver.manage().window().maximize();

        // Inițializăm utilitarul
        elementsMethod = new ElementsMethod(driver);

        // --- CORECorecție Eroare: Folosim JavaScript pentru a ignora reclamele ---
        WebElement elementsMeniu = driver.findElement(By.xpath("//h5[text()='Elements']"));
        elementsMethod.javaScriptElement(elementsMeniu);

        WebElement webTable = driver.findElement(By.xpath("//span[text()='Web Tables']"));
        elementsMethod.clickElement(webTable);
        // -----------------------------------------------------------------------

        List<WebElement> continutTabel = driver.findElements(By.xpath("//div[@class='rt-tbody']/div/div[@class='rt-tr -odd' or @class='rt-tr -even']"));
        Assert.assertEquals(continutTabel.size(), 3, "Marimea tabelului nu este 3");

// Definim un element
        WebElement addElement = driver.findElement(By.id("addNewRecordButton"));
        elementsMethod.clickElement(addElement);

// First Name
        WebElement firstNameElement = driver.findElement(By.id("firstName"));
        String firstName = "Johny";
        elementsMethod.fillElement(firstNameElement, firstName);

// Last Name
        WebElement lastNameElement = driver.findElement(By.id("lastName"));
        String lastName = "Cash";
        elementsMethod.fillElement(lastNameElement, lastName);

// Email
        WebElement userEmailElement = driver.findElement(By.id("userEmail"));
        String userEmail = "johnycash12n@gmail.com";
        elementsMethod.fillElement(userEmailElement, userEmail);

// Age
        WebElement ageElement = driver.findElement(By.id("age"));
        String age = "31";
        elementsMethod.fillElement(ageElement, age);

// Salary
        WebElement salaryElement = driver.findElement(By.id("salary"));
        String salary = "5000";
        elementsMethod.fillElement(salaryElement, salary);

// Department
        WebElement departmentElement = driver.findElement(By.id("department"));
        String department = "Discogs";
        elementsMethod.fillElement(departmentElement, department);

        WebElement submitButton = driver.findElement(By.id("submit"));
        elementsMethod.clickElement(submitButton);

//      Validam noua dimensiune a tabelului
        List<WebElement> continutTabelNou = driver.findElements(By.xpath("//div[@class='rt-tbody']/div/div[@class='rt-tr -odd' or @class='rt-tr -even']"));
        Assert.assertEquals(continutTabelNou.size(), 4, "Marimea tabelului nu este 4");

//       Validam valorile pe care le-am introdus
        String continutRand = continutTabelNou.get(3).getText();
        Assert.assertTrue(continutRand.contains(firstName), "Randul nu contine first name");
        Assert.assertTrue(continutRand.contains(lastName), "Randul nu contine last name");
        Assert.assertTrue(continutRand.contains(userEmail), "Randul nu contine email");
        Assert.assertTrue(continutRand.contains(age), "Randul nu contine age");
        Assert.assertTrue(continutRand.contains(salary), "Randul nu contine salary");
        Assert.assertTrue(continutRand.contains(department), "Randul nu contine department");

        //Functionalitate de edit
        WebElement editElement = driver.findElement(By.id("edit-record-4"));
        elementsMethod.clickElement(editElement);

        WebElement editFirstNameElement = driver.findElement(By.id("firstName"));
        editFirstNameElement.clear();
        String editFirstName = "John";
        elementsMethod.fillElement(editFirstNameElement, editFirstName);

        WebElement editLastNameElement = driver.findElement(By.id("lastName"));
        editLastNameElement.clear();
        String editLastName = "Smith";
        elementsMethod.fillElement(editLastNameElement, editLastName);

        WebElement editEmailElement = driver.findElement(By.id("userEmail"));
        editEmailElement.clear();
        String editEmail = "johnysmithasd2@conver.com";
        elementsMethod.fillElement(editEmailElement, editEmail);

        WebElement editAgeElement = driver.findElement(By.id("age"));
        editAgeElement.clear();
        String editAge = "50";
        elementsMethod.fillElement(editAgeElement, editAge);

        WebElement submitButton2Button = driver.findElement(By.id("submit"));
        elementsMethod.clickElement(submitButton2Button);

        WebElement deleteElement = driver.findElement(By.id("delete-record-4"));
        elementsMethod.clickElement(deleteElement);

        List<WebElement> continutTabelSters = driver.findElements(By.xpath("//div[@class='rt-tbody']/div/div[@class='rt-tr -odd' or @class='rt-tr -even']"));
        Assert.assertEquals(continutTabelSters.size(), 3, "Noul tabel nu contine 3 randuri");

        //driver.quit();
    }
}