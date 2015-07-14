package br.ufop.performance.checker.test;

import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverTest26_06 {
	private WebDriver driver;
	private String baseUrl;
	private StringBuffer verificationErrors = new StringBuffer();
	@Before
	public void setUp() throws Exception {
		driver = new FirefoxDriver();
		baseUrl = "http://fleury.sensedia.com";
		//driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@Test
	public void testWebDriverTest2606() throws Exception {
		
		//pegar estes passos para gerar cenario de teste em XML.
		
		driver.get(baseUrl + "/repository/main/home.jsf");
		driver.get(baseUrl + "/repository/access/login.jsf");
		driver.findElement(By.id("username")).clear();
		driver.findElement(By.id("username")).sendKeys("system");
		driver.findElement(By.id("password")).clear();
		driver.findElement(By.id("password")).sendKeys("manager");
		driver.findElement(By.id("submit")).click();
	
		driver.findElement(By.id("userText")).click();
		driver.findElement(By.id("userText")).clear();
		driver.findElement(By.id("userText")).sendKeys("tracker");
		driver.findElement(By.cssSelector("input[type=\"image\"]")).click();
		driver.findElement(By.linkText("tracker")).click();
		driver.findElement(By.id("counterForm:logout")).click();
		
		
		
		driver.get("www.google.com.br");
	}

	@After
	public void tearDown() throws Exception {
		//driver.quit();
		String verificationErrorString = verificationErrors.toString();
		if (!"".equals(verificationErrorString)) {
			fail(verificationErrorString);
		}
	}

	
}
