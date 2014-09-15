package testcase;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

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
	// @Test
	public void createOrderformal() {
		this.dataPre();
		this.creatOrderCom();
		this.dataClear();
	}
	/**
	 * 创建订单时学员不能为空
	 */
//	@Test
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
	public void createOrderWithoutPrice() {

	}

	/**
	 * 订单类型为线上的订单
	 */
	public void createOnlineOrder() {

	}

	/**
	 * 订单性质为意向需求与成交订单
	 */
	public void differentStateOrders() {

	}

	/**
	 * 订单备注不能超过XX字
	 */
	public void description() {

	}

	/**
	 * 订单列表页的字段检查
	 */
	public void checkFiledData() {

	}

	/**
	 * 按姓名搜索订单
	 */
	public void searchByName() {

	}

	/**
	 * 按订单号搜索订单
	 */
	public void searchByOrderNumber() {

	}

	/**
	 * 按订单类型搜索订单
	 */
	public void searchByOrderType() {

	}

	/**
	 * 按订单性质搜索订单
	 */
	public void searchByOrderPro() {

	}

	/**
	 * 按课程名称搜索订单
	 */
	public void searchByCourseName() {

	}

	/**
	 * 按创建时间搜索订单
	 */
	public void searchByCreateTime() {

	}

	/**
	 * 按成交时间搜索订单
	 */
	public void searchByDealTime() {

	}

	/**
	 * 订单的详情页
	 */
	public void detailPage() {

	}

	/**
	 * 修改订单
	 */
	public void modifyOrder() {

	}

	/**
	 * 删除订单
	 */
	public void deleteOrder() {

	}

	/**
	 * 退款操作
	 */
	public void refund() {

	}

	/**
	 * 有一级推荐人的订单
	 */
	public void oneLevelFeferrer() {

	}

	/**
	 * 有二级推荐人的订单
	 */
	public void twoLevelFeferrer() {

	}

	/**
	 * 有三级推荐人的订单
	 */
	public void threeLevelFeferrer() {

	}

}
