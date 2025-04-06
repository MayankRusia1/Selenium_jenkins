package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageObjectClass 
{
	WebDriver driver;

	public PageObjectClass(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id="txt-username")
	WebElement email;

	@FindBy(xpath = "//input[@id='txt-password' and @type='password']")
	WebElement password;

	@FindBy(css = "button#btn-login[type='submit']")
	WebElement loginBtn;

	@FindBy(xpath = "//a[@id='menu-toggle']")
	WebElement menu_toggle;

	@FindBy(linkText = "Logout")
	WebElement logoutBtn;

	public void enterCredentials(String emailString, String passwordString)
	{
		email.sendKeys(emailString);
		password.sendKeys(passwordString);
	}

	public void clickLoginBtn()
	{
		loginBtn.click();
	}

	public boolean verifyLogoutPresent(WebDriver driver)
	{
		Actions actions = new Actions(driver);
		actions.moveToElement(menu_toggle).click().build().perform();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
		boolean result = logoutBtn.isDisplayed();
		return result;
	}
}
