@Playstore
  Feature: Playstore

    @LaunchingPlaystore
    Scenario: Search Ezeelink App on Playstore
      Given Playstore Opened User Click Search Bar
      When User Fill the Search Bar with Ezeelink
      Then User Navigate to Ezeelink App