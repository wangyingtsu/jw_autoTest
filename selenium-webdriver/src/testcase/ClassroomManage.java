package testcase;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class ClassroomManage extends Base {
	/**
	 * 1.添加教室 2.删除教室
	 */
	 @Test
	public void createClassRoom() {
		String expectedCurrenturl = "http://jw." + env
				+ "ablesky.com/classRoomRedirect.do?action=toManage";
		driver.findElement(By.linkText("教室管理")).click();
		String actualCurrenturl = driver.getCurrentUrl();
		String title = driver.getTitle() + "  教室管理";
		System.out.println(title + "\n" + actualCurrenturl);
		assertEquals(expectedCurrenturl, actualCurrenturl);

		driver.findElement(By.cssSelector("span.greenbtn25_text")).click();
		driver.findElement(By.id("classRoomname")).clear();
		driver.findElement(By.id("classRoomname")).sendKeys("第一篮球场");
		driver.findElement(By.name("location")).clear();
		driver.findElement(By.name("location")).sendKeys("最大的操场");
		driver.findElement(By.cssSelector("span.bluebtn30_text")).click();
		driver.findElement(By.linkText("教室管理")).click();
		driver.findElement(By.linkText("详情")).click();
		String classroomName = driver.findElement(
				By.xpath("html/body/div[4]/div[2]/div/div/div[1]/div"))
				.getText();
		System.out.println(classroomName);
		sleep();

		driver.findElement(By.xpath("html/body/div[4]/div[1]/ul/li[8]/a"))
				.click();
		sleep();
		// 删除
		driver.findElement(By.linkText("删除")).click();
		driver.findElement(By.cssSelector("button[type=\"button\"]")).click();
		driver.findElement(By.xpath("html/body/div[4]/div[1]/ul/li[8]/a"))
				.click();
		sleep();

	}

	/**
	 * 查询教室
	 */
	 @Test
	public void queryClassRoom() {
		String expectedCurrenturl = "http://jw." + env
				+ "ablesky.com/classRoomRedirect.do?action=toManage";
		driver.findElement(By.linkText("教室管理")).click();
		String actualCurrenturl = driver.getCurrentUrl();
		String title = driver.getTitle() + "  教室管理";
		System.out.println(title + "\n" + actualCurrenturl);
		assertEquals(expectedCurrenturl, actualCurrenturl);

		driver.findElement(By.cssSelector("span.greenbtn25_text")).click();
		driver.findElement(By.id("classRoomname")).clear();
		driver.findElement(By.id("classRoomname")).sendKeys("第一篮球场222");
		driver.findElement(By.name("location")).clear();
		driver.findElement(By.name("location")).sendKeys("最大的操场");
		driver.findElement(By.cssSelector("span.bluebtn30_text")).click();
		driver.findElement(By.linkText("教室管理")).click();
		driver.findElement(By.name("userName")).clear();
		driver.findElement(By.name("userName")).sendKeys("第一篮球场");
		sleep();
		driver.findElement(By.cssSelector("span.bluebtn25_text")).click();
		sleep();
		sleep();
		sleep();
		// 删除
		driver.findElement(By.linkText("删除")).click();
		driver.findElement(By.cssSelector("button[type=\"button\"]")).click();
		driver.findElement(By.xpath("html/body/div[4]/div[1]/ul/li[8]/a"))
				.click();
		sleep();

	}

	/**
	 * 修改教室
	 */
	 @Test
	public void modifyClassroom() {
		String expectedCurrenturl = "http://jw." + env
				+ "ablesky.com/classRoomRedirect.do?action=toManage";
		driver.findElement(By.linkText("教室管理")).click();
		String actualCurrenturl = driver.getCurrentUrl();
		String title = driver.getTitle() + "  教室管理";
		System.out.println(title + "\n" + actualCurrenturl);
		assertEquals(expectedCurrenturl, actualCurrenturl);

		driver.findElement(By.cssSelector("span.greenbtn25_text")).click();
		driver.findElement(By.id("classRoomname")).clear();
		driver.findElement(By.id("classRoomname")).sendKeys("第一篮球场222");
		driver.findElement(By.name("location")).clear();
		driver.findElement(By.name("location")).sendKeys("最大的操场");
		driver.findElement(By.cssSelector("span.bluebtn30_text")).click();
		driver.findElement(By.linkText("教室管理")).click();
		driver.findElement(By.linkText("修改")).click();
		driver.findElement(By.id("classRoomname")).clear();
		driver.findElement(By.id("classRoomname")).sendKeys("第一篮球场333");
		driver.findElement(By.name("location")).clear();
		driver.findElement(By.name("location")).sendKeys(
				"最大的操场33333333333333333333333333");
		driver.findElement(By.cssSelector("span.bluebtn30_text")).click();
		sleep();
		// 删除
		driver.findElement(By.linkText("删除")).click();
		driver.findElement(By.cssSelector("button[type=\"button\"]")).click();
		driver.findElement(By.xpath("html/body/div[4]/div[1]/ul/li[8]/a"))
				.click();
		sleep();
	}

	/**
	 * 教室名称长度超过100字。提示错误信息“最多100个字符”
	 * 
	 * @throws IOException
	 * 
	 */
	 @Test
	public void ClassRNameToolong() throws IOException {
		String expectedCurrenturl = "http://jw." + env
				+ "ablesky.com/classRoomRedirect.do?action=toManage";
		String expectederrorMessage = "最多100个字符";
		driver.findElement(By.linkText("教室管理")).click();
		String actualCurrenturl = driver.getCurrentUrl();
		String title = driver.getTitle() + "  教室管理";
		System.out.println(title + "\n" + actualCurrenturl);
		assertEquals(expectedCurrenturl, actualCurrenturl);

		driver.findElement(By.cssSelector("span.greenbtn25_text")).click();
		driver.findElement(By.id("classRoomname")).clear();
		driver.findElement(By.id("classRoomname"))
				.sendKeys(
						"第一篮球场萨丹哈房间卡水电费会计师快发货时课件的发货快撒地方很快就撒旦回复空间撒的回复空间和谁打反馈会计恢复快静安寺电话费课件阿斯达罚款圣诞节发挥空间撒电话费空间按时萨丹哈房间卡水电费会计师快发货时课件的发货快撒地方很快就撒旦回复空间撒的回复空");
		driver.findElement(By.name("location")).clear();
		driver.findElement(By.name("location")).sendKeys("最大的操场");
		driver.findElement(By.cssSelector("span.bluebtn30_text")).click();
		String actualerrorMessage = driver
				.findElement(
						By.xpath(".//*[@id='J_createCircleBasic']/tbody/tr[1]/td[2]/div/label"))
				.getText();
		// 截图并保存在D盘下
		File screenShotFile = ((TakesScreenshot) driver)
				.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenShotFile, new File(
				"D:/auto_test/Classroommanage/classroomNameError.png"));
		Assert.assertEquals(expectederrorMessage, actualerrorMessage);
		driver.findElement(By.id("classRoomname")).clear();
		driver.findElement(By.id("classRoomname")).sendKeys("第一篮球场55555");
		driver.findElement(By.cssSelector("span.bluebtn30_text")).click();
		driver.findElement(By.linkText("教室管理")).click();
		// 删除
		driver.findElement(By.linkText("删除")).click();
		driver.findElement(By.cssSelector("button[type=\"button\"]")).click();
		driver.findElement(By.xpath("html/body/div[4]/div[1]/ul/li[8]/a"))
				.click();
		sleep();

	}

	/**
	 * 教室地点名称超过100字，提示错误信息“最多100个字符”
	 * 
	 * @throws IOException
	 */
	@Test
	public void ClassRAddressToolong() throws IOException {
		String expectedCurrenturl = "http://jw." + env
				+ "ablesky.com/classRoomRedirect.do?action=toManage";
		String expectederrorMessage = "最多100个字符";
		driver.findElement(By.linkText("教室管理")).click();
		String actualCurrenturl = driver.getCurrentUrl();
		String title = driver.getTitle() + "  教室管理";
		System.out.println(title + "\n" + actualCurrenturl);
		assertEquals(expectedCurrenturl, actualCurrenturl);

		driver.findElement(By.cssSelector("span.greenbtn25_text")).click();
		driver.findElement(By.id("classRoomname")).clear();
		driver.findElement(By.id("classRoomname")).sendKeys("第二篮球场");
		driver.findElement(By.name("location")).clear();
		driver.findElement(By.name("location"))
				.sendKeys(
						"第一篮球场萨丹哈房间卡水电费会计师快发货时课件的发货快撒地方很快就撒旦回复空间撒的回复空间和谁打反馈会计恢复快静安寺电话费课件阿斯达罚款圣诞节发挥空间撒电话费空间按时萨丹哈房间卡水电费会计师快发货时课件的发货快撒地方很快就撒旦回复空间撒的回复空");
		driver.findElement(By.cssSelector("span.bluebtn30_text")).click();
		String actualerrorMessage = driver
				.findElement(
						By.xpath(".//*[@id='J_createCircleBasic']/tbody/tr[2]/td[2]/div/label"))
				.getText();
		// 截图并保存在D盘下
		File screenShotFile = ((TakesScreenshot) driver)
				.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenShotFile, new File(
				"D:/auto_test/Classroommanage/locationError.png"));
		Assert.assertEquals(expectederrorMessage, actualerrorMessage);
		sleep();
		sleep();
		driver.findElement(By.name("location")).clear();
		driver.findElement(By.name("location")).sendKeys("第一篮球场萨丹哈");
		driver.findElement(By.cssSelector("span.bluebtn30_text")).click();
		driver.findElement(By.linkText("教室管理")).click();
		// 删除
		driver.findElement(By.linkText("删除")).click();
		driver.findElement(By.cssSelector("button[type=\"button\"]")).click();
		driver.findElement(By.xpath("html/body/div[4]/div[1]/ul/li[8]/a"))
				.click();
		sleep();

	}

	/**
	 * 教室备注超过1000字，提示错误信息“最多1000个字符”
	 * 
	 * @throws IOException
	 */
	@Test
	public void ClassRDescriptionToolong() throws IOException {
		String expectedCurrenturl = "http://jw." + env
				+ "ablesky.com/classRoomRedirect.do?action=toManage";
		String inputdescriptionerror = "撒电话费卡上的反馈和速度快开始电话费课件撒花地方会计核算快递费很快就撒旦发挥空间撒电话费会计啥的和罚款坚实的课件凤凰山课件的和福克斯电话费会计啥的和福克斯的恢复快水电费可花洒的看法和开始撒电话费卡上的反馈和速度快开始电话费课件撒花地方会计核算快递费很快就撒旦发挥空间撒电话费会计啥的和罚款坚实的课件凤凰山课件的和福克斯电话费会计啥的和福克斯的恢复快水电费可花洒的看法和开始撒电话费卡撒电话费卡上的反馈和速度快开始电话费课件撒花地方会计核算快递费很快就撒旦发挥空间撒电话费会计啥的和罚款坚实的课件凤凰山课件的和福克斯电话费会计啥的和福克斯的恢复快水电费可花洒的看法和开始撒电话费卡上的反馈和速度快开始电话费课件撒花地方会计核算快递费很快就撒旦发挥空间撒电话费会计啥的和罚款坚实的课件凤凰山课件的和福克斯电话费会计啥的和福克斯的恢复快水电费可花洒的看法和开始撒电话费卡上的反馈和速度快开始电话费课件撒花地方会计核算快递费很快就撒旦发挥空间撒电话费会计啥的和罚款坚实的课件凤凰山课件的和福克斯电话费会计啥的和福克斯的恢复快水电费可花洒的看法和开始撒电话费卡上的反馈和速度快开始电话费课件撒花地方会计核算快递费很快就撒旦发挥空间撒电话费会计啥的和罚款坚实的课件凤凰山课件的和福克斯电话费会计啥的和福克斯的恢复快水电费可花洒的看法和开始撒电话费卡上的反馈和速度快开始电话费课件撒花地方会计核算快递费很快就撒旦发挥空间撒电话费会计啥的和罚款坚实的课件凤凰山课件的和福克斯电话费会计啥的和福克斯的恢复快水电费可花洒的看法和开始撒电话费卡上的反馈和速度快开始电话费课件撒花地方会计核算快递费很快就撒旦发挥空间撒电话费会计啥的和罚款坚实的课件凤凰山课件的和福克斯电话费会计啥的和福克斯的恢复快水电费可花洒的看法和开始撒电话费卡上的反馈和速度快开始电话费课件撒花地方会计核算快递费很快就撒旦发挥空间撒电话费会计啥的和罚款坚实的课件凤凰山课件的和福克斯电话费会计啥的和福克斯的恢复快水电费可花洒的看法和开始撒电话费卡上的反馈和速度快开始电话费课件撒花地方会计核算快递费很快就撒旦发挥空间撒电话费会计啥的和罚款坚实的课件凤凰山课件的和福克斯电话费会计啥的和福克斯的恢复快水电费可花洒的看法和开始撒电话费卡上的反馈开始电话费课件撒花地方会计核算快递费很快就撒旦发挥空间撒电话费会计啥的和罚款坚实的课件凤凰山课件的和福克斯电话费会计啥的和福克斯的恢复快水电";
		String inputdescriptionright = "撒电话费卡上的反馈和速度快开始电话费课件撒花地方会计核算快递费很快就撒旦发挥空间撒电话费会计啥的和罚款坚实的课件凤凰山课件的和福克斯电话费会计啥的和福克斯的恢复快水电费可花洒的看法和开始撒电话费卡上的反馈和速度快开始电话费课件撒花地方会计核算快递费很快就撒旦发挥空间撒电话费会计啥的和罚款坚实的课件凤凰山课件的和福克斯电话费会计啥的和福克斯的恢复快水电费可花洒的看法和开始撒电话费卡撒";
		String expectederrorMessage = "最多1000位字符";
		driver.findElement(By.linkText("教室管理")).click();
		String actualCurrenturl = driver.getCurrentUrl();
		String title = driver.getTitle() + "  教室管理";
		System.out.println(title + "\n" + actualCurrenturl);
		assertEquals(expectedCurrenturl, actualCurrenturl);

		driver.findElement(By.cssSelector("span.greenbtn25_text")).click();
		driver.findElement(By.id("classRoomname")).clear();
		driver.findElement(By.id("classRoomname")).sendKeys("第二篮球场");
		driver.findElement(By.name("location")).clear();
		driver.findElement(By.name("location")).sendKeys("第一篮球场萨丹回复空");
		driver.findElement(By.name("remark")).clear();
		driver.findElement(By.name("remark")).sendKeys(inputdescriptionerror);
		driver.findElement(By.cssSelector("span.bluebtn30_text")).click();
		// 截图并保存在D盘下
		File screenShotFile = ((TakesScreenshot) driver)
				.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenShotFile, new File(
				"D:/auto_test/Classroommanage/descriptionError.png"));
		String actualerrorMessage = driver
				.findElement(
						By.xpath(".//*[@id='J_createCircleBasic']/tbody/tr[3]/td[2]/div/label"))
				.getText();
		Assert.assertEquals(expectederrorMessage, actualerrorMessage);
		sleep();
		sleep();
		driver.findElement(By.name("remark")).clear();
		driver.findElement(By.name("remark")).sendKeys(inputdescriptionright);
		driver.findElement(By.cssSelector("span.bluebtn30_text")).click();
		driver.findElement(By.linkText("教室管理")).click();
		// 删除
		driver.findElement(By.linkText("删除")).click();
		driver.findElement(By.cssSelector("button[type=\"button\"]")).click();
		driver.findElement(By.xpath("html/body/div[4]/div[1]/ul/li[8]/a"))
				.click();
		sleep();

	}

}
