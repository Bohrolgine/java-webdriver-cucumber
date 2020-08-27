package definitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import gherkin.ast.ScenarioOutline;
import org.assertj.core.api.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.SourceType;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.time.Instant;
import java.util.*;
import java.util.concurrent.TimeUnit;
import static org.assertj.core.api.Assertions.assertThat;
import static support.TestContext.getDriver;
import org.apache.logging.log4j.core.util.JsonUtils;
import org.apache.logging.log4j.core.util.Source;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.w3c.dom.ls.LSOutput;
import static support.TestContext.*;


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

    @When("I run to Lookup ZIP page by address") //-ok
    public void iRunToLookupZIPPageByAddress() {
        WebElement mailAndShip = getDriver().findElement(By.xpath("//a[@id='mail-ship-width']"));

        new Actions(getDriver())
                .moveToElement(mailAndShip)
                .perform();

        getDriver().findElement(By.xpath("//li[@class='tool-zip']//a")).click();
        getDriver().findElement(By.xpath("//a[contains(@class, 'zip-code-address')]")).click();
    }

    @And("I fill out {string} street, {string} city, {string} state") // -ok
    public void iFillOutStreetCityState(String street, String city, String state) throws InterruptedException {
        getDriver().findElement(By.xpath("//input[@id='tAddress']")).sendKeys(street);
        getDriver().findElement(By.xpath("//input[@id='tCity']")).sendKeys(city);

        Select stateSelect = new Select(getDriver().findElement(By.xpath("//select[@id='tState']")));
        stateSelect.selectByValue(state);

        getDriver().findElement(By.xpath("//a[@id='zip-by-address']")).click();
    }

    @Then("I validate {string} zip code exists in the result") // -ok
    public void iValidateZipCodeExistsInTheResult(String zip) throws InterruptedException {
        getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        String result = getDriver().findElement(By.xpath("//ul[@class='list-group industry-detail']")).getText();
        assertThat(result).contains(zip);

        // --- explicit wait
        //WebDriverWait wait = new WebDriverWait(getDriver(), 10);
        //WebElement result = getDriver().findElement(By.xpath("//div[@id='zipByAddressDiv']"));

        //wait.until(ExpectedConditions.textToBePresentInElement(result, zip));
//        //--- wait.until(driver -> result.getText().length() > 0);
//        //--- assertThat(result.getText()).contains(zip);

    }

    @And("I go to calculate price page")
    public void iGoToCalculatePricePage() throws InterruptedException {
        WebElement mailAndShip = getDriver().findElement(By.xpath("//a[@id='mail-ship-width']"));
        WebElement calculatePrice = getDriver().findElement(By.xpath("//li[@class='tool-calc']//a[contains(text(),'Calculate a Price')]"));

        Actions actions = new Actions(getDriver());     // - actions initializing and they're connected to the browser //
        actions.moveToElement(mailAndShip)              // - "move to" works like "mouse over" // + click on the next required element//
                .click(calculatePrice)
                .perform();

        Thread.sleep(3000);
    }

    @And("I select {string} with {string} shape")
    public void iSelectWithShape(String country, String shape) throws InterruptedException {
        getDriver().findElement(By.xpath("//body//option[72]")).click();
        getDriver().findElement(By.xpath("//input[@id='option_1']")).click();
    }

    @And("I define {string} qty")
    public void iDefineQty(String qty) throws InterruptedException {
        getDriver().findElement(By.xpath("//input[@id='quantity-0']")).sendKeys(qty);
        getDriver().findElement(By.xpath("//input[@class='btn btn-pcalc btn-default']")).click();
        Thread.sleep(1000);
    }

    @Then("I validate the price is {string}")
    public void iValidateThePriceIs(String priceres) {
        String total = getDriver().findElement(By.xpath("//div[@id='total']")).getText();
        assertThat(total).contains(priceres);
    }

    @When("I perform {string} search") // -ok
    public void iPerformSearch(String free_boxes) throws InterruptedException {
        WebElement searchMenu = getDriver().findElement(By.xpath("//li[contains(@class, 'nav-search')]"));
        WebElement searchInput = getDriver().findElement(By.xpath("//input[@id='global-header--search-track-search']"));

        new Actions(getDriver())
                .moveToElement(searchMenu)
                .sendKeys(searchInput, free_boxes)
                .sendKeys(Keys.ENTER)
                .perform();


//        WebElement search = getDriver().findElement(By.xpath("//a[contains(text(),'Search USPS.com')]"));
//        WebElement tracksearch = getDriver().findElement(By.xpath("//input[@id='global-header--search-track-search']"));
//
//        Actions actions = new Actions(getDriver());
//        actions.moveToElement(search)
//                .clickAndHold(search)
//                .perform();;
//
//        getDriver().findElement(By.xpath("//input[@id='global-header--search-track-search']")).sendKeys(free_boxes);
//        getDriver().findElement(By.xpath("//input[@id='global-header--search-track-search']")).sendKeys(Keys.ENTER);
//        Thread.sleep(3000);
    }

    @And("I set {string} in filters") //-ok
    public void iSetInFilters(String filter1) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(getDriver(), 5);

        WebElement spinner = getDriver().findElement(By.xpath("//div[@class='white-spinner-container']"));
        wait.until(ExpectedConditions.invisibilityOf(spinner));

        getDriver().findElement(By.xpath("//a[@class='dn-attr-a'][text()='" + filter1 + "']")).click();

        wait.until(ExpectedConditions.invisibilityOf(spinner));
    }

    @Then("I verify that {string} results found") // -ok
    public void iVerifyThatResultsFound(String searchresultqty) {

        int expectedSize = Integer.parseInt(searchresultqty); //elements parsing

        List<WebElement> results = getDriver().findElements(By.xpath("//ul[@id='records']/li"));
        int actualSize = results.size();

        assertThat(actualSize).isEqualTo(expectedSize);

        //String result = getDriver().findElement(By.xpath("//span[@id='searchResultsHeading']")).getText();
        //assertThat(result).contains(searchresultqty);
    }

    @When("I select {string} in results")  // -ok
    public void iSelectInResults(String result) {
        getDriver().findElement(By.xpath("//span[contains(text(),'Priority Mail | USPS')]")).click();

    }


    @And("I click {string} button") // -ok
    public void iClickButton(String button) {
        getDriver().findElement(By.xpath("//a[contains(text(),'" + button + "')]")).click();
    }

    @Then("I validate that Sign In is required") // -ok
    public void iValidateThatSignInIsRequired() throws InterruptedException {
        Thread.sleep(3000);

        String originalWindow = getDriver().getWindowHandle();

        // switch to new window
        for (String handle : getDriver().getWindowHandles()) {
            getDriver().switchTo().window(handle);
        }

        new WebDriverWait(getDriver(), 3)
                .until(ExpectedConditions.titleContains("Sign In"));

        WebElement username = getDriver().findElement(By.xpath("//input[@id='username']"));
        assertThat(username.isDisplayed()).isTrue();

        // switch back
        getDriver().switchTo().window(originalWindow);

//        Iterator<String> iterator = getDriver().getWindowHandles().iterator(); //switch to a new tab
//        String newWindow = iterator.next();
//        while (iterator.hasNext()) {
//            newWindow = iterator.next();
//        }
//        getDriver().switchTo().window(newWindow);
//
//        String result = getDriver().findElement(By.xpath("//h1[@id='sign-in-to-your-account-header']")).getText();
//        assertThat(result).contains("Sign In To Your Account");
    }

    @When("I go to Find a Location Page")
    public void iGoToFindALocationPage() throws InterruptedException {
        WebElement quickTools = getDriver().findElement(By.xpath("//a[@id='mail-ship-width']"));
        WebElement findLocation = getDriver().findElement(By.xpath("//a[contains(text(),'Find a USPS Location')]"));

        Actions actions = new Actions(getDriver());
        actions.moveToElement(quickTools)
                .click(findLocation)
                .perform();

        Thread.sleep(3000);
    }

    @And("I filter by {string} Location Types, {string} Services,{string} Available Services")
    public void iFilterByLocationTypesServicesAvailableServices(String locationTypes, String services, String availableServices) throws InterruptedException {

        WebElement locationTypesF = getDriver().findElement(By.xpath("//button[@id='post-offices-select']"));
        WebElement locationType = getDriver().findElement(By.xpath("(//ul[@class='dropdown-menu']//a[text()= '" + locationTypes + "'])[2]")); // - forced to hardcode
        WebElement servicesF = getDriver().findElement(By.xpath("//button[@id='service-type-select']"));
        WebElement servicesType = getDriver().findElement(By.xpath("//li[@id='pickupPo']//a[contains(text(),'" + services + "')]"));
        WebElement availableServicesF = getDriver().findElement(By.xpath("//button[@id='available-service-select']"));
        WebElement availableServicesType = getDriver().findElement(By.xpath("//a[contains(text(),'" + availableServices + "')]"));

        new WebDriverWait(getDriver(), 3)
                .until(ExpectedConditions.elementToBeClickable(locationTypesF));

        Actions actions = new Actions(getDriver());
        actions.moveToElement(locationTypesF)
                .click()
                .release()
                .moveToElement(locationType)
                .click()
                .perform();

        new WebDriverWait(getDriver(), 3)
                .until(ExpectedConditions.elementToBeClickable(servicesF));

        actions.moveToElement(servicesF)
                .click()
                .release()
                .moveToElement(servicesType)
                .click()
                .perform();

        new WebDriverWait(getDriver(), 3)
                .until(ExpectedConditions.elementToBeClickable(availableServicesF));

        actions.moveToElement(availableServicesF)
                .click()
                .release()
                .moveToElement(availableServicesType)
                .click()
                .perform();
    }

    @And("I fill in {string} street, {string} city, {string} state")
    public void iFillInStreetCityState(String Street, String City, String State) throws InterruptedException {

        WebElement addressF = getDriver().findElement(By.xpath("//input[@id='search-input']"));
        WebElement addressStreetF = getDriver().findElement(By.xpath("//input[@id='addressLineOne']"));
        WebElement addressZipF = getDriver().findElement(By.xpath("//input[@id='cityOrZipCode']"));
        WebElement addressStateF = getDriver().findElement(By.xpath("//select[@id='servicesStateSelect']"));
        WebElement addressStateType = getDriver().findElement(By.xpath("//select[@id='servicesStateSelect']//option[contains(text(),'CA')]"));
        //WebElement addressStateType = getDriver().findElement(By.xpath("//*[@value='" + State + "']"));
        WebElement resultsBtn = getDriver().findElement(By.xpath("//a[contains(text(),'Go to Results')]"));

        //*[@value= 'CA']


        Actions actions = new Actions(getDriver());
        actions.moveToElement(addressF)
                .click()
                .perform();

        Thread.sleep(1000);
        actions.moveToElement(addressStreetF)
                .click()
                .sendKeys(Street)
                .moveToElement(addressZipF)
                .click()
                .sendKeys(City)
                .click()
                .perform();

        Thread.sleep(1000);
        getDriver().findElement(By.xpath("//option[contains(text(),'" + State + "')]")).click();
        getDriver().findElement(By.xpath("//a[contains(text(),'Go to Results')]")).click();
        Thread.sleep(1000);
    }

    @Then("I print the phone number and validate it is {string}")
    public void iPrintThePhoneNumberAndValidateItIs(String phone) throws InterruptedException {

       //WebElement firstResult = getDriver().findElement(By.xpath("//div[@id='1440608']//span[@class='listArrow']"));
        //WebElement resultContainer = getDriver().findElement(By.xpath("//p[@class='ask-usps']"));

        Thread.sleep(3000);
        getDriver().findElement(By.xpath("//h2[@class='normal']//strong[contains(text(),'MOUNTAIN VIEW')]")).click();

        Thread.sleep(3000);
        String result = getDriver().findElement(By.xpath("//p[@class='ask-usps']")).getText();
        assertThat(result).contains(phone);
    }

    @When("I go to {string} tab")
    public void iGoToTab(String tab) {
        getDriver().findElement(By.xpath("//a[@class='menuitem'][contains(text(),'" + tab + "')]")).click();
    }

    @And("I perform {string} help search")
    public void iPerformHelpSearch(String delivery) throws InterruptedException {
        WebElement search = getDriver().findElement(By.xpath("//input[@id='137:0']"));

        new WebDriverWait(getDriver(), 3)
        .until(ExpectedConditions.elementToBeClickable(search));

        Actions actions = new Actions(getDriver());
        actions.moveToElement(search)
                .click()
                .sendKeys(delivery)
                .sendKeys(Keys.ENTER)
                .perform();
    }

    @Then("I verify that no results of {string} available in help search")
    public void iVerifyThatNoResultsOfAvailableinHelpSearch(String delivery2) {
        WebElement results = getDriver().findElement(By.xpath("//div[@class='slds-has-dividers--bottom uiAbstractList']"));

        new WebDriverWait(getDriver(), 3)
                .until(ExpectedConditions.elementToBeClickable(results));

        String result = getDriver().findElement(By.xpath("//div[@class='slds-has-dividers--bottom uiAbstractList']")).getText();
        assertThat(result).doesNotContain(delivery2);
    }
}

