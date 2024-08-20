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





}

