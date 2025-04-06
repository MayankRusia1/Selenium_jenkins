package Utilities;

import org.testng.annotations.DataProvider;

public class Testdata_login 
{
	@DataProvider(name = "testdata_loginFunctionality")
	public Object[][] getdata()
	{
		Object[][] data = {
							{"Aman Gupta","amanjj@yahoo.com"},
							{"divyansh sharma","ThisiSSecuredPassword35"}
						  };
		return data;
	}
}
