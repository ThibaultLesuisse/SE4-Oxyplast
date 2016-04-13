package be.odisee.brainstorm2016wa2;

import java.util.List;

import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.en.*;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class StepDefinitions {
	
	WebDriver driver = new FirefoxDriver();
	
	@Given("^I am on the page where I can introduce add a project$")
	public void i_am_on_the_page_where_I_can_introduce_add_a_project() throws Throwable {
	    driver.navigate().to("http://localhost:8080/oxyplast2016groep8/nieuwProject.html");
	}

	@When("^I enter \"([^\"]*)\" in the Naam field$")
	public void i_enter_in_the_Naam_field(String myNaam) throws Throwable {
		driver.findElement(By.id("naam")).sendKeys(myNaam);
	}

	@When("^I enter \"([^\"]*)\" in the Status field$")
	public void i_enter_in_the_Status_field(String myStatus) throws Throwable {
		driver.findElement(By.id("status")).sendKeys(myStatus);
	}

	@When("^I enter \"([^\"]*)\" in the TeamID field$")
	public void i_enter_in_the_TeamID_field(String myTeamId) throws Throwable {
		driver.findElement(By.id("teamId")).sendKeys(myTeamId);
	}

	@When("^I press on the Submit button$")
	public void i_press_on_the_Submit_button() throws Throwable {
		driver.findElement(By.name("submit")).click();
	}

	@Then("^I should see \"([^\"]*)\" as Naam$")
	public void i_should_see_as_Naam(String dataNaam) throws Throwable {
		driver.findElement(By.name("dbDataNaam")).equals(dataNaam);
	}

	@Then("^I should see \"([^\"]*)\" as Status$")
	public void i_should_see_as_Status(String dataStatus) throws Throwable {
		driver.findElement(By.name("dbDataStatus")).equals(dataStatus);
	}

	@Then("^I should see \"([^\"]*)\" as TeamID$")
	public void i_should_see_as_TeamID(String dataTeamID) throws Throwable {
		driver.findElement(By.name("dbDataTeamID")).equals(dataTeamID);
	}
	
	@When("^I click the Terug Link$")
	public void i_click_the_Terug_Link() throws Throwable {
		driver.findElement(By.name("terugButton")).click();
	}

	@Then("^I should see a list containing \"([^\"]*)\"$")
	public void i_should_see_a_list_containing(String text2bFound) throws Throwable {
		String bodyText = driver.findElement(By.tagName("body")).getText();
		Assert.assertTrue("Did not find this text: "+text2bFound+"\n",bodyText.contains(text2bFound));
	}

	@Then("^I close the browser$")
	public void i_close_the_browser() throws Throwable {
		driver.quit();
	}
}
