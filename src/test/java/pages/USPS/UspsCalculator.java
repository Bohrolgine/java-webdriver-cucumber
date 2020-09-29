package pages.USPS;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.Page;

public class UspsCalculator extends Page {

    @FindBy(id = "quantity-0")
    private WebElement quantity;

    @FindBy(id = "total")
    private WebElement total;

    @FindBy(xpath = "//*[@value='Calculate']")
    private WebElement submit;


    public void fillQuantity(String value) {
        quantity.sendKeys(value);
    }

    public void submit() {
        submit.click();
    }

    public String getTotal() {
        return total.getText();
    }
}
