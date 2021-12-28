package org.pcge;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BookHotel extends LibGlobal{
	public BookHotel() {
		PageFactory.initElements(driver, this);
	}
	@FindBy(id="first_name")
	private WebElement txtfirstname  ;

	@FindBy(id="last_name")
	private WebElement  txtlastname ;

	@FindBy(id="address")
	private WebElement txtaddress  ;

	@FindBy(id="cc_num")
	private WebElement txtcreditno;

	@FindBy(id="cc_type")
	private WebElement dDnccardtype ;

	@FindBy(id="cc_exp_month")
	private WebElement dDnexperym ;

	

	@FindBy(id="cc_exp_year")
	private WebElement dDnexperyy ;


	@FindBy(id="cc_cvv")
	private WebElement txtccvno ;

	@FindBy(id="book_now")
	private WebElement clickbook ;

	public WebElement getTxtfirstname() {
		return txtfirstname;
	}

	public WebElement getTxtlastname() {
		return txtlastname;
	}

	public WebElement getTxtaddress() {
		return txtaddress;
	}

	public WebElement getTxtcreditno() {
		return txtcreditno;
	}

	public WebElement getdDnccardtype() {
		return dDnccardtype;
	}

	public WebElement getdDnexperym() {
		return dDnexperym;
	}

	public WebElement getdDnexperyy() {
		return dDnexperyy;
	}

	public WebElement getTxtccvno() {
		return txtccvno;
	}

	public WebElement getClickbook() {
		return clickbook;
	} 
	public void verify3(String expValue) {
		WebElement ele = driver.findElement(By.xpath("(//td[@class='login_title'])[2]"));
		String actValue = gettext(ele);
		Assert.assertEquals("Book Hotel msg", expValue, actValue);
			}
	

	public void Bookshotel(String firstName,String lastName,String Address,String CreditCard,String CardType,String ExpiryMnth,String ExpiryYear,String ccv) {
setText(getTxtfirstname(), firstName);
setText(getTxtlastname(), lastName);
setText(getTxtaddress(), Address);
setText(getTxtcreditno(), CreditCard);	
selectByVisibleText(getdDnccardtype(), CardType);
selectByVisibleText(getdDnexperym(), ExpiryMnth);
selectByVisibleText(getdDnexperyy(), ExpiryYear);
setText(getTxtccvno(), ccv);	
click(getClickbook());
	
	}}
