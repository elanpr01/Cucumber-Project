package stepDefinations;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.cucumber.listener.Reporter;
import com.google.common.io.Files;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import helper.DataLoader;

public class Hooks {
	public static WebDriver driver;
	public static HashMap<String, String> data;
	@Before
	public void BeforeSteps(Scenario scenario) {
		/*
		 * What all you can perform here Starting a webdriver Setting up DB connections
		 * Setting up test data Setting up browser cookies Navigating to certain page or
		 * anything before the test
		 */

		String[] TestCasName = scenario.getName().split(" ");
		System.out.println(TestCasName[0]);
		data = DataLoader.data(TestCasName[0]);
		System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();

	}

	@After
	public void AfterSteps(Scenario scenario) {
		if (scenario.isFailed()) {
			try {
				TakesScreenshot scrShot = ((TakesScreenshot) driver);
				String screenshotName = scenario.getName().replaceAll(" ", "_");
				File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);
				File DestFile = new File(System.getProperty("user.dir") + "/screenshots/"
						+ screenshotName + ".png");
				Files.copy(SrcFile, DestFile);
				Reporter.addScreenCaptureFromPath(DestFile.toString());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
