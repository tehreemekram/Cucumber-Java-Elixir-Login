package StepDefinitions;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.*;

public class PlutoLoginSteps {

	WebDriver driver = null;
	
	@Given("browser is open")
	public void browser_is_open() {
		
		System.out.println("Inside -- Browser is open");
		System.getProperty("webdriver.chrome.driver", "/CucumberJava/src/test/resources/drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		
//		driver.manage().window().maximize();
		
	}

	@Given("user is on login page")
	public void user_is_on_login_page() {
		driver.navigate().to("https://labs.octdaily.com/public/login");
		
	}

	@When("user enters username and password")
	public void user_enters_username_and_password() throws InterruptedException {
		driver.findElement(By.name("username")).sendKeys("hafsazafar");
		driver.findElement(By.name("password")).sendKeys("123456");

		Thread.sleep(2000);
	}
	
	@And("user clicks on login")
	public void user_clicks_on_login() {
		
		driver.findElement(By.cssSelector(".waves-effect.waves-light.btn.btn-danger.mb-5")).click();

	}

	@Then("user is navigated to the home page")
	public void user_is_navigated_to_the_home_page() throws InterruptedException {
		driver.findElement(By.className("mat-mdc-button-touch-target")).isDisplayed();

		Thread.sleep(2000);
//	    driver.close();
//	    driver.quit();
	}
	
	@When("user clicks on logout")
	public void user_clicks_on_logout() {
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	    // Step 1: Click on the user profile drop down
	    By profileDropdown = By.cssSelector(".dropdown.user.user-menu > a");
	    wait.until(ExpectedConditions.elementToBeClickable(profileDropdown)).click();

	    // Step 2: Wait for the Logout button and click it
	    By logoutButton = By.xpath("//a[contains(text(),'Logout')]");
	    wait.until(ExpectedConditions.elementToBeClickable(logoutButton)).click();
	}

	
	@Then("user is navigated back to the login page")
	public void user_is_navigated_back_to_the_login_page() {
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    wait.until(ExpectedConditions.urlContains("public/login"));
	}
	
	@And("close the browser")
	public void close_the_browser() {
	    if (driver != null) {
	        driver.close();  // Closes the current tab
	        driver.quit();   // Closes the entire browser session
	    }
	}

}
