package pages;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver driver;
	
	/*WebElement email = driver.findElement(By.id("usernameInput-input"));
	WebElement password = driver.findElement(By.id("password-input"));
	WebElement signInButton = driver.findElement(By.id("signIn"));
	WebElement emailErr = driver.findElement(By.id("UsernameTextField__errors-usernameInput"));
	WebElement passwordErr = driver.findElement(By.id("PasswordTextField__errors-password"));
	WebElement globalErr = driver.findElement(By.id("globalError"));
	*/
	
	@FindBy(id = "usernameInput-input")
    public WebElement email;
	
	@FindBy(name = "password")
    public WebElement password;
	
	@FindBy(id = "signIn")
    public WebElement signInButton;
	
	@FindBy(id = "globalError")
    public WebElement globalErr;
	
	@FindBy(id = "UsernameTextField__errors-usernameInput")
    public WebElement emailErr;
	
	@FindBy(id = "PasswordTextField__errors-password")
    public WebElement passwordErr;
	public void openBrowser() throws IOException {
		
		FileInputStream fi = new FileInputStream("/Users/gamer/Desktop/QA/Selenium_WorkSpace/XLS_Project/src/prop.properties");
		Properties prop = new Properties();
		prop.load(fi);
		
		String browser = prop.getProperty("browser");
				
		if(browser.equals("Firefox")) {
			driver = new FirefoxDriver();
		}else if(browser.equals("Chrome")) {
			driver = new ChromeDriver();
		}else {
			driver = new SafariDriver();
		}
	
	PageFactory.initElements(driver, this);
	}
	public void closeBrowser() {
		driver.quit();
	}
	
	public void openLoginPage() {
		driver.get("https://auth.scotiaonline.scotiabank.com/online?oauth_key=P4yfdtnCr6M&oauth_key_signature=eyJraWQiOiJrUFVqdlNhT25GWUVDakpjMmV1MXJvNGxnb2VFeXJJb2tCbU1oX3BiZXNVIiwidHlwIjoiSldUIiwiYWxnIjoiUlMyNTYifQ.eyJyZWZlcmVyIjoiaHR0cHM6XC9cL3d3dy5nb29nbGUuY29tXC8iLCJvYXV0aF9rZXkiOiJQNHlmZHRuQ3I2TSIsImNvbnNlbnRfcmVxdWlyZWQiOmZhbHNlLCJyZWRpcmVjdF91cmkiOiJodHRwczpcL1wvd3d3LnNjb3RpYW9ubGluZS5zY290aWFiYW5rLmNvbVwvb25saW5lXC9sYW5kaW5nXC9vYXV0aGxhbmRpbmcuYm5zIiwiZXhwIjoxNjg3NjQwNTQxLCJpYXQiOjE2ODc2MzkzNDEsImp0aSI6ImIwNmEyN2M0LTUxMTMtNGEwNC05OWM2LWE3NWUxNjc2YWRhMCIsImNsaWVudF9pZCI6IjhlZTkwYzM5LTFjNTItNGZmNC04YWU2LWE3YjU0YzUzOTkzMyIsImNsaWVudF9tZXRhZGF0YSI6eyJDaGFubmVsSUQiOiJTT0wiLCJBcHBsaWNhdGlvbkNvZGUiOiJINyJ9LCJpc3N1ZXIiOiJodHRwczpcL1wvcGFzc3BvcnQuc2NvdGlhYmFuay5jb20ifQ.Q0cHfwaXbCRceVETGtyFu3eof3LV9-HHLNT3r64qt6V6awPxCAMrxxt4DbNJQeFauQ5LfqUoq2YszQQ_Ro7rb15UF-1wAImp45lVWLLyLfrx_eW6pMoRjML3bETNvX7oRmch72t1CuPkW7FuvCi4nU6c-S5qmRrzFPelCiHKAYIEMUSo1alHE6zNxghBtukAurr2GLmlqM2ahFp_G0z_1pq0UvARPqlKX1HgUL-ha22WQJQDYaf265U4sgo693SeIfX1Q_YdlqjfC4dvNn1qv3qISHWjUdjQGDR7J8-VftuWraazpTtoqNG8CaWxhXS46s2bcbPC5xG2HtKseMBcNg&preferred_environment=");
	 }
	
	public void login(String a, String b) throws InterruptedException {
		email.sendKeys(a);
		password.sendKeys(b);
		signInButton.click();
		Thread.sleep(2000);
	}
	
	public String readEmailErr() {
		String actualErr = emailErr.getText();
		System.out.println(actualErr);
		return actualErr;
	}
	
	public String readPasswordErr() {
		String actualErr =passwordErr.getText();
		System.out.println(actualErr);
		return actualErr;
	}
	
	public String readGlobalErr() {
		String actualErr =globalErr.getText();
		System.out.println(actualErr);
		return actualErr;
	
	}
}

