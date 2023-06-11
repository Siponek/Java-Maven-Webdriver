
Feature: Edit owner
  As a user, I want to edit an owner to see if the 
  functionality has been implemented correctly in the PetClinic app
  
Scenario: Edit owner with valid data
  Given a web browser is on PetClinic app
  When the user goes to 'find owners' web page
  And the user clicks 'Find Owner' button
  And the user clicks "George Franklin"
  And the user clicks 'Edit Owner' button
  And the user modifies the city "Madison" in "New York"
  And the user clicks update owner button
  Then a novel web page containing the owner information with the modified city (i.e., "New York") is shown

Scenario: Try to edit an owner with empty name
  Given a web browser is on PetClinic app
  When the user goes to 'find owners' web page
  And the user clicks 'Find Owner' button
  And the user clicks "George Franklin"
  And the user clicks 'Edit Owner' button
  And the user modifies the name "George" in "" (that means leaving void the field)
  And the user clicks update owner button
  Then in the same web page the error message "it must not be empty" appears under the 'First Name' field
  
Scenario: Try to edit an owner with non numeric telephone
  Given a web browser is on PetClinic app
  When the user goes to 'find owners' web page
  And the user clicks 'Find Owner' button
  And the user clicks "George Franklin"
  And the user clicks 'Edit Owner' button
  And the user modifies the telephone "6085551023" in "xyz"
  And the user clicks update owner button
  Then in the same web page the error message "numerical value out of bounds" appears under the 'Telephone' field 