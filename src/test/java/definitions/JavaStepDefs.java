package definitions;

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
import java.util.*;
import java.util.concurrent.TimeUnit;

import static org.assertj.core.api.Assertions.assertThat;
import static support.TestContext.getDriver;


//import org.apache.logging.log4j.core.util.JsonUtils;
//import org.apache.logging.log4j.core.util.Source;
//import org.w3c.dom.ls.LSOutput;


///////////// - Day 4 - /////////////
//_______________________________________________________//
public class JavaStepDefs {
    @Given("I say hello world")
    public void iSayHelloWorld() {
        System.out.println("Hello World!");
    }

    @And("I say {string}")
    public void iSay(String message) {
        System.out.println(message);
    }

    @Given("I perform my actions with {string} and {string}")
    public void iPerformMyActionsWithAnd(String var5, String var6) {
        System.out.println("var 1: " + var5);
        System.out.println("var 2: " + var6);
        System.out.println("var 1 upperCase: " + var5.toUpperCase());
        System.out.println("var 2 upperCase: " + var6.toUpperCase());
        System.out.println("var 1 length: " + var5.length());
        System.out.println("var 2 length: " + var6.length());
        System.out.println("var equals: " + var5.equals(var6));
        //System.out.println("var equals ignoring case: " + var5.toLowerCase().equals(var6.toLowerCase()));
        System.out.println("var equals ignoring case: " + var5.equalsIgnoreCase(var6));
        System.out.println("var 1 contains var2: " + var5.contains(var6));
    }

    @Given("I perform few steps with additional variables: {string} , {string} and {string}")
    public void iPerformFewStepsWithAdditionalVariablesAnd(String arg0, String arg1, String arg2) {
        arg0 = "Hello World!";
        arg1 = "HeLlO wOrLd!";
        arg2 = "World Hello!";
        System.out.println("arg0: " + arg0);
        System.out.println("arg1: " + arg1);
        System.out.println("arg2: " + arg2);
        System.out.println("arg0 upperCase: " + arg0.toUpperCase());
        System.out.println("arg1 upperCase: " + arg1.toUpperCase());
        System.out.println("arg2 upperCase: " + arg2.toUpperCase());
        System.out.println("arg0 length: " + arg0.length());
        System.out.println("arg1 length: " + arg1.length());
        System.out.println("arg2 length: " + arg2.length());
//        System.out.println("args equals: " + arg0.equals(arg1));
//        System.out.println("args equals: " + arg0.equals(arg2));
//        System.out.println("args equals: " + arg1.equals(arg0));
//        System.out.println("args equals: " + arg1.equals(arg2));
//        System.out.println("args equals: " + arg2.equals(arg0));
//        System.out.println("args equals: " + arg2.equals(arg1));
//        System.out.println("args equals: " + arg0.equalsIgnoreCase(arg1));
//        System.out.println("args equals: " + arg0.equalsIgnoreCase(arg2));
//        System.out.println("args equals: " + arg1.equalsIgnoreCase(arg0));
//        System.out.println("args equals: " + arg1.equalsIgnoreCase(arg2));
//        System.out.println("args equals: " + arg2.equalsIgnoreCase(arg0));
//        System.out.println("args equals: " + arg2.equalsIgnoreCase(arg1));
//        System.out.println("args equals: " + arg0.contains(arg1));
//        System.out.println("args equals: " + arg0.contains(arg2));
//        System.out.println("args equals: " + arg1.contains(arg0));
//        System.out.println("args equals: " + arg1.contains(arg2));
//        System.out.println("args equals: " + arg2.contains(arg0));
//        System.out.println("args equals: " + arg2.contains(arg1));
    }

    //String var1 = "Say hello!";
    //System.out.println(var1);
    //String firstName = "Boris";
    //String lastName = "Jacob";
    //System.out.println("Full name: " + firstName + " " + lastName);
    //System.out.println(firstName.toUpperCase());
    //System.out.println(firstName.length());
    //String var1 = "Hello World!";
    //System.out.println("var1");
    //or
    //String var1;
    //var1 = "Hello World!";
    //System.out.println(var1);
    // }
//_______________________________________________________//


///////////// - Day 5 - /////////////
//_______________________________________________________//

    //number exercise p.12//
    int num1 = 130;
    int num2 = 15;
    double num3 = 16.5;
    int sum = num1 + num2;
    int difference = num1 - num2;
    int quotient1 = num1 / num2;
    double quotient2 = num1 / num3;
    int product = num1 * num2;
    String favoriteColour = "Red";
    String notfavoriteColour = "Green";
    //boolean compare = favoriteColour == notfavoriteColour;

    @Given("I do my homework")
    public void iDoMyHomework() {
        System.out.println("Here are my number exercises:");
        System.out.println("the sum: " + sum);
        System.out.println("the difference: " + difference);
        System.out.println("the division: " + quotient1);
        System.out.println("the division by a float: " + quotient2);
        System.out.println("the product: " + product);
        System.out.println("R the colours equal?: " + favoriteColour.equals(notfavoriteColour));
        //System.out.println("Compare via boolean var: " + compare);
    }

    //boolean exercise p.14//
    String string1 = "";
    String string2 = "";

    @Given("We compare {string} and {string} strings")
    public void weCompareStringAndStringStrings() {

        System.out.println("I compare 'string1' and 'string2' - r they equal?: " + string1.equals(string2));
        System.out.println("I compare 'string1' and 'string2' ignoring letter case - r they equal?: " + string1.equalsIgnoreCase(string2));
    }

    //conditions exercise p.17//
    @And("We print URL for {string} page")
    public void wePrintURLForPage(String site) {
        if (site.equalsIgnoreCase("google")) {
            System.out.println("https://www.google.com");
        } else if (site.equalsIgnoreCase("yahoo")) {
            System.out.println("https://www.yahoo.com");
        } else if (site.equalsIgnoreCase("quote")) {
            System.out.println("https://www.skryabin.com/market/quote.html");
        } else {
            System.out.println(site + " is not supported");
        }
    }

    //conditions exercise p.19//
    @When("We print URL for {string} page using switch")
    public void wePrintURLForPageUsingSwitch(String site1) {
        switch (site1.toLowerCase()) {
            case "google":
                System.out.println("https://www.google.com");
                break;
            case "yahoo":
                System.out.println("https://www.yahoo.com");
                break;
            case "quote":
                System.out.println("https://www.skryabin.com/market/quote.html");
                break;
            default:
                System.out.println(site1 + " is not supported");
        }
    }

    // arrays p.20
    @Given("I work with arrays")
    public void iWorkWithArrays() {
        String[] fruits = {"apple", "plum", "kiwi", "orange"};
        int[] nums = {5, 2, 3, 2, 5};

        //System.out.println(fruits[0]);
        //System.out.println(fruits[1]);
        //System.out.println(fruits[2]);

        for (String fruit : fruits) {
            System.out.println(fruit);
        }
        for (int allnumbers : nums) {
            System.out.println("num:" + allnumbers);
        }

        List<String> myFruits = Arrays.asList("apple", "plum", "kiwi", "orange");
        for (String fruit : myFruits) {
            System.out.println(fruit);
        }

        List<Integer> myNums = Arrays.asList(1, 2, 3, 4656, 555, 777, 3333, 12);
        for (int num : myNums) {
            System.out.println("my list nums: " + num);
        }
        //myNums.add(5);
    }


//_______________________________________________________//


///////////// - Day 6 - /////////////
//_______________________________________________________//

    @Given("I run to {string} page")
    public void iRunToPage(String page) {
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

    @And("I print page details")
    public void iPrintPageDetails() {
        System.out.println(getDriver().getTitle());
        System.out.println(getDriver().getCurrentUrl());
        System.out.println(getDriver().getPageSource());
        System.out.println(getDriver().getWindowHandle());
        System.out.println(getDriver().getWindowHandles());
    }

    @And("I go back and forward, then refresh")
    public void iGoBackAndForwardThenRefresh() {
        getDriver().navigate().back();
        getDriver().navigate().forward();
        getDriver().navigate().refresh();
    }

    @And("I change resolution to {string}")
    public void iChangeResolutionTo(String resolution) {
        switch (resolution.toLowerCase()) {
            case "phone":
                getDriver().manage().window().setSize(new Dimension(400, 768));
                break;
            case "desktop":
                getDriver().manage().window().setSize(new Dimension(1024, 768));
                break;
            case "max":
                getDriver().manage().window().maximize();
                break;
            default:
                getDriver().manage().window().fullscreen();
        }
    }

    @And("I fill required fields")
    public void iFillRequiredFields() {
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

    @And("I fill optional fields")
    public void iFillOptionalFields() {
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
        //getDriver().findElement(By.xpath("//button[contains(text(),'Related documents (click)')]")).click();
        //getDriver().switchTo().window(getDriver().getWindowHandles().iterator().next()); // switch back
        //getDriver().findElement(By.xpath("//a[@id='link']")).click();
        //getDriver().navigate().back();
    }

    @And("I submit the page")
    public void iSubmitThePage() {
        getDriver().findElement(By.xpath("//button[@id='formSubmit']")).click();
    }

    @Then("I verify e-mail field behavior")
    public void iVerifyEMailFieldBehavior() {
        getDriver().findElement(By.xpath("//input[@name='email']")).clear();
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

    @And("I verify submitted fields saved correctly")
    public void iVerifySubmittedFieldsSavedCorrectly() {
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











    //OLD section
    ///////////////////////////////////////////////////////////////// DAY 6 OLD ARRAYS - MAPS
    @Given("I work with maps")
    public void iWorkWithMaps() {
        Map<String, String> user = Map.of(
                "username", "jdoe",
                "password", "welcome",
                "email", "john@doe.com"
        );
        Map<String, String> admin = Map.of(
                "username", "admin",
                "password", "pass1",
                "email", "admin@doe.com"
        );
        System.out.println(user);
        System.out.println(admin);
        System.out.println(user.get("username"));
        System.out.println(user.get("password"));
        System.out.println(user.get("email"));
        System.out.println(admin.get("username"));
        System.out.println(admin.get("password"));
        System.out.println(admin.get("email"));
    }

    ///////////////////////////////////////////////////////////////// DAY 6 OLD ARRAYS - CODING CHALLENGES ////////////////
    @Given("I solve coding challenges")
    public void iSolveCodingChallenges() {
        swap(2, 5);

        isDivisibleBy3and4(9);
        isDivisibleBy3and4(8);
        isDivisibleBy3and4(12);
        isDivisibleBy3and4(17);

        isDivisibleBy2and5(10);
        isDivisibleBy2and5(50);
        isDivisibleBy2and5(500);
        isDivisibleBy2and5(1500);
        isDivisibleBy2and5(5000);

    }

    // HOMEWORK DAY 6 //
    void isDivisibleBy2and5(int divnum) {
        //System.out.println("Is divisible function for " + num);
        if (divnum % 2 == 0 && divnum % 5 == 0) {
            System.out.println(divnum + " is divisible by 2 and 5");
        } else if (divnum % 2 == 0) {
            System.out.println(divnum + " is divisible by 2");
        } else if (divnum % 5 == 0) {
            System.out.println(divnum + " is divisible by 5");
        } else {
            System.out.println(divnum + " is not divisible by 2 and 5");
        }
    }


    void isDivisibleBy3and4(int num) {
        //System.out.println("Is divisible function for " + num);
        if (num % 2 == 0 && num % 5 == 0) {
            System.out.println(num + " is divisible by 3 and 4");
        } else if (num % 2 == 0) {
            System.out.println(num + " is divisible by 3");
        } else if (num % 5 == 0) {
            System.out.println(num + " is divisible by 4");
        } else {
            System.out.println(num + " is not divisible by 3 and 4");
        }
    }

    void swap(int a, int b) {
        System.out.println("Swap Function");
        System.out.println("values before");
        System.out.println("a: " + a);
        System.out.println("b: " + b);
        int temp = a;
        a = b;
        b = temp;
        System.out.println("values after");
        System.out.println("a: " + a);
        System.out.println("b: " + b);
    }


    ///////////////////////////////////////////////////////////////// DAY 6 HOMEWORK
    @Given("I work with arrays hw")
    public void iWorkWithArraysHw() {
        int[] mynums = {5, 2, 9, 7, 3};
        System.out.println("Given array before swap: " + mynums[0] + ", " + mynums[1] + ", " + mynums[2] + ", " + mynums[3] + ", " + mynums[4]);

        int temp = mynums[2];
        mynums[2] = mynums[4];
        mynums[4] = temp;

        System.out.println("Given array after swap: " + mynums[0] + ", " + mynums[1] + ", " + mynums[2] + ", " + mynums[3] + ", " + mynums[4]);
    }

    @And("I use a list")
    public void iUseAList() {
        List<Integer> numbers = Arrays.asList(5, 2, 9, 7, 3);
        System.out.println("Results before swap operation: ");
        //for (int num : numbers)
        System.out.println(numbers);
//??        Collections.swap(numbers,3,5);
    }

    //
    //System.out.println(num);


    @And("I work with maps hw")
    public void iWorkWithMapsHw() {
        Map<String, String> info = new java.util.HashMap<>(Map.of(
                "username", "John",
                "middleName", "George"));
        {

            System.out.println("Values before swap: " + (info));

            String temp = (info.get("username"));
            info.put("username", (info.get("middleName")));
            //String temp2 = (info.get("middleName"));
            info.put("middleName", temp);
            //info.put ("username", temp2);

            System.out.println("Values after swap: " + (info));
        }

        //System.out.println(user.get("email")); info.get("key")
        //System.out.println(admin.get("username"));
        //System.out.println(admin.get("password"));
        //System.out.println(admin.get("email"));

    }



}







