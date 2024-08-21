package Stage.testCases;

import Stage.pageObjects.CustomProducts;
import org.junit.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class CPB6 extends BaseClass{

    @Test
    public void CPB6() throws IOException, InterruptedException {
        driver.get(stageURL);
        logger.info("open staging site");

        CustomProducts cp = new CustomProducts(driver);

        cp.switchToIFrame();
        logger.info("switch to iFrame");

//  click "clone product"
        cp.clickCloneProduct();
        logger.info("product is cloned");

        Thread.sleep(4000);

//  click a delete a cloned copy
        cp.clickDeleteProduct();
        logger.info("delete a cloned product");

// confirm to delete a copy
        cp.clickConfirmDelete();
        logger.info("delete a clone is confirmed");

//  confirming a cloned product was deleted
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
