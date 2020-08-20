package definitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import gherkin.ast.ScenarioOutline;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.SourceType;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.support.ui.Select;
import java.util.*;
import java.util.concurrent.TimeUnit;
import static org.assertj.core.api.Assertions.assertThat;
import static support.TestContext.getDriver;
import org.apache.logging.log4j.core.util.JsonUtils;
import org.apache.logging.log4j.core.util.Source;
import org.w3c.dom.ls.LSOutput;


public class USPS {
    @Given("I navigate to {string} page")
    public void iNavigateToPage(String page) {
        getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        switch (page.toLowerCase()) {
            case "quote":
                getDriver().get("https://skryabin.com/market/quote.html");
                break;
            case "google":
                getDriver().get("https://www.google.com");
                break;
            case "usps":
                getDriver().get("https://www.usps.com");
                break;
            case "calculate price":
                getDriver().get("https://postcalc.usps.com/");
                break;
            case "yahoo":
                getDriver().get("https://yahoo.com/");
                break;
            default:
                System.out.println("Not recognized page " + page);
                //throw new RuntimeException("Not recognized page " + page);
        }
    }

    @When("I run to Lookup ZIP page by address")
    public void iRunToLookupZIPPageByAddress() {
        WebElement mailAndShip = getDriver().findElement(By.xpath("//a[@id='mail-ship-width']"));
        //Actions actions = new Actions(getDriver());
        //actions.moveToElement(mailAndShip).perform(); //move to element // - 2 strokes he makes mouseover via a variable
        new Actions(getDriver()).moveToElement(mailAndShip).perform();
        getDriver().findElement(By.xpath("//li[@class='tool-zip']//a")).click(); //full xpath: //li[@class='tool-zip']//a[contains(text(),'Look Up a ZIP Code')]
        getDriver().findElement(By.xpath("//a[contains(@class, 'zip-code-address')]")).click();
        //getDriver().findElement(By.xpath("//a[@id='mail-ship-width']")).click();
        //getDriver().findElement(By.xpath("//h2[@class='header-2 center']//a[contains(text(),'Look Up a ZIP Code')]")).click();
    }

    @And("I fill out {string} street, {string} city, {string} state")
    public void iFillOutStreetCityState(String street, String city, String state) throws InterruptedException {
        getDriver().findElement(By.xpath("//input[@id='tAddress']")).sendKeys(street);
        getDriver().findElement(By.xpath("//input[@id='tCity']")).sendKeys(city);
        WebElement stateElement = getDriver().findElement(By.xpath("//select[@id='tState']"));
        new Select(stateElement).selectByValue(state);
        getDriver().findElement(By.xpath("//a[@id='zip-by-address']")).click();


    }

    @Then("I validate {string} zip code exists in the result")
    public void iValidateZipCodeExistsInTheResult(String zip) throws InterruptedException {
        Thread.sleep(1000);
        String result = getDriver().findElement(By.xpath("//ul[@class='list-group industry-detail']")).getText();
        assertThat(result).contains(zip);
    }
}
