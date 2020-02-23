package helloselenium;


import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import pages.HomePage;
import pages.ShiftingContentPage;
import pages.UploadPage;

import java.io.File;
import java.util.concurrent.TimeUnit;

import static java.lang.Thread.*;

public class UploadFile {



    public static WebDriver driver;
    public static boolean first = true;
    public static HomePage homePage;
    public static Actions actions;
    public static UploadPage uploadPage;
    public static ShiftingContentPage shiftingContentPage;



    @Given("^User is on home page$")
    public void user_is_on_main_page() throws Exception {
        if (first){
            first = false;
            driver = new ChromeDriver();
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            homePage = new HomePage(driver);
            actions = new Actions(driver);
            uploadPage = new UploadPage(driver);
            shiftingContentPage = new ShiftingContentPage(driver);
            driver.get("http://the-internet.herokuapp.com/");
    }

        driver.get("http://the-internet.herokuapp.com/");

    }
    @When("^User clicks \"([^\"]*)\" button$")
    public void user_clicks_button(String arg1) throws Exception {
        sleep(2000);
        switch (arg1) {
            case "upload_file":
                homePage.ClickFileUploadPageButton();
                break;
            case "shifting_content":
                homePage.ClickShiftingContentPageButton();
                break;
        }


    }



    @When("^User chooses file$")
    public void user_chooses_file() throws Exception {
        uploadPage.ChooseFile();
    }

    @When("^User clicks upload button$")
    public void user_clicks_upload_button() throws Exception {
        sleep(2000);
            uploadPage.clickUploadFileButton();
    }

    @Then("^file should be uploaded$")
    public void file_should_be_uploaded() throws Exception {
        assert uploadPage.IsFileUploadTextDisplayed() && uploadPage.fileUploadedTextIsTrue();
    }

    @When("^user moves cursor to \"([^\"]*)\" button$")
    public void user_moves_cursor_to_button(String arg1) throws Exception {
        shiftingContentPage.ClickMenuElementButton();
        sleep(2000);
        actions.moveToElement(shiftingContentPage.homeButton).perform();

    }

    @Then("^button design should be changed$")
    public void button_design_should_be_changed() throws Exception {
            assert shiftingContentPage.IsDesignChanged();
    }
    @When("^User clicks click here button for image$")
    public void user_clicks_click_here_button_for_image() throws Exception {
        shiftingContentPage.ClickImageButton();
            shiftingContentPage.ClickHere();
    }

    @Then("^image should move$")
    public void image_should_move() throws Exception {

    }


}
