
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class testAddUser {

    WebDriver driver;

    @Test
    public void fAddUser(){
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

        wait.until(ExpectedConditions.elementToBeClickable(cUM.btnAdd)); //Wait until Add button is displayed and clickable
        cUM.clickAddButton();   //Click Add button

        addUserPage cAU = new addUserPage(driver); //Initializing Add User page
        wait.until(ExpectedConditions.elementToBeClickable(cAU.txtUserName)); //Wait until username text field is displayed and clickable

        cAU.setEmpName(cUD.sEmpName);           // Enter employee name
        cAU.setUserName(cUD.sUserName);         // Enter username
        cAU.selectUserStatus(cUD.sUserStatus);  // Select User Status
        cAU.setPassword(cUD.sPassword);         // Enter password
        cAU.setConfirmPassword(cUD.sPassword);  // Enter same password in Confirm Password field
        cAU.selectUserRole(cUD.sUserRole);      // Select user role

      //  wait.until(ExpectedConditions.elementSelectionStateToBe(cAU.btnSave, true));       // wait until Save button is clickable
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        cAU.clickSave(); // click Save button

        cUM.getsUsername();
        Assert.assertEquals(cUM.chkUserAdded, cUD.sUserName);   //Check if the user is added successfully

        driver.close();
        driver.quit();
    }



}