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
	
   /**���ѧԱ */
	  @Test
	  public void createStudent() {
	    
		String expectedCurrenturl = "http://jw."+ env
				+" .ablesky.com/studentRedirect.do?action=toManageStudent";
					
		driver.findElement(By.linkText("ѧԱ����")).click();
		String actualCurrentur1 = driver.getCurrentUrl();//Ӧ����ȡ������ǰ�ĵ�ַ��actualCurrentur1
		String title = driver.getTitle() + "ѧԱ����";//����һ������
		System.out.println(title + "\n" + actualCurrentur1);//����̨��ӡ,����Ա�������õ�(���п���)                                                                                                                                                                                                                                                                                            
		assertEquals(expectedCurrenturl,actualCurrentur1);//�Ƚ�����ֵ�Ƿ����
		
	    driver.findElement(By.linkText("ѧԱ����")).click();
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
	    
	/**ɾ��ѧԱ*/
		driver.findElement(By.linkText("ɾ��")).click();		
		//driver.findElement(By.xpath("(//a[contains(text(),'ɾ��')])[1]")).click();//ɾ��ѧԱ��������ʾ�ڼ������б��о�ɾ���ڼ���ѧԱ��
	    driver.findElement(By.cssSelector("button[type=\"button\"]")).click();	    
	    sleep();
	  }
	  
	  /**���ܴ���ͬ��ѧԱ */
		@Test
		public void Cannotcreatethesamestudents(){
			String expectedCurrenturl = "http://jw."+ env
				+".ablesky.com/studentRedirect.do?action=toManageStudent";
			String expectederrorMess ="�����Ѵ��ڣ����ܴ���ͬ��ѧԱ";//����һ���ַ���������
			driver.findElement(By.linkText("ѧԱ����")).click();
			String actualCurrentur1 = driver.getCurrentUrl();//Ӧ����ȡ������ǰ�ĵ�ַ��actualCurrentur1
			String title = driver.getTitle() + "ѧԱ����";//����һ������
			System.out.println(title + "\n" + actualCurrentur1);//����̨��ӡ,����Ա�������õ�(���п���)                                                                                                                                                                                                                                                                                            
			assertEquals(expectedCurrenturl,actualCurrentur1);//�Ƚ�����ֵ�Ƿ����
		    sleep();
		    driver.findElement(By.linkText("ѧԱ����")).click();
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
		    String actualerrorMess = driver.findElement(By.id("name_tip")).getText();//��ȡ��name_tip�ַ�����ֵ����actualerrorMess����
		    Assert.assertEquals(expectederrorMess, actualerrorMess);//expected������ֵ��ͨ�������û�ָ�������ݣ�actual�Ǳ����ԵĴ��뷵�ص�ʵ��ֵ���Ƚ�����ֵ�Ƿ���ȣ�
		    
		    driver.findElement(By.cssSelector("span.graybtn30_text")).click();		    
					
		}
		
		/**�������ܳ���20���ַ� */
		@Test
		public void nameover20(){
			String expectedCurrenturl = "http://jw."+ env
				+".ablesky.com/studentRedirect.do?action=toManageStudent";
			String errorname="ymymymymymymymymymymymymymymyjm121221";//��������
			String rightname="ym12";//��ȷ����
			driver.findElement(By.linkText("ѧԱ����")).click();
			String actualCurrentur1 = driver.getCurrentUrl();//Ӧ����ȡ������ǰ�ĵ�ַ��actualCurrentur1
			String title = driver.getTitle() + "ѧԱ����";//����һ������
			System.out.println(title + "\n" + actualCurrentur1);//����̨��ӡ,����Ա�������õ�(���п���)                                                                                                                                                                                                                                                                                            
			assertEquals(expectedCurrenturl,actualCurrentur1);//�Ƚ�����ֵ�Ƿ����
		   
		    driver.findElement(By.linkText("ѧԱ����")).click();
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
			String expectederror="���20λ�ַ�";
			Assert.assertEquals(expectederror, actualerrorMess);//expected������ֵ��ͨ�������û�ָ�������ݣ�actual�Ǳ����ԵĴ��뷵�ص�ʵ��ֵ���Ƚ�����ֵ�Ƿ���ȣ�
			sleep();
			driver.findElement(By.id("name")).clear();
			driver.findElement(By.id("name")).sendKeys(rightname);
			driver.findElement(By.cssSelector("span.bluebtn30_text")).click(); 
		   				
		}
		
		/**�Ա�ѡ��Ů*/
		@Test
		public void gentelIsfemal(){
			String expectedCurrenturl = "http://jw."+ env
				+".ablesky.com/studentRedirect.do?action=toManageStudent";
			driver.findElement(By.linkText("ѧԱ����")).click();
			String actualCurrentur1 = driver.getCurrentUrl();//Ӧ����ȡ������ǰ�ĵ�ַ��actualCurrentur1
			String title = driver.getTitle() + "ѧԱ����";//����һ������
			System.out.println(title + "\n" + actualCurrentur1);//����̨��ӡ,����Ա�������õ�(���п���)                                                                                                                                                                                                                                                                                            
			assertEquals(expectedCurrenturl,actualCurrentur1);//�Ƚ�����ֵ�Ƿ����
		   		   
			driver.findElement(By.cssSelector("span.greenbtn25_text")).click();
		    driver.findElement(By.id("name")).click();
		    driver.findElement(By.id("name")).clear();
		    driver.findElement(By.id("name")).sendKeys("564655");
		    driver.findElement(By.xpath("(//input[@name='gender'])[2]")).click();
		    driver.findElement(By.cssSelector("span.bluebtn30_text")).click();
		    		
		}	
			
		/**�ֻ������������֤*/
		@Test
		public void mobileNumber(){
			String expectedCurrenturl = "http://jw."+ env
				+".ablesky.com/studentRedirect.do?action=toManageStudent";
			driver.findElement(By.linkText("ѧԱ����")).click();
			String actualCurrentur1 = driver.getCurrentUrl();//Ӧ����ȡ������ǰ�ĵ�ַ��actualCurrentur1
			String title = driver.getTitle() + "ѧԱ����";//����һ������
			System.out.println(title + "\n" + actualCurrentur1);//����̨��ӡ,����Ա�������õ�(���п���)                                                                                                                                                                                                                                                                                            
			assertEquals(expectedCurrenturl,actualCurrentur1);//�Ƚ�����ֵ�Ƿ����
			sleep();
			driver.findElement(By.cssSelector("span.greenbtn25_text")).click();
		    driver.findElement(By.id("name")).click();
		    driver.findElement(By.id("name")).clear();
		    driver.findElement(By.id("name")).sendKeys("45544");
			//���ֻ��������ַ�
		    driver.findElement(By.name("mobile")).clear();
		    driver.findElement(By.name("mobile")).sendKeys("jcvjgcfjnvcnbvmn");
		    driver.findElement(By.cssSelector("span.bluebtn30_text")).click();
		    sleep();
			String expectedErrorMess01="�ֻ������ʽ����";
			String actualerrorMessage01=driver.findElement(By.xpath(".//*[@id='J_createCircleBasic']/tbody/tr[3]/td[2]/div/label")).getText();
			Assert.assertEquals(expectedErrorMess01, actualerrorMessage01);
			//���ֻ�������λ��С��13λ
			driver.findElement(By.name("mobile")).clear();
		    driver.findElement(By.name("mobile")).sendKeys("13236436");
		    driver.findElement(By.cssSelector("span.bluebtn30_text")).click();
		    sleep();
			String expectedErrorMess02="�ֻ������ʽ����";
			String actualerrorMessage02=driver.findElement(By.xpath(".//*[@id='J_createCircleBasic']/tbody/tr[3]/td[2]/div/label")).getText();
			Assert.assertEquals(expectedErrorMess02, actualerrorMessage02);
			//���ֻ������볬��13λ
			driver.findElement(By.name("mobile")).clear();
		    driver.findElement(By.name("mobile")).sendKeys("132333355556");
		    driver.findElement(By.cssSelector("span.bluebtn30_text")).click();
		    sleep();
			String expectedErrorMess03="�ֻ������ʽ����";
			String actualerrorMessage03=driver.findElement(By.xpath(".//*[@id='J_createCircleBasic']/tbody/tr[3]/td[2]/div/label")).getText();
			Assert.assertEquals(expectedErrorMess03, actualerrorMessage03);
			//������ȷ���ֻ���
			driver.findElement(By.name("mobile")).clear();
		    driver.findElement(By.name("mobile")).sendKeys("13266664444");
		    driver.findElement(By.cssSelector("span.bluebtn30_text")).click();			
			    
	    }
	  
	/**��ѯѧԱ*/  
	@Test
	  public void queryStudent() {
		  
	    String expectedCurrenturl = "http://jw."+ env
				+".ablesky.com/studentRedirect.do?action=toManageStudent";
					
	    driver.findElement(By.linkText("ѧԱ����")).click();
		String actualCurrentur1 = driver.getCurrentUrl();//Ӧ����ȡ������ǰ�ĵ�ַ��actualCurrentur1
		String title = driver.getTitle() + "ѧԱ����";//����һ������
		System.out.println(title + "\n" + actualCurrentur1);//����̨��ӡ,����Ա�������õ�(���п���)                                                                                                                                                                                                                                                                                            
		assertEquals(expectedCurrenturl,actualCurrentur1);//�Ƚ�����ֵ�Ƿ����
		
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
		//���ֻ���ѯ
		driver.findElement(By.name("userName")).click();
		driver.findElement(By.name("userName")).clear();
		driver.findElement(By.name("userName")).sendKeys("18201649665");
		driver.findElement(By.cssSelector("span.bluebtn25_text")).click();	  
	  }
	  
	/**�޸�ѧԱ*/ 
	  @Test
	  public void modifyStudent() {
		String expectedCurrenturl = "http://jw."+ env
				+".ablesky.com/studentRedirect.do?action=toManageStudent";
	    				
		driver.findElement(By.linkText("ѧԱ����")).click();
		String actualCurrentur1 = driver.getCurrentUrl();//Ӧ����ȡ������ǰ�ĵ�ַ��actualCurrentur1
		String title = driver.getTitle() + "ѧԱ����";//����һ������
		System.out.println(title + "\n" + actualCurrentur1);//����̨��ӡ,����Ա�������õ�(���п���)                                                                                                                                                                                                                                                                                            
		assertEquals(expectedCurrenturl,actualCurrentur1);//�Ƚ�����ֵ�Ƿ����
		
	    driver.findElement(By.cssSelector("a.current")).click();
	    driver.findElement(By.linkText("�޸�")).click();
	    driver.findElement(By.id("name")).click();
	    driver.findElement(By.id("name")).clear();
	    driver.findElement(By.id("name")).sendKeys("ggggggg");
	    driver.findElement(By.name("mobile")).clear();
	    driver.findElement(By.name("mobile")).sendKeys("13233332222");
	    driver.findElement(By.cssSelector("span.bluebtn30_text")).click();
	  } 
	  
	/**��ӱ�ע*/
	  @Test
	  public void Message() {
		String expectedCurrenturl = "http://jw."+ env
				+".ablesky.com/studentRedirect.do?action=toManageStudent";
	    				
		driver.findElement(By.linkText("ѧԱ����")).click();
		String actualCurrentur1 = driver.getCurrentUrl();//Ӧ����ȡ������ǰ�ĵ�ַ��actualCurrentur1
		String title = driver.getTitle() + "ѧԱ����";//����һ������
		System.out.println(title + "\n" + actualCurrentur1);//����̨��ӡ,����Ա�������õ�(���п���)                                                                                                                                                                                                                                                                                            
		assertEquals(expectedCurrenturl,actualCurrentur1);//�Ƚ�����ֵ�Ƿ����
		
		driver.findElement(By.linkText("ѧԱ����")).click();
		driver.findElement(By.linkText("��ע")).click();
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
	  
	/**���Ͷ���*/
	 @Test
	  public void SmsComposeTask() {
		String expectedCurrenturl = "http://jw."+ env
				+".ablesky.com/studentRedirect.do?action=toManageStudent";
	    				
		driver.findElement(By.linkText("ѧԱ����")).click();
		String actualCurrentur1 = driver.getCurrentUrl();//Ӧ����ȡ������ǰ�ĵ�ַ��actualCurrentur1
		String title = driver.getTitle() + "ѧԱ����";//����һ������
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
		String expectedCurrenturl = "http://jw."+ env
				+".ablesky.com/studentRedirect.do?action=toManageStudent";		    				
		driver.findElement(By.linkText("ѧԱ����")).click();
		String actualCurrentur1 = driver.getCurrentUrl();//Ӧ����ȡ������ǰ�ĵ�ַ��actualCurrentur1
		String title = driver.getTitle() + "ѧԱ����";//����һ������
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
	  
	  /**�����Ҫ�̶�*/
		 @Test
		  public void Tagtodegree() {
			String expectedCurrenturl = "http://jw."+ env
				+".ablesky.com/studentRedirect.do?action=toManageStudent";			    				
			driver.findElement(By.linkText("ѧԱ����")).click();
			String actualCurrentur1 = driver.getCurrentUrl();//Ӧ����ȡ������ǰ�ĵ�ַ��actualCurrentur1
			String title = driver.getTitle() + "ѧԱ����";//����һ������
			System.out.println(title + "\n" + actualCurrentur1);//����̨��ӡ,����Ա�������õ�(���п���)                                                                                                                                                                                                                                                                                            
			assertEquals(expectedCurrenturl,actualCurrentur1);//�Ƚ�����ֵ�Ƿ����
			
			driver.findElement(By.cssSelector("a.current")).click();
		    driver.findElement(By.id("6515")).click();//���ֹ��Ķ����ֽ���ɾ��������Ҫ��ɾ����ť��idһ��
		    driver.findElement(By.name("level")).click();
		    sleep();
		    driver.findElement(By.cssSelector("button[type=\"button\"]")).click();
		    sleep();
		    driver.findElement(By.id("6515")).click();//���ֹ��Ķ����ֽ���ɾ��������Ҫ��ɾ����ť��idһ��
	  }
		//��鵼��excel��ť
		@Test
		public void exportbutton(){
			driver.findElement(By.linkText("ѧԱ����")).click();
			String exportButtonname="����Excel�ļ�";
			WebElement exportButton=driver.findElement(By.xpath(".//*[@id='export']/span"));
			Boolean isexportButton= exportButton.isEnabled();
			String relexportButtonName=exportButton.getText();
			Assert.assertTrue(isexportButton);
			Assert.assertEquals(exportButtonname, relexportButtonName);
			System.out.println("����Excel�ļ���ť�Ƿ���� ��   "+isexportButton+"\n"+"����Excel�ļ���ť�����ƣ�"+relexportButtonName);
		}
}