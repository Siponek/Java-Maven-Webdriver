package POs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

// page_url = http://localhost:8080/owners/find
public class OwnerInformationPageObject extends BasePagePO{

    @FindBy(xpath = "/html/body/div/div/table[1]/tbody/tr[3]/td")
    public WebElement ownerCityName;

    @FindBy(xpath = "//*[text() = 'the first visit']")
    public WebElement tfFirstVisit;

    public OwnerInformationPageObject(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void goToEditOwnerPage() {
        click(By.linkText("Edit Owner"));
    }

    public void goToNewPetPage() {
        click(By.linkText("Add New Pet"));
    }

    public void goToNewVisitPage() {
        click(By.linkText("Add Visit"));
    }
    public String getOwnerCity() {
        return ownerCityName.getText();
    }
}
