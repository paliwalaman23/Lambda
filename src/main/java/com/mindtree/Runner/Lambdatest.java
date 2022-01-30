
package com.mindtree.Runner;

import org.testng.annotations.Test;

import com.mindtree.utility.RetreiveExcelData;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.Parameters;

public class Lambdatest {

	public RemoteWebDriver driver = null;
	String username = "Aman.Paliwal";
	String accessKey = "x0KhmgGUDweSu263P1eRHWonJdrHCzMUfuSULaNveRzIaBwMga";

	// @BeforeTest
	public void setUp(String BrowserType, String Version, String OS, String TestName) throws Exception {

		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("browserName", BrowserType);
		capabilities.setCapability("version", Version);
		capabilities.setCapability("platform", OS);
		capabilities.setCapability("resolution", "1024x768");
		capabilities.setCapability("build", "First Build");
		capabilities.setCapability("name", TestName);
		capabilities.setCapability("network", true); // To enable network logs
		capabilities.setCapability("visual", true); // To enable step by step screenshot
		capabilities.setCapability("video", true); // To enable video recording
		capabilities.setCapability("console", true); // To capture console logs

		try {
			driver = new RemoteWebDriver(
					new URL("https://" + username + ":" + accessKey + "@hub.lambdatest.com/wd/hub"), capabilities);
		} catch (MalformedURLException e) {
			System.out.println("Invalid grid URL");
		}
	}

	@Test
	public void Test1() throws Exception {
		try {

			ArrayList<String> data1 = RetreiveExcelData.getData("Chrome");

			setUp(data1.get(0), data1.get(1), data1.get(2), "First Test");
			driver.get("https://www.lambdatest.com/selenium-playground/");
			driver.findElement(By.linkText("Simple Form Demo")).click();
			driver.findElement(By.linkText("Simple Form Demo")).getText();
			if (driver.findElement(By.linkText("Simple Form Demo")).getText().equalsIgnoreCase("Simple Form Demo")) {
				Assert.assertTrue(true);
			} else
				Assert.assertTrue(false);

			String str = "Welcome To Lambda";
			driver.findElement(By.id("user-message")).sendKeys(str);
			driver.findElement(By.id("showInput")).click();
			if (driver.findElement(By.id("message")).getText().equalsIgnoreCase(str)) {
				Assert.assertTrue(true);
			} else {
				Assert.assertTrue(false);
			}
			driver.quit();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}

	@Test
	public void Test2() throws Exception {
		try {

			ArrayList<String> data2 = RetreiveExcelData.getData("Internet Explorer");

			setUp(data2.get(0), data2.get(1), data2.get(2), "Second Test");
			driver.get("https://www.lambdatest.com/selenium-playground/");
			driver.findElement(By.linkText("Drag & Drop Sliders")).click();
			WebElement slider = driver.findElement(By.xpath("//*[@value='15']"));

			for (int i = 1; i <= 80; i++) {
				slider.sendKeys(Keys.ARROW_RIGHT);
			}
			if (driver.findElement(By.xpath("//*[text()='95']")).getText().equals("95"))
				Assert.assertTrue(true);
			else
				Assert.assertTrue(false);

			driver.quit();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}

	@Test
	public void Test3() throws Exception {
		try {

			ArrayList<String> data3 = RetreiveExcelData.getData("MicrosoftEdge");

			setUp(data3.get(0), data3.get(1), data3.get(2), "Third Test");
			driver.get("https://www.lambdatest.com/selenium-playground/");
			driver.findElement(By.xpath("//*[@class='cookie__bar__close hover:underline smtablet:hidden']")).click();
			Thread.sleep(3000);

			driver.findElement(By.xpath("//*[@href='https://www.lambdatest.com/selenium-playground/input-form-demo']"))
					.click();
			Thread.sleep(3000);

			driver.findElement(By.xpath("//*[@type='submit']")).click();
			driver.findElement(By.id("name")).sendKeys("Jack");
			driver.findElement(By.id("inputEmail4")).sendKeys("Jack@gmail.com");
			driver.findElement(By.id("inputPassword4")).sendKeys("Jack@123");
			driver.findElement(By.id("company")).sendKeys("Lambda");
			driver.findElement(By.id("websitename")).sendKeys("Lambda.com");
			driver.findElement(By.id("websitename")).sendKeys("Lambda.com");
			driver.findElement(By.xpath("//*[@name='country']")).click();

			driver.findElement(By.xpath("//*[text()='United States']")).click();
			driver.findElement(By.id("inputCity")).sendKeys("London");
			driver.findElement(By.id("inputAddress1")).sendKeys("Alisha Heights");
			driver.findElement(By.id("inputAddress2")).sendKeys("Plot No 01");
			driver.findElement(By.id("inputState")).sendKeys("New York");
			driver.findElement(By.id("inputZip")).sendKeys("007007");
			driver.findElement(By.xpath("//*[text()='Submit']")).click();

			if (driver.findElement(By.xpath("//*[@class='success-msg hidden']")).getText()
					.equalsIgnoreCase("Thanks for contacting us, we will get back to you shortly."))
				Assert.assertTrue(true);
			else
				Assert.assertTrue(false);

			driver.quit();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}

}