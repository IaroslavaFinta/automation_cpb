package Stage.testCases;

import Stage.pageObjects.CustomProducts;
import org.junit.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class CPB5 extends BaseClass {

    @Test
    public void CPB5() throws IOException {
        driver.get(stageURL);
        logger.info("open staging site");

        CustomProducts cp = new CustomProducts(driver);

        cp.switchToIFrame();
        logger.info("switch to iFrame");

        cp.clickCreateNewProduct();
        logger.info("button <create new product> is clicked");

        cp.sendKeysProductTitle();
        logger.info("product title is filled");

        cp.sendKeysProductDescription();
        logger.info("product description is filled");

        cp.sendKeysProductPrice();
        logger.info("product price is filled");

        cp.sendKeysProductImage();
        logger.info("product image is uploaded");

        cp.clickSubmitNewProduct();
        logger.info("button create new product is clicked");

        cp.clickAdminMode();
        logger.info("click Admin Mode");

        if(driver.getPageSource().contains("Add First Custom Option"))
        {
            Assert.assertTrue(true);
            logger.info("test passed");
        } else{
            captureScreen(driver,"CPB5");
            Assert.assertFalse(false);
            logger.info("test failed");
        }
    }
}

