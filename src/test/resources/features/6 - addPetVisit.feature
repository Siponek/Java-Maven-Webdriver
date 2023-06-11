
Feature: Add pet visit
  As a user, I want to add a visit to a pet to see if the 
  functionality has been implemented correctly in the PetClinic app

Scenario: Add a pet visit with valid data
  Given a web browser is on PetClinic app
  When the user goes to 'find owners' web page
  And the user clicks 'Find Owner' button
  And the user clicks "George Franklin"
  And the user clicks 'Add Visit' link of the first pet in the table associated to "George Franklin"
  And the user inserts "the first visit" in the Description input field
  And the user clicks 'Add Visit' button
  Then in the Pets and Visits table the novel visit with description equal to "the first visit" is show among the visits of the first pet

Scenario: Try to add a pet visit with invalid data (empty description)
  Given a web browser is on PetClinic app
  When the user goes to 'find owners' web page
  And the user clicks 'Find Owner' button
  And the user clicks "George Franklin"
  And the user clicks 'Add Visit' link of the first pet in the table associated to "George Franklin"
  And the user leaves the visit's description void (i.e., with the empty string)
  And the user clicks 'Add Visit' button
  Then in the same web page the error message "it must not be empty" appears under the Description field
  
Scenario: Try to add a pet visit with invalid data (incorrect date)
  Given a web browser is on PetClinic app
  When the user goes to 'find owners' web page
  And the user clicks 'Find Owner' button
  And the user clicks "George Franklin"
  And the user clicks 'Add Visit' link of the first pet in the table associated to "George Franklin"
  And the user inserts "2021-03-194" in the Date input field
  And the user inserts "the first visit" in the Description input field
  And the user clicks 'Add Visit' button
  Then in the same web page a pop-up under Date input field shows the error message "enter a date in this format: YYYY-MM-DD" 
  
