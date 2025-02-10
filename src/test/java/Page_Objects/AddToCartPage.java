package Page_Objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddToCartPage extends BasePage{

    @FindBy(id = "cartur")
    private WebElement cartLink;

    @FindBy(xpath = "//div[@class='col-lg-1']//button[@data-target='#orderModal']")
    private WebElement cartPlaceOrderButton;

    @FindBy(xpath = "//div[@class='modal-content']//div[@class='form-group']//input[@id='name']")
    private WebElement cartPlaceOrderName;

    @FindBy(xpath = "//div[@class='modal-content']//div[@class='form-group']//input[@id='country']")
    private WebElement cartPlaceOrderCountry;

    @FindBy(xpath = "//div[@class='modal-content']//div[@class='form-group']//input[@id='city']")
    private WebElement cartPlaceOrderCity;

    @FindBy(xpath = "//div[@class='modal-content']//div[@class='form-group']//input[@id='card']")
    private WebElement cartPlaceOrderCreditCard;

    @FindBy(xpath = "//div[@class='modal-content']//div[@class='form-group']//input[@id='month']")
    private WebElement cartPlaceOrderMonth;

    @FindBy(xpath = "//div[@class='modal-content']//div[@class='form-group']//input[@id='year']")
    private WebElement cartPlaceOrderYear;

    @FindBy(css = "button[onclick='purchaseOrder()']")
    private WebElement cartPlaceOrderPurchaseBtn;

    @FindBy(css = "button[class='confirm btn btn-lg btn-primary']")
    private WebElement cartPurchaseConfirmationBtn;

    @FindBy(xpath = "(//button[@data-dismiss='modal'])[5]")
    private WebElement cartPlaceOrderCloseBtn;

    public AddToCartPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this); //this initializes the WebElement fields in this class by using the WebDriver to locate them on the page, the @FindBy.
    }

    public void clickCartLink(){
        click(cartLink);
    }

    public void clickCartPlaceOrderBtn(){
        click(cartPlaceOrderButton);
    }

    public void enterName(String name){
        type(cartPlaceOrderName, name);
    }

    public void enterCountry(String country) {
        type(cartPlaceOrderCountry, country);
    }

    public void enterCity(String city){
        type(cartPlaceOrderCity, city);
    }

    public void enterCreditCard(String card){
        type(cartPlaceOrderCreditCard, card);
    }

    public void enterMonth(String month){
        type(cartPlaceOrderMonth, month);
    }

    public void enterYear(String year){
        type(cartPlaceOrderYear, year);
    }

    public void clickCartPlaceOrderPurchaseBtn(){
        click(cartPlaceOrderPurchaseBtn);
    }

    public void clickCartPurchaseConfirmationBtn(){
        click(cartPurchaseConfirmationBtn);
    }

    public void clickCartPlaceOrderCloseBtn(){
        click(cartPlaceOrderCloseBtn);
    }

}
