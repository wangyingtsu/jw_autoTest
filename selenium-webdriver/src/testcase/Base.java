package testcase;

import static org.junit.Assert.fail;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class Base {
	public WebDriver driver;
	public String baseUrl;
	public boolean acceptNextAlert = true;
	public StringBuffer verificationErrors = new StringBuffer();
	public String env="";
	//public String env="beta";
	public String username="auto_test";
	public String password="auto_test";

	@Before
	public void setUp() throws Exception {
		String browser ="firefox";
		// start driver
		//�������û�а�װ��C�̣��ô˾�System.setProperty("webdriver.firefox.bin","D:/MozillaFirefox/firefox.exe");
		System.out.println("browser will be open");
		if(browser=="firefox"){
			
		 driver = new FirefoxDriver();
		 driver.manage().window().maximize();
		 baseUrl = "http://jw.ablesky.com/";
		//���������
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		System.out.println("browser is open");
		
		}
		else if(browser=="ie"){
			
			 driver = new InternetExplorerDriver();;
			 driver.manage().window().maximize();
			 baseUrl = "http://jw.ablesky.com/";
			//���������
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			/**
			 * ������ InterenetExplorerDriverʱ�����ܻ�����һ����ȫ������ʾ��"Protected Mode must be set to the same value (enabled or disabled) for all zones"����Ҫ�����һ���⣬��Ҫ�����ض��Ĺ���
			 */
			DesiredCapabilities capability=DesiredCapabilities.internetExplorer(); 
			 capability.setCapability( 
			              InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true); 
			 WebDriver webdriver = new InternetExplorerDriver(capability);
		}

		
		// login
		driver.get(baseUrl + "/");
		driver.findElement(By.name("username")).clear();
		driver.findElement(By.name("username")).sendKeys(username);
		driver.findElement(By.name("password")).clear();
		driver.findElement(By.name("password")).sendKeys(password);
		WebElement element =driver.findElement(By.cssSelector("span.bluebtn35_text"));
		element.click();
	}

	@After
	public void tearDown() throws Exception {
		// logout
		//driver.findElement(By.linkText("�γ̹���")).click();
		driver.findElement(By.linkText("[�˳�]")).click();
		// stop driver
		System.out.println("browser will be closed");
		driver.quit();
		System.out.println("browser is closed");
		String verificationErrorString = verificationErrors.toString();
		if (!"".equals(verificationErrorString)) {
			fail(verificationErrorString);
		}
	}
	
	//����ѧԱ��������
		public void createStucom(){
			String name="ymgg11";//��ѧԱ�������õ������ݣ����ܸ��Ĵ˱���
			sleep();sleep();
			driver.findElement(By.linkText("ѧԱ����")).click();
			driver.findElement(By.cssSelector("span.greenbtn25_text")).click();
			driver.findElement(By.id("name")).click();
			driver.findElement(By.id("name")).clear();
			driver.findElement(By.id("name")).sendKeys(name);
			driver.findElement(By.xpath("(//input[@name='gender'])[2]")).click();
			driver.findElement(By.name("mobile")).clear();
			driver.findElement(By.name("mobile")).sendKeys("13522224444");
			driver.findElement(By.name("recommenderIdbefore")).click();
			driver.findElement(By.id("ymgg")).click();
			driver.findElement(By.cssSelector("button[type=\"button\"]")).click();
			driver.findElement(By.cssSelector("span.bluebtn30_text")).click();
			
		}
		//ɾ��ѧԱ��������
		public void deleteStucom(){
			sleep();
			driver.findElement(By.linkText("ѧԱ����")).click();
			sleep();
			driver.findElement(By.linkText("ɾ��")).click();		
			//driver.findElement(By.xpath("(//a[contains(text(),'ɾ��')])[1]")).click();//ɾ��ѧԱ��������ʾ�ڼ������б��о�ɾ���ڼ���ѧԱ��
		    driver.findElement(By.cssSelector("button[type=\"button\"]")).click();	    
		    sleep();
			
		}
	
	//������ʦ
	
	//�����༶
	
	//�����༶��Ŀ
	
	//�����γ̹�������
		public void createCoursecom(){
			String coursename = "���Կγ�-����";
			driver.findElement(By.linkText("�γ̹���")).click();
			driver.findElement(By.cssSelector("span.greenbtn25_text")).click();
			driver.findElement(By.id("courseName")).clear();
			driver.findElement(By.id("courseName")).sendKeys(coursename);
			driver.findElement(By.id("coursePrice")).clear();
			driver.findElement(By.id("coursePrice")).sendKeys("12");
			driver.findElement(By.id("J_tinyContainer")).clear();
			driver.findElement(By.id("J_tinyContainer")).sendKeys("���ĿΡ������Կγ�");
			driver.findElement(By.cssSelector("span.bluebtn30_text")).click();
		}
		public void deleteCoursecom(){
			// ɾ�����Կγ�
			       driver.findElement(By.linkText("�γ̹���")).click();
					driver.findElement(By.cssSelector("a.current")).click();
					driver.findElement(By.linkText("ɾ��")).click();
					driver.findElement(By.cssSelector("button[type=\"button\"]")).click();
					sleep();
			
		}
	
	//��������
	
	
	//�����Ƽ��˹�������
		public void  createRefcom(){
			sleep();sleep();
			driver.findElement(By.linkText("��������")).click();
			driver.findElement(By.cssSelector("span.greenbtn25_text")).click();
			driver.findElement(By.id("name")).clear();
			driver.findElement(By.id("name")).sendKeys("����001");
			driver.findElement(By.id("mobile")).clear();
			driver.findElement(By.id("mobile")).sendKeys("18610221512");
			sleep();
			driver.findElement(By.cssSelector("span.bluebtn30_text")).click();
			driver.findElement(By.linkText("��������")).click();
			sleep();

		}
		//��������
		public void deleteRefcom(){
			sleep();
			driver.findElement(By.linkText("��������")).click();
			sleep();
			driver.findElement(By.linkText("ɾ��")).click();
			driver.findElement(
					By.xpath("html/body/div[9]/table/tbody/tr[2]/td[2]/div[3]/button[1]"))
					.click();
			sleep();
		}
	
	//
	
	public void sleep() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
