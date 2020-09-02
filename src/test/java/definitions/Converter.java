package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import static org.assertj.core.api.Assertions.assertThat;
import static support.TestContext.getDriver;

public class Converter {
    @When("I click on {string}")
    public void iClickOn(String measure) {

        getDriver().findElement(By.xpath("//div[@id='menu']//a[contains(text(),'" + measure + "')]")).click();
    }

    @And("I set {string} to {string}")
    public void iSetTo(String m1, String m2) {
        getDriver().findElement(By.xpath("//select[@id='calFrom']//option[contains(text(),'" + m1 + "')]")).click();
        getDriver().findElement(By.xpath("//select[@id='calTo']//option[contains(text(),'" + m2 + "')]")).click();
    }

    @Then("I enter into From field {string} and verify {string} result")
    public void iEnterIntoFromFieldAndVerifyResult(String v1, String v2) {
        getDriver().findElement(By.xpath("//input[@name='fromVal']")).sendKeys(v1);

        String result = getDriver().findElement(By.xpath("//div[@id='calResults']")).getText();
        assertThat(result).contains(v2);
    }

    @When("I navigate to {string}")
    public void iNavigateTo(String option) {
        getDriver().findElement(By.xpath("//a[contains(text(),'Auto Loan Calculator')]")).click();
    }

    @And("I clear all calculator fields")
    public void iClearAllCalculatorFields() {
        getDriver().findElement(By.xpath("//input[@id='cloanamount']")).clear();
        getDriver().findElement(By.xpath("//input[@id='cloanterm']")).clear();
        getDriver().findElement(By.xpath("//input[@id='cinterestrate']")).clear();
        getDriver().findElement(By.xpath("//input[@id='cdownpayment']")).clear();
        getDriver().findElement(By.xpath("//input[@id='ctradeinvalue']")).clear();
        getDriver().findElement(By.xpath("//input[@id='csaletax']")).clear();
        getDriver().findElement(By.xpath("//input[@id='ctitlereg']")).clear();
    }

    @And("I calculate")
    public void iCalculate() {
        getDriver().findElement(By.xpath("//body//input[3]")).click();
    }

    @Then("I verify {string} calculator error")
    public void iVerifyCalculatorError(String err) {
        String result = getDriver().findElement(By.xpath("//div[@id='content']")).getText();
        assertThat(result).contains(err);
    }

    @And("I enter {string} price, {string} months, {string} interest, {string} downpayment, {string} trade-in, {string} state, {string} percent tax, {string} fees")
    public void iEnterPriceMonthsInterestDownpaymentTradeInStatePercentTaxFees(String price, String month, String interest, String downpayment, String tradeIn, String state, String percentTax, String fees) {
//        WebElement autoPrice = getDriver().findElement(By.xpath("//input[@id='cloanamount']"));
//        WebElement loanTerm = getDriver().findElement(By.xpath("//input[@id='cloanterm']"));
//        WebElement interestRate = getDriver().findElement(By.xpath("//input[@id='cinterestrate']"));
//        WebElement downPayment = getDriver().findElement(By.xpath("//input[@id='cdownpayment']"));
//        WebElement tradeValue = getDriver().findElement(By.xpath("//input[@id='ctradeinvalue']"));
//        WebElement stateS = getDriver().findElement(By.xpath("//select[@name='cstate']"));
//        WebElement saleTax = getDriver().findElement(By.xpath("//input[@id='csaletax']"));
//        WebElement title = getDriver().findElement(By.xpath("//input[@id='ctitlereg']"));

//        new Actions(getDriver())
//                .moveToElement(autoPrice).sendKeys(price)
//                .moveToElement(loanTerm).sendKeys(month)
//                .moveToElement(interestRate).sendKeys(interest)
//                .moveToElement(downPayment).sendKeys(downpayment)
//                .moveToElement(tradeValue).sendKeys(tradeIn)
//                .moveToElement(stateS).sendKeys(state)
//                .moveToElement(saleTax).sendKeys(percentTax)
//                .moveToElement(title).sendKeys(fees)
//                .sendKeys(Keys.ENTER)
//                .perform();

        getDriver().findElement(By.xpath("//input[@id='cloanamount']")).sendKeys(price);
        getDriver().findElement(By.xpath("//input[@id='cloanterm']")).sendKeys(month);
        getDriver().findElement(By.xpath("//input[@id='cinterestrate']")).sendKeys(interest);
        getDriver().findElement(By.xpath("//input[@id='cdownpayment']")).sendKeys(downpayment);
        getDriver().findElement(By.xpath("//input[@id='ctradeinvalue']")).sendKeys(tradeIn);
        getDriver().findElement(By.xpath("//select[@name='cstate']")).sendKeys(state);
        getDriver().findElement(By.xpath("//input[@id='csaletax']")).sendKeys(percentTax);
        getDriver().findElement(By.xpath("//input[@id='ctitlereg']")).sendKeys(fees);
    }

    @Then("I verify monthly pay is {string}")
    public void iVerifyMonthlyPayIs(String pay) {
        String result = getDriver().findElement(By.xpath("//h2[@class='h2result']")).getText();
        assertThat(result).contains(pay);
    }
}
