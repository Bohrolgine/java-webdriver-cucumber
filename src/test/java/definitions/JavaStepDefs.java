package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;

import java.util.*;

//import org.apache.logging.log4j.core.util.JsonUtils;
//import org.apache.logging.log4j.core.util.Source;
//import org.w3c.dom.ls.LSOutput;


///////////// - Day 4 aka Methods Exercises - /////////////
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


///////////// - Day 5 aka Numbers Exercises - /////////////
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

    ///////////////////////////////////////////////////////////////// DAY 6 ARRAYS - MAPS
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

    ///////////////////////////////////////////////////////////////// DAY 6 ARRAYS - CODING CHALLENGES ////////////////
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




