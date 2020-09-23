@UI
Feature: Responsive UI Validation

  @UI1 #ok
  Scenario: Responsive UI Validation for mobile layout.
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

  @UI2 #ok
  Scenario: Input field Validation - Username.
    Given I open url "https://skryabin.com/market/quote.html"
    When I type "a" into element with xpath "//input[@name='username']"
    And I click on element with xpath "//button[@id='formSubmit']"
    Then element with xpath "//label[@id='username-error']" should be displayed
    When I type "b" into element with xpath "//input[@name='username']"
    Then element with xpath "//label[@id='username-error']" should not be displayed

  @UI3-1 #ok
  Scenario: Input field Validation - Email pattern "name@host".
    Given I open url "https://skryabin.com/market/quote.html"
    When I type "a" into element with xpath "//input[@name='email']"
    And I click on element with xpath "//button[@id='formSubmit']"
    Then element with xpath "//label[@id='email-error']" should be displayed
    When I type "@" into element with xpath "//input[@name='email']"
    Then element with xpath "//label[@id='email-error']" should be displayed
    When I type "b" into element with xpath "//input[@name='email']"
    Then element with xpath "//label[@id='email-error']" should not be displayed

  @UI3-2 #ok
  Scenario: Input field Validation - Email pattern "name@host.domain".
    Given I open url "https://skryabin.com/market/quote.html"
    When I type "name.domain" into element with xpath "//input[@name='email']"
    And I click on element with xpath "//button[@id='formSubmit']"
    Then element with xpath "//label[@id='email-error']" should be displayed
    When I clear element with xpath "//input[@name='email']"
    When I type "name@host.domain" into element with xpath "//input[@name='email']"
    Then element with xpath "//label[@id='email-error']" should not be displayed

  @UI4 #ok
  Scenario: Input field Validation - Password.
    Given I open url "https://skryabin.com/market/quote.html"
    Then element with xpath "//input[@id='confirmPassword']" should be disabled
    Then I clear element with xpath "//input[@id='password']"
    Then element with xpath "//input[@id='password']" should have attribute "value" as ""
    When I type "password" into element with xpath "//input[@id='password']"
    Then element with xpath "//input[@id='confirmPassword']" should be enabled

  @UI5 #ok
  Scenario: Input field Validation - Name.
    Given I open url "https://skryabin.com/market/quote.html"
    When I click on element with xpath "//input[@id='name']"
    And element with xpath "//div[@id='nameDialog']" should be displayed
    When I type "Firstname" into element with xpath "//input[@id='firstName']"
    When I type "Middlename" into element with xpath "//input[@id='middleName']"
    When I type "Lastname" into element with xpath "//input[@id='lastName']"
    And I click on element with xpath "//span[contains(text(),'Save')]"
    Then element with xpath "//input[@id='name']" should have attribute "value" as "Firstname Middlename Lastname"

  @UI6 #ok
  Scenario: Input field Validation - Validate that Accepting Privacy Policy is required to submit the form, then check the field.
    Given I open url "https://skryabin.com/market/quote.html"
    When I type "Name" into element with xpath "//input[@id='name']"
    And I type "Username" into element with xpath "//input[@name='username']"
    And I type "password" into element with xpath "//input[@id='password']"
    And I type "password" into element with xpath "//input[@id='confirmPassword']"
    And I type "name@host.domain" into element with xpath "//input[@name='email']"
    And I click on element with xpath "//button[@id='formSubmit']"
    Then element with xpath "//label[@id='agreedToPrivacyPolicy-error']" should be displayed
    When I click on element using JavaScript with xpath "//input[@name='agreedToPrivacyPolicy']"
    And I click on element with xpath "//button[@id='formSubmit']"
    Then element with xpath "//legend[@class='applicationResult']" should be displayed

  @UI7 #ok
  Scenario: Input field Validation - Entering the following non-required fields.
    Given I open url "https://skryabin.com/market/quote.html"
    When I type "1234567890" into element with xpath "//input[@name='phone']"
    And I click on element with xpath "//option[contains(text(),'Japan')]"
    And I click on element with xpath "//div[5]//label[2]//input[1]"
    And I click on element with xpath "//input[@name='allowedToContact']"
    And I type "12345 - ABCD ABCD FDRE SE" into element with xpath "//textarea[@id='address']"
    And I click on element with xpath "//option[contains(text(),'Other')]"
    And I click on element using JavaScript with xpath "//button[@id='thirdPartyButton']"
    And I accept alert
    And I type "09/09/2020" into element with xpath "//input[@id='dateOfBirth']"

  @UI8 #ok
  Scenario: Input field Validation - Submit the form and verify the data.
    Given I open url "https://skryabin.com/market/quote.html"
    When I type "Name" into element with xpath "//input[@id='name']"
    And I type "Username" into element with xpath "//input[@name='username']"
    And I type "mypassword" into element with xpath "//input[@id='password']"
    And I type "mypassword" into element with xpath "//input[@id='confirmPassword']"
    And I type "name@host.domain" into element with xpath "//input[@name='email']"
    When I click on element using JavaScript with xpath "//input[@name='agreedToPrivacyPolicy']"
    And I click on element with xpath "//button[@id='formSubmit']"
    Then element with xpath "//b[@name='name']" should contain text "Name"
    And element with xpath "//b[@name='username']" should contain text "Username"
    And element with xpath "//b[@name='email']" should contain text "name@host.domain"
    And element with xpath "//div[@class='well form-container container-fluid']" should not contain text "mypassword"

  @UI9 #ok
  Scenario: Input field Validation - Validate Date Picker functionality.
    Given I open url "https://skryabin.com/market/quote.html"
    And I click on element with xpath "//input[@id='dateOfBirth']"
    Then element with xpath "//div[@class='ui-datepicker-title']" should be displayed
    When I click on element with xpath "//a[contains(text(), '18')]"
    Then element with xpath "//input[@id='dateOfBirth']" should have attribute "value" as "08/18/2020"
    When I click on element with xpath "//input[@id='dateOfBirth']"
    And I wait for 1 sec
    And I click on element with xpath "//option[contains(text(),'Jan')]"
    And I click on element with xpath "//select[@class='ui-datepicker-year']//option[112]"
    And I click on element using JavaScript with xpath "//a[contains(text(), '20')]"
    Then element with xpath "//input[@id='dateOfBirth']" should have attribute "value" as "01/20/2010"
    When I click on element using JavaScript with xpath "//span[@class='ui-icon ui-icon-circle-triangle-w']"
    Then element with xpath "//div[@id='ui-datepicker-div']//select[1]" should have attribute "value" as "11"
    When I click on element using JavaScript with xpath "//span[@class='ui-icon ui-icon-circle-triangle-e']"
    Then element with xpath "//div[@id='ui-datepicker-div']//select[1]" should have attribute "value" as "0"

  @UI10 #ok
  Scenario: Input field Validation - Working with i-frames.
    Given I open url "https://skryabin.com/market/quote.html"
    And I switch to iframe with xpath "//iframe[@name='additionalInfo']"
    And I type "Person Name" into element with xpath "//input[@id='contactPersonName']"
    And I type "1234567890" into element with xpath "//input[@id='contactPersonPhone']"
    And I switch to default content
    And I click on element using JavaScript with xpath "//input[@name='agreedToPrivacyPolicy']"

  @UI11 #ok
  Scenario: Input field Validation - Working with alerts.
    Given I open url "https://skryabin.com/market/quote.html"
    And I click on element using JavaScript with xpath "//button[@id='thirdPartyButton']"
    And I accept alert
    Then element with xpath "//span[@id='thirdPartyResponseMessage']" should contain text "accepted"
    When I click on element using JavaScript with xpath "//button[@id='thirdPartyButton']"
    And I dismiss alert
    Then element with xpath "//span[@id='thirdPartyResponseMessage']" should contain text "did not accept"

  @UI12 #ok
  Scenario: Input field Validation - Working with new windows.
    Given I open url "https://skryabin.com/market/quote.html"
    And I click on element using JavaScript with xpath "//div[11]//button[1]"
    And I switch to new window
    And element with xpath "//html//body//ul" should contain text "Document 1"
    And element with xpath "//html//body//ul" should contain text "Document 2"
    And element with xpath "//html//body//ul" should contain text "Document 3"
    And I switch to first window
    And I type "New Address" into element with xpath "//textarea[@id='address']"
    

