package ohtu;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Tester {

    public static void main(String[] args) {
//        System.setProperty("webdriver.chrome.driver",
//                "../../../../Programs/ChromeDriver/chromedriver"); 
        ChromeDriverManager.getInstance().setup();
        WebDriver driver = new ChromeDriver();

        //first scenario
        driver.get("http://localhost:4567");
        
        sleep(2);
        
        WebElement element = driver.findElement(By.linkText("login"));
        element.click();

        sleep(2);

        element = driver.findElement(By.name("username"));
        element.sendKeys("pekka");
        element = driver.findElement(By.name("password"));
        element.sendKeys("akkep");
        element = driver.findElement(By.name("login"));
        
        sleep(2);
        element.submit();

        sleep(3);
        
        
        // second scenario
        driver.get("http://localhost:4567");
        
        sleep(2);
        
        element = driver.findElement(By.linkText("login"));
        element.click();

        sleep(2);

        element = driver.findElement(By.name("username"));
        element.sendKeys("pekka");
        element = driver.findElement(By.name("password"));
        element.sendKeys("väärä");
        
        sleep(2);
        element.submit();

        sleep(3);
        
        
        // third scenario
        driver.get("http://localhost:4567");
        
        sleep(2);
        
        element = driver.findElement(By.linkText("login"));
        element.click();

        sleep(2);

        element = driver.findElement(By.name("username"));
        element.sendKeys("väärä");
        element = driver.findElement(By.name("password"));
        element.sendKeys("väärä");
        
        sleep(2);
        element.submit();

        sleep(3);
        
        
        // fourth scenario
        driver.get("http://localhost:4567");
        
        sleep(2);
        
        element = driver.findElement(By.linkText("register new user"));
        element.click();

        sleep(2);

        element = driver.findElement(By.name("username"));
        element.sendKeys("toinen");
        element = driver.findElement(By.name("password"));
        element.sendKeys("salasana");
        element = driver.findElement(By.name("passwordConfirmation"));
        element.sendKeys("salasana");
        
        sleep(2);
        element.submit();

        sleep(3);
        
        
        // fifth scenario
        driver.get("http://localhost:4567");
        
        sleep(2);
        
        element = driver.findElement(By.linkText("register new user"));
        element.click();

        sleep(2);

        element = driver.findElement(By.name("username"));
        element.sendKeys("kolmas");
        element = driver.findElement(By.name("password"));
        element.sendKeys("salasana");
        element = driver.findElement(By.name("passwordConfirmation"));
        element.sendKeys("salasana");
        
        sleep(2);
        element.submit();

        sleep(3);
        
        element = driver.findElement(By.linkText("continue to application mainpage"));
        element.click();

        sleep(2);
        
        element = driver.findElement(By.linkText("logout"));
        element.click();

        sleep(2);
        
        driver.quit();
    }
    
    private static void sleep(int n){
        try{
            Thread.sleep(n*1000);
        } catch(Exception e){}
    }
}
