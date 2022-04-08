package com.wmk.testCases;

import com.wmk.pageObjects.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class TC_LoginTest_001 extends BaseClass {
    @Test
    public void loginTest() throws InterruptedException, IOException {
        driver.get(baseURL);
        LoginPage lp = new LoginPage(driver);
        lp.setUserName(username);
        logger.info("User provided"); //logger msg

        lp.setPassword(password);
        logger.info("Password provided");//logger msg

        lp.clickLogin();
        logger.info("Login in Clicked");//logger msg

        Thread.sleep(5000);

        if (driver.getTitle().equals("Dashboard / nopCommerce administration"))
        {
            lp.clickLogout();
            Assert.assertTrue(true);
            logger.info("Login Passed");//logger msg
        } else {
            captureScreen(driver,"loginTest");
            Assert.assertTrue(false);
            logger.info("Login Failed");//logger msg
        }

    }
}
