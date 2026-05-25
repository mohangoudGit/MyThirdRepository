package com.qa.hvcom.pages;

import java.sql.Driver;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.NoSuchElementException;

import java.util.List;

import io.qameta.allure.Step;

public class HomePage {
	
	
	private WebDriver driver;
	//Private By Loctaors
	private final By productsTab=By.xpath("//a[text()=' Products ']");
	private final By SolutionTab=By.xpath("//a[text()=' Solutions ']");
	private final By ServicesTab=By.xpath("//a[text()=' Services ']");
	private final By PartnersTab=By.xpath("//a[text()=' Partners ']");
	//private final By TechAlPart=By.xpath("//a[text()='Technology Alliance Partners']");
	private final By PartID=By.xpath("(//a[starts-with(@id,'global-systems-integrators')])[2]");
	
	private final By PartnerEchoSys=By.xpath("(//a[starts-with(@id,'our-partner-ecosystem')])[2]");
	private final By SupportPortalLink=By.xpath("//div[starts-with(@id,'customer-success-support')]/section/p/span[1]/a");
	private final By BlockStorageLink=By.xpath("//div[starts-with(@id,'storage-platforms')]/section/p/span[1]/a");
		
	
	//div[starts-with(@id,'customer-success-support')]/section/p/span[1]/a  -- Support Portal
	
	//a[text()=' Solutions ']
	
		//Public Pgae Conctructor
	
	
	 //a[text()=' Products ']
	
	
		
		public HomePage(WebDriver driver) {
			
			this.driver=driver;
		}
		
		//public page actions/methods
		@Step("Geeting Product text")
		public String getProductText() {
			
			String Title =driver.getTitle();
			return driver.findElement(productsTab).getText();
			
			
		}
		//public page actions/methods
		
		public String goToProducts() throws InterruptedException {
			
			
			
			driver.findElement(productsTab).click();
			Thread.sleep(5000);
			
			String blockStorageProd=driver.findElement(BlockStorageLink).getText();
			return blockStorageProd;
			
	
		}
		
		public String goToSolutions() throws InterruptedException {
			
			String SolutionTabText= driver.findElement(SolutionTab).getText();
			
			driver.findElement(SolutionTab).click();
			
			return SolutionTabText;
			
	
		}
		
		public String goToServices() throws InterruptedException {
			
			String ServicesTabText= driver.findElement(ServicesTab).getText();
			System.out.println(ServicesTabText);
			
			driver.findElement(ServicesTab).click();
			
			Thread.sleep(5000);
			String Supportaltext=driver.findElement(SupportPortalLink).getText();
			
			return Supportaltext;
			
	
		}
		
public String goToPartners() throws InterruptedException {
			
			String ServicesTabText= driver.findElement(PartnersTab).getText();
			
			driver.findElement(PartnersTab).click();
			
			Thread.sleep(5000);
			
			String Text=driver.findElement(PartnerEchoSys).getText();
			//driver.findElement(PartnerEchoSys).click();
			
			//a[starts-with(@id, 'global-systems-integrators')]
			System.out.println("Text="+Text);
			
	
		//*****************************************************************
			
			
		//*******************************************************************	
			return Text;
		
		}


public  int getFrameIndexOfElement(WebDriver driver, By targetElementLocator) {
    // Step 1: Return focus to the main top-level page
    driver.switchTo().defaultContent();
    
    // Step 2: Find all top-level iframes currently on the page
    List<WebElement> frames = driver.findElements(By.tagName("iframe"));
    int totalFrames = frames.size();
    
    // Step 3: Iterate through each frame context
    for (int i = 0; i < totalFrames; i++) {
        try {
            // Switch focus into the current frame index
            driver.switchTo().frame(i);
            
            // Attempt to locate the target element inside this frame
            if (driver.findElements(targetElementLocator).size() > 0) {
                System.out.println("Success! Element found inside Frame Index: " + i);
                return i; // Target frame index found
            }
        } catch (Exception e) {
            // Handle occasional frame detach/loading errors gracefully
        } finally {
            // Always break back to the main document context before the next loop iteration
            driver.switchTo().defaultContent();
        }
    }
    
    System.out.println("Element was not found inside any top-level frame.");
    return -1; 
}

}
