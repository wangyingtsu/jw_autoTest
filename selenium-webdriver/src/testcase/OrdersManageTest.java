package testcase;

import org.junit.Test;

public class OrdersManageTest extends Base{
	//����׼��
	public  void dataPre(){
		this.createStucom();//���û����еĴ���ѧԱ�ķ���
		this.createCoursecom();//���û����еĴ����γ̵ķ���
		this.createRefcom();//���û����еĴ����Ƽ��˵ķ���
	}
	//�������
	public  void dataClear(){
		this.deleteStucom();
		this.deleteCoursecom();
		this.deleteRefcom();
	}
	
	/**
	 *������������ 
	 */
	@Test
	public void createOrderformal(){
		this.dataPre();
		
		this.dataClear();
		
	}
	
	/**
	 * ����û���Ƽ��˵Ķ���
	 */
	public void createOrderWithoutFeferrer(){
		
	}
	/**
	 * ��������ʱѧԱ����Ϊ��
	 */
	public void createOrderWithoutStudent(){
		
	}
	
	/**
	 * ��������ʱ�γ̲���Ϊ��
	 */
	public void createOrderWithoutCourse(){
		
	}
	/**
	 * ��������ʱ�ۿۼ۲���Ϊ��
	 */
	public void createOrderWithoutPrice(){
		
	}
	
	/**
	 * ��������Ϊ���ϵĶ���
	 */
	public void createOnlineOrder(){
		
	}
	
	/**
	 * ��������Ϊ����������ɽ�����
	 */
	public void differentStateOrders(){
		
	}
	
	/**
	 * ������ע���ܳ���XX��
	 */
	public  void description(){
		
	}
	
	
	/**
	 * �����б�ҳ���ֶμ��
	 */
	public void checkFiledData(){
		
	}
	
	/**
	 * ��������������
	 */
	public void searchByName(){
		
	}
	
	/**
	 * ����������������
	 */
	public void searchByOrderNumber(){
		
	}
	
	/**
	 * ������������������
	 */
	public void searchByOrderType(){
		
	}
	
	/**
	 * ������������������
	 */
	public void searchByOrderPro(){
		
	}
	
	/**
	 * ���γ�������������
	 */
	public void searchByCourseName(){
		
	}
	
	/**
	 * ������ʱ����������
	 */
	public void searchByCreateTime(){
		
	}
	/**
	 * ���ɽ�ʱ����������
	 */
	public void searchByDealTime(){
		
	}
	/**
	 * ����������ҳ
	 */
	public void  detailPage(){
		
	}
	
	/**
	 * �޸Ķ���
	 */
	public void modifyOrder(){
		
	}
	
	/**
	 * ɾ������
	 */
	public void deleteOrder(){
		
	}
	
	/**
	 * �˿����
	 */
	public void refund(){
		
	}
	
	
	/**
	 * ��һ���Ƽ��˵Ķ���
	 */
	public void oneLevelFeferrer(){
		
	}
	
	/**
	 * �ж����Ƽ��˵Ķ���
	 */
	public void twoLevelFeferrer(){
		
	}
	
	/**
	 * �������Ƽ��˵Ķ���
	 */
	public void threeLevelFeferrer(){
		
	}
	
}
