package org.pcge;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebElement;

public class SearchProcess extends LibGlobal {
	@BeforeClass
	public static void beforeClass() {
getDriver();
maximize();
loadurl("https://adactinhotelapp.com/index.php");
	}
	@AfterClass
	public static void afterClass() {
		quit();
	}
@Test
public void Search() throws InterruptedException   {
	LoginPage login=new LoginPage();
	login.login("Ragavanr", "rsunder");
	
	
	SearchHotel srchhtl=new SearchHotel();
	srchhtl.verify("Hello Ragavanr!");
	
	srchhtl.searchhotels("Paris", "Hotel Sunshine", "Super Deluxe", "1 - One",/* "29/12/2021", "02/01/2022",*/ "1 - One", "0 - None");
	SelectHotel select= new SelectHotel();
	select.verify2("Select Hotel");
	select.select();
	BookHotel book=new BookHotel();
	book.verify3("Book A Hotel");
	book.Bookshotel("Ragavan","Sunder","bcbcub","1234567890123456", "VISA", "July", "2022", "1234");
	Thread.sleep(10000);
	
	BookingConfrm cnfrm=new BookingConfrm();
	cnfrm.verify4("Booking Confirmation");
	cnfrm.getBtnSearch();
	
	CancelBooking cancel=new CancelBooking();
	cancel.cancel();
	

}
}
