
package Tests;

import Pages.EmployeesPage;
import Pages.HomePage;
import Pages.LoginPage;
import Utilities.CommonDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class EmployeesTests extends CommonDriver
    {
        LoginPage loginPageObj = new LoginPage();
        HomePage homePageObj = new HomePage();
        EmployeesPage employeesPageObj = new EmployeesPage();


        @BeforeTest
        public void EmployeesSetUp()
        {
            driver = new ChromeDriver();
            loginPageObj.LoginFunction(driver);
            homePageObj.GoToEmployeesPage(driver);
        }

        @Test(priority = 0,description = "This test is to check if user able to create a Employee Records")
        public void CreateEmployees_Test() throws InterruptedException {
            
            employeesPageObj.CreateEmployees(driver);
            employeesPageObj.CreateEmployeeValidation(driver);
  
        }

        @Test(priority = 1,description = "This test is to check if user able to create a Employee Records")
        public void EditEmployees_Test()
        {

            employeesPageObj.EditEmployees(driver);
            employeesPageObj.EditEmployeeValidataion(driver);
        }

        @Test(priority =2,description = "This test is to check if user able to create a Employee Records")
        public void DeleteEmployees_Test() throws InterruptedException {
            employeesPageObj.DeleteEmployees(driver);
            employeesPageObj.DeleteEmployeeValidation(driver);

        }
       @AfterTest
        public void CloseTestRun()
        {
            driver.quit();
        }
    }

