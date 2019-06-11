package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {


	@FindBy(xpath="//*[@name='uid']")
	public static WebElement userName;

	@FindBy(xpath="//*[@name='password']")
	public  static WebElement Password;


	@FindBy(xpath="//*[@name='btnLogin']")
	public  static WebElement submitButton;

}
