package Stage.testCases;

import Stage.pageObjects.AdminMode;
import Stage.pageObjects.CustomProducts;
import org.junit.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class CPB15 extends BaseClass{

    @Test
    public void CPB15() throws IOException {
        driver.get(stageURL);
        logger.info("open staging site");

        CustomProducts cp = new CustomProducts(driver);
        AdminMode am = new AdminMode(driver);

        cp.switchToIFrame();
        logger.info("switch to iFrame");

        cp.clickEditButton();
        logger.info("click Edit");

        cp.clickAdminMode();
        logger.info("click Admin Mode");

        am.clickOnAddNewCustomOption();
        logger.info("click on New Custom Option");

        if(driver.getPageSource().contains("Edit Custom Option"))
        {
            Assert.assertTrue(true);
            logger.info("test passed");
        }else{
            captureScreen(driver,"CPB15");
            Assert.assertFalse(false);
            logger.info("test failed");
        }
    }
}








