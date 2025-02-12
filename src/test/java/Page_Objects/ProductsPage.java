package Page_Objects;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class ProductsPage extends BasePage {

    public ProductsPage (WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this); //this initializes the WebElement fields in this class by using the WebDriver to locate them on the page, the @FindBy.
    }

    @FindBy(xpath = "//div[@class='list-group']//a[contains(text(),'Monitors')]")
    private WebElement MonitorsCategory;

    @FindBy(xpath = "//div[@class='list-group']//a[contains(text(),'Laptops')]")
    private WebElement LaptopsCategory;

    @FindBy(xpath = "//div[@class='list-group']//a[contains(text(),'Phones')]")
    private WebElement PhonesCategory;

    @FindBy(css = "a[class='btn btn-success btn-lg']")
    private WebElement ProductAddToCartBtn;

    @FindBy(xpath = "//div[@class='navbar-collapse']//a[@href='index.html']")
    private WebElement HomePageLink;

    @FindBy(xpath = "//div[@id='footc']//b[contains(text(), 'About Us')]")
    private WebElement AboutUsFooter;

    //For Dynamic and Stale Elements
    private WebElement getMonitorsCategory(){
        return driver.findElement(By.xpath("//div[@class='list-group']//a[contains(text(),'Monitors')]"));
    }

    private WebElement getLaptopsCategory(){
        return driver.findElement(By.xpath("//div[@class='list-group']//a[contains(text(),'Monitors')]"));
    }

    private WebElement getPhonesCategory(){
        return driver.findElement(By.xpath("//div[@class='list-group']//a[contains(text(),'Monitors')]"));
    }




    //Dynamic locator for product selection
    public void clickProduct(String productName){
        By productLocator = By.xpath("//a[contains(text(),'" + productName + "')]");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(productLocator)).click();
    }

    public void clickMonitorsCategory(){
        try{
            click(MonitorsCategory);
        }
        catch (StaleElementReferenceException e){
            driver.navigate().refresh();
            waitForElement(getMonitorsCategory());
            getMonitorsCategory().click();
        }
    }

    public void clickLaptopsCategory(){
        try {
            click(LaptopsCategory);
        }
        catch (StaleElementReferenceException e){
            driver.navigate().refresh();
            waitForElement(getLaptopsCategory());
            getLaptopsCategory().click();
        }
    }

    public void clickPhonesCategory(){
        try {
            click(PhonesCategory);
        }
        catch (StaleElementReferenceException e){
            driver.navigate().refresh();
            waitForElement(getPhonesCategory());
            getPhonesCategory().click();
        }
    }

    public void clickProductAddToCartBtn(){
        click(ProductAddToCartBtn);
    }

    public void clickProductAddToCartBtnAndAcceptAlert(){
        click(ProductAddToCartBtn);
        acceptAlert();
    }

    public void clickHomePageLink(){
        click(HomePageLink);
    }

}
