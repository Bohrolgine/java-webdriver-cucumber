package pages.USPS;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import pages.Page;

import static support.TestContext.getDriver;

public class UspsCalculatePrice extends Page {

    @FindBy(id = "CountryID")
    private WebElement country;

    //dynamic element

    private WebElement getShapeByValue(String value) {
        return getByXpath("//input[@value='" + value + "']");
    }

    //micro-methods
    public void selectCountry(String name){
        new Select(country).selectByVisibleText(name);
    }

    public void selectShape(String name){
        getShapeByValue(name).click();
    }

}
