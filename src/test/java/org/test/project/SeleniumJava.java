package org.test.project;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.test.project.org.test.project.BaseClass;
import org.testng.Assert;
import org.testng.annotations.Test;


import com.aventstack.extentreports.Status;


public class SeleniumJava extends BaseClass {

	@Test  
	public void firstTestCase(){
		
		try {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--headless=new");
		options.addArguments("--no-sandbox");
		options.addArguments("--disable-dev-shm-usage");
		driver=new ChromeDriver(options);
		Actions action=new Actions(driver);
		WebDriverWait wt=new WebDriverWait(driver,Duration.ofSeconds(60));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		driver.manage().window().maximize();
		driver.navigate().to("https://demoqa.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		String elementTab = "//h5[contains(text(),'Elements')]/../..";
		WebElement eleTab = driver.findElement(By.xpath(elementTab));
		//action.scrollToElement(eleTab);
		js.executeScript("arguments[0].scrollIntoViewIfNeeded(true);", eleTab);
		wt.until(ExpectedConditions.elementToBeClickable(eleTab));
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
		action.scrollToElement(submitBtn);
		js.executeScript("arguments[0].scrollIntoView(true);", submitBtn);
		wt.until(ExpectedConditions.elementToBeClickable(submitBtn));
		submitBtn.click();

		WebElement emailVerification=driver.findElement(By.xpath("//p[@id='email']"));
		String emailValue = emailVerification.getText().split(":")[1];
		Assert.assertEquals(email,emailValue,"Values are not matching");
		test.log(Status.INFO,"This testcase is passed");
		}catch(Exception ex) {
			System.out.println(ex.getMessage());
			System.out.println("This is just to push the event and check github pipeline is triggered or not");
		}
	}

	@Test  
	public void secondTestCase(){
		try {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--headless=new");
		options.addArguments("--no-sandbox");
		options.addArguments("--disable-dev-shm-usage");
		driver=new ChromeDriver(options);
		Actions action=new Actions(driver);
		WebDriverWait wt=new WebDriverWait(driver,Duration.ofSeconds(60));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		driver.manage().window().maximize();
		driver.navigate().to("https://demoqa.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		String elementTab = "//h5[contains(text(),'Elements')]/../..";
		WebElement eleTab = driver.findElement(By.xpath(elementTab));
		//action.scrollToElement(eleTab);
		js.executeScript("arguments[0].scrollIntoViewIfNeeded(true);", eleTab);
		wt.until(ExpectedConditions.elementToBeClickable(eleTab));
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
		action.scrollToElement(submitBtn);
		js.executeScript("arguments[0].scrollIntoView(true);", submitBtn);
		wt.until(ExpectedConditions.elementToBeClickable(submitBtn));
		submitBtn.click();

		WebElement emailVerification=driver.findElement(By.xpath("//p[@id='email']"));
		String emailValue = emailVerification.getText().split(":")[1];
		Assert.assertEquals(email,emailValue,"Values are not matching");
		test.log(Status.INFO,"This testcase is passed");
		}catch(Exception ex) {
			System.out.println(ex.getMessage());
			System.out.println("Jenkins pipeline updated github");
		}
	}
}
