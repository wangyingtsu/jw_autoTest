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
		//火狐浏览器最高版本支持到29.0
		System.out.println("firefox browser will be open");
		System.setProperty("webdriver.firefox.bin","C:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe");
		 driver = new FirefoxDriver();
		 driver.manage().window().maximize();
		 baseUrl = "http://jw.ablesky.com/";
		//将窗口最大化
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
			//将窗口最大化
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		}
		else if(browser=="IE"){
			System.out.println("IE  browser is open");
		 
				/**
				 * 当采用 InterenetExplorerDriver时，可能会遇到一个安全问题提示："Protected Mode must be set to the same value (enabled or disabled) for all zones"。想要解决这一问题，需要设置特定的功能
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
		//driver.findElement(By.linkText("课程管理")).click();
		driver.findElement(By.linkText("[退出]")).click();
		// stop driver
		System.out.println("browser will be closed");
		driver.quit();
		System.out.println("browser is closed");
		String verificationErrorString = verificationErrors.toString();
		if (!"".equals(verificationErrorString)) {
			fail(verificationErrorString);
		}
	}
	
	//创建学员公共方法
		public void createStucom(){
			String name="ymgg11";//在学员管理中用到此数据，不能更改此变量
			sleep();sleep();
			driver.findElement(By.linkText("学员管理")).click();
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
			//driver.findElement(By.linkText("学员管理")).click();
			System.out.println("mmmm");
		}
		//删除学员公共方法
		public void deleteStucom(){
			sleep();
			driver.findElement(By.linkText("学员管理")).click();
			sleep();
			driver.findElement(By.linkText("删除")).click();		
			//driver.findElement(By.xpath("(//a[contains(text(),'删除')])[1]")).click();//删除学员（数字显示第几个，列表中就删除第几个学员）
		    driver.findElement(By.cssSelector("button[type=\"button\"]")).click();	    
		    sleep();
		    driver.findElement(By.linkText("学员管理")).click();
			
		}
	
	//创建老师
	
	//创建班级
	
	//创建班级类目
	
	//创建课程公共方法
		public void createCoursecom(){
			String coursename = "测试课程-绿萝";
			driver.findElement(By.linkText("课程管理")).click();
			sleep();
			driver.findElement(By.cssSelector("span.greenbtn25_text")).click();
			driver.findElement(By.id("courseName")).clear();
			driver.findElement(By.id("courseName")).sendKeys(coursename);
			driver.findElement(By.id("coursePrice")).clear();
			driver.findElement(By.id("coursePrice")).sendKeys("12");
			driver.findElement(By.id("J_tinyContainer")).clear();
			driver.findElement(By.id("J_tinyContainer")).sendKeys("语文课——测试课程");
			driver.findElement(By.cssSelector("span.bluebtn30_text")).click();
			driver.findElement(By.cssSelector("a.current")).click();
//			driver.findElement(By.linkText("课程管理")).click();
//			driver.findElement(By.linkText("课程管理")).click();
		}
		public void deleteCoursecom(){
			// 删除测试课程
			       driver.findElement(By.linkText("课程管理")).click();
					driver.findElement(By.cssSelector("a.current")).click();
					driver.findElement(By.linkText("删除")).click();
					driver.findElement(By.cssSelector("button[type=\"button\"]")).click();
					sleep();
			
		}
	
	//创建教室
	
	
	//创建推荐人公共方法
		public void  createRefcom(){
			sleep();sleep();
			driver.findElement(By.linkText("招生管理")).click();
			sleep();sleep();
			driver.findElement(By.cssSelector("span.greenbtn25_text")).click();
			driver.findElement(By.id("name")).clear();
			driver.findElement(By.id("name")).sendKeys("萝莉001");
			driver.findElement(By.id("mobile")).clear();
			driver.findElement(By.id("mobile")).sendKeys("18610221512");
			sleep();
			driver.findElement(By.cssSelector("span.bluebtn30_text")).click();
			driver.findElement(By.linkText("招生管理")).click();
			sleep();sleep();sleep();
			driver.findElement(By.cssSelector("a.current")).click();

		}
		//公共方法
		public void deleteRefcom(){
			sleep();
			driver.findElement(By.linkText("招生管理")).click();
			sleep();
			driver.findElement(By.linkText("删除")).click();
			driver.findElement(
					By.xpath("html/body/div[9]/table/tbody/tr[2]/td[2]/div[3]/button[1]"))
					.click();
			sleep();
		}
	
		//创建订单公共方法
		public void creatOrderCom(){
			String expectedCurrenturl = "http://jw."+ env
					+"ablesky.com/courseOrderRedirect.do?action=toCourseOrderList";
			String name="ymgg11";
			sleep();
			driver.findElement(By.linkText("订单管理")).click();
			String actualCurrentur1 = driver.getCurrentUrl();
			String title = driver.getTitle() + "订单管理";
			System.out.println(title + "\n" + actualCurrentur1);                                                                                                                                                                                                                                                                              
			assertEquals(expectedCurrenturl,actualCurrentur1);
			sleep();
			driver.findElement(By.className("greenbtn25_text")).click();//点击创建订单按钮
			sleep();
			driver.findElement(By.id("order_stuName")).clear();
			driver.findElement(By.id("order_stuName")).click();//选择学员
			//在弹出框中选择学员
			List<WebElement> ele=driver.findElements(By.className("clc-item-name"));
			for(WebElement e:ele){
				String stuName=e.getText();
				System.out.println(stuName+"####");
				if (stuName.equals(name)){
					e.click();
				}
				break;
			}
			//点击弹框中的确认按钮
		driver.findElement(By.xpath(".//*[@id='choice_clc']/table/tbody/tr[2]/td[2]/div[3]/button[1]")).click();
		//选择课程
		sleep();sleep();
		String coursename = "测试课程-绿萝";
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
		//点击确认按钮
		driver.findElement(By.xpath(".//*[@id='choice_clc']/table/tbody/tr[2]/td[2]/div[3]/button[1]")).click();
		sleep();
		//输入折扣价
		driver.findElement(By.id("order_coursePrice")).clear();
		driver.findElement(By.id("order_coursePrice")).sendKeys("10");
		//课程推荐人
		String refename = "萝莉001";
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
		//点击提交表单的确认按钮
		sleep();
		List<WebElement>  comfs=driver.findElements(By.className("bluebtn30_text"));
		for(WebElement comf:comfs ){
			String  con=comf.getText();
			if(con.equals("确定")){
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
