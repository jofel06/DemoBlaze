package Page_Objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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

    @FindBy(partialLinkText = "Home ")
    private WebElement HomePageLink;


    //Dynamic locator for product selection
    public void clickProduct(String productName){
        By productLocator = By.xpath("//a[contains(text(),'" + productName + "')]");
        driver.findElement(productLocator).click();
    }

    public void clickMonitorsCategory(){
        click(MonitorsCategory);
    }

    public void clickLaptopsCategory(){
        click(LaptopsCategory);
    }

    public void clickPhonesCategory(){
        click(PhonesCategory);
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
