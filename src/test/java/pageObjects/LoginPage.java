package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import factory.DriverFactory;


public class LoginPage {
//	private final WebDriver driver;


    @FindBy(name = "user")
    WebElement uName;
    @FindBy(name = "pass")
    WebElement pword;
    @FindBy(name = "btnSubmit")
    WebElement submitButton;
    @FindBy(xpath = "//a[contains(text(),'Logout')]")
    WebElement logout;
    @FindBy(xpath = "//div[@id='user_bar']/h5")
    WebElement welcomeMessage;
    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = DriverFactory.getDriver();
        PageFactory.initElements(driver, this);

    }


    public void insertUserName(String un) {

        uName.sendKeys(un);
//		elementUtil.isTextBoxEnabled(uName);
//		elementUtil.enterText(uName,un);

    }


    public void insertPassword(String pw) {

//		elementUtil.enterText(pword, pw);

        pword.sendKeys(pw);
    }


    public void clickSubmit() {

//		elementUtil.clickButton(submitButton);

        submitButton.click();


    }

    public void getWelcomeMessage() {
        System.out.println(welcomeMessage.getText());
//		elementUtil.getText(welcomeMessage);

    }

    public void clickSignOut() {

//		elementUtil.clickButton(logout);
        logout.click();
    }


}
