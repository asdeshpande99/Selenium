package com.demo.advantageShopping;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import com.demo.pages.LoginPage;
import com.demo.pages.AddToCart;

public class AppTest {
    WebDriver driver;
    LoginPage loginpage = new LoginPage();
    AddToCart addtocart = new AddToCart();

    @BeforeClass
    public void setup() {
        driver = new ChromeDriver();
        driver.get("https://advantageonlineshopping.com/");
        driver.manage().window().maximize();
    }

    @Test
    public void openHomePage() throws InterruptedException {        
        System.out.println("Page title is: " + driver.getTitle());
        loginpage.loginWithCreds(driver, "admin", "adm1n");
    }
    @Test(enabled = false)
    public void validateLoginPopup() throws InterruptedException {
    	loginpage.validateloginPopup(driver);
    }
    @Test
    public void validateCategoryPage() throws InterruptedException, IOException {
    	addtocart.validateCategoriesAndHovering(driver);
    }

    @AfterClass
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
