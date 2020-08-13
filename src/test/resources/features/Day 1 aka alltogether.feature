@predefined
Feature: Responsive UI Validation

  @predefined1 @UI-1
  Scenario: Input field Validation - Name (iframe)
    Given I open url "https://skryabin.com/market/quote.html"
    When I type "1234567890" into element with xpath "//input[@name='phone']"
    And I click on element with xpath "//select[@name='countryOfOrigin']"
    And I scroll to the element with xpath "//option[contains(text(),'Japan')]" with offset 1
    And I click on element using JavaScript with xpath "//div[5]//label[2]//input[1]"
    And I click on element using JavaScript with xpath "//input[@name='allowedToContact']"
    And I type "12345 - ABCD ABCD FDRE SE" into element with xpath "//textarea[@id='address']"
    And I click on element using JavaScript with xpath "//option[contains(text(),'BMW')]"
    When I click on element using JavaScript with xpath "//button[@id='thirdPartyButton']"
    Then I accept alert
    And I type "02/03/2020" into element with xpath "//input[@id='dateOfBirth']"
    And I switch to iframe with xpath "//iframe[@name='additionalInfo']"
    And I type "ABC" into element with xpath "//input[@id='contactPersonName']"
    And I switch to default content



      #@predefined12 #ok
  #Scenario: Predefined steps for Amazon
    #Given I open url "https://www.amazon.ca"
    #Then I should see page title as "Amazon.ca: Low Prices – Fast Shipping – Millions of Items"
    #Then element with xpath "//input[@id='twotabsearchtextbox']" should be present
    #When I type "masks" into element with xpath "//input[@id='twotabsearchtextbox']"
    #Then I click on element with xpath "//form[@name='site-search']//div[@class='nav-right']"
    #Then I wait for element with xpath "//div[@id='search']" to be present
    #Then I click on element with xpath "//span[contains(text(),'Ships from Canada - 100 Pack Disposable Face Safet')]"
    #Then I wait for 2 sec
    #Then element with xpath "//span[@id='productTitle']" should contain text "Ships from Canada"

  #@predefined13 #ok
  #Scenario: Predefined steps for Ebay
    #Given I open url "https://www.ebay.ca"
    #Then I should see page title as "Electronics, Cars, Fashion, Collectibles & More | eBay"
    #When I type "masks" into element with xpath "//input[@id='gh-ac']"
    #Then I click on element with xpath "//input[@id='gh-btn']"
    #Then I wait for element with xpath "//ul[@class='srp-results srp-grid clearfix']" to be present
    #Then I click on element with xpath "//h3[contains(text(),'[2-Pack] - Reusable Washable Face Mask with Breath')]"
    #Then I wait for 2 sec
    #Then element with xpath "//h1[@id='itemTitle']" should contain text "Face Mask"


  @java
  Feature: Java steps

  @java1
  Scenario: Number Exercises
    #Given I do my homework
    #When We compare "string1" and "string2" strings
    #And We print URL for "quote" page
    #And We print URL for "QuoTe" page
    #And We print URL for "google" page
    #And We print URL for "GooglE" page
    #And We print URL for "yahoo" page
    #And We print URL for "yAHoo" page
    #And We print URL for "wrongurl" page

    #When We print URL for "quote" page using switch
    #When We print URL for "QuoTe" page using switch
    #And We print URL for "google" page using switch
    #And We print URL for "GooglE" page using switch
    #And We print URL for "yahoo" page using switch
    #And We print URL for "yAHoo" page using switch
    #And We print URL for "wrongurl" page using switch



# Homework Day 5 If / else conditions

    When I go to "google" page
    Then I print page details in console





    And I print if number 35 is positive
                                                          #And I print if number 35 is positive via switch
    And I print 5 th day of the week


  @predefined
  Feature: Responsive UI Validation

  @predefined1 @UI-1
  Scenario: Input field Validation - Form
    Given I open url "https://skryabin.com/market/quote.html"
    When I type "Username" into element with xpath "//input[@name='username']"
    And I type "email@mail.io" into element with xpath "//input[@name='email']"
    And I type "password" into element with xpath "//input[@id='password']"
    And I type "password" into element with xpath "//input[@id='confirmPassword']"
    And I type "Name Secondname" into element with xpath "//input[@id='name']"
    And I type "1234567890" into element with xpath "//input[@name='phone']"
    #steps for calendar
    When I click on element with xpath "//input[@id='dateOfBirth']"
    And I click on element using JavaScript with xpath "//select[@class='ui-datepicker-month']//option[4]"
    And I click on element using JavaScript with xpath "//select[@class='ui-datepicker-year']//option[contains(text(),'1975')]"
    And I wait for 2 sec
    And I click on element using JavaScript with xpath "//a[contains(text(),'11')]"
    Then element with xpath "//input[@id='dateOfBirth']" should have attribute "value" as "03/11/2020"
    And I wait for 2 sec


    #And I type "02/03/2020" into element with xpath "//input[@id='dateOfBirth']"
    And I click on element with xpath "//select[@name='countryOfOrigin']"
    And I scroll to the element with xpath "//option[contains(text(),'Japan')]" with offset 1
    And I click on element with xpath "//button[@id='formSubmit']"
    Then element with xpath "//label[@id='agreedToPrivacyPolicy-error']" should be displayed
    When I click on element using JavaScript with xpath "//input[@name='agreedToPrivacyPolicy']"
    Then element with xpath "//label[@id='agreedToPrivacyPolicy-error']" should not be displayed
    When I click on element with xpath "//button[@id='formSubmit']"
    Then element with xpath "//b[@name='agreedToPrivacyPolicy']" should contain text "true"
    Then element with xpath "//b[@name='name']" should contain text "Name Secondname"


  @predefined
  Feature: Responsive UI Validation

  @predefined1 @UI-1
  Scenario: Input field Validation - Name
    Given I open url "https://skryabin.com/market/quote.html"
    When I click on element with xpath "//input[@id='name']"
    And element with xpath "//div[@id='nameDialog']" should be displayed
    When I type "Firstname" into element with xpath "//input[@id='firstName']"
    When I type "Middlename" into element with xpath "//input[@id='middleName']"
    When I type "Lastname" into element with xpath "//input[@id='lastName']"
    And I click on element with xpath "//span[contains(text(),'Save')]"
    Then element with xpath "//input[@id='name']" should have attribute "value" as "Firstname Middlename Lastname"


  @predefined
  Feature: Responsive UI Validation

  @predefined1 @UI-1
  Scenario: Input field Validation - Password
    Given I open url "https://skryabin.com/market/quote.html"
    Then element with xpath "//input[@id='confirmPassword']" should be disabled
    Then I clear element with xpath "//input[@id='password']"
    Then element with xpath "//input[@id='password']" should have attribute "value" as ""
    When I type "password" into element with xpath "//input[@id='password']"
    Then element with xpath "//input[@id='confirmPassword']" should be enabled


  @predefined
  Feature: Responsive UI Validation

  @predefined1 @UI-1
  Scenario: Input field Validation - Email pattern "name@host"
    Given I open url "https://skryabin.com/market/quote.html"
    When I type "a" into element with xpath "//input[@name='email']"
    And I click on element with xpath "//button[@id='formSubmit']"
    Then element with xpath "//label[@id='email-error']" should be displayed
    When I type "@" into element with xpath "//input[@name='email']"
    Then element with xpath "//label[@id='email-error']" should be displayed
    When I type "b" into element with xpath "//input[@name='email']"
    Then element with xpath "//label[@id='email-error']" should not be displayed

  @predefined2 @UI-1
  Scenario: Input field Validation - Email pattern "name@host.domain"
    Given I open url "https://skryabin.com/market/quote.html"
    When I type "name.domain" into element with xpath "//input[@name='email']"
    And I click on element with xpath "//button[@id='formSubmit']"
    Then element with xpath "//label[@id='email-error']" should be displayed
    When I clear element with xpath "//input[@name='email']"
    When I type "name@host.domain" into element with xpath "//input[@name='email']"
    Then element with xpath "//label[@id='email-error']" should not be displayed


  @predefined
  Feature: Responsive UI Validation

  @predefined1 @UI-1
  Scenario: Input field Validation - Username
    Given I open url "https://skryabin.com/market/quote.html"
    When I type "a" into element with xpath "//input[@name='username']"
    And I click on element with xpath "//button[@id='formSubmit']"
    Then element with xpath "//label[@id='username-error']" should be displayed
    When I type "b" into element with xpath "//input[@name='username']"
    Then element with xpath "//label[@id='username-error']" should not be displayed


  @PR
  Feature: Responsive UI Validation

  @predefined1
  Scenario: Responsive UI Validation for mobile layout
    Given I open url "https://skryabin.com/market/quote.html"
    When I maximize window
    Then element with xpath "//span[contains(text(),'Location')]" should be displayed
    And element with xpath "//span[contains(text(),'Date')]" should be displayed
    And element with xpath "//span[contains(text(),'Time')]" should be displayed
    When I resize window to 900 and 900
    Then element with xpath "//span[contains(text(),'Location')]" should be displayed
    And element with xpath "//span[contains(text(),'Date')]" should be displayed
    And element with xpath "//span[contains(text(),'Time')]" should be displayed
    When I resize window to 500 and 500
    Then element with xpath "//span[contains(text(),'Location')]" should not be displayed
    And element with xpath "//span[contains(text(),'Date')]" should not be displayed
    And element with xpath "//span[contains(text(),'Time')]" should not be displayed
    And I maximize window


  @predefined
  Feature: Smoke steps for diff browsers

  @predefined1
  Scenario: Predefined steps for Google
    Given I open url "https://google.com"
    Then I should see page title as "Google"
    Then element with xpath "//input[@name='q']" should be present
    When I type "Behavior Driven Development" into element with xpath "//input[@name='q']"
    Then I click on element using JavaScript with xpath "(//input[@name='btnK'])[1]"
    Then I wait for element with xpath "//*[@id='res']" to be present
    Then element with xpath "//*[@id='res']" should contain text "Cucumber"

  @predefined2
  Scenario: Predefined steps for BING
    Given I open url "https://www.bing.com/"
    Then I should see page title as "Bing"
    Then element with xpath "//input[@id='sb_form_q']" should be present
    When I type "Behavior Driven Development" into element with xpath "//input[@id='sb_form_q']"
    Then I click on element using JavaScript with xpath "//label[@for='sb_form_go']"
    Then I wait for element with xpath "//ol[@id='b_results']" to be present
    Then element with xpath "//ol[@id='b_results']" should contain text "Wikipedia"

  @predefined3
  Scenario: Predefined steps for DuckDuckGo
    Given I open url "https://duckduckgo.com/"
    Then I should see page title as "DuckDuckGo — Privacy, simplified."
    Then element with xpath "//input[@id='search_form_input_homepage']" should be present
    When I type "Behavior Driven Development" into element with xpath "//input[@id='search_form_input_homepage']"
    Then I click on element using JavaScript with xpath "//input[@id='search_button_homepage']"
    Then I wait for element with xpath "//div[@class='results--main']" to be present
    Then element with xpath "//div[@class='results--main']" should contain text "Wikipedia"




      #@UI6-1 #ok
  #Scenario: Input field Validation - Form
    #Given I open url "https://skryabin.com/market/quote.html"
    #When I type "Username" into element with xpath "//input[@name='username']"
    #And I type "email@mail.io" into element with xpath "//input[@name='email']"
    #And I type "password" into element with xpath "//input[@id='password']"
    #And I type "password" into element with xpath "//input[@id='confirmPassword']"
    #And I type "Name Secondname" into element with xpath "//input[@id='name']"
    #And I type "1234567890" into element with xpath "//input[@name='phone']"
    #And I type "02/03/2020" into element with xpath "//input[@id='dateOfBirth']"
    #And I click on element with xpath "//select[@name='countryOfOrigin']"
    #And I scroll to the element with xpath "//option[contains(text(),'Japan')]" with offset 1
    #And I click on element with xpath "//button[@id='formSubmit']"
    #Then element with xpath "//label[@id='agreedToPrivacyPolicy-error']" should be displayed
    #When I click on element using JavaScript with xpath "//input[@name='agreedToPrivacyPolicy']"
    #Then element with xpath "//label[@id='agreedToPrivacyPolicy-error']" should not be displayed
    #When I click on element with xpath "//button[@id='formSubmit']"
    #Then element with xpath "//b[@name='agreedToPrivacyPolicy']" should contain text "true"
    #Then element with xpath "//b[@name='name']" should contain text "Name Secondname"

  @UI10
  Scenario: Input field Validation - Name (iframe)
    Given I open url "https://skryabin.com/market/quote.html"
    When I type "1234567890" into element with xpath "//input[@name='phone']"
    And I click on element with xpath "//select[@name='countryOfOrigin']"
    And I scroll to the element with xpath "//option[contains(text(),'Japan')]" with offset 1
    And I click on element using JavaScript with xpath "//div[5]//label[2]//input[1]"
    And I click on element using JavaScript with xpath "//input[@name='allowedToContact']"
    And I type "12345 - ABCD ABCD FDRE SE" into element with xpath "//textarea[@id='address']"
    And I click on element using JavaScript with xpath "//option[contains(text(),'BMW')]"
    When I click on element using JavaScript with xpath "//button[@id='thirdPartyButton']"
    Then I accept alert
    And I type "02/03/2020" into element with xpath "//input[@id='dateOfBirth']"
    And I switch to iframe with xpath "//iframe[@name='additionalInfo']"
    And I type "ABC" into element with xpath "//input[@id='contactPersonName']"
    And I switch to default content