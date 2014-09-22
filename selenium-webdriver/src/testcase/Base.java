package testcase;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
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
	public String browser ="IE";
	@Before
	public void setUp() throws Exception {
	
		// start driver   
		if(browser=="firefox"){
		//����������߰汾֧�ֵ�29.0
		System.out.println("firefox browser will be open");
		System.setProperty("webdriver.firefox.bin","C:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe");
		 driver = new FirefoxDriver();
		 driver.manage().window().maximize();
		 baseUrl = "http://jw.ablesky.com/";
		//���������
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		System.out.println("firefox browser is open");
		
		}
		else if(browser=="chrome"){
			System.out.println("chrome  browser is open");
			System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
			// System.setProperty("webdriver.chrome.driver", "D:\\chromedriver\\chromedriver.exe");
			 driver = new ChromeDriver();
			 driver.manage().window().maximize();
			 baseUrl = "http://jw.ablesky.com/";
			//���������
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		}
		else if(browser=="IE"){
			System.out.println("IE  browser is open");
		 
				/**
				 * ������ InterenetExplorerDriverʱ�����ܻ�����һ����ȫ������ʾ��"Protected Mode must be set to the same value (enabled or disabled) for all zones"����Ҫ�����һ���⣬��Ҫ�����ض��Ĺ���
				 */
			DesiredCapabilities ieCapabilities = DesiredCapabilities.internetExplorer();
		     ieCapabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
		     System.setProperty("webdriver.ie.driver", "drivers\\IEDriverServer.exe");
		     driver = new InternetExplorerDriver(ieCapabilities);
			 driver.manage().window().maximize();
			 baseUrl = "http://jw.ablesky.com/";
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

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

			driver.findElement(By.cssSelector("span.bluebtn30_text")).click();
			System.out.println("tttttt");
			driver.findElement(By.cssSelector("a.current")).click();
			//driver.findElement(By.linkText("ѧԱ����")).click();
			System.out.println("mmmm");
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
		    driver.findElement(By.linkText("ѧԱ����")).click();
			
		}
	
	//������ʦ
	
	//�����༶
	
	//�����༶��Ŀ
	
	//�����γ̹�������
		public void createCoursecom(){
			String coursename = "���Կγ�-����";
			driver.findElement(By.linkText("�γ̹���")).click();
			sleep();
			driver.findElement(By.cssSelector("span.greenbtn25_text")).click();
			driver.findElement(By.id("courseName")).clear();
			driver.findElement(By.id("courseName")).sendKeys(coursename);
			driver.findElement(By.id("coursePrice")).clear();
			driver.findElement(By.id("coursePrice")).sendKeys("12");
			driver.findElement(By.id("J_tinyContainer")).clear();
			driver.findElement(By.id("J_tinyContainer")).sendKeys("���ĿΡ������Կγ�");
			driver.findElement(By.cssSelector("span.bluebtn30_text")).click();
			driver.findElement(By.cssSelector("a.current")).click();
//			driver.findElement(By.linkText("�γ̹���")).click();
//			driver.findElement(By.linkText("�γ̹���")).click();
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
			sleep();sleep();
			driver.findElement(By.cssSelector("span.greenbtn25_text")).click();
			driver.findElement(By.id("name")).clear();
			driver.findElement(By.id("name")).sendKeys("����001");
			driver.findElement(By.id("mobile")).clear();
			driver.findElement(By.id("mobile")).sendKeys("18610221512");
			sleep();
			driver.findElement(By.cssSelector("span.bluebtn30_text")).click();
			driver.findElement(By.linkText("��������")).click();
			sleep();sleep();sleep();
			driver.findElement(By.cssSelector("a.current")).click();

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
	
		//����������������
		public void creatOrderCom(){
			String expectedCurrenturl = "http://jw."+ env
					+"ablesky.com/courseOrderRedirect.do?action=toCourseOrderList";
			String name="ymgg11";
			sleep();
			driver.findElement(By.linkText("��������")).click();
			String actualCurrentur1 = driver.getCurrentUrl();
			String title = driver.getTitle() + "��������";
			System.out.println(title + "\n" + actualCurrentur1);                                                                                                                                                                                                                                                                              
			assertEquals(expectedCurrenturl,actualCurrentur1);
			sleep();
			driver.findElement(By.className("greenbtn25_text")).click();//�������������ť
			sleep();
			driver.findElement(By.id("order_stuName")).clear();
			driver.findElement(By.id("order_stuName")).click();//ѡ��ѧԱ
			//�ڵ�������ѡ��ѧԱ
			List<WebElement> ele=driver.findElements(By.className("clc-item-name"));
			for(WebElement e:ele){
				String stuName=e.getText();
				System.out.println(stuName+"####");
				if (stuName.equals(name)){
					e.click();
				}
				break;
			}
			//��������е�ȷ�ϰ�ť
		driver.findElement(By.xpath(".//*[@id='choice_clc']/table/tbody/tr[2]/td[2]/div[3]/button[1]")).click();
		//ѡ��γ�
		sleep();sleep();
		String coursename = "���Կγ�-����";
		driver.findElement(By.id("order_course")).click();
		List<WebElement> cou=driver.findElements(By.className("clc-item-name"));
		for(WebElement c:cou){
			String stuName=c.getText();
			System.out.println(stuName+"$$$$");
			if (stuName.equals(coursename)){
				c.click();
			}
			break;
		}
		sleep();sleep();
		//���ȷ�ϰ�ť
		driver.findElement(By.xpath(".//*[@id='choice_clc']/table/tbody/tr[2]/td[2]/div[3]/button[1]")).click();
		sleep();
		//�����ۿۼ�
		driver.findElement(By.id("order_coursePrice")).clear();
		driver.findElement(By.id("order_coursePrice")).sendKeys("10");
		//�γ��Ƽ���
		String refename = "����001";
		driver.findElement(By.id("order_recomm")).click();
		sleep();
		List<WebElement> rec=driver.findElements(By.className("clc-item-name"));
		for(WebElement re:rec){
			String ReName=re.getText();
			System.out.println(ReName+"$$$$");
			if (ReName.equals(refename)){
				re.click();
			}
			break;
		}
		driver.findElement(By.xpath(".//*[@id='choice_clc']/table/tbody/tr[2]/td[2]/div[3]/button[1]")).click();
		//����ύ����ȷ�ϰ�ť
		sleep();
		List<WebElement>  comfs=driver.findElements(By.className("bluebtn30_text"));
		for(WebElement comf:comfs ){
			String  con=comf.getText();
			if(con.equals("ȷ��")){
				comf.click();
			}
			break;
					
		}
		}
		
	
	public void sleep() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
