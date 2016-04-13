Feature: Add Project

It should be possible to add a project to the list
Just after adding the project, the details of the project should be known
After the list is shown again, the project data should be visible

Scenario: Add a project
Given I am on the page where I can introduce add a project
When I enter "ProjectX" in the Naam field
And I enter "StatusX" in the Status field
And I enter "420" in the TeamID field
And I press on the Submit button
Then I should see "ProjectX" as Naam
And I should see "StatusX" as Status
And I should see "420" as TeamID
When I click the Terug Link
Then I should see a list containing "ProjectX"
And I close the browser
  