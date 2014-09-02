package testcase;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;

public class EmailTest extends Base {

	//��Ϊ�����ʼ��Ĺ�������������test����
	public void sentAEmail(){
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
		driver.findElement(
				By.xpath("html/body/div[4]/div[3]/div[1]/div/div[1]/div[1]/a/span"))
				.click();// ������Ű�ť
		sleep();
		sleep();
		driver.findElement(By.xpath(".//*[@id='recipients']")).click();// ���ѡ���ռ���
		driver.findElement(By.id("recipients")).click();
		driver.findElement(By.id("choice_clc_keyword")).click();
		driver.findElement(By.id("choice_clc_keyword")).clear();
		driver.findElement(By.id("choice_clc_keyword")).sendKeys("auto_test");
		sleep();
		sleep();
		driver.findElement(By.cssSelector("span.bluebtn25_text")).click();
		sleep();
		sleep();
		driver.findElement(By.name("auto_test")).click();
		driver.findElement(By.cssSelector("button[type=\"button\"]")).click();
		sleep();
		sleep();
		driver.findElement(By.id("mailTitle")).click();
		driver.findElement(By.id("mailTitle")).clear();
		driver.findElement(By.id("mailTitle")).sendKeys("�����ʼ�");

		// д�ŵĵ����ݿؼ���ʱ��ȡ��������û����������
		// ��λiframe.switchTo()�ᴴ��һ��TargetLocator���󣬿��Խ���ǰ�Ǳ�������ƶ�����Ҫ��λ��frame��
		driver.switchTo().frame("message-content_ifr");
		driver.findElement(By.id("tinymce")).click();
		driver.findElement(By.id("tinymce")).clear();
		driver.findElement(By.id("tinymce")).sendKeys("aaaaaaaaaaaaaaa");

		// ����iframe
		driver.switchTo().defaultContent();


		sleep();
		sleep();
		driver.findElement(By.xpath(".//*[@id='J_sumitform']")).click();
		sleep();
	}
	
	
	/**
	 * ���水ť�������
	 */
	 @Test
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
	 * 
	 * @throws IOException
	 */
	 @Test
	public void sentEmail() throws IOException {

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
		sleep();
		sleep();

		// String count0=driver.findElement(By.id("J_totalCount")).getText();
		// String
		// ss=driver.findElement(By.className("dataTables_empty")).getText();

		// System.out.println("kkkkkkkkkkkkkkkkkkk"+ss);
		// if(!"���޼�¼".equals(ss)){
		// driver.findElement(By.className("checkbox_all")).click();
		// sleep();sleep();sleep();
		// driver.findElement(By.id("checkdel")).click();
		// sleep();sleep();
		// driver.findElement(By.xpath("html/body/div[7]/table/tbody/tr[2]/td[2]/div[3]/button[1]")).click();
		// sleep();sleep();
		// }
		// else{

		driver.findElement(
				By.xpath("html/body/div[4]/div[3]/div[1]/div/div[1]/div[1]/a/span"))
				.click();// ������Ű�ť
		sleep();
		sleep();
		driver.findElement(By.xpath(".//*[@id='recipients']")).click();// ���ѡ���ռ���
		driver.findElement(By.id("recipients")).click();
		driver.findElement(By.id("choice_clc_keyword")).click();
		driver.findElement(By.id("choice_clc_keyword")).clear();
		driver.findElement(By.id("choice_clc_keyword")).sendKeys("auto_test");
		sleep();
		sleep();
		driver.findElement(By.cssSelector("span.bluebtn25_text")).click();
		sleep();
		sleep();
		driver.findElement(By.name("auto_test")).click();
		driver.findElement(By.cssSelector("button[type=\"button\"]")).click();
		sleep();
		sleep();
		driver.findElement(By.id("mailTitle")).click();
		driver.findElement(By.id("mailTitle")).clear();
		driver.findElement(By.id("mailTitle")).sendKeys("�����ʼ�");

		// д�ŵĵ����ݿؼ���ʱ��ȡ��������û����������
		// ��λiframe.switchTo()�ᴴ��һ��TargetLocator���󣬿��Խ���ǰ�Ǳ�������ƶ�����Ҫ��λ��frame��
		driver.switchTo().frame("message-content_ifr");
		driver.findElement(By.id("tinymce")).click();
		driver.findElement(By.id("tinymce")).clear();
		driver.findElement(By.id("tinymce")).sendKeys("aaaaaaaaaaaaaaa");

		// ����iframe
		driver.switchTo().defaultContent();

		sleep();
		sleep();
		driver.findElement(By.xpath(".//*[@id='J_sumitform']")).click();
		sleep();
		sleep();
		driver.findElement(By.xpath("html/body/div[4]/div[2]/div[1]/a/div"))
				.click();// ����ռ���
		sleep();
		sleep();
		sleep();
		// System.out.println("aaaaaaaaaaaaa");
		// ��ͼ��������D����
		File screenShotFile = ((TakesScreenshot) driver)
				.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenShotFile, new File(
				"D:/auto_test/EmailTest/sentEmail.png"));
		String count = driver.findElement(By.id("J_totalCount")).getText();
		System.out.println("count:" + count);
		Assert.assertEquals("1", count);
		driver.findElement(By.className("checkbox_all")).click();
		sleep();
		sleep();
		sleep();
		driver.findElement(By.id("checkdel")).click();
		sleep();
		sleep();
		driver.findElement(
				By.xpath("html/body/div[7]/table/tbody/tr[2]/td[2]/div[3]/button[1]"))
				.click();
		sleep();
		sleep();
	}

	// }

	/**
	 * �ռ���Ϊ��
	 * 
	 * @throws IOException
	 */
	 @Test
	public void recevierisnull() throws IOException {
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
		driver.findElement(
				By.xpath("html/body/div[4]/div[3]/div[1]/div/div[1]/div[1]/a/span"))
				.click();// ������Ű�ť
		sleep();
		sleep();
		driver.findElement(By.id("mailTitle")).click();
		driver.findElement(By.id("mailTitle")).clear();
		driver.findElement(By.id("mailTitle")).sendKeys("�����ʼ�");
		sleep();
		sleep();
		driver.findElement(By.xpath(".//*[@id='J_sumitform']")).click();
		sleep();
		sleep();
		// ��ͼ��������D����
		File screenShotFile = ((TakesScreenshot) driver)
				.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenShotFile, new File(
				"D:/auto_test/EmailTest/revicerisNull.png"));
		// �Ե�����Ĵ���
		Alert alert = driver.switchTo().alert();
		String text = alert.getText();
		Assert.assertEquals("�ռ��˲���Ϊ��", text);
		System.out.println(text);
		alert.accept();// �൱�ڵ��ȷ�ϰ�ť
		sleep();
		sleep();
		driver.findElement(By.id("cancelBtn")).click();
		driver.findElement(
				By.xpath("html/body/div[7]/table/tbody/tr[2]/td[2]/div[3]/button[1]"))
				.click();
		sleep();

	}

	/**
	 * ����Ϊ��
	 */
	 @Test
	public void titileisnull() {
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
		driver.findElement(
				By.xpath("html/body/div[4]/div[3]/div[1]/div/div[1]/div[1]/a/span"))
				.click();// ������Ű�ť
		sleep();
		sleep();

		driver.findElement(By.xpath(".//*[@id='recipients']")).click();// ���ѡ���ռ���
		driver.findElement(By.id("recipients")).click();
		driver.findElement(By.id("choice_clc_keyword")).click();
		driver.findElement(By.id("choice_clc_keyword")).clear();
		driver.findElement(By.id("choice_clc_keyword")).sendKeys("auto_test");
		sleep();
		sleep();
		driver.findElement(By.cssSelector("span.bluebtn25_text")).click();
		sleep();
		sleep();
		driver.findElement(By.name("auto_test")).click();
		driver.findElement(By.cssSelector("button[type=\"button\"]")).click();
		// driver.findElement(By.id("mailTitle")).click();
		// driver.findElement(By.id("mailTitle")).clear();
		// driver.findElement(By.id("mailTitle")).sendKeys("�����ʼ�");
		sleep();
		sleep();
		driver.findElement(By.xpath(".//*[@id='J_sumitform']")).click();
		sleep();
		sleep();
		// �Ե�����Ĵ���
		Alert alert = driver.switchTo().alert();
		String text = alert.getText();
		Assert.assertEquals("���ⲻ��Ϊ��", text);
		System.out.println(text);
		alert.accept();// �൱�ڵ��ȷ�ϰ�ť
		sleep();
		sleep();
		driver.findElement(By.id("cancelBtn")).click();
		driver.findElement(
				By.xpath("html/body/div[7]/table/tbody/tr[2]/td[2]/div[3]/button[1]"))
				.click();
		sleep();

	}

	/**
	 * ���ⲻ�ܳ���100�ַ�
	 */
	 @Test
	public void titileover100() {
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
		driver.findElement(
				By.xpath("html/body/div[4]/div[3]/div[1]/div/div[1]/div[1]/a/span"))
				.click();// ������Ű�ť
		sleep();
		sleep();

		driver.findElement(By.xpath(".//*[@id='recipients']")).click();// ���ѡ���ռ���
		driver.findElement(By.id("recipients")).click();
		driver.findElement(By.id("choice_clc_keyword")).click();
		driver.findElement(By.id("choice_clc_keyword")).clear();
		driver.findElement(By.id("choice_clc_keyword")).sendKeys("auto_test");
		sleep();
		sleep();
		driver.findElement(By.cssSelector("span.bluebtn25_text")).click();
		sleep();
		sleep();
		driver.findElement(By.name("auto_test")).click();
		driver.findElement(By.cssSelector("button[type=\"button\"]")).click();
		driver.findElement(By.id("mailTitle")).click();
		driver.findElement(By.id("mailTitle")).clear();
		String ss = "���շѿռ䰢���ͷ�������˽�˳����ʦ�͵Ŀռ䰢ʲ�ٿ������ϵĿռ䰢ʲ�ٿμ�����ʡ���ü���˹�μ��Ĺ���˯�����ܿ�Ͱ��Ͽμ�����Ŀռ䰡���㿨��˹�´���ͻ��򿨻�ˢ������ʲ�ٴ�����˹�ֵĿռ䰢ʲ�ٿμ���ʲ�ٿռ䰡���Ͽ�ʼ�Ŀռ䰡�ռ�ڿͻ��ذ�";
		driver.findElement(By.id("mailTitle")).sendKeys(ss);
		sleep();
		sleep();
		driver.findElement(By.xpath(".//*[@id='J_sumitform']")).click();
		sleep();
		sleep();
		// �Ե�����Ĵ���
		Alert alert = driver.switchTo().alert();
		String text = alert.getText();
		Assert.assertEquals("�������", text);
		System.out.println(text);
		alert.accept();// �൱�ڵ��ȷ�ϰ�ť
		sleep();
		sleep();
		driver.findElement(By.id("cancelBtn")).click();
		driver.findElement(
				By.xpath("html/body/div[7]/table/tbody/tr[2]/td[2]/div[3]/button[1]"))
				.click();
		sleep();

	}

	/**
	 * �ռ����ѯ
	 * 
	 * @throws IOException
	 */
	@Test
	public void queryInReceiveBox() throws IOException {
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
		sleep();
		sleep();
		String emailtitle = "�����ʼ�";
		String mm = "aab";
		int j = 3;
		for (int i = 1; i < j; i++) {
			emailtitle = emailtitle + mm;
			driver.findElement(
					By.xpath("html/body/div[4]/div[3]/div[1]/div/div[1]/div[1]/a/span"))
					.click();// ������Ű�ť
			sleep();
			sleep();
			driver.findElement(By.xpath(".//*[@id='recipients']")).click();// ���ѡ���ռ���
			driver.findElement(By.id("recipients")).click();
			driver.findElement(By.id("choice_clc_keyword")).click();
			driver.findElement(By.id("choice_clc_keyword")).clear();
			driver.findElement(By.id("choice_clc_keyword")).sendKeys(
					"auto_test");
			sleep();
			sleep();
			driver.findElement(By.cssSelector("span.bluebtn25_text")).click();
			sleep();
			sleep();
			driver.findElement(By.name("auto_test")).click();
			driver.findElement(By.cssSelector("button[type=\"button\"]"))
					.click();
			sleep();
			sleep();
			driver.findElement(By.id("mailTitle")).click();
			driver.findElement(By.id("mailTitle")).clear();
			driver.findElement(By.id("mailTitle")).sendKeys(emailtitle);

			// д�ŵĵ����ݿؼ���ʱ��ȡ��������û����������
			// ��λiframe.switchTo()�ᴴ��һ��TargetLocator���󣬿��Խ���ǰ�Ǳ�������ƶ�����Ҫ��λ��frame��
			driver.switchTo().frame("message-content_ifr");
			driver.findElement(By.id("tinymce")).click();
			driver.findElement(By.id("tinymce")).clear();
			driver.findElement(By.id("tinymce")).sendKeys("aaaaaaaaaaaaaaa");
			// ����iframe
			driver.switchTo().defaultContent();
			sleep();
			sleep();
			driver.findElement(By.xpath(".//*[@id='J_sumitform']")).click();
		}
		// ������һ���ʼ�
		driver.findElement(By.xpath("html/body/div[4]/div[2]/div[1]/a/div"))
				.click();// ����ռ���
		WebElement input = driver.findElement(By.name("userName"));
		input.click();
		input.clear();
		input.sendKeys("aabaab");
		driver.findElement(By.xpath(".//*[@id='J_searchBtn']/a/span")).click();
		sleep();
		String count = driver.findElement(By.id("J_totalCount")).getText();
		System.out.println("count:" + count);
		Assert.assertEquals("1", count);
		if (count.equals("1")) {
			System.out.println("queried a email");
		} else {
			System.out.println("there is a error ");
		}
		// ������0���ʼ�
		driver.findElement(By.xpath("html/body/div[4]/div[2]/div[1]/a/div"))
				.click();// ����ռ���
		sleep();
		sleep();
		WebElement input1 = driver.findElement(By.name("userName"));
		input1.click();
		input1.clear();
		input1.sendKeys("aabaabsssssssssss");
		driver.findElement(By.xpath(".//*[@id='J_searchBtn']/a/span")).click();
		sleep();
		String ss = driver.findElement(By.className("dataTables_empty"))
				.getText();
		Assert.assertEquals("���޼�¼", ss);
		if (ss.equals("���޼�¼")) {
			System.out.println("there is no related email");
		} else {
			System.out.println("there is a error���� ");
		}

		// ����ռ���
		sleep();
		sleep();
		driver.findElement(By.xpath("html/body/div[4]/div[2]/div[1]/a/div"))
				.click();// ����ռ���
		sleep();sleep();sleep();
		driver.findElement(By.className("checkbox_all")).click();
		sleep();
		sleep();
		driver.findElement(By.id("checkdel")).click();
		sleep();
		sleep();
		driver.findElement(
				By.xpath("html/body/div[7]/table/tbody/tr[2]/td[2]/div[3]/button[1]"))
				.click();
		sleep();
		sleep();

	}


	/**
	 * ��(�ռ���ͷ�����)�ʼ��б�ɾ���ʼ�ɾ���ʼ�
	 */
	@Test
	public void deleteEmailInEmailList(){
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
		driver.findElement(
				By.xpath("html/body/div[4]/div[3]/div[1]/div/div[1]/div[1]/a/span"))
				.click();// ������Ű�ť
		sleep();
		sleep();
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
		sleep();
		driver.findElement(By.xpath(".//*[@id='J_sumitform']")).click();
		sleep();sleep();
		//���ռ�����ɾ�������ʼ�
		driver.findElement(By.xpath("html/body/div[4]/div[2]/div[1]/a/div"))
				.click();// ����ռ���
		sleep();
		driver.findElement(By.className("checkbox_all")).click();
		sleep();
		sleep();
		sleep();
		driver.findElement(By.id("checkdel")).click();
		sleep();
		sleep();
		WebElement delete=driver.findElement(
				By.xpath("html/body/div[7]/table/tbody/tr[2]/td[2]/div[3]/button[1]"));
		delete.click();
		
		sleep();
	
		//�ڷ�����ɾ�������ʼ�
		driver.findElement(By.xpath("html/body/div[4]/div[1]/ul/li[11]/a"))
		.click();// �ҵ����䵼��
		driver.findElement(By.xpath("html/body/div[4]/div[2]/div[2]/a/div")).click();
		sleep();sleep();
		driver.findElement(By.className("checkbox_all")).click();
		
		sleep();
		sleep();
		driver.findElement(By.id("J_sendMessageToStudent")).click();
		sleep();
		sleep();
		WebElement  ss=driver.findElement(
				By.xpath("html/body/div[7]/table/tbody/tr[2]/td[2]/div[3]/button[1]"));
		ss.click();
//		List<WebElement> ss=driver.findElements(By.xpath("html/body/div[7]/table/tbody/tr[2]/td[2]/div[3]/button[1]"));
//		for(WebElement s:ss){
//			System.out.println(s.getAttribute("id"));
//		}
		
		
		sleep();
		driver.findElement(By.xpath("html/body/div[4]/div[2]/div[2]/a/div")).click();
	}

	/**
	 * ���Ϊ�Ѷ�
	 */
	@Test
	public void markdealed(){
		sentAEmail();
		sleep();
		driver.findElement(By.xpath("html/body/div[4]/div[2]/div[1]/a/div"))
		.click();// ����ռ���
		String unread=driver.findElement(By.xpath(".//*[@id='J_pmDataTablesTnbox']/tbody/tr/td[2]/a/div/span[1]")).getAttribute("title");
		System.out.println("****"+unread);
		Assert.assertEquals("δ��", unread);
		sleep();sleep();
		driver.findElement(By.className("checkbox_all")).click();
		
		driver.findElement(By.id("setRead")).click();//������Ϊ�Ѷ���ť
		sleep();sleep();
		String readed=driver.findElement(By.xpath(".//*[@id='J_pmDataTablesTnbox']/tbody/tr/td[2]/a/div/span[1]")).getAttribute("title");
		System.out.println("****"+readed);
		Assert.assertEquals("�Ѷ�", readed);
		//ɾ��
		driver.findElement(By.className("checkbox_all")).click();
		sleep();
		sleep();
		sleep();
		driver.findElement(By.id("checkdel")).click();
		sleep();
		sleep();
		WebElement delete=driver.findElement(
				By.xpath("html/body/div[7]/table/tbody/tr[2]/td[2]/div[3]/button[1]"));
		delete.click();
		
		sleep();
		driver.findElement(By.xpath("html/body/div[4]/div[2]/div[2]/a/div")).click();
			}

	/**
	 * �ظ��ʼ�
	 */
	@Test
	public void answeredEmail(){
		sentAEmail();
		WebElement e=driver.findElement(By.xpath("html/body/div[4]/div[2]/div[1]/a/div"));
		e.click();// ����ռ���
		driver.findElement(By.xpath(".//*[@id='J_pmDataTablesTnbox']/tbody/tr[1]/td[2]/a/div/span[3]")).click();
		sleep();sleep();
		List<WebElement>  el=driver.findElements(By.className("operationbtn"));
		for(WebElement l:el){
			System.out.println(l.getAttribute("text"));
			String oper=l.getAttribute("text");
		
		
		
			if(oper.equals("�ظ�")){
				l.click();//����ظ���ť
				
				driver.switchTo().frame("message-content_ifr");
				driver.findElement(By.id("tinymce")).click();
				driver.findElement(By.id("tinymce")).clear();
				driver.findElement(By.id("tinymce")).sendKeys("bbbbbbbbbbbbbbbbbbbbbb");

				// ����iframe
				driver.switchTo().defaultContent();
				
				sleep();
				driver.findElement(By.xpath(".//*[@id='J_sumitform']")).click();
				sleep();
		
		        break;
			}
			WebElement er=driver.findElement(By.xpath("html/body/div[4]/div[2]/div[1]/a/div"));
			er.click();// ����ռ���
			driver.findElement(By.className("checkbox_all")).click();
			sleep();
			sleep();
			sleep();
			driver.findElement(By.id("checkdel")).click();
			sleep();
			sleep();
			WebElement delete=driver.findElement(
					By.xpath("html/body/div[7]/table/tbody/tr[2]/td[2]/div[3]/button[1]"));
			delete.click();
			
			sleep();
			driver.findElement(By.xpath("html/body/div[4]/div[2]/div[2]/a/div")).click();
			
		}
		
		
		
		
		
	}

	/**
	 * ת���ʼ�
	 */
	@Test
	public void transpond(){
		sentAEmail();
		WebElement e=driver.findElement(By.xpath("html/body/div[4]/div[2]/div[1]/a/div"));
		e.click();// ����ռ���
		driver.findElement(By.xpath(".//*[@id='J_pmDataTablesTnbox']/tbody/tr[1]/td[2]/a/div/span[3]")).click();
		sleep();sleep();
		List<WebElement>  el=driver.findElements(By.className("operationbtn"));
		for(WebElement l:el){
			System.out.println(l.getAttribute("text"));
			String oper=l.getAttribute("text");
			if(oper.equals("ת��")){
				l.click();//���ת����ť
				sleep();
				driver.findElement(By.xpath(".//*[@id='recipients']")).click();// ���ѡ���ռ���
				driver.findElement(By.id("recipients")).click();
				driver.findElement(By.id("choice_clc_keyword")).click();
				driver.findElement(By.id("choice_clc_keyword")).clear();
				driver.findElement(By.id("choice_clc_keyword")).sendKeys("auto_test");
				sleep();
				sleep();
				driver.findElement(By.cssSelector("span.bluebtn25_text")).click();
				sleep();
				sleep();
				driver.findElement(By.name("auto_test")).click();
				driver.findElement(By.cssSelector("button[type=\"button\"]")).click();
				sleep();
				
				driver.switchTo().frame("message-content_ifr");
				driver.findElement(By.id("tinymce")).click();
				driver.findElement(By.id("tinymce")).clear();
				driver.findElement(By.id("tinymce")).sendKeys("ccccccccccccccccc");

				// ����iframe
				driver.switchTo().defaultContent();
				
				sleep();
				driver.findElement(By.xpath(".//*[@id='J_sumitform']")).click();
				sleep();
		
		        break;
			}
		}
			WebElement er=driver.findElement(By.xpath("html/body/div[4]/div[2]/div[1]/a/div"));
			er.click();// ����ռ���
			sleep();
			sleep();
			driver.findElement(By.className("checkbox_all")).click();
			sleep();
			sleep();
			driver.findElement(By.id("checkdel")).click();
			sleep();
			sleep();
			WebElement delete=driver.findElement(
					By.xpath("html/body/div[7]/table/tbody/tr[2]/td[2]/div[3]/button[1]"));
			delete.click();
			
			sleep();
			driver.findElement(By.xpath("html/body/div[4]/div[2]/div[2]/a/div")).click();
			
		  //ɾ���������ʼ�
			driver.findElement(By.xpath("html/body/div[4]/div[1]/ul/li[11]/a"))
			.click();// �ҵ����䵼��
			driver.findElement(By.xpath("html/body/div[4]/div[2]/div[2]/a/div")).click();
			sleep();sleep();
			driver.findElement(By.className("checkbox_all")).click();
			sleep();
			sleep();
			driver.findElement(By.id("J_sendMessageToStudent")).click();
			sleep();
			sleep();
			WebElement  ss=driver.findElement(
					By.xpath("html/body/div[7]/table/tbody/tr[2]/td[2]/div[3]/button[1]"));
			ss.click();
			sleep();
			driver.findElement(By.xpath("html/body/div[4]/div[2]/div[2]/a/div")).click();
		}
		
		
		


	/**
	 * ���ռ�����ɾ���ʼ�
	 */
	@Test
	public void deleteEmailIndetailPage(){
		sentAEmail();
		WebElement e=driver.findElement(By.xpath("html/body/div[4]/div[2]/div[1]/a/div"));
		e.click();// ����ռ���
		driver.findElement(By.xpath(".//*[@id='J_pmDataTablesTnbox']/tbody/tr[1]/td[2]/a/div/span[3]")).click();
		sleep();sleep();
		driver.findElement(By.id("deletemailDetails")).click();
		sleep();sleep();
		  //ɾ���������ʼ�
			driver.findElement(By.xpath("html/body/div[4]/div[1]/ul/li[11]/a"))
			.click();// �ҵ����䵼��
			driver.findElement(By.xpath("html/body/div[4]/div[2]/div[2]/a/div")).click();
			sleep();sleep();
			driver.findElement(By.className("checkbox_all")).click();
			sleep();
			sleep();
			driver.findElement(By.id("J_sendMessageToStudent")).click();
			sleep();
			sleep();
			WebElement  ss=driver.findElement(
					By.xpath("html/body/div[7]/table/tbody/tr[2]/td[2]/div[3]/button[1]"));
			ss.click();
			sleep();
			driver.findElement(By.xpath("html/body/div[4]/div[2]/div[2]/a/div")).click();
		
	}
	

}
