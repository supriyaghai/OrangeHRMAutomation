import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class testDeleteUser {

    WebDriver driver;
//    WebDriverWait wait = new WebDriverWait(driver, 30);

    @Test
    public void fDeleteUser(){

        boolean checkDeleteSuccessfully;
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();        //Initiating driver

        userDetails cUD = new userDetails();
        driver.navigate().to(cUD.sURL);         // Navigate to URL of the Website

        loginPage cLP = new loginPage(driver);  //Initializing login page class
        cLP.setUsername();      //Enter username
        cLP.setPassword();      //Enter password
        cLP.clickLogin();       //Click Login button

        dashBoard cDB = new dashBoard(driver);   //Initiating dashboard class

        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.elementToBeClickable(cDB.menuAdmin)); //Wait until dashboard page is loaded

        cDB.clickAdmin();  //Click admin button

        userManagementPage cUM = new userManagementPage(driver, cUD.sUserName); //initializing User Management page class
        wait.until(ExpectedConditions.visibilityOf(cUM.btnDelete));
        cUM.getsAddUserId();
        cUM.selectUser();
        cUM.clickDeleteButton();
        cUM.clickDeleteDialogueBox();
        checkDeleteSuccessfully = cUM.checkSuccessMsg();

        Assert.assertTrue(checkDeleteSuccessfully);

        driver.close();
        driver.quit();

    }
}


