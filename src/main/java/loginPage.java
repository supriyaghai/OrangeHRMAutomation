import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class loginPage {

    //Class variables declaration
    WebDriver driver;
    @FindBy(id="txtUsername")
    WebElement txtUserName;

    @FindBy(id="txtPassword")
    WebElement txtPassword;

    @FindBy(id="btnLogin")
    WebElement btnLogin;

    @FindBy(id="logInPanelHeading")
    WebElement txtLogInPanelHeading;

    //Constructor Class
    loginPage(WebDriver driver){
        this.driver = driver;                         //Initializing Class Web Driver variable
        PageFactory.initElements(driver, this); //Initializing Web Elements
    }

    // Method to enter Username
    public void setUsername(){
        txtUserName.sendKeys("admin");
    }

    //Method to enter Password
    public void setPassword(){
        txtPassword.sendKeys("admin123");
    }

    //Method to click login button
    public void clickLogin(){
        btnLogin.click();
    }

    //Method to get login page heading
    public String getLoginPageHeading(){
        return txtLogInPanelHeading.getText();
    }

}



