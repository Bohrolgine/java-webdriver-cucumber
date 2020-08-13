@predefined
Feature: Smoke steps

  @predefined1 #ok
  Scenario: Predefined steps for Google
    Given I open url "https://google.com"
    Then I should see page title as "Google"
    Then element with xpath "//input[@name='q']" should be present
    When I type "Behavior Driven Development" into element with xpath "//input[@name='q']"
    Then I click on element using JavaScript with xpath "(//input[@name='btnK'])[1]"
    Then I wait for element with xpath "//*[@id='res']" to be present
    Then element with xpath "//*[@id='res']" should contain text "Cucumber"

  @predefined2 #ok
  Scenario: Predefined steps for BING
    Given I open url "https://www.bing.com/"
    Then I should see page title as "Bing"
    Then element with xpath "//input[@id='sb_form_q']" should be present
    When I type "Behavior Driven Development" into element with xpath "//input[@id='sb_form_q']"
    Then I click on element using JavaScript with xpath "//label[@for='sb_form_go']"
    Then I wait for element with xpath "//ol[@id='b_results']" to be present
    Then element with xpath "//ol[@id='b_results']" should contain text "Wikipedia"

  @predefined3 #ok
  Scenario: Predefined steps for DuckDuckGo
    Given I open url "https://duckduckgo.com/"
    Then I should see page title as "DuckDuckGo — Privacy, simplified."
    Then element with xpath "//input[@id='search_form_input_homepage']" should be present
    When I type "Behavior Driven Development" into element with xpath "//input[@id='search_form_input_homepage']"
    Then I click on element using JavaScript with xpath "//input[@id='search_button_homepage']"
    Then I wait for element with xpath "//div[@class='results--main']" to be present
    Then element with xpath "//div[@class='results--main']" should contain text "Wikipedia"

  @predefined4 #ok
  Scenario: Predefined steps for Yahoo
    Given I open url "https://ca.yahoo.com/?p=ca"
    Then I should see page title as "Yahoo"
    Then element with xpath "//input[@id='header-search-input']" should be present
    When I type "Behavior Driven Development" into element with xpath "//input[@id='header-search-input']"
    Then I click on element using JavaScript with xpath "//button[@id='header-desktop-search-button']"
    Then I wait for element with xpath "//div[@id='main']" to be present
    Then element with xpath "//div[@id='main']" should contain text "Wikipedia"

  @predefined5 #ok
  Scenario: Predefined steps for Gibiru
    Given I open url "https://gibiru.com/"
    Then I should see page title as "Gibiru – Protecting your privacy since 2009"
    Then element with xpath "//input[@id='q']" should be present
    When I type "Behavior Driven Development" into element with xpath "//input[@id='q']"
    Then I click on element using JavaScript with xpath "//i[@class='fas fa-search new']"
    Then I wait for element with xpath "//div[@class='gsc-results gsc-webResult']" to be present
    Then element with xpath "//div[@class='gsc-results gsc-webResult']" should contain text "Wikipedia"

  @predefined6 #ok
  Scenario: Predefined steps for Swisscows
    Given I open url "https://swisscows.com"
    Then I should see page title as "Swisscows the alternative, data secure search engine."
    Then element with xpath "//input[@name='query']" should be present
    When I type "Behavior Driven Development" into element with xpath "//input[@name='query']"
    Then I click on element using JavaScript with xpath "//button[@class='search-submit']"
    And I wait for 2 sec
    Then I wait for element with xpath "//div[@class='web-results']" to be present
    Then element with xpath "//div[@class='web-results']" should contain text "Wikipedia"

  @predefined7 #ok
  Scenario: Predefined steps for Searchencrypt
    Given I open url "https://www.searchencrypt.com"
    Then I should see page title as "Search Encrypt | Home"
    Then element with xpath "//input[@placeholder='Search...']" should be present
    When I type "Behavior Driven Development" into element with xpath "//input[@placeholder='Search...']"
    Then I click on element using JavaScript with xpath "//button[@class='search-bar__submit']"
    Then I wait for element with xpath "//section[@class='serp__results container']" to be present
    Then element with xpath "//section[@class='serp__results container']" should contain text "Wikipedia"

  @predefined8 #ok
  Scenario: Predefined steps for Startpage
    Given I open url "https://www.startpage.com"
    Then I should see page title as "Startpage.com - The world's most private search engine"
    Then element with xpath "//input[@id='q']" should be present
    When I type "Behavior Driven Development" into element with xpath "//input[@id='q']"
    Then I click on element using JavaScript with xpath "//button[@class='search-form-home__form__button']"
    And I wait for 2 sec
    Then I wait for element with xpath "//div[@class='layout-web__body']" to be present
    Then element with xpath "//div[@class='layout-web__body']" should contain text "Wikipedia"

  @predefined9 #ok
  Scenario: Predefined steps for Yandex
    Given I open url "https://yandex.com/"
    Then I should see page title as "Yandex"
    Then element with xpath "//input[@id='text']" should be present
    When I type "Behavior Driven Development" into element with xpath "//input[@id='text']"
    Then I click on element using JavaScript with xpath "//span[@class='button__text']"
    And I wait for 2 sec
    Then I wait for element with xpath "//div[@class='main__content']" to be present
    Then element with xpath "//div[@class='main__content']" should contain text "Wikipedia"

  @predefined10 #ok
  Scenario: Predefined steps for Boardreader
    Given I open url "http://boardreader.com"
    Then I should see page title as "Boardreader - Forum Search Engine"
    Then element with xpath "//input[@id='title-query']" should be present
    When I type "Behavior Driven Development" into element with xpath "//input[@id='title-query']"
    Then I click on element using JavaScript with xpath "//button[@id='title-submit']"
    And I wait for 2 sec
    Then I wait for element with xpath "//ul[@class='mdl-list']" to be present
    Then element with xpath "//ul[@class='mdl-list']" should contain text "Told I am too old to learn to code"

  @predefined11 #ok
  Scenario: Predefined steps for Ecosia
    Given I open url "https://www.ecosia.org"
    # And I resize window to 400 and 2000
    Then I should see page title as "Ecosia - the search engine that plants trees"
    Then element with xpath "//input[@name='q']" should be present
    When I type "Behavior Driven Development" into element with xpath "//input[@name='q']"
    Then I click on element using JavaScript with xpath "//body//button[2]"
    Then I wait for element with xpath "//div[@class='mainline-results']" to be present
    Then element with xpath "//div[@class='mainline-results']" should contain text "Wikipedia"




