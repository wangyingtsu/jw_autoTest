package testcase;

import static org.junit.Assert.assertEquals;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

public class RectutStudentsManage extends Base{
	/**
	 * �����Ƽ���
	 */
	//@Test@Test
	public void creatReferrer(){
		String expectedCurrenturl = "http://jw." + env
				+ "ablesky.com/recommenderRedirect.do?action=toManage";
		driver.findElement(By.linkText("��������")).click();
		String actualCurrenturl = driver.getCurrentUrl();
		String title = driver.getTitle() + "  ��������";
		System.out.println(title + "\n" + actualCurrenturl);
		assertEquals(expectedCurrenturl, actualCurrenturl);
	    sleep();
	   // driver.findElement(By.cssSelector("a.current")).click();
	    driver.findElement(By.cssSelector("span.greenbtn25_text")).click();
	    driver.findElement(By.id("name")).clear();
	    driver.findElement(By.id("name")).sendKeys("����001");
	    driver.findElement(By.id("mobile")).clear();
	    driver.findElement(By.id("mobile")).sendKeys("18610221512");
	    sleep();
	    driver.findElement(By.cssSelector("span.bluebtn30_text")).click();
	    driver.findElement(By.linkText("��������")).click();
	    sleep(); sleep(); sleep();
	    driver.findElement(By.linkText("ɾ��")).click();
	    driver.findElement(By.xpath("html/body/div[9]/table/tbody/tr[2]/td[2]/div[3]/button[1]")).click();
	    sleep();sleep();
	    driver.findElement(By.linkText("��������")).click();
	    
	}
	
	
	/**
	 * ���ܴ���ͬ�����Ƽ���
	 */
	//@Test
	public void createReferrerwithsamename(){
		String expectedCurrenturl = "http://jw." + env
				+ "ablesky.com/recommenderRedirect.do?action=toManage";
		String expectederrorMess ="�Ƽ����Ѿ����ڣ����ܴ��������Ƽ���";
		driver.findElement(By.linkText("��������")).click();
		String actualCurrenturl = driver.getCurrentUrl();
		String title = driver.getTitle() + "  ��������";
		System.out.println(title + "\n" + actualCurrenturl);
		assertEquals(expectedCurrenturl, actualCurrenturl);
	    sleep();
	   // driver.findElement(By.cssSelector("a.current")).click();
	    driver.findElement(By.cssSelector("span.greenbtn25_text")).click();
	    driver.findElement(By.id("name")).clear();
	    driver.findElement(By.id("name")).sendKeys("����001");
	    driver.findElement(By.id("mobile")).clear();
	    driver.findElement(By.id("mobile")).sendKeys("18610221512");
	    sleep();
	    driver.findElement(By.cssSelector("span.bluebtn30_text")).click();
	    driver.findElement(By.linkText("��������")).click();
	    sleep(); sleep(); sleep();
	    driver.findElement(By.cssSelector("span.greenbtn25_text")).click();
	    driver.findElement(By.id("name")).clear();
	    driver.findElement(By.id("name")).sendKeys("����001");
	    driver.findElement(By.id("mobile")).clear();
	    driver.findElement(By.id("mobile")).sendKeys("18610221512");
	    sleep();
	    driver.findElement(By.cssSelector("span.bluebtn30_text")).click();
	    String  actualerrorMess = driver.findElement(By.id("name_tip")).getText();
	    Assert.assertEquals(expectederrorMess, actualerrorMess);
	    driver.findElement(By.cssSelector("span.graybtn30_text")).click();
	    driver.findElement(By.linkText("��������")).click();
	    //ɾ��
	    sleep(); sleep();
	    driver.findElement(By.linkText("ɾ��")).click();
	    driver.findElement(By.xpath("html/body/div[9]/table/tbody/tr[2]/td[2]/div[3]/button[1]")).click();
	    sleep();sleep();
	    driver.findElement(By.linkText("��������")).click();
		
	}
	
	
	/**
	 * �������ܳ���100��
	 */
	//@Test
	public void nameover100(){
		String expectedCurrenturl = "http://jw." + env
				+ "ablesky.com/recommenderRedirect.do?action=toManage";
		String errorname="�ͷ����ˮ������ķ������ٶȿ췢����ݿƼ��͸���˹�ܿ�ͻ��ѿ�����Ļ��ʦ�ظ����ʦ�ŵÿ���ʦ�����ʦ�Ļָ����ʦ�ظ����ʦ����ٻ�������ȿ�ˮ������᰸ʱ�ܿ��ܿ��ܿ�Ῠ��ɶ�ĺͷ��ͺŵؿ鿴���ظ��ɼ�ɶ�ĺͷ�";
		String rightname="����002";
		driver.findElement(By.linkText("��������")).click();
		String actualCurrenturl = driver.getCurrentUrl();
		String title = driver.getTitle() + "  ��������";
		System.out.println(title + "\n" + actualCurrenturl);
		assertEquals(expectedCurrenturl, actualCurrenturl);
	    sleep();
	   // driver.findElement(By.cssSelector("a.current")).click();
	    driver.findElement(By.cssSelector("span.greenbtn25_text")).click();
	    driver.findElement(By.id("name")).clear();
	    driver.findElement(By.id("name")).sendKeys(errorname);
	    driver.findElement(By.id("mobile")).clear();
	    driver.findElement(By.id("mobile")).sendKeys("18610221512");
	    sleep();
	    driver.findElement(By.cssSelector("span.bluebtn30_text")).click();
	    String actualerrormess = driver.findElement(By.xpath(".//*[@id='J_createCircleBasic']/tbody/tr[1]/td[2]/div/label")).getText();
	    String expectederror="���100λ�ַ�";
	    Assert.assertEquals(expectederror, actualerrormess);
	    
	    driver.findElement(By.id("name")).clear();
	    driver.findElement(By.id("name")).sendKeys(rightname);
	    driver.findElement(By.cssSelector("span.bluebtn30_text")).click();
	    
	    driver.findElement(By.linkText("��������")).click();
	    sleep(); sleep(); sleep();
	    driver.findElement(By.linkText("ɾ��")).click();
	    driver.findElement(By.xpath("html/body/div[9]/table/tbody/tr[2]/td[2]/div[3]/button[1]")).click();
	    sleep();sleep();
	    driver.findElement(By.linkText("��������")).click();
		
		
	}
	
	
	/**
	 * �Ա�ѡ��Ů
	 */
	//@Test
	public void gentelIsfemal(){
		String expectedCurrenturl = "http://jw." + env
				+ "ablesky.com/recommenderRedirect.do?action=toManage";
		driver.findElement(By.linkText("��������")).click();
		String actualCurrenturl = driver.getCurrentUrl();
		String title = driver.getTitle() + "  ��������";
		System.out.println(title + "\n" + actualCurrenturl);
		assertEquals(expectedCurrenturl, actualCurrenturl);
	    sleep();
	   // driver.findElement(By.cssSelector("a.current")).click();
	    driver.findElement(By.cssSelector("span.greenbtn25_text")).click();
	    driver.findElement(By.id("name")).clear();
	    driver.findElement(By.id("name")).sendKeys("����001");
	    sleep();
	    driver.findElement(By.xpath("(//input[@name='gender'])[2]")).click();
	    sleep();
	    driver.findElement(By.id("mobile")).clear();
	    driver.findElement(By.id("mobile")).sendKeys("18610221512");
	    sleep();
	    driver.findElement(By.cssSelector("span.bluebtn30_text")).click();
	    driver.findElement(By.linkText("��������")).click();
	    sleep(); sleep(); sleep();
	    driver.findElement(By.linkText("ɾ��")).click();
	    driver.findElement(By.xpath("html/body/div[9]/table/tbody/tr[2]/td[2]/div[3]/button[1]")).click();
	    sleep();sleep();
	    driver.findElement(By.linkText("��������")).click();
		
	}
	
	
	
	
	/**
	 * �ֻ������������֤
	 */
	   // @Test
		public void mobileNumber(){
			String expectedCurrenturl = "http://jw." + env
					+ "ablesky.com/recommenderRedirect.do?action=toManage";
			driver.findElement(By.linkText("��������")).click();
			String actualCurrenturl = driver.getCurrentUrl();
			String title = driver.getTitle() + "  ��������";
			System.out.println(title + "\n" + actualCurrenturl);
			assertEquals(expectedCurrenturl, actualCurrenturl);
		    sleep();
		    driver.findElement(By.cssSelector("span.greenbtn25_text")).click();
		    driver.findElement(By.id("name")).clear();
		    driver.findElement(By.id("name")).sendKeys("����002");
		    //���ֻ��������ַ�
		    driver.findElement(By.id("mobile")).clear();
		    driver.findElement(By.id("mobile")).sendKeys("aaaaaaaa");
		    sleep();
		    driver.findElement(By.cssSelector("span.bluebtn30_text")).click();
		    String expectedErrorMess01="�ֻ������ʽ����";
		    String actualerrorMessage01=driver.findElement(By.xpath(".//*[@id='J_createCircleBasic']/tbody/tr[3]/td[2]/div/label")).getText();
		    Assert.assertEquals(expectedErrorMess01, actualerrorMessage01);
		    //���ֻ�������λ��С��13λ
		    driver.findElement(By.id("mobile")).clear();
		    driver.findElement(By.id("mobile")).sendKeys("1861022125");
		    sleep();
		    driver.findElement(By.cssSelector("span.bluebtn30_text")).click();
		    String expectedErrorMess02="�ֻ������ʽ����";
		    String actualerrorMessage02=driver.findElement(By.xpath(".//*[@id='J_createCircleBasic']/tbody/tr[3]/td[2]/div/label")).getText();
		    Assert.assertEquals(expectedErrorMess02, actualerrorMessage02);
		    //���ֻ������볬��13λ
		    driver.findElement(By.id("mobile")).clear();
		    driver.findElement(By.id("mobile")).sendKeys("186102212556655");
		    sleep();
		    driver.findElement(By.cssSelector("span.bluebtn30_text")).click();
		    String expectedErrorMess03="�ֻ������ʽ����";
		    String actualerrorMessage03=driver.findElement(By.xpath(".//*[@id='J_createCircleBasic']/tbody/tr[3]/td[2]/div/label")).getText();
		    Assert.assertEquals(expectedErrorMess03, actualerrorMessage03);
		    //������ȷ���ֻ���
		    driver.findElement(By.id("mobile")).clear();
		    driver.findElement(By.id("mobile")).sendKeys("18512564569");
		    sleep();
		    driver.findElement(By.cssSelector("span.bluebtn30_text")).click();
		    sleep();sleep();
		    
		    driver.findElement(By.linkText("��������")).click();
		    sleep(); sleep(); sleep();
		    driver.findElement(By.linkText("ɾ��")).click();
		    driver.findElement(By.xpath("html/body/div[9]/table/tbody/tr[2]/td[2]/div[3]/button[1]")).click();
		    sleep();sleep();
		    driver.findElement(By.linkText("��������")).click();
		    
		}
	
	
	
	
	
	/**
	 * ���������Ƽ���
	 */
		@Ignore
		public void importReferrerByExcel (){
			
		}
	
	
	

	/**
	 * �޸��Ƽ���
	 */
		//@Test
		public void modifyReferrer(){
			String expectedCurrenturl = "http://jw." + env
					+ "ablesky.com/recommenderRedirect.do?action=toManage";
			driver.findElement(By.linkText("��������")).click();
			String actualCurrenturl = driver.getCurrentUrl();
			String title = driver.getTitle() + "  ��������";
			System.out.println(title + "\n" + actualCurrenturl);
			assertEquals(expectedCurrenturl, actualCurrenturl);
		    sleep();
		    driver.findElement(By.cssSelector("span.greenbtn25_text")).click();
		    driver.findElement(By.id("name")).clear();
		    driver.findElement(By.id("name")).sendKeys("����001");
		    driver.findElement(By.id("mobile")).clear();
		    driver.findElement(By.id("mobile")).sendKeys("18610221512");
		    sleep();
		    driver.findElement(By.cssSelector("span.bluebtn30_text")).click();
		    driver.findElement(By.linkText("��������")).click();
		    sleep(); sleep(); sleep();
		    driver.findElement(By.linkText("�޸�")).click();
		    sleep();
		    driver.findElement(By.id("name")).clear();
		    driver.findElement(By.id("name")).sendKeys("����002");
		    driver.findElement(By.xpath(".//*[@id='J_createCircleBasic']/tbody/tr[2]/td[2]/div/input[2]")).click();
		    driver.findElement(By.id("mobile")).clear();
		    driver.findElement(By.id("mobile")).sendKeys("18610226666");
		    sleep();
		    driver.findElement(By.cssSelector("span.bluebtn30_text")).click();
		    sleep();
		    driver.findElement(By.linkText("��������")).click();
		    
		    driver.findElement(By.linkText("ɾ��")).click();
		    driver.findElement(By.xpath("html/body/div[9]/table/tbody/tr[2]/td[2]/div[3]/button[1]")).click();
		    sleep();sleep();
		    driver.findElement(By.linkText("��������")).click();
		}
	
	
	
	/**
	 * �鿴�Ƽ�ѧԱ
	 */
	public void recommendStudentsList(){
		
	}
	
	
	/**
	 * �鿴�Ƽ��γ�
	 */
	
	public void recommendCoursesList(){
		
	}
	
	
	/**
	 * �����������Ƽ���
	 */
	//@Test
	public void queryByNmae(){
		String expectedCurrenturl = "http://jw." + env
				+ "ablesky.com/recommenderRedirect.do?action=toManage";
		driver.findElement(By.linkText("��������")).click();
		String actualCurrenturl = driver.getCurrentUrl();
		String title = driver.getTitle() + "  ��������";
		System.out.println(title + "\n" + actualCurrenturl);
		assertEquals(expectedCurrenturl, actualCurrenturl);
	    sleep();
	    driver.findElement(By.cssSelector("span.greenbtn25_text")).click();
	    driver.findElement(By.id("name")).clear();
	    driver.findElement(By.id("name")).sendKeys("����00000001");
	    driver.findElement(By.id("mobile")).clear();
	    driver.findElement(By.id("mobile")).sendKeys("18666668888");
	    sleep();
	    driver.findElement(By.cssSelector("span.bluebtn30_text")).click();
	    driver.findElement(By.linkText("��������")).click();
	    
	    driver.findElement(By.id("data_type")).click();
	    driver.findElement(By.cssSelector("option[value=\"name\"]")).click();
	   // driver.findElement(By.name("userName")).click();
	    driver.findElement(By.name("userName")).clear();
	    driver.findElement(By.name("userName")).sendKeys("00001");
	    sleep(); sleep(); sleep();
	    driver.findElement(By.cssSelector("span.bluebtn25_text")).click();
	    sleep(); sleep(); sleep();sleep();
	    String expectNum="1";
	    String actualNum=driver.findElement(By.id("J_totalCount")).getText();
	    Assert.assertEquals(expectNum, actualNum);
	    
	    driver.findElement(By.linkText("ɾ��")).click();
	    driver.findElement(By.xpath("html/body/div[9]/table/tbody/tr[2]/td[2]/div[3]/button[1]")).click();
	    sleep();sleep();
	    driver.findElement(By.linkText("��������")).click();
		
		
	}
	
	
	/**
	 * ���ֻ����������Ƽ���
	 */
	@Test
    public void queryByMobile(){
    	String expectedCurrenturl = "http://jw." + env
				+ "ablesky.com/recommenderRedirect.do?action=toManage";
		driver.findElement(By.linkText("��������")).click();
		String actualCurrenturl = driver.getCurrentUrl();
		String title = driver.getTitle() + "  ��������";
		System.out.println(title + "\n" + actualCurrenturl);
		assertEquals(expectedCurrenturl, actualCurrenturl);
	    sleep();
	    driver.findElement(By.cssSelector("span.greenbtn25_text")).click();
	    driver.findElement(By.id("name")).clear();
	    driver.findElement(By.id("name")).sendKeys("����00000002");
	    driver.findElement(By.id("mobile")).clear();
	    driver.findElement(By.id("mobile")).sendKeys("18666665555");
	    sleep();
	    driver.findElement(By.cssSelector("span.bluebtn30_text")).click();
	    driver.findElement(By.linkText("��������")).click();
	    //ѡ�������б���
	     Select select= new Select(driver.findElement(By.id("data_type")));
	     select.selectByValue("mobile");
	    
	    sleep();sleep();
	    driver.findElement(By.name("userName")).click();
	    driver.findElement(By.name("userName")).clear();
	    driver.findElement(By.name("userName")).sendKeys("66665555");
	    sleep(); sleep(); sleep();
	    driver.findElement(By.cssSelector("span.bluebtn25_text")).click();
	    sleep(); sleep(); sleep();sleep();
	    String expectNum="1";
	    String actualNum=driver.findElement(By.id("J_totalCount")).getText();
	    Assert.assertEquals(expectNum, actualNum);
	    sleep();sleep();
	    driver.findElement(By.linkText("ɾ��")).click();
	    driver.findElement(By.xpath("html/body/div[9]/table/tbody/tr[2]/td[2]/div[3]/button[1]")).click();
	    sleep();sleep();
	    driver.findElement(By.linkText("��������")).click();
	    sleep();sleep();
	}
	
	
	
	/**
	 * ����excel
	 */
	@Ignore
    public void exportByExcel(){
    	
    }
	
	
	/**
	 * 
	 */
	
	
}
