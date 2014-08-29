package testcase;

import static org.junit.Assert.assertEquals;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

public class RectutStudentsManage extends Base{
	/**
	 * 创建推荐人
	 */
	//@Test@Test
	public void creatReferrer(){
		String expectedCurrenturl = "http://jw." + env
				+ "ablesky.com/recommenderRedirect.do?action=toManage";
		driver.findElement(By.linkText("招生管理")).click();
		String actualCurrenturl = driver.getCurrentUrl();
		String title = driver.getTitle() + "  招生管理";
		System.out.println(title + "\n" + actualCurrenturl);
		assertEquals(expectedCurrenturl, actualCurrenturl);
	    sleep();
	   // driver.findElement(By.cssSelector("a.current")).click();
	    driver.findElement(By.cssSelector("span.greenbtn25_text")).click();
	    driver.findElement(By.id("name")).clear();
	    driver.findElement(By.id("name")).sendKeys("萝莉001");
	    driver.findElement(By.id("mobile")).clear();
	    driver.findElement(By.id("mobile")).sendKeys("18610221512");
	    sleep();
	    driver.findElement(By.cssSelector("span.bluebtn30_text")).click();
	    driver.findElement(By.linkText("招生管理")).click();
	    sleep(); sleep(); sleep();
	    driver.findElement(By.linkText("删除")).click();
	    driver.findElement(By.xpath("html/body/div[9]/table/tbody/tr[2]/td[2]/div[3]/button[1]")).click();
	    sleep();sleep();
	    driver.findElement(By.linkText("招生管理")).click();
	    
	}
	
	
	/**
	 * 不能创建同名的推荐人
	 */
	//@Test
	public void createReferrerwithsamename(){
		String expectedCurrenturl = "http://jw." + env
				+ "ablesky.com/recommenderRedirect.do?action=toManage";
		String expectederrorMess ="推荐人已经存在，不能创建重名推荐人";
		driver.findElement(By.linkText("招生管理")).click();
		String actualCurrenturl = driver.getCurrentUrl();
		String title = driver.getTitle() + "  招生管理";
		System.out.println(title + "\n" + actualCurrenturl);
		assertEquals(expectedCurrenturl, actualCurrenturl);
	    sleep();
	   // driver.findElement(By.cssSelector("a.current")).click();
	    driver.findElement(By.cssSelector("span.greenbtn25_text")).click();
	    driver.findElement(By.id("name")).clear();
	    driver.findElement(By.id("name")).sendKeys("萝莉001");
	    driver.findElement(By.id("mobile")).clear();
	    driver.findElement(By.id("mobile")).sendKeys("18610221512");
	    sleep();
	    driver.findElement(By.cssSelector("span.bluebtn30_text")).click();
	    driver.findElement(By.linkText("招生管理")).click();
	    sleep(); sleep(); sleep();
	    driver.findElement(By.cssSelector("span.greenbtn25_text")).click();
	    driver.findElement(By.id("name")).clear();
	    driver.findElement(By.id("name")).sendKeys("萝莉001");
	    driver.findElement(By.id("mobile")).clear();
	    driver.findElement(By.id("mobile")).sendKeys("18610221512");
	    sleep();
	    driver.findElement(By.cssSelector("span.bluebtn30_text")).click();
	    String  actualerrorMess = driver.findElement(By.id("name_tip")).getText();
	    Assert.assertEquals(expectederrorMess, actualerrorMess);
	    driver.findElement(By.cssSelector("span.graybtn30_text")).click();
	    driver.findElement(By.linkText("招生管理")).click();
	    //删除
	    sleep(); sleep();
	    driver.findElement(By.linkText("删除")).click();
	    driver.findElement(By.xpath("html/body/div[9]/table/tbody/tr[2]/td[2]/div[3]/button[1]")).click();
	    sleep();sleep();
	    driver.findElement(By.linkText("招生管理")).click();
		
	}
	
	
	/**
	 * 姓名不能超过100字
	 */
	//@Test
	public void nameover100(){
		String expectedCurrenturl = "http://jw." + env
				+ "ablesky.com/recommenderRedirect.do?action=toManage";
		String errorname="和发快件水电费撒的反馈和速度快发货快捷科技和福克斯很快就话费卡舒服的会计师回复会计师放得开康师傅会计师的恢复会计师回复会计师快快速货到付款喝口水发货快结案时很卡很卡很快会卡和啥的和发送号地块看到回复可见啥的和发";
		String rightname="萝莉002";
		driver.findElement(By.linkText("招生管理")).click();
		String actualCurrenturl = driver.getCurrentUrl();
		String title = driver.getTitle() + "  招生管理";
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
	    String expectederror="最多100位字符";
	    Assert.assertEquals(expectederror, actualerrormess);
	    
	    driver.findElement(By.id("name")).clear();
	    driver.findElement(By.id("name")).sendKeys(rightname);
	    driver.findElement(By.cssSelector("span.bluebtn30_text")).click();
	    
	    driver.findElement(By.linkText("招生管理")).click();
	    sleep(); sleep(); sleep();
	    driver.findElement(By.linkText("删除")).click();
	    driver.findElement(By.xpath("html/body/div[9]/table/tbody/tr[2]/td[2]/div[3]/button[1]")).click();
	    sleep();sleep();
	    driver.findElement(By.linkText("招生管理")).click();
		
		
	}
	
	
	/**
	 * 性别选择女
	 */
	//@Test
	public void gentelIsfemal(){
		String expectedCurrenturl = "http://jw." + env
				+ "ablesky.com/recommenderRedirect.do?action=toManage";
		driver.findElement(By.linkText("招生管理")).click();
		String actualCurrenturl = driver.getCurrentUrl();
		String title = driver.getTitle() + "  招生管理";
		System.out.println(title + "\n" + actualCurrenturl);
		assertEquals(expectedCurrenturl, actualCurrenturl);
	    sleep();
	   // driver.findElement(By.cssSelector("a.current")).click();
	    driver.findElement(By.cssSelector("span.greenbtn25_text")).click();
	    driver.findElement(By.id("name")).clear();
	    driver.findElement(By.id("name")).sendKeys("萝莉001");
	    sleep();
	    driver.findElement(By.xpath("(//input[@name='gender'])[2]")).click();
	    sleep();
	    driver.findElement(By.id("mobile")).clear();
	    driver.findElement(By.id("mobile")).sendKeys("18610221512");
	    sleep();
	    driver.findElement(By.cssSelector("span.bluebtn30_text")).click();
	    driver.findElement(By.linkText("招生管理")).click();
	    sleep(); sleep(); sleep();
	    driver.findElement(By.linkText("删除")).click();
	    driver.findElement(By.xpath("html/body/div[9]/table/tbody/tr[2]/td[2]/div[3]/button[1]")).click();
	    sleep();sleep();
	    driver.findElement(By.linkText("招生管理")).click();
		
	}
	
	
	
	
	/**
	 * 手机号输入规则验证
	 */
	   // @Test
		public void mobileNumber(){
			String expectedCurrenturl = "http://jw." + env
					+ "ablesky.com/recommenderRedirect.do?action=toManage";
			driver.findElement(By.linkText("招生管理")).click();
			String actualCurrenturl = driver.getCurrentUrl();
			String title = driver.getTitle() + "  招生管理";
			System.out.println(title + "\n" + actualCurrenturl);
			assertEquals(expectedCurrenturl, actualCurrenturl);
		    sleep();
		    driver.findElement(By.cssSelector("span.greenbtn25_text")).click();
		    driver.findElement(By.id("name")).clear();
		    driver.findElement(By.id("name")).sendKeys("萝莉002");
		    //当手机号输入字符
		    driver.findElement(By.id("mobile")).clear();
		    driver.findElement(By.id("mobile")).sendKeys("aaaaaaaa");
		    sleep();
		    driver.findElement(By.cssSelector("span.bluebtn30_text")).click();
		    String expectedErrorMess01="手机号码格式错误";
		    String actualerrorMessage01=driver.findElement(By.xpath(".//*[@id='J_createCircleBasic']/tbody/tr[3]/td[2]/div/label")).getText();
		    Assert.assertEquals(expectedErrorMess01, actualerrorMessage01);
		    //当手机号输入位数小于13位
		    driver.findElement(By.id("mobile")).clear();
		    driver.findElement(By.id("mobile")).sendKeys("1861022125");
		    sleep();
		    driver.findElement(By.cssSelector("span.bluebtn30_text")).click();
		    String expectedErrorMess02="手机号码格式错误";
		    String actualerrorMessage02=driver.findElement(By.xpath(".//*[@id='J_createCircleBasic']/tbody/tr[3]/td[2]/div/label")).getText();
		    Assert.assertEquals(expectedErrorMess02, actualerrorMessage02);
		    //当手机号输入超过13位
		    driver.findElement(By.id("mobile")).clear();
		    driver.findElement(By.id("mobile")).sendKeys("186102212556655");
		    sleep();
		    driver.findElement(By.cssSelector("span.bluebtn30_text")).click();
		    String expectedErrorMess03="手机号码格式错误";
		    String actualerrorMessage03=driver.findElement(By.xpath(".//*[@id='J_createCircleBasic']/tbody/tr[3]/td[2]/div/label")).getText();
		    Assert.assertEquals(expectedErrorMess03, actualerrorMessage03);
		    //输入正确的手机号
		    driver.findElement(By.id("mobile")).clear();
		    driver.findElement(By.id("mobile")).sendKeys("18512564569");
		    sleep();
		    driver.findElement(By.cssSelector("span.bluebtn30_text")).click();
		    sleep();sleep();
		    
		    driver.findElement(By.linkText("招生管理")).click();
		    sleep(); sleep(); sleep();
		    driver.findElement(By.linkText("删除")).click();
		    driver.findElement(By.xpath("html/body/div[9]/table/tbody/tr[2]/td[2]/div[3]/button[1]")).click();
		    sleep();sleep();
		    driver.findElement(By.linkText("招生管理")).click();
		    
		}
	
	
	
	
	
	/**
	 * 批量导入推荐人
	 */
		@Ignore
		public void importReferrerByExcel (){
			
		}
	
	
	

	/**
	 * 修改推荐人
	 */
		//@Test
		public void modifyReferrer(){
			String expectedCurrenturl = "http://jw." + env
					+ "ablesky.com/recommenderRedirect.do?action=toManage";
			driver.findElement(By.linkText("招生管理")).click();
			String actualCurrenturl = driver.getCurrentUrl();
			String title = driver.getTitle() + "  招生管理";
			System.out.println(title + "\n" + actualCurrenturl);
			assertEquals(expectedCurrenturl, actualCurrenturl);
		    sleep();
		    driver.findElement(By.cssSelector("span.greenbtn25_text")).click();
		    driver.findElement(By.id("name")).clear();
		    driver.findElement(By.id("name")).sendKeys("萝莉001");
		    driver.findElement(By.id("mobile")).clear();
		    driver.findElement(By.id("mobile")).sendKeys("18610221512");
		    sleep();
		    driver.findElement(By.cssSelector("span.bluebtn30_text")).click();
		    driver.findElement(By.linkText("招生管理")).click();
		    sleep(); sleep(); sleep();
		    driver.findElement(By.linkText("修改")).click();
		    sleep();
		    driver.findElement(By.id("name")).clear();
		    driver.findElement(By.id("name")).sendKeys("萝莉002");
		    driver.findElement(By.xpath(".//*[@id='J_createCircleBasic']/tbody/tr[2]/td[2]/div/input[2]")).click();
		    driver.findElement(By.id("mobile")).clear();
		    driver.findElement(By.id("mobile")).sendKeys("18610226666");
		    sleep();
		    driver.findElement(By.cssSelector("span.bluebtn30_text")).click();
		    sleep();
		    driver.findElement(By.linkText("招生管理")).click();
		    
		    driver.findElement(By.linkText("删除")).click();
		    driver.findElement(By.xpath("html/body/div[9]/table/tbody/tr[2]/td[2]/div[3]/button[1]")).click();
		    sleep();sleep();
		    driver.findElement(By.linkText("招生管理")).click();
		}
	
	
	
	/**
	 * 查看推荐学员
	 */
	public void recommendStudentsList(){
		
	}
	
	
	/**
	 * 查看推荐课程
	 */
	
	public void recommendCoursesList(){
		
	}
	
	
	/**
	 * 按姓名搜索推荐人
	 */
	//@Test
	public void queryByNmae(){
		String expectedCurrenturl = "http://jw." + env
				+ "ablesky.com/recommenderRedirect.do?action=toManage";
		driver.findElement(By.linkText("招生管理")).click();
		String actualCurrenturl = driver.getCurrentUrl();
		String title = driver.getTitle() + "  招生管理";
		System.out.println(title + "\n" + actualCurrenturl);
		assertEquals(expectedCurrenturl, actualCurrenturl);
	    sleep();
	    driver.findElement(By.cssSelector("span.greenbtn25_text")).click();
	    driver.findElement(By.id("name")).clear();
	    driver.findElement(By.id("name")).sendKeys("萝莉00000001");
	    driver.findElement(By.id("mobile")).clear();
	    driver.findElement(By.id("mobile")).sendKeys("18666668888");
	    sleep();
	    driver.findElement(By.cssSelector("span.bluebtn30_text")).click();
	    driver.findElement(By.linkText("招生管理")).click();
	    
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
	    
	    driver.findElement(By.linkText("删除")).click();
	    driver.findElement(By.xpath("html/body/div[9]/table/tbody/tr[2]/td[2]/div[3]/button[1]")).click();
	    sleep();sleep();
	    driver.findElement(By.linkText("招生管理")).click();
		
		
	}
	
	
	/**
	 * 按手机号码搜索推荐人
	 */
	@Test
    public void queryByMobile(){
    	String expectedCurrenturl = "http://jw." + env
				+ "ablesky.com/recommenderRedirect.do?action=toManage";
		driver.findElement(By.linkText("招生管理")).click();
		String actualCurrenturl = driver.getCurrentUrl();
		String title = driver.getTitle() + "  招生管理";
		System.out.println(title + "\n" + actualCurrenturl);
		assertEquals(expectedCurrenturl, actualCurrenturl);
	    sleep();
	    driver.findElement(By.cssSelector("span.greenbtn25_text")).click();
	    driver.findElement(By.id("name")).clear();
	    driver.findElement(By.id("name")).sendKeys("萝莉00000002");
	    driver.findElement(By.id("mobile")).clear();
	    driver.findElement(By.id("mobile")).sendKeys("18666665555");
	    sleep();
	    driver.findElement(By.cssSelector("span.bluebtn30_text")).click();
	    driver.findElement(By.linkText("招生管理")).click();
	    //选择下拉列表方法
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
	    driver.findElement(By.linkText("删除")).click();
	    driver.findElement(By.xpath("html/body/div[9]/table/tbody/tr[2]/td[2]/div[3]/button[1]")).click();
	    sleep();sleep();
	    driver.findElement(By.linkText("招生管理")).click();
	    sleep();sleep();
	}
	
	
	
	/**
	 * 导出excel
	 */
	@Ignore
    public void exportByExcel(){
    	
    }
	
	
	/**
	 * 
	 */
	
	
}
