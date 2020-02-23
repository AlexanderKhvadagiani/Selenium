Feature: Upload file

  Scenario: User uploads file successfully
    Given  User is on home page
    When User clicks "upload_file" button
    And User chooses file
    And User clicks upload button
    Then file should be uploaded

  Scenario: User moves mouse cursor to Home button

    Given  User is on home page
    When User clicks "shifting_content" button
    And user moves cursor to "Home" button
    Then button design should be changed

  Scenario: User clicks "click here" button and image moves

    Given  User is on home page
    When User clicks "shifting_content" button
    And  User clicks click here button for image
    Then image should move

