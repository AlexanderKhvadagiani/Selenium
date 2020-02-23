package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShiftingContentPage {

    private WebDriver driver;

    public ShiftingContentPage(WebDriver driver){

        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }


    @FindBy(xpath = "//html/body/div[2]/div/div/a[1]")
    private WebElement menuElementButton;
    @FindBy(xpath = "//*[@id=\"content\"]/div/a[2]")
    private WebElement imageButton;

    @FindBy(xpath = "/html/body/div[2]/div/div/ul/li[1]/a")
    public WebElement homeButton;

    @FindBy(xpath = "/html/body/div[2]/div/div/p[3]/a")
    private WebElement clickHereButton;

     @FindBy(xpath = "/html/body/div[2]/div/div/img")
     private WebElement image;




    public void ClickMenuElementButton()
    {
        menuElementButton.click();
    }
    public void ClickImageButton()
    {
        imageButton.click();
    }
    public boolean IsDesignChanged()
    {
        return homeButton.getCssValue("color")!="#DA4B4B";
    }
    public void ClickHere()
    {
        clickHereButton.click();
    }

    public boolean IsImageMoved(){
       return image.getCssValue("left")!=System.getProperty("DefaultLeftValue");
    }

}
