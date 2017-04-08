package ohtu;

import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import static org.junit.Assert.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import cucumber.api.java.Before;
import io.github.bonigarcia.wdm.ChromeDriverManager;

public class Stepdefs {
    WebDriver driver;
    String baseUrl = "http://localhost:4567";
    
    @Before
    public void setUp() {
        ChromeDriverManager.getInstance().setup();
        driver = new ChromeDriver();
    }

    @Given("^login is selected$")
    public void login_selected() throws Throwable {
        
        driver.get(baseUrl);
        WebElement element = driver.findElement(By.linkText("login"));       
        element.click();          
    }
    
    @Given("^new user is selected$")
    public void new_user_selected() throws Throwable {
        driver.get(baseUrl);
        WebElement element = driver.findElement(By.linkText("register new user"));
        element.click();
    }

    @When("^username \"([^\"]*)\" and password \"([^\"]*)\" are given$")
    public void username_and_password_are_given(String username, String password) throws Throwable {
        WebElement element = driver.findElement(By.name("username"));
        element.sendKeys(username);
        element = driver.findElement(By.name("password"));
        element.sendKeys(password);
        element = driver.findElement(By.name("login"));
        element.submit();  
    }

    @Then("^system will respond \"([^\"]*)\"$")
    public void system_will_respond(String pageContent) throws Throwable {
        assertTrue(driver.getPageSource().contains(pageContent));
    }
    
    @When("^correct username \"([^\"]*)\" and password \"([^\"]*)\" are given$")
    public void username_correct_and_password_are_given(String username, String password) throws Throwable {
        logInWith(username, password);
    }

    @When("^correct username \"([^\"]*)\" and incorrect password \"([^\"]*)\" are given$")
    public void username_and_incorrect_password_are_given(String username, String password) throws Throwable {
        logInWith(username, password);
    }
    
    @When("^nonexistent username \"([^\"]*)\" and password \"([^\"]*)\" are given$")
    public void nonexistent_username_is_given(String username, String password) throws Throwable {
        logInWith(username, password);
    }
    
    @When("^correct username \"([^\"]*)\", password \"([^\"]*)\" and password confirmation \"([^\"]*)\" are given for registration$")
    public void correct_register_information_are_given_for_registration(String username, String password, String passwordConfirmation) {
        registerWith(username, password, passwordConfirmation);
    }
    
    @When("^correct username \"([^\"]*)\" and too short password \"([^\"]*)\" are given for registration$")
    public void correct_username_and_too_short_password_are_given_registration(String username, String password) throws Throwable {
        registerWith(username, password, password);
    }
    
    @When("^too short username \"([^\"]*)\" and valid password \"([^\"]*)\" are given for registration$")
    public void too_shot_username_and_correct_password_are_given_for_registration(String username, String password) {
        registerWith(username, password, password);
    }
    
    @When("^correct username \"([^\"]*)\" and password consisting of only letters \"([^\"]*)\" are given for registration$")
    public void password_with_only_letters_is_given_for_registration(String username, String password) {
        registerWith(username, password, password);
    }
    
    @When("^an already used username \"([^\"]*)\" and valid password \"([^\"]*)\" are given for registration$")
    public void already_taken_username_is_given_for_registration(String username, String password) throws Throwable {
        registerWith(username, password, password);
    }
    
    @When("^correct username \"([^\"]*)\" is given but password \"([^\"]*)\" and password confirmation \"([^\"]*)\" do not match$")
    public void password_and_password_confirmation_do_not_match(String username, String password, String passwordConfimation) throws Throwable {
        registerWith(username, password, passwordConfimation);
    }
    
    @Then("^user is logged in$")
    public void user_is_logged_in() throws Throwable {
        pageHasContent("Ohtu Application main page");
    }
    
    @Then("^user is not logged in and error message is given$")
    public void user_is_not_logged_in_and_error_message_is_given() throws Throwable {
        pageHasContent("invalid username or password");
        pageHasContent("Give your credentials to login");
    }     
    
    @Then("^user creation is successful$")
    public void user_creation_is_successful()throws Throwable {
        pageHasContent("Welcome to Ohtu Application");
        pageHasContent("info for newbie");
    }
    
    @Then("^user is not created and error \"([^\"]*)\" is reported$")
    public void user_is_not_created_and_error_is_reported(String errorMessage) throws Throwable {
        pageHasContent(errorMessage);
        pageHasContent("username");
        pageHasContent("password confirmation");
    }
    
    @After
    public void tearDown(){
        driver.quit();
    }
        
    /* helper methods */
 
    private void pageHasContent(String content) {
        assertTrue(driver.getPageSource().contains(content));
    }
        
    private void logInWith(String username, String password) {
        assertTrue(driver.getPageSource().contains("Give your credentials to login"));
        WebElement element = driver.findElement(By.name("username"));
        element.sendKeys(username);
        element = driver.findElement(By.name("password"));
        element.sendKeys(password);
        element = driver.findElement(By.name("login"));
        element.submit();  
    } 
    
    private void registerWith(String username, String password, String passwordConfirmation) {
        assertTrue(driver.getPageSource().contains("Create username and give password"));
        WebElement element = driver.findElement(By.name("username"));
        element.sendKeys(username);
        element = driver.findElement(By.name("password"));
        element.sendKeys(password);
        element = driver.findElement(By.name("passwordConfirmation"));
        element.sendKeys(passwordConfirmation);
        element = driver.findElement(By.name("signup"));
        element.submit();  
    }
}
