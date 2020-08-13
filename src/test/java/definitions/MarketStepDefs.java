package definitions;

import com.sun.tools.xjc.reader.xmlschema.BindYellow;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.support.ui.Select;

import static org.assertj.core.api.Assertions.assertThat;
//import support.TestContext;


import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.Keys.TAB;
import static support.TestContext.getDriver;

///////////////////////////////////////////////////////////////// DAY 5 market.feature GO TO PAGE
public class MarketStepDefs {
    @Given("I go to {string} page")
    public void iGoToPage(String page) {
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

    ///////////////////////////////////////////////////////////////// DAY 5 market.feature DETAILS IN CONSOLE
    @And("I print page details in console")
    public void iPrintPageDetailsInConsole() {
        System.out.println(getDriver().getTitle());
        System.out.println(getDriver().getCurrentUrl());
        System.out.println(getDriver().getPageSource());
        System.out.println(getDriver().getWindowHandle());
        System.out.println(getDriver().getWindowHandles());

    }

    ///////////////////////////////////////////////////////////////// DAY 5 market.feature PAGE NAVIGATION
    @And("I go back and forward, then refresh the page")
    public void iGoBackAndForwardThenRefreshThePage() {
        getDriver().navigate().back();
        getDriver().navigate().forward();
        getDriver().navigate().refresh();

    }

    ///////////////////////////////////////////////////////////////// DAY 5 market.feature FILL OUT THE FORM
    @When("I fill out required fields")
    public void iFillOutRequiredFields() {
        getDriver().findElement(By.xpath("//input[@id='name']")).click();
        getDriver().manage().timeouts().setScriptTimeout(2, TimeUnit.SECONDS);
        getDriver().findElement(By.xpath("//input[@id='firstName']")).sendKeys("FirstName");
        getDriver().findElement(By.xpath("//input[@id='middleName']")).sendKeys("MiddleName");
        getDriver().findElement(By.xpath("//input[@id='lastName']")).sendKeys("LastName");
        getDriver().findElement(By.xpath("//span[contains(text(),'Save')]")).click();
        getDriver().findElement(By.xpath("//input[@name='username']")).sendKeys("username");
        getDriver().findElement(By.xpath("//input[@name='email']")).sendKeys("test@bj.com");
        getDriver().findElement(By.xpath("//input[@id='password']")).sendKeys("password");
        getDriver().findElement(By.xpath("//input[@id='confirmPassword']")).sendKeys("password");
        getDriver().manage().timeouts().setScriptTimeout(2, TimeUnit.SECONDS);
        getDriver().findElement(By.xpath("//input[@name='agreedToPrivacyPolicy']")).click();
        //getDriver().findElement(By.xpath("//button[@id='formSubmit']")).click();

    }

    ///////////////////////////////////////////////////////////////// DAY 5 market.feature FILL OUT THE FORM OPTIONAL FIELDS
    @And("I fill out optional fields")
    public void iFillOutOptionalFields() {
        getDriver().findElement(By.xpath("//input[@name='phone']")).sendKeys("12345678");
        getDriver().findElement(By.xpath("//input[@id='dateOfBirth']")).click();
        getDriver().findElement(By.xpath("//select[@class='ui-datepicker-month']")).click();
        getDriver().findElement(By.xpath("//option[contains(text(),'May')]")).click();
        getDriver().findElement(By.xpath("//select[@class='ui-datepicker-year']")).click();
        getDriver().findElement(By.xpath("//option[contains(text(),'2000')]")).click();
        getDriver().findElement(By.xpath("//a[contains(text(),'22')]")).click();
        getDriver().findElement(By.xpath("//select[@name='countryOfOrigin']")).click();
        getDriver().findElement(By.xpath("//option[contains(text(),'Canada')]")).click();
        getDriver().findElement(By.xpath("//span[contains(text(),'Male')]")).click();
        getDriver().findElement(By.xpath("//input[@name='allowedToContact']")).click();
        getDriver().findElement(By.xpath("//textarea[@id='address']")).sendKeys("378 Rue Greenshields, OTTAWA");
        getDriver().findElement(By.xpath("//option[contains(text(),'Toyota')]")).click();
        getDriver().switchTo().frame("additionalInfo");
        getDriver().findElement(By.xpath("//input[@id='contactPersonName']")).sendKeys("Name 1");
        getDriver().findElement(By.xpath("//input[@id='contactPersonPhone']")).sendKeys("Name 2");
        getDriver().switchTo().defaultContent();
        getDriver().findElement(By.xpath("//button[@id='thirdPartyButton']")).click();
        getDriver().switchTo().alert().accept();
        getDriver().findElement(By.xpath("//button[contains(text(),'Related documents (click)')]")).click();
        getDriver().switchTo().window(getDriver().getWindowHandles().iterator().next()); // switch back
        getDriver().findElement(By.xpath("//a[@id='link']")).click();
        getDriver().navigate().back();


        //getDriver().switchTo().defaultContent();
        //getDriver().findElement(By.xpath("//html//body")).sendKeys(Keys.CONTROL + "w");
        //getDriver().switchTo().window("[CDwindow-2A14DBD50CDD9017C834075822E2AD5A]");
        //getDriver().findElement(By.xpath("//a[@id='link']")).click();
        //getDriver().findElement(By.xpath("//html//body")).sendKeys(Keys.CONTROL + "w");
        //getDriver().getWindowHandle("CDwindow-2A14DBD50CDD9017C834075822E2AD5A");
        //getDriver().switchTo().window("viewport");
        //getDriver().close();


    }

    ///////////////////////////////////////////////////////////////// DAY 5 market.feature PRINT OUT THE 35 POS&NEG
    @And("I print if number {int} is positive")
    public void iPrintIfNumberIsPositive(int x) {
        if (x > 0 && x < 36) {
            System.out.println("The entered value " + x + " is positive.");
        } else if (x < 0) {
            System.out.println("The entered value " + x + " is negative.");
        } else if (x > 35) {
            System.out.println("The entered value " + x + " is bigger than 35, please re-enter.");
        } else if (x == 0) {
            System.out.println("You've entered 0 (zero), please re-enter.");
        }

    }

    ///////////////////////////////////////////////////////////////// DAY 5 market.feature PRINT DAY OF THE WEEK
    @And("I print {int} th day of the week")
    public void iPrintThDayOfTheWeek(int day) {
        switch (day) {
            case 1:
                System.out.println("Monday.");
                break;
            case 2:
                System.out.println("Tuesday.");
                break;
            case 3:
                System.out.println("Wednesday.");
                break;
            case 4:
                System.out.println("Thursday.");
                break;
            case 5:
                System.out.println("Friday.");
                break;
            case 6:
                System.out.println("Saturday.");
                break;
            case 7:
                System.out.println("Sunday.");
                break;
            default:
                System.out.println("Please enter a week-day number from 1 to 7.");
        }
    }

    ///////////////////////////////////////////////////////////////// DAY 5 market.feature CHANGE RESOLUTION
    @And("I change res to {string}")
    public void iChangeResTo(String resolution) {
        switch (resolution.toLowerCase()) {
            case "phone":
                getDriver().manage().window().setSize(new Dimension(400, 768));
                break;
            case "desktop":
                getDriver().manage().window().setSize(new Dimension(1024, 768));
                break;
            default:
                getDriver().manage().window().fullscreen();
        }
    }

    ///////////////////////////////////////////////////////////////// DAY 5 market.feature SUBMIT BUTTON CLICK
    @And("I submit the form")
    public void iSubmitTheForm() {
        getDriver().findElement(By.xpath("//button[@id='formSubmit']")).click();
    }

    ///////////////////////////////////////////////////////////////// DAY 5 market.feature EMAIL FIELD BEH assertion https://assertj.github.io/doc/
    @When("I verify email field behavior")
    public void iVerifyEmailFieldBehavior() {
        getDriver().findElement(By.xpath("//input[@name='email']")).sendKeys("setofrandomsymbols");
        getDriver().findElement(By.xpath("//input[@name='email']")).sendKeys(Keys.ENTER);
        assertThat(getDriver().findElement(By.xpath("//label[@id='email-error']")).isDisplayed()).isTrue();
        assertThat(getDriver().findElement(By.xpath("//label[@id='email-error']")).getText()).isEqualTo("Please enter a valid email address.");
        getDriver().findElement(By.xpath("//input[@name='email']")).sendKeys(Keys.BACK_SPACE);
        assertThat(getDriver().findElement(By.xpath("//label[@id='email-error']")).isDisplayed()).isTrue();
        assertThat(getDriver().findElement(By.xpath("//label[@id='email-error']")).getText()).contains("valid email address");
        assertThat(getDriver().findElement(By.xpath("//label[@id='email-error']")).getCssValue("#8b0000"));
        getDriver().findElement(By.xpath("//input[@name='email']")).clear();
        getDriver().findElement(By.xpath("//input[@name='email']")).sendKeys("name@name.name");
        getDriver().findElement(By.xpath("//input[@name='email']")).sendKeys(Keys.ENTER);
        assertThat(getDriver().findElement(By.xpath("//label[@id='email-error']")).isDisplayed()).isFalse();

    }

    ///////////////////////////////////////////////////////////////// DAY 5 market.feature SUBMITTED FIELDS assertion https://assertj.github.io/doc/
    @Then("I verify that submitted fields saved correctly")
    public void iVerifyThatSubmittedFieldsSavedCorrectly() {
        getDriver().manage().timeouts().setScriptTimeout(2, TimeUnit.SECONDS);
        assertThat(getDriver().findElement(By.xpath("//legend[@class='applicationResult']")).isDisplayed()).isTrue();
        assertThat(getDriver().findElement(By.xpath("//legend[@class='applicationResult']")).getText()).isEqualTo("Submitted Application");
        assertThat(getDriver().findElement(By.xpath("//b[@name='firstName']")).getText()).isEqualTo("FirstName");
        assertThat(getDriver().findElement(By.xpath("//b[@name='middleName']")).getText()).isEqualTo("MiddleName");
        assertThat(getDriver().findElement(By.xpath("//b[@name='lastName']")).getText()).isEqualTo("LastName");
        assertThat(getDriver().findElement(By.xpath("//b[@name='name']")).getText()).isEqualTo("FirstName MiddleName LastName");
        assertThat(getDriver().findElement(By.xpath("//b[@name='username']")).getText()).isEqualTo("username");
        assertThat(getDriver().findElement(By.xpath("//b[@name='password']")).getText()).isEqualTo("[entered]");
        assertThat(getDriver().findElement(By.xpath("//b[@name='email']")).getText()).isEqualTo("test@bj.com");


    }

    ///////////////////////////////////////////////////////////////// DAY 7, 8, 9 - USPS ZIP CODE

    @When("I go to Lookup ZIP page by address")
    public void iGoToLookupZIPPageByAddress() throws InterruptedException {
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

    @And("I select {string}")
    public void iSelect(String arg0) throws InterruptedException {
        getDriver().findElement(By.xpath("//option[contains(text(),'United Kingdom (United Kingdom of Great Britain an')]")).click();
    }


    @And("I print logs to the console")
    public void iPrintLogsToTheConsole() throws InterruptedException {
        Thread.sleep(1000);
        LogEntries logs = getDriver().manage().logs().get("browser");
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> Browser logs. Begin: >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        for (LogEntry log : logs) {
            System.out.println(log);
        }
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> Browser logs. End. >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");

    }

    @And("I fill multi-select")
    public void iFillMultiSelect() throws InterruptedException {
        WebElement ford = getDriver().findElement(By.xpath("//select[@name='carMake']/option[@value='Ford']"));
        WebElement bmw = getDriver().findElement(By.xpath("//select[@name='carMake']/option[@value='BMW']"));

//        Actions actions = new Actions(getDriver());
//
//        actions
//                .moveToElement(ford)
//                .click()
//                .pause(1000)
//                .keyDown(Keys.CONTROL)
//                .moveToElement(bmw)
//                .click()
//                .perform();

        WebElement carsElement = getDriver().findElement(By.xpath("//select[@name='carMake']"));
        Select carsSelect = new Select(carsElement);
        carsSelect.selectByValue("Ford");
        carsSelect.selectByValue("BMW");


        Thread.sleep(3000);
    }
}