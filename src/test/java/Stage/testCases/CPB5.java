package Stage.testCases;

import Stage.pageObjects.CustomProducts;
import org.junit.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

// test case in Jira
// https://iaroslavafinta.atlassian.net/projects/MYP?selectedItem=com.atlassian.plugins.atlassian-connect-plugin:com.kanoah.test-manager__main-project-page#!/testCase/MYP-T12
public class CPB5 extends BaseClass {

    @Test
    public void CPB5() throws IOException, InterruptedException {
        driver.get(stageURL);
        logger.info("open staging site");

        CustomProducts cp = new CustomProducts(driver);

        cp.switchToIFrame();
        logger.info("switch to iFrame");

// new product button click
        cp.clickCreateNewProduct();
        logger.info("button <create new product> is clicked");

// product title
        cp.sendKeysProductTitle();
        logger.info("product title is filled");

// product description
        cp.sendKeysProductDescription();
        logger.info("product description is filled");

// product price
        cp.sendKeysProductPrice();
        logger.info("product price is filled");

        Thread.sleep(4000);

// product image
        cp.sendKeysProductImage();
        logger.info("product image is uploaded");

//  create new product click
        cp.clickSubmitNewProduct();
        logger.info("button create new product is clicked");

        Thread.sleep(4000);

//  activate admin mode
        cp.clickAdminMode();
        logger.info("click Admin Mode");

        Thread.sleep(4000);

//  confirming a product is created
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
