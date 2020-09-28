package pages.USPS;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.Page;

public class UspsLookupByZip extends Page {

    @FindBy(xpath = "//a[contains(text(),'Find by Address')]")
    private WebElement findByAddress;

    public void clickFindByAddress() {
        findByAddress.click();
    }

}
