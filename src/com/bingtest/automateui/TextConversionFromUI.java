package com.bingtest.automateui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TextConversionFromUI {

	public String translateText(WebDriver driver,String from,String to,String text) throws InterruptedException{
		driver.findElement(By.cssSelector(".sourceText .LS_Header")).click();
		driver.findElement(By.cssSelector(".sourceText .LanguageList .LS_Item[value="+ from +"]")).click();
		driver.findElement(By.cssSelector(".destinationText .LS_Header")).click();
		driver.findElement(By.cssSelector(".destinationText .LanguageList .LS_Item[value="+ to +"]")).click();
		driver.findElement(By.cssSelector("#srcText")).sendKeys(text);
		Thread.sleep(3000);
		String convertedString= driver.findElement(By.cssSelector("#destText")).getText();
        return convertedString;
	}
	
	public String autotextConversion(WebDriver driver,String to,String text) throws InterruptedException{
		
		driver.findElement(By.cssSelector(".sourceText  .LS_Header")).click();
		 driver.findElement(By.cssSelector(".sourceText  .LanguageList  .LS_Item[value='-']")).click();
		driver.findElement(By.cssSelector("#srcText")).sendKeys(text);
        driver.findElement(By.cssSelector(".destinationText .LS_Header")).click();
		driver.findElement(By.cssSelector(".destinationText .LanguageList .LS_Item[value="+ to +"]")).click();
		//driver.findElement(By.cssSelector("#TranslateButton")).click();
		Thread.sleep(3000);
		String convertedString= driver.findElement(By.cssSelector("#destText")).getText();
	    return convertedString;
	}
	
	public static void main(String[] args) throws InterruptedException{
		String from="fr";
		String to="en";
		String text="bonjour";
		String downloadDir = System.getProperty("user.home") + "//Downloads";
		System.setProperty("webdriver.chrome.driver", downloadDir+"//chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.bing.com/translator");
	    TextConversionFromUI txtObj= new TextConversionFromUI();
	    System.out.println(txtObj.translateText(driver, from, to, text));
	    driver.findElement(By.cssSelector("#srcText")).clear();
		System.out.println(txtObj.autotextConversion(driver, to, text));
	}
}
