import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class addUserPage {

    //Class Variables declaration
    WebDriver driver;

    @FindBy(id="systemUser_userType")
    WebElement lstUserRole;

    @FindBy(id="systemUser_employeeName_empName")
    WebElement txtEmpName;

    @FindBy(id="systemUser_userName")
    WebElement txtUserName;

    @FindBy(id="systemUser_status")
    WebElement lstUserStatus;

    @FindBy(id="systemUser_password")
    WebElement txtPassword;

    @FindBy(id="systemUser_confirmPassword")
    WebElement txtConfirmPassword;

    @FindBy(id="btnSave")
    WebElement btnSave;

 //   @FindBy(linkText = sUsername)
 //   WebElement sUserId;

    //Constructor Class
    addUserPage(WebDriver driver){
        this.driver = driver;                                   //Initialization of class web driver
     //   this.sUsername = sUsername;                             //Initialization of Username
        PageFactory.initElements(driver, this);           //Initialization of Web elements
    }

    //Method to select User Role
    public void selectUserRole(String sUserRole){
        Select userRole = new Select(lstUserRole);
        userRole.selectByValue(sUserRole);
    }

    //Method to enter employee name
    public void setEmpName(String sEmpName){
        txtEmpName.sendKeys(sEmpName);
    }

    public void setUserName(String sUserName){      //Method to enter user name
        txtUserName.sendKeys(sUserName);
    }

    public void selectUserStatus(String sStatus){      //Method to select user status
        Select userStatus = new Select(lstUserStatus);
        userStatus.selectByValue(sStatus);

    }

    public void setPassword(String sPassword){      //Method to enter password
        txtPassword.sendKeys(sPassword);
    }

    public void setConfirmPassword(String sConfirmPwd){     //Method to enter confirm password
        txtConfirmPassword.sendKeys(sConfirmPwd);
    }

    public void clickSave(){      //Method to click Save button
        btnSave.click();

    }



}
