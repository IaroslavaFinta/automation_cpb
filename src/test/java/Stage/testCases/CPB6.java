package Stage.testCases;

import Stage.pageObjects.CustomProducts;
import org.junit.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class CPB6 extends BaseClass{

    @Test
    public void CPB6() throws IOException {
        driver.get(stageURL);
        logger.info("open staging site");

        CustomProducts cp = new CustomProducts(driver);

        cp.switchToIFrame();
        logger.info("switch to iFrame");

        cp.clickCloneProduct();
        logger.info("product is cloned");

        cp.clickDeleteProduct();
        logger.info("delete a cloned product");

        cp.clickConfirmDelete();
        logger.info("delete a clone is confirmed");

        if(driver.getPageSource().contains("Candle-Copy"))
        {
            Assert.assertTrue(true);
            logger.info("test failed");
        } else{
            captureScreen(driver,"CPB6");
            Assert.assertFalse(false);
            logger.info("test passed");
        }
    }
}

