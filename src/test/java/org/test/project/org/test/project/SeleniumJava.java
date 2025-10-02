package org.test.project.org.test.project;

import java.time.Duration;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;


public class SeleniumJava {

	static WebDriver driver= null;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			driver=new ChromeDriver();
			Actions action=new Actions(driver);
			WebDriverWait wt=new WebDriverWait(driver,Duration.ofSeconds(60));
			JavascriptExecutor js = (JavascriptExecutor) driver;
			driver.get("https://demoqa.com/");
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

			String elementTab = "//h5[contains(text(),'Elements')]/../..";
			WebElement eleTab = driver.findElement(By.xpath(elementTab));
			js.executeScript("arguments[0].scrollIntoViewIfNeeded(true);", eleTab);
			eleTab.click();

			String textBox = "//span[contains(text(),'Text Box')]";
			WebElement textBoxClk=driver.findElement(By.xpath(textBox));
			textBoxClk.click();

			String fullName = "userName";
			WebElement fullNameSend = driver.findElement(By.id(fullName));
			action.scrollToElement(fullNameSend);
			fullNameSend.sendKeys("Neelesh Gupta");

			String email = "neelesh.gupta@text.com";
			WebElement emailSend = driver.findElement(By.id("userEmail"));
			emailSend.sendKeys(email);

			String currentAdd = "Bangalore India";
			WebElement currentAddSend=driver.findElement(By.id("currentAddress"));
			currentAddSend.sendKeys(currentAdd);

			String permanentAdd = "Bangalore India";
			WebElement permanentAddSend = driver.findElement(By.id("permanentAddress"));
			permanentAddSend.sendKeys(permanentAdd);

			WebElement submitBtn=driver.findElement(By.xpath("//*[@id='submit']"));
			js.executeScript("arguments[0].scrollIntoView(true);", submitBtn);
			submitBtn.click();
			
			WebElement emailVerification=driver.findElement(By.xpath("//p[@id='email']"));
			String emailValue = emailVerification.getText().split(":")[1];
			Assert.assertEquals(email,emailValue,"Values are not matching");
		}
		catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
		finally {
			driver.quit();
		}
	}

}
