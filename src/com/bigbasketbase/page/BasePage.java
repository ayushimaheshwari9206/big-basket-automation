package com.bigbasketbase.page;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class BasePage {

	public static WebDriver driver = null;
	public static Properties Config = null;
	public static Properties OR = null;

	
	public BasePage() throws IOException {

		// Browser implementation
		if (driver == null) {
			FileInputStream fileInput = new FileInputStream(
					System.getProperty("user.dir")
							+ "\\src\\com\\bigbasketconfig\\property\\Config.properties");
			Config = new Properties();
			Config.load(fileInput);

			fileInput = new FileInputStream(System.getProperty("user.dir")
					+ "\\src\\com\\bigbasketconfig\\property\\OR.properties");
			OR = new Properties();
			OR.load(fileInput);

			if (Config.getProperty("browser").equals("FIREFOX")) {
				System.setProperty("webdriver.gecko.driver",
						System.getProperty("user.dir")
								+ "\\geckodriver.exe");
				driver = new FirefoxDriver();
				System.out
						.println("Browser - Firefox is opened for the current session,do not close this brwoser till the test is finished.");
			} else if (Config.getProperty("browser").equals("CHROME")) {
				System.setProperty("webdriver.chrome.driver",
						System.getProperty("user.dir")
								+ "\\chromedriver.exe");
				driver = new ChromeDriver();
				System.out
						.println("Browser - Chrome is opened for the current session,do not close this brwoser till the test is finished.");
			} else if (Config.getProperty("browser").equals("IEEXPLORE")) {
				driver = new InternetExplorerDriver();
				System.out
						.println("Browser - IE is opened for the current session,do not close this brwoser till the test is finished.");
			}
		}
		
		driver.get(Config.getProperty("BaseUrl"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

	}


	// click an element
	public void elementClick(String XpathKey) {
		try {
			driver.findElement(By.xpath(OR.getProperty(XpathKey))).click();
		} catch (Exception e) {
			System.out.println("Not able to click due to = " + e.getMessage());
		}
	}


}
