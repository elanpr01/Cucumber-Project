package modules;

import java.util.HashMap;

import com.cucumber.listener.Reporter;

import helper.Log;
import pageObjects.LoginPage;

public class LogInAction {

	public static void execute(HashMap<String,String> map)
	{
		Log.startTestCase();
		Log.info("Login Action perfomed");
		LoginPage.userName.sendKeys(map.get("username"));
		LoginPage.Password.sendKeys(map.get("password"));
		LoginPage.submitButton.click();
		Reporter.addStepLog("Logged In successfully");
		Log.endTestCase();

	}

}
