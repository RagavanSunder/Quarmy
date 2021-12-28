package org.pcge;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SelectHotel extends  LibGlobal{
		public SelectHotel() {
		PageFactory.initElements(driver, this);
	}
	@FindBy(id="radiobutton_0")
	private WebElement btnRadio;
	@FindBy(id="continue")
	private WebElement btnContinue;
	public WebElement getBtnRadio() {
		
		return btnRadio;
	}
	public WebElement getBtnContinue() {
		return btnContinue;
	}
	public void verify2(String expValu) {
		WebElement ele1 = driver.findElement(By.xpath("//td[@class='login_title']"));
		String actValue = gettext(ele1);
		Assert.assertEquals("Select Hotel msg", expValu, actValue);
			}
	
	public void select() {
		click(getBtnRadio());
		click(getBtnContinue());
	}
	
	//public void click() {
		
		
//	}
		
	//}
}
