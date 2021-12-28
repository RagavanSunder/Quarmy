package org.pcge;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.bouncycastle.jcajce.provider.asymmetric.ec.SignatureSpi.ecCVCDSA;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;
public class LibGlobal {
	public static final int KeyEvent = 0;
	public static final String VK_DOWN = null;
	public static final String VK_UP = null;
	public static WebDriver driver;
	public Object keyEvent;

	public static void getDriver() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

	}

	public static void loadurl(String url) {
		driver.get(url);

	}

	public static void maximize() {
		driver.manage().window().maximize();

	}

	public String currenturl() {
		String currentUrl = driver.getCurrentUrl();
		return currentUrl;

	}

	public String getitle() {
		String title = driver.getTitle();
		return title;
	}

	public static void quit() {
		driver.quit();

	}

	public String getWindowHandle() {
		String windowHandle = driver.getWindowHandle();
		return windowHandle;
	}

	public Set<String> windowHandles() {
		Set<String> windowHandles = driver.getWindowHandles();
		return windowHandles;

	}

	public String gettext(WebElement element) {
		String text = element.getText();
		return text;

	}

	public String getAttributeVal(WebElement element) {

		String attribute = element.getAttribute("value");
		return attribute;

	}

	public WebElement findElementByName(String data) {
		WebElement findElement = driver.findElement(By.id(data));
		return findElement;

	}

	public WebElement findElementById(String data) {
		WebElement findElement = driver.findElement(By.id(data));
		return findElement;

	}

	public WebElement findEelementByXpath(String data) {
		WebElement findElement = driver.findElement(By.xpath(data));
		return findElement;

	}

	public void setText(WebElement element, String data) {
		element.sendKeys(data);

	}
	

	public void click(WebElement element) {
		element.click();

	}

	public void moveToElement(WebElement element) {
		Actions actions = new Actions(driver);
		actions.moveToElement(element).perform();

	}

	public void contextclick(WebElement element) {
		Actions actions = new Actions(driver);
		actions.contextClick(element).perform();
	}

	public void doubleclick(WebElement element) {
		Actions actions = new Actions(driver);
		actions.doubleClick(element).perform();

	}

	public void selectByIndex(WebElement element,int index) {
		Select select = new Select(element);
		select.selectByIndex(index);

	} 
		
	

	public void selectByValue(WebElement element, String data) {
		Select select = new Select(element);
		select.selectByValue(data);
	}

	public void selectByVisibleText(WebElement element, String data) {
		Select select = new Select(element);
		select.selectByVisibleText(data);
	}

	public List<WebElement> SelectGetOptions(WebElement element) {
		Select select = new Select(element);
		List<WebElement> options = select.getOptions();
		return options;
	}

	public WebElement getfirstSelectedOptions(WebElement element) {
		Select select = new Select(element);
		WebElement firstSelectedOption = select.getFirstSelectedOption();

		return firstSelectedOption;

	}

	public List<WebElement> getAllSelectedOption(WebElement element) {
		Select select = new Select(element);
		List<WebElement> allSelectedOptions = select.getAllSelectedOptions();

		return allSelectedOptions;

	}

	public boolean selectMultiple(WebElement element) {
		Select select = new Select(element);
		boolean multiple = select.isMultiple();
		return multiple;

	}

	public void deSelectByIndex(WebElement element, int index) {
		Select select = new Select(element);
		select.deselectByIndex(index);
	}

	public void deSelectByValue(WebElement element, String data) {
		Select select = new Select(element);
		select.deselectByValue(data);

	}

	public void deSelectByVisibleText(WebElement element, String data) {
		Select select = new Select(element);
		select.deselectByVisibleText(data);

	}

	public void deSelectAll(WebElement element) {
		Select select = new Select(element);
		select.deselectAll();

	}

	public void javaScriptExecuteClick() {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click");

	}

	public void javaScriptExecutorInsertValues(WebElement element, String data) {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].setAttribute('value','" + data + "')", element);

	}
	
	public void javaScriptExecutorGetValues(WebElement element, String data) {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("return argument[0].getAttribute('value')", element);

	}
	
	public void wait(int duration) {
		try {
			Thread.sleep(duration);
		}catch(InterruptedException e){
		   e.printStackTrace();	
		}
	}

	public String getData(String location, String name, int rownum, int cellnum) throws IOException {
		String data = null;
		File file = new File(location);
		FileInputStream stream = new FileInputStream(file);
		Workbook workbook = new XSSFWorkbook(stream);
		Sheet sheet = workbook.getSheet(name);
		Row row = sheet.getRow(rownum);
		Cell cell = row.getCell(cellnum);
		int type = cell.getCellType();
		if (type == 1) {
			data = cell.getStringCellValue();

		}
		if (type == 0) {

			if (DateUtil.isCellDateFormatted(cell)) {
				Date date = cell.getDateCellValue();
				SimpleDateFormat dateformat = new SimpleDateFormat("dd-MM-YYYY");
				data = dateformat.format(date);

			} else {

				double d = cell.getNumericCellValue();
				long l = (long) d;
				data = String.valueOf(l);

			}

		}
		return data;

	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}

