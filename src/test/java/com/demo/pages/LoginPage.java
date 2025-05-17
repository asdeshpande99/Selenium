package com.demo.pages;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class LoginPage {
	
	public void validateloginPopup(WebDriver driver) throws InterruptedException {
		Thread.sleep(10);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("hrefUserIcon")));
		driver.findElement(By.id("hrefUserIcon")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'SIGN IN WITH FACEBOOK')]")));
		String titleOfPopup = driver.findElement(By.xpath("//*[contains(text(),'SIGN IN WITH FACEBOOK')]")).getText();
		Assert.assertEquals(titleOfPopup, "SIGN IN WITH FACEBOOK", "Not Matching");		
	}
	
	public void loginWithCreds(WebDriver driver, String username, String password) throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("hrefUserIcon")));
		driver.findElement(By.id("hrefUserIcon")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("username")));
		driver.findElement(By.name("username")).sendKeys(username);
		driver.findElement(By.name("password")).sendKeys(password);
		Thread.sleep(10);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("loader")));
		driver.findElement(By.id("sign_in_btn")).click();
		Thread.sleep(30);
	}
	
}
