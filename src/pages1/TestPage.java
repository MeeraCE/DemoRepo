package pages1;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TestPage {

	WebDriver driver;
	
	/*public WebElement email = driver.findElement(By.id("usernameInput-input"));
	public WebElement password = driver.findElement(By.name("password"));
	public WebElement signIn = driver.findElement(By.id("signIn"));
	public WebElement emailErr = driver.findElement(By.id("UsernameTextField__errors-usernameInput"));
	public WebElement passwordErr = driver.findElement(By.id("PasswordTextField__errors-password"));
	public WebElement globalErr = driver.findElement(By.id("globalError"));*/
	
	@FindBy(id = "usernameInput-input")
    public WebElement email;
	
	@FindBy(name = "password")
    public WebElement password;
	
	@FindBy(id = "signIn")
    public WebElement signIn;
	
	@FindBy(id = "globalError")
    public WebElement globalErr;
	
	@FindBy(id = "UsernameTextField__errors-usernameInput")
    public WebElement emailErr;
	
	@FindBy(id = "PasswordTextField__errors-password")
    public WebElement passwordErr;
	
	public void openbrowser() throws IOException {
		
		FileInputStream f = new FileInputStream("C:\\QA\\Testing\\prop.properties");
		Properties prop = new Properties();
		prop.load(f);
		
		System.out.println(prop.getProperty("browser"));
		String browser = prop.getProperty("browser");
		
		if(browser.equals("Firefox")) {
			driver = new FirefoxDriver(); 	
		}else if(browser.equals("Chrome")){
			driver = new ChromeDriver(); 
		}else {
			driver = new SafariDriver();
		}
		PageFactory.initElements(driver, this);

	}
	
	public void openloginpage() {
		
		driver.get("https://auth.scotiaonline.scotiabank.com/online?oauth_key=W7FSaBhgYfQ&oauth_key_signature=eyJraWQiOiJrUFVqdlNhT25GWUVDakpjMmV1MXJvNGxnb2VFeXJJb2tCbU1oX3BiZXNVIiwidHlwIjoiSldUIiwiYWxnIjoiUlMyNTYifQ.eyJyZWZlcmVyIjoiaHR0cHM6XC9cL3d3dy5zY290aWFiYW5rLmNvbVwvIiwib2F1dGhfa2V5IjoiVzdGU2FCaGdZZlEiLCJjb25zZW50X3JlcXVpcmVkIjpmYWxzZSwicmVkaXJlY3RfdXJpIjoiaHR0cHM6XC9cL3d3dy5zY290aWFvbmxpbmUuc2NvdGlhYmFuay5jb21cL29ubGluZVwvbGFuZGluZ1wvb2F1dGhsYW5kaW5nLmJucyIsImV4cCI6MTY2ODM3MzEyMywiaWF0IjoxNjY4MzcxOTIzLCJqdGkiOiJiMjYxZTY1My0wOTY2LTQ5YTEtOWRiZC1lZjA2MjJhYmI0Y2EiLCJjbGllbnRfaWQiOiI4ZWU5MGMzOS0xYzUyLTRmZjQtOGFlNi1hN2I1NGM1Mzk5MzMiLCJjbGllbnRfbWV0YWRhdGEiOnsiQ2hhbm5lbElEIjoiU09MIiwiQXBwbGljYXRpb25Db2RlIjoiSDcifSwiaXNzdWVyIjoiaHR0cHM6XC9cL3Bhc3Nwb3J0LnNjb3RpYWJhbmsuY29tIn0.vHCADYaFYkwIKcOwS2FlzHzPjZZ7Wdk9rSBpL50oXV__ElwaUS3ZZvkziKHo2qrrnzLsfFwUHGs1pSE7N76wE0T6Gq6pAmEr0Ouejs3aqxlxuslhY3u8UOiTEAWcP_IlRm52N-MuLhdLiYjaiZN3AbAeR3pONVTz3T2aOrA-O_VKCdsJw-Gu-wZ1nBJ1qqFK-2VbsfZ-6OnKOybJlEThHhdaREHbnsAk9R4f2y49sK8OqGV-VGQq7YV1zwRJ6CatJ7OPiLHWv_szagHVXabJtW5X4n_x8-q2g6qvM2K4TtyUccIiGYd5rTfxpj6IJHmxnbvRUAA42Dhv41DBkqmP_Q&preferred_environment=");
	}
	
	public void closebrowser() {
		
		 driver.quit();
	}
	
	public void login(String a, String b) throws InterruptedException {
		
		email.sendKeys(a);
		password.sendKeys(b);
		signIn.click();
		Thread.sleep(2000);
	}
	
	public String readEmailError() {
		
		String actualErr = emailErr.getText();
	    System.out.println(actualErr);
	    return actualErr;
	}
	
	public String readPasswordError() {
		
		String actualErr = passwordErr.getText();
	    System.out.println(actualErr);
	    return actualErr;
	}
	
	public String readGlobalError() {
		
		String actualErr = globalErr.getText();
	    System.out.println(actualErr);
		return actualErr;
		
	}

	
}
