package com.demo.pages;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AddToCart {

	//Validate categories on Page
	public void validateCategoriesAndHovering(WebDriver driver) throws InterruptedException, IOException {
		JavascriptExecutor js = (JavascriptExecutor) driver;

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("speakersImg")));
		driver.findElement(By.id("speakersImg")).isDisplayed();
		System.out.println("Speakers display T/F : " + driver.findElement(By.id("speakersImg")).isDisplayed());
		Actions action = new Actions(driver);		
		action.moveToElement(driver.findElement(By.id("speakersImg"))).perform();
		Thread.sleep(20);
		WebElement element = driver.findElement(By.id("speakersLink"));
		js.executeScript("arguments[0].scrollIntoView(true);", element);

		driver.findElement(By.id("speakersLink")).isDisplayed();
		System.out.println("SHop Now Link Displayed T/F : "+driver.findElement(By.id("speakersLink")).isDisplayed());
		// Take screenshot and save it
        TakesScreenshot ts = (TakesScreenshot) driver;
        File src = ts.getScreenshotAs(OutputType.FILE);
        File dest = new File("/Users/asdeshpande/Desktop/repos/AdvantageDemo/advantageShopping/Screenshots/hovering.png");

        // Copy the file to destination
        FileHandler.copy(src, dest);
        System.out.println("✅ Screenshot saved at: " + dest.getAbsolutePath());
	}

}
