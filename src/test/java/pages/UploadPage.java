package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.File;

public class UploadPage {

    private WebDriver driver;

    public UploadPage(WebDriver driver){

        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    @FindBy(xpath = "//*[@id=\"file-upload\"]")
    private WebElement chooseFileInput;

    @FindBy(xpath="//*[@id=\"content\"]/div/h3")
    private WebElement fileUploadedText;

    @FindBy(xpath="//*[@id=\"uploaded-files\"]")
    private WebElement uploadedFileNameDiv;

    @FindBy(xpath="//*[@id=\"file-submit\"]")
    private WebElement uploadButton;



    public void ClickChooseFileButton()
    {
        chooseFileInput.click();
    }

    public void ChooseFile()
    {
        File file = new File(System.getProperty("FilePath"));
        chooseFileInput.sendKeys(file.getAbsolutePath());
    }
    public boolean IsFileUploadTextDisplayed()
    {
        return fileUploadedText.isDisplayed();
    }

    public boolean IsFileNameTrue(String fileName)
    {
        return uploadedFileNameDiv.getAttribute("innerHTML") == fileName;
    }

    public void clickUploadFileButton()
    {
         uploadButton.click();
    }
    public boolean fileUploadedTextIsTrue()
    {
      return  fileUploadedText.getAttribute("innerHTML").contains("File Uploaded!");
    }
}
