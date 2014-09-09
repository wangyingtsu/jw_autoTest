package testcase;

import static org.junit.Assert.assertEquals;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class TeacherManageTest extends Base {

	 /**添加正确的老师 */
	  @Test
	  public void CorrectTeacher() {
	    
			String expectedCurrenturl = "http://jw." + env + "ablesky.com/teacherRedirect.do?action=toManage";					
			driver.findElement(By.linkText("老师管理")).click();
			String actualCurrentur1 = driver.getCurrentUrl();//应该是取驱动当前的地址给actualCurrentur1
			String title = driver.getTitle() + "老师管理";//定义一个标题
			System.out.println(title + "\n" + actualCurrentur1);//控制台打印,程序员调程序用的(可有可无)                                                                                                                                                                                                                                                                                            
			assertEquals(expectedCurrenturl,actualCurrentur1);//比较两个值是否相等
		
			driver.findElement(By.cssSelector("span.greenbtn25_text")).click();
			driver.findElement(By.id("username")).clear();
			driver.findElement(By.id("username")).sendKeys("gfg111444777fgfgfgfg");
			driver.findElement(By.id("password")).clear();
			driver.findElement(By.id("password")).sendKeys("1234");
			driver.findElement(By.id("opassword")).clear();
			driver.findElement(By.id("opassword")).sendKeys("1234");
			driver.findElement(By.id("teachername")).clear();
			driver.findElement(By.id("teachername")).sendKeys("ffgg");
			
			Select select = new Select(driver.findElement(By.id("J_selPlatForm")));//选择下拉列表方法	
			select.selectByVisibleText("5445");
			
			driver.findElement(By.name("email")).clear();  
			driver.findElement(By.name("email")).sendKeys("df@163.com");
			driver.findElement(By.name("mobile")).clear();
		    driver.findElement(By.name("mobile")).sendKeys("13266665555");
		    driver.findElement(By.id("introduction")).clear();
		    driver.findElement(By.id("introduction")).sendKeys("ffdsafdsafdsafdasfdsafdsafdsfdsafdsafdsafdsafdasfdsafdsafdsfdsafdsafdsafdasfdsafdsafdsfdsafdsafdsafds");
			driver.findElement(By.cssSelector("span.bluebtn30_text")).click(); 
			
			// 删除
			sleep();
			sleep();
			driver.findElement(By.linkText("删除")).click();
			driver.findElement(By.xpath("html/body/div[7]/table/tbody/tr[2]/td[2]/div[3]/button[1]")).click();
	  }	
	  
	  /**不能创建同名老师 */
	   @Test
	   public void Cannotcreatethesameteacher(){
			String expectedCurrenturl = "http://jw." + env + "ablesky.com/teacherRedirect.do?action=toManage";
			String expectederrorMess ="老师已经存在，不能创建重名老师";//定义一个字符串的内容
			driver.findElement(By.linkText("老师管理")).click();
			String actualCurrentur1 = driver.getCurrentUrl();//应该是取驱动当前的地址给actualCurrentur1
			String title = driver.getTitle() + "老师管理";//定义一个标题
			System.out.println(title + "\n" + actualCurrentur1);//控制台打印,程序员调程序用的(可有可无)                                                                                                                                                                                                                                                                                            
			assertEquals(expectedCurrenturl,actualCurrentur1);//比较两个值是否相等
			
			driver.findElement(By.cssSelector("span.greenbtn25_text")).click();
			driver.findElement(By.id("username")).clear();
			driver.findElement(By.id("username")).sendKeys("gfg117771fgfgfgfg");
			driver.findElement(By.id("password")).clear();
			driver.findElement(By.id("password")).sendKeys("1234");
			driver.findElement(By.id("opassword")).clear();
			driver.findElement(By.id("opassword")).sendKeys("1234");
			driver.findElement(By.id("teachername")).clear();
			driver.findElement(By.id("teachername")).sendKeys("ffgg");
			
			Select select = new Select(driver.findElement(By.id("J_selPlatForm")));//选择下拉列表方法	
			select.selectByVisibleText("5445");
			
			driver.findElement(By.name("email")).clear();  
			driver.findElement(By.name("email")).sendKeys("df@163.com");
			driver.findElement(By.name("mobile")).clear();
		    driver.findElement(By.name("mobile")).sendKeys("13266665555");
		    driver.findElement(By.id("introduction")).clear();
		    driver.findElement(By.id("introduction")).sendKeys("ffdsafdsafdsafdasfdsafdsafdsfdsafdsafdsafdsafdasfdsafdsafdsfdsafdsafdsafdasfdsafdsafdsfdsafdsafdsafds");
			driver.findElement(By.cssSelector("span.bluebtn30_text")).click();
			sleep();
			String actualerrorMess = driver.findElement(By.id("name_tip")).getText();//获取的name_tip字符串的值传给actualerrorMess对像
			Assert.assertEquals(expectederrorMess, actualerrorMess);//expected是期望值，通常都是用户指定的内容，actual是被测试的代码返回的实际值（比较两个值是否相等）
			driver.findElement(By.cssSelector("span.graybtn30_text")).click();
		
	   }
	   
	   /**用户名不能超过20个字符 */
		@Test
		public void nameover20(){
			String expectedCurrenturl = "http://jw." + env + "ablesky.com/teacherRedirect.do?action=toManage";
			String errorname="ymymymymymymymymymymymymymymyjm121221";//错误姓名
			String rightname="yggm12";//正确姓名
			driver.findElement(By.linkText("老师管理")).click();
			String actualCurrentur1 = driver.getCurrentUrl();//应该是取驱动当前的地址给actualCurrentur1
			String title = driver.getTitle() + "老师管理";//定义一个标题
			System.out.println(title + "\n" + actualCurrentur1);//控制台打印,程序员调程序用的(可有可无)                                                                                                                                                                                                                                                                                            
			assertEquals(expectedCurrenturl,actualCurrentur1);//比较两个值是否相等
		   
			driver.findElement(By.cssSelector("span.greenbtn25_text")).click();
			driver.findElement(By.id("username")).clear();
			driver.findElement(By.id("username")).sendKeys(errorname);
			driver.findElement(By.id("password")).clear();
			driver.findElement(By.id("password")).sendKeys("1234");
			driver.findElement(By.id("opassword")).clear();
			driver.findElement(By.id("opassword")).sendKeys("1234");
			driver.findElement(By.id("teachername")).clear();
			driver.findElement(By.id("teachername")).sendKeys("ffgg");
			
			Select select = new Select(driver.findElement(By.id("J_selPlatForm")));//选择下拉列表方法	
			select.selectByVisibleText("5445");
			 
			driver.findElement(By.name("email")).clear();  
			driver.findElement(By.name("email")).sendKeys("df@163.com");
			driver.findElement(By.name("mobile")).clear();
		    driver.findElement(By.name("mobile")).sendKeys("13266665555");
		    driver.findElement(By.id("introduction")).clear();
		    driver.findElement(By.id("introduction")).sendKeys("ffdsafdsafdsafdasfdsafdsafdsfdsafdsafdsafdsafdasfdsafdsafdsfdsafdsafdsafdasfdsafdsafdsfdsafdsafdsafds");
		    driver.findElement(By.cssSelector("span.bluebtn30_text")).click();//确定
			
			String actualerrorMess = driver.findElement(By.xpath(".//*[@id='J_createCircleBasic']/tbody/tr[1]/td[2]/div/label")).getText();
			String expectederror="最多20个字符";
			Assert.assertEquals(expectederror, actualerrorMess);//expected是期望值，通常都是用户指定的内容，actual是被测试的代码返回的实际值（比较两个值是否相等）
			
			sleep();
			driver.findElement(By.id("username")).clear();
			driver.findElement(By.id("username")).sendKeys(rightname);
			driver.findElement(By.cssSelector("span.bluebtn30_text")).click(); 
					
		}
		
		/**两次密码输入不一致 */
		@Test
		public void Enteredpasswordsdiffer(){
			String expectedCurrenturl = "http://jw." + env + "ablesky.com/teacherRedirect.do?action=toManage";
			driver.findElement(By.linkText("老师管理")).click();
			String actualCurrentur1 = driver.getCurrentUrl();//应该是取驱动当前的地址给actualCurrentur1
			String title = driver.getTitle() + "老师管理";//定义一个标题
			System.out.println(title + "\n" + actualCurrentur1);//控制台打印,程序员调程序用的(可有可无)                                                                                                                                                                                                                                                                                            
			assertEquals(expectedCurrenturl,actualCurrentur1);//比较两个值是否相等
			
			driver.findElement(By.cssSelector("a.current")).click();
		    driver.findElement(By.cssSelector("span.greenbtn25_text")).click();
		    driver.findElement(By.id("username")).clear();
		    driver.findElement(By.id("username")).sendKeys("gs5554sdf");
		    driver.findElement(By.id("password")).clear();
		    driver.findElement(By.id("password")).sendKeys("1234");//正确密码
		    driver.findElement(By.id("opassword")).clear();
		    driver.findElement(By.id("opassword")).sendKeys("12345");//不相同密码
		    driver.findElement(By.id("teachername")).clear();
		    driver.findElement(By.id("teachername")).sendKeys("gdsfg");
		    driver.findElement(By.xpath("(//input[@name='gender'])[2]")).click();		    
		    Select select = new Select(driver.findElement(By.id("J_selPlatForm")));//选择下拉列表方法	
		    select.selectByVisibleText("5445");			
		    driver.findElement(By.name("email")).clear();
		    driver.findElement(By.name("email")).sendKeys("gfsd@163.com");
		    driver.findElement(By.cssSelector("span.bluebtn30_text")).click();		    
		    //String actualerrorMess = driver.findElement(By.xpath(".//*[@id='pwd_tip']")).getText();
			//String expectederror="两次密码输入不一致 ";
			//Assert.assertEquals(expectederror, actualerrorMess);//expected是期望值，通常都是用户指定的内容，actual是被测试的代码返回的实际值（比较两个值是否相等）
		    System.out.println("两次密码输入不一致");//打印
		    sleep();
		    driver.findElement(By.id("opassword")).clear();
		    driver.findElement(By.id("opassword")).sendKeys("1234");//修改后的正确密码
		    driver.findElement(By.cssSelector("span.bluebtn30_text")).click();  
		  	sleep();
		 	sleep();
		 	driver.findElement(By.linkText("删除")).click();// 删除
		 	driver.findElement(By.xpath("html/body/div[7]/table/tbody/tr[2]/td[2]/div[3]/button[1]")).click();
		}
		
		/**用户名为空 */
		@Test
		public void userisnull() {
			String expectedCurrenturl = "http://jw." + env + "ablesky.com/teacherRedirect.do?action=toManage";
			driver.findElement(By.linkText("老师管理")).click();
			String actualCurrentur1 = driver.getCurrentUrl();//应该是取驱动当前的地址给actualCurrentur1
			String title = driver.getTitle() + "老师管理";//定义一个标题
			System.out.println(title + "\n" + actualCurrentur1);//控制台打印,程序员调程序用的(可有可无)                                                                                                                                                                                                                                                                                            
			assertEquals(expectedCurrenturl,actualCurrentur1);//比较两个值是否相等
			
			driver.findElement(By.cssSelector("span.greenbtn25_text")).click();
		    driver.findElement(By.id("password")).clear();
		    driver.findElement(By.id("password")).sendKeys("1234");
		    driver.findElement(By.id("opassword")).clear();
		    driver.findElement(By.id("opassword")).sendKeys("1234");
		    driver.findElement(By.id("teachername")).clear();
		    driver.findElement(By.id("teachername")).sendKeys("dsfds");
		    Select select = new Select(driver.findElement(By.id("J_selPlatForm")));//选择下拉列表方法	
			select.selectByVisibleText("5445");	
		    driver.findElement(By.name("email")).clear();
		    driver.findElement(By.name("email")).sendKeys("fdsaf@163.com");
		    driver.findElement(By.cssSelector("span.bluebtn30_text")).click();
		    
		    //String actualerrorMess = driver.findElement(By.xpath(".//*[@id='J_createCircleBasic']/tbody/tr[1]/td[2]/div/label")).getText();
			//String expectederror="用户名不能为空 ";
			//Assert.assertEquals(expectederror, actualerrorMess);//expected是期望值，通常都是用户指定的内容，actual是被测试的代码返回的实际值（比较两个值是否相等）
			System.out.println("用户名不能为空");//打印
		    sleep();
		    driver.findElement(By.id("username")).clear();
		    driver.findElement(By.id("username")).sendKeys("fgf645654");
		    driver.findElement(By.cssSelector("span.bluebtn30_text")).click();
		    sleep();
		 	sleep();
		 	driver.findElement(By.linkText("删除")).click();// 删除
		 	driver.findElement(By.xpath("html/body/div[7]/table/tbody/tr[2]/td[2]/div[3]/button[1]")).click();
		}
		
		/**分配权限 */
		@Test
		public void PermissionAssignment(){
			String expectedCurrenturl = "http://jw." + env + "ablesky.com/teacherRedirect.do?action=toManage";
			driver.findElement(By.linkText("老师管理")).click();
			String actualCurrentur1 = driver.getCurrentUrl();//应该是取驱动当前的地址给actualCurrentur1
			String title = driver.getTitle() + "老师管理";//定义一个标题
			System.out.println(title + "\n" + actualCurrentur1);//控制台打印,程序员调程序用的(可有可无)                                                                                                                                                                                                                                                                                            
			assertEquals(expectedCurrenturl,actualCurrentur1);//比较两个值是否相等
			
			driver.findElement(By.cssSelector("a.current")).click();
		    driver.findElement(By.cssSelector("span.greenbtn25_text")).click();
		    driver.findElement(By.id("username")).clear();
		    driver.findElement(By.id("username")).sendKeys("s4555sdf");
		    driver.findElement(By.id("password")).clear();
		    driver.findElement(By.id("password")).sendKeys("1234");
		    driver.findElement(By.id("opassword")).clear();
		    driver.findElement(By.id("opassword")).sendKeys("1234");
		    driver.findElement(By.id("teachername")).sendKeys("gdsfg");
		    driver.findElement(By.xpath("(//input[@name='gender'])[2]")).click();		    
		    Select select = new Select(driver.findElement(By.id("J_selPlatForm")));//选择下拉列表方法	
		    select.selectByVisibleText("5445");			
		    driver.findElement(By.name("email")).clear();
		    driver.findElement(By.name("email")).sendKeys("gfsd@163.com");
		    sleep();
		    //给老师分配权限
		    driver.findElement(By.linkText("选择权限范围")).click();
		    driver.findElement(By.cssSelector("option[value=\"2009\"]")).click(); 
		    Select select1 = new Select(driver.findElement(By.id("circleYear")));//选择下拉列表方法	
		    select1.selectByVisibleText("2015");	
		    driver.findElement(By.cssSelector("option[value=\"2015\"]")).click();
		    driver.findElement(By.linkText("搜索")).click();
		    driver.findElement(By.id("sel_all_btn")).click();
		    driver.findElement(By.cssSelector("span.bluebtn30_text")).click();		    
		   	sleep();
		 	sleep();
		 	driver.findElement(By.linkText("删除")).click();// 删除
		 	driver.findElement(By.xpath("html/body/div[7]/table/tbody/tr[2]/td[2]/div[3]/button[1]")).click();
		}
		
		/**查询老师*/  
		@Test
		  public void queryTeacher() {			  
		    String expectedCurrenturl = "http://jw." + env + "ablesky.com/teacherRedirect.do?action=toManage";						
		    driver.findElement(By.linkText("老师管理")).click();
			String actualCurrentur1 = driver.getCurrentUrl();//应该是取驱动当前的地址给actualCurrentur1
			String title = driver.getTitle() + "老师管理";//定义一个标题
			System.out.println(title + "\n" + actualCurrentur1);//控制台打印,程序员调程序用的(可有可无)                                                                                                                                                                                                                                                                                            
			assertEquals(expectedCurrenturl,actualCurrentur1);//比较两个值是否相等
			
			driver.findElement(By.cssSelector("a.current")).click();
			driver.findElement(By.cssSelector("td.text-left")).click();
			driver.findElement(By.name("userName")).click();
			driver.findElement(By.name("userName")).clear();
			driver.findElement(By.name("userName")).sendKeys("dsfds");
			driver.findElement(By.cssSelector("span.bluebtn25_text")).click();
			sleep();sleep();
			//按手机查询
			driver.findElement(By.id("data_type")).click();
			Select select= new Select(driver.findElement(By.id("data_type")));
			select.selectByValue("mobile");
			sleep();sleep();sleep();
			driver.findElement(By.cssSelector("option[value=\"mobile\"]")).click();			
			driver.findElement(By.name("userName")).click();
			driver.findElement(By.name("userName")).clear();
			driver.findElement(By.name("userName")).sendKeys("666");
			driver.findElement(By.cssSelector("span.bluebtn25_text")).click();
			sleep();sleep();
			//按用户名查询
			driver.findElement(By.id("data_type")).click();
			Select select1= new Select(driver.findElement(By.id("data_type")));
			select1.selectByValue("user");
			sleep();sleep();sleep();
			driver.findElement(By.cssSelector("option[value=\"user\"]")).click();
			sleep();sleep();
			driver.findElement(By.name("userName")).click();
			driver.findElement(By.name("userName")).clear();
			driver.findElement(By.name("userName")).sendKeys("fff");
			sleep();sleep();
			driver.findElement(By.cssSelector("span.bluebtn25_text")).click();
		}		
		
		  
		/**修改老师*/ 
		  @Test
		  public void modifyStudent() {
			String expectedCurrenturl = "http://jw." + env + "ablesky.com/teacherRedirect.do?action=toManage";		    				
			driver.findElement(By.linkText("老师管理")).click();
			String actualCurrentur1 = driver.getCurrentUrl();//应该是取驱动当前的地址给actualCurrentur1
			String title = driver.getTitle() + "老师管理";//定义一个标题
			System.out.println(title + "\n" + actualCurrentur1);//控制台打印,程序员调程序用的(可有可无)                                                                                                                                                                                                                                                                                            
			assertEquals(expectedCurrenturl,actualCurrentur1);//比较两个值是否相等
			
			driver.findElement(By.cssSelector("a.current")).click();
		    driver.findElement(By.xpath("(//a[contains(text(),'修改')])[2]")).click();
		    driver.findElement(By.id("teachername")).clear();
		    driver.findElement(By.id("teachername")).sendKeys("gdsfg432543");
		    driver.findElement(By.id("change_uname")).click();
		    driver.findElement(By.id("newuname")).clear();
		    driver.findElement(By.id("newuname")).sendKeys("gaoxia001");		    
		    driver.findElement(By.cssSelector("button[type=\"button\"]")).click();
		    sleep();sleep();
		    driver.findElement(By.xpath("(//button[@type='button'])[2]")).click();
		    driver.findElement(By.cssSelector("span.bluebtn30_text")).click();		    
		    sleep();
		 	sleep();
		 	driver.findElement(By.linkText("删除")).click();// 删除
		 	driver.findElement(By.xpath("html/body/div[7]/table/tbody/tr[2]/td[2]/div[3]/button[1]")).click();
		  } 
		  
		  /**发送短信   余额充足情况*/
		@Test
		public void SmsComposeTask() {
		    String expectedCurrenturl = "http://jw." + env + "ablesky.com/teacherRedirect.do?action=toManage";			    				
			driver.findElement(By.linkText("老师管理")).click();
			String actualCurrentur1 = driver.getCurrentUrl();//应该是取驱动当前的地址给actualCurrentur1
			String title = driver.getTitle() + "老师管理";//定义一个标题
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
			String expectedCurrenturl = "http://jw." + env + "ablesky.com/teacherRedirect.do?action=toManage";		    				
			driver.findElement(By.linkText("老师管理")).click();
			String actualCurrentur1 = driver.getCurrentUrl();//应该是取驱动当前的地址给actualCurrentur1
			String title = driver.getTitle() + "老师管理";//定义一个标题
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
		
		/**详情*/
		@Test
		public void particulars() {
			String expectedCurrenturl = "http://jw." + env + "ablesky.com/teacherRedirect.do?action=toManage";		    				
			driver.findElement(By.linkText("老师管理")).click();
			String actualCurrentur1 = driver.getCurrentUrl();//应该是取驱动当前的地址给actualCurrentur1
			String title = driver.getTitle() + "老师管理";//定义一个标题
			System.out.println(title + "\n" + actualCurrentur1);//控制台打印,程序员调程序用的(可有可无)                                                                                                                                                                                                                                                                                            
			assertEquals(expectedCurrenturl,actualCurrentur1);//比较两个值是否相等
			
			driver.findElement(By.cssSelector("a.current")).click();
		  driver.findElement(By.linkText("详情")).click();
		  driver.findElement(By.linkText("返回")).click();
	}
		
		/**检查导出excel按钮*/
		@Test
		public void exportbutton(){
			driver.findElement(By.linkText("老师管理")).click();
			String exportButtonname="导出Excel文件";
			WebElement exportButton=driver.findElement(By.xpath(".//*[@id='export']/span"));//取到一个webElecment的一个对象
			Boolean isexportButton= exportButton.isEnabled();//取到的这个对象里面的一个属性是boolean类型给isexportButton
			String relexportButtonName=exportButton.getText();//是这个对象里面的text属性给relexportButtonName
			Assert.assertTrue(isexportButton);//是传一个boolean(就是trueORfalse)值进行判断处理
			Assert.assertEquals(exportButtonname, relexportButtonName);
			System.out.println("导出Excel文件按钮是否可用 ： "+isexportButton+"\n"+"导出Excel文件按钮的名称："+relexportButtonName);//打印
			
			//检查批量导入按钮                                              
			String importButtonname="批量导入老师";
			WebElement importButton=driver.findElement(By.xpath(".//*[@id='import_teacher']"));
			Boolean isimportButton= importButton.isEnabled();
			String relimportButtonName=importButton.getText();
			Assert.assertTrue(isimportButton);
			Assert.assertEquals(importButtonname, relimportButtonName);
			System.out.println("批量导入老师按钮是否可用 ： "+isimportButton+"\n"+"批量老师按钮的名称："+relimportButtonName);
	}

}
