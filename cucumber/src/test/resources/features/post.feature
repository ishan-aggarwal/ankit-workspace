Feature:Test post api's
  @Post
  Scenario: get post endpoint
    Given I have request
    When I send get request
    Then I verify response