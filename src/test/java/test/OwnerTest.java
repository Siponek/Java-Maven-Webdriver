package test;
// OwnerTest.java

import POs.FindOwnersPageObject;
import POs.NewOwnerPageObject;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class OwnerTest {
    private WebDriver driver;
    FindOwnersPageObject findOwnersPage;
    NewOwnerPageObject newOwnerPage;


    @BeforeEach
    public void setUp() {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        findOwnersPage = new FindOwnersPageObject(driver);
        findOwnersPage.visit("http://localhost:8080/owners/find");
        findOwnersPage.goToAddOwnerPage();
        newOwnerPage = new NewOwnerPageObject(driver);
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void testAddOwnerWithValidData() {
//        newOwnerPage.addOwner("Charles", "Smith", "street 1", "New York", "123");
        String longTelephone = "123";
        String address = "street 1";
        String city = "New York";
        String firstName = "Charles";
        String lastName = "Smith";
        newOwnerPage.addOwner(firstName,
                lastName,
                address,
                city,
                longTelephone);
        // Here you would verify that a new page showing the new owner is displayed.
        // You might navigate to the page showing the list of owners and check that the new owner is in the list.
        assertTrue(newOwnerPage.getDisplayedOwnerName().contains(firstName + " " + lastName), "Owner name is not displayed");

    }

    @Test
    public void testAddOwnerWithEmptyField() {
        newOwnerPage.addOwner("John", "Doe", "street 1", "", "12345");
        String errorMessage = newOwnerPage.getErrorMessage();
        //  I have a polish browser
        assertTrue(errorMessage.contains("it must not be empty") || errorMessage.contains("nie może być puste"));
    }

    @Test
    public void testAddOwnerWithTooLongTelephone() {
        String longTelephone = "1234567898765";
        String address = "street 1";
        String city = "city 1";
        String firstName = "John";
        String lastName = "Doe";
        newOwnerPage.addOwner(firstName,
                lastName,
                address,
                city,
                longTelephone);

        String errorMessage = newOwnerPage.getErrorMessage();
        boolean isErrorMessageCorrect = errorMessage.contains("numeric value out of bounds") || errorMessage.contains("wartość liczbowa spoza zakresu (oczekiwano <liczba cyfr: 10>,<liczba cyfr: 0>)");
        assertTrue(isErrorMessageCorrect, "Error message for phone is not correct");
    }


}
