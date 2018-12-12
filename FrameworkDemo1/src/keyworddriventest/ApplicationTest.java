package keyworddriventest;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;

import utility.Readmyexcel;

public class ApplicationTest {
	
	@Test
	public void LoginToApplication() throws Exception {
		
		String[][] data= Readmyexcel.getdata("C:\\Users\\Ragha\\Desktop\\TestExcel.xlsx","Sheet2");
		
		for(int i=1;i<10;i++) {
			
			switch(data[i][3])
			{
			
			case "openBrowser":
				GenericMethods.openBrowser();
				break;
				
			case "maximizeWindow":
				GenericMethods.maximizeWindow();
				break;
				
			case "implementWait":
				GenericMethods.implementWait();
				break;
				
			case "NavigateTo":
				GenericMethods.NavigateTo(data[i][6]);
				break;
				
			case "enterinvalidUsername":
				GenericMethods.invalidUsername(data[i][4], data[i][5], data[i][6]);
				break;
				
			case "enterinvalidPassword":
			GenericMethods.invalidPassword(data[i][4], data[i][5], data[i][6]);
			break;
			
			case "clickSubmit":
				GenericMethods.clickSubmit(data[i][4], data[i][5]);
				break;
				
			case "verifyMessage":
				GenericMethods.verifyMessage(data[i][4], data[i][5],data[i][6]);
				break;
			case "closeBrowser":
				GenericMethods.closeBrowser();
				
						
			
			
			}
		}
		
	}

}
