Feature: BellyFeature
  Scenario: eaten many cukes and growl
    Given I have eaten 22 cukes
    When I wait 3 hour
    Then my Belly should Growl

  Scenario: eaten may cukes and growl
    Given I have eaten 27 cukes
    When I wait 1 hour
    Then my belly Should not Growl

  Scenario: eaten few cukes and not growl
    Given I have eaten 8 cukes
    When I wait 4 hour
    Then My belly should not growl

  Scenario: eaten little cukes and not growl
    Given I have eaten 7 cukes
    When I wait 1 hour
    Then My BellY ShOuLd not growl

  Scenario: eaten poco cukes and growl
    Given I have eaten 0 cukes
    When I wait 0 hour
    Then mY Belly should not growl