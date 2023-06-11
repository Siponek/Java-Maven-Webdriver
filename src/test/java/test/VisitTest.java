package test;

import POs.FindOwnersPageObject;
import POs.NewOwnerPageObject;
import POs.NewPetVisitPageObject;
import POs.OwnerInformationPageObject;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindBy;

import static POs.BasePagePO.ANSI_BLUE;
import static POs.BasePagePO.ANSI_RESET;
import static org.junit.jupiter.api.Assertions.*;

public class VisitTest {


    private WebDriver driver;
    FindOwnersPageObject findOwnersPage;
    NewPetVisitPageObject newPetVisitPage;
    OwnerInformationPageObject ownerInfoPage;

    @BeforeEach
    public void setUp() {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        findOwnersPage = new FindOwnersPageObject(driver);
        ownerInfoPage = new OwnerInformationPageObject(driver);
        newPetVisitPage = new NewPetVisitPageObject(driver);
        findOwnersPage.visit("http://localhost:8080/owners/find");
        findOwnersPage.searchForAllOwners();
        findOwnersPage.clickOnOwner("George Franklin");
        ownerInfoPage.goToNewVisitPage();
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
//    Scenario: Add a pet visit with valid data

    @Test
    public void testAddPetVisitWithValidData() {
        String userPutDescription = "the first visit";
        newPetVisitPage.enterDescription( userPutDescription);
        newPetVisitPage.clickAddVisit();
        String visitDescription = ownerInfoPage.tfFirstVisit.getText();
        System.out.println("String in the description : " + ANSI_BLUE + visitDescription + ANSI_RESET);

        assertEquals(userPutDescription, visitDescription, "The visit description is not correct");
    }

    @Test
    public void testAddPetVisitWithEmptyDescription() {
        String userPutDescription = "";
        newPetVisitPage.enterDescription( userPutDescription);
        newPetVisitPage.clickAddVisit();
        Boolean isErrorDisplayedEnglish = newPetVisitPage.isErrorDisplayed("must not be empty");
        Boolean isErrorDisplayedPolish = newPetVisitPage.isErrorDisplayed("nie może być puste");
        assertTrue( isErrorDisplayedEnglish || isErrorDisplayedPolish);
    }

    @Test
    public void testAddPetVisitWithInvalidDate() {
        String userPutDate = "2021-03-194";
        newPetVisitPage.setDate(userPutDate);
        newPetVisitPage.clickAddVisit();
        String expectedDateError = "enter a date in this format: YYYY-MM-DD";
        String properError = "invalid date";
        assertTrue(newPetVisitPage.isErrorDisplayed(properError), ANSI_BLUE + "The error message is not correct" + ANSI_RESET);
        assertTrue(newPetVisitPage.isErrorDisplayed(expectedDateError), ANSI_BLUE + "The error message is not correct" + ANSI_RESET);
    }

}
