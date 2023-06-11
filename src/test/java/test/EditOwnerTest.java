package test;

//...

import POs.EditOwnerPageObject;
import POs.FindOwnersPageObject;
import POs.OwnerInformationPageObject;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static POs.BasePagePO.ANSI_BLUE;
import static POs.BasePagePO.ANSI_RESET;
import static org.junit.jupiter.api.Assertions.*;

public class EditOwnerTest {


    private WebDriver driver;
    private FindOwnersPageObject findOwnersPage;
    private OwnerInformationPageObject ownerInfoPage;
    private EditOwnerPageObject editOwnerPage;



    @BeforeEach
    public void setUp() {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        findOwnersPage = new FindOwnersPageObject(driver);
        ownerInfoPage = new OwnerInformationPageObject(driver);
        editOwnerPage = new EditOwnerPageObject(driver);

        findOwnersPage.visit("http://localhost:8080/owners/find");
        // NewOwnerPageObject newOwnerPage = new NewOwnerPageObject(driver);
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void testEditOwnerWithValidData() {
        findOwnersPage.searchForAllOwners();
        findOwnersPage.clickOnOwner("George Franklin");
        ownerInfoPage.goToEditOwnerPage();
//        editOwnerPage.editOwner("George", "Franklin", "110 W. Liberty St.", "New York", "6085551023");
        editOwnerPage.editOwnerCity("New York");
        editOwnerPage.updateOwner();
        // Then verify that the owner's city has been updated
        System.out.println(ANSI_BLUE + ownerInfoPage.getOwnerCity() + ANSI_RESET);
        assertEquals("New York", ownerInfoPage.getOwnerCity());
    }
    
//    Scenario: Try to edit an owner with empty name
    @Test
    public void testEditOwnerWithEmptyName() {
        findOwnersPage.searchForAllOwners();
        findOwnersPage.clickOnOwner("George Franklin");
        ownerInfoPage.goToEditOwnerPage();
        editOwnerPage.editOwner("", "Franklin", "110 W. Liberty St.", "New York", "6085551023");
        editOwnerPage.updateOwner();
        String errorMessageEnglish = "First name must not be empty";
        String errorMessagePolish = "nie może być puste";
        assertTrue(editOwnerPage.isErrorDisplayed(errorMessageEnglish) || editOwnerPage.isErrorDisplayed(errorMessagePolish));
    }

//    Scenario: Try to edit an owner with non numeric telephone
    @Test
    public void testEditOwnerWithNonNumericTelephone() {
        findOwnersPage.searchForAllOwners();
        findOwnersPage.clickOnOwner("George Franklin");
        ownerInfoPage.goToEditOwnerPage();
        editOwnerPage.editOwnerTelephone("xyz");
        editOwnerPage.updateOwner();
        String errorMessageEnglish = "numeric value out of bounds (<10 digits>.<0 digits> expected)";
        String errorMessagePolish = "wartość liczbowa spoza zakresu (oczekiwano <liczba cyfr: 10>,<liczba cyfr: 0>)";
        // You need to implement isTelephoneErrorDisplayed method in EditOwnerPageObject class
        assertTrue(editOwnerPage.isErrorDisplayed(errorMessageEnglish) || editOwnerPage.isErrorDisplayed(errorMessagePolish));
    }
}
