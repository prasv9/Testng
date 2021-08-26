package Pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Browser.BaseClass;

public class BookingConfirmation extends BaseClass{
	
	String E = "E:\\Prasanna\\Task\\Book1.xlsx";
	String S = "Sheet1";
	
	@Test(dataProvider="sampledata")
	private void test1(String username, String password, int location, int hotels, 
			int room_type, int room_nos, String datepick_in, String datepick_out, 
			int adult_room, int child_room, String firstname, String lastname, 
			String address, String cc_num, int cc_type, int cc_exp_month, 
			int cc_exp_year, String cc_cvv) throws IOException, Exception {
		
		launchUrl("https://adactinhotelapp.com/");
		
		Page1 p1 = new Page1();
		enterText(p1.getUsername(), username);
		enterText(p1.getPassword(), password);
		buttonClick(p1.getLogin());
		
		Page2 p2 = new Page2();
		selectionByIndex(p2.getLocation(), location);
		selectionByIndex(p2.getHotels(), hotels);
		selectionByIndex(p2.getRoom_type(), room_type);
		selectionByIndex(p2.getRoom_nos(), room_nos);
		p2.getDatepick_in().clear();
		enterText(p2.getDatepick_in(), datepick_in);
	     p2.getDatepick_out().clear();
	     enterText(p2.getDatepick_out(), datepick_out);
	     selectionByIndex(p2.getAdult_room(), adult_room);
	     selectionByIndex(p2.getChild_room(), child_room);
	     buttonClick(p2.getSubmit());
	     Page3 p3 = new Page3();
	     buttonClick(p3.getRadiobutton_0());
	     buttonClick(p3.getSubmit());
	     Page4 p4 = new Page4();
	     enterText(p4.getFirstname(), firstname);
	     enterText(p4.getLastname(), lastname);
	     enterText(p4.getAddress(), address);
	     enterText(p4.getCc_num(), cc_num);
	     selectionByIndex(p4.getCc_type(), cc_type);
	     selectionByIndex(p4.getCc_exp_month(), cc_exp_month);
	   selectionByIndex(p4.getCc_exp_year(), cc_exp_year);
	   enterText(p4.getCc_cvv(), cc_cvv);
	     buttonClick(p4.getBook_now());
	     Thread.sleep(5000);
	     Page5 p5 = new Page5();
	    WebElement orderno = p5.getOrderno();
	    String attribute = orderno.getAttribute("value");
	     System.out.println("Order No  "+attribute);
	     
	    excelWrite(E, S, 0, 18, attribute);
	    	}
	
	@DataProvider (name ="sampledata")
	private Object[] [] data() throws IOException {
		return new Object[][] {
			
			{	excelRead(E, S, 0, 0),excelRead(E, S, 0, 1),
				Integer.parseInt(excelRead(E,S,0,2)),Integer.parseInt(excelRead(E,S,0,3)),
				Integer.parseInt(excelRead(E,S,0,4)),Integer.parseInt(excelRead(E,S,0,5)),
				excelRead(E,S,0,6),excelRead(E,S,0,7),Integer.parseInt(excelRead(E,S,0,8)),
				Integer.parseInt(excelRead(E,S,0,9)),excelRead(E, S, 0, 10),excelRead(E, S, 0, 11),
				excelRead(E, S, 0, 12), excelRead(E, S, 0, 13), Integer.parseInt(excelRead(E,S,0,14)),
				Integer.parseInt(excelRead(E,S,0,15)), 
				Integer.parseInt(excelRead(E,S,0,16)), excelRead(E, S, 0, 17)}, 
			
		};

	}

}
