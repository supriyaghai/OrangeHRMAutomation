import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import sun.jvm.hotspot.debugger.Page;

public class userManagementPage {

    //Class Variables declaration
    WebDriver driver;
    String sUsername;
    String sAddUserId;
    String chkUserAdded;

    @FindBy(id="btnAdd")
    WebElement btnAdd;

    @FindBy(id="btnDelete")
    WebElement btnDelete;

    @FindBy(id="searchBtn")
    WebElement btnSearch;

    @FindBy(id = "resetBtn")
    WebElement btnReset;

    //Constructor Class
    userManagementPage(WebDriver driver, String sUsername){
        this.driver = driver;       //Class web driver initialization
        this.sUsername = sUsername;
        PageFactory.initElements(driver, this);     //Web Elements initialization
    }

    // Method to click Add button
    public void clickAddButton(){
        btnAdd.click();
    }

    //Method to click Delete button
    public void clickDeleteButton(){
        btnDelete.click();
    }

    //Method to click Search Button
    public void clickSearchButton(){
        btnSearch.click();
    }

    //Method to click Reset Button
    public void clickResetButton(){
        btnReset.click();
    }

    public void getsUsername(){
        String sxpath = "//td[contains(.,'" + sUsername +"')]";
        chkUserAdded = driver.findElement(By.xpath(sxpath)).getText();
    }

    public void getsAddUserId() {
        WebElement lnkText = driver.findElement(By.linkText(sUsername));
        sAddUserId = lnkText.getAttribute("href").substring(lnkText.getAttribute("href").length()-2);
    }

    public void selectUser(){
        getsAddUserId();
        driver.findElement(By.id("ohrmList_chkSelectRecord_" + sAddUserId)).click();
    }

    public void clickDeleteDialogueBox(){
        driver.findElement(By.id("dialogDeleteBtn")).click();
    }

    public boolean checkSuccessMsg(){
        return driver.findElement(By.xpath("//div[@class='message success fadable']")).isDisplayed();
    }
}
