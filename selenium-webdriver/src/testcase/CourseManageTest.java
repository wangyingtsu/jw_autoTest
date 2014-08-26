package testcase;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.junit.*;

import static org.junit.Assert.*;

import org.openqa.selenium.*;

public class CourseManageTest extends Base {
	/**
	 * 1.正常添加课程 
	 * 2.正常 删除课程
	 */
	// @Test
	public void createCouse() throws Exception {

		String expectedCurrenturl = "http://jw.ablesky.com/courseRedirect.do?action=toCourseList";
		String coursename = "测试课程-语文";

		driver.findElement(By.linkText("课程管理")).click();

		String actualCurrenturl = driver.getCurrentUrl();
		String title = driver.getTitle() + "  课程管理";
		System.out.println(title + "\n" + actualCurrenturl);
		assertEquals(expectedCurrenturl, actualCurrenturl);

		driver.findElement(By.cssSelector("span.greenbtn25_text")).click();
		driver.findElement(By.id("courseName")).clear();
		driver.findElement(By.id("courseName")).sendKeys(coursename);
		driver.findElement(By.id("coursePrice")).clear();
		driver.findElement(By.id("coursePrice")).sendKeys("12");
		driver.findElement(By.id("J_tinyContainer")).clear();
		driver.findElement(By.id("J_tinyContainer")).sendKeys("语文课——测试课程");
		driver.findElement(By.cssSelector("span.bluebtn30_text")).click();
		driver.findElement(By.linkText("课程管理")).click();

		driver.findElement(By.cssSelector("a.current")).click();
		driver.findElement(By.linkText("修改")).click();
		// 截图并保存在D盘下
		File screenShotFile = ((TakesScreenshot) driver)
				.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenShotFile, new File(
				"D:/auto_test/createCourse/createCourse.png"));
		String realCourse = driver.findElement(By.id("courseName"))
				.getAttribute("value");
		sleep();
		assertEquals(coursename, realCourse);

		driver.findElement(By.cssSelector("span.bluebtn30_text")).click();// 保存

		driver.findElement(By.cssSelector("a.current")).click();
		driver.findElement(By.linkText("删除")).click();
		driver.findElement(By.cssSelector("button[type=\"button\"]")).click();
		sleep();

	}

	/**
	 * 课程标题输入超过100字，提示信息：“最多100位字符”
	 * 
	 */
	//@Test
	public void createCourseForTitletoolong() throws IOException {
		String errorCourseName = "噶尽快发货卡机啥的和反馈阿道夫凯撒的恢复快接电话发快件萨丹哈反馈电话费会计师的恢复会计"
				+ "师电话费课件是电话费可接受的回复空间萨丹哈反馈奥斯卡回复会计啥的和反馈盛大和罚款坚实的发货快的看法和卡仕达福克斯的恢复快的生活费";
		String formalName = "数学课——测试";
		String expectedErrorMessage = "最多100位字符";
		driver.findElement(By.linkText("课程管理")).click();
		sleep();
		driver.findElement(By.cssSelector("span.greenbtn25_text")).click();
		driver.findElement(By.id("courseName")).clear();
		driver.findElement(By.id("courseName")).sendKeys(errorCourseName);
		driver.findElement(By.cssSelector("span.bluebtn30_text")).click();

		// 截图并保存在D盘下
		File screenShotFile = ((TakesScreenshot) driver)
				.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenShotFile, new File(
				"D:/auto_test/createCourse/createCourseForTitletoolong.png"));
		String errorMessage = driver
				.findElement(
						By.xpath(".//*[@id='#J_createCourse']/tbody/tr[1]/td[2]/div/label[2]"))
				.getText();

		assertEquals(expectedErrorMessage, errorMessage);
		System.out.println("当课程题目超过100个字符时提示： " + errorMessage);
		driver.findElement(By.id("courseName")).clear();
		driver.findElement(By.id("courseName")).sendKeys(formalName);
		driver.findElement(By.cssSelector("span.bluebtn30_text")).click();// 确定按钮

		// 删除测试课程
		driver.findElement(By.cssSelector("a.current")).click();
		driver.findElement(By.linkText("删除")).click();
		driver.findElement(By.cssSelector("button[type=\"button\"]")).click();
		sleep();
	}

	/**
	 * 
	 * 课程简介输入超过500字时提示：“课程简介超过500字”
	 * 
	 */
	//@Test
	public void createcourseFordescriptionOvertoolong() throws IOException {
		String courseName="英语课——测试";
		String coursePrice="100";
		String errorCourseDescription = "与规范和发挥规范和规范化规范回归和规范和符合规范和规范和发挥复合肥与规范和发挥规范和规范化规范回归和规范和符合规范和规范和发挥复合肥与规范和发挥规范和规范化规范回归和规范和符合规范和规范和发挥复合肥与规范和发挥规范和规范化规范回归和规范和符合规范和规范和发挥复合肥与规范和发挥规范和规范化规范回归和规范和符合规范和规范和发挥复合肥与规范和发挥规范和规范化规范回归和规范和符合规范和规范和发挥复合肥与规范和发挥规范和规范化规范回归和规范和符合规范和规范和发挥复合肥与规范和发挥规范和规范化规范回归和规范和符合规范和规范和发挥复合肥与规范和发挥规范和规范化规范回归和规范和符合规范和规范和发挥复合肥与规范和发挥规范和规范化规范回归和规范和符合规范和规范和发挥复合肥与规范和发挥规范和规范化规范回归和规范和符合规范和规范和发挥复合肥与规范和发挥规范和规范化规范回归和规范和符合规范和规范和发挥复合肥与规范和发挥规范和规范化规范回归和规范和符合规范和规范和发挥复合肥与规范和发挥规范和规范化规范回归和规范和符合规范和规范和发挥复合肥与规范和发挥规范和规范化规范回归和规范和符合规范和规范和发挥复合肥与规范和发挥规范和规范化规范回归和规范和符合规范和规范和发挥复合肥与规范和发挥规范和规范化规范回归和规范和符合规范和规范和发挥复合肥与规范和发挥规范和规范化规范回归和规范和符合规范和规范和发挥复合肥与规范和发挥规范和规范化规范回归和规范和符合规范和规范和发挥复合肥与规范和发挥规范和规范化规范回归和规范和符合规范和规范和发挥复合肥与规范和发挥规范和规范化规范回归和规范和符合规范和规范和发挥复合肥与规范和发挥规范和规范化规范回归和规范和符合规范和规范和发挥复合肥与规范和发挥规范和规范化规范回归和规范和符合规范和规范和发挥复合肥与规范和发挥规范和规范化规范回归和规范和符合规范和规范和发挥复合肥与规范和发挥规范和规范化规范回归和规范和符合规范和规范和发挥复合肥与规范和发挥规范和规范化规范回归和规范和符合规范和规范和发挥复合肥与规范和发挥规范和规范化规范回归和规范和符合规范和规范和发挥复合肥与规范和发挥规范和规范化规范回归和规范和符合规范和规范和发挥复合肥与规范和发挥规范和规范化规范回归和规范和符合规范和规范和发挥复合肥与规范和发挥规范和规范化规范回归和规范和符合规范和规范和发挥复合肥与规范和发挥规范和规范化规范回归和规范和符合规范和规范和发挥复合肥与规范和发挥规范和规范化规范回归和规范和符合规范和规范和发挥复合肥与规范和发挥规范和规范化规范回归和规范和符合规范和规范和发挥复合肥与规范和发挥规范和规范化规范回归和规范和符合规范和规范和发挥复合肥与规范和发挥规范和规范化规范回归和规范和符合规范和规范和发挥复合肥与规范和发挥规范和规范化规范回归和规范和符合规范和规范和发挥复合肥与规范和发挥规范和规范化规范回归和规范和符合规范和规范和发挥复合肥与规范和发挥规范和规范化规范回归和规范和符合规范和规范和发挥复合肥";
		String formalDescription = "与规范和发挥规范和规范化规范回归和规范和符合规范和规范和发";
		String expectedErrorMessage = "最多500位字符";
		driver.findElement(By.linkText("课程管理")).click();
		sleep();
		driver.findElement(By.cssSelector("span.greenbtn25_text")).click();
		driver.findElement(By.id("courseName")).clear();
		driver.findElement(By.id("courseName")).sendKeys(courseName);
		driver.findElement(By.id("coursePrice")).clear();
		driver.findElement(By.id("coursePrice")).sendKeys(coursePrice);
		driver.findElement(By.id("J_tinyContainer")).clear();
		driver.findElement(By.id("J_tinyContainer")).sendKeys(errorCourseDescription);
		
		driver.findElement(By.cssSelector("span.bluebtn30_text")).click();
		

		// 截图并保存在D盘下
		File screenShotFile = ((TakesScreenshot) driver)
				.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenShotFile, new File(
				"D:/auto_test/createCourse/createcourseFordescriptionOvertoolong.png"));
		String actulerrorMessage = driver
				.findElement(
						By.xpath(".//*[@id='#J_createCourse']/tbody/tr[3]/td[2]/label"))
				.getText();

		assertEquals(expectedErrorMessage, actulerrorMessage);
		System.out.println("当课程描述超过500个字符时提示： " + actulerrorMessage);
		driver.findElement(By.id("J_tinyContainer")).clear();
		driver.findElement(By.id("J_tinyContainer")).sendKeys(formalDescription);
		driver.findElement(By.cssSelector("span.bluebtn30_text")).click();// 确定按钮

		// 删除测试课程
		driver.findElement(By.cssSelector("a.current")).click();
		driver.findElement(By.linkText("删除")).click();
		driver.findElement(By.cssSelector("button[type=\"button\"]")).click();
		sleep();

	}

	/**
	 * 课程价格不能超过1000000元
	 */
	//@Test
	public void createcourseForPricetoohigh() throws IOException {
		String courseName="英语课——测试";
		String formalcoursePrice="100";
		String errorCoursePrice="1000001";
		String expectedErrorMessage = "课程价格不能超过1000000元";
		driver.findElement(By.linkText("课程管理")).click();
		sleep();
		driver.findElement(By.cssSelector("span.greenbtn25_text")).click();
		driver.findElement(By.id("courseName")).clear();
		driver.findElement(By.id("courseName")).sendKeys(courseName);
		driver.findElement(By.id("coursePrice")).clear();
		driver.findElement(By.id("coursePrice")).sendKeys(errorCoursePrice);
		
		driver.findElement(By.cssSelector("span.bluebtn30_text")).click();
		

		// 截图并保存在D盘下
		File screenShotFile = ((TakesScreenshot) driver)
				.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenShotFile, new File(
				"D:/auto_test/createCourse/createcourseForPricetoohigh.png"));
		String actulerrorMessage = driver
				.findElement(
						By.xpath("html/body/div[4]/div[2]/section/div/div"))
				.getText();

		assertEquals(expectedErrorMessage, actulerrorMessage);
		System.out.println("当课程价格超过1000000元时提示： ： " + actulerrorMessage);
		driver.findElement(By.id("coursePrice")).clear();
		driver.findElement(By.id("coursePrice")).sendKeys(formalcoursePrice);
		driver.findElement(By.cssSelector("span.bluebtn30_text")).click();// 确定按钮

		// 删除测试课程
		driver.findElement(By.cssSelector("a.current")).click();
		driver.findElement(By.linkText("删除")).click();
		driver.findElement(By.cssSelector("button[type=\"button\"]")).click();
		sleep();

	}
	
	/**
	 * 批量导入课程
	 */
	@ Ignore
	public void importCourseByexcel(){
		
	}
	
	
	
	
	/**
	 * 导出excel文件
	 */
	@Ignore
	public void exportCourseByExcel(){
		
	}
	
	
	/**
	 * 检查页面各个按钮及按钮状态
	 */
	@Test
	public void checkbuttonsState(){
		//检查添加按钮
		String expdaddCButtonname="添加课程";
		driver.findElement(By.linkText("课程管理")).click();
		WebElement createCourseButton=driver.findElement(By.cssSelector("span.greenbtn25_text"));
		Boolean addCButton= createCourseButton.isEnabled();
		String reladdCButtonname=createCourseButton.getText();
		Assert.assertTrue(addCButton);
		Assert.assertEquals(expdaddCButtonname, reladdCButtonname);
		System.out.println("添加课程按钮是否可用 ：   "+addCButton+"\n"+"添加课程按钮的名称："+reladdCButtonname);
		//检查批量导入按钮                                              
		String importButtonname="批量导入课程";
		WebElement importButton=driver.findElement(By.xpath(".//*[@id='import_student']/span"));
		Boolean isimportButton= importButton.isEnabled();
		String relimportButtonName=importButton.getText();
		Assert.assertTrue(isimportButton);
		Assert.assertEquals(importButtonname, relimportButtonName);
		System.out.println("批量导入课程按钮是否可用 ：   "+isimportButton+"\n"+"批量课程按钮的名称："+relimportButtonName);
		//检查导出excel按钮
		String exportButtonname="导出Excel文件";
		WebElement exportButton=driver.findElement(By.xpath(".//*[@id='export']/span"));
		Boolean isexportButton= exportButton.isEnabled();
		String relexportButtonName=exportButton.getText();
		Assert.assertTrue(isexportButton);
		Assert.assertEquals(exportButtonname, relexportButtonName);
		System.out.println("导出Excel文件按钮是否可用 ：   "+isexportButton+"\n"+"导出Excel文件按钮的名称："+relexportButtonName);
		
		
		
	}
}
