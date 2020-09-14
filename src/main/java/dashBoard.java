import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class dashBoard {
    WebDriver driver;

 //   @FindBy(id="menu_dashboard_index")
//    WebElement menuDashboard;

    @FindBy(id="menu_admin_viewAdminModule")
    WebElement menuAdmin;

    dashBoard(WebDriver driver){
        this.driver = driver; //initializing driver
        PageFactory.initElements(driver, this); //initializing web elements
    }

    public void clickAdmin(){
        menuAdmin.click();
    }

}
