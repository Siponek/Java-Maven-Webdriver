package POs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;

public class EditOwnerPageObject extends BasePagePO {
    public EditOwnerPageObject(WebDriver driver) {
        super(driver);
    }

    public void  fillElement(By by, String text) {
        WebElement element = find(by);
        element.clear();
        element.sendKeys(text);
    }
    public void editOwner(String firstName, String lastName, String address, String city, String telephone) {
        fillElement(By.id("firstName"), firstName);
        fillElement(By.id("lastName"), lastName);
        fillElement(By.id("address"), address);
        fillElement(By.id("city"), city);
        fillElement(By.id("telephone"), telephone);
    }

    public void editOwnerCity(String city) {
        fillElement(By.id("city"), city);
    }
    public void editOwnerTelephone(String telephone) {
        fillElement(By.id("telephone"), telephone);
    }
    public void editOwnerAddress(String address) {
           fillElement(By.id("address"), address);
    }
    public void editOwnerLastName(String lastName) {
        fillElement(By.id("lastName"), lastName);
    }
    public void editOwnerFirstName(String firstName) {
        fillElement(By.id("firstName"), firstName);
    }

    public void updateOwner() {
        click(By.xpath("//button[text()='Update Owner']"));
    }
}
