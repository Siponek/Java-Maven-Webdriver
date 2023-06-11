
Feature: Add owner
  As a user, I want to add an owner to see if the 
  functionality has been implemented correctly in the PetClinic app
  
Scenario: Add owner with valid data
  Given a web browser is on PetClinic app
  When the user goes to 'find owners' web page
  And the user clicks 'Add Owner' button
  And the user fills First Name with "Charles"
  And the user fills Second Name with "Smith"
  And the user fills Address with "street 1"
  And the user fills City with "New York"
  And the user fills Telephone with "123"
  And the user clicks 'Add Owner' button
  Then a novel web page containing the inserted owner ("Charles" "Smith") is shown

Scenario: Try to add an owner with invalid data (an empty field)
  Given a web browser is on PetClinic app
  When the user goes to 'find owners' web page
  And the user clicks 'Add Owner' button
  And the user fills First Name with "John"
  And the user fills Second Name with "Doe"
  And the user fills Address with "street 1"
  And the user fills City with 'empty string' (i.e., "")
  And the user fills Telephone with "12345"
  And the user clicks 'Add Owner' button
  Then in the same web page the error message "it must not be empty" appears under the field left void (i.e., City)
	  
Scenario: Try to add an owner with telephone number too long
  Given a web browser is on PetClinic app
  When the user goes to 'find owners' web page
  And the user clicks 'Add Owner' button
  And the user fills First Name with "John"
  And the user fills Second Name with "Doe"
  And the user fills Address with "street 1"
  And the user fills City with "city 1"
  And the user fills Telephone with "1234567898765"
  And the user clicks 'Add Owner' button
  Then in the same web page the error message "numerical value out of bounds" appears under the telephone field
