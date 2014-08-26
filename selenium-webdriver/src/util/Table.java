package util;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Table {

	/**
	 * @author gongjf
	 */
	private WebDriver driver;
	public Table(WebDriver driver){
		this.driver = driver;
	}
	
	/** ��һ��table�ĵ�Ԫ���еõ��ı�ֵ. ����tableCellAddress�ĸ�ʽΪ
	row.column, ���д�0��ʼ.
	@param by  ���ڵõ�table����
	@param tableCellAddress һ����Ԫ���ַ, ��. "1.4"
	@return ��һ��table�ĵ�Ԫ���еõ��ı�ֵ
	*/
	public String getCellText(By by,String tableCellAddress) {
		//�õ�tableԪ�ض���
		WebElement table = driver.findElement(by);
		//����Ҫ���ҵĵ�Ԫ��λ���ַ������зֽ⣬�õ����Ӧ�С��С�
		int index = tableCellAddress.trim().indexOf('.');
		int row =  Integer.parseInt(tableCellAddress.substring(0, index));
		int cell = Integer.parseInt(tableCellAddress.substring(index+1));
		//�õ�table���������ж��󣬲��õ���Ҫ��ѯ���ж���
		 List<WebElement> rows = table.findElements(By.tagName("tr"));
		 WebElement theRow = rows.get(row);
		 //����getCell�����õ���Ӧ���ж���Ȼ��õ�Ҫ��ѯ���ı���
		 String text = getCell(theRow, cell).getText();
		 return text;
	}
	private WebElement getCell(WebElement Row,int cell){
		 List<WebElement> cells;
		 WebElement target = null;
		 //��������"<th>"��"<td>"���ֱ�ǩ�����Էֿ�����
		 if(Row.findElements(By.tagName("th")).size()>0){
			cells = Row.findElements(By.tagName("th"));
			target = cells.get(cell);
		 }
		 if(Row.findElements(By.tagName("td")).size()>0){
			cells = Row.findElements(By.tagName("td"));
			target = cells.get(cell);
		 }
		return target;
		 
	}
	
	
	public static void main(String[] args) {
		 WebDriver driver;
		 System.setProperty("webdriver.firefox.bin","D:\\Program Files\\Mozilla Firefox\\firefox.exe");  
		 driver = new FirefoxDriver();
		 driver.get("file:///C:/Documents and Settings/Gongjf/����/selenium_test/table.html");
	
		 Table table = new Table(driver);
		 By by = By.id("myTable");
		 String address = "0.2";
	 
		 System.out.println(table.getCellText(by, address));
		
		
	}

}
