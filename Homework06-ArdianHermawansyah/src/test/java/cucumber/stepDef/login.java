package cucumber.stepDef;


import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class login {

    WebDriver driver;
    String Url = "https://www.saucedemo.com";

    @Given("the user is on web login page")
    public void the_user_is_on_web_login_page() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions opt = new ChromeOptions();
        opt.setHeadless(true);
        driver = new ChromeDriver(opt);
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(Url);

        String Loginpage = driver.findElement(By.xpath("//*[@id='login_credentials']/h4")).getText();
        Assert.assertEquals(Loginpage, "Accepted usernames are:");


    }

    @And("the user has entered (.*) as username$")
    public void the_user_has_entered_standard_user_as_username(String username) {

        driver.findElement(By.id("user-name")).sendKeys(username);
    }

    @And("the user has entered (.*) as password$")
    public void the_user_has_entered_secret_sauce_as_password(String password) {
        driver.findElement(By.id("password")).sendKeys(password);
    }

    @When("the user click login button")
    public void the_user_click_login_button() {
       driver.findElement(By.xpath("//*[@id='login-button']")).click();

         }

        @Then("the user verify (.*) login result$")
        public void the_user_verify_success_login_result (String status){
            if (status.equals("success")) {
                driver.findElement(By.xpath("//*[@id='header_container']/div[2]/span"));
                String username = driver.findElement(By.xpath("//*[@id='header_container']/div[2]/span")).getText();
                Assert.assertEquals(username, "Products");
            } else {
                String errorLogin = driver.findElement(By.xpath("//*[@id='login_button_container']/div/form/div[3]")).getText();
                Assert.assertEquals(errorLogin, "Epic sadface: Username and password do not match any user in this service");
            }
        }
    }

