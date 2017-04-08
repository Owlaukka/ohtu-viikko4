Feature: A new user account can be created if a proper unused username and a proper password are given

  Scenario: creation succesful with correct username and password
    Given new user is selected
    When correct username "uusi", password "salasana1" and password confirmation "salasana1" are given for registration
    Then user creation is successful

  Scenario: creation fails with too short username and valid passord
    Given new user is selected
    When too short username "as" and valid password "salasana" are given for registration
    Then user is not created and error "username should have at least 3 characters" is reported

  Scenario: creation fails with correct username and too short password
    Given new user is selected
    When correct username "uusi" and too short password "lyhyt" are given for registration
    Then user is not created and error "password should have at least 8 characters" is reported

  Scenario: creation fails with correct username and password consisting of letters
    Given new user is selected
    When correct username "uusi" and password consisting of only letters "salasana" are given for registration
    Then user is not created and error "password can not contain only letters" is reported

  Scenario: creation fails with already taken username and valid pasword
    Given new user is selected
    When an already used username "jukka" and valid password "salasana1" are given for registration
    Then user is not created and error "username is already taken" is reported

  Scenario: creation fails when password and password confirmation do not match
    Given new user is selected
    When correct username "uusi" is given but password "salasana1" and password confirmation "salasana2" do not match
    Then user is not created and error "password and password confirmation do not match" is reported
