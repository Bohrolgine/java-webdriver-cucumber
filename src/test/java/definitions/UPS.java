package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.assertj.core.api.Assertions.assertThat;
import static support.TestContext.getDriver;
import org.openqa.selenium.interactions.Actions;
import pages.UPS.UpsHome;
import pages.USPS.UspsHome;

import java.util.concurrent.TimeUnit;

public class UPS {
    @And("I open Shipping menu")
    public void iOpenShippingMenu() throws InterruptedException {

        getDriver().findElement(By.xpath("//a[@id='ups-menuLinks2']")).click();
        Thread.sleep(3000);
        //WebElement shipping = getDriver().findElement(By.xpath("//a[@id='ups-menuLinks2']"));
        //WebElement createShipment = getDriver().findElement(By.xpath("//a[contains(text(),'Create a Shipment:')]"));
        //WebElement continueButton = getDriver().findElement(By.xpath("//button[@id='nbsBackForwardNavigationContinueButton']"));
        //WebDriverWait wait = new WebDriverWait(getDriver(), 10);
       // wait.until(ExpectedConditions.visibilityOf(continueButton));
    }

    @And("I go to Create a Shipment")
    public void iGoToCreateAShipment() throws InterruptedException {
        getDriver().findElement(By.xpath("//a[contains(text(),'Create a Shipment:')]")).click();
        Thread.sleep(3000);
    }

    @When("I fill out origin shipment fields")
    public void iFillOutOriginShipmentFields() throws InterruptedException {

//        WebElement countryOrTerritory = getDriver().findElement(By.xpath("//select[@id='origincountry']"));
//        WebElement country = getDriver().findElement(By.xpath("//option[contains(text(),'Canada')]"));
//        WebElement name = getDriver().findElement(By.xpath("//input[@id='originname']"));
//        WebElement contactName = getDriver().findElement(By.xpath("//input[@id='origincontactName']"));
//        WebElement address = getDriver().findElement(By.xpath("//input[@id='originaddress1']"));
//        WebElement city = getDriver().findElement(By.xpath("//input[@id='origincity']"));
//        WebElement province = getDriver().findElement(By.xpath("//select[@id='originstate']"));
//        WebElement prov = getDriver().findElement(By.xpath("//option[contains(text(),'Alberta')]"));
//        WebElement postalCode = getDriver().findElement(By.xpath("//input[@id='originpostal']"));
//        WebElement resSwitch = getDriver().findElement(By.xpath("//label[@id='originisResidentialLabel']"));
//        WebElement email = getDriver().findElement(By.xpath("//input[@id='originemail']"));
//        WebElement phone = getDriver().findElement(By.xpath("//input[@id='originphone']"));
//        WebElement cButton = getDriver().findElement(By.xpath("//button[@id='nbsBackForwardNavigationContinueButton']"));
//
//        String iname = "John Doe";

        getDriver().findElement(By.xpath("//option[contains(text(),'Canada')]")).click();
        getDriver().findElement(By.xpath("//input[@id='originname']")).sendKeys("John Doe");
        getDriver().findElement(By.xpath("//input[@id='origincontactName']")).sendKeys("John Doe");
        getDriver().findElement(By.xpath("//input[@id='originaddress1']")).sendKeys("12345 - John Doe Ave South West");
        getDriver().findElement(By.xpath("//input[@id='origincity']")).sendKeys("Calgary");
        getDriver().findElement(By.xpath("//option[contains(text(),'Alberta')]")).click();
        getDriver().findElement(By.xpath("//input[@id='originpostal']")).sendKeys("T2Z4H5");
        getDriver().findElement(By.xpath("//label[@id='originisResidentialLabel']")).click();
        getDriver().findElement(By.xpath("//input[@id='originemail']")).sendKeys("john.doe@mail.au");
        getDriver().findElement(By.xpath("//input[@id='originphone']")).sendKeys("123456789");
    }

    @And("I submit the shipment form")
    public void iSubmitTheShipmentForm() throws InterruptedException {


        int offset = 500;
        WebElement element = getDriver().findElement(By.xpath("//button[@id='nbsBackForwardNavigationContinueButton']"));
        JavascriptExecutor executor = (JavascriptExecutor) getDriver();
        executor.executeScript("arguments[0].scrollIntoView(false);", element);
        executor.executeScript("window.scrollBy(0, " + offset + ");", element);
        Thread.sleep(500);

        getDriver().findElement(By.xpath("//button[@id='nbsBackForwardNavigationContinueButton']")).click();
        Thread.sleep(3000);
    }

    @Then("I verify origin shipment fields submitted")
    public void iVerifyOriginShipmentFieldsSubmitted() throws InterruptedException {


        String fields = "John Doe, John Doe\n" +
                "12345 - John Doe Ave South West, Calgary, AB T2Z4H5\n" +
                "CA\n" +
                "john.doe@mail.au, 123456789\n" +
                "Residential";
        String result = getDriver().findElement(By.xpath("//div[@class='ups-group ups-group_condensed']")).getText();
        assertThat(result).contains(fields);
    }

    @And("I cancel the shipment form")
    public void iCancelTheShipmentForm() throws InterruptedException {
        getDriver().findElement(By.xpath("//button[@id='nbsBackForwardNavigationCancelShipmentButton']")).click();
        Thread.sleep(1000);
        getDriver().findElement(By.xpath("//button[@id='nbsCancelShipmentWarningYes']")).click();
    }

    @Then("I verify shipment form is reset")
    public void iVerifyShipmentFormIsReset() throws InterruptedException {

        String empty = "";

        String resultName = getDriver().findElement(By.xpath("//input[@id='originname']")).getText();
        assertThat(resultName).isBlank();

        String contactName = getDriver().findElement(By.xpath("//input[@id='origincontactName']")).getText();
        assertThat(contactName).isBlank();

        String street = getDriver().findElement(By.xpath("//input[@id='originaddress1']")).getText();
        assertThat(street).contains(empty);

        String city = getDriver().findElement(By.xpath("//input[@id='origincity']")).getText();
        assertThat(city).contains(empty);

        String postal = getDriver().findElement(By.xpath("//input[@id='originpostal']")).getText();
        assertThat(postal).contains(empty);

        String email = getDriver().findElement(By.xpath("//input[@id='originemail']")).getText();
        assertThat(email).contains(empty);

        String phone = getDriver().findElement(By.xpath("//input[@id='originphone']")).getText();
        assertThat(phone).contains(empty);

        Thread.sleep(3000);
    }

    @When("I fill out destination shipment fields")
    public void iFillOutDestinationShipmentFields() throws InterruptedException {
        getDriver().findElement(By.xpath("//option[contains(text(),'Canada')]")).click();
        getDriver().findElement(By.xpath("//input[@id='destinationname']")).sendKeys("John Doe");
        getDriver().findElement(By.xpath("//input[@id='destinationcontactName']")).sendKeys("John Doe");
        getDriver().findElement(By.xpath("//input[@id='destinationaddress1']")).sendKeys("12345 - John Doe Ave South West");
        getDriver().findElement(By.xpath("//input[@id='destinationpostal']")).sendKeys("T2Z4H5");
        //getDriver().findElement(By.xpath("//label[@id='destinationisResidentialLabel']")).click();
        getDriver().findElement(By.xpath("//input[@id='destinationemail']")).sendKeys("john.doe@mail.au");
        getDriver().findElement(By.xpath("//input[@id='destinationphone']")).sendKeys("123456789");
        getDriver().findElement(By.xpath("//option[contains(text(),'Alberta')]")).click();
        getDriver().findElement(By.xpath("//input[@id='destinationcity']")).sendKeys("Calgary");
    }

    @And("I set packaging type and weight")
    public void iSetPackagingTypeAndWeight() {
        getDriver().findElement(By.xpath("//option[contains(text(),'UPS Express Box - Small')]")).click();
        getDriver().findElement(By.xpath("//input[@id='nbsPackagePackageWeightField0']")).sendKeys("3");
    }

    @Then("I verify total charges appear")
    public void iVerifyTotalChargesAppear() throws InterruptedException {

        WebDriverWait wait = new WebDriverWait(getDriver(),10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='upsell-tiles ups-shipping_schedule_when ng-star-inserted']")));

        int offset = 500;
        WebElement element = getDriver().findElement(By.xpath("//button[@id='nbsBackForwardNavigationContinueButton']"));
        JavascriptExecutor executor = (JavascriptExecutor) getDriver();
        executor.executeScript("arguments[0].scrollIntoView(false);", element);
        executor.executeScript("window.scrollBy(0, " + offset + ");", element);
        Thread.sleep(500);

        String fast = getDriver().findElement(By.xpath("//div[@class='upsell-tiles ups-shipping_schedule_when ng-star-inserted']//upsell-service-tile[1]")).getText();
        assertThat(fast).contains("57.33");
        String recom = getDriver().findElement(By.xpath("//upsell-service-tile[@class='upsell-service-tiles ng-star-inserted']//div[@id='Recommended']")).getText();
        assertThat(recom).contains("25.22");
        String low = getDriver().findElement(By.xpath("//upsell-service-tile[@class='upsell-service-tiles ng-star-inserted']//div[@id='Cheapest']")).getText();
        assertThat(low).contains("15.61");
    }

    @And("I select cheapest delivery option")
    public void iSelectCheapestDeliveryOption() throws InterruptedException {
        getDriver().findElement(By.xpath("//input[@id='nbsServiceTileServiceRadio7']")).click();

        Thread.sleep(1000);
    }

    @And("I set description and check Saturday Delivery type") // can't find "Saturday Delivery" option - set to "Deliver only to the receiver's address (+$)"
    public void iSetDescriptionAndCheckSaturdayDeliveryType() throws InterruptedException {
        getDriver().findElement(By.xpath("//input[@id='nbsShipmentDescription']")).sendKeys("My Item Description");
        getDriver().findElement(By.xpath("//direct-delivery-only-option[@class='ng-star-inserted']//span[@class='ups-lever_switch']")).click();
        Thread.sleep(2000);
    }

    @Then("I verify total charges changed")
    public void iVerifyTotalChargesChanged() throws InterruptedException {
        String charges = getDriver().findElement(By.xpath("//span[@id='total-charges-spinner']")).getText();
        assertThat(charges).contains("17.71");
        Thread.sleep(2000);
    }

    @And("I select Paypal payment type")
    public void iSelectPaypalPaymentType() throws InterruptedException {
        getDriver().findElement(By.xpath("//div[@id='tile-4']//span[@class='ups-tile_link ups-form_label']")).click();
        Thread.sleep(1000);
        getDriver().findElement(By.xpath("//label[@class='ups-radio-custom-label ng-star-inserted']")).click();
    }

    @Then("I review all recorded details on the review page")
    public void iReviewAllRecordedDetailsOnTheReviewPage() throws InterruptedException {

        getDriver().findElement(By.xpath("//button[@id='nbsBackForwardNavigationReviewPrimaryButton']")).click();
        Thread.sleep(2000);

        int offset = 500;
        WebElement element = getDriver().findElement(By.xpath("//button[@id='nbsBackForwardNavigationPayAndGetLabelsButton']"));
        JavascriptExecutor executor = (JavascriptExecutor) getDriver();
        executor.executeScript("arguments[0].scrollIntoView(false);", element);
        executor.executeScript("window.scrollBy(0, " + offset + ");", element);
        Thread.sleep(500);

    }

    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////// OOP section

    UpsHome upsHome = new UpsHome();


}
