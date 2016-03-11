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
	
	@Given("^I am on the page where I can introduce a new person$")
	public void i_am_on_the_page_where_I_can_introduce_a_new_person() throws Throwable {
		driver.navigate().to("http://localhost:8080/brainstorm2016WA2/nieuwePersoon.html");
	}

	@When("^I enter \"([^\"]*)\" in the ([^\"]*) field$")
	public void i_enter_in_the_firstname_field(String enteredText, String fieldName) throws Throwable {
		driver.findElement(By.id(fieldName)).sendKeys(enteredText);
	}

	@When("^I press on the Submit button$")
	public void i_press_on_the_Submit_button() throws Throwable {
		driver.findElement(By.name("submit")).click();
	}

	class LabelData {
		String label;
		String data;
	}
	
	@Then("^I should see the following on the screen$")
	public void i_should_see_the_following_on_the_screen(List<LabelData> checklist) throws Throwable {
		String bodyText = driver.findElement(By.tagName("body")).getText();
		for (LabelData ld: checklist){
			String text2bFound = ld.label + " " + ld.data;
			Assert.assertTrue("Did not find this text: "+text2bFound+"\n",bodyText.contains(text2bFound));
		}

	}

	@When("^I click the Home Link$")
	public void i_click_the_Home_Link() throws Throwable {
		driver.findElement(By.linkText("Home")).click();
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
