package definitions;

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
import org.w3c.dom.ranges.Range;

import java.util.*;
import java.util.concurrent.TimeUnit;

import static org.assertj.core.api.Assertions.assertThat;
//import static org.graalvm.compiler.debug.TTY.printf;
//import static org.graalvm.compiler.hotspot.stubs.StubUtil.printf;
import static org.assertj.core.api.Assertions.shouldHaveThrown;
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


///////////// - Day 6 - ///////////// GetDriver
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

    //Maps

    @And("I work with maps hw")
    public void iWorkWithMapsHw() {
        Map<String, String> info = new java.util.HashMap<>(Map.of(
                "firstname", "John",
                "middleName", "George"));
        {

            System.out.println("Values before swap: " + (info));

            String temp = (info.get("firstname"));
            info.put("firstname", (info.get("middleName")));
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

    @Given("I solve coding challenges")
    public void iSolveCodingChallenges() {
        swap(2, 5);

//        isDivisibleBy3and4(9);
//        isDivisibleBy3and4(8);
//        isDivisibleBy3and4(12);
//        isDivisibleBy3and4(17);

        isDivisibleBy2and5(10);
        isDivisibleBy2and5(50);
        isDivisibleBy2and5(500);
        isDivisibleBy2and5(1500);
        isDivisibleBy2and5(5000);

    }

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

//    void isDivisibleBy3and4(int num) {
//        if (num % 3 == 0 && num % 4 == 0) {
//            System.out.println(num + " is divisible by 3 and 4");
//        } else if (num % 3 == 0) {
//            System.out.println(num + " is divisible by 3");
//        } else if (num % 4 == 0) {
//            System.out.println(num + " is divisible by 4");
//        } else {
//            System.out.println(num + " is not divisible by 3 and 4");
//        }
//    }

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


//_______________________________________________________//


///////////// - Day 7 - ///////////// Interview questions
//_______________________________________________________//


    @Given("Swap array elements")
    public void swapArrayElements() {
        int[] givenArray = {5, 2, 9, 7, 3};

        for (int count = 0; count < givenArray.length; count++)
            System.out.println(givenArray[count]);
        System.out.println();

        int temp = givenArray[2];
        givenArray[2] = givenArray[4];
        givenArray[4] = temp;

        for (int count = 0; count < givenArray.length; count++)
            System.out.println(givenArray[count] + " ");
        System.out.println();
    }

    @Given("Swap array elements two")
    public void swapArrayElementsTwo() {
        int[] givenArray = {5, 2, 9, 7, 3};

        System.out.println(Arrays.toString(givenArray));

        int temp = givenArray[2];
        givenArray[2] = givenArray[4];
        givenArray[4] = temp;

        System.out.println(Arrays.toString(givenArray));
    }


    @Given("Divisible by")
    public void divisibleBy() {

        isDivisibleBy3and4(9);
        isDivisibleBy3and4(8);
        isDivisibleBy3and4(12);
        isDivisibleBy3and4(17);
        isDivisibleBy3and4(171);
        isDivisibleBy3and4(212);
        isDivisibleBy3and4(612);
        isDivisibleBy3and4(1612);
        isDivisibleBy3and4(12612);
    }

    void isDivisibleBy3and4(int num) {
        if (num % 3 == 0 && num % 4 == 0) {
            System.out.println(num + " is divisible by 3 and 4");
        } else if (num % 3 == 0) {
            System.out.println(num + " is divisible by 3");
        } else if (num % 4 == 0) {
            System.out.println(num + " is divisible by 4");
        } else {
            System.out.println(num + " is not divisible by 3 and 4");
        }

    }


///////////// - Day 8 - ///////////// Interview questions
//_______________________________________________________//


    @Given("Prints all numbers from {int} up to {int}")
    public void printsAllNumbersFromUpTo(int n1, int n2) {

        int number, rev;

        if (n2 < n1) {
            rev = n1;
            n1 = n2;
            n2 = rev;
        }

        System.out.println("All numbers from " + n1 + " to " + n2 + " are: ");

        for (number = n1; number <= n2; number++)
            System.out.print(number + " ");
    }


    @Given("Print all integer array")
    public void printAllIntegerArray() {
        int[] Arr = {1, 2, 5, 2, 9, 7, 3, 10, 12, 20, 50, 75, 91, 100};
        int toFind = 10;
        boolean found = false;

        if (Arr.length == 0) {
            System.out.println("array is null");
        }

        System.out.println("All integer array: " + Arrays.toString(Arr));

        System.out.println("Odd numbers: ");
        for (int count = 0; count < Arr.length; count++) {
            if (Arr[count] % 2 != 0) {
                System.out.println(Arr[count]);
            }
        }
        System.out.println("Even numbers: ");
        for (int count = 0; count < Arr.length; count++) {
            if (Arr[count] % 2 == 0) {
                System.out.println(Arr[count]);
            }
        }

        for (int n : Arr) {
            if (n == toFind) {
                found = true;
                break;
            }
        }
        if (found)
            System.out.println("array contains " + toFind);
        else
            System.out.println("array does contain " + toFind);
    }

    @Given("Fizz & Buzz functions up to {int}")
    public void fizzBuzzFunctionsUpTo(int y) {

        for (int x = 1; x <= y; x++)
            if (x % 3 == 0 && x % 5 == 0) {
                System.out.println("FizzBuzz");
            } else if (x % 3 == 0) {
                System.out.println("Fizz");
            } else if (x % 5 == 0) {
                System.out.println("Buzz");
            } else {
                System.out.println(x);
            }
    }

    @Given("Reverse words in sentence {string}") // - from day 10 - reverse a string
    public void reverseWordsInSentence(String sentence) {

        System.out.println("Original sentence: " + sentence);

        for (int i = sentence.length() - 1; i >= 0; i--) {

            System.out.print("Reversed sentence: " + sentence.charAt(i));
        }
    }

    @Given("Reversing words order in sentence {string}")
    public void reversingWordsOrderInSentence(String sentence) {
        String a[] = sentence.split(" ");

        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }

        System.out.println();

        for (int i = a.length - 1; i >= 0; i--) {
            System.out.print(a[i] + " ");
        }
    }

    @Given("Reverse every third character in sentence {string}")
    public void reverseEveryThirdCharacterInSentence(String sentence) {

        System.out.println(sentence);
        for (int i = sentence.length() - 1; i >= 0; i--)
            if (i % 3 == 0) {

                System.out.print(sentence.charAt(i));
            }
    }

    @Given("Reverse every third character in sentence {string} two")
    public void reverseEveryThirdCharacterInSentenceTwo(String sentence) {
        System.out.println(sentence);
        for (int i = sentence.length() - 1; i >= 0; i -= 3) {

            System.out.print(sentence.charAt(i));
        }
    }

    @Given("Here are numbers {int} and {int}")
    public void hereAreNumbersAnd(int a, int b) {

        //if (a % 5 == 0 && b % 5 == 0) {
        //System.out.println( "Entered numbers aren't divisible by 5, please re-enter numbers from 1 to 20 divisible by 5");
        //}
        //else {
        if (a >= 1 && a <= 10 && b >= 5 && b <= 10) {
            System.out.println("entered numbers belong to 1...10 range");
        } else if (a >= 11 && a <= 20 && b >= 11 && b <= 20) {
            System.out.println("entered numbers belong to 11...20 range");
        } else if (a >= 1 && a <= 10 && b >= 11 && b <= 20) {
            System.out.println("1st entered number belongs to 1...10 range & second entered number belongs to 11...20 range");
        } else if (a >= 11 && a <= 20 && b >= 1 && b <= 10) {
            System.out.println("1st entered number belongs to 10...20 range & second entered number belongs to 1...10 range");
        }
    }

    @Given("Here are my numbers {int} and {int}") // aka 5-1
    public void hereAreMyNumbersAnd(int a, int b) {

        if (a % 5 != 0 || b % 5 != 0) {
            System.out.println("Both or one of numbers aren't divisible by 5");
        } else if (a / 5 == 1) {
            System.out.println("Range is 1...10");
        } else if (a / 5 == 2) {
            System.out.println("Number goes to range 1...10 and range 10...20");
        } else if (a / 5 == 3 || a / 5 == 4) {
            System.out.println("Range is 10...20");
        } else if (a <= 0 || a > 20) {
            System.out.println("Number is out of range");
        }
    }

    @Given("Two numbers are {int} and {int}")
    public void twoNumbersAreAnd(int a, int b) {
        int sum = a + b;
        System.out.println("Addition of 2 numbers: " + sum);

        assertThat(a = sum - b);
    }

    @Given("Write a function that find two max numbers in an array")
    public void writeAFunctionThatFindTwoMaxNumbersInAnArray() {

        int[] arrayM = {10, 5, 350, 351, 45, 95, 560, 101, 1, 555, -5, 0, 1024, 768, 769, 900};
        int max1 = 0;
        int max2 = 0;

        for (int i = 0; i < arrayM.length; i++) {
            if (max1 < arrayM[i]) {
                max2 = max1;
                max1 = arrayM[i];
            } else if (max2 < arrayM[i]) {
                max2 = arrayM[i];
            }
        }
        System.out.println("1st max is: " + max1 + " and 2nd max is: " + max2);
    }

    @Given("Write a function that finds if array contains duplicates")
    public void writeAFunctionThatFindsIfArrayContainsDuplicates() {

        int[] arrayM = {10, 5, 450, 351, 450, 95, 560, 101, 1, 555, -5, 0, 1024, 768, 769, 900};
        boolean trigger = false;

        for (int i = 0; i < arrayM.length; i++) {

            for (int j = i + 1; j < arrayM.length; j++) {

                if (arrayM[i] == arrayM[j]) {
                    System.out.println(arrayM[i] + " is duplicated.");
                    trigger = true;
                }
            }
        }
        if (!trigger) {   //(trigger == false) - simplified
            System.out.println("No duplicates found");
        }
    }

    @Given("Write a function that finds if array contains duplicates via HashSet")
    public void writeAFunctionThatFindsIfArrayContainsDuplicatesViaHashSet() {
        String[] arrayM = {"java", "cucumber", "java", "coding", "maven", "black metal", "cucumbers", "python", "legal notice"};

        HashSet<String> langs = new HashSet<String>();

        for (String l : arrayM) {
            if (langs.add(l) == false) {
                System.out.println("Duplicated element: " + l);
            }
        }
    }

    @Given("Write a function that finds if word is palindrome")
    public void writeAFunctionThatFindsIfWordIsPalindrome() {
        String original = "ablewasiereisawelba";
        String reversed = "";


        int len = original.length();

        for (int i = len - 1; i >= 0; i--) {
            reversed = reversed + original.charAt(i);
        }

        if (original.equals(reversed)) {//same as if (original == reversed)

            System.out.println(reversed + " is palindrome string");
        } else {
            System.out.println(reversed + " is not palindrome string");
        }
    }

    @Given("Write a function that counts number of each character in a string")
    public void writeAFunctionThatCountsNumberOfEachCharacterInAString() {

//        int totalCount = mystring.length();
//        int totalCountWithNoSym = mystring.replace("a", "").length();
//        int count = (totalCount - totalCountWithNoSym);
//        System.out.println("");

        String mystring = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nam consectetur.";
        //String mystringupd = mystring.replace(" ", "");
        Map<Character, Integer> charMapCount = new HashMap<>();

        for (Character c : mystring.toCharArray()) {

            if (charMapCount.containsKey(c)) {
                charMapCount.put(c, charMapCount.get(c) +1);
            }
            else {
                charMapCount.put(c,1);
            }
        }
        System.out.println(charMapCount);
        }
    }



//Timeouts:
// getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
// getDriver().manage().timeouts().setScriptTimeout(2, TimeUnit.SECONDS);
// getDriver().switchTo().window(getDriver().getWindowHandles().iterator().next()); // switch back
// //getDriver().switchTo().defaultContent();
// //getDriver().switchTo().window("[CDwindow-2A14DBD50CDD9017C834075822E2AD5A]");





































