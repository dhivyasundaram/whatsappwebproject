package com.mindforce.whatsapp;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WhatsappWeb {

	public static void main(String[] args) throws Exception {
		
		String[] data = ExcelUtility.getData().split("----------");
		
		for (String phoneNumbers : data) {
			
			ChromeDriver driver = new ChromeDriver();
			try {
				driver.manage().window().maximize();
				driver.get("https://whatsapp.webjaadu.com/login");
				driver.findElement(By.xpath("//input[@id='username']")).sendKeys("xoom.finserve@gmail.com");
				driver.findElement(By.xpath("//input[@id='password']")).sendKeys("Yennaapp4*");
				driver.findElement(By.xpath("//button[@type='submit']")).click();
				Thread.sleep(5000);
		
				driver.findElement(By.xpath("//span[text()='WA Contact']")).click();
		
				Thread.sleep(3000);
				Actions a = new Actions(driver);
				WebElement move = driver.findElement(By.xpath("//a[contains(@href, 'whatsapp_contact/index/phone_numbers')]"));
				a.moveToElement(move).click().perform();
				WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
				wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.xpath("(//input[@type='checkbox'])"), 1));
				driver.findElement(By.xpath("(//input[@type='checkbox'])[1]")).click();
				driver.findElement(By.xpath("//a[contains(@href,'whatsapp_contact/delete_phone')]")).click();
				driver.switchTo().alert().accept();
		
				Thread.sleep(5000);
				WebElement element = driver
						.findElement(By.xpath("//a[contains(@href,'whatsapp_contact/popup_import_contact')]"));
				a.moveToElement(element).click().perform();
		
				Thread.sleep(5000);
		
				WebElement form = driver.findElement(By.xpath("//label[@for='type_import_form']"));
				a.moveToElement(form).click().perform();
		
				Thread.sleep(5000);
		
				
		
				driver.findElement(By.xpath("//textarea[@id='phone_numbers']")).sendKeys(phoneNumbers);
				Thread.sleep(3000);
		
				driver.findElement(By.xpath("//button[@type='submit']")).click();
				Thread.sleep(5000);
				driver.findElement(By.xpath("//span[text()='WA Bulk messaging']")).click();
				driver.findElement(By.xpath("(//a[contains(@href,'whatsapp.webjaadu.com/whatsapp_bulk/index/update')])[1]"))
						.click();
				driver.findElement(By.xpath("//button[@class='am-open-list-account']")).click();
				Thread.sleep(3000);
				driver.findElement(By.xpath("//div[@class='flex-grow-1 me-2 text-over-all']")).click();
				// driver.findElement(By.xpath("//div[@class='am-selected-arrow']")).click();
				driver.findElement(By.xpath("//input[@class='form-control form-control-solid']")).sendKeys("student group");
				WebElement element1 = driver.findElement(By.name("group"));
				Select s = new Select(element1);
				s.selectByVisibleText("Group_1");
				Thread.sleep(3000);
				driver.findElement(By.xpath("//span[@class='fs-12']")).click();
				Thread.sleep(3000);
				driver.findElement(By.xpath("//input[@class='form-check-input']")).click();
				driver.findElement(By.xpath("//button[@class='btn btn-primary btnAddFiles']")).click();
				Thread.sleep(5000);
				driver.findElement(By.xpath("//div[@class='emojionearea-editor']")).sendKeys("hi");
		
			     WebElement time1 = driver.findElement(By.name("min_interval_per_post"));
			    
			     Select sec1 = new Select(time1);
			     sec1.selectByVisibleText("1 seconds");
			     Thread.sleep(3000);
			     
			     WebElement time2 = driver.findElement(By.name("max_interval_per_post"));
			     
			     Select sec2 = new Select(time2);
			     sec2.selectByVisibleText("1 seconds");
			     driver.findElement(By.xpath("//button[@type='submit']")).click();
			     Thread.sleep(600000);
			}finally{
				driver.quit();
			}
		}
	}

}

