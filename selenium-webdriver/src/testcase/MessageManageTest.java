package testcase;

import static org.junit.Assert.assertEquals;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class MessageManageTest extends Base{
	/**
	 * 1.������Ѷ
	 * 2.ɾ����Ѷ
	 */
	@Test
	public void publishMessage (){
		String expectedCurrenturl = "http://jw." + env + "ablesky.com/infomationRedirect.do?action=toManage";
		driver.findElement(By.linkText("��Ѷ����")).click();
		String actualCurrentur1 = driver.getCurrentUrl();//Ӧ����ȡ������ǰ�ĵ�ַ��actualCurrentur1
		String title = driver.getTitle() + "��Ѷ����";//����һ������
		System.out.println(title + "\n" + actualCurrentur1);//����̨��ӡ,����Ա�������õ�(���п���)                                                                                                                                                                                                                                                                                            
		assertEquals(expectedCurrenturl,actualCurrentur1);//�Ƚ�����ֵ�Ƿ����
		    
		driver.findElement(By.cssSelector("span.greenbtn25_text")).click();
		driver.findElement(By.id("title")).clear();
		driver.findElement(By.id("title")).sendKeys("1111");
		Select select = new Select(driver.findElement(By.id("J_selPlatForm")));//�����б�
		select.selectByVisibleText("�ش���Ϣ");
		driver.findElement(By.cssSelector("span.bluebtn30_text")).click();
		    
		// ɾ��
		 sleep();sleep();		
		 driver.findElement(By.linkText("ɾ��")).click();
		 driver.findElement(By.xpath("html/body/div[7]/table/tbody/tr[2]/td[2]/div[3]/button[1]")).click();
	}
	
	 /**���ⲻ�ܳ���100���ַ� */
	@Test
	public void nameover100(){
		String expectedCurrenturl = "http://jw." + env + "ablesky.com/infomationRedirect.do?action=toManage";
		String errorname="ymymymymymymymymymymymymymymymymymymymymymymymyjm121221ymymymymymymymymymymymymymymyjm121221ymymymymymymy"
				+ "mymymymymymymymyjm121221ymymymymymymymymymymymymymymyjm121221ymymymymymymymymymymymymymymymymymymymyjm121221ymymym"
				+ "ymymymymymymymymymymymyjm121221ymymymymymymymymymymymymymymyjm121221ymymymymymymymymymyjm121221ymymymymymyjm121221";//��������
		String rightname="yggm12";//��ȷ����
		driver.findElement(By.linkText("��Ѷ����")).click();
		String actualCurrentur1 = driver.getCurrentUrl();//Ӧ����ȡ������ǰ�ĵ�ַ��actualCurrentur1
		String title = driver.getTitle() + "��Ѷ����";//����һ������
		System.out.println(title + "\n" + actualCurrentur1);//����̨��ӡ,����Ա�������õ�(���п���)                                                                                                                                                                                                                                                                                            
		assertEquals(expectedCurrenturl,actualCurrentur1);//�Ƚ�����ֵ�Ƿ����
	   
		driver.findElement(By.cssSelector("span.greenbtn25_text")).click();
	    driver.findElement(By.id("title")).clear();
	    driver.findElement(By.id("title")).sendKeys(errorname);
	    driver.findElement(By.cssSelector("span.bluebtn30_text")).click();		
	    Select select = new Select(driver.findElement(By.id("J_selPlatForm")));//�����б�
		select.selectByVisibleText("�ش���Ϣ");		
		String actualerrorMess = driver.findElement(By.xpath(".//*[@id='J_createCircleBasic']/tbody/tr[1]/td[2]/div/label")).getText();
		String expectederror="���100���ַ�";
		Assert.assertEquals(expectederror, actualerrorMess);//expected������ֵ��ͨ�������û�ָ�������ݣ�actual�Ǳ����ԵĴ��뷵�ص�ʵ��ֵ���Ƚ�����ֵ�Ƿ���ȣ�
		
		sleep();
		driver.findElement(By.id("title")).clear();
		driver.findElement(By.id("title")).sendKeys(rightname);
		driver.findElement(By.cssSelector("span.bluebtn30_text")).click(); 
		
		// ɾ��
		sleep();sleep();		
		driver.findElement(By.linkText("ɾ��")).click();
		driver.findElement(By.xpath("html/body/div[7]/table/tbody/tr[2]/td[2]/div[3]/button[1]")).click();
	}
	
	/**���ⲻ��Ϊ�� */
	@Test
	public void titleisempty(){
		String expectedCurrenturl = "http://jw." + env + "ablesky.com/infomationRedirect.do?action=toManage";
		driver.findElement(By.linkText("��Ѷ����")).click();
		String actualCurrentur1 = driver.getCurrentUrl();//Ӧ����ȡ������ǰ�ĵ�ַ��actualCurrentur1
		String title = driver.getTitle() + "��Ѷ����";//����һ������
		System.out.println(title + "\n" + actualCurrentur1);//����̨��ӡ,����Ա�������õ�(���п���)                                                                                                                                                                                                                                                                                            
		assertEquals(expectedCurrenturl,actualCurrentur1);//�Ƚ�����ֵ�Ƿ����
		
		driver.findElement(By.cssSelector("span.greenbtn25_text")).click();
		Select select = new Select(driver.findElement(By.id("J_selPlatForm")));//�����б�
	    select.selectByVisibleText("�ش���Ϣ");
	    driver.findElement(By.cssSelector("span.bluebtn30_text")).click();
	    System.out.println("��Ѷ���ⲻ��Ϊ��");//��ӡ	    
	    driver.findElement(By.id("title")).clear();
	    driver.findElement(By.id("title")).sendKeys("gfdsgfdsgfd");
	    driver.findElement(By.cssSelector("span.bluebtn30_text")).click();
	}
	
	/**
	 * �޸���Ѷ
	 */
	@Test
	public void modifMessage(){
		String expectedCurrenturl = "http://jw." + env + "ablesky.com/infomationRedirect.do?action=toManage";
		driver.findElement(By.linkText("��Ѷ����")).click();
		String actualCurrentur1 = driver.getCurrentUrl();//Ӧ����ȡ������ǰ�ĵ�ַ��actualCurrentur1
		String title = driver.getTitle() + "��Ѷ����";//����һ������
		System.out.println(title + "\n" + actualCurrentur1);//����̨��ӡ,����Ա�������õ�(���п���)                                                                                                                                                                                                                                                                                            
		assertEquals(expectedCurrenturl,actualCurrentur1);//�Ƚ�����ֵ�Ƿ����
		
		driver.findElement(By.linkText("�޸�")).click();
	    driver.findElement(By.id("title")).clear();
	    driver.findElement(By.id("title")).sendKeys("fff645654654");
	    Select select = new Select(driver.findElement(By.id("J_selPlatForm")));//�����б�
	    select.selectByVisibleText("�ش���Ϣ");
	    driver.findElement(By.cssSelector("span.bluebtn30_text")).click();
	    
	 // ɾ��
	 	sleep();sleep();		
	 	driver.findElement(By.linkText("ɾ��")).click();
	 	driver.findElement(By.xpath("html/body/div[7]/table/tbody/tr[2]/td[2]/div[3]/button[1]")).click();
	}
	
	/**
	 * ������Ѷ
	 */
	@Test
	public void queryMessage(){
		String expectedCurrenturl = "http://jw." + env + "ablesky.com/infomationRedirect.do?action=toManage";
		driver.findElement(By.linkText("��Ѷ����")).click();
		String actualCurrentur1 = driver.getCurrentUrl();//Ӧ����ȡ������ǰ�ĵ�ַ��actualCurrentur1
		String title = driver.getTitle() + "��Ѷ����";//����һ������
		System.out.println(title + "\n" + actualCurrentur1);//����̨��ӡ,����Ա�������õ�(���п���)                                                                                                                                                                                                                                                                                            
		assertEquals(expectedCurrenturl,actualCurrentur1);//�Ƚ�����ֵ�Ƿ����
		
		//ȫ�����Ʋ�ѯ
		driver.findElement(By.name("userName")).click();
	    driver.findElement(By.name("userName")).clear();
	    driver.findElement(By.name("userName")).sendKeys("hgdsgdsfgfdsgdsfgfdsgfsdgfsd");
	    driver.findElement(By.cssSelector("span.bluebtn25_text")).click();
		sleep();sleep();
		//ģ����ѯ
		driver.findElement(By.cssSelector("a.current")).click();
	    driver.findElement(By.name("userName")).click();
	    driver.findElement(By.name("userName")).clear();
	    driver.findElement(By.name("userName")).sendKeys("gfsdg");
	    driver.findElement(By.cssSelector("span.bluebtn25_text")).click();
	    sleep();sleep();
	    //���ҿո��ѯ
	    driver.findElement(By.name("userName")).click();
	    driver.findElement(By.name("userName")).clear();
	    driver.findElement(By.name("userName")).sendKeys("    gfsdg     ");
	    driver.findElement(By.cssSelector("span.bluebtn25_text")).click();
	    sleep();sleep();
	  //�м�ո��ѯ
	    driver.findElement(By.name("userName")).click();
	    driver.findElement(By.name("userName")).click();
	    driver.findElement(By.name("userName")).clear();
	    driver.findElement(By.name("userName")).sendKeys("gfs    dg");
	    driver.findElement(By.cssSelector("span.bluebtn25_text")).click();
	    sleep();sleep();
	  //�ղ�ѯ
	    driver.findElement(By.name("userName")).click();
	    driver.findElement(By.name("userName")).clear();
	    driver.findElement(By.name("userName")).sendKeys("");
	    driver.findElement(By.cssSelector("span.bluebtn25_text")).click();
	}
	
	/**
	 * ���ҳ�������ť����ť״̬
	 */
	@Test
	public void checkbuttonsState(){
		
		//����ѯ��ť
		String expdaddCButtonname="��ѯ";
		driver.findElement(By.linkText("��Ѷ����")).click();
		WebElement createCourseButton=driver.findElement(By.cssSelector("span.bluebtn25_text"));
		Boolean addCButton= createCourseButton.isEnabled();
		String reladdCButtonname=createCourseButton.getText();
		Assert.assertTrue(addCButton);
		Assert.assertEquals(expdaddCButtonname, reladdCButtonname);
		System.out.println("��ѯ��ť�Ƿ���� ��   "+addCButton+"\n"+"��ѯ��ť�����ƣ�"+reladdCButtonname);
		
		//������鰴ť
		String QueryButtonname="����";
		WebElement QueryButton=driver.findElement(By.xpath(".//*[@id='J_pmDataTables']/tbody/tr[1]/td[4]/div/a[1]"));
		Boolean iseQueryButton= QueryButton.isEnabled();
		String relQueryButtonname=QueryButton.getText();
		Assert.assertTrue(iseQueryButton);
		Assert.assertEquals(QueryButtonname, relQueryButtonname);
		System.out.println("���鰴ť�Ƿ���� ��   "+iseQueryButton+"\n"+"���鰴ť�����ƣ�"+relQueryButtonname);
		
	}
	
}
