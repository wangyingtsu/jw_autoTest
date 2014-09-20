package testcase;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

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
	@Test
	public void createOrderformal() {
		this.dataPre();
		this.creatOrderCom();
		this.dataClear();
	}
	/**
	 * ��������ʱѧԱ����Ϊ��
	 */
    @Test
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
	@Test
	public void createOrderWithoutPrice() {
		sleep();
		driver.findElement(By.linkText("��������")).click();
		sleep();
		driver.findElement(By.className("greenbtn25_text")).click();// �������������ť
		sleep();
		this.selectstudent();
		sleep();
		this.selectCourse();
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
		// �ۿۼ۲���Ϊ��
		String expecterror3 = "�ۿۼ۲���Ϊ��";
		String actuerror3 = driver.findElement(
						By.xpath("html/body/div[4]/div[2]/div/div"))
				.getText();
		System.out.println(actuerror3 + "*****");
		Assert.assertEquals(expecterror3, actuerror3);
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
	
	//ѡ��ѧԱ����
	public void selectstudent(){
		driver.findElement(By.id("order_stuName")).clear();
		driver.findElement(By.id("order_stuName")).click();//ѡ��ѧԱ
		sleep();
		//���õ������еĵ�һ������
		driver.findElement(By.xpath(".//*[@id='choice_clc_list']/tbody/tr[1]/td[1]/label")).click();
		//��������е�ȷ�ϰ�ť
		sleep();
    	driver.findElement(By.xpath(".//*[@id='choice_clc']/table/tbody/tr[2]/td[2]/div[3]/button[1]")).click();
	}
	//ѡ��γ�
	public void selectCourse(){
		sleep();sleep();
		driver.findElement(By.id("order_course")).click();
		sleep();sleep();
		//���õ������еĵ�һ������
		driver.findElement(By.xpath(".//*[@id='choice_clc_list']/tbody/tr[1]/td[1]/label")).click();
		//���ȷ�ϰ�ť
		driver.findElement(By.xpath(".//*[@id='choice_clc']/table/tbody/tr[2]/td[2]/div[3]/button[1]")).click();
		sleep();
	}

	/**
	 * ��������Ϊ���ϵĶ���
	 * ��������Ϊ����������ɽ�����
	 */
    @Test
	public void createOnlineOrder() {
		sleep();
		driver.findElement(By.linkText("��������")).click();
		sleep();
		driver.findElement(By.className("greenbtn25_text")).click();// �������������ť
		sleep();
		this.selectstudent();
		sleep();
		this.selectCourse();
		sleep();
		driver.findElement(By.id("order_coursePrice")).clear();
		driver.findElement(By.id("order_coursePrice")).sendKeys("0");
		Select select1 = new Select(driver.findElement(By.id("order_type")));
		select1.selectByValue("up");//����
		sleep();
		Select select2 = new Select(driver.findElement(By.id("order_character")));
		select2.selectByValue("ordersuccess");//�ɽ�����
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
		}

	/**
	 * ������ע���ܳ���100��
	 */
	@Test
	public void description() {
		String  des="�𿨵绰�ѿռ���շѻ��ɶ�ĺͷѿռ�͵ط��Ƽ����͵ط��μ�����ɷݿռ䰴ʱ���ܿ�ͺܴ󷽽𿨵绰�ѿռ���շѻ��ɶ�ĺͷѿռ�͵ط��Ƽ����͵ط��μ�����ɷݿռ䰴ʱ���ܿ�ͺܴ󷽽𿨵绰�ѿռ���շѻ��ɶ�ĺͷѿռ�͵ط��Ƽ����͵ط��μ�";
		
		sleep();
		driver.findElement(By.linkText("��������")).click();
		sleep();
		driver.findElement(By.className("greenbtn25_text")).click();// �������������ť
		sleep();
		this.selectstudent();
		sleep();
		this.selectCourse();
		sleep();
		driver.findElement(By.id("order_coursePrice")).clear();
		driver.findElement(By.id("order_coursePrice")).sendKeys("0");
		driver.findElement(By.id("J_tinyContainer")).sendKeys(des);
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
		String message=driver.findElement(By.xpath("html/body/div[4]/div[2]/div/div")).getText();
		
		System.out.println(message+"^^^^^^^^^");
		Assert.assertEquals("��ע���ܳ���100���ַ�", message);
		sleep();
		List<WebElement> comfs2 = driver.findElements(By
				.className("bluebtn30_text"));
		for (WebElement comf : comfs2) {
			String con = comf.getText();
			if (con.equals("ȡ��")) {
				comf.click();
			}
			break;
		}
		sleep();

	}

	/**
	 * ����������������
	 */
	@Test
	public void searchByOrderNumber() {
		sleep();
		driver.findElement(By.linkText("��������")).click();
		sleep();
		driver.findElement(By.className("greenbtn25_text")).click();// �������������ť
		sleep();
		this.selectstudent();
		sleep();
		this.selectCourse();
		sleep();
		driver.findElement(By.id("order_coursePrice")).clear();
		driver.findElement(By.id("order_coursePrice")).sendKeys("0");
		Select select1 = new Select(driver.findElement(By.id("order_type")));
		select1.selectByValue("up");//����
		sleep();
		Select select2 = new Select(driver.findElement(By.id("order_character")));
		select2.selectByValue("ordersuccess");//�ɽ�����
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
		//������鰴ť
		driver.findElement(By.xpath(".//*[@id='J_pmDataTables']/tbody/tr[1]/td[9]/div/a[1]")).click();
		//��ȡ������
		String orderNumber=driver.findElement(By.xpath("html/body/div[4]/div[2]/div/div[1]/div")).getText();
		System.out.println(orderNumber+"*****");
		sleep();
		driver.findElement(By.linkText("��������")).click();
		Select select3 = new Select(driver.findElement(By.id("search_type")));
		select3.selectByValue("orderNum");//������
		//�����������뵽�ı�����
		driver.findElement(By.id("search_value")).clear();
		driver.findElement(By.id("search_value")).sendKeys(orderNumber);
		//�����ѯ��ť
		driver.findElement(By.cssSelector("span.bluebtn25_text")).click();
		sleep();
		String count=driver.findElement(By.id("J_totalCount")).getText();
		System.out.println(count+"^^^^^^");
		Assert.assertEquals("1", count);
		
	}



	/**
	 * �޸Ķ���
	 */
	@Test
	public void modifyOrder() {
		sleep();
		driver.findElement(By.linkText("��������")).click();
		sleep();
		driver.findElement(By.className("greenbtn25_text")).click();// �������������ť
		sleep();
		this.selectstudent();
		sleep();
		this.selectCourse();
		sleep();
		driver.findElement(By.id("order_coursePrice")).clear();
		driver.findElement(By.id("order_coursePrice")).sendKeys("0");
		Select select1 = new Select(driver.findElement(By.id("order_type")));
		select1.selectByValue("up");//����
		sleep();
		Select select2 = new Select(driver.findElement(By.id("order_character")));
		select2.selectByValue("ordersuccess");//�ɽ�����
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
		//�޸İ�ť
		driver.findElement(By.xpath(".//*[@id='J_pmDataTables']/tbody/tr[1]/td[9]/div/a[2]")).click();
		sleep();
		driver.findElement(By.id("order_original")).clear();
		driver.findElement(By.id("order_original")).sendKeys("123");
		driver.findElement(By.id("order_coursePrice")).clear();
		driver.findElement(By.id("order_coursePrice")).sendKeys("100");
		driver.findElement(By.xpath(".//*[@id='J_sumitform']/span")).click();

	}

	/**
	 * ɾ������
	 */
	@Test
	public void deleteOrder() {
		driver.findElement(By.linkText("��������")).click();
		sleep();
        driver.findElement(By.xpath(".//*[@id='J_pmDataTables']/tbody/tr[1]/td[9]/div/a[3]")).click();//���ɾ����ť
       
//        Alert alert = driver.switchTo().alert();
//        alert.accept();
        //ȷ�ϰ�ť
        driver.findElement(By.xpath("html/body/div[8]/table/tbody/tr[2]/td[2]/div[3]/button[1]")).click();
    	sleep();
	}

	/**
	 * �˿����
	 */
	@Test
	public void refund() {
		sleep();
		driver.findElement(By.linkText("��������")).click();
		sleep();
		driver.findElement(By.className("greenbtn25_text")).click();// �������������ť
		sleep();
		this.selectstudent();
		sleep();
		this.selectCourse();
		sleep();
		driver.findElement(By.id("order_coursePrice")).clear();
		driver.findElement(By.id("order_coursePrice")).sendKeys("0");
		Select select1 = new Select(driver.findElement(By.id("order_type")));
		select1.selectByValue("up");//����
		sleep();
		Select select2 = new Select(driver.findElement(By.id("order_character")));
		select2.selectByValue("ordersuccess");//�ɽ�����
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
		
		driver.findElement(By.linkText("��������")).click();
		sleep();
		//����˿ť
		driver.findElement(By.xpath(".//*[@id='J_pmDataTables']/tbody/tr[1]/td[9]/div/a[4]")).click();
		//ȷ�ϰ�ť
		driver.findElement(By.xpath("html/body/div[8]/table/tbody/tr[2]/td[2]/div[3]/button[1]")).click();
	}
	
	
	

}
