package testcase;

import static org.junit.Assert.assertEquals;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class TeacherManageTest extends Base {

	 /**�����ȷ����ʦ */
	  @Test
	  public void CorrectTeacher() {
	    
			String expectedCurrenturl = "http://jw." + env + "ablesky.com/teacherRedirect.do?action=toManage";					
			driver.findElement(By.linkText("��ʦ����")).click();
			String actualCurrentur1 = driver.getCurrentUrl();//Ӧ����ȡ������ǰ�ĵ�ַ��actualCurrentur1
			String title = driver.getTitle() + "��ʦ����";//����һ������
			System.out.println(title + "\n" + actualCurrentur1);//����̨��ӡ,����Ա�������õ�(���п���)                                                                                                                                                                                                                                                                                            
			assertEquals(expectedCurrenturl,actualCurrentur1);//�Ƚ�����ֵ�Ƿ����
		
			driver.findElement(By.cssSelector("span.greenbtn25_text")).click();
			driver.findElement(By.id("username")).clear();
			driver.findElement(By.id("username")).sendKeys("gfg111444777fgfgfgfg");
			driver.findElement(By.id("password")).clear();
			driver.findElement(By.id("password")).sendKeys("1234");
			driver.findElement(By.id("opassword")).clear();
			driver.findElement(By.id("opassword")).sendKeys("1234");
			driver.findElement(By.id("teachername")).clear();
			driver.findElement(By.id("teachername")).sendKeys("ffgg");
			
			Select select = new Select(driver.findElement(By.id("J_selPlatForm")));//ѡ�������б���	
			select.selectByVisibleText("5445");
			
			driver.findElement(By.name("email")).clear();  
			driver.findElement(By.name("email")).sendKeys("df@163.com");
			driver.findElement(By.name("mobile")).clear();
		    driver.findElement(By.name("mobile")).sendKeys("13266665555");
		    driver.findElement(By.id("introduction")).clear();
		    driver.findElement(By.id("introduction")).sendKeys("ffdsafdsafdsafdasfdsafdsafdsfdsafdsafdsafdsafdasfdsafdsafdsfdsafdsafdsafdasfdsafdsafdsfdsafdsafdsafds");
			driver.findElement(By.cssSelector("span.bluebtn30_text")).click(); 
			
			// ɾ��
			sleep();
			sleep();
			driver.findElement(By.linkText("ɾ��")).click();
			driver.findElement(By.xpath("html/body/div[7]/table/tbody/tr[2]/td[2]/div[3]/button[1]")).click();
	  }	
	  
	  /**���ܴ���ͬ����ʦ */
	   @Test
	   public void Cannotcreatethesameteacher(){
			String expectedCurrenturl = "http://jw." + env + "ablesky.com/teacherRedirect.do?action=toManage";
			String expectederrorMess ="��ʦ�Ѿ����ڣ����ܴ���������ʦ";//����һ���ַ���������
			driver.findElement(By.linkText("��ʦ����")).click();
			String actualCurrentur1 = driver.getCurrentUrl();//Ӧ����ȡ������ǰ�ĵ�ַ��actualCurrentur1
			String title = driver.getTitle() + "��ʦ����";//����һ������
			System.out.println(title + "\n" + actualCurrentur1);//����̨��ӡ,����Ա�������õ�(���п���)                                                                                                                                                                                                                                                                                            
			assertEquals(expectedCurrenturl,actualCurrentur1);//�Ƚ�����ֵ�Ƿ����
			
			driver.findElement(By.cssSelector("span.greenbtn25_text")).click();
			driver.findElement(By.id("username")).clear();
			driver.findElement(By.id("username")).sendKeys("gfg117771fgfgfgfg");
			driver.findElement(By.id("password")).clear();
			driver.findElement(By.id("password")).sendKeys("1234");
			driver.findElement(By.id("opassword")).clear();
			driver.findElement(By.id("opassword")).sendKeys("1234");
			driver.findElement(By.id("teachername")).clear();
			driver.findElement(By.id("teachername")).sendKeys("ffgg");
			
			Select select = new Select(driver.findElement(By.id("J_selPlatForm")));//ѡ�������б���	
			select.selectByVisibleText("5445");
			
			driver.findElement(By.name("email")).clear();  
			driver.findElement(By.name("email")).sendKeys("df@163.com");
			driver.findElement(By.name("mobile")).clear();
		    driver.findElement(By.name("mobile")).sendKeys("13266665555");
		    driver.findElement(By.id("introduction")).clear();
		    driver.findElement(By.id("introduction")).sendKeys("ffdsafdsafdsafdasfdsafdsafdsfdsafdsafdsafdsafdasfdsafdsafdsfdsafdsafdsafdasfdsafdsafdsfdsafdsafdsafds");
			driver.findElement(By.cssSelector("span.bluebtn30_text")).click();
			sleep();
			String actualerrorMess = driver.findElement(By.id("name_tip")).getText();//��ȡ��name_tip�ַ�����ֵ����actualerrorMess����
			Assert.assertEquals(expectederrorMess, actualerrorMess);//expected������ֵ��ͨ�������û�ָ�������ݣ�actual�Ǳ����ԵĴ��뷵�ص�ʵ��ֵ���Ƚ�����ֵ�Ƿ���ȣ�
			driver.findElement(By.cssSelector("span.graybtn30_text")).click();
		
	   }
	   
	   /**�û������ܳ���20���ַ� */
		@Test
		public void nameover20(){
			String expectedCurrenturl = "http://jw." + env + "ablesky.com/teacherRedirect.do?action=toManage";
			String errorname="ymymymymymymymymymymymymymymyjm121221";//��������
			String rightname="yggm12";//��ȷ����
			driver.findElement(By.linkText("��ʦ����")).click();
			String actualCurrentur1 = driver.getCurrentUrl();//Ӧ����ȡ������ǰ�ĵ�ַ��actualCurrentur1
			String title = driver.getTitle() + "��ʦ����";//����һ������
			System.out.println(title + "\n" + actualCurrentur1);//����̨��ӡ,����Ա�������õ�(���п���)                                                                                                                                                                                                                                                                                            
			assertEquals(expectedCurrenturl,actualCurrentur1);//�Ƚ�����ֵ�Ƿ����
		   
			driver.findElement(By.cssSelector("span.greenbtn25_text")).click();
			driver.findElement(By.id("username")).clear();
			driver.findElement(By.id("username")).sendKeys(errorname);
			driver.findElement(By.id("password")).clear();
			driver.findElement(By.id("password")).sendKeys("1234");
			driver.findElement(By.id("opassword")).clear();
			driver.findElement(By.id("opassword")).sendKeys("1234");
			driver.findElement(By.id("teachername")).clear();
			driver.findElement(By.id("teachername")).sendKeys("ffgg");
			
			Select select = new Select(driver.findElement(By.id("J_selPlatForm")));//ѡ�������б���	
			select.selectByVisibleText("5445");
			 
			driver.findElement(By.name("email")).clear();  
			driver.findElement(By.name("email")).sendKeys("df@163.com");
			driver.findElement(By.name("mobile")).clear();
		    driver.findElement(By.name("mobile")).sendKeys("13266665555");
		    driver.findElement(By.id("introduction")).clear();
		    driver.findElement(By.id("introduction")).sendKeys("ffdsafdsafdsafdasfdsafdsafdsfdsafdsafdsafdsafdasfdsafdsafdsfdsafdsafdsafdasfdsafdsafdsfdsafdsafdsafds");
		    driver.findElement(By.cssSelector("span.bluebtn30_text")).click();//ȷ��
			
			String actualerrorMess = driver.findElement(By.xpath(".//*[@id='J_createCircleBasic']/tbody/tr[1]/td[2]/div/label")).getText();
			String expectederror="���20���ַ�";
			Assert.assertEquals(expectederror, actualerrorMess);//expected������ֵ��ͨ�������û�ָ�������ݣ�actual�Ǳ����ԵĴ��뷵�ص�ʵ��ֵ���Ƚ�����ֵ�Ƿ���ȣ�
			
			sleep();
			driver.findElement(By.id("username")).clear();
			driver.findElement(By.id("username")).sendKeys(rightname);
			driver.findElement(By.cssSelector("span.bluebtn30_text")).click(); 
					
		}
		
		/**�����������벻һ�� */
		@Test
		public void Enteredpasswordsdiffer(){
			String expectedCurrenturl = "http://jw." + env + "ablesky.com/teacherRedirect.do?action=toManage";
			driver.findElement(By.linkText("��ʦ����")).click();
			String actualCurrentur1 = driver.getCurrentUrl();//Ӧ����ȡ������ǰ�ĵ�ַ��actualCurrentur1
			String title = driver.getTitle() + "��ʦ����";//����һ������
			System.out.println(title + "\n" + actualCurrentur1);//����̨��ӡ,����Ա�������õ�(���п���)                                                                                                                                                                                                                                                                                            
			assertEquals(expectedCurrenturl,actualCurrentur1);//�Ƚ�����ֵ�Ƿ����
			
			driver.findElement(By.cssSelector("a.current")).click();
		    driver.findElement(By.cssSelector("span.greenbtn25_text")).click();
		    driver.findElement(By.id("username")).clear();
		    driver.findElement(By.id("username")).sendKeys("gs5554sdf");
		    driver.findElement(By.id("password")).clear();
		    driver.findElement(By.id("password")).sendKeys("1234");//��ȷ����
		    driver.findElement(By.id("opassword")).clear();
		    driver.findElement(By.id("opassword")).sendKeys("12345");//����ͬ����
		    driver.findElement(By.id("teachername")).clear();
		    driver.findElement(By.id("teachername")).sendKeys("gdsfg");
		    driver.findElement(By.xpath("(//input[@name='gender'])[2]")).click();		    
		    Select select = new Select(driver.findElement(By.id("J_selPlatForm")));//ѡ�������б���	
		    select.selectByVisibleText("5445");			
		    driver.findElement(By.name("email")).clear();
		    driver.findElement(By.name("email")).sendKeys("gfsd@163.com");
		    driver.findElement(By.cssSelector("span.bluebtn30_text")).click();		    
		    //String actualerrorMess = driver.findElement(By.xpath(".//*[@id='pwd_tip']")).getText();
			//String expectederror="�����������벻һ�� ";
			//Assert.assertEquals(expectederror, actualerrorMess);//expected������ֵ��ͨ�������û�ָ�������ݣ�actual�Ǳ����ԵĴ��뷵�ص�ʵ��ֵ���Ƚ�����ֵ�Ƿ���ȣ�
		    System.out.println("�����������벻һ��");//��ӡ
		    sleep();
		    driver.findElement(By.id("opassword")).clear();
		    driver.findElement(By.id("opassword")).sendKeys("1234");//�޸ĺ����ȷ����
		    driver.findElement(By.cssSelector("span.bluebtn30_text")).click();  
		  	sleep();
		 	sleep();
		 	driver.findElement(By.linkText("ɾ��")).click();// ɾ��
		 	driver.findElement(By.xpath("html/body/div[7]/table/tbody/tr[2]/td[2]/div[3]/button[1]")).click();
		}
		
		/**�û���Ϊ�� */
		@Test
		public void userisnull() {
			String expectedCurrenturl = "http://jw." + env + "ablesky.com/teacherRedirect.do?action=toManage";
			driver.findElement(By.linkText("��ʦ����")).click();
			String actualCurrentur1 = driver.getCurrentUrl();//Ӧ����ȡ������ǰ�ĵ�ַ��actualCurrentur1
			String title = driver.getTitle() + "��ʦ����";//����һ������
			System.out.println(title + "\n" + actualCurrentur1);//����̨��ӡ,����Ա�������õ�(���п���)                                                                                                                                                                                                                                                                                            
			assertEquals(expectedCurrenturl,actualCurrentur1);//�Ƚ�����ֵ�Ƿ����
			
			driver.findElement(By.cssSelector("span.greenbtn25_text")).click();
		    driver.findElement(By.id("password")).clear();
		    driver.findElement(By.id("password")).sendKeys("1234");
		    driver.findElement(By.id("opassword")).clear();
		    driver.findElement(By.id("opassword")).sendKeys("1234");
		    driver.findElement(By.id("teachername")).clear();
		    driver.findElement(By.id("teachername")).sendKeys("dsfds");
		    Select select = new Select(driver.findElement(By.id("J_selPlatForm")));//ѡ�������б���	
			select.selectByVisibleText("5445");	
		    driver.findElement(By.name("email")).clear();
		    driver.findElement(By.name("email")).sendKeys("fdsaf@163.com");
		    driver.findElement(By.cssSelector("span.bluebtn30_text")).click();
		    
		    //String actualerrorMess = driver.findElement(By.xpath(".//*[@id='J_createCircleBasic']/tbody/tr[1]/td[2]/div/label")).getText();
			//String expectederror="�û�������Ϊ�� ";
			//Assert.assertEquals(expectederror, actualerrorMess);//expected������ֵ��ͨ�������û�ָ�������ݣ�actual�Ǳ����ԵĴ��뷵�ص�ʵ��ֵ���Ƚ�����ֵ�Ƿ���ȣ�
			System.out.println("�û�������Ϊ��");//��ӡ
		    sleep();
		    driver.findElement(By.id("username")).clear();
		    driver.findElement(By.id("username")).sendKeys("fgf645654");
		    driver.findElement(By.cssSelector("span.bluebtn30_text")).click();
		    sleep();
		 	sleep();
		 	driver.findElement(By.linkText("ɾ��")).click();// ɾ��
		 	driver.findElement(By.xpath("html/body/div[7]/table/tbody/tr[2]/td[2]/div[3]/button[1]")).click();
		}
		
		/**����Ȩ�� */
		@Test
		public void PermissionAssignment(){
			String expectedCurrenturl = "http://jw." + env + "ablesky.com/teacherRedirect.do?action=toManage";
			driver.findElement(By.linkText("��ʦ����")).click();
			String actualCurrentur1 = driver.getCurrentUrl();//Ӧ����ȡ������ǰ�ĵ�ַ��actualCurrentur1
			String title = driver.getTitle() + "��ʦ����";//����һ������
			System.out.println(title + "\n" + actualCurrentur1);//����̨��ӡ,����Ա�������õ�(���п���)                                                                                                                                                                                                                                                                                            
			assertEquals(expectedCurrenturl,actualCurrentur1);//�Ƚ�����ֵ�Ƿ����
			
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
		    Select select = new Select(driver.findElement(By.id("J_selPlatForm")));//ѡ�������б���	
		    select.selectByVisibleText("5445");			
		    driver.findElement(By.name("email")).clear();
		    driver.findElement(By.name("email")).sendKeys("gfsd@163.com");
		    sleep();
		    //����ʦ����Ȩ��
		    driver.findElement(By.linkText("ѡ��Ȩ�޷�Χ")).click();
		    driver.findElement(By.cssSelector("option[value=\"2009\"]")).click(); 
		    Select select1 = new Select(driver.findElement(By.id("circleYear")));//ѡ�������б���	
		    select1.selectByVisibleText("2015");	
		    driver.findElement(By.cssSelector("option[value=\"2015\"]")).click();
		    driver.findElement(By.linkText("����")).click();
		    driver.findElement(By.id("sel_all_btn")).click();
		    driver.findElement(By.cssSelector("span.bluebtn30_text")).click();		    
		   	sleep();
		 	sleep();
		 	driver.findElement(By.linkText("ɾ��")).click();// ɾ��
		 	driver.findElement(By.xpath("html/body/div[7]/table/tbody/tr[2]/td[2]/div[3]/button[1]")).click();
		}
		
		/**��ѯ��ʦ*/  
		@Test
		  public void queryTeacher() {			  
		    String expectedCurrenturl = "http://jw." + env + "ablesky.com/teacherRedirect.do?action=toManage";						
		    driver.findElement(By.linkText("��ʦ����")).click();
			String actualCurrentur1 = driver.getCurrentUrl();//Ӧ����ȡ������ǰ�ĵ�ַ��actualCurrentur1
			String title = driver.getTitle() + "��ʦ����";//����һ������
			System.out.println(title + "\n" + actualCurrentur1);//����̨��ӡ,����Ա�������õ�(���п���)                                                                                                                                                                                                                                                                                            
			assertEquals(expectedCurrenturl,actualCurrentur1);//�Ƚ�����ֵ�Ƿ����
			
			driver.findElement(By.cssSelector("a.current")).click();
			driver.findElement(By.cssSelector("td.text-left")).click();
			driver.findElement(By.name("userName")).click();
			driver.findElement(By.name("userName")).clear();
			driver.findElement(By.name("userName")).sendKeys("dsfds");
			driver.findElement(By.cssSelector("span.bluebtn25_text")).click();
			sleep();sleep();
			//���ֻ���ѯ
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
			//���û�����ѯ
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
		
		  
		/**�޸���ʦ*/ 
		  @Test
		  public void modifyStudent() {
			String expectedCurrenturl = "http://jw." + env + "ablesky.com/teacherRedirect.do?action=toManage";		    				
			driver.findElement(By.linkText("��ʦ����")).click();
			String actualCurrentur1 = driver.getCurrentUrl();//Ӧ����ȡ������ǰ�ĵ�ַ��actualCurrentur1
			String title = driver.getTitle() + "��ʦ����";//����һ������
			System.out.println(title + "\n" + actualCurrentur1);//����̨��ӡ,����Ա�������õ�(���п���)                                                                                                                                                                                                                                                                                            
			assertEquals(expectedCurrenturl,actualCurrentur1);//�Ƚ�����ֵ�Ƿ����
			
			driver.findElement(By.cssSelector("a.current")).click();
		    driver.findElement(By.xpath("(//a[contains(text(),'�޸�')])[2]")).click();
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
		 	driver.findElement(By.linkText("ɾ��")).click();// ɾ��
		 	driver.findElement(By.xpath("html/body/div[7]/table/tbody/tr[2]/td[2]/div[3]/button[1]")).click();
		  } 
		  
		  /**���Ͷ���   ���������*/
		@Test
		public void SmsComposeTask() {
		    String expectedCurrenturl = "http://jw." + env + "ablesky.com/teacherRedirect.do?action=toManage";			    				
			driver.findElement(By.linkText("��ʦ����")).click();
			String actualCurrentur1 = driver.getCurrentUrl();//Ӧ����ȡ������ǰ�ĵ�ַ��actualCurrentur1
			String title = driver.getTitle() + "��ʦ����";//����һ������
			System.out.println(title + "\n" + actualCurrentur1);//����̨��ӡ,����Ա�������õ�(���п���)                                                                                                                                                                                                                                                                                            
			assertEquals(expectedCurrenturl,actualCurrentur1);//�Ƚ�����ֵ�Ƿ����
				
			driver.findElement(By.xpath("(//a[contains(text(),'���Ͷ���')])[2]")).click();//����б��еĵڼ������Ͷ���
			driver.findElement(By.linkText("�����ֶ�")).click();	    
			driver.findElement(By.id("insertField")).click();
			Select select = new Select(driver.findElement(By.id("insertField")));//ѡ�������б���	
			driver.findElement(By.xpath("//select[@id='insertField']/option[4]")).click();
			driver.findElement(By.id("message_text")).click();
			driver.findElement(By.id("message_text")).clear();
			driver.findElement(By.id("message_text")).sendKeys("{�ֻ�}sgsdfgdsfggfsdgsdfgsdfg");
			driver.findElement(By.id("save_as_template")).click();
			driver.findElement(By.cssSelector("button[type=\"button\"]")).click();
	 }
			 
		/**ѡ�����ģ��*/
		@Test
		public void SMSTemplate() {
			String expectedCurrenturl = "http://jw." + env + "ablesky.com/teacherRedirect.do?action=toManage";		    				
			driver.findElement(By.linkText("��ʦ����")).click();
			String actualCurrentur1 = driver.getCurrentUrl();//Ӧ����ȡ������ǰ�ĵ�ַ��actualCurrentur1
			String title = driver.getTitle() + "��ʦ����";//����һ������
			System.out.println(title + "\n" + actualCurrentur1);//����̨��ӡ,����Ա�������õ�(���п���)                                                                                                                                                                                                                                                                                            
			assertEquals(expectedCurrenturl,actualCurrentur1);//�Ƚ�����ֵ�Ƿ����		
			    
			driver.findElement(By.xpath("(//a[contains(text(),'���Ͷ���')])[2]")).click();
			driver.findElement(By.id("template")).click();
			driver.findElement(By.xpath("(//input[@name='content'])[5]")).click();
			driver.findElement(By.xpath("(//button[@type='button'])[3]")).click();
			driver.findElement(By.cssSelector("button[type=\"button\"]")).click();	    
			//ɾ������ģ��		
		    driver.findElement(By.xpath("(//a[contains(text(),'���Ͷ���')])[2]")).click();
			driver.findElement(By.id("template")).click();
			driver.findElement(By.id("155")).click();//���ֹ��Ķ����ֽ���ɾ��������Ҫ��ɾ����ť��idһ��
			driver.findElement(By.xpath("(//button[@type='button'])[3]")).click();
			driver.findElement(By.xpath("(//button[@type='button'])[2]")).click();
				
     }
		
		/**����*/
		@Test
		public void particulars() {
			String expectedCurrenturl = "http://jw." + env + "ablesky.com/teacherRedirect.do?action=toManage";		    				
			driver.findElement(By.linkText("��ʦ����")).click();
			String actualCurrentur1 = driver.getCurrentUrl();//Ӧ����ȡ������ǰ�ĵ�ַ��actualCurrentur1
			String title = driver.getTitle() + "��ʦ����";//����һ������
			System.out.println(title + "\n" + actualCurrentur1);//����̨��ӡ,����Ա�������õ�(���п���)                                                                                                                                                                                                                                                                                            
			assertEquals(expectedCurrenturl,actualCurrentur1);//�Ƚ�����ֵ�Ƿ����
			
			driver.findElement(By.cssSelector("a.current")).click();
		  driver.findElement(By.linkText("����")).click();
		  driver.findElement(By.linkText("����")).click();
	}
		
		/**��鵼��excel��ť*/
		@Test
		public void exportbutton(){
			driver.findElement(By.linkText("��ʦ����")).click();
			String exportButtonname="����Excel�ļ�";
			WebElement exportButton=driver.findElement(By.xpath(".//*[@id='export']/span"));//ȡ��һ��webElecment��һ������
			Boolean isexportButton= exportButton.isEnabled();//ȡ����������������һ��������boolean���͸�isexportButton
			String relexportButtonName=exportButton.getText();//��������������text���Ը�relexportButtonName
			Assert.assertTrue(isexportButton);//�Ǵ�һ��boolean(����trueORfalse)ֵ�����жϴ���
			Assert.assertEquals(exportButtonname, relexportButtonName);
			System.out.println("����Excel�ļ���ť�Ƿ���� �� "+isexportButton+"\n"+"����Excel�ļ���ť�����ƣ�"+relexportButtonName);//��ӡ
			
			//����������밴ť                                              
			String importButtonname="����������ʦ";
			WebElement importButton=driver.findElement(By.xpath(".//*[@id='import_teacher']"));
			Boolean isimportButton= importButton.isEnabled();
			String relimportButtonName=importButton.getText();
			Assert.assertTrue(isimportButton);
			Assert.assertEquals(importButtonname, relimportButtonName);
			System.out.println("����������ʦ��ť�Ƿ���� �� "+isimportButton+"\n"+"������ʦ��ť�����ƣ�"+relimportButtonName);
	}

}
