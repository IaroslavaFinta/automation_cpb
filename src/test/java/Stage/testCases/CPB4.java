package Stage.testCases;

// https://buildateam.zendesk.com/hc/en-us/articles/360059761751-Import-and-export-of-the-product-data
// Jira test case
// https://iaroslavafinta.atlassian.net/projects/MYP?selectedItem=com.atlassian.plugins.atlassian-connect-plugin:com.kanoah.test-manager__main-project-page#!/testCase/MYP-T19

import Stage.pageObjects.CustomProducts;
import org.junit.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class CPB4 extends BaseClass {

    @Test
    public void CPB4() throws IOException, InterruptedException {
        driver.get(stageURL);
        logger.info("open staging site");

        CustomProducts cp = new CustomProducts(driver);

        cp.switchToIFrame();
        logger.info("switch to iFrame");

// new product button click
        cp.clickCreateNewProduct();
        logger.info("button <create new product> is clicked");

// import Data From Another Product clicked
        cp.clickImportDataFromAnotherProduct();
        logger.info("checkbox <import Data From Another Product> clicked");

// json file is uploaded
        cp.sendKeysJsonUpload();
        logger.info("json file is uploaded");

//  fill data clicked
        cp.clickFillDataButton();
        logger.info("button <fill data> clicked");

        Thread.sleep(4000);

//  edit product title is done
        cp.sendKeysProductTitleJson();
        logger.info("product title is edited");

        Thread.sleep(4000);

//  create new product click
        cp.clickSubmitNewProduct();
        logger.info("button <create new product> is clicked");

        Thread.sleep(4000);

//  activate admin mode
        cp.clickAdminMode();
        logger.info("click Admin Mode");

        Thread.sleep(4000);

//  product is saved
        cp.clickSaveProduct();
        logger.info("product is saved");

        Thread.sleep(4000);

//  confirming a product is created
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



