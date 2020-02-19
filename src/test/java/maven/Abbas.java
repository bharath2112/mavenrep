package maven;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class Abbas {
	
	@Parameters({"username","password"})
	@Test
	private void test3(String s1,String s2) throws Exception {
System.setProperty("webdriver.chrome.driver", "C:\\Users\\shalom daniel\\eclipse-workspace\\Maven\\div\\chromedriver.exe");
WebDriver dr=new ChromeDriver();
dr.get("https://accounts.google.com//");
WebElement user = dr.findElement(By.id("identifierId"));
user.sendKeys(s1);
WebElement nxt = dr.findElement(By.xpath("//span[text()='Next']"));
nxt.click();
Thread.sleep(2000);


WebElement pass = dr.findElement(By.xpath("(//input[@class='whsOnd zHQkBf'])[1]"));
pass.sendKeys(s2);
dr.findElement(By.xpath("//span[text()='Next']")).click();
	}
	
}
