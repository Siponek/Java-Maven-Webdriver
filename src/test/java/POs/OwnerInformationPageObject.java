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

    public OwnerInformationPageObject(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void goToEditOwnerPage() {
        click(By.linkText("Edit Owner"));
    }

    public String getOwnerCity() {
        return ownerCityName.getText();
    }
}
