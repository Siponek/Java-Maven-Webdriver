package test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestClassA {
	
	// Initialize HERE the driver file locations as costant if you want
    // In the code do not use WebDriverManager but the System.setProperty()
	
	private WebDriver driver;
	private String baseUrl; // Use it if needed
	
	@BeforeAll
	public static void before_all() {
		// Fix the following setProperty() HERE with path to the driver
		System.setProperty("", "");
	}
	
	@BeforeEach
	public void before_each() {
		// Create the driver instance
		driver = new ChromeDriver();
	}
	
	@AfterEach
	public void afterEach() {
		// close Chrome Browser
		driver.quit();
	}

	@Test
	public void testA() throws Exception {
		// Example Test method()
    	// You have to insert here the test logics
	}
	
	@Test
	public void testB() throws Exception {
		// Example Test method()
    	// You have to insert here the test logics
	}
	
	@Test
	public void testC() throws Exception {
		// Example Test method()
    	// You have to insert here the test logics
	}
}

