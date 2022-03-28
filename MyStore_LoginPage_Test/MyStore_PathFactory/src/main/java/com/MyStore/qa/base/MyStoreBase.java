package com.MyStore.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.MyStore.qa.util.MyStoreUtil;

public class MyStoreBase {
	public static Properties prop;
	public static WebDriver driver;

	public MyStoreBase() {

		try {
			prop = new Properties();
			FileInputStream ip= new FileInputStream("C:\\Users\\dhruv\\eclipse-workspace\\myproject\\bin\\MyStore_PathFactory"
					+ "\\src\\main\\java\\com\\MyStore\\qa\\config\\config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}


	public static void initialization() {

		String browsername= prop.getProperty("browser");

		if (browsername.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\dhruv\\ChromeDriver\\chromedriver.exe");

			driver= new ChromeDriver();

		}
		else if (browsername.equals("Firefox")) {
			System.setProperty("webdriver.gecko.driver","C:\\Users\\dhruv\\geckodriver\\geckodriver.exe");

			driver = new FirefoxDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(MyStoreUtil.PageLoad_Timeout, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(MyStoreUtil.Implicit_Wait, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
	}
	

}
