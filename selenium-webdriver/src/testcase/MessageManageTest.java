package testcase;

import static org.junit.Assert.assertEquals;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class MessageManageTest extends Base{
	/**
	 * 1.发布资讯
	 * 2.删除资讯
	 */
	@Test
	public void publishMessage (){
		String expectedCurrenturl = "http://jw." + env + "ablesky.com/infomationRedirect.do?action=toManage";
		driver.findElement(By.linkText("资讯管理")).click();
		String actualCurrentur1 = driver.getCurrentUrl();//应该是取驱动当前的地址给actualCurrentur1
		String title = driver.getTitle() + "资讯管理";//定义一个标题
		System.out.println(title + "\n" + actualCurrentur1);//控制台打印,程序员调程序用的(可有可无)                                                                                                                                                                                                                                                                                            
		assertEquals(expectedCurrenturl,actualCurrentur1);//比较两个值是否相等
		    
		driver.findElement(By.cssSelector("span.greenbtn25_text")).click();
		driver.findElement(By.id("title")).clear();
		driver.findElement(By.id("title")).sendKeys("1111");
		Select select = new Select(driver.findElement(By.id("J_selPlatForm")));//下拉列表
		select.selectByVisibleText("重大消息");
		driver.findElement(By.cssSelector("span.bluebtn30_text")).click();
		    
		// 删除
		 sleep();sleep();		
		 driver.findElement(By.linkText("删除")).click();
		 driver.findElement(By.xpath("html/body/div[7]/table/tbody/tr[2]/td[2]/div[3]/button[1]")).click();
	}
	
	 /**标题不能超过100个字符 */
	@Test
	public void nameover100(){
		String expectedCurrenturl = "http://jw." + env + "ablesky.com/infomationRedirect.do?action=toManage";
		String errorname="ymymymymymymymymymymymymymymymymymymymymymymymyjm121221ymymymymymymymymymymymymymymyjm121221ymymymymymymy"
				+ "mymymymymymymymyjm121221ymymymymymymymymymymymymymymyjm121221ymymymymymymymymymymymymymymymymymymymyjm121221ymymym"
				+ "ymymymymymymymymymymymyjm121221ymymymymymymymymymymymymymymyjm121221ymymymymymymymymymyjm121221ymymymymymyjm121221";//错误姓名
		String rightname="yggm12";//正确姓名
		driver.findElement(By.linkText("资讯管理")).click();
		String actualCurrentur1 = driver.getCurrentUrl();//应该是取驱动当前的地址给actualCurrentur1
		String title = driver.getTitle() + "资讯管理";//定义一个标题
		System.out.println(title + "\n" + actualCurrentur1);//控制台打印,程序员调程序用的(可有可无)                                                                                                                                                                                                                                                                                            
		assertEquals(expectedCurrenturl,actualCurrentur1);//比较两个值是否相等
	   
		driver.findElement(By.cssSelector("span.greenbtn25_text")).click();
	    driver.findElement(By.id("title")).clear();
	    driver.findElement(By.id("title")).sendKeys(errorname);
	    driver.findElement(By.cssSelector("span.bluebtn30_text")).click();		
	    Select select = new Select(driver.findElement(By.id("J_selPlatForm")));//下拉列表
		select.selectByVisibleText("重大消息");		
		String actualerrorMess = driver.findElement(By.xpath(".//*[@id='J_createCircleBasic']/tbody/tr[1]/td[2]/div/label")).getText();
		String expectederror="最多100个字符";
		Assert.assertEquals(expectederror, actualerrorMess);//expected是期望值，通常都是用户指定的内容，actual是被测试的代码返回的实际值（比较两个值是否相等）
		
		sleep();
		driver.findElement(By.id("title")).clear();
		driver.findElement(By.id("title")).sendKeys(rightname);
		driver.findElement(By.cssSelector("span.bluebtn30_text")).click(); 
		
		// 删除
		sleep();sleep();		
		driver.findElement(By.linkText("删除")).click();
		driver.findElement(By.xpath("html/body/div[7]/table/tbody/tr[2]/td[2]/div[3]/button[1]")).click();
	}
	
	/**标题不能为空 */
	@Test
	public void titleisempty(){
		String expectedCurrenturl = "http://jw." + env + "ablesky.com/infomationRedirect.do?action=toManage";
		driver.findElement(By.linkText("资讯管理")).click();
		String actualCurrentur1 = driver.getCurrentUrl();//应该是取驱动当前的地址给actualCurrentur1
		String title = driver.getTitle() + "资讯管理";//定义一个标题
		System.out.println(title + "\n" + actualCurrentur1);//控制台打印,程序员调程序用的(可有可无)                                                                                                                                                                                                                                                                                            
		assertEquals(expectedCurrenturl,actualCurrentur1);//比较两个值是否相等
		
		driver.findElement(By.cssSelector("span.greenbtn25_text")).click();
		Select select = new Select(driver.findElement(By.id("J_selPlatForm")));//下拉列表
	    select.selectByVisibleText("重大消息");
	    driver.findElement(By.cssSelector("span.bluebtn30_text")).click();
	    System.out.println("资讯标题不能为空");//打印	    
	    driver.findElement(By.id("title")).clear();
	    driver.findElement(By.id("title")).sendKeys("gfdsgfdsgfd");
	    driver.findElement(By.cssSelector("span.bluebtn30_text")).click();
	}
	
	/**
	 * 修改资讯
	 */
	@Test
	public void modifMessage(){
		String expectedCurrenturl = "http://jw." + env + "ablesky.com/infomationRedirect.do?action=toManage";
		driver.findElement(By.linkText("资讯管理")).click();
		String actualCurrentur1 = driver.getCurrentUrl();//应该是取驱动当前的地址给actualCurrentur1
		String title = driver.getTitle() + "资讯管理";//定义一个标题
		System.out.println(title + "\n" + actualCurrentur1);//控制台打印,程序员调程序用的(可有可无)                                                                                                                                                                                                                                                                                            
		assertEquals(expectedCurrenturl,actualCurrentur1);//比较两个值是否相等
		
		driver.findElement(By.linkText("修改")).click();
	    driver.findElement(By.id("title")).clear();
	    driver.findElement(By.id("title")).sendKeys("fff645654654");
	    Select select = new Select(driver.findElement(By.id("J_selPlatForm")));//下拉列表
	    select.selectByVisibleText("重大消息");
	    driver.findElement(By.cssSelector("span.bluebtn30_text")).click();
	    
	 // 删除
	 	sleep();sleep();		
	 	driver.findElement(By.linkText("删除")).click();
	 	driver.findElement(By.xpath("html/body/div[7]/table/tbody/tr[2]/td[2]/div[3]/button[1]")).click();
	}
	
	/**
	 * 搜索资讯
	 */
	@Test
	public void queryMessage(){
		String expectedCurrenturl = "http://jw." + env + "ablesky.com/infomationRedirect.do?action=toManage";
		driver.findElement(By.linkText("资讯管理")).click();
		String actualCurrentur1 = driver.getCurrentUrl();//应该是取驱动当前的地址给actualCurrentur1
		String title = driver.getTitle() + "资讯管理";//定义一个标题
		System.out.println(title + "\n" + actualCurrentur1);//控制台打印,程序员调程序用的(可有可无)                                                                                                                                                                                                                                                                                            
		assertEquals(expectedCurrenturl,actualCurrentur1);//比较两个值是否相等
		
		//全部名称查询
		driver.findElement(By.name("userName")).click();
	    driver.findElement(By.name("userName")).clear();
	    driver.findElement(By.name("userName")).sendKeys("hgdsgdsfgfdsgdsfgfdsgfsdgfsd");
	    driver.findElement(By.cssSelector("span.bluebtn25_text")).click();
		sleep();sleep();
		//模糊查询
		driver.findElement(By.cssSelector("a.current")).click();
	    driver.findElement(By.name("userName")).click();
	    driver.findElement(By.name("userName")).clear();
	    driver.findElement(By.name("userName")).sendKeys("gfsdg");
	    driver.findElement(By.cssSelector("span.bluebtn25_text")).click();
	    sleep();sleep();
	    //左右空格查询
	    driver.findElement(By.name("userName")).click();
	    driver.findElement(By.name("userName")).clear();
	    driver.findElement(By.name("userName")).sendKeys("    gfsdg     ");
	    driver.findElement(By.cssSelector("span.bluebtn25_text")).click();
	    sleep();sleep();
	  //中间空格查询
	    driver.findElement(By.name("userName")).click();
	    driver.findElement(By.name("userName")).click();
	    driver.findElement(By.name("userName")).clear();
	    driver.findElement(By.name("userName")).sendKeys("gfs    dg");
	    driver.findElement(By.cssSelector("span.bluebtn25_text")).click();
	    sleep();sleep();
	  //空查询
	    driver.findElement(By.name("userName")).click();
	    driver.findElement(By.name("userName")).clear();
	    driver.findElement(By.name("userName")).sendKeys("");
	    driver.findElement(By.cssSelector("span.bluebtn25_text")).click();
	}
	
	/**
	 * 检查页面各个按钮及按钮状态
	 */
	@Test
	public void checkbuttonsState(){
		
		//检查查询按钮
		String expdaddCButtonname="查询";
		driver.findElement(By.linkText("资讯管理")).click();
		WebElement createCourseButton=driver.findElement(By.cssSelector("span.bluebtn25_text"));
		Boolean addCButton= createCourseButton.isEnabled();
		String reladdCButtonname=createCourseButton.getText();
		Assert.assertTrue(addCButton);
		Assert.assertEquals(expdaddCButtonname, reladdCButtonname);
		System.out.println("查询按钮是否可用 ：   "+addCButton+"\n"+"查询按钮的名称："+reladdCButtonname);
		
		//检查详情按钮
		String QueryButtonname="详情";
		WebElement QueryButton=driver.findElement(By.xpath(".//*[@id='J_pmDataTables']/tbody/tr[1]/td[4]/div/a[1]"));
		Boolean iseQueryButton= QueryButton.isEnabled();
		String relQueryButtonname=QueryButton.getText();
		Assert.assertTrue(iseQueryButton);
		Assert.assertEquals(QueryButtonname, relQueryButtonname);
		System.out.println("详情按钮是否可用 ：   "+iseQueryButton+"\n"+"详情按钮的名称："+relQueryButtonname);
		
	}
	
}
