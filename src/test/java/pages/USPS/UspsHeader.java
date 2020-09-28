package pages.USPS;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.Page;

import static support.TestContext.getExecutor;

public class UspsHeader extends Page {

    @FindBy(id = "mail-ship-width")
    private WebElement mailAndShip;

    @FindBy(xpath = "//li[@class='tool-zip']/a")
    private WebElement lookupByZip;

    @FindBy(xpath = "//li[@class='tool-calc']/a[contains(@href,'post')]")
    private WebElement calculatePrice;


    public void goToLookupByZip() {
        //waitToBeSelected(mailAndShip);
        mouseOver(mailAndShip);
        click(lookupByZip);
        //clickWithJS(lookupByZip);
        //lookupByZip.click();
    }

    public void goToCalculatePrice() {
        //waitToBeSelected(mailAndShip);
        mouseOver(mailAndShip);
        click(calculatePrice);
        //clickWithJS(calculatePrice);
        //calculatePrice.click();
    }



}
