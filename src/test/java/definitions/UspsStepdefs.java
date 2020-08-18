package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import static support.TestContext.*;


////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
public class UspsStepdefs {
    @When("I go to Find a Location Page")
    public void iGoToFindALocationPage() {
        WebElement mailShip = getDriver().findElement(By.xpath("//a[@id='mail-ship-width']"));
        new Actions(getDriver()).moveToElement(mailShip).perform();
        getDriver().findElement(By.xpath("//li[@class='tool-find']/a")).click();
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    @And("I filter by {string} Location Types, {string} Services, {string} Available Services")
    public void iFilterByLocationTypesServicesAvailableServices(String locationType, String service, String available) throws InterruptedException {
        getDriver().findElement(By.xpath("//button[@id='post-offices-select']")).click();
        getDriver().findElement(By.xpath("//a[string()='" + locationType + "']")).click();
        getDriver().findElement(By.xpath("//button[@id='service-type-select']")).click();
        getDriver().findElement(By.xpath("//a[string()='" + service + "']")).click();
        //getDriver().findElement(By.xpath)

        Thread.sleep(5000);
    }


}
