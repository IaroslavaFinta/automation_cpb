package Stage.testCases;

import Stage.pageObjects.CustomProducts;
import org.junit.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class CPB52 extends BaseClass{
    @Test
    public void CPB51() throws IOException, InterruptedException {
        driver.get(stageURL);
        logger.info("open staging site");

        CustomProducts cp = new CustomProducts(driver);

        cp.switchToIFrame();
        logger.info("switch to iFrame");

        cp.clickPreviewProduct();
        logger.info("preview product clicked");

        Thread.sleep(3000);

        cp.sendKeysPassword();
        logger.info("password is entered");

        cp.clickEnter();
        logger.info("enter is pressed");

        cp.clickPreviewProduct();
        logger.info("preview product clicked");

        if(driver.getPageSource().contains("Welcome to our store"))
        {
            Assert.assertTrue(true);
            logger.info("test passed");
        } else{
            captureScreen(driver,"CPB52");
            Assert.assertFalse(false);
            logger.info("test failed");
        }
    }
}


