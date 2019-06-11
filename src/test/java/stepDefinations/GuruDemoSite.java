package stepDefinations;

import java.util.HashMap;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import modules.LogInAction;
import pageObjects.LoginPage;

public class GuruDemoSite {

	public WebDriver driver;

	public HashMap<String, String> data = Hooks.data;

	@Given("^I want to write a step with Launch the URLs$")
	public void i_want_to_write_a_step_with_Launch_the_URLs() throws Throwable {
		driver = Hooks.driver;
		driver.get("http://demo.guru99.com/V4/");
	}

	@When("^Login the site with Username$")
	public void login_the_site_with_USername() throws Throwable {
		PageFactory.initElements(driver, LoginPage.class);
		//driver.findElement(By.id("dfd"));
		LogInAction.execute(data);
	}

	@Then("^verify the status$")
	public void verify_the_status() throws Throwable {
		driver.switchTo().alert().accept();
		driver.close();
	}

}
