package tests;

import modelObject.PracticeFormsModel;
import org.testng.annotations.Test;
import pages.PracticeFormsPage;
import sharedData.Hooks;

public class PracticeForms extends Hooks {

    @Test
    public void metodaTest() {

        PracticeFormsModel testData = new PracticeFormsModel("src/test/resources/inputData/PracticeFormsData.json");

        PracticeFormsPage practiceFormsPage = new PracticeFormsPage(getDriver());
        practiceFormsPage.clickFormsMenu();
        practiceFormsPage.clickPracticeFormSubMenu();
        practiceFormsPage.fillPracticeForm(testData);
    }
}