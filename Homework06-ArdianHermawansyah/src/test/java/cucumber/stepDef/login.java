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

    @When("the user click addtochart")
    public void the_user_click_addtochart() {
        driver.findElement(By.xpath("//*[@id='add-to-cart-sauce-labs-backpack']")).click();

    }
    @Then("the user success adding product")
    public void the_user_success_adding_product() {
        driver.findElement(By.xpath("//*[@id='remove-sauce-labs-backpack']"));
        String add = driver.findElement(By.xpath("//*[@id='remove-sauce-labs-backpack']")).getText();
        Assert.assertEquals(add, "Remove");

    }

    @When("the user click remove")
    public void the_user_click_remove() {
        driver.findElement(By.xpath("//*[@id='remove-sauce-labs-backpack']")).click();
    }

    @Then("the user success remove product")
    public void the_user_success_remove_product() {
        driver.findElement(By.xpath("//*[@id='add-to-cart-sauce-labs-backpack']"));
        String add = driver.findElement(By.xpath("//*[@id='add-to-cart-sauce-labs-backpack']")).getText();
        Assert.assertEquals(add, "Add to cart");
    }

    @And("the user click icon cart")
    public void the_user_click_icon_cart() {
        driver.findElement(By.xpath("//*[@id='shopping_cart_container']")).click();
    }

    @When("the user on the cart page")
    public void the_user_on_the_cart_page() {
        driver.findElement(By.xpath("//*[@id='header_container']/div[2]/span"));
        String add = driver.findElement(By.xpath("//*[@id='header_container']/div[2]/span")).getText();
        Assert.assertEquals(add, "Your Cart");
    }

    @And("the user click checkout button on cartpage")
    public void the_user_click_checkout_button_on_cartpage() {
        driver.findElement(By.xpath("//*[@id='checkout']")).click();
    }

    @When("the user on information page")
    public void the_user_on_information_page() {
        driver.findElement(By.xpath("//*[@id='header_container']/div[2]/span"));
        String add = driver.findElement(By.xpath("//*[@id='header_container']/div[2]/span")).getText();
        Assert.assertEquals(add, "Checkout: Your Information");
    }

    @And("the user fill information")
    public void the_user_fill_information() {
        driver.findElement(By.xpath("//*[@id='first-name']")).sendKeys("ardian");
        driver.findElement(By.xpath("//*[@id='last-name']")).sendKeys("hermawansyah");
        driver.findElement(By.xpath("//*[@id='postal-code']")).sendKeys("34111");
    }

    @And("the user click continue button on information page")
    public void the_user_click_continue_button_on_information_page() {
        driver.findElement(By.xpath("//*[@id='continue']")).click();
        
    }

    @When("the user on checkout overview page")
    public void the_user_on_checkout_overview_page() {
        driver.findElement(By.xpath("//*[@id='header_container']/div[2]/span"));
        String add = driver.findElement(By.xpath("//*[@id='header_container']/div[2]/span")).getText();
        Assert.assertEquals(add, "Checkout: Overview");
    }

    @And("the user click finish on overview page")
    public void the_user_click_finish_on_overview_page() {
        driver.findElement(By.xpath("//*[@id='finish']")).click();
        
    }

    @Then("the user success checkout")
    public void the_user_success_checkout() {
        driver.findElement(By.xpath("//*[@id='header_container']/div[2]/span"));
        String add = driver.findElement(By.xpath("//*[@id='header_container']/div[2]/span")).getText();
        Assert.assertEquals(add, "Checkout: Complete!");
    }

}

