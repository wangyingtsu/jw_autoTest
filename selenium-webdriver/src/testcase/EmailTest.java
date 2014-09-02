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

	//此为发送邮件的公共方法，不是test方法
	public void sentAEmail(){
		String expectedCurrenturl = "http://jw." + env
				+ "ablesky.com/mailRedirect.do?action=toReceiveMail";
		driver.findElement(By.xpath("html/body/div[4]/div[1]/ul/li[11]/a"))
				.click();// 我的邮箱导航
		String actualCurrenturl = driver.getCurrentUrl();
		String title = driver.getTitle() + "  我的信箱";
		System.out.println(title + "\n" + actualCurrenturl);
		assertEquals(expectedCurrenturl, actualCurrenturl);
		sleep();
		sleep();
		driver.findElement(
				By.xpath("html/body/div[4]/div[3]/div[1]/div/div[1]/div[1]/a/span"))
				.click();// 点击发信按钮
		sleep();
		sleep();
		driver.findElement(By.xpath(".//*[@id='recipients']")).click();// 点击选择收件人
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
		driver.findElement(By.id("mailTitle")).sendKeys("测试邮件");

		// 写信的的内容控件暂时获取不到，故没有输入内容
		// 定位iframe.switchTo()会创建一个TargetLocator对象，可以将当前是别的主体移动到需要定位的frame上
		driver.switchTo().frame("message-content_ifr");
		driver.findElement(By.id("tinymce")).click();
		driver.findElement(By.id("tinymce")).clear();
		driver.findElement(By.id("tinymce")).sendKeys("aaaaaaaaaaaaaaa");

		// 跳出iframe
		driver.switchTo().defaultContent();


		sleep();
		sleep();
		driver.findElement(By.xpath(".//*[@id='J_sumitform']")).click();
		sleep();
	}
	
	
	/**
	 * 界面按钮基本检查
	 */
	 @Test
	public void allbuttonscheck() {
		String expectedCurrenturl = "http://jw." + env
				+ "ablesky.com/mailRedirect.do?action=toReceiveMail";
		driver.findElement(By.xpath("html/body/div[4]/div[1]/ul/li[11]/a"))
				.click();// 我的邮箱导航
		String actualCurrenturl = driver.getCurrentUrl();
		String title = driver.getTitle() + "  我的信箱";
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
		Assert.assertEquals("发信", sentButtonName);
		sleep();
		sleep();
		boolean queryButtonisEnable = driver.findElement(
				By.xpath(".//*[@id='J_searchBtn']/a/span")).isEnabled();
		String queryName = driver.findElement(
				By.xpath(".//*[@id='J_searchBtn']/a/span")).getText();
		Assert.assertTrue(queryButtonisEnable);
		Assert.assertEquals("查询", queryName);

	}

	/**
	 * 正常发送邮件
	 * 
	 * @throws IOException
	 */
	 @Test
	public void sentEmail() throws IOException {

		String expectedCurrenturl = "http://jw." + env
				+ "ablesky.com/mailRedirect.do?action=toReceiveMail";
		driver.findElement(By.xpath("html/body/div[4]/div[1]/ul/li[11]/a"))
				.click();// 我的邮箱导航
		String actualCurrenturl = driver.getCurrentUrl();
		String title = driver.getTitle() + "  我的信箱";
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
		// if(!"暂无记录".equals(ss)){
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
				.click();// 点击发信按钮
		sleep();
		sleep();
		driver.findElement(By.xpath(".//*[@id='recipients']")).click();// 点击选择收件人
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
		driver.findElement(By.id("mailTitle")).sendKeys("测试邮件");

		// 写信的的内容控件暂时获取不到，故没有输入内容
		// 定位iframe.switchTo()会创建一个TargetLocator对象，可以将当前是别的主体移动到需要定位的frame上
		driver.switchTo().frame("message-content_ifr");
		driver.findElement(By.id("tinymce")).click();
		driver.findElement(By.id("tinymce")).clear();
		driver.findElement(By.id("tinymce")).sendKeys("aaaaaaaaaaaaaaa");

		// 跳出iframe
		driver.switchTo().defaultContent();

		sleep();
		sleep();
		driver.findElement(By.xpath(".//*[@id='J_sumitform']")).click();
		sleep();
		sleep();
		driver.findElement(By.xpath("html/body/div[4]/div[2]/div[1]/a/div"))
				.click();// 点击收件箱
		sleep();
		sleep();
		sleep();
		// System.out.println("aaaaaaaaaaaaa");
		// 截图并保存在D盘下
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
	 * 收件人为空
	 * 
	 * @throws IOException
	 */
	 @Test
	public void recevierisnull() throws IOException {
		String expectedCurrenturl = "http://jw." + env
				+ "ablesky.com/mailRedirect.do?action=toReceiveMail";
		driver.findElement(By.xpath("html/body/div[4]/div[1]/ul/li[11]/a"))
				.click();// 我的邮箱导航
		String actualCurrenturl = driver.getCurrentUrl();
		String title = driver.getTitle() + "  我的信箱";
		System.out.println(title + "\n" + actualCurrenturl);
		assertEquals(expectedCurrenturl, actualCurrenturl);
		sleep();
		sleep();
		driver.findElement(
				By.xpath("html/body/div[4]/div[3]/div[1]/div/div[1]/div[1]/a/span"))
				.click();// 点击发信按钮
		sleep();
		sleep();
		driver.findElement(By.id("mailTitle")).click();
		driver.findElement(By.id("mailTitle")).clear();
		driver.findElement(By.id("mailTitle")).sendKeys("测试邮件");
		sleep();
		sleep();
		driver.findElement(By.xpath(".//*[@id='J_sumitform']")).click();
		sleep();
		sleep();
		// 截图并保存在D盘下
		File screenShotFile = ((TakesScreenshot) driver)
				.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenShotFile, new File(
				"D:/auto_test/EmailTest/revicerisNull.png"));
		// 对弹出框的处理
		Alert alert = driver.switchTo().alert();
		String text = alert.getText();
		Assert.assertEquals("收件人不能为空", text);
		System.out.println(text);
		alert.accept();// 相当于点击确认按钮
		sleep();
		sleep();
		driver.findElement(By.id("cancelBtn")).click();
		driver.findElement(
				By.xpath("html/body/div[7]/table/tbody/tr[2]/td[2]/div[3]/button[1]"))
				.click();
		sleep();

	}

	/**
	 * 主题为空
	 */
	 @Test
	public void titileisnull() {
		String expectedCurrenturl = "http://jw." + env
				+ "ablesky.com/mailRedirect.do?action=toReceiveMail";
		driver.findElement(By.xpath("html/body/div[4]/div[1]/ul/li[11]/a"))
				.click();// 我的邮箱导航
		String actualCurrenturl = driver.getCurrentUrl();
		String title = driver.getTitle() + "  我的信箱";
		System.out.println(title + "\n" + actualCurrenturl);
		assertEquals(expectedCurrenturl, actualCurrenturl);
		sleep();
		sleep();
		driver.findElement(
				By.xpath("html/body/div[4]/div[3]/div[1]/div/div[1]/div[1]/a/span"))
				.click();// 点击发信按钮
		sleep();
		sleep();

		driver.findElement(By.xpath(".//*[@id='recipients']")).click();// 点击选择收件人
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
		// driver.findElement(By.id("mailTitle")).sendKeys("测试邮件");
		sleep();
		sleep();
		driver.findElement(By.xpath(".//*[@id='J_sumitform']")).click();
		sleep();
		sleep();
		// 对弹出框的处理
		Alert alert = driver.switchTo().alert();
		String text = alert.getText();
		Assert.assertEquals("主题不能为空", text);
		System.out.println(text);
		alert.accept();// 相当于点击确认按钮
		sleep();
		sleep();
		driver.findElement(By.id("cancelBtn")).click();
		driver.findElement(
				By.xpath("html/body/div[7]/table/tbody/tr[2]/td[2]/div[3]/button[1]"))
				.click();
		sleep();

	}

	/**
	 * 主题不能超过100字符
	 */
	 @Test
	public void titileover100() {
		String expectedCurrenturl = "http://jw." + env
				+ "ablesky.com/mailRedirect.do?action=toReceiveMail";
		driver.findElement(By.xpath("html/body/div[4]/div[1]/ul/li[11]/a"))
				.click();// 我的邮箱导航
		String actualCurrenturl = driver.getCurrentUrl();
		String title = driver.getTitle() + "  我的信箱";
		System.out.println(title + "\n" + actualCurrenturl);
		assertEquals(expectedCurrenturl, actualCurrenturl);
		sleep();
		sleep();
		driver.findElement(
				By.xpath("html/body/div[4]/div[3]/div[1]/div/div[1]/div[1]/a/span"))
				.click();// 点击发信按钮
		sleep();
		sleep();

		driver.findElement(By.xpath(".//*[@id='recipients']")).click();// 点击选择收件人
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
		String ss = "和收费空间阿三和发快件阿克江顺达会计师和的空间阿什顿看见爱上的空间阿什顿课件安徽省看得见哈斯课件的哈快睡觉但很快就阿迪课件阿红的空间啊花点卡和斯柯达哈客户打卡机刷卡机阿什顿打撒阿斯钢的空间阿什顿课件阿什顿空间啊哈上课始的空间啊空间黑客基地啊";
		driver.findElement(By.id("mailTitle")).sendKeys(ss);
		sleep();
		sleep();
		driver.findElement(By.xpath(".//*[@id='J_sumitform']")).click();
		sleep();
		sleep();
		// 对弹出框的处理
		Alert alert = driver.switchTo().alert();
		String text = alert.getText();
		Assert.assertEquals("主题过长", text);
		System.out.println(text);
		alert.accept();// 相当于点击确认按钮
		sleep();
		sleep();
		driver.findElement(By.id("cancelBtn")).click();
		driver.findElement(
				By.xpath("html/body/div[7]/table/tbody/tr[2]/td[2]/div[3]/button[1]"))
				.click();
		sleep();

	}

	/**
	 * 收件箱查询
	 * 
	 * @throws IOException
	 */
	@Test
	public void queryInReceiveBox() throws IOException {
		String expectedCurrenturl = "http://jw." + env
				+ "ablesky.com/mailRedirect.do?action=toReceiveMail";
		driver.findElement(By.xpath("html/body/div[4]/div[1]/ul/li[11]/a"))
				.click();// 我的邮箱导航
		String actualCurrenturl = driver.getCurrentUrl();
		String title = driver.getTitle() + "  我的信箱";
		System.out.println(title + "\n" + actualCurrenturl);
		assertEquals(expectedCurrenturl, actualCurrenturl);
		sleep();
		sleep();
		sleep();
		sleep();
		String emailtitle = "测试邮件";
		String mm = "aab";
		int j = 3;
		for (int i = 1; i < j; i++) {
			emailtitle = emailtitle + mm;
			driver.findElement(
					By.xpath("html/body/div[4]/div[3]/div[1]/div/div[1]/div[1]/a/span"))
					.click();// 点击发信按钮
			sleep();
			sleep();
			driver.findElement(By.xpath(".//*[@id='recipients']")).click();// 点击选择收件人
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

			// 写信的的内容控件暂时获取不到，故没有输入内容
			// 定位iframe.switchTo()会创建一个TargetLocator对象，可以将当前是别的主体移动到需要定位的frame上
			driver.switchTo().frame("message-content_ifr");
			driver.findElement(By.id("tinymce")).click();
			driver.findElement(By.id("tinymce")).clear();
			driver.findElement(By.id("tinymce")).sendKeys("aaaaaaaaaaaaaaa");
			// 跳出iframe
			driver.switchTo().defaultContent();
			sleep();
			sleep();
			driver.findElement(By.xpath(".//*[@id='J_sumitform']")).click();
		}
		// 搜索出一封邮件
		driver.findElement(By.xpath("html/body/div[4]/div[2]/div[1]/a/div"))
				.click();// 点击收件箱
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
		// 搜索出0封邮件
		driver.findElement(By.xpath("html/body/div[4]/div[2]/div[1]/a/div"))
				.click();// 点击收件箱
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
		Assert.assertEquals("暂无记录", ss);
		if (ss.equals("暂无记录")) {
			System.out.println("there is no related email");
		} else {
			System.out.println("there is a error…… ");
		}

		// 清空收件箱
		sleep();
		sleep();
		driver.findElement(By.xpath("html/body/div[4]/div[2]/div[1]/a/div"))
				.click();// 点击收件箱
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
	 * 在(收件箱和发件箱)邮件列表删除邮件删除邮件
	 */
	@Test
	public void deleteEmailInEmailList(){
		String expectedCurrenturl = "http://jw." + env
				+ "ablesky.com/mailRedirect.do?action=toReceiveMail";
		driver.findElement(By.xpath("html/body/div[4]/div[1]/ul/li[11]/a"))
				.click();// 我的邮箱导航
		String actualCurrenturl = driver.getCurrentUrl();
		String title = driver.getTitle() + "  我的信箱";
		System.out.println(title + "\n" + actualCurrenturl);
		assertEquals(expectedCurrenturl, actualCurrenturl);
		sleep();
		sleep();
		driver.findElement(
				By.xpath("html/body/div[4]/div[3]/div[1]/div/div[1]/div[1]/a/span"))
				.click();// 点击发信按钮
		sleep();
		sleep();
		driver.findElement(By.xpath(".//*[@id='recipients']")).click();// 点击选择收件人
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
		driver.findElement(By.id("mailTitle")).sendKeys("测试邮件");
		sleep();
		driver.findElement(By.xpath(".//*[@id='J_sumitform']")).click();
		sleep();sleep();
		//在收件箱中删除所有邮件
		driver.findElement(By.xpath("html/body/div[4]/div[2]/div[1]/a/div"))
				.click();// 点击收件箱
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
	
		//在发件箱删除所有邮件
		driver.findElement(By.xpath("html/body/div[4]/div[1]/ul/li[11]/a"))
		.click();// 我的邮箱导航
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
	 * 标记为已读
	 */
	@Test
	public void markdealed(){
		sentAEmail();
		sleep();
		driver.findElement(By.xpath("html/body/div[4]/div[2]/div[1]/a/div"))
		.click();// 点击收件箱
		String unread=driver.findElement(By.xpath(".//*[@id='J_pmDataTablesTnbox']/tbody/tr/td[2]/a/div/span[1]")).getAttribute("title");
		System.out.println("****"+unread);
		Assert.assertEquals("未读", unread);
		sleep();sleep();
		driver.findElement(By.className("checkbox_all")).click();
		
		driver.findElement(By.id("setRead")).click();//点击标记为已读按钮
		sleep();sleep();
		String readed=driver.findElement(By.xpath(".//*[@id='J_pmDataTablesTnbox']/tbody/tr/td[2]/a/div/span[1]")).getAttribute("title");
		System.out.println("****"+readed);
		Assert.assertEquals("已读", readed);
		//删除
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
	 * 回复邮件
	 */
	@Test
	public void answeredEmail(){
		sentAEmail();
		WebElement e=driver.findElement(By.xpath("html/body/div[4]/div[2]/div[1]/a/div"));
		e.click();// 点击收件箱
		driver.findElement(By.xpath(".//*[@id='J_pmDataTablesTnbox']/tbody/tr[1]/td[2]/a/div/span[3]")).click();
		sleep();sleep();
		List<WebElement>  el=driver.findElements(By.className("operationbtn"));
		for(WebElement l:el){
			System.out.println(l.getAttribute("text"));
			String oper=l.getAttribute("text");
		
		
		
			if(oper.equals("回复")){
				l.click();//点击回复按钮
				
				driver.switchTo().frame("message-content_ifr");
				driver.findElement(By.id("tinymce")).click();
				driver.findElement(By.id("tinymce")).clear();
				driver.findElement(By.id("tinymce")).sendKeys("bbbbbbbbbbbbbbbbbbbbbb");

				// 跳出iframe
				driver.switchTo().defaultContent();
				
				sleep();
				driver.findElement(By.xpath(".//*[@id='J_sumitform']")).click();
				sleep();
		
		        break;
			}
			WebElement er=driver.findElement(By.xpath("html/body/div[4]/div[2]/div[1]/a/div"));
			er.click();// 点击收件箱
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
	 * 转发邮件
	 */
	@Test
	public void transpond(){
		sentAEmail();
		WebElement e=driver.findElement(By.xpath("html/body/div[4]/div[2]/div[1]/a/div"));
		e.click();// 点击收件箱
		driver.findElement(By.xpath(".//*[@id='J_pmDataTablesTnbox']/tbody/tr[1]/td[2]/a/div/span[3]")).click();
		sleep();sleep();
		List<WebElement>  el=driver.findElements(By.className("operationbtn"));
		for(WebElement l:el){
			System.out.println(l.getAttribute("text"));
			String oper=l.getAttribute("text");
			if(oper.equals("转发")){
				l.click();//点击转发按钮
				sleep();
				driver.findElement(By.xpath(".//*[@id='recipients']")).click();// 点击选择收件人
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

				// 跳出iframe
				driver.switchTo().defaultContent();
				
				sleep();
				driver.findElement(By.xpath(".//*[@id='J_sumitform']")).click();
				sleep();
		
		        break;
			}
		}
			WebElement er=driver.findElement(By.xpath("html/body/div[4]/div[2]/div[1]/a/div"));
			er.click();// 点击收件箱
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
			
		  //删除发件箱邮件
			driver.findElement(By.xpath("html/body/div[4]/div[1]/ul/li[11]/a"))
			.click();// 我的邮箱导航
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
	 * 在收件详情删除邮件
	 */
	@Test
	public void deleteEmailIndetailPage(){
		sentAEmail();
		WebElement e=driver.findElement(By.xpath("html/body/div[4]/div[2]/div[1]/a/div"));
		e.click();// 点击收件箱
		driver.findElement(By.xpath(".//*[@id='J_pmDataTablesTnbox']/tbody/tr[1]/td[2]/a/div/span[3]")).click();
		sleep();sleep();
		driver.findElement(By.id("deletemailDetails")).click();
		sleep();sleep();
		  //删除发件箱邮件
			driver.findElement(By.xpath("html/body/div[4]/div[1]/ul/li[11]/a"))
			.click();// 我的邮箱导航
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
