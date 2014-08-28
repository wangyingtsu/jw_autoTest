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
	 * 1.��ӽ��� 2.ɾ������
	 */
	 @Test
	public void createClassRoom() {
		String expectedCurrenturl = "http://jw." + env
				+ "ablesky.com/classRoomRedirect.do?action=toManage";
		driver.findElement(By.linkText("���ҹ���")).click();
		String actualCurrenturl = driver.getCurrentUrl();
		String title = driver.getTitle() + "  ���ҹ���";
		System.out.println(title + "\n" + actualCurrenturl);
		assertEquals(expectedCurrenturl, actualCurrenturl);

		driver.findElement(By.cssSelector("span.greenbtn25_text")).click();
		driver.findElement(By.id("classRoomname")).clear();
		driver.findElement(By.id("classRoomname")).sendKeys("��һ����");
		driver.findElement(By.name("location")).clear();
		driver.findElement(By.name("location")).sendKeys("���Ĳٳ�");
		driver.findElement(By.cssSelector("span.bluebtn30_text")).click();
		driver.findElement(By.linkText("���ҹ���")).click();
		driver.findElement(By.linkText("����")).click();
		String classroomName = driver.findElement(
				By.xpath("html/body/div[4]/div[2]/div/div/div[1]/div"))
				.getText();
		System.out.println(classroomName);
		sleep();

		driver.findElement(By.xpath("html/body/div[4]/div[1]/ul/li[8]/a"))
				.click();
		sleep();
		// ɾ��
		driver.findElement(By.linkText("ɾ��")).click();
		driver.findElement(By.cssSelector("button[type=\"button\"]")).click();
		driver.findElement(By.xpath("html/body/div[4]/div[1]/ul/li[8]/a"))
				.click();
		sleep();

	}

	/**
	 * ��ѯ����
	 */
	 @Test
	public void queryClassRoom() {
		String expectedCurrenturl = "http://jw." + env
				+ "ablesky.com/classRoomRedirect.do?action=toManage";
		driver.findElement(By.linkText("���ҹ���")).click();
		String actualCurrenturl = driver.getCurrentUrl();
		String title = driver.getTitle() + "  ���ҹ���";
		System.out.println(title + "\n" + actualCurrenturl);
		assertEquals(expectedCurrenturl, actualCurrenturl);

		driver.findElement(By.cssSelector("span.greenbtn25_text")).click();
		driver.findElement(By.id("classRoomname")).clear();
		driver.findElement(By.id("classRoomname")).sendKeys("��һ����222");
		driver.findElement(By.name("location")).clear();
		driver.findElement(By.name("location")).sendKeys("���Ĳٳ�");
		driver.findElement(By.cssSelector("span.bluebtn30_text")).click();
		driver.findElement(By.linkText("���ҹ���")).click();
		driver.findElement(By.name("userName")).clear();
		driver.findElement(By.name("userName")).sendKeys("��һ����");
		sleep();
		driver.findElement(By.cssSelector("span.bluebtn25_text")).click();
		sleep();
		sleep();
		sleep();
		// ɾ��
		driver.findElement(By.linkText("ɾ��")).click();
		driver.findElement(By.cssSelector("button[type=\"button\"]")).click();
		driver.findElement(By.xpath("html/body/div[4]/div[1]/ul/li[8]/a"))
				.click();
		sleep();

	}

	/**
	 * �޸Ľ���
	 */
	 @Test
	public void modifyClassroom() {
		String expectedCurrenturl = "http://jw." + env
				+ "ablesky.com/classRoomRedirect.do?action=toManage";
		driver.findElement(By.linkText("���ҹ���")).click();
		String actualCurrenturl = driver.getCurrentUrl();
		String title = driver.getTitle() + "  ���ҹ���";
		System.out.println(title + "\n" + actualCurrenturl);
		assertEquals(expectedCurrenturl, actualCurrenturl);

		driver.findElement(By.cssSelector("span.greenbtn25_text")).click();
		driver.findElement(By.id("classRoomname")).clear();
		driver.findElement(By.id("classRoomname")).sendKeys("��һ����222");
		driver.findElement(By.name("location")).clear();
		driver.findElement(By.name("location")).sendKeys("���Ĳٳ�");
		driver.findElement(By.cssSelector("span.bluebtn30_text")).click();
		driver.findElement(By.linkText("���ҹ���")).click();
		driver.findElement(By.linkText("�޸�")).click();
		driver.findElement(By.id("classRoomname")).clear();
		driver.findElement(By.id("classRoomname")).sendKeys("��һ����333");
		driver.findElement(By.name("location")).clear();
		driver.findElement(By.name("location")).sendKeys(
				"���Ĳٳ�33333333333333333333333333");
		driver.findElement(By.cssSelector("span.bluebtn30_text")).click();
		sleep();
		// ɾ��
		driver.findElement(By.linkText("ɾ��")).click();
		driver.findElement(By.cssSelector("button[type=\"button\"]")).click();
		driver.findElement(By.xpath("html/body/div[4]/div[1]/ul/li[8]/a"))
				.click();
		sleep();
	}

	/**
	 * �������Ƴ��ȳ���100�֡���ʾ������Ϣ�����100���ַ���
	 * 
	 * @throws IOException
	 * 
	 */
	 @Test
	public void ClassRNameToolong() throws IOException {
		String expectedCurrenturl = "http://jw." + env
				+ "ablesky.com/classRoomRedirect.do?action=toManage";
		String expectederrorMessage = "���100���ַ�";
		driver.findElement(By.linkText("���ҹ���")).click();
		String actualCurrenturl = driver.getCurrentUrl();
		String title = driver.getTitle() + "  ���ҹ���";
		System.out.println(title + "\n" + actualCurrenturl);
		assertEquals(expectedCurrenturl, actualCurrenturl);

		driver.findElement(By.cssSelector("span.greenbtn25_text")).click();
		driver.findElement(By.id("classRoomname")).clear();
		driver.findElement(By.id("classRoomname"))
				.sendKeys(
						"��һ�������������俨ˮ��ѻ��ʦ�췢��ʱ�μ��ķ��������ط��ܿ�������ظ��ռ����Ļظ��ռ��˭������ƻָ��쾲���µ绰�ѿμ���˹�﷣��ʥ���ڷ��ӿռ����绰�ѿռ䰴ʱ���������俨ˮ��ѻ��ʦ�췢��ʱ�μ��ķ��������ط��ܿ�������ظ��ռ����Ļظ���");
		driver.findElement(By.name("location")).clear();
		driver.findElement(By.name("location")).sendKeys("���Ĳٳ�");
		driver.findElement(By.cssSelector("span.bluebtn30_text")).click();
		String actualerrorMessage = driver
				.findElement(
						By.xpath(".//*[@id='J_createCircleBasic']/tbody/tr[1]/td[2]/div/label"))
				.getText();
		// ��ͼ��������D����
		File screenShotFile = ((TakesScreenshot) driver)
				.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenShotFile, new File(
				"D:/auto_test/Classroommanage/classroomNameError.png"));
		Assert.assertEquals(expectederrorMessage, actualerrorMessage);
		driver.findElement(By.id("classRoomname")).clear();
		driver.findElement(By.id("classRoomname")).sendKeys("��һ����55555");
		driver.findElement(By.cssSelector("span.bluebtn30_text")).click();
		driver.findElement(By.linkText("���ҹ���")).click();
		// ɾ��
		driver.findElement(By.linkText("ɾ��")).click();
		driver.findElement(By.cssSelector("button[type=\"button\"]")).click();
		driver.findElement(By.xpath("html/body/div[4]/div[1]/ul/li[8]/a"))
				.click();
		sleep();

	}

	/**
	 * ���ҵص����Ƴ���100�֣���ʾ������Ϣ�����100���ַ���
	 * 
	 * @throws IOException
	 */
	@Test
	public void ClassRAddressToolong() throws IOException {
		String expectedCurrenturl = "http://jw." + env
				+ "ablesky.com/classRoomRedirect.do?action=toManage";
		String expectederrorMessage = "���100���ַ�";
		driver.findElement(By.linkText("���ҹ���")).click();
		String actualCurrenturl = driver.getCurrentUrl();
		String title = driver.getTitle() + "  ���ҹ���";
		System.out.println(title + "\n" + actualCurrenturl);
		assertEquals(expectedCurrenturl, actualCurrenturl);

		driver.findElement(By.cssSelector("span.greenbtn25_text")).click();
		driver.findElement(By.id("classRoomname")).clear();
		driver.findElement(By.id("classRoomname")).sendKeys("�ڶ�����");
		driver.findElement(By.name("location")).clear();
		driver.findElement(By.name("location"))
				.sendKeys(
						"��һ�������������俨ˮ��ѻ��ʦ�췢��ʱ�μ��ķ��������ط��ܿ�������ظ��ռ����Ļظ��ռ��˭������ƻָ��쾲���µ绰�ѿμ���˹�﷣��ʥ���ڷ��ӿռ����绰�ѿռ䰴ʱ���������俨ˮ��ѻ��ʦ�췢��ʱ�μ��ķ��������ط��ܿ�������ظ��ռ����Ļظ���");
		driver.findElement(By.cssSelector("span.bluebtn30_text")).click();
		String actualerrorMessage = driver
				.findElement(
						By.xpath(".//*[@id='J_createCircleBasic']/tbody/tr[2]/td[2]/div/label"))
				.getText();
		// ��ͼ��������D����
		File screenShotFile = ((TakesScreenshot) driver)
				.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenShotFile, new File(
				"D:/auto_test/Classroommanage/locationError.png"));
		Assert.assertEquals(expectederrorMessage, actualerrorMessage);
		sleep();
		sleep();
		driver.findElement(By.name("location")).clear();
		driver.findElement(By.name("location")).sendKeys("��һ����������");
		driver.findElement(By.cssSelector("span.bluebtn30_text")).click();
		driver.findElement(By.linkText("���ҹ���")).click();
		// ɾ��
		driver.findElement(By.linkText("ɾ��")).click();
		driver.findElement(By.cssSelector("button[type=\"button\"]")).click();
		driver.findElement(By.xpath("html/body/div[4]/div[1]/ul/li[8]/a"))
				.click();
		sleep();

	}

	/**
	 * ���ұ�ע����1000�֣���ʾ������Ϣ�����1000���ַ���
	 * 
	 * @throws IOException
	 */
	@Test
	public void ClassRDescriptionToolong() throws IOException {
		String expectedCurrenturl = "http://jw." + env
				+ "ablesky.com/classRoomRedirect.do?action=toManage";
		String inputdescriptionerror = "���绰�ѿ��ϵķ������ٶȿ쿪ʼ�绰�ѿμ������ط���ƺ����ݷѺܿ���������ӿռ����绰�ѻ��ɶ�ĺͷ����ʵ�Ŀμ����ɽ�μ��ĺ͸���˹�绰�ѻ��ɶ�ĺ͸���˹�Ļָ���ˮ��ѿɻ����Ŀ����Ϳ�ʼ���绰�ѿ��ϵķ������ٶȿ쿪ʼ�绰�ѿμ������ط���ƺ����ݷѺܿ���������ӿռ����绰�ѻ��ɶ�ĺͷ����ʵ�Ŀμ����ɽ�μ��ĺ͸���˹�绰�ѻ��ɶ�ĺ͸���˹�Ļָ���ˮ��ѿɻ����Ŀ����Ϳ�ʼ���绰�ѿ����绰�ѿ��ϵķ������ٶȿ쿪ʼ�绰�ѿμ������ط���ƺ����ݷѺܿ���������ӿռ����绰�ѻ��ɶ�ĺͷ����ʵ�Ŀμ����ɽ�μ��ĺ͸���˹�绰�ѻ��ɶ�ĺ͸���˹�Ļָ���ˮ��ѿɻ����Ŀ����Ϳ�ʼ���绰�ѿ��ϵķ������ٶȿ쿪ʼ�绰�ѿμ������ط���ƺ����ݷѺܿ���������ӿռ����绰�ѻ��ɶ�ĺͷ����ʵ�Ŀμ����ɽ�μ��ĺ͸���˹�绰�ѻ��ɶ�ĺ͸���˹�Ļָ���ˮ��ѿɻ����Ŀ����Ϳ�ʼ���绰�ѿ��ϵķ������ٶȿ쿪ʼ�绰�ѿμ������ط���ƺ����ݷѺܿ���������ӿռ����绰�ѻ��ɶ�ĺͷ����ʵ�Ŀμ����ɽ�μ��ĺ͸���˹�绰�ѻ��ɶ�ĺ͸���˹�Ļָ���ˮ��ѿɻ����Ŀ����Ϳ�ʼ���绰�ѿ��ϵķ������ٶȿ쿪ʼ�绰�ѿμ������ط���ƺ����ݷѺܿ���������ӿռ����绰�ѻ��ɶ�ĺͷ����ʵ�Ŀμ����ɽ�μ��ĺ͸���˹�绰�ѻ��ɶ�ĺ͸���˹�Ļָ���ˮ��ѿɻ����Ŀ����Ϳ�ʼ���绰�ѿ��ϵķ������ٶȿ쿪ʼ�绰�ѿμ������ط���ƺ����ݷѺܿ���������ӿռ����绰�ѻ��ɶ�ĺͷ����ʵ�Ŀμ����ɽ�μ��ĺ͸���˹�绰�ѻ��ɶ�ĺ͸���˹�Ļָ���ˮ��ѿɻ����Ŀ����Ϳ�ʼ���绰�ѿ��ϵķ������ٶȿ쿪ʼ�绰�ѿμ������ط���ƺ����ݷѺܿ���������ӿռ����绰�ѻ��ɶ�ĺͷ����ʵ�Ŀμ����ɽ�μ��ĺ͸���˹�绰�ѻ��ɶ�ĺ͸���˹�Ļָ���ˮ��ѿɻ����Ŀ����Ϳ�ʼ���绰�ѿ��ϵķ������ٶȿ쿪ʼ�绰�ѿμ������ط���ƺ����ݷѺܿ���������ӿռ����绰�ѻ��ɶ�ĺͷ����ʵ�Ŀμ����ɽ�μ��ĺ͸���˹�绰�ѻ��ɶ�ĺ͸���˹�Ļָ���ˮ��ѿɻ����Ŀ����Ϳ�ʼ���绰�ѿ��ϵķ������ٶȿ쿪ʼ�绰�ѿμ������ط���ƺ����ݷѺܿ���������ӿռ����绰�ѻ��ɶ�ĺͷ����ʵ�Ŀμ����ɽ�μ��ĺ͸���˹�绰�ѻ��ɶ�ĺ͸���˹�Ļָ���ˮ��ѿɻ����Ŀ����Ϳ�ʼ���绰�ѿ��ϵķ�����ʼ�绰�ѿμ������ط���ƺ����ݷѺܿ���������ӿռ����绰�ѻ��ɶ�ĺͷ����ʵ�Ŀμ����ɽ�μ��ĺ͸���˹�绰�ѻ��ɶ�ĺ͸���˹�Ļָ���ˮ��";
		String inputdescriptionright = "���绰�ѿ��ϵķ������ٶȿ쿪ʼ�绰�ѿμ������ط���ƺ����ݷѺܿ���������ӿռ����绰�ѻ��ɶ�ĺͷ����ʵ�Ŀμ����ɽ�μ��ĺ͸���˹�绰�ѻ��ɶ�ĺ͸���˹�Ļָ���ˮ��ѿɻ����Ŀ����Ϳ�ʼ���绰�ѿ��ϵķ������ٶȿ쿪ʼ�绰�ѿμ������ط���ƺ����ݷѺܿ���������ӿռ����绰�ѻ��ɶ�ĺͷ����ʵ�Ŀμ����ɽ�μ��ĺ͸���˹�绰�ѻ��ɶ�ĺ͸���˹�Ļָ���ˮ��ѿɻ����Ŀ����Ϳ�ʼ���绰�ѿ���";
		String expectederrorMessage = "���1000λ�ַ�";
		driver.findElement(By.linkText("���ҹ���")).click();
		String actualCurrenturl = driver.getCurrentUrl();
		String title = driver.getTitle() + "  ���ҹ���";
		System.out.println(title + "\n" + actualCurrenturl);
		assertEquals(expectedCurrenturl, actualCurrenturl);

		driver.findElement(By.cssSelector("span.greenbtn25_text")).click();
		driver.findElement(By.id("classRoomname")).clear();
		driver.findElement(By.id("classRoomname")).sendKeys("�ڶ�����");
		driver.findElement(By.name("location")).clear();
		driver.findElement(By.name("location")).sendKeys("��һ���������ظ���");
		driver.findElement(By.name("remark")).clear();
		driver.findElement(By.name("remark")).sendKeys(inputdescriptionerror);
		driver.findElement(By.cssSelector("span.bluebtn30_text")).click();
		// ��ͼ��������D����
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
		driver.findElement(By.linkText("���ҹ���")).click();
		// ɾ��
		driver.findElement(By.linkText("ɾ��")).click();
		driver.findElement(By.cssSelector("button[type=\"button\"]")).click();
		driver.findElement(By.xpath("html/body/div[4]/div[1]/ul/li[8]/a"))
				.click();
		sleep();

	}

}
