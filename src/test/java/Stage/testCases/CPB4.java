package Stage.testCases;

import Stage.pageObjects.CustomProducts;
import org.junit.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class CPB4 extends BaseClass {

    @Test
    public void CPB4() throws IOException {
        driver.get(stageURL);
        logger.info("open staging site");

        CustomProducts cp = new CustomProducts(driver);

        cp.switchToIFrame();
        logger.info("switch to iFrame");

        cp.clickCreateNewProduct();
        logger.info("button <create new product> is clicked");

        cp.clickImportDataFromAnotherProduct();
        logger.info("checkbox <import Data From Another Product> clicked");

        cp.sendKeysJsonUpload();
        logger.info("json file is uploaded");

        cp.clickFillDataButton();
        logger.info("button <fill data> clicked");

        cp.sendKeysProductTitleJson();
        logger.info("product title is edited");

        cp.clickSubmitNewProduct();
        logger.info("button <create new product> is clicked");

        cp.clickAdminMode();
        logger.info("click Admin Mode");

        cp.clickSaveProduct();
        logger.info("product is saved");

        if(driver.getPageSource().contains("Add New Custom Option"))
        {
            Assert.assertTrue(true);
            logger.info("test passed");
        } else{
            captureScreen(driver,"CPB4");
            Assert.assertFalse(false);
            logger.info("test failed");
        }
    }

}


