package testcase;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class OrdersManageTest extends Base {
	// ����׼��
	public void dataPre() {
		this.createStucom();// ���û����еĴ���ѧԱ�ķ���
		System.out.println("aaaaaaaaaaa");
		this.createCoursecom();// ���û����еĴ����γ̵ķ���
		System.out.println("bbbbbbbbb");
		this.createRefcom();// ���û����еĴ����Ƽ��˵ķ���
	}

	// �������
	public void dataClear() {
		this.deleteStucom();
		this.deleteCoursecom();
		this.deleteRefcom();
	}
	/**
	 * ������������
	 */
	// @Test
	public void createOrderformal() {
		this.dataPre();
		this.creatOrderCom();
		this.dataClear();
	}
	/**
	 * ��������ʱѧԱ����Ϊ��
	 */
//	@Test
	public void createOrderWithoutStudent() {
		sleep();
		driver.findElement(By.linkText("��������")).click();
		sleep();
		driver.findElement(By.className("greenbtn25_text")).click();// �������������ť
		sleep();
		// ȷ��
		List<WebElement> comfs = driver.findElements(By
				.className("bluebtn30_text"));
		for (WebElement comf : comfs) {
			String con = comf.getText();
			if (con.equals("ȷ��")) {
				comf.click();
			}
			break;
		}
		sleep();
		System.out.println("aaaaaa");
		// ��������Ϊ����ʾ
		String expecterror1 = "��������Ϊ��";
		String actuerror1 = driver.findElement(
						By.xpath(".//*[@id='J_courseOrder']/tbody/tr[1]/td[2]/div/label[2]"))
				.getText();
		System.out.println(actuerror1 + "*****");
		Assert.assertEquals(expecterror1, actuerror1);
		// ȡ��
		List<WebElement> comfs1 = driver.findElements(By
				.className("bluebtn30_text"));
		for (WebElement ref : comfs1) {
			String con = ref.getText();
			if (con.equals("ȡ��")) {
				ref.click();
			}
			break;
		}
		System.out.println("bbbbb");
		sleep();
	}

	/**
	 * ��������ʱ�γ̲���Ϊ��
	 */
	@Test
	public void createOrderWithoutCourse() {
		sleep();
		driver.findElement(By.linkText("��������")).click();
		sleep();
		driver.findElement(By.className("greenbtn25_text")).click();// �������������ť
		sleep();
		// ȷ��
		List<WebElement> comfs = driver.findElements(By
				.className("bluebtn30_text"));
		for (WebElement comf : comfs) {
			String con = comf.getText();
			if (con.equals("ȷ��")) {
				comf.click();
			}
			break;
		}
		sleep();
		// �γ̲���Ϊ����ʾ
		String expecterror2 = "�γ̲���Ϊ��";
		String actuerror2 = driver.findElement(
						By.xpath(".//*[@id='J_courseOrder']/tbody/tr[2]/td[2]/div/label[2]"))
				.getText();
		System.out.println(actuerror2 + "*****");
		Assert.assertEquals(expecterror2, actuerror2);
		// ȡ��
		List<WebElement> comfs1 = driver.findElements(By
				.className("bluebtn30_text"));
		for (WebElement ref : comfs1) {
			String con = ref.getText();
			if (con.equals("ȡ��")) {
				ref.click();
			}
			break;
		}
		sleep();
	}

	/**
	 * ��������ʱ�ۿۼ۲���Ϊ��
	 */
	public void createOrderWithoutPrice() {

	}

	/**
	 * ��������Ϊ���ϵĶ���
	 */
	public void createOnlineOrder() {

	}

	/**
	 * ��������Ϊ����������ɽ�����
	 */
	public void differentStateOrders() {

	}

	/**
	 * ������ע���ܳ���XX��
	 */
	public void description() {

	}

	/**
	 * �����б�ҳ���ֶμ��
	 */
	public void checkFiledData() {

	}

	/**
	 * ��������������
	 */
	public void searchByName() {

	}

	/**
	 * ����������������
	 */
	public void searchByOrderNumber() {

	}

	/**
	 * ������������������
	 */
	public void searchByOrderType() {

	}

	/**
	 * ������������������
	 */
	public void searchByOrderPro() {

	}

	/**
	 * ���γ�������������
	 */
	public void searchByCourseName() {

	}

	/**
	 * ������ʱ����������
	 */
	public void searchByCreateTime() {

	}

	/**
	 * ���ɽ�ʱ����������
	 */
	public void searchByDealTime() {

	}

	/**
	 * ����������ҳ
	 */
	public void detailPage() {

	}

	/**
	 * �޸Ķ���
	 */
	public void modifyOrder() {

	}

	/**
	 * ɾ������
	 */
	public void deleteOrder() {

	}

	/**
	 * �˿����
	 */
	public void refund() {

	}

	/**
	 * ��һ���Ƽ��˵Ķ���
	 */
	public void oneLevelFeferrer() {

	}

	/**
	 * �ж����Ƽ��˵Ķ���
	 */
	public void twoLevelFeferrer() {

	}

	/**
	 * �������Ƽ��˵Ķ���
	 */
	public void threeLevelFeferrer() {

	}

}
