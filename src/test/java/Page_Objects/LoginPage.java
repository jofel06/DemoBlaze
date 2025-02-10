package Page_Objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage{

    @FindBy(id = "login2")
    private WebElement loginLink;

    @FindBy(id = "loginusername")
    private WebElement usernameField;

    @FindBy(id = "loginpassword")
    private WebElement passwordField;

    @FindBy(css = "button[onclick='logIn()']")
    private WebElement loginButton;

    @FindBy(xpath = "(//div[@class='modal-footer']//button[text()='Close'])[2]")
    private WebElement loginCloseButton;

    @FindBy(xpath = "(//div[@class='modal-header']/button[@class='close'])[2]")
    private WebElement loginCloseIcon;


    public LoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this); //this initializes the WebElement fields in this class by using the WebDriver to locate them on the page, the @FindBy.
    }

    public void clickLoginLink(){
        click(loginLink);
    }

    public void enterUsername(String username){
        type(usernameField, username);
    }

    public void enterPassword(String password){
        type(passwordField, password);
    }

    public void clickLoginButton(){
        click(loginButton);
    }

    public void clickLoginCloseButton(){
        click(loginCloseButton);
    }

    public void clickLoginCloseIcon(){
        click(loginCloseIcon);
    }

    public void clickLoginButtonAndAcceptAlert(){
        click(loginButton);
        acceptAlert();
    }
}


