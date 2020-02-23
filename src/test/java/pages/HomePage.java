package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

private WebDriver driver;

public HomePage(WebDriver driver){

    this.driver = driver;
    PageFactory.initElements(this.driver, this);
}

    @FindBy(xpath = "/html/body/div[2]/div/ul/li[18]/a")
    private WebElement fileUploadPage;

    @FindBy(xpath="//*[@id=\"content\"]/ul/li[39]/a")
    private WebElement shiftingContentPage;



    public void ClickFileUploadPageButton()
    {
        fileUploadPage.click();
    }

    public void ClickShiftingContentPageButton()
    {
        shiftingContentPage.click();
    }

}
