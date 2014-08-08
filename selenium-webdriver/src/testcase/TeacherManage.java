package testcase;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class TeacherManage extends Base {

	@Test
	public void testUntitled5() throws Exception {
	
		driver.findElement(By.linkText("老师管理")).click();
		driver.findElement(By.cssSelector("span.greenbtn25_text")).click();
		driver.findElement(By.id("username")).clear();
		driver.findElement(By.id("username")).sendKeys("teacheyhjuyfgr0gjhgj");
		         
		driver.findElement(By.id("password")).clear();
		driver.findElement(By.id("password")).sendKeys("1234");
		driver.findElement(By.id("opassword")).clear();
		driver.findElement(By.id("opassword")).sendKeys("1234");
		driver.findElement(By.id("teachername")).clear(); 
		driver.findElement(By.id("teachername")).sendKeys("teacher001");
		new Select(driver.findElement(By.id("J_selPlatForm")))
				.selectByVisibleText("老师");
		driver.findElement(By.name("email")).clear();
		driver.findElement(By.name("email")).sendKeys("teacher001@163.com");
		driver.findElement(By.name("form-field")).click();
		driver.findElement(By.xpath("(//input[@name='form-field'])[2]"))
				.click();
		driver.findElement(By.xpath("(//input[@name='form-field'])[3]"))
				.click();
		driver.findElement(By.xpath("(//input[@name='form-field'])[7]"))
				.click();
		driver.findElement(By.cssSelector("span.bluebtn30_text")).click();

	}

}
