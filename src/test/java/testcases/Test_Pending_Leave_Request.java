package testcases;

import commonfunctions.CommonFunctions;
import jdk.internal.instrumentation.Logger;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageobjects.Dashboard_Page_Objects;
import pageobjects.Login_Page_Objects;

public class Test_Pending_Leave_Request extends CommonFunctions {

   String actualMessage = null;
     Logger logger = Logger.getLogger(Test_Pending_Leave_Request.class);
    public void login() {

        logger.info("Logging into the application");
        PageFactory.initElements(driver, Login_Page_Objects.class);
        Login_Page_Objects.userName.sendKeys(properties.getProperty("username"));
        Login_Page_Objects.password.sendKeys(properties.getProperty("password"));
        Login_Page_Objects.submitButton.click();
    }
        public void getPendingLeaveRequests() {
            PageFactory.initElements(driver, Dashboard_Page_Objects.class);

             actualMessage = Dashboard_Page_Objects.pendingLeaveRequests.getText();
        }

        @Test
        public void verifyPendingLeaveRequests() {
            login();
            logger.info("Getting the Pending Leave Request Details");
            getPendingLeaveRequests();
            logger.info("Verification");
            Assert.assertEquals(actualMessage, "No Records are Available");
           logger.info("End of Test_Pending_Leave_Request test case");
        }

    }


