package com.assessment.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeSuite;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public static Properties prop;
	public static WebDriver driver;
	private final int BROWSER_WAIT_MILLISECONDS = 2000;

	@BeforeSuite
	public void LoadConfigurations() {
		try {
			prop = new Properties();
			FileInputStream fis = new FileInputStream(
					(System.getProperty("user.dir") + "/Resources/config.properties"));
			prop.load(fis);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static WebDriver driver() {
		return driver;

	}

	public void LaunchBrowser(String browserName, String url) {
		browserName = browserName.toLowerCase();
		switch (browserName) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;
		case "edge":
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			break;
		default:
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;
		}
		driver().manage().deleteAllCookies();
		driver().navigate().to(prop.getProperty("baseUrl") + "/" + url);
		driver().manage().window().maximize();
		driver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}

	public void waitBeforeClosingBrowser() throws InterruptedException {
		Thread.sleep(BROWSER_WAIT_MILLISECONDS);
	}

}
