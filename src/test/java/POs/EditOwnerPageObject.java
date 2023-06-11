package POs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import static POs.BasePagePO.ANSI_BLUE;
import static POs.BasePagePO.ANSI_RESET;

import java.time.Duration;

public class EditOwnerPageObject extends BasePagePO {
//    @FindBy(xpath = "//*[text() = 'must not be empty']")
//    public WebElement spanMustNotEmpty;

    @FindBy(css = "span.help-inline")
    public WebElement spanMustNotEmpty;

    public EditOwnerPageObject(WebDriver driver) {
        super(driver);
    }

    

    public void  fillElement(By by, String text) {
        WebElement element = find(by);
        element.clear();
        element.sendKeys(text);
    }
    public boolean isErrorDisplayed() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(spanMustNotEmpty));
        System.out.println(ANSI_BLUE + "spanMustNotEmpty.getText() = " + spanMustNotEmpty.getText() + ANSI_RESET);
        return spanMustNotEmpty.getText().contains("must not be empty") || spanMustNotEmpty.getText().contains("nie może być puste");
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
