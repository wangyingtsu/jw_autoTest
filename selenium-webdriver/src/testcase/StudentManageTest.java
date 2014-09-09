package testcase;
import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
//import org.openqa.selenium.os.*;

public class StudentManageTest extends Base {
	
   /**添加学员 */
	  @Test
	  public void createStudent() {
	    
		String expectedCurrenturl = "http://jw."+ env
				+" .ablesky.com/studentRedirect.do?action=toManageStudent";
					
		driver.findElement(By.linkText("学员管理")).click();
		String actualCurrentur1 = driver.getCurrentUrl();//应该是取驱动当前的地址给actualCurrentur1
		String title = driver.getTitle() + "学员管理";//定义一个标题
		System.out.println(title + "\n" + actualCurrentur1);//控制台打印,程序员调程序用的(可有可无)                                                                                                                                                                                                                                                                                            
		assertEquals(expectedCurrenturl,actualCurrentur1);//比较两个值是否相等
		
	    driver.findElement(By.linkText("学员管理")).click();
	    driver.findElement(By.cssSelector("span.greenbtn25_text")).click();
	    driver.findElement(By.id("name")).click();
	    driver.findElement(By.id("name")).clear();
	    driver.findElement(By.id("name")).sendKeys("ymgg");
	    driver.findElement(By.xpath("(//input[@name='gender'])[2]")).click();
	    driver.findElement(By.name("mobile")).clear();
	    driver.findElement(By.name("mobile")).sendKeys("13522224444");
	    driver.findElement(By.name("recommenderIdbefore")).click();
	    driver.findElement(By.id("ymgg")).click();
	    driver.findElement(By.cssSelector("button[type=\"button\"]")).click();
	    driver.findElement(By.cssSelector("span.bluebtn30_text")).click();	    
	    
	/**删除学员*/
		driver.findElement(By.linkText("删除")).click();		
		//driver.findElement(By.xpath("(//a[contains(text(),'删除')])[1]")).click();//删除学员（数字显示第几个，列表中就删除第几个学员）
	    driver.findElement(By.cssSelector("button[type=\"button\"]")).click();	    
	    sleep();
	  }
	  
	  /**不能创建同名学员 */
		@Test
		public void Cannotcreatethesamestudents(){
			String expectedCurrenturl = "http://jw."+ env
				+".ablesky.com/studentRedirect.do?action=toManageStudent";
			String expectederrorMess ="姓名已存在，不能创建同名学员";//定义一个字符串的内容
			driver.findElement(By.linkText("学员管理")).click();
			String actualCurrentur1 = driver.getCurrentUrl();//应该是取驱动当前的地址给actualCurrentur1
			String title = driver.getTitle() + "学员管理";//定义一个标题
			System.out.println(title + "\n" + actualCurrentur1);//控制台打印,程序员调程序用的(可有可无)                                                                                                                                                                                                                                                                                            
			assertEquals(expectedCurrenturl,actualCurrentur1);//比较两个值是否相等
		    sleep();
		    driver.findElement(By.linkText("学员管理")).click();
		    driver.findElement(By.cssSelector("span.greenbtn25_text")).click();
		    driver.findElement(By.id("name")).click();
		    driver.findElement(By.id("name")).clear();
		    driver.findElement(By.id("name")).sendKeys("ymgg");
		    driver.findElement(By.name("mobile")).clear();
		    driver.findElement(By.name("mobile")).sendKeys("13222224444");
		    driver.findElement(By.name("recommenderIdbefore")).click();
		    driver.findElement(By.id("ymgg")).click();
		    driver.findElement(By.cssSelector("button[type=\"button\"]")).click();
		    driver.findElement(By.cssSelector("span.bluebtn30_text")).click();
		    sleep();
		    String actualerrorMess = driver.findElement(By.id("name_tip")).getText();//获取的name_tip字符串的值传给actualerrorMess对像
		    Assert.assertEquals(expectederrorMess, actualerrorMess);//expected是期望值，通常都是用户指定的内容，actual是被测试的代码返回的实际值（比较两个值是否相等）
		    
		    driver.findElement(By.cssSelector("span.graybtn30_text")).click();		    
					
		}
		
		/**姓名不能超过20个字符 */
		@Test
		public void nameover20(){
			String expectedCurrenturl = "http://jw."+ env
				+".ablesky.com/studentRedirect.do?action=toManageStudent";
			String errorname="ymymymymymymymymymymymymymymyjm121221";//错误姓名
			String rightname="ym12";//正确姓名
			driver.findElement(By.linkText("学员管理")).click();
			String actualCurrentur1 = driver.getCurrentUrl();//应该是取驱动当前的地址给actualCurrentur1
			String title = driver.getTitle() + "学员管理";//定义一个标题
			System.out.println(title + "\n" + actualCurrentur1);//控制台打印,程序员调程序用的(可有可无)                                                                                                                                                                                                                                                                                            
			assertEquals(expectedCurrenturl,actualCurrentur1);//比较两个值是否相等
		   
		    driver.findElement(By.linkText("学员管理")).click();
			driver.findElement(By.cssSelector("span.greenbtn25_text")).click();
			driver.findElement(By.id("name")).click();
			driver.findElement(By.id("name")).clear();
			driver.findElement(By.id("name")).sendKeys(errorname);
			driver.findElement(By.name("mobile")).clear();
			driver.findElement(By.name("mobile")).sendKeys("13222224444");
			driver.findElement(By.name("recommenderIdbefore")).click();
			driver.findElement(By.id("ymgg")).click();
			driver.findElement(By.cssSelector("button[type=\"button\"]")).click();
			driver.findElement(By.cssSelector("span.bluebtn30_text")).click();
			String actualerrorMess = driver.findElement(By.xpath(".//*[@id='J_createCircleBasic']/tbody/tr[1]/td[2]/div/label")).getText();
			String expectederror="最多20位字符";
			Assert.assertEquals(expectederror, actualerrorMess);//expected是期望值，通常都是用户指定的内容，actual是被测试的代码返回的实际值（比较两个值是否相等）
			sleep();
			driver.findElement(By.id("name")).clear();
			driver.findElement(By.id("name")).sendKeys(rightname);
			driver.findElement(By.cssSelector("span.bluebtn30_text")).click(); 
		   				
		}
		
		/**性别选择女*/
		@Test
		public void gentelIsfemal(){
			String expectedCurrenturl = "http://jw."+ env
				+".ablesky.com/studentRedirect.do?action=toManageStudent";
			driver.findElement(By.linkText("学员管理")).click();
			String actualCurrentur1 = driver.getCurrentUrl();//应该是取驱动当前的地址给actualCurrentur1
			String title = driver.getTitle() + "学员管理";//定义一个标题
			System.out.println(title + "\n" + actualCurrentur1);//控制台打印,程序员调程序用的(可有可无)                                                                                                                                                                                                                                                                                            
			assertEquals(expectedCurrenturl,actualCurrentur1);//比较两个值是否相等
		   		   
			driver.findElement(By.cssSelector("span.greenbtn25_text")).click();
		    driver.findElement(By.id("name")).click();
		    driver.findElement(By.id("name")).clear();
		    driver.findElement(By.id("name")).sendKeys("564655");
		    driver.findElement(By.xpath("(//input[@name='gender'])[2]")).click();
		    driver.findElement(By.cssSelector("span.bluebtn30_text")).click();
		    		
		}	
			
		/**手机号输入规则验证*/
		@Test
		public void mobileNumber(){
			String expectedCurrenturl = "http://jw."+ env
				+".ablesky.com/studentRedirect.do?action=toManageStudent";
			driver.findElement(By.linkText("学员管理")).click();
			String actualCurrentur1 = driver.getCurrentUrl();//应该是取驱动当前的地址给actualCurrentur1
			String title = driver.getTitle() + "学员管理";//定义一个标题
			System.out.println(title + "\n" + actualCurrentur1);//控制台打印,程序员调程序用的(可有可无)                                                                                                                                                                                                                                                                                            
			assertEquals(expectedCurrenturl,actualCurrentur1);//比较两个值是否相等
			sleep();
			driver.findElement(By.cssSelector("span.greenbtn25_text")).click();
		    driver.findElement(By.id("name")).click();
		    driver.findElement(By.id("name")).clear();
		    driver.findElement(By.id("name")).sendKeys("45544");
			//当手机号输入字符
		    driver.findElement(By.name("mobile")).clear();
		    driver.findElement(By.name("mobile")).sendKeys("jcvjgcfjnvcnbvmn");
		    driver.findElement(By.cssSelector("span.bluebtn30_text")).click();
		    sleep();
			String expectedErrorMess01="手机号码格式错误";
			String actualerrorMessage01=driver.findElement(By.xpath(".//*[@id='J_createCircleBasic']/tbody/tr[3]/td[2]/div/label")).getText();
			Assert.assertEquals(expectedErrorMess01, actualerrorMessage01);
			//当手机号输入位数小于13位
			driver.findElement(By.name("mobile")).clear();
		    driver.findElement(By.name("mobile")).sendKeys("13236436");
		    driver.findElement(By.cssSelector("span.bluebtn30_text")).click();
		    sleep();
			String expectedErrorMess02="手机号码格式错误";
			String actualerrorMessage02=driver.findElement(By.xpath(".//*[@id='J_createCircleBasic']/tbody/tr[3]/td[2]/div/label")).getText();
			Assert.assertEquals(expectedErrorMess02, actualerrorMessage02);
			//当手机号输入超过13位
			driver.findElement(By.name("mobile")).clear();
		    driver.findElement(By.name("mobile")).sendKeys("132333355556");
		    driver.findElement(By.cssSelector("span.bluebtn30_text")).click();
		    sleep();
			String expectedErrorMess03="手机号码格式错误";
			String actualerrorMessage03=driver.findElement(By.xpath(".//*[@id='J_createCircleBasic']/tbody/tr[3]/td[2]/div/label")).getText();
			Assert.assertEquals(expectedErrorMess03, actualerrorMessage03);
			//输入正确的手机号
			driver.findElement(By.name("mobile")).clear();
		    driver.findElement(By.name("mobile")).sendKeys("13266664444");
		    driver.findElement(By.cssSelector("span.bluebtn30_text")).click();			
			    
	    }
	  
	/**查询学员*/  
	@Test
	  public void queryStudent() {
		  
	    String expectedCurrenturl = "http://jw."+ env
				+".ablesky.com/studentRedirect.do?action=toManageStudent";
					
	    driver.findElement(By.linkText("学员管理")).click();
		String actualCurrentur1 = driver.getCurrentUrl();//应该是取驱动当前的地址给actualCurrentur1
		String title = driver.getTitle() + "学员管理";//定义一个标题
		System.out.println(title + "\n" + actualCurrentur1);//控制台打印,程序员调程序用的(可有可无)                                                                                                                                                                                                                                                                                            
		assertEquals(expectedCurrenturl,actualCurrentur1);//比较两个值是否相等
		
		driver.findElement(By.cssSelector("td.text-left > div")).click();
		driver.findElement(By.name("userName")).click();
		driver.findElement(By.name("userName")).clear();
		driver.findElement(By.name("userName")).sendKeys("ymgg");
		driver.findElement(By.cssSelector("em")).click();
		driver.findElement(By.id("data_type")).click();
		sleep();sleep();
		Select select= new Select(driver.findElement(By.id("data_type")));
		sleep();sleep();sleep();
		select.selectByValue("mobile");
		sleep();sleep();
		//按手机查询
		driver.findElement(By.name("userName")).click();
		driver.findElement(By.name("userName")).clear();
		driver.findElement(By.name("userName")).sendKeys("18201649665");
		driver.findElement(By.cssSelector("span.bluebtn25_text")).click();	  
	  }
	  
	/**修改学员*/ 
	  @Test
	  public void modifyStudent() {
		String expectedCurrenturl = "http://jw."+ env
				+".ablesky.com/studentRedirect.do?action=toManageStudent";
	    				
		driver.findElement(By.linkText("学员管理")).click();
		String actualCurrentur1 = driver.getCurrentUrl();//应该是取驱动当前的地址给actualCurrentur1
		String title = driver.getTitle() + "学员管理";//定义一个标题
		System.out.println(title + "\n" + actualCurrentur1);//控制台打印,程序员调程序用的(可有可无)                                                                                                                                                                                                                                                                                            
		assertEquals(expectedCurrenturl,actualCurrentur1);//比较两个值是否相等
		
	    driver.findElement(By.cssSelector("a.current")).click();
	    driver.findElement(By.linkText("修改")).click();
	    driver.findElement(By.id("name")).click();
	    driver.findElement(By.id("name")).clear();
	    driver.findElement(By.id("name")).sendKeys("ggggggg");
	    driver.findElement(By.name("mobile")).clear();
	    driver.findElement(By.name("mobile")).sendKeys("13233332222");
	    driver.findElement(By.cssSelector("span.bluebtn30_text")).click();
	  } 
	  
	/**添加备注*/
	  @Test
	  public void Message() {
		String expectedCurrenturl = "http://jw."+ env
				+".ablesky.com/studentRedirect.do?action=toManageStudent";
	    				
		driver.findElement(By.linkText("学员管理")).click();
		String actualCurrentur1 = driver.getCurrentUrl();//应该是取驱动当前的地址给actualCurrentur1
		String title = driver.getTitle() + "学员管理";//定义一个标题
		System.out.println(title + "\n" + actualCurrentur1);//控制台打印,程序员调程序用的(可有可无)                                                                                                                                                                                                                                                                                            
		assertEquals(expectedCurrenturl,actualCurrentur1);//比较两个值是否相等
		
		driver.findElement(By.linkText("学员管理")).click();
		driver.findElement(By.linkText("备注")).click();
		driver.findElement(By.cssSelector("span.greenbtn25_text")).click();
		driver.findElement(By.name("title")).click();
	    driver.findElement(By.name("title")).clear();
		driver.findElement(By.name("title")).sendKeys("gdsgfdsggfdsgfds");
		driver.findElement(By.name("content")).click();
		driver.findElement(By.name("content")).clear();
		driver.findElement(By.name("content")).sendKeys("gfdsgfdsgfsdgfdsgfsdgfdsgfdsgfd");
		driver.findElement(By.id("J_getStartTime")).click();
		driver.findElement(By.cssSelector("td.td.today")).click();
		driver.findElement(By.cssSelector("span.bluebtn30_text")).click();		  
	  }
	  
	/**发送短信*/
	 @Test
	  public void SmsComposeTask() {
		String expectedCurrenturl = "http://jw."+ env
				+".ablesky.com/studentRedirect.do?action=toManageStudent";
	    				
		driver.findElement(By.linkText("学员管理")).click();
		String actualCurrentur1 = driver.getCurrentUrl();//应该是取驱动当前的地址给actualCurrentur1
		String title = driver.getTitle() + "学员管理";//定义一个标题
		System.out.println(title + "\n" + actualCurrentur1);//控制台打印,程序员调程序用的(可有可无)                                                                                                                                                                                                                                                                                            
		assertEquals(expectedCurrenturl,actualCurrentur1);//比较两个值是否相等
		
		driver.findElement(By.xpath("(//a[contains(text(),'发送短信')])[2]")).click();//点击列表中的第几个发送短信
		driver.findElement(By.linkText("插入字段")).click();	    
	    driver.findElement(By.id("insertField")).click();
	    Select select = new Select(driver.findElement(By.id("insertField")));//选择下拉列表方法	
	    driver.findElement(By.xpath("//select[@id='insertField']/option[4]")).click();
	    driver.findElement(By.id("message_text")).click();
	    driver.findElement(By.id("message_text")).clear();
	    driver.findElement(By.id("message_text")).sendKeys("{手机}sgsdfgdsfggfsdgsdfgsdfg");
	    driver.findElement(By.id("save_as_template")).click();
	    driver.findElement(By.cssSelector("button[type=\"button\"]")).click();
	  }
	 
	/**选择短信模板*/
	 @Test
	  public void SMSTemplate() {
		String expectedCurrenturl = "http://jw."+ env
				+".ablesky.com/studentRedirect.do?action=toManageStudent";		    				
		driver.findElement(By.linkText("学员管理")).click();
		String actualCurrentur1 = driver.getCurrentUrl();//应该是取驱动当前的地址给actualCurrentur1
		String title = driver.getTitle() + "学员管理";//定义一个标题
		System.out.println(title + "\n" + actualCurrentur1);//控制台打印,程序员调程序用的(可有可无)                                                                                                                                                                                                                                                                                            
		assertEquals(expectedCurrenturl,actualCurrentur1);//比较两个值是否相等		
	    
	    driver.findElement(By.xpath("(//a[contains(text(),'发送短信')])[2]")).click();
	    driver.findElement(By.id("template")).click();
	    driver.findElement(By.xpath("(//input[@name='content'])[5]")).click();
	    driver.findElement(By.xpath("(//button[@type='button'])[3]")).click();
	    driver.findElement(By.cssSelector("button[type=\"button\"]")).click();	    
	    //删除短信模板		
		driver.findElement(By.xpath("(//a[contains(text(),'发送短信')])[2]")).click();
		driver.findElement(By.id("template")).click();
		driver.findElement(By.id("155")).click();//需手工改动数字进行删除，数字要跟删除按钮的id一致
		driver.findElement(By.xpath("(//button[@type='button'])[3]")).click();
		driver.findElement(By.xpath("(//button[@type='button'])[2]")).click();
		
      }
	  
	  /**标记重要程度*/
		 @Test
		  public void Tagtodegree() {
			String expectedCurrenturl = "http://jw."+ env
				+".ablesky.com/studentRedirect.do?action=toManageStudent";			    				
			driver.findElement(By.linkText("学员管理")).click();
			String actualCurrentur1 = driver.getCurrentUrl();//应该是取驱动当前的地址给actualCurrentur1
			String title = driver.getTitle() + "学员管理";//定义一个标题
			System.out.println(title + "\n" + actualCurrentur1);//控制台打印,程序员调程序用的(可有可无)                                                                                                                                                                                                                                                                                            
			assertEquals(expectedCurrenturl,actualCurrentur1);//比较两个值是否相等
			
			driver.findElement(By.cssSelector("a.current")).click();
		    driver.findElement(By.id("6515")).click();//需手工改动数字进行删除，数字要跟删除按钮的id一致
		    driver.findElement(By.name("level")).click();
		    sleep();
		    driver.findElement(By.cssSelector("button[type=\"button\"]")).click();
		    sleep();
		    driver.findElement(By.id("6515")).click();//需手工改动数字进行删除，数字要跟删除按钮的id一致
	  }
		//检查导出excel按钮
		@Test
		public void exportbutton(){
			driver.findElement(By.linkText("学员管理")).click();
			String exportButtonname="导出Excel文件";
			WebElement exportButton=driver.findElement(By.xpath(".//*[@id='export']/span"));
			Boolean isexportButton= exportButton.isEnabled();
			String relexportButtonName=exportButton.getText();
			Assert.assertTrue(isexportButton);
			Assert.assertEquals(exportButtonname, relexportButtonName);
			System.out.println("导出Excel文件按钮是否可用 ：   "+isexportButton+"\n"+"导出Excel文件按钮的名称："+relexportButtonName);
		}
}