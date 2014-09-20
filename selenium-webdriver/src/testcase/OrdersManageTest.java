package testcase;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class OrdersManageTest extends Base {
	// 数据准备
	public void dataPre() {
		this.createStucom();// 调用基类中的创建学员的方法
		System.out.println("aaaaaaaaaaa");
		this.createCoursecom();// 调用基类中的创建课程的方法
		System.out.println("bbbbbbbbb");
		this.createRefcom();// 调用基类中的创建推荐人的方法
	}
	// 数据清除
	public void dataClear() {
		this.deleteStucom();
		this.deleteCoursecom();
		this.deleteRefcom();
	}
	/**
	 * 正常创建订单
	 */
	@Test
	public void createOrderformal() {
		this.dataPre();
		this.creatOrderCom();
		this.dataClear();
	}
	/**
	 * 创建订单时学员不能为空
	 */
    @Test
	public void createOrderWithoutStudent() {
		sleep();
		driver.findElement(By.linkText("订单管理")).click();
		sleep();
		driver.findElement(By.className("greenbtn25_text")).click();// 点击创建订单按钮
		sleep();
		// 确定
		List<WebElement> comfs = driver.findElements(By
				.className("bluebtn30_text"));
		for (WebElement comf : comfs) {
			String con = comf.getText();
			if (con.equals("确定")) {
				comf.click();
			}
			break;
		}
		sleep();
		System.out.println("aaaaaa");
		// 姓名不能为空提示
		String expecterror1 = "姓名不能为空";
		String actuerror1 = driver.findElement(
						By.xpath(".//*[@id='J_courseOrder']/tbody/tr[1]/td[2]/div/label[2]"))
				.getText();
		System.out.println(actuerror1 + "*****");
		Assert.assertEquals(expecterror1, actuerror1);
		// 取消
		List<WebElement> comfs1 = driver.findElements(By
				.className("bluebtn30_text"));
		for (WebElement ref : comfs1) {
			String con = ref.getText();
			if (con.equals("取消")) {
				ref.click();
			}
			break;
		}
		System.out.println("bbbbb");
		sleep();
	}

	/**
	 * 创建订单时课程不能为空
	 */
	@Test
	public void createOrderWithoutCourse() {
		sleep();
		driver.findElement(By.linkText("订单管理")).click();
		sleep();
		driver.findElement(By.className("greenbtn25_text")).click();// 点击创建订单按钮
		sleep();
		// 确定
		List<WebElement> comfs = driver.findElements(By
				.className("bluebtn30_text"));
		for (WebElement comf : comfs) {
			String con = comf.getText();
			if (con.equals("确定")) {
				comf.click();
			}
			break;
		}
		sleep();
		// 课程不能为空提示
		String expecterror2 = "课程不能为空";
		String actuerror2 = driver.findElement(
						By.xpath(".//*[@id='J_courseOrder']/tbody/tr[2]/td[2]/div/label[2]"))
				.getText();
		System.out.println(actuerror2 + "*****");
		Assert.assertEquals(expecterror2, actuerror2);
		// 取消
		List<WebElement> comfs1 = driver.findElements(By
				.className("bluebtn30_text"));
		for (WebElement ref : comfs1) {
			String con = ref.getText();
			if (con.equals("取消")) {
				ref.click();
			}
			break;
		}
		sleep();
	}

	/**
	 * 创建订单时折扣价不能为空
	 */
	@Test
	public void createOrderWithoutPrice() {
		sleep();
		driver.findElement(By.linkText("订单管理")).click();
		sleep();
		driver.findElement(By.className("greenbtn25_text")).click();// 点击创建订单按钮
		sleep();
		this.selectstudent();
		sleep();
		this.selectCourse();
		// 确定
		List<WebElement> comfs = driver.findElements(By
				.className("bluebtn30_text"));
		for (WebElement comf : comfs) {
			String con = comf.getText();
			if (con.equals("确定")) {
				comf.click();
			}
			break;
		}
		sleep();
		// 折扣价不能为空
		String expecterror3 = "折扣价不能为空";
		String actuerror3 = driver.findElement(
						By.xpath("html/body/div[4]/div[2]/div/div"))
				.getText();
		System.out.println(actuerror3 + "*****");
		Assert.assertEquals(expecterror3, actuerror3);
		// 取消
		List<WebElement> comfs1 = driver.findElements(By
				.className("bluebtn30_text"));
		for (WebElement ref : comfs1) {
			String con = ref.getText();
			if (con.equals("取消")) {
				ref.click();
			}
			break;
		}
		sleep();
	}
	
	//选择学员方法
	public void selectstudent(){
		driver.findElement(By.id("order_stuName")).clear();
		driver.findElement(By.id("order_stuName")).click();//选择学员
		sleep();
		//采用弹出框中的第一行数据
		driver.findElement(By.xpath(".//*[@id='choice_clc_list']/tbody/tr[1]/td[1]/label")).click();
		//点击弹框中的确认按钮
		sleep();
    	driver.findElement(By.xpath(".//*[@id='choice_clc']/table/tbody/tr[2]/td[2]/div[3]/button[1]")).click();
	}
	//选择课程
	public void selectCourse(){
		sleep();sleep();
		driver.findElement(By.id("order_course")).click();
		sleep();sleep();
		//采用弹出框中的第一行数据
		driver.findElement(By.xpath(".//*[@id='choice_clc_list']/tbody/tr[1]/td[1]/label")).click();
		//点击确认按钮
		driver.findElement(By.xpath(".//*[@id='choice_clc']/table/tbody/tr[2]/td[2]/div[3]/button[1]")).click();
		sleep();
	}

	/**
	 * 订单类型为线上的订单
	 * 订单性质为意向需求与成交订单
	 */
    @Test
	public void createOnlineOrder() {
		sleep();
		driver.findElement(By.linkText("订单管理")).click();
		sleep();
		driver.findElement(By.className("greenbtn25_text")).click();// 点击创建订单按钮
		sleep();
		this.selectstudent();
		sleep();
		this.selectCourse();
		sleep();
		driver.findElement(By.id("order_coursePrice")).clear();
		driver.findElement(By.id("order_coursePrice")).sendKeys("0");
		Select select1 = new Select(driver.findElement(By.id("order_type")));
		select1.selectByValue("up");//线上
		sleep();
		Select select2 = new Select(driver.findElement(By.id("order_character")));
		select2.selectByValue("ordersuccess");//成交订单
		// 确定
		List<WebElement> comfs = driver.findElements(By
				.className("bluebtn30_text"));
		for (WebElement comf : comfs) {
			String con = comf.getText();
			if (con.equals("确定")) {
				comf.click();
			}
			break;
		}
		sleep();
		}

	/**
	 * 订单备注不能超过100字
	 */
	@Test
	public void description() {
		String  des="金卡电话费空间的收费会计啥的和费空间和地方科技阿和地方课件沪电股份空间按时但很快就很大方金卡电话费空间的收费会计啥的和费空间和地方科技阿和地方课件沪电股份空间按时但很快就很大方金卡电话费空间的收费会计啥的和费空间和地方科技阿和地方课件";
		
		sleep();
		driver.findElement(By.linkText("订单管理")).click();
		sleep();
		driver.findElement(By.className("greenbtn25_text")).click();// 点击创建订单按钮
		sleep();
		this.selectstudent();
		sleep();
		this.selectCourse();
		sleep();
		driver.findElement(By.id("order_coursePrice")).clear();
		driver.findElement(By.id("order_coursePrice")).sendKeys("0");
		driver.findElement(By.id("J_tinyContainer")).sendKeys(des);
		sleep();
		// 确定
		List<WebElement> comfs = driver.findElements(By
				.className("bluebtn30_text"));
		for (WebElement comf : comfs) {
			String con = comf.getText();
			if (con.equals("确定")) {
				comf.click();
			}
			break;
		}
		String message=driver.findElement(By.xpath("html/body/div[4]/div[2]/div/div")).getText();
		
		System.out.println(message+"^^^^^^^^^");
		Assert.assertEquals("备注不能超过100个字符", message);
		sleep();
		List<WebElement> comfs2 = driver.findElements(By
				.className("bluebtn30_text"));
		for (WebElement comf : comfs2) {
			String con = comf.getText();
			if (con.equals("取消")) {
				comf.click();
			}
			break;
		}
		sleep();

	}

	/**
	 * 按订单号搜索订单
	 */
	@Test
	public void searchByOrderNumber() {
		sleep();
		driver.findElement(By.linkText("订单管理")).click();
		sleep();
		driver.findElement(By.className("greenbtn25_text")).click();// 点击创建订单按钮
		sleep();
		this.selectstudent();
		sleep();
		this.selectCourse();
		sleep();
		driver.findElement(By.id("order_coursePrice")).clear();
		driver.findElement(By.id("order_coursePrice")).sendKeys("0");
		Select select1 = new Select(driver.findElement(By.id("order_type")));
		select1.selectByValue("up");//线上
		sleep();
		Select select2 = new Select(driver.findElement(By.id("order_character")));
		select2.selectByValue("ordersuccess");//成交订单
		// 确定
		List<WebElement> comfs = driver.findElements(By
				.className("bluebtn30_text"));
		for (WebElement comf : comfs) {
			String con = comf.getText();
			if (con.equals("确定")) {
				comf.click();
			}
			break;
		}
		//点击详情按钮
		driver.findElement(By.xpath(".//*[@id='J_pmDataTables']/tbody/tr[1]/td[9]/div/a[1]")).click();
		//获取订单号
		String orderNumber=driver.findElement(By.xpath("html/body/div[4]/div[2]/div/div[1]/div")).getText();
		System.out.println(orderNumber+"*****");
		sleep();
		driver.findElement(By.linkText("订单管理")).click();
		Select select3 = new Select(driver.findElement(By.id("search_type")));
		select3.selectByValue("orderNum");//订单号
		//将订单号输入到文本框中
		driver.findElement(By.id("search_value")).clear();
		driver.findElement(By.id("search_value")).sendKeys(orderNumber);
		//点击查询按钮
		driver.findElement(By.cssSelector("span.bluebtn25_text")).click();
		sleep();
		String count=driver.findElement(By.id("J_totalCount")).getText();
		System.out.println(count+"^^^^^^");
		Assert.assertEquals("1", count);
		
	}



	/**
	 * 修改订单
	 */
	@Test
	public void modifyOrder() {
		sleep();
		driver.findElement(By.linkText("订单管理")).click();
		sleep();
		driver.findElement(By.className("greenbtn25_text")).click();// 点击创建订单按钮
		sleep();
		this.selectstudent();
		sleep();
		this.selectCourse();
		sleep();
		driver.findElement(By.id("order_coursePrice")).clear();
		driver.findElement(By.id("order_coursePrice")).sendKeys("0");
		Select select1 = new Select(driver.findElement(By.id("order_type")));
		select1.selectByValue("up");//线上
		sleep();
		Select select2 = new Select(driver.findElement(By.id("order_character")));
		select2.selectByValue("ordersuccess");//成交订单
		// 确定
		List<WebElement> comfs = driver.findElements(By
				.className("bluebtn30_text"));
		for (WebElement comf : comfs) {
			String con = comf.getText();
			if (con.equals("确定")) {
				comf.click();
			}
			break;
		}
		sleep();
		//修改按钮
		driver.findElement(By.xpath(".//*[@id='J_pmDataTables']/tbody/tr[1]/td[9]/div/a[2]")).click();
		sleep();
		driver.findElement(By.id("order_original")).clear();
		driver.findElement(By.id("order_original")).sendKeys("123");
		driver.findElement(By.id("order_coursePrice")).clear();
		driver.findElement(By.id("order_coursePrice")).sendKeys("100");
		driver.findElement(By.xpath(".//*[@id='J_sumitform']/span")).click();

	}

	/**
	 * 删除订单
	 */
	@Test
	public void deleteOrder() {
		driver.findElement(By.linkText("订单管理")).click();
		sleep();
        driver.findElement(By.xpath(".//*[@id='J_pmDataTables']/tbody/tr[1]/td[9]/div/a[3]")).click();//点击删除按钮
       
//        Alert alert = driver.switchTo().alert();
//        alert.accept();
        //确认按钮
        driver.findElement(By.xpath("html/body/div[8]/table/tbody/tr[2]/td[2]/div[3]/button[1]")).click();
    	sleep();
	}

	/**
	 * 退款操作
	 */
	@Test
	public void refund() {
		sleep();
		driver.findElement(By.linkText("订单管理")).click();
		sleep();
		driver.findElement(By.className("greenbtn25_text")).click();// 点击创建订单按钮
		sleep();
		this.selectstudent();
		sleep();
		this.selectCourse();
		sleep();
		driver.findElement(By.id("order_coursePrice")).clear();
		driver.findElement(By.id("order_coursePrice")).sendKeys("0");
		Select select1 = new Select(driver.findElement(By.id("order_type")));
		select1.selectByValue("up");//线上
		sleep();
		Select select2 = new Select(driver.findElement(By.id("order_character")));
		select2.selectByValue("ordersuccess");//成交订单
		// 确定
		List<WebElement> comfs = driver.findElements(By
				.className("bluebtn30_text"));
		for (WebElement comf : comfs) {
			String con = comf.getText();
			if (con.equals("确定")) {
				comf.click();
			}
			break;
		}
		sleep();
		
		driver.findElement(By.linkText("订单管理")).click();
		sleep();
		//点击退款按钮
		driver.findElement(By.xpath(".//*[@id='J_pmDataTables']/tbody/tr[1]/td[9]/div/a[4]")).click();
		//确认按钮
		driver.findElement(By.xpath("html/body/div[8]/table/tbody/tr[2]/td[2]/div[3]/button[1]")).click();
	}
	
	
	

}
