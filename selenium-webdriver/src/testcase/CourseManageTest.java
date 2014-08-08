package testcase;

import java.io.File;
import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.junit.*;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class CourseManageTest extends Base {

	@Test
	public void testUntitled2() throws Exception {
		String expectedCurrenturl="http://jw.ablesky.com/courseRedirect.do?action=toCourseList";
		driver.findElement(By.linkText("课程管理")).click();
		String actualCurrenturl = driver.getCurrentUrl();
		
		String title = driver.getTitle();
		System.out.println(title+"\n"+actualCurrenturl);
		assertEquals(expectedCurrenturl, actualCurrenturl);
		//截图并保存在D盘下
        File screenShotFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenShotFile, new File("D:/test.png"));
        
		driver.findElement(By.cssSelector("span.greenbtn25_text")).click();
		driver.findElement(By.id("courseName")).clear();
		driver.findElement(By.id("courseName")).sendKeys("ASF");
		driver.findElement(By.id("coursePrice")).clear();
		driver.findElement(By.id("coursePrice")).sendKeys("12");
		driver.findElement(By.id("J_tinyContainer")).clear();
		driver.findElement(By.id("J_tinyContainer")).sendKeys("苏打水大苏打");
		driver.findElement(By.cssSelector("span.bluebtn30_text")).click();
		driver.findElement(By.linkText("课程管理")).click();
		sleep();

	}

}
