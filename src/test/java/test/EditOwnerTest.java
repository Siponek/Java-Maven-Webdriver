package test;

//...

import POs.EditOwnerPageObject;
import POs.FindOwnersPageObject;
import POs.NewOwnerPageObject;
import POs.OwnerInformationPageObject;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

public class EditOwnerTest {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";
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
}
