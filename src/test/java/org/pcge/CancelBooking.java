package org.pcge;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CancelBooking extends LibGlobal {
	public CancelBooking() {
		PageFactory.initElements(driver, this);
	}
	/*@FindBy(id="order_no")
	private WebElement getOrder;
	
	public WebElement getGetOrder() {
		return getOrder;
	}
	@FindBy(id="my_itinerary")
	private WebElement clckItenary;
	@FindBy(id="order_id_text")
	private WebElement insertOrder;
	public WebElement getInsertOrder() {
		return insertOrder;
	}
	@FindBy(id="btn_id_518459")
	private WebElement cancelId;
	@FindBy(id="search_hotel_id")
	private WebElement searchGo;
	public WebElement getCancelId() {
		return cancelId;
	}
	public WebElement getSearchGo() {
		return searchGo;
	}
	public WebElement getClckItenary() {
		return clckItenary;
	}
	public WebElement getClckOrderId() {
		return cancelId;
	}
	public void login() {
		gettext(getGetOrder());
		click(clckItenary);
		
       setText(getInsertOrder(), "data");
       click(getSearchGo());
      // click(cancelId);
      
	}

}*/
	@FindBy(id="order_no")
	private WebElement orderId;
	
	@FindBy(xpath= "//a[text()='Booked Itinerary']")
	private WebElement bookItenery;
	
	@FindBy(id="order_id_text")
	private WebElement orderText;
	
	@FindBy(id="search_hotel_id")
    private WebElement clkGo;
	
	@FindBy(xpath="(//input[@type='button'])[1]")
	private WebElement cancelTicket;

	public WebElement getOrderId() {
		return orderId;
	}

	public WebElement getBookItenery() {
		return bookItenery;
	}

	public WebElement getOrderText() {
		return orderText;
	}

	public WebElement getClkGo() {
		return clkGo;
	}

	public WebElement getCancelTicket() {
		return cancelTicket;
	}
	
	public void cancel() {
		WebElement elee = driver.findElement(By.id("order_no"));
String val = getAttributeVal(elee);
click(getBookItenery());
 setText(getOrderText(), val);
 click(getClkGo());
 //findEelementByXpath("")
 
click(getCancelTicket());
Alert al=driver.switchTo().alert();
al.accept();
 
	
	
	}
	
	
	
	
	
}