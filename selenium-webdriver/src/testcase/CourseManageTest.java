package testcase;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.junit.*;

import static org.junit.Assert.*;

import org.openqa.selenium.*;

public class CourseManageTest extends Base {
	/**
	 * 1.������ӿγ� 
	 * 2.���� ɾ���γ�
	 */
	// @Test
	public void createCouse() throws Exception {

		String expectedCurrenturl = "http://jw.ablesky.com/courseRedirect.do?action=toCourseList";
		String coursename = "���Կγ�-����";

		driver.findElement(By.linkText("�γ̹���")).click();

		String actualCurrenturl = driver.getCurrentUrl();
		String title = driver.getTitle() + "  �γ̹���";
		System.out.println(title + "\n" + actualCurrenturl);
		assertEquals(expectedCurrenturl, actualCurrenturl);

		driver.findElement(By.cssSelector("span.greenbtn25_text")).click();
		driver.findElement(By.id("courseName")).clear();
		driver.findElement(By.id("courseName")).sendKeys(coursename);
		driver.findElement(By.id("coursePrice")).clear();
		driver.findElement(By.id("coursePrice")).sendKeys("12");
		driver.findElement(By.id("J_tinyContainer")).clear();
		driver.findElement(By.id("J_tinyContainer")).sendKeys("���ĿΡ������Կγ�");
		driver.findElement(By.cssSelector("span.bluebtn30_text")).click();
		driver.findElement(By.linkText("�γ̹���")).click();

		driver.findElement(By.cssSelector("a.current")).click();
		driver.findElement(By.linkText("�޸�")).click();
		// ��ͼ��������D����
		File screenShotFile = ((TakesScreenshot) driver)
				.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenShotFile, new File(
				"D:/auto_test/createCourse/createCourse.png"));
		String realCourse = driver.findElement(By.id("courseName"))
				.getAttribute("value");
		sleep();
		assertEquals(coursename, realCourse);

		driver.findElement(By.cssSelector("span.bluebtn30_text")).click();// ����

		driver.findElement(By.cssSelector("a.current")).click();
		driver.findElement(By.linkText("ɾ��")).click();
		driver.findElement(By.cssSelector("button[type=\"button\"]")).click();
		sleep();

	}

	/**
	 * �γ̱������볬��100�֣���ʾ��Ϣ�������100λ�ַ���
	 * 
	 */
	//@Test
	public void createCourseForTitletoolong() throws IOException {
		String errorCourseName = "�����췢������ɶ�ĺͷ������������Ļָ���ӵ绰����������������绰�ѻ��ʦ�Ļָ����"
				+ "ʦ�绰�ѿμ��ǵ绰�ѿɽ��ܵĻظ��ռ�������������˹���ظ����ɶ�ĺͷ���ʢ��ͷ����ʵ�ķ�����Ŀ����Ϳ��˴︣��˹�Ļָ���������";
		String formalName = "��ѧ�Ρ�������";
		String expectedErrorMessage = "���100λ�ַ�";
		driver.findElement(By.linkText("�γ̹���")).click();
		sleep();
		driver.findElement(By.cssSelector("span.greenbtn25_text")).click();
		driver.findElement(By.id("courseName")).clear();
		driver.findElement(By.id("courseName")).sendKeys(errorCourseName);
		driver.findElement(By.cssSelector("span.bluebtn30_text")).click();

		// ��ͼ��������D����
		File screenShotFile = ((TakesScreenshot) driver)
				.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenShotFile, new File(
				"D:/auto_test/createCourse/createCourseForTitletoolong.png"));
		String errorMessage = driver
				.findElement(
						By.xpath(".//*[@id='#J_createCourse']/tbody/tr[1]/td[2]/div/label[2]"))
				.getText();

		assertEquals(expectedErrorMessage, errorMessage);
		System.out.println("���γ���Ŀ����100���ַ�ʱ��ʾ�� " + errorMessage);
		driver.findElement(By.id("courseName")).clear();
		driver.findElement(By.id("courseName")).sendKeys(formalName);
		driver.findElement(By.cssSelector("span.bluebtn30_text")).click();// ȷ����ť

		// ɾ�����Կγ�
		driver.findElement(By.cssSelector("a.current")).click();
		driver.findElement(By.linkText("ɾ��")).click();
		driver.findElement(By.cssSelector("button[type=\"button\"]")).click();
		sleep();
	}

	/**
	 * 
	 * �γ̼�����볬��500��ʱ��ʾ�����γ̼�鳬��500�֡�
	 * 
	 */
	//@Test
	public void createcourseFordescriptionOvertoolong() throws IOException {
		String courseName="Ӣ��Ρ�������";
		String coursePrice="100";
		String errorCourseDescription = "��淶�ͷ��ӹ淶�͹淶���淶�ع�͹淶�ͷ��Ϲ淶�͹淶�ͷ��Ӹ��Ϸ���淶�ͷ��ӹ淶�͹淶���淶�ع�͹淶�ͷ��Ϲ淶�͹淶�ͷ��Ӹ��Ϸ���淶�ͷ��ӹ淶�͹淶���淶�ع�͹淶�ͷ��Ϲ淶�͹淶�ͷ��Ӹ��Ϸ���淶�ͷ��ӹ淶�͹淶���淶�ع�͹淶�ͷ��Ϲ淶�͹淶�ͷ��Ӹ��Ϸ���淶�ͷ��ӹ淶�͹淶���淶�ع�͹淶�ͷ��Ϲ淶�͹淶�ͷ��Ӹ��Ϸ���淶�ͷ��ӹ淶�͹淶���淶�ع�͹淶�ͷ��Ϲ淶�͹淶�ͷ��Ӹ��Ϸ���淶�ͷ��ӹ淶�͹淶���淶�ع�͹淶�ͷ��Ϲ淶�͹淶�ͷ��Ӹ��Ϸ���淶�ͷ��ӹ淶�͹淶���淶�ع�͹淶�ͷ��Ϲ淶�͹淶�ͷ��Ӹ��Ϸ���淶�ͷ��ӹ淶�͹淶���淶�ع�͹淶�ͷ��Ϲ淶�͹淶�ͷ��Ӹ��Ϸ���淶�ͷ��ӹ淶�͹淶���淶�ع�͹淶�ͷ��Ϲ淶�͹淶�ͷ��Ӹ��Ϸ���淶�ͷ��ӹ淶�͹淶���淶�ع�͹淶�ͷ��Ϲ淶�͹淶�ͷ��Ӹ��Ϸ���淶�ͷ��ӹ淶�͹淶���淶�ع�͹淶�ͷ��Ϲ淶�͹淶�ͷ��Ӹ��Ϸ���淶�ͷ��ӹ淶�͹淶���淶�ع�͹淶�ͷ��Ϲ淶�͹淶�ͷ��Ӹ��Ϸ���淶�ͷ��ӹ淶�͹淶���淶�ع�͹淶�ͷ��Ϲ淶�͹淶�ͷ��Ӹ��Ϸ���淶�ͷ��ӹ淶�͹淶���淶�ع�͹淶�ͷ��Ϲ淶�͹淶�ͷ��Ӹ��Ϸ���淶�ͷ��ӹ淶�͹淶���淶�ع�͹淶�ͷ��Ϲ淶�͹淶�ͷ��Ӹ��Ϸ���淶�ͷ��ӹ淶�͹淶���淶�ع�͹淶�ͷ��Ϲ淶�͹淶�ͷ��Ӹ��Ϸ���淶�ͷ��ӹ淶�͹淶���淶�ع�͹淶�ͷ��Ϲ淶�͹淶�ͷ��Ӹ��Ϸ���淶�ͷ��ӹ淶�͹淶���淶�ع�͹淶�ͷ��Ϲ淶�͹淶�ͷ��Ӹ��Ϸ���淶�ͷ��ӹ淶�͹淶���淶�ع�͹淶�ͷ��Ϲ淶�͹淶�ͷ��Ӹ��Ϸ���淶�ͷ��ӹ淶�͹淶���淶�ع�͹淶�ͷ��Ϲ淶�͹淶�ͷ��Ӹ��Ϸ���淶�ͷ��ӹ淶�͹淶���淶�ع�͹淶�ͷ��Ϲ淶�͹淶�ͷ��Ӹ��Ϸ���淶�ͷ��ӹ淶�͹淶���淶�ع�͹淶�ͷ��Ϲ淶�͹淶�ͷ��Ӹ��Ϸ���淶�ͷ��ӹ淶�͹淶���淶�ع�͹淶�ͷ��Ϲ淶�͹淶�ͷ��Ӹ��Ϸ���淶�ͷ��ӹ淶�͹淶���淶�ع�͹淶�ͷ��Ϲ淶�͹淶�ͷ��Ӹ��Ϸ���淶�ͷ��ӹ淶�͹淶���淶�ع�͹淶�ͷ��Ϲ淶�͹淶�ͷ��Ӹ��Ϸ���淶�ͷ��ӹ淶�͹淶���淶�ع�͹淶�ͷ��Ϲ淶�͹淶�ͷ��Ӹ��Ϸ���淶�ͷ��ӹ淶�͹淶���淶�ع�͹淶�ͷ��Ϲ淶�͹淶�ͷ��Ӹ��Ϸ���淶�ͷ��ӹ淶�͹淶���淶�ع�͹淶�ͷ��Ϲ淶�͹淶�ͷ��Ӹ��Ϸ���淶�ͷ��ӹ淶�͹淶���淶�ع�͹淶�ͷ��Ϲ淶�͹淶�ͷ��Ӹ��Ϸ���淶�ͷ��ӹ淶�͹淶���淶�ع�͹淶�ͷ��Ϲ淶�͹淶�ͷ��Ӹ��Ϸ���淶�ͷ��ӹ淶�͹淶���淶�ع�͹淶�ͷ��Ϲ淶�͹淶�ͷ��Ӹ��Ϸ���淶�ͷ��ӹ淶�͹淶���淶�ع�͹淶�ͷ��Ϲ淶�͹淶�ͷ��Ӹ��Ϸ���淶�ͷ��ӹ淶�͹淶���淶�ع�͹淶�ͷ��Ϲ淶�͹淶�ͷ��Ӹ��Ϸ���淶�ͷ��ӹ淶�͹淶���淶�ع�͹淶�ͷ��Ϲ淶�͹淶�ͷ��Ӹ��Ϸ���淶�ͷ��ӹ淶�͹淶���淶�ع�͹淶�ͷ��Ϲ淶�͹淶�ͷ��Ӹ��Ϸ���淶�ͷ��ӹ淶�͹淶���淶�ع�͹淶�ͷ��Ϲ淶�͹淶�ͷ��Ӹ��Ϸ���淶�ͷ��ӹ淶�͹淶���淶�ع�͹淶�ͷ��Ϲ淶�͹淶�ͷ��Ӹ��Ϸ�";
		String formalDescription = "��淶�ͷ��ӹ淶�͹淶���淶�ع�͹淶�ͷ��Ϲ淶�͹淶�ͷ�";
		String expectedErrorMessage = "���500λ�ַ�";
		driver.findElement(By.linkText("�γ̹���")).click();
		sleep();
		driver.findElement(By.cssSelector("span.greenbtn25_text")).click();
		driver.findElement(By.id("courseName")).clear();
		driver.findElement(By.id("courseName")).sendKeys(courseName);
		driver.findElement(By.id("coursePrice")).clear();
		driver.findElement(By.id("coursePrice")).sendKeys(coursePrice);
		driver.findElement(By.id("J_tinyContainer")).clear();
		driver.findElement(By.id("J_tinyContainer")).sendKeys(errorCourseDescription);
		
		driver.findElement(By.cssSelector("span.bluebtn30_text")).click();
		

		// ��ͼ��������D����
		File screenShotFile = ((TakesScreenshot) driver)
				.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenShotFile, new File(
				"D:/auto_test/createCourse/createcourseFordescriptionOvertoolong.png"));
		String actulerrorMessage = driver
				.findElement(
						By.xpath(".//*[@id='#J_createCourse']/tbody/tr[3]/td[2]/label"))
				.getText();

		assertEquals(expectedErrorMessage, actulerrorMessage);
		System.out.println("���γ���������500���ַ�ʱ��ʾ�� " + actulerrorMessage);
		driver.findElement(By.id("J_tinyContainer")).clear();
		driver.findElement(By.id("J_tinyContainer")).sendKeys(formalDescription);
		driver.findElement(By.cssSelector("span.bluebtn30_text")).click();// ȷ����ť

		// ɾ�����Կγ�
		driver.findElement(By.cssSelector("a.current")).click();
		driver.findElement(By.linkText("ɾ��")).click();
		driver.findElement(By.cssSelector("button[type=\"button\"]")).click();
		sleep();

	}

	/**
	 * �γ̼۸��ܳ���1000000Ԫ
	 */
	//@Test
	public void createcourseForPricetoohigh() throws IOException {
		String courseName="Ӣ��Ρ�������";
		String formalcoursePrice="100";
		String errorCoursePrice="1000001";
		String expectedErrorMessage = "�γ̼۸��ܳ���1000000Ԫ";
		driver.findElement(By.linkText("�γ̹���")).click();
		sleep();
		driver.findElement(By.cssSelector("span.greenbtn25_text")).click();
		driver.findElement(By.id("courseName")).clear();
		driver.findElement(By.id("courseName")).sendKeys(courseName);
		driver.findElement(By.id("coursePrice")).clear();
		driver.findElement(By.id("coursePrice")).sendKeys(errorCoursePrice);
		
		driver.findElement(By.cssSelector("span.bluebtn30_text")).click();
		

		// ��ͼ��������D����
		File screenShotFile = ((TakesScreenshot) driver)
				.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenShotFile, new File(
				"D:/auto_test/createCourse/createcourseForPricetoohigh.png"));
		String actulerrorMessage = driver
				.findElement(
						By.xpath("html/body/div[4]/div[2]/section/div/div"))
				.getText();

		assertEquals(expectedErrorMessage, actulerrorMessage);
		System.out.println("���γ̼۸񳬹�1000000Ԫʱ��ʾ�� �� " + actulerrorMessage);
		driver.findElement(By.id("coursePrice")).clear();
		driver.findElement(By.id("coursePrice")).sendKeys(formalcoursePrice);
		driver.findElement(By.cssSelector("span.bluebtn30_text")).click();// ȷ����ť

		// ɾ�����Կγ�
		driver.findElement(By.cssSelector("a.current")).click();
		driver.findElement(By.linkText("ɾ��")).click();
		driver.findElement(By.cssSelector("button[type=\"button\"]")).click();
		sleep();

	}
	
	/**
	 * ��������γ�
	 */
	@ Ignore
	public void importCourseByexcel(){
		
	}
	
	
	
	
	/**
	 * ����excel�ļ�
	 */
	@Ignore
	public void exportCourseByExcel(){
		
	}
	
	
	/**
	 * ���ҳ�������ť����ť״̬
	 */
	@Test
	public void checkbuttonsState(){
		//�����Ӱ�ť
		String expdaddCButtonname="��ӿγ�";
		driver.findElement(By.linkText("�γ̹���")).click();
		WebElement createCourseButton=driver.findElement(By.cssSelector("span.greenbtn25_text"));
		Boolean addCButton= createCourseButton.isEnabled();
		String reladdCButtonname=createCourseButton.getText();
		Assert.assertTrue(addCButton);
		Assert.assertEquals(expdaddCButtonname, reladdCButtonname);
		System.out.println("��ӿγ̰�ť�Ƿ���� ��   "+addCButton+"\n"+"��ӿγ̰�ť�����ƣ�"+reladdCButtonname);
		//����������밴ť                                              
		String importButtonname="��������γ�";
		WebElement importButton=driver.findElement(By.xpath(".//*[@id='import_student']/span"));
		Boolean isimportButton= importButton.isEnabled();
		String relimportButtonName=importButton.getText();
		Assert.assertTrue(isimportButton);
		Assert.assertEquals(importButtonname, relimportButtonName);
		System.out.println("��������γ̰�ť�Ƿ���� ��   "+isimportButton+"\n"+"�����γ̰�ť�����ƣ�"+relimportButtonName);
		//��鵼��excel��ť
		String exportButtonname="����Excel�ļ�";
		WebElement exportButton=driver.findElement(By.xpath(".//*[@id='export']/span"));
		Boolean isexportButton= exportButton.isEnabled();
		String relexportButtonName=exportButton.getText();
		Assert.assertTrue(isexportButton);
		Assert.assertEquals(exportButtonname, relexportButtonName);
		System.out.println("����Excel�ļ���ť�Ƿ���� ��   "+isexportButton+"\n"+"����Excel�ļ���ť�����ƣ�"+relexportButtonName);
		
		
		
	}
}
