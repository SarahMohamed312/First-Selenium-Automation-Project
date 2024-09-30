package utilities;

public class DataProvider {

    @org.testng.annotations.DataProvider(name = "FillFormData")
    public Object[][] fillForm(){
        return new Object[][]{

                {"Sarah","Egypt","Mansoura","987654321","September","2024"},
                {"@@@@","!!!!","$$$$","%%%%","****","&&&&"},
                {"123456","4567","789","12","1","0"}
        };

        }
    }
