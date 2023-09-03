
package Tests;

import Pages.HomePage;
import Pages.LoginPage;
import Pages.TimeMaterialPage;
import Utilities.CommonDriver;
import jdk.jfr.Description;
import net.bytebuddy.build.Plugin;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TimeMaterialTest extends CommonDriver
    {
        LoginPage loginPageObj = new LoginPage();
        HomePage homePageObj = new HomePage();
        TimeMaterialPage timeMaterialPageObj = new TimeMaterialPage();
        @BeforeTest
        public void SetUpTM()
        {
            driver = new ChromeDriver();
           
            loginPageObj.LoginFunction(driver);
            homePageObj.GoToTimeMaterialPage(driver);
        }

        @Test(priority =0,description="This test is to check whether user able to delete a Time Materials Record")
        public void CreateTM_Test()
        {
            timeMaterialPageObj.CreateTimeRecord(driver);
            timeMaterialPageObj.CreateRecordActualDataAssertion(driver);

        }
        @Test(priority =1,description="This test is to check whether user able to edit an existing Time Materials Record")
        public void EditTM_Test()
        {
            timeMaterialPageObj.EditRecord(driver);
            timeMaterialPageObj.EditedTMCodeAssertion(driver);
            timeMaterialPageObj.EditedTMDescreptionAssertion(driver);
        }

        @Test(priority =2,description="This test is to check whether user able to delete a Time Materials Record")
        public void DeleteTM_Test() throws InterruptedException {
            timeMaterialPageObj.DeleteRecord(driver);
            timeMaterialPageObj.DeleteTMRecordAssertion(driver);
        }
        @AfterTest
        public void CloseTestRun()
        {
           driver.quit();

        }
      

    }

