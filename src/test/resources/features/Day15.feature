@uspsOOP02
Scenario: Calculate price
Given I open "usps" page
When I go to Calculate Price Page oop
And I select "Canada" with "Postcard" shape oop
And I define "2" quantity oop
Then I calculate the price and validate cost is "$2.40" oop