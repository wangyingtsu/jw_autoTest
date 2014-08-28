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
	
	
	public void sleep() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
