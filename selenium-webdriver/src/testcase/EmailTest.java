package testcase;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;

public class EmailTest extends Base {

	/**
	 * ���水ť�������
	 */
	// @Test
	public void allbuttonscheck() {
		String expectedCurrenturl = "http://jw." + env
				+ "ablesky.com/mailRedirect.do?action=toReceiveMail";
		driver.findElement(By.xpath("html/body/div[4]/div[1]/ul/li[11]/a"))
				.click();// �ҵ����䵼��
		String actualCurrenturl = driver.getCurrentUrl();
		String title = driver.getTitle() + "  �ҵ�����";
		System.out.println(title + "\n" + actualCurrenturl);
		assertEquals(expectedCurrenturl, actualCurrenturl);
		sleep();
		sleep();
		boolean sentButtonisEnable = driver
				.findElement(
						By.xpath("html/body/div[4]/div[3]/div[1]/div/div[1]/div[1]/a/span"))
				.isEnabled();
		String sentButtonName = driver
				.findElement(
						By.xpath("html/body/div[4]/div[3]/div[1]/div/div[1]/div[1]/a/span"))
				.getText();
		Assert.assertTrue(sentButtonisEnable);
		Assert.assertEquals("����", sentButtonName);
		sleep();
		sleep();
		boolean queryButtonisEnable = driver.findElement(
				By.xpath(".//*[@id='J_searchBtn']/a/span")).isEnabled();
		String queryName = driver.findElement(
				By.xpath(".//*[@id='J_searchBtn']/a/span")).getText();
		Assert.assertTrue(queryButtonisEnable);
		Assert.assertEquals("��ѯ", queryName);

	}

	/**
	 * ���������ʼ�
	 * @throws IOException 
	 */
	//@Test
	public void sentEmail() throws IOException {
		
		String expectedCurrenturl = "http://jw." + env
				+ "ablesky.com/mailRedirect.do?action=toReceiveMail";
		driver.findElement(By.xpath("html/body/div[4]/div[1]/ul/li[11]/a"))
				.click();// �ҵ����䵼��
		String actualCurrenturl = driver.getCurrentUrl();
		String title = driver.getTitle() + "  �ҵ�����";
		System.out.println(title + "\n" + actualCurrenturl);
		assertEquals(expectedCurrenturl, actualCurrenturl);
		sleep();sleep();
		sleep();sleep();
		
		//String count0=driver.findElement(By.id("J_totalCount")).getText();
		//String ss=driver.findElement(By.className("dataTables_empty")).getText();
		
	//	System.out.println("kkkkkkkkkkkkkkkkkkk"+ss);
//		if(!"���޼�¼".equals(ss)){
//		driver.findElement(By.className("checkbox_all")).click();
//		sleep();sleep();sleep();
//		driver.findElement(By.id("checkdel")).click();
//		sleep();sleep();
//		driver.findElement(By.xpath("html/body/div[7]/table/tbody/tr[2]/td[2]/div[3]/button[1]")).click();
//		sleep();sleep();
//		}
//		else{
		
		driver.findElement(
				By.xpath("html/body/div[4]/div[3]/div[1]/div/div[1]/div[1]/a/span"))
				.click();// ������Ű�ť
		sleep();sleep();
		driver.findElement(By.xpath(".//*[@id='recipients']")).click();// ���ѡ���ռ���
		driver.findElement(By.id("recipients")).click();
		driver.findElement(By.id("choice_clc_keyword")).click();
		driver.findElement(By.id("choice_clc_keyword")).clear();
		driver.findElement(By.id("choice_clc_keyword")).sendKeys("auto_test");
		sleep();sleep();
		driver.findElement(By.cssSelector("span.bluebtn25_text")).click();
		sleep();sleep();
		driver.findElement(By.name("auto_test")).click();
		driver.findElement(By.cssSelector("button[type=\"button\"]")).click();
		sleep();sleep();
		driver.findElement(By.id("mailTitle")).click();
		driver.findElement(By.id("mailTitle")).clear();
		driver.findElement(By.id("mailTitle")).sendKeys("�����ʼ�");
		
		//д�ŵĵ����ݿؼ���ʱ��ȡ��������û����������
		//��λiframe.switchTo()�ᴴ��һ��TargetLocator���󣬿��Խ���ǰ�Ǳ�������ƶ�����Ҫ��λ��frame��
		driver.switchTo().frame("message-content_ifr");
		driver.findElement(By.id("tinymce")).click();
		driver.findElement(By.id("tinymce")).clear();
		driver.findElement(By.id("tinymce")).sendKeys("aaaaaaaaaaaaaaa");
		
		//����iframe
		driver.switchTo().defaultContent();
		
		sleep();sleep();
	    driver.findElement(By.xpath(".//*[@id='J_sumitform']")).click();
	    sleep();sleep();
		driver.findElement(By.xpath("html/body/div[4]/div[2]/div[1]/a/div")).click();//����ռ���
		 sleep();sleep();sleep();
		// System.out.println("aaaaaaaaaaaaa");
		// ��ͼ��������D����
			File screenShotFile = ((TakesScreenshot) driver)
					.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(screenShotFile, new File(
					"D:/auto_test/EmailTest/sentEmail.png"));
		String count=driver.findElement(By.id("J_totalCount")).getText();
		System.out.println("count:"+count);
		Assert.assertEquals("1", count);
		driver.findElement(By.className("checkbox_all")).click();
		sleep();sleep();sleep();
		driver.findElement(By.id("checkdel")).click();
		sleep();sleep();
		driver.findElement(By.xpath("html/body/div[7]/table/tbody/tr[2]/td[2]/div[3]/button[1]")).click();
		sleep();sleep();
	}
	//}

	/**
	 * �ռ���Ϊ��
	 */
	//@Test
	public void recevierisnull(){
		String expectedCurrenturl = "http://jw." + env
				+ "ablesky.com/mailRedirect.do?action=toReceiveMail";
		driver.findElement(By.xpath("html/body/div[4]/div[1]/ul/li[11]/a"))
				.click();// �ҵ����䵼��
		String actualCurrenturl = driver.getCurrentUrl();
		String title = driver.getTitle() + "  �ҵ�����";
		System.out.println(title + "\n" + actualCurrenturl);
		assertEquals(expectedCurrenturl, actualCurrenturl);
		sleep();sleep();
		driver.findElement(
				By.xpath("html/body/div[4]/div[3]/div[1]/div/div[1]/div[1]/a/span"))
				.click();// ������Ű�ť
		sleep();sleep();
		driver.findElement(By.id("mailTitle")).click();
		driver.findElement(By.id("mailTitle")).clear();
		driver.findElement(By.id("mailTitle")).sendKeys("�����ʼ�");
		sleep();sleep();
	    driver.findElement(By.xpath(".//*[@id='J_sumitform']")).click();
	    sleep();sleep();
	    //�Ե�����Ĵ���
	    Alert alert=driver.switchTo().alert();
	    String text=alert.getText();
	    Assert.assertEquals("�ռ��˲���Ϊ��", text);
	    System.out.println(text);
	    alert.accept();//�൱�ڵ��ȷ�ϰ�ť
	    sleep();sleep();
	    driver.findElement(By.id("cancelBtn")).click();
	    driver.findElement(By.xpath("html/body/div[7]/table/tbody/tr[2]/td[2]/div[3]/button[1]")).click();
	    sleep();
		
		
		
	}

	/**
	 * ����Ϊ��
	 */
	//@Test
	public void titileisnull(){
		String expectedCurrenturl = "http://jw." + env
				+ "ablesky.com/mailRedirect.do?action=toReceiveMail";
		driver.findElement(By.xpath("html/body/div[4]/div[1]/ul/li[11]/a"))
				.click();// �ҵ����䵼��
		String actualCurrenturl = driver.getCurrentUrl();
		String title = driver.getTitle() + "  �ҵ�����";
		System.out.println(title + "\n" + actualCurrenturl);
		assertEquals(expectedCurrenturl, actualCurrenturl);
		sleep();sleep();
		driver.findElement(
				By.xpath("html/body/div[4]/div[3]/div[1]/div/div[1]/div[1]/a/span"))
				.click();// ������Ű�ť
		sleep();sleep();
		
		driver.findElement(By.xpath(".//*[@id='recipients']")).click();// ���ѡ���ռ���
		driver.findElement(By.id("recipients")).click();
		driver.findElement(By.id("choice_clc_keyword")).click();
		driver.findElement(By.id("choice_clc_keyword")).clear();
		driver.findElement(By.id("choice_clc_keyword")).sendKeys("auto_test");
		sleep();sleep();
		driver.findElement(By.cssSelector("span.bluebtn25_text")).click();
		sleep();sleep();
		driver.findElement(By.name("auto_test")).click();
		driver.findElement(By.cssSelector("button[type=\"button\"]")).click();
//		driver.findElement(By.id("mailTitle")).click();
//		driver.findElement(By.id("mailTitle")).clear();
//		driver.findElement(By.id("mailTitle")).sendKeys("�����ʼ�");
		sleep();sleep();
	    driver.findElement(By.xpath(".//*[@id='J_sumitform']")).click();
	    sleep();sleep();
	    //�Ե�����Ĵ���
	    Alert alert=driver.switchTo().alert();
	    String text=alert.getText();
	    Assert.assertEquals("���ⲻ��Ϊ��", text);
	    System.out.println(text);
	    alert.accept();//�൱�ڵ��ȷ�ϰ�ť
	    sleep();sleep();
	    driver.findElement(By.id("cancelBtn")).click();
	    driver.findElement(By.xpath("html/body/div[7]/table/tbody/tr[2]/td[2]/div[3]/button[1]")).click();
	    sleep();
		
	}

	/**
	 * ���ⲻ�ܳ���100�ַ�
	 */
	@Test
	public void titileover100(){
		String expectedCurrenturl = "http://jw." + env
				+ "ablesky.com/mailRedirect.do?action=toReceiveMail";
		driver.findElement(By.xpath("html/body/div[4]/div[1]/ul/li[11]/a"))
				.click();// �ҵ����䵼��
		String actualCurrenturl = driver.getCurrentUrl();
		String title = driver.getTitle() + "  �ҵ�����";
		System.out.println(title + "\n" + actualCurrenturl);
		assertEquals(expectedCurrenturl, actualCurrenturl);
		sleep();sleep();
		driver.findElement(
				By.xpath("html/body/div[4]/div[3]/div[1]/div/div[1]/div[1]/a/span"))
				.click();// ������Ű�ť
		sleep();sleep();
		
		driver.findElement(By.xpath(".//*[@id='recipients']")).click();// ���ѡ���ռ���
		driver.findElement(By.id("recipients")).click();
		driver.findElement(By.id("choice_clc_keyword")).click();
		driver.findElement(By.id("choice_clc_keyword")).clear();
		driver.findElement(By.id("choice_clc_keyword")).sendKeys("auto_test");
		sleep();sleep();
		driver.findElement(By.cssSelector("span.bluebtn25_text")).click();
		sleep();sleep();
		driver.findElement(By.name("auto_test")).click();
		driver.findElement(By.cssSelector("button[type=\"button\"]")).click();
		driver.findElement(By.id("mailTitle")).click();
		driver.findElement(By.id("mailTitle")).clear();
		String ss="���շѿռ䰢���ͷ�������˽�˳����ʦ�͵Ŀռ䰢ʲ�ٿ������ϵĿռ䰢ʲ�ٿμ�����ʡ���ü���˹�μ��Ĺ���˯�����ܿ�Ͱ��Ͽμ�����Ŀռ䰡���㿨��˹�´���ͻ��򿨻�ˢ������ʲ�ٴ�����˹�ֵĿռ䰢ʲ�ٿμ���ʲ�ٿռ䰡���Ͽ�ʼ�Ŀռ䰡�ռ�ڿͻ��ذ�";
		driver.findElement(By.id("mailTitle")).sendKeys(ss);
		sleep();sleep();
	    driver.findElement(By.xpath(".//*[@id='J_sumitform']")).click();
	    sleep();sleep();
	    //�Ե�����Ĵ���
	    Alert alert=driver.switchTo().alert();
	    String text=alert.getText();
	    Assert.assertEquals("�������", text);
	    System.out.println(text);
	    alert.accept();//�൱�ڵ��ȷ�ϰ�ť
	    sleep();sleep();
	    driver.findElement(By.id("cancelBtn")).click();
	    driver.findElement(By.xpath("html/body/div[7]/table/tbody/tr[2]/td[2]/div[3]/button[1]")).click();
	    sleep();
		
	}

	/**
	 * 
	 */

}
