package org.pcge;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BookingConfrm extends LibGlobal{
	public BookingConfrm() {
		PageFactory.initElements(driver, this);
	}
	@FindBy(id="order_no")
	private WebElement txtOrderid;
	
	
	public WebElement getTxtOrderid() {
		return txtOrderid;
	}
	@FindBy(id="my_itinerary")
	private WebElement BtnSearch;

	public WebElement getBtnSearch() {
		return BtnSearch;
	}
	public void verify4(String expValue) {
		WebElement ele = driver.findElement(By.xpath("//td[text()='Booking Confirmation ']"));
		String actValue = ele.getText();
		Assert.assertEquals("Book Hotel msg", expValue, actValue);
			}
	public void confirm() {
	//	getAttribute(getTxtOrderid(), "value");
	 click(getBtnSearch());
	}

}
