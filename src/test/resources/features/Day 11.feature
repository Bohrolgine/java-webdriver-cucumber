@java
Feature: ScenarioOutline cases

# resources - create new directory - "data"
# data - create new file - for instance - user.yml
# resources / TestContext.java add the following:
#     public static Map<String, String> getData(String fileName) throws FileNotFoundException {
#        String path = System.getProperty("user.dir") + "/src/test/resources/data/" + fileName + ".yml";
#        File file = new File(path);
#        InputStream stream = new FileInputStream(file);
#        Yaml yaml = new Yaml();
#        return yaml.load(stream);
#    }


  @java1 # Mirror flip string reverse - ok
  Scenario: I fill out required fields via yml
    Given I navigate to "quote" page
    Given I fill out required fields for "user"

  @usps1 # Scenario Outline - eg USPS - ok
  Scenario Outline: Validate ZIP code for PCSchool
    Given I navigate to "usps" page
    Given I run to Lookup ZIP page by address
    And I fill out "<street>" street, "<city>" city, "<state>" state
    Then I validate "<zip>" zip code exists in the result
    Examples:
      | street              | city      | state | zip   |
      | 4970 El Camino Real | Los Altos | CA    | 94022 |
      | 11 Wall st          | New York  | NY    | 10005 |
      | 111 S Michigan Ave  | Chicago   | IL    | 60603 |


  @calc1 # #Converter with Scenario Outline - ok
  Scenario Outline: Validate diff conversions
    Given I navigate to "converter" page
    When I click on "<value>"
    And I set "<from>" to "<to>"
    Then I enter into From field "<input>" and verify "<result>" result

    Examples:
      | value       | from         | to         | input | result       |
      | Length      | Meter        | Mile       | 54    | 0.0335539193 |
      | Temperature | Celsius      | Fahrenheit | 30    | 86           |
      | Area        | Square Meter | Acre       | 2500  | 0.6177634537 |
      | Volume      | Cubic Meter  | Liter      | 1     | 1000         |
      | Weight      | Kilogram     | Pound      | 10    | 22.046244202 |
      | Time        | Year         | Day        | 38    | 13879.5      |


  @java2 #Calculator
  Scenario Outline: Verify calculator results
    Given I navigate to "calculator" page
    When I navigate to "<type>"
    And I clear all calculator fields
    And I calculate
    Then I verify "<error>" calculator error
    #Then I verify "Please provide a positive interest value." calculator error
    And I enter "<price>" price, "<month>" months, "<interest>" interest, "<downp>" downpayment, "<trade>" trade-in, "<state>" state, "<tax>" percent tax, "<fees>" fees
    And I calculate
    Then I verify monthly pay is "<mpay>"

    Examples:
      | type                 | error                                    | price | month | interest | downp | trade | state      | tax | fees | mpay    |
      | Auto Loan Calculator | Please provide a positive auto price     | 25000 | 60    | 4.5      | 5000  | 0     | California | 7   | 300  | $372.86 |
      | Auto Loan Calculator | Please provide a positive interest value | 12076 | 55    | 4.2      | 10000 | 0     | Arizona    | 6   | 290  | $41.56  |




