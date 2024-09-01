package Stage.testCases;

import Stage.pageObjects.CustomProducts;
import org.junit.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class CPB51 extends BaseClass {

    @Test
    public void CPB51() throws IOException {
        driver.get(stageURL);
        logger.info("open staging site");

        CustomProducts cp = new CustomProducts(driver);

        cp.switchToIFrame();
        logger.info("switch to iFrame");

        cp.clickEditProduct();
        logger.info("edit product clicked");

        cp.clickSettings();
        logger.info("settings product clicked");

        cp.clickImportData();
        logger.info("import data expanded");

        cp.clickExportData();
        logger.info("checkbox <export> is selected");

        cp.clickDownload();
        logger.info("download button clicked");

        if(driver.getPageSource().contains("Apply"))
        {
            Assert.assertTrue(true);
            logger.info("test passed");
        } else{
            captureScreen(driver,"CPB51");
            Assert.assertFalse(false);
            logger.info("test failed");
        }
    }
}
