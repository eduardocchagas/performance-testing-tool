package br.ufop.performance.checker.test;

import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FleuryRepositoryCen1Test {
	private WebDriver driver;
	private String baseUrl;
	private StringBuffer verificationErrors = new StringBuffer();
	@Before
	public void setUp() throws Exception {
		driver = new FirefoxDriver();
		baseUrl = "http://fleury.sensedia.com/";
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@Test
	public void testFleuryRepositoryCen1() throws Exception {
		driver.get(baseUrl + "/repository/access/login.jsf");
		driver.findElement(By.id("username")).clear();
		driver.findElement(By.id("username")).sendKeys("system");
		driver.findElement(By.id("password")).clear();
		driver.findElement(By.id("password")).sendKeys("manager");
		driver.findElement(By.id("submit")).click();
		driver.findElement(By.id("userText")).click();
		driver.findElement(By.id("userText")).clear();
		driver.findElement(By.id("userText")).sendKeys("track");
		driver.findElement(By.cssSelector("div.description")).click();
		driver.findElement(By.id("counterForm:logout")).click();
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
		String verificationErrorString = verificationErrors.toString();
		if (!"".equals(verificationErrorString)) {
			fail(verificationErrorString);
		}
	}

	
}
