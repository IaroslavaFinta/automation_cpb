package Stage.pageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CustomProducts {

    WebDriver driver;
    WebDriverWait wait;
    public CustomProducts(WebDriver driver) {
        //`driver` you pass when you create an instance of `CustomProducts` is saved and used later for methods like `switchToIFrame()`.
        this.driver = driver;
        this.wait = new WebDriverWait(driver,45);
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "cpb")
    @CacheLookup
    WebElement iFrame;

    @FindBy(xpath = "//*[@id=\"product-builder\"]/div/div/div/div[2]/div/div/ul/li[1]/div/div[2]/div[2]")
    @CacheLookup
    WebElement editButton;

    @FindBy(xpath = "//*[@id=\"product-builder\"]/div[1]/div/div/div[1]/div[2]/button[1]")
    @CacheLookup
    WebElement adminMode;

// create new product - a standart way

    @FindBy(xpath = "/html/body/div[2]/div/div/div/div[2]/h2/div/button/span")
    @CacheLookup
    WebElement createNewProduct;

    @FindBy(xpath = "/html/body/div[2]/div/div/div/div/div/div/div/div[2]/div[2]/div[1]/div/div[1]/div[2]/input")
    @CacheLookup
    WebElement productTitle;

    @FindBy(xpath = "/html/body/div[2]/div/div/div/div/div/div/div/div[2]/div[2]/div[2]/div/div[1]/div[2]/textarea")
    @CacheLookup
    WebElement productDescription;

    @FindBy(xpath = "/html/body/div[2]/div/div/div/div/div/div/div/div[2]/div[2]/div[3]/div/div[1]/div[2]/input")
    @CacheLookup
    WebElement productPrice;

    // copy XPath; accepts jpeg, png, gif
    @FindBy(xpath = "//*[@id=\"product-builder\"]/div/div/div/div/div/div/div/div[2]/div[3]/div/input")
    @CacheLookup
    WebElement productImage;

    @FindBy(xpath = "/html/body/div[2]/div/div/div/div/div/div/div/div[3]/div/div[1]/button")
    @CacheLookup
    WebElement submitNewProduct;

//  create new product - upload json file

    @FindBy(xpath = "//*[@id=\"product-builder\"]/div/div/div/div/div/div/div/div[2]/div[1]/label/span[1]/div/div[1]")
    @CacheLookup
    WebElement clickImportDataFromAnotherProduct;

    @FindBy(xpath = "//*[@id=\"product-builder\"]/div/div/div/div/div/div/div/div[2]/div[1]/div/div/div[2]/div[2]/div[2]/div/div/input")
    @CacheLookup
    WebElement jsonUpload;

    @FindBy(xpath = "/html/body/div[2]/div/div/div/div/div/div/div/div[2]/div[1]/div/div/div[2]/div[2]/div[4]/button/span/span")
    @CacheLookup
    WebElement fillDataButton;

    @FindBy(xpath = "//*[@id=\"product-builder\"]/div[1]/div/div/div[1]/div[2]/button[3]")
    @CacheLookup
    WebElement saveProductButton;

// clone a product

    @FindBy(xpath = "/html/body/div[2]/div/div/div/div[2]/div/div/ul/li[3]/div/div[2]/div[3]/div")
    @CacheLookup
    WebElement cloneProduct;

    @FindBy(xpath = "/html/body/div[2]/div/div/div/div[2]/div/div/ul/li[4]/div/div[2]/div[4]/div")
    @CacheLookup
    WebElement deleteProduct;

    @FindBy(xpath = "/html/body/div[4]/div/div[6]/button[1]")
    @CacheLookup
    WebElement confirmDeleteProduct;

//  export json file

    @FindBy(xpath = "//*[@id=\"product-builder\"]/div/div/div/div[2]/div/div/ul/li[1]/div/div[2]/div[2]")
    @CacheLookup
    WebElement editProduct;

    @FindBy(xpath = "/html/body/div[2]/div[1]/div/div/div[1]/div[1]/button[2]")
    @CacheLookup
    WebElement settingsButton;

    @FindBy(xpath = "//*[@id=\"Panel-0\"]/div/div/div[7]/div[1]/div/div[1]")
    @CacheLookup
    WebElement clickImportData;

    @FindBy(xpath = "/html/body/div[3]/div[4]/div/div/div/div[2]/div/div/div/div[2]/div/div/div[7]/div[1]/div/div[2]/div[1]/div[2]/label/span[1]/div")
    @CacheLookup
    WebElement selectExportCheckbox;

    @FindBy(xpath = "/html/body/div[3]/div[4]/div/div/div/div[2]/div/div/div/div[2]/div/div/div[7]/div[1]/div/div[2]/div[3]/button")
    @CacheLookup
    WebElement clickDownloadJson;

    @FindBy(xpath = "//*[@id=\"product-builder\"]/div/div/div/div[2]/div/div/ul/li[3]/div/div[2]/div[1]/a")
    @CacheLookup
    WebElement previewProduct;

    @FindBy(xpath = "//*[@id=\"password\"]")
    @CacheLookup
    WebElement passwordStore;

    @FindBy(xpath = "/html/body/div/div[2]/div[2]/form/button")
    @CacheLookup
    WebElement clickEnterButton;

    public void switchToIFrame() {
        driver.switchTo().frame(iFrame);
    }

    public void clickEditButton() {
        wait.until(ExpectedConditions.visibilityOf(editButton));
        editButton.click();
    }

    public void clickAdminMode() {
        wait.until(ExpectedConditions.elementToBeClickable(adminMode));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", adminMode);
    }

// create new product - a standart way

    public void clickCreateNewProduct(){
        wait.until(ExpectedConditions.elementToBeClickable(createNewProduct));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", createNewProduct);
    }

    public void sendKeysProductTitle(){
        productTitle.sendKeys("Candle_Finta");
    }

    public void sendKeysProductDescription(){
        productDescription.sendKeys("Nice candle");
    }

    public void sendKeysProductPrice(){
        productPrice.sendKeys("15.00");
    }

    public void sendKeysProductImage(){
        productImage.sendKeys("/Users/Iaroslava/Downloads/nicecandle.jpeg");
    }

    public void clickSubmitNewProduct(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", submitNewProduct);
    }

// create new product - json upload

    public void clickImportDataFromAnotherProduct(){
        wait.until(ExpectedConditions.elementToBeClickable(clickImportDataFromAnotherProduct));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", clickImportDataFromAnotherProduct);
    }

    public void sendKeysJsonUpload(){
        jsonUpload.sendKeys("/Users/Iaroslava/Downloads/8286148526375-upload_test.json");
    }

    public void clickFillDataButton() {
        wait.until(ExpectedConditions.visibilityOf(fillDataButton));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", fillDataButton);
    }

    public void sendKeysProductTitleJson(){
        productTitle.sendKeys(" Finta");
    }

    public void clickSaveProduct() {
        wait.until(ExpectedConditions.visibilityOf(saveProductButton));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", saveProductButton);
    }

    //  clone a product
    public void clickCloneProduct() {
        wait.until(ExpectedConditions.visibilityOf(cloneProduct));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", cloneProduct);
    }

    public void clickDeleteProduct() {
        wait.until(ExpectedConditions.visibilityOf(deleteProduct));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", deleteProduct);
    }

    public void clickConfirmDelete() {
        wait.until(ExpectedConditions.visibilityOf(confirmDeleteProduct));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", confirmDeleteProduct);
    }

    //    download json file
    public void clickEditProduct() {
        wait.until(ExpectedConditions.visibilityOf(editProduct));
        editProduct.click();
    }

    public void clickSettings() {
        wait.until(ExpectedConditions.elementToBeClickable(settingsButton));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", settingsButton);
    }

    public void clickImportData() {
        wait.until(ExpectedConditions.visibilityOf(clickImportData));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", clickImportData);
    }

    public void clickExportData() {
        wait.until(ExpectedConditions.visibilityOf(selectExportCheckbox));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", selectExportCheckbox);
    }

    public void clickDownload() {
        wait.until(ExpectedConditions.visibilityOf(clickDownloadJson));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", clickDownloadJson);
    }

    //    preview product
    public void clickPreviewProduct() {
        wait.until(ExpectedConditions.visibilityOf(previewProduct));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", previewProduct);
    }

    public void sendKeysPassword(){
        passwordStore.sendKeys("12345");
    }

    public void clickEnter() {
        wait.until(ExpectedConditions.visibilityOf(clickEnterButton));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", clickEnterButton );
    }


}
